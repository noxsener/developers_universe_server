package com.codenfast.developersuniverse.user.service;

import com.codenfast.developersuniverse.common.entity.user.UserRole;
import com.codenfast.developersuniverse.common.service.BaseServiceImpl;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.codenfast.developersuniverse.model.FilterParam;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.model.TableModel;
import com.codenfast.developersuniverse.user.repository.UserRoleRepository;
import com.codenfast.developersuniverse.utils.StringConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole> implements UserRoleService {

    private final UserRoleRepository repository;

    @Override
    public UserRole save(UserRole entity) throws CodenfastException {
        UserRole entityRef = super.save(entity);
        entityRef = repository.save(entityRef);
        repository.detach(entityRef);
        return entityRef;
    }

    @Override
    public UserRole update(UserRole entity) throws CodenfastException {
        UserRole entityRef = super.update(repository, entity);
        entityRef = repository.save(entityRef);
        repository.detach(entityRef);
        return entityRef;
    }

    @Override
    public UserRole delete(String id) throws CodenfastException {
        Optional<UserRole> entityOptional = repository.findById(id).filter(e -> !e.getPassive()).stream().findFirst();
        if (entityOptional.isEmpty()) {
            throw new CodenfastException(StringConstant.DATA_NOT_FOUND);
        }
        UserRole entity = entityOptional.get();
        entity.setPassive(Boolean.TRUE);
        return repository.detach(repository.save(entity));
    }

    @Override
    public List<UserRole> save(List<UserRole> entityList) throws CodenfastException {
        List<UserRole> entityRef = super.save(entityList);
        return repository.saveAll(entityRef);
    }

    @Override
    public List<UserRole> update(List<UserRole> entityList) throws CodenfastException {
        List<UserRole> entityRef = super.update(repository, entityList);
        return repository.saveAll(entityRef);
    }

    @Transactional
    @Override
    public List<UserRole> delete(List<UserRole> entityList) throws CodenfastException {
        try {
            List<String> idList = entityList.stream().map(UserRole::getId).collect(Collectors.toList());
            Map<String, Object> updateParams = new HashMap<>();
            updateParams.put(StringConstant.PASSIVE, Boolean.TRUE);
            List<FilterParam> filterParamList = new ArrayList<>();
            filterParamList.add(new FilterParam(StringConstant.ID, StringConstant.IN, idList));
            repository.update(UserRole.class, updateParams, filterParamList);
            return entityList;
        } catch (Exception e) {
            throw new CodenfastException(e.getMessage(), e);
        }
    }

    @Override
    public List<UserRole> grid(RequestGrid requestGrid) throws CodenfastException {
        return super.grid(UserRole.class, repository, requestGrid);
    }

    @Override
    public TableModel<UserRole> gridTableModel(RequestGrid requestGrid) throws CodenfastException {
        return super.gridTableModel(UserRole.class, repository, requestGrid);
    }
}
