package com.codenfast.developersuniverse.media.service;

import com.codenfast.developersuniverse.common.converter.EntityToDto;
import com.codenfast.developersuniverse.common.entity.media.Media;
import com.codenfast.developersuniverse.common.entity.music.Genre;
import com.codenfast.developersuniverse.common.entity.music.MediaGenre;
import com.codenfast.developersuniverse.common.service.BaseServiceImpl;
import com.codenfast.developersuniverse.entitydto.music.MediaGenreDto;
import com.codenfast.developersuniverse.media.repository.MediaRepository;
import com.codenfast.developersuniverse.media.utils.MultipartFileSender;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.codenfast.developersuniverse.model.FilterParam;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.model.TableModel;
import com.codenfast.developersuniverse.utils.DateUtil;
import com.codenfast.developersuniverse.utils.StringConstant;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.BitstreamException;
import javazoom.jl.decoder.Header;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

@Service
@Slf4j
@RequiredArgsConstructor
public class MediaServiceImpl extends BaseServiceImpl<Media> implements MediaService {

    private final MediaRepository repository;
    private final MediaGenreService mediaGenreService;
    private final GenreService genreService;

    @Value("${developersuniverse.media.container-folder}")
    private String mediaContainerFolder;

    @Scheduled(timeUnit = TimeUnit.HOURS, fixedRate = 4)
    public void updateMediaLengthInSeconds() {
        try {
            List<String> propertyList = new ArrayList<>();
            propertyList.add("id");
            propertyList.add("fileLocation");
            List<FilterParam> filterList = new ArrayList<>();
            filterList.add(new FilterParam("mimeType", StringConstant.EQUAL, "audio/mpeg"));
            filterList.add(new FilterParam("status.name", StringConstant.EQUAL, "DONE"));
            filterList.add(new FilterParam("lengthInSeconds", "isNull"));
            List<Media> mediaList = repository.grid(Media.class, propertyList, filterList);
            if (CollectionUtils.isEmpty(mediaList)) {
                return;
            }
            Map<String, Object> updateParams = new HashMap<>();
            for(Media media : mediaList) {
                File mediaFile = new File(media.getFileLocation());
                if(!mediaFile.exists()) {
                    continue;
                }
                try(FileInputStream file = new FileInputStream(mediaFile)) {
                    Bitstream bitstream = new Bitstream(file);
                    Header h = bitstream.readFrame();
                    long tn = file.getChannel().size();
                    updateParams.put("lengthInSeconds", ((int) (h.total_ms((int) tn) / 1000)));
                    repository.update(Media.class,
                            updateParams,
                            Collections.singletonList(
                                    new FilterParam("id", StringConstant.EQUAL, media.getId())));
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public Media getMedia(String id) throws CodenfastException {
        Optional<Media> entityOptional = repository.findById(id).filter(e -> !e.getPassive()).stream().findFirst();
        if (entityOptional.isEmpty()) {
            throw CodenfastException.entityNotFound(Media.class, id);
        }
        return repository.detach(entityOptional.get());
    }

    @Async
    @Override
    public CompletableFuture<Void> download(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String id) {
        return CompletableFuture.runAsync(() -> {
            try {
                Optional<Media> entityOptional = repository.findById(id).filter(e -> !e.getPassive()).stream().findFirst();
                if (entityOptional.isEmpty()) {
                    httpServletResponse.sendError(HttpStatus.NOT_FOUND.value());
                    return;
                }
                Media media = entityOptional.get();

                MultipartFileSender.fromFile(new File(media.getFileLocation())).with(httpServletRequest).with(httpServletResponse).serveResource();
            } catch (Exception e) {
                httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
                try {
                    httpServletResponse.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
                } catch (IOException ignored) {
                }
            }
        });
    }

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.HOURS)
    @Override
    public void generateMediafileLists() {
        RequestGrid genreRequestGrid = RequestGrid.getByProperty(StringConstant.PASSIVE, false);
        try {
            List<Genre> genreList = genreService.grid(genreRequestGrid);
            List<String> propertyList = Arrays.asList(
                    "id",
                    "genre.id",
                    "genre.name",
                    "media.id",
                    "media.artist",
                    "media.name",
                    "media.mediaImage.id",
                    "media.mediaImage.downloadedUrl",
                    "media.attributionText",
                    "media.attributionLink",
                    "media.downloadedUrl",
                    "media.mediaDownloadSource.id",
                    "media.mediaDownloadSource.siteName",
                    "media.mediaDownloadSource.title",
                    "media.mediaDownloadSource.url",
                    "media.mediaDownloadSource.image.id",
                    "media.mediaDownloadSource.image.downloadedUrl"
            );
            List<FilterParam> filterParamList = Arrays.asList(
              new FilterParam("passive",StringConstant.EQUAL, Boolean.FALSE),
              new FilterParam("genre.passive",StringConstant.EQUAL, Boolean.FALSE),
              new FilterParam("media.passive",StringConstant.EQUAL, Boolean.FALSE),
              new FilterParam("media.mimeType",StringConstant.EQUAL, "audio/mpeg"),
              new FilterParam("media.status.name",StringConstant.EQUAL, "DONE")
            );
            RequestGrid requestGrid = new RequestGrid();
            requestGrid.setPage(0);
            requestGrid.setPageSize(Integer.MAX_VALUE);
            requestGrid.setPropertyList(propertyList);

            BiFunction<List<FilterParam>, Genre ,List<FilterParam>> addGenreFilter = (list, genre) -> {
                List<FilterParam> filterParamListNew = new ArrayList<>(list);
                filterParamListNew.add(new FilterParam("genre.id",StringConstant.EQUAL, genre.getId()));
                return filterParamListNew;
            };

            ObjectMapper objectMapper = new ObjectMapper();
            File mediaFolder = new File(mediaContainerFolder,"MediaFileList");
            for(Genre genre : genreList) {
                requestGrid.setFilters(addGenreFilter.apply(filterParamList, genre));
                List<MediaGenre> mediaGenreList = mediaGenreService.grid(requestGrid);
                if(mediaGenreList.size() < 10) {
                    continue;
                }
                EntityToDto<MediaGenreDto> entityToDto = new EntityToDto<>();
                List<MediaGenreDto> mediaGenreDtoList = new ArrayList<>();
                for(MediaGenre mediaGenre : mediaGenreList) {
                    mediaGenreDtoList.add(entityToDto.convertToDto(mediaGenre, MediaGenreDto.class, propertyList));
                }
                String mediaGenreJson = Base64.getEncoder().encodeToString(objectMapper.writeValueAsString(mediaGenreDtoList).getBytes(StandardCharsets.UTF_8));
                FileUtils.write(new File(mediaFolder,genre.getName().replaceAll("[\\\\/]","-")+".json"), mediaGenreJson, StandardCharsets.UTF_8);
            }
        } catch (CodenfastException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Media> getMediaFileIndexList() throws IOException {
        File mediaFolder = new File(mediaContainerFolder,"MediaFileList");
        List<Media> mediaFileIndexList = new ArrayList<>();
        Tika tika = new Tika();
        if(mediaFolder.exists() && ArrayUtils.isNotEmpty(mediaFolder.listFiles())) {
            for (File file : Objects.requireNonNull(mediaFolder.listFiles(pathname -> pathname.getName().endsWith(".json")))) {
                Media mediaFileIndex = new Media();
                mediaFileIndex.setName(file.getName());
                mediaFileIndex.setMimeType(tika.detect(file));
                mediaFileIndex.setSize(file.length());
                BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                mediaFileIndex.setUpdateTime(DateUtil.convert(attr.lastModifiedTime().toMillis()));
                mediaFileIndex.setCreateTime(DateUtil.convert(attr.creationTime().toMillis()));
                mediaFileIndexList.add(mediaFileIndex);
            }
        }
        return mediaFileIndexList;
    }

    @Override
    public CompletableFuture<Void> downloadMediaFileList(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String mediaName) {
        return CompletableFuture.runAsync(() -> {
            try {
                File mediaFolder = new File(mediaContainerFolder,"MediaFileList");
                File mediaFileIndex = new File(mediaFolder, mediaName);
                if (!mediaFileIndex.exists() || !mediaFileIndex.isFile()) {
                    httpServletResponse.sendError(HttpStatus.NOT_FOUND.value());
                    return;
                }
                MultipartFileSender.fromFile(mediaFileIndex).with(httpServletRequest).with(httpServletResponse).serveResource();
            } catch (Exception e) {
                httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
                try {
                    httpServletResponse.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
                } catch (IOException ignored) {
                }
            }
        });
    }

    @Override
    public Media save(Media entity) throws CodenfastException {
        Media entityRef = super.save(entity);
        try {
            entityRef = repository.save(entityRef);
            repository.detach(entityRef);
            if (StringUtils.isNotBlank(entity.getFileBase64())) {
                LocalDate today = LocalDate.now();
                File mediaFolder = new File(mediaContainerFolder, "MediaFolder/" + entity.getMimeType() + "/" + today.getYear() + "/" + today.getMonth().getValue());
                FileUtils.writeByteArrayToFile(mediaFolder, Base64.getDecoder().decode(entity.getFileBase64()));
            }
        } catch (IOException e) {
            throw new CodenfastException(e.getMessage(), e);
        }
        return entityRef;
    }

    @Override
    public Media update(Media entity) throws CodenfastException {
        Media entityRef = super.update(repository, entity);
        try {
            entityRef = repository.save(entityRef);
            repository.detach(entityRef);
            File file = new File(entity.getFileLocation());
            if (StringUtils.isNotBlank(entity.getFileBase64())) {
                Files.write(file.toPath(), Base64.getDecoder().decode(entity.getFileBase64()));
            }
        } catch (IOException e) {
            throw new CodenfastException(e.getMessage(), e);
        }
        return entityRef;
    }

    @Override
    public Media delete(String id) throws CodenfastException {
        Optional<Media> entityOptional = repository.findById(id).filter(e -> !e.getPassive()).stream().findFirst();
        if (entityOptional.isEmpty()) {
            throw new CodenfastException(StringConstant.DATA_NOT_FOUND);
        }
        Media entity = entityOptional.get();
        entity.setPassive(Boolean.TRUE);
        entity = repository.detach(repository.save(entity));
        try {
            Files.deleteIfExists(new File(entity.getFileLocation()).toPath());
        } catch (Exception e) {
            throw new CodenfastException(e.getMessage(), e);
        }
        return entity;
    }

    @Override
    public List<Media> save(List<Media> entityList) throws CodenfastException {
        List<Media> entityRef = super.save(entityList);
        for (Media media : entityRef) {
            save(media);
        }
        return entityRef;
    }

    @Override
    public List<Media> update(List<Media> entityList) throws CodenfastException {
        List<Media> entityRef = super.update(repository, entityList);
        for (Media media : entityRef) {
            update(media);
        }
        return entityRef;
    }

    @Override
    public List<Media> delete(List<Media> entityList) throws CodenfastException {
        try {
            List<String> idList = entityList.stream().map(Media::getId).toList();
            for (String id : idList) {
                delete(id);
            }
            return entityList;
        } catch (Exception e) {
            throw new CodenfastException(e.getMessage(), e);
        }
    }

    @Override
    public List<Media> grid(RequestGrid requestGrid) throws CodenfastException {
        return super.grid(Media.class, repository, requestGrid);
    }

    @Override
    public TableModel<Media> gridTableModel(RequestGrid requestGrid) throws CodenfastException {
        return super.gridTableModel(Media.class, repository, requestGrid);
    }
}
