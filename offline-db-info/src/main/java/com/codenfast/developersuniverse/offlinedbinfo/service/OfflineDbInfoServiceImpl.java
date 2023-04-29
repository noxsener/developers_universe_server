package com.codenfast.developersuniverse.offlinedbinfo.service;

import com.codenfast.developersuniverse.common.entity.OfflineDbInfo;
import com.codenfast.developersuniverse.offlinedbinfo.repository.OfflineDbInfoRepository;
import com.codenfast.developersuniverse.common.service.BaseServiceImpl;
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
public class OfflineDbInfoServiceImpl extends BaseServiceImpl<OfflineDbInfo> implements OfflineDbInfoService {

    private final OfflineDbInfoRepository repository;

    @Override
    public OfflineDbInfo save(OfflineDbInfo entity) throws CodenfastException {
        OfflineDbInfo entityRef = super.save(entity);
        entityRef = repository.save(entityRef);
        repository.detach(entityRef);
        return entityRef;
    }

    @Override
    public OfflineDbInfo update(OfflineDbInfo entity) throws CodenfastException {
        OfflineDbInfo entityRef = super.update(repository, entity);
        entityRef = repository.save(entityRef);
        repository.detach(entityRef);
        return entityRef;
    }

    @Override
    public OfflineDbInfo delete(String id) throws CodenfastException {
        Optional<OfflineDbInfo> entityOptional = repository.findById(id).filter(e -> !e.getPassive()).stream().findFirst();
        if(entityOptional.isEmpty()) {
            throw new CodenfastException(StringConstant.DATA_NOT_FOUND);
        }
        OfflineDbInfo entity = entityOptional.get();
        entity.setPassive(Boolean.TRUE);
        return repository.detach(repository.save(entity));
    }

    @Override
    public List<OfflineDbInfo> save(List<OfflineDbInfo> entityList) throws CodenfastException {
        List<OfflineDbInfo> entityRef = super.save(entityList);
        return repository.saveAll(entityRef);
    }

    @Override
    public List<OfflineDbInfo> update(List<OfflineDbInfo> entityList) throws CodenfastException {
        List<OfflineDbInfo> entityRef = super.update(repository, entityList);
        return repository.saveAll(entityRef);
    }

    @Transactional
    @Override
    public List<OfflineDbInfo> delete(List<OfflineDbInfo> entityList) throws CodenfastException {
        try {
            List<String> idList = entityList.stream().map(OfflineDbInfo::getId).collect(Collectors.toList());
            Map<String, Object> updateParams = new HashMap<>();
            updateParams.put(StringConstant.PASSIVE, Boolean.TRUE);
            List<FilterParam> filterParamList = new ArrayList<>();
            filterParamList.add(new FilterParam(StringConstant.ID, StringConstant.IN, idList));
            repository.update(OfflineDbInfo.class, updateParams, filterParamList);
            return entityList;
        } catch (Exception e) {
            throw new CodenfastException(e.getMessage(), e);
        }
    }

    @Override
    public List<OfflineDbInfo> grid(RequestGrid requestGrid) throws CodenfastException {
        return super.grid(OfflineDbInfo.class, repository, requestGrid);
    }

    @Override
    public TableModel<OfflineDbInfo> gridTableModel(RequestGrid requestGrid) throws CodenfastException {
        return super.gridTableModel(OfflineDbInfo.class, repository, requestGrid);
    }
}
