package com.codenfast.developersuniverse.user.service;

import com.codenfast.developersuniverse.common.entity.user.Auth;
import com.codenfast.developersuniverse.common.service.BaseServiceImpl;
import com.codenfast.developersuniverse.model.CodenfastException;
import com.codenfast.developersuniverse.model.FilterParam;
import com.codenfast.developersuniverse.model.RequestGrid;
import com.codenfast.developersuniverse.model.TableModel;
import com.codenfast.developersuniverse.user.repository.AuthRepository;
import com.codenfast.developersuniverse.utils.StringConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl extends BaseServiceImpl<Auth> implements AuthService {

    private final AuthRepository repository;

    @Override
    public Auth save(Auth entity) throws CodenfastException {
        Auth entityRef = super.save(entity);
        entityRef = repository.save(entityRef);
        repository.detach(entityRef);
        return entityRef;
    }

    @Override
    public Auth update(Auth entity) throws CodenfastException {
        Auth entityRef = super.update(repository, entity);
        entityRef = repository.save(entityRef);
        repository.detach(entityRef);
        return entityRef;
    }

    @Override
    public Auth delete(String id) throws CodenfastException {
        Optional<Auth> entityOptional = repository.findById(id).filter(e -> !e.getPassive()).stream().findFirst();
        if (entityOptional.isEmpty()) {
            throw new CodenfastException(StringConstant.DATA_NOT_FOUND);
        }
        Auth entity = entityOptional.get();
        entity.setPassive(Boolean.TRUE);
        return repository.detach(repository.save(entity));
    }

    @Override
    public List<Auth> save(List<Auth> entityList) throws CodenfastException {
        List<Auth> entityRef = super.save(entityList);
        return repository.saveAll(entityRef);
    }

    @Override
    public List<Auth> update(List<Auth> entityList) throws CodenfastException {
        List<Auth> entityRef = super.update(repository, entityList);
        return repository.saveAll(entityRef);
    }

    @Transactional
    @Override
    public List<Auth> delete(List<Auth> entityList) throws CodenfastException {
        try {
            List<String> idList = entityList.stream().map(Auth::getId).collect(Collectors.toList());
            Map<String, Object> updateParams = new HashMap<>();
            updateParams.put(StringConstant.PASSIVE, Boolean.TRUE);
            List<FilterParam> filterParamList = new ArrayList<>();
            filterParamList.add(new FilterParam(StringConstant.ID, StringConstant.IN, idList));
            repository.update(Auth.class, updateParams, filterParamList);
            return entityList;
        } catch (Exception e) {
            throw new CodenfastException(e.getMessage(), e);
        }
    }

    @Override
    public List<Auth> grid(RequestGrid requestGrid) throws CodenfastException {
        return super.grid(Auth.class, repository, requestGrid);
    }

    @Override
    public TableModel<Auth> gridTableModel(RequestGrid requestGrid) throws CodenfastException {
        return super.gridTableModel(Auth.class, repository, requestGrid);
    }
}
