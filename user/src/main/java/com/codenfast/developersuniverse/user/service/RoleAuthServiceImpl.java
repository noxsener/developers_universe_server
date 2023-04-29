package com.codenfast.developersuniverse.user.service;

import com.codenfast.developersuniverse.common.entity.user.RoleAuth;
import com.codenfast.developersuniverse.common.service.BaseServiceImpl;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.codenfast.developersuniverse.model.FilterParam;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.model.TableModel;
import com.codenfast.developersuniverse.user.repository.RoleAuthRepository;
import com.codenfast.developersuniverse.utils.StringConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleAuthServiceImpl extends BaseServiceImpl<RoleAuth> implements RoleAuthService {

    private final RoleAuthRepository repository;

    @Override
    public RoleAuth save(RoleAuth entity) throws CodenfastException {
        RoleAuth entityRef = super.save(entity);
        entityRef = repository.save(entityRef);
        repository.detach(entityRef);
        return entityRef;
    }

    @Override
    public RoleAuth update(RoleAuth entity) throws CodenfastException {
        RoleAuth entityRef = super.update(repository, entity);
        entityRef = repository.save(entityRef);
        repository.detach(entityRef);
        return entityRef;
    }

    @Override
    public RoleAuth delete(String id) throws CodenfastException {
        Optional<RoleAuth> entityOptional = repository.findById(id).filter(e -> !e.getPassive()).stream().findFirst();
        if (entityOptional.isEmpty()) {
            throw new CodenfastException(StringConstant.DATA_NOT_FOUND);
        }
        RoleAuth entity = entityOptional.get();
        entity.setPassive(Boolean.TRUE);
        return repository.detach(repository.save(entity));
    }

    @Override
    public List<RoleAuth> save(List<RoleAuth> entityList) throws CodenfastException {
        List<RoleAuth> entityRef = super.save(entityList);
        return repository.saveAll(entityRef);
    }

    @Override
    public List<RoleAuth> update(List<RoleAuth> entityList) throws CodenfastException {
        List<RoleAuth> entityRef = super.update(repository, entityList);
        return repository.saveAll(entityRef);
    }

    @Transactional
    @Override
    public List<RoleAuth> delete(List<RoleAuth> entityList) throws CodenfastException {
        try {
            List<String> idList = entityList.stream().map(RoleAuth::getId).collect(Collectors.toList());
            Map<String, Object> updateParams = new HashMap<>();
            updateParams.put(StringConstant.PASSIVE, Boolean.TRUE);
            List<FilterParam> filterParamList = new ArrayList<>();
            filterParamList.add(new FilterParam(StringConstant.ID, StringConstant.IN, idList));
            repository.update(RoleAuth.class, updateParams, filterParamList);
            return entityList;
        } catch (Exception e) {
            throw new CodenfastException(e.getMessage(), e);
        }
    }

    @Override
    public List<RoleAuth> grid(RequestGrid requestGrid) throws CodenfastException {
        return super.grid(RoleAuth.class, repository, requestGrid);
    }

    @Override
    public TableModel<RoleAuth> gridTableModel(RequestGrid requestGrid) throws CodenfastException {
        return super.gridTableModel(RoleAuth.class, repository, requestGrid);
    }
}
