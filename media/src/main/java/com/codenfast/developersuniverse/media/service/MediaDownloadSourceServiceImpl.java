package com.codenfast.developersuniverse.media.service;

import com.codenfast.developersuniverse.common.entity.media.MediaDownloadSource;
import com.codenfast.developersuniverse.common.service.BaseServiceImpl;
import com.codenfast.developersuniverse.media.repository.MediaDownloadSourceRepository;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.codenfast.developersuniverse.model.FilterParam;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.model.TableModel;
import com.codenfast.developersuniverse.utils.StringConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MediaDownloadSourceServiceImpl extends BaseServiceImpl<MediaDownloadSource> implements MediaDownloadSourceService {

    private final MediaDownloadSourceRepository repository;

    @Override
    public MediaDownloadSource save(MediaDownloadSource entity) throws CodenfastException {
        MediaDownloadSource entityRef = super.save(entity);
        entityRef = repository.save(entityRef);
        repository.detach(entityRef);
        return entityRef;
    }

    @Override
    public MediaDownloadSource update(MediaDownloadSource entity) throws CodenfastException {
        MediaDownloadSource entityRef = super.update(repository, entity);
        entityRef = repository.save(entityRef);
        repository.detach(entityRef);
        return entityRef;
    }

    @Override
    public MediaDownloadSource delete(String id) throws CodenfastException {
        Optional<MediaDownloadSource> entityOptional = repository.findById(id).filter(e -> !e.getPassive()).stream().findFirst();
        if(entityOptional.isEmpty()) {
            throw new CodenfastException(StringConstant.DATA_NOT_FOUND);
        }
        MediaDownloadSource entity = entityOptional.get();
        entity.setPassive(Boolean.TRUE);
        return repository.detach(repository.save(entity));
    }

    @Override
    public List<MediaDownloadSource> save(List<MediaDownloadSource> entityList) throws CodenfastException {
        List<MediaDownloadSource> entityRef = super.save(entityList);
        return repository.saveAll(entityRef);
    }

    @Override
    public List<MediaDownloadSource> update(List<MediaDownloadSource> entityList) throws CodenfastException {
        List<MediaDownloadSource> entityRef = super.update(repository, entityList);
        return repository.saveAll(entityRef);
    }

    @Transactional
    @Override
    public List<MediaDownloadSource> delete(List<MediaDownloadSource> entityList) throws CodenfastException {
        try {
            List<String> idList = entityList.stream().map(MediaDownloadSource::getId).collect(Collectors.toList());
            Map<String, Object> updateParams = new HashMap<>();
            updateParams.put(StringConstant.PASSIVE, Boolean.TRUE);
            List<FilterParam> filterParamList = new java.util.ArrayList<>();
            filterParamList.add(new FilterParam(StringConstant.ID, StringConstant.IN, idList));
            repository.update(MediaDownloadSource.class, updateParams, filterParamList);
            return entityList;
        } catch (Exception e) {
            throw new CodenfastException(e.getMessage(), e);
        }
    }

    @Override
    public List<MediaDownloadSource> grid(RequestGrid requestGrid) throws CodenfastException {
        return super.grid(MediaDownloadSource.class, repository, requestGrid);
    }

    @Override
    public TableModel<MediaDownloadSource> gridTableModel(RequestGrid requestGrid) throws CodenfastException {
        return super.gridTableModel(MediaDownloadSource.class, repository, requestGrid);
    }
}
