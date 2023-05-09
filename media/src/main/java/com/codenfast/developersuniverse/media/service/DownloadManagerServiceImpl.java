package com.codenfast.developersuniverse.media.service;

import com.codenfast.developersuniverse.common.converter.EntityToDto;
import com.codenfast.developersuniverse.common.entity.download.DownloadPart;
import com.codenfast.developersuniverse.common.entity.download.DownloadStatus;
import com.codenfast.developersuniverse.common.entity.media.Media;
import com.codenfast.developersuniverse.common.mq.service.DiscordServiceMQ;
import com.codenfast.developersuniverse.entitydto.media.MediaDto;
import com.codenfast.developersuniverse.media.repository.DownloadPartRepository;
import com.codenfast.developersuniverse.media.repository.DownloadStatusRepository;
import com.codenfast.developersuniverse.media.repository.MediaRepository;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.codenfast.developersuniverse.model.FilterParam;
import com.codenfast.developersuniverse.utils.StringConstant;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.*;

@Service
@Slf4j
public class DownloadManagerServiceImpl implements DownloadManagerService {

    private final static Integer WORKER_COUNT_VERYLOW = 1;
    private final static Integer WORKER_COUNT_LOW = 2;
    private final static Integer WORKER_COUNT_MID = 4;
    private final static Integer WORKER_COUNT_HIGH = 8;

    private final DiscordServiceMQ discordServiceMQ;
    private final ObjectMapper objectMapper;

    private final DownloadIntentService downloadIntentService;
    private final MediaRepository mediaRepository;
    private final DownloadPartRepository downloadPartRepository;
    private final DownloadStatusRepository downloadStatusRepository;
    private final HttpClient httpClient;

    private final DownloadStatus onlineDownloadStatus;
    private final DownloadStatus waitingDownloadStatus;
    private final DownloadStatus failedDownloadStatus;
    private final DownloadStatus resumeDownloadStatus;
    private final DownloadStatus doneDownloadStatus;

    public DownloadManagerServiceImpl(
            DiscordServiceMQ discordServiceMQ,
            ObjectMapper objectMapper,
            MediaRepository mediaRepository,
            DownloadPartRepository downloadPartRepository,
            DownloadStatusRepository downloadStatusRepository,
            DownloadIntentService downloadIntentService
    ) throws CodenfastException {
        this.discordServiceMQ = discordServiceMQ;
        this.objectMapper = objectMapper;
        this.mediaRepository = mediaRepository;
        this.downloadPartRepository = downloadPartRepository;
        this.downloadStatusRepository = downloadStatusRepository;
        this.downloadIntentService = downloadIntentService;
        this.httpClient = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(30))
                .build();

