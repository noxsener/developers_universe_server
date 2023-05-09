package com.codenfast.developersuniverse.media.service;

import com.codenfast.developersuniverse.common.entity.download.DownloadStatus;
import com.codenfast.developersuniverse.common.service.BaseServiceImpl;
import com.codenfast.developersuniverse.media.repository.DownloadStatusRepository;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.codenfast.developersuniverse.model.FilterParam;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.model.TableModel;
import com.codenfast.developersuniverse.utils.StringConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DownloadStatusServiceImpl extends BaseServiceImpl<DownloadStatus> implements DownloadStatusService {

    private final DownloadStatusRepository repository;

    @Override
    public DownloadStatus save(DownloadStatus entity) throws CodenfastException {
        DownloadStatus entityRef = super.save(entity);
        entityRef = repository.save(entityRef);
        repository.detach(entityRef);
        return entityRef;
    }

    @Override
    public DownloadStatus update(DownloadStatus entity) throws CodenfastException {
        DownloadStatus entityRef = super.update(repository, entity);
        entityRef = repository.save(entityRef);
        repository.detach(entityRef);
        return entityRef;
    }

    @Override
    public DownloadStatus delete(String id) throws CodenfastException {
        Optional<DownloadStatus> entityOptional = repository.findById(id).filter(e -> !e.getPassive()).stream().findFirst();
        if(entityOptional.isEmpty()) {
            throw new CodenfastException(StringConstant.DATA_NOT_FOUND);
        }
        DownloadStatus entity = entityOptional.get();
        entity.setPassive(Boolean.TRUE);
        return repository.detach(repository.save(entity));
    }

    @Override
    public List<DownloadStatus> save(List<DownloadStatus> entityList) throws CodenfastException {
        List<DownloadStatus> entityRef = super.save(entityList);
        return repository.saveAll(entityRef);
    }

    @Override
    public List<DownloadStatus> update(List<DownloadStatus> entityList) throws CodenfastException {
        List<DownloadStatus> entityRef = super.update(repository, entityList);
        return repository.saveAll(entityRef);
    }

    @Transactional
    @Override
    public List<DownloadStatus> delete(List<DownloadStatus> entityList) throws CodenfastException {
        try {
            List<String> idList = entityList.stream().map(DownloadStatus::getId).collect(Collectors.toList());
            Map<String, Object> updateParams = new HashMap<>();
            updateParams.put(StringConstant.PASSIVE, Boolean.TRUE);
            List<FilterParam> filterParamList = new java.util.ArrayList<>();
            filterParamList.add(new FilterParam(StringConstant.ID, StringConstant.IN, idList));
            repository.update(DownloadStatus.class, updateParams, filterParamList);
            return entityList;
        } catch (Exception e) {
            throw new CodenfastException(e.getMessage(), e);
        }
    }

    @Override
    public List<DownloadStatus> grid(RequestGrid requestGrid) throws CodenfastException {
        return super.grid(DownloadStatus.class, repository, requestGrid);
    }

    @Override
    public TableModel<DownloadStatus> gridTableModel(RequestGrid requestGrid) throws CodenfastException {
        return super.gridTableModel(DownloadStatus.class, repository, requestGrid);
    }
}
