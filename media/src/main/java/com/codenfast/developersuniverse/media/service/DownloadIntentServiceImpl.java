package com.codenfast.developersuniverse.media.service;

import com.codenfast.developersuniverse.common.converter.EntityToDto;
import com.codenfast.developersuniverse.common.entity.download.DownloadIntent;
import com.codenfast.developersuniverse.common.entity.media.Media;
import com.codenfast.developersuniverse.common.service.BaseServiceImpl;
import com.codenfast.developersuniverse.entitydto.media.MediaDto;
import com.codenfast.developersuniverse.media.repository.DownloadIntentRepository;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.codenfast.developersuniverse.model.FilterParam;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.model.TableModel;
import com.codenfast.developersuniverse.utils.StringConstant;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.tika.mime.MimeTypeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static com.codenfast.developersuniverse.utils.StringConstant.JUST_MEDIA_DOWNLOAD;
import static com.codenfast.developersuniverse.utils.StringConstant.NON_COPYRIGHT_MUSIC_DOWNLOAD;

@Service
@Data
@RequiredArgsConstructor
public class DownloadIntentServiceImpl extends BaseServiceImpl<DownloadIntent> implements DownloadIntentService {

    @Value("${developersuniverse.media.container-folder}")
    private String mediaContainerFolder;

    private final DownloadIntentRepository repository;
    private final MediaService mediaService;

    @Override
    public MediaDto processIntent(Media media) throws CodenfastException, IOException {
        try {
        if(media.getDownloadIntent().getName().equals(NON_COPYRIGHT_MUSIC_DOWNLOAD)) {
            return musicDownload(media);
        } else if(media.getDownloadIntent().getName().equals(JUST_MEDIA_DOWNLOAD)){
            return justMediaDownload(media);
        }
        } catch (MimeTypeException e) {
            e.printStackTrace();
        }
        throw new CodenfastException(String.format("This Operation is not defined: %s", media.getDownloadIntent().getName()));
    }

    private MediaDto musicDownload(Media media) throws MimeTypeException, IOException, CodenfastException {
        File downloadedFile = new File("DownloadFolder", media.getFileName());

        File mediaFolder = new File(mediaContainerFolder+"/MediaFolder/Music/"+media.getArtist());
        if (!mediaFolder.exists()) {
            mediaFolder.mkdirs();
        }
        File newPosition = new File(mediaFolder,media.getFileName());
        Files.deleteIfExists(newPosition.toPath());
        Files.move(downloadedFile.toPath(), newPosition.toPath());
        media.setFileLocation(newPosition.getAbsolutePath());
        EntityToDto<MediaDto> entityToDto = new EntityToDto<>();
        media = mediaService.update(media);
        return entityToDto.convertToDto(media, MediaDto.class);
    }

    private MediaDto justMediaDownload(Media media) throws IOException, CodenfastException {
        File downloadedFile = new File("DownloadFolder", media.getFileName());
        LocalDate today = LocalDate.now();
        File mediaFolder = new File(mediaContainerFolder+"/MediaFolder/"+media.getMimeType()+"/"+today.getYear()+"/"+today.getMonth().getValue());
        if (!mediaFolder.exists()) {
            mediaFolder.mkdirs();
        }
        File newPosition = new File(mediaFolder,media.getFileName());
        Files.deleteIfExists(newPosition.toPath());
        Files.move(downloadedFile.toPath(), newPosition.toPath());
        media.setFileLocation(newPosition.getAbsolutePath());
        media = mediaService.update(media);
        List<String> propertyList = Arrays.asList("id","artist","name","downloadedUrl","description","mimeType","zipMimeType",
                "size","fileName","status","partialDownloadSupport",
                "mediaImage","downloadIntent");
        return new EntityToDto<MediaDto>().convertToDto(media, MediaDto.class, propertyList);
    }

    @Override
    public DownloadIntent save(DownloadIntent entity) throws CodenfastException {
        DownloadIntent entityRef = super.save(entity);
        entityRef = repository.save(entityRef);
        repository.detach(entityRef);
        return entityRef;
    }

    @Override
    public DownloadIntent update(DownloadIntent entity) throws CodenfastException {
        DownloadIntent entityRef = super.update(repository, entity);
        entityRef = repository.save(entityRef);
        repository.detach(entityRef);
        return entityRef;
    }

    @Override
    public DownloadIntent delete(String id) throws CodenfastException {
        Optional<DownloadIntent> entityOptional = repository.findById(id).filter(e -> !e.getPassive()).stream().findFirst();
        if(entityOptional.isEmpty()) {
            throw new CodenfastException(StringConstant.DATA_NOT_FOUND);
        }
        DownloadIntent entity = entityOptional.get();
        entity.setPassive(Boolean.TRUE);
        return repository.detach(repository.save(entity));
    }

    @Override
    public List<DownloadIntent> save(List<DownloadIntent> entityList) throws CodenfastException {
        List<DownloadIntent> entityRef = super.save(entityList);
        return repository.saveAll(entityRef);
    }

    @Override
    public List<DownloadIntent> update(List<DownloadIntent> entityList) throws CodenfastException {
        List<DownloadIntent> entityRef = super.update(repository, entityList);
        return repository.saveAll(entityRef);
    }

    @Transactional
    @Override
    public List<DownloadIntent> delete(List<DownloadIntent> entityList) throws CodenfastException {
        try {
            List<String> idList = entityList.stream().map(DownloadIntent::getId).collect(Collectors.toList());
            Map<String, Object> updateParams = new HashMap<>();
            updateParams.put(StringConstant.PASSIVE, Boolean.TRUE);
            List<FilterParam> filterParamList = new java.util.ArrayList<>();
            filterParamList.add(new FilterParam(StringConstant.ID, StringConstant.IN, idList));
            repository.update(DownloadIntent.class, updateParams, filterParamList);
            return entityList;
        } catch (Exception e) {
            throw new CodenfastException(e.getMessage(), e);
        }
    }

    @Override
    public List<DownloadIntent> grid(RequestGrid requestGrid) throws CodenfastException {
        return super.grid(DownloadIntent.class, repository, requestGrid);
    }

    @Override
    public TableModel<DownloadIntent> gridTableModel(RequestGrid requestGrid) throws CodenfastException {
        return super.gridTableModel(DownloadIntent.class, repository, requestGrid);
    }
}