        try {
            onlineDownloadStatus = getDownloadStatus(StringConstant.ONLINE);
            waitingDownloadStatus = getDownloadStatus(StringConstant.WAITING);
            failedDownloadStatus = getDownloadStatus(StringConstant.FAILED);
            resumeDownloadStatus = getDownloadStatus(StringConstant.RESUME);
            doneDownloadStatus = getDownloadStatus(StringConstant.DONE);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new CodenfastException(e.getMessage(), e);
        }
    }

    private DownloadStatus getDownloadStatus(String name) throws NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, CodenfastException {
        List<FilterParam> statusFilterParamList = new java.util.ArrayList<>();
        statusFilterParamList.add(new FilterParam(StringConstant.NAME, StringConstant.EQUAL, name));
        statusFilterParamList.add(new FilterParam(StringConstant.PASSIVE, StringConstant.EQUAL, Boolean.FALSE));
        List<DownloadStatus> downloadStatusList = downloadStatusRepository.grid(DownloadStatus.class, Collections.singletonList(StringConstant.ID), statusFilterParamList);
        if (CollectionUtils.isEmpty(downloadStatusList)) {
            DownloadStatus newDownloadStatus = new DownloadStatus();
            newDownloadStatus.setName(name);
            newDownloadStatus.setPassive(Boolean.FALSE);
            return downloadStatusRepository.save(newDownloadStatus);
        }
        return downloadStatusList.get(0);
    }

    @Override
    public Media getMedia(String id) {
        return mediaRepository.findById(id).filter(entity -> !entity.getPassive()).orElse(null);
    }

    @Override
    public Media addDownloadQueue(Media media) throws CodenfastException {
        try {
            media = generateMediaFromUrl(media);
            return mediaRepository.detach(mediaRepository.save(media));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new CodenfastException(e.getMessage(), e);
        }
    }

    @Override
    public Media generateMediaFromUrl(Media media) throws IOException, InterruptedException, NoSuchFieldException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, CodenfastException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(media.getDownloadedUrl()))
                .setHeader(StringConstant.USER_AGENT_HEADER, StringConstant.USER_AGENT)
                .method(StringConstant.HTTP_METHOD_HEAD, HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<Void> response = null;

        response = httpClient.send(request, HttpResponse.BodyHandlers.discarding());

        List<FilterParam> statusFilterParamList = new java.util.ArrayList<>();
        statusFilterParamList.add(new FilterParam(StringConstant.NAME, StringConstant.EQUAL, StringConstant.WAITING));
        List<DownloadStatus> downloadStatusList = downloadStatusRepository.grid(DownloadStatus.class, Collections.singletonList(StringConstant.ID), statusFilterParamList);
        if (CollectionUtils.isEmpty(downloadStatusList)) {
            CodenfastException e = new CodenfastException(String.format("System doesn't have %s download status", StringConstant.WAITING));
            log.error(e.getMessage(), e);
            throw e;
        }
        media.setStatus(downloadStatusList.get(0));
        media.setPartialDownloadSupport(Boolean.FALSE);

        HttpHeaders headers = response.headers();
        for (Map.Entry<String, List<String>> entry : headers.map().entrySet()) {
            if ("Accept-Ranges".equalsIgnoreCase(entry.getKey())) {
                media.setPartialDownloadSupport(CollectionUtils.isNotEmpty(entry.getValue()) && "bytes".equals(entry.getValue().get(0)));
            } else if (StringConstant.CONTENT_TYPE.equalsIgnoreCase(entry.getKey()) && CollectionUtils.isNotEmpty(entry.getValue())) {
                media.setMimeType(entry.getValue().get(0));
            } else if (StringConstant.CONTENT_LENGHT.equalsIgnoreCase(entry.getKey()) && CollectionUtils.isNotEmpty(entry.getValue())) {
                String value = entry.getValue().get(0).trim();
                if (!value.matches(StringConstant.REGEX_NUMBER)) {
                    throw new CodenfastException(String.format("%s HEAD Request is returned invalid Content-Length: %s", media.getDownloadedUrl(), value));
                }
                media.setSize(Long.parseLong(entry.getValue().get(0)));
            } else if (StringConstant.CONTENT_DISPOSITION.equalsIgnoreCase(entry.getKey()) && CollectionUtils.isNotEmpty(entry.getValue())) {
                String fileName = entry.getValue().get(0).replaceFirst("(?i)^.*filename=\"?([^\"]+)\"?.*$", "$1");
                media.setFileName(fileName);
            }
        }
        if (StringUtils.isBlank(media.getFileName())) {
            String potantialFileName = media.getDownloadedUrl().substring(media.getDownloadedUrl().lastIndexOf('/') + 1);
            if (potantialFileName.matches("[a-zA-ZğüşıöçĞÜŞİÖÇ0-9\\-_.* \\(\\)]*[.][A-Za-z0-9]{3,}")) {
                media.setFileName(potantialFileName);
                if (StringUtils.isBlank(media.getName())) {
                    media.setName(potantialFileName);
                }
            }
        }
        return media;
    }

    @Override
    public void cancelMedia(String id) {

    }

    @Override
    public void retryMedia(String id) throws CodenfastException {
        Optional<Media> mediaOptional = mediaRepository.findById(id).filter(entity -> !entity.getPassive());
        if (mediaOptional.isEmpty()) {
            throw CodenfastException.entityNotFound(Media.class, id);
        }
        try {
            Media media = mediaOptional.get();
            List<FilterParam> statusFilterParamList = new java.util.ArrayList<>();
            statusFilterParamList.add(new FilterParam(StringConstant.NAME, StringConstant.EQUAL, StringConstant.WAITING));
            List<DownloadStatus> downloadStatusList = downloadStatusRepository.grid(DownloadStatus.class, Collections.singletonList(StringConstant.ID), statusFilterParamList);
            if (CollectionUtils.isEmpty(downloadStatusList)) {
                CodenfastException e = new CodenfastException(String.format("System doesn't have %s download status", StringConstant.WAITING));
                log.error(e.getMessage(), e);
                throw e;
            }
            media.setStatus(downloadStatusList.get(0));
            mediaRepository.detach(mediaRepository.save(media));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new CodenfastException(e.getMessage(), e);
        }
    }

    @Override
    public List<Media> waitingMediaList() throws CodenfastException {
        List<FilterParam> statusFilterParamList = new java.util.ArrayList<>();
        statusFilterParamList.add(new FilterParam(StringConstant.NAME, StringConstant.EQUAL, StringConstant.WAITING));
        statusFilterParamList.add(new FilterParam(StringConstant.PASSIVE, StringConstant.EQUAL, Boolean.FALSE));
        List<Media> mediaList = null;
        try {
            mediaList = mediaRepository.grid(Media.class, Collections.singletonList(StringConstant.ID), statusFilterParamList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new CodenfastException(e.getMessage(), e);
        }
        return mediaList;
    }

    @Scheduled(fixedDelay = 2, timeUnit = TimeUnit.MINUTES)
    private void media() {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try {
        List<FilterParam> processFilterParamList = new java.util.ArrayList<>();
        Map<String, Object> waitingDownloadStatusFilterMap = new HashMap<>();
        waitingDownloadStatusFilterMap.put(StringConstant.ID, waitingDownloadStatus.getId());
        processFilterParamList.add(new FilterParam(StringConstant.STATUS, StringConstant.EQUAL, waitingDownloadStatusFilterMap));
        processFilterParamList.add(new FilterParam(StringConstant.PASSIVE, StringConstant.EQUAL, Boolean.FALSE));
        List<Media> mediaList = mediaRepository.grid(Media.class, null, 0, 200, StringConstant.CREATE_TIME, 1, processFilterParamList);

        if (CollectionUtils.isEmpty(mediaList)) {
            return;
        }

        CompletableFuture<?>[] mediaDownloadFuture = new CompletableFuture[mediaList.size()];
        for (int i = 0; i < mediaList.size(); i++) {
            final Media mediaFinal = mediaList.get(i);
            mediaDownloadFuture[i] = CompletableFuture.runAsync(() -> {
                try {
                    downloadingProcess(mediaFinal);
                    mediaFinal.setStatus(doneDownloadStatus);
                    mediaRepository.detach(mediaRepository.save(mediaFinal));
                } catch (Exception e) {
                    mediaFinal.setStatus(failedDownloadStatus);
                    mediaFinal.setPassive(Boolean.TRUE);
                    mediaFinal.setDescription(e.getMessage());
                    mediaRepository.save(mediaFinal);
                    log.error(e.getMessage(), e);
                }
            }, executorService);
        }
        CompletableFuture.allOf(mediaDownloadFuture).join();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            executorService.shutdownNow();
        }

    }


    @Override
    public MediaDto downloadingProcess(Media media) throws NoSuchFieldException, IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, CodenfastException {
        File downloadingFolder = new File("DownloadFolder");
        if (!downloadingFolder.exists()) {
            downloadingFolder.mkdirs();
        }

        if (StringUtils.isBlank(media.getId())) {
            media.setId(UUID.randomUUID().toString());

            if(media.getSize() == null) {
                media.setSize(0l);
                media.setDescription("File size is null!");
            }

            media = mediaRepository.save(media);
        }

        List<FilterParam> partFilterParamList = new java.util.ArrayList<>();
        Map<String, Object> mediaFilterMap = new HashMap<>();
        mediaFilterMap.put(StringConstant.ID, media.getId());
        partFilterParamList.add(new FilterParam("media", StringConstant.EQUAL, mediaFilterMap));
        partFilterParamList.add(new FilterParam(StringConstant.PASSIVE, StringConstant.EQUAL, Boolean.FALSE));
        List<DownloadPart> downloadPartList = downloadPartRepository.grid(DownloadPart.class, null, StringConstant.CREATE_TIME, 1, partFilterParamList);

        if (CollectionUtils.isEmpty(downloadPartList)) {
            downloadPartList = generateDownloadParts(waitingDownloadStatus, media);
        }
        media.setStatus(resumeDownloadStatus);
        mediaRepository.save(media);

        CompletableFuture<?>[] partProcessArray = new CompletableFuture[downloadPartList.size()];
        for (int i = 0; i < downloadPartList.size(); i++) {
            final Media finalMedia = media;
            final DownloadPart downloadPart = downloadPartList.get(i);
            partProcessArray[i] = CompletableFuture.runAsync(() -> {
                try {
                    long byteStart = downloadPart.getByteRangeStart();
                    File downloadPartFile = new File(downloadingFolder, downloadPart.getPartFileName());
                    if (downloadPartFile.exists()) {
                        byteStart = byteStart + downloadPartFile.length();
                    }

                    if (byteStart >= downloadPart.getByteRangeEnd()) {
                        return;
                    }
                    HttpRequest request = HttpRequest.newBuilder()
                            .GET()
                            .uri(URI.create(finalMedia.getDownloadedUrl()))
                            .setHeader(StringConstant.RANGE, "bytes=" + byteStart + "-" + downloadPart.getByteRangeEnd())
                            .setHeader(StringConstant.USER_AGENT_HEADER, StringConstant.USER_AGENT)
                            .build();

                    HttpResponse<InputStream> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofInputStream());

                    if (httpResponse.statusCode() != HttpStatus.OK.value() && httpResponse.statusCode() != HttpStatus.PARTIAL_CONTENT.value()) {
                        finalMedia.setStatus(failedDownloadStatus);
                        finalMedia.setDescription(String.format("Http Result: %s", httpResponse.statusCode()));
                        finalMedia.setPassive(Boolean.TRUE);
                        mediaRepository.save(finalMedia);
                        downloadPart.setStatus(failedDownloadStatus);
                        downloadPart.setPassive(Boolean.TRUE);
                        downloadPartRepository.detach(downloadPartRepository.save(downloadPart));
                        return;
                    }

                    List<String> fileNameHeaderValue = httpResponse.headers().map().get(StringConstant.CONTENT_DISPOSITION);
                    if (StringUtils.isBlank(finalMedia.getFileName()) && CollectionUtils.isNotEmpty(fileNameHeaderValue)) {
                        String fileName = fileNameHeaderValue.get(0).replaceFirst("(?i)^.*filename=\"?([^\"]+)\"?.*$", "$1");
                        finalMedia.setFileName(fileName);
                    } else if (StringUtils.isBlank(finalMedia.getFileName())) {
                        MimeTypes allTypes = MimeTypes.getDefaultMimeTypes();
                        MimeType mimeType = allTypes.forName(finalMedia.getMimeType());
                        finalMedia.setFileName(finalMedia.getId() + mimeType.getExtension());
                    }

                    if (resumeDownloadStatus.equals(finalMedia.getStatus())) {
                        finalMedia.setStatus(resumeDownloadStatus);
                        mediaRepository.save(finalMedia);
                    }
                    downloadPart.setStatus(resumeDownloadStatus);
                    downloadPartRepository.save(downloadPart);


                    try (BufferedInputStream in = new BufferedInputStream(httpResponse.body());
                         FileOutputStream fileOutputStream = new FileOutputStream(downloadPartFile)) {
                        byte[] dataBuffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                            fileOutputStream.write(dataBuffer, 0, bytesRead);
                        }
                        downloadPart.setStatus(doneDownloadStatus);
                        downloadPartRepository.save(downloadPart);
                    }
                } catch (IOException | MimeTypeException | InterruptedException e) {
                    finalMedia.setStatus(failedDownloadStatus);
                    finalMedia.setPassive(Boolean.TRUE);
                    finalMedia.setDescription(e.getMessage());
                    mediaRepository.save(finalMedia);
                    downloadPart.setPassive(Boolean.TRUE);
                    downloadPart.setStatus(failedDownloadStatus);
                    downloadPartRepository.save(downloadPart);
                    throw new CompletionException(e.getMessage(), e);
                }
            });
        }
        CompletableFuture.allOf(partProcessArray).join();
        combineDownloadParts(media, downloadPartList);
        MediaDto mediaDto = downloadIntentService.processIntent(media);
        media.setStatus(doneDownloadStatus);
        mediaRepository.save(media);

        EntityToDto<MediaDto> converter = new EntityToDto<>();
        List<String> propertyList = Arrays.asList(
                "artist",
                "mediaImage",
                "name",
                "downloadedUrl",
                "description",
                "mimeType",
                "zipMimeType",
                "mediaDownloadSource",
                "height",
                "width",
                "fileLocation",
                "fileName",
                "attributionText",
                "status",
                "partialDownloadSupport",
                "downloadIntent");
        mediaDto = converter.convertToDto(media, MediaDto.class, propertyList);
        discordServiceMQ.mediaDownload(mediaDto);
        return mediaDto;
    }

    private List<DownloadPart> generateDownloadParts(DownloadStatus waitingDownloadStatus, Media media) {
        List<DownloadPart> downloadPartList = new java.util.ArrayList<>();
        if (media.getPartialDownloadSupport()
                && StringUtils.isNotBlank(media.getMimeType())
                && !media.getMimeType().matches("image[/].*")) {
            Long fileSize = media.getSize();
            int idealWorkerCount = getIdealWorkerCount(fileSize);
            long byteSizePerPart = fileSize / idealWorkerCount;
            long previousByteEnd = 0L;
            for (int i = 0; i < idealWorkerCount; i++) {
                DownloadPart downloadPart = new DownloadPart();
                downloadPart.setMedia(media);
                downloadPart.setStatus(waitingDownloadStatus);
                downloadPart.setPartNumber(i);
                downloadPart.setByteRangeStart(previousByteEnd);
                long endByteRange = previousByteEnd + byteSizePerPart;
                if ((i + 1) >= idealWorkerCount) {
                    endByteRange = fileSize;
                }
                downloadPart.setByteRangeEnd(endByteRange);
                previousByteEnd = endByteRange + 1;
                downloadPart.setPartFileName(media.getFileName() + "_" + i + ".tmp");
                downloadPartList.add(downloadPart);
            }
        } else {
            DownloadPart downloadPart = new DownloadPart();
            downloadPart.setMedia(media);
            downloadPart.setStatus(waitingDownloadStatus);
            downloadPart.setPartNumber(0);
            downloadPart.setByteRangeStart(0L);
            downloadPart.setByteRangeEnd(media.getSize());
            downloadPart.setPartFileName(media.getFileName() + "_0.tmp");
            downloadPartList.add(downloadPart);
        }
        return downloadPartRepository.saveAll(downloadPartList);
    }

    private Integer getIdealWorkerCount(Long fileSize) {
        if (fileSize > 1073741824) { // Over 1GB
            return WORKER_COUNT_HIGH;
        } else if (fileSize > 104857600) { // Over 100MB
            return WORKER_COUNT_MID;
        } else if (fileSize > 10485760) { // Over 10MB
            return WORKER_COUNT_LOW;
        } else {
            return WORKER_COUNT_VERYLOW;
        }
    }

    private File combineDownloadParts(Media media, List<DownloadPart> downloadPartList) throws CodenfastException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        File downloadingFolder = new File("DownloadFolder");
        downloadPartList.sort(Comparator.comparing(DownloadPart::getPartNumber));
        for (DownloadPart downloadPart : downloadPartList) {
            File downloadPartFile = new File(downloadingFolder, downloadPart.getPartFileName());
            if (!downloadPartFile.exists()) {
                CodenfastException e = new CodenfastException(String.format("DownloadPartFile is not found: %s", downloadPartFile.getAbsolutePath()));
                log.error(e.getMessage(), e);
                throw e;
            }

            try {
                byteArrayOutputStream.write(FileUtils.readFileToByteArray(downloadPartFile));
            } catch (IOException e) {
                log.error(e.getMessage(), e);
                throw new CodenfastException(e.getMessage(), e);
            }
        }

        File downloadedFile = new File(downloadingFolder, media.getFileName());
        try {
            FileUtils.writeByteArrayToFile(downloadedFile, byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new CodenfastException(e.getMessage(), e);
        }
        CompletableFuture.runAsync(() -> {
            for (DownloadPart downloadPart : downloadPartList) {
                FileUtils.deleteQuietly(new File(downloadingFolder, downloadPart.getPartFileName()));
            }
        });
        return downloadedFile;
    }
}
