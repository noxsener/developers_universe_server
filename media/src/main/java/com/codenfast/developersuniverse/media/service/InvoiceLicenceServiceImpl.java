package com.codenfast.developersuniverse.media.service;

import com.codenfast.developersuniverse.common.entity.download.DownloadStatus;
import com.codenfast.developersuniverse.common.entity.media.InvoiceLicence;
import com.codenfast.developersuniverse.common.service.BaseServiceImpl;
import com.codenfast.developersuniverse.media.repository.DownloadStatusRepository;
import com.codenfast.developersuniverse.media.repository.InvoiceLicenceRepository;
import com.codenfast.developersuniverse.media.utils.MultipartFileSender;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.codenfast.developersuniverse.model.FilterParam;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.model.TableModel;
import com.codenfast.developersuniverse.utils.StringConstant;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class InvoiceLicenceServiceImpl extends BaseServiceImpl<InvoiceLicence> implements InvoiceLicenceService {

    private final InvoiceLicenceRepository repository;

    @Value("${developersuniverse.media.container-folder}")
    private String mediaContainerFolder;
    private final DownloadStatusRepository downloadStatusRepository;

    private DownloadStatus doneDownloadStatus;

    @Override
    public InvoiceLicence getInvoiceLicence(String id) throws CodenfastException {
        Optional<InvoiceLicence> entityOptional = repository.findById(id).filter(e -> !e.getPassive()).stream().findFirst();
        if (entityOptional.isEmpty()) {
            throw CodenfastException.entityNotFound(InvoiceLicence.class, id);
        }
        return repository.detach(entityOptional.get());
    }

    @Async
    @Override
    public CompletableFuture<Void> download(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String id) {
        return CompletableFuture.runAsync(() -> {
            try {
                Optional<InvoiceLicence> entityOptional = repository.findById(id).filter(e -> !e.getPassive()).stream().findFirst();
                if (entityOptional.isEmpty()) {
                    httpServletResponse.sendError(HttpStatus.NOT_FOUND.value());
                    return;
                }
                InvoiceLicence media = entityOptional.get();

                MultipartFileSender.fromFile(new File(media.getFileLocation())).with(httpServletRequest).with(httpServletResponse).serveResource();
            } catch (Exception e) {
                try {
                    httpServletResponse.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
                } catch (IOException ioException) {
                    httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
                }
            }
        });
    }

    @Override
    public InvoiceLicence save(InvoiceLicence entity) throws CodenfastException {
        InvoiceLicence entityRef = super.save(entity);
        try {
            entityRef = repository.save(entityRef);
            repository.detach(entityRef);
            if(StringUtils.isNotBlank(entity.getFileBase64())) {
                LocalDate today = LocalDate.now();
                File mediaFolder = new File(mediaContainerFolder,"InvoiceLicenceFolder/"+entity.getMimeType()+"/"+today.getYear()+"/"+today.getMonth().getValue()+"/"+entity.getFileName());
                FileUtils.writeByteArrayToFile(mediaFolder, Base64.getDecoder().decode(entity.getFileBase64()));
            }
        } catch (IOException e) {
            throw new CodenfastException(e.getMessage(), e);
        }
        return entityRef;
    }

    @Override
    public InvoiceLicence update(InvoiceLicence entity) throws CodenfastException {
        LocalDate today = LocalDate.now();

        File exFile = null;
        if(StringUtils.isNotBlank(entity.getFileLocation())) {
            exFile = new File(entity.getFileLocation());
        } else {
            exFile = new File(mediaContainerFolder,"InvoiceLicenceFolder/"+entity.getMimeType()+"/"+today.getYear()+"/"+today.getMonth().getValue()+"/"+ entity.getFileName());
        }
        try {

            FileUtils.writeByteArrayToFile(exFile, Base64.getDecoder().decode(entity.getFileBase64()));
            if(!exFile.getAbsolutePath().equals(exFile.getAbsolutePath())) {
                FileUtils.deleteQuietly(exFile);
            }
            entity.setFileLocation(exFile.getAbsolutePath());
            entity.setFileName(entity.getFileName());

            if (ObjectUtils.isEmpty(doneDownloadStatus)) {
                doneDownloadStatus = getDownloadStatus(StringConstant.DONE);
            }

            InvoiceLicence entityRef = super.update(repository, entity);
            entityRef = repository.save(entityRef);
            return repository.detach(entityRef);
        } catch (IOException e) {
            throw new CodenfastException(e.getMessage(), e);
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | NoSuchFieldException e) {
            log.error(e.getMessage(), e);
            throw new CodenfastException(e.getMessage(), e);
        }
    }

    @Override
    public InvoiceLicence delete(String id) throws CodenfastException {
        Optional<InvoiceLicence> entityOptional = repository.findById(id).filter(e -> !e.getPassive()).stream().findFirst();
        if (entityOptional.isEmpty()) {
            throw new CodenfastException(StringConstant.DATA_NOT_FOUND);
        }
        InvoiceLicence entity = entityOptional.get();
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
    public List<InvoiceLicence> save(List<InvoiceLicence> entityList) throws CodenfastException {
        List<InvoiceLicence> entityRef = super.save(entityList);
        for(InvoiceLicence media : entityRef) {
            save(media);
        }
        return entityRef;
    }

    @Override
    public List<InvoiceLicence> update(List<InvoiceLicence> entityList) throws CodenfastException {
        List<InvoiceLicence> entityRef = super.update(repository, entityList);
        for(InvoiceLicence media : entityRef) {
            update(media);
        }
        return entityRef;
    }

    @Override
    public List<InvoiceLicence> delete(List<InvoiceLicence> entityList) throws CodenfastException {
        try {
            List<String> idList = entityList.stream().map(InvoiceLicence::getId).collect(Collectors.toList());
            for (String id : idList) {
                delete(id);
            }
            return entityList;
        } catch (Exception e) {
            throw new CodenfastException(e.getMessage(), e);
        }
    }

    @Override
    public List<InvoiceLicence> grid(RequestGrid requestGrid) throws CodenfastException {
        return super.grid(InvoiceLicence.class, repository, requestGrid);
    }

    @Override
    public TableModel<InvoiceLicence> gridTableModel(RequestGrid requestGrid) throws CodenfastException {
        return super.gridTableModel(InvoiceLicence.class, repository, requestGrid);
    }

    private DownloadStatus getDownloadStatus(String name) throws CodenfastException, NoSuchMethodException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        RequestGrid requestGrid = RequestGrid.getByProperty(StringConstant.NAME, name);
        List<FilterParam> requestFilterList = new java.util.ArrayList<>();
        requestFilterList.add(new FilterParam(StringConstant.NAME, StringConstant.EQUAL, name));
        requestFilterList.add(new FilterParam(StringConstant.PASSIVE, StringConstant.EQUAL, Boolean.FALSE));
        List<DownloadStatus> downloadStatusList = downloadStatusRepository.grid(DownloadStatus.class, Arrays.asList(StringConstant.ID, StringConstant.NAME), requestFilterList);
        if (CollectionUtils.isEmpty(downloadStatusList)) {
            DownloadStatus downloadStatus = new DownloadStatus();
            downloadStatus.setName(name);
            downloadStatus.setPassive(Boolean.FALSE);
            return downloadStatusRepository.save(downloadStatus);
        }
        return (CollectionUtils.isNotEmpty(downloadStatusList)) ?
                downloadStatusList.get(0) : null;
    }
}
