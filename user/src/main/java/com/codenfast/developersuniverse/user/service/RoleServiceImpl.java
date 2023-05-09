package com.codenfast.developersuniverse.user.service;

import com.codenfast.developersuniverse.common.entity.user.Role;
import com.codenfast.developersuniverse.common.service.BaseServiceImpl;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.codenfast.developersuniverse.model.FilterParam;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.model.TableModel;
import com.codenfast.developersuniverse.user.repository.RoleRepository;
import com.codenfast.developersuniverse.utils.StringConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    private final RoleRepository repository;

    @Override
    public Role save(Role entity) throws CodenfastException {
        Role entityRef = super.save(entity);
        entityRef = repository.save(entityRef);
        repository.detach(entityRef);
        return entityRef;
    }

    @Override
    public Role update(Role entity) throws CodenfastException {
        Role entityRef = super.update(repository, entity);
        entityRef = repository.save(entityRef);
        repository.detach(entityRef);
        return entityRef;
    }

    @Override
    public Role delete(String id) throws CodenfastException {
        Optional<Role> entityOptional = repository.findById(id).filter(e -> !e.getPassive()).stream().findFirst();
        if (entityOptional.isEmpty()) {
            throw new CodenfastException(StringConstant.DATA_NOT_FOUND);
        }
        Role entity = entityOptional.get();
        entity.setPassive(Boolean.TRUE);
        return repository.detach(repository.save(entity));
    }

    @Override
    public List<Role> save(List<Role> entityList) throws CodenfastException {
        List<Role> entityRef = super.save(entityList);
        return repository.saveAll(entityRef);
    }

    @Override
    public List<Role> update(List<Role> entityList) throws CodenfastException {
        List<Role> entityRef = super.update(repository, entityList);
        return repository.saveAll(entityRef);
    }

    @Transactional
    @Override
    public List<Role> delete(List<Role> entityList) throws CodenfastException {
        try {
            List<String> idList = entityList.stream().map(Role::getId).collect(Collectors.toList());
            Map<String, Object> updateParams = new HashMap<>();
            updateParams.put(StringConstant.PASSIVE, Boolean.TRUE);
            List<FilterParam> filterParamList = new ArrayList<>();
            filterParamList.add(new FilterParam(StringConstant.ID, StringConstant.IN, idList));
            repository.update(Role.class, updateParams, filterParamList);
            return entityList;
        } catch (Exception e) {
            throw new CodenfastException(e.getMessage(), e);
        }
    }

    @Override
    public List<Role> grid(RequestGrid requestGrid) throws CodenfastException {
        return super.grid(Role.class, repository, requestGrid);
    }

    @Override
    public TableModel<Role> gridTableModel(RequestGrid requestGrid) throws CodenfastException {
        return super.gridTableModel(Role.class, repository, requestGrid);
    }
}
