package com.codenfast.developersuniverse.media.service;

import com.codenfast.developersuniverse.common.entity.music.Genre;
import com.codenfast.developersuniverse.common.service.BaseServiceImpl;
import com.codenfast.developersuniverse.media.repository.GenreRepository;
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
public class GenreServiceImpl extends BaseServiceImpl<Genre> implements GenreService {

    private final GenreRepository repository;

    @Override
    public Genre save(Genre entity) throws CodenfastException {
        Genre entityRef = super.save(entity);
        entityRef = repository.save(entityRef);
        repository.detach(entityRef);
        return entityRef;
    }

    @Override
    public Genre update(Genre entity) throws CodenfastException {
        Genre entityRef = super.update(repository, entity);
        entityRef = repository.save(entityRef);
        repository.detach(entityRef);
        return entityRef;
    }

    @Override
    public Genre delete(String id) throws CodenfastException {
        Optional<Genre> entityOptional = repository.findById(id).filter(e -> !e.getPassive()).stream().findFirst();
        if(entityOptional.isEmpty()) {
            throw new CodenfastException(StringConstant.DATA_NOT_FOUND);
        }
        Genre entity = entityOptional.get();
        entity.setPassive(Boolean.TRUE);
        return repository.detach(repository.save(entity));
    }

    @Override
    public List<Genre> save(List<Genre> entityList) throws CodenfastException {
        List<Genre> entityRef = super.save(entityList);
        return repository.saveAll(entityRef);
    }

    @Override
    public List<Genre> update(List<Genre> entityList) throws CodenfastException {
        List<Genre> entityRef = super.update(repository, entityList);
        return repository.saveAll(entityRef);
    }

    @Transactional
    @Override
    public List<Genre> delete(List<Genre> entityList) throws CodenfastException {
        try {
            List<String> idList = entityList.stream().map(Genre::getId).collect(Collectors.toList());
            Map<String, Object> updateParams = new HashMap<>();
            updateParams.put(StringConstant.PASSIVE, Boolean.TRUE);
            List<FilterParam> filterParamList = new java.util.ArrayList<>();
            filterParamList.add(new FilterParam(StringConstant.ID, StringConstant.IN, idList));
            repository.update(Genre.class, updateParams, filterParamList);
            return entityList;
        } catch (Exception e) {
            throw new CodenfastException(e.getMessage(), e);
        }
    }

    @Override
    public List<Genre> grid(RequestGrid requestGrid) throws CodenfastException {
        return super.grid(Genre.class, repository, requestGrid);
    }

    @Override
    public TableModel<Genre> gridTableModel(RequestGrid requestGrid) throws CodenfastException {
        return super.gridTableModel(Genre.class, repository, requestGrid);
    }
}
