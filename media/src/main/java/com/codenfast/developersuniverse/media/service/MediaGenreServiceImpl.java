package com.codenfast.developersuniverse.media.service;

import com.codenfast.developersuniverse.common.entity.music.MediaGenre;
import com.codenfast.developersuniverse.common.service.BaseServiceImpl;
import com.codenfast.developersuniverse.media.repository.MediaGenreRepository;
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
public class MediaGenreServiceImpl extends BaseServiceImpl<MediaGenre> implements MediaGenreService {

    private final MediaGenreRepository repository;

    @Override
    public MediaGenre save(MediaGenre entity) throws CodenfastException {
        MediaGenre entityRef = super.save(entity);
        entityRef = repository.save(entityRef);
        repository.detach(entityRef);
        return entityRef;
    }

    @Override
    public MediaGenre update(MediaGenre entity) throws CodenfastException {
        MediaGenre entityRef = super.update(repository, entity);
        entityRef = repository.save(entityRef);
        repository.detach(entityRef);
        return entityRef;
    }

    @Override
    public MediaGenre delete(String id) throws CodenfastException {
        Optional<MediaGenre> entityOptional = repository.findById(id).filter(e -> !e.getPassive()).stream().findFirst();
        if(entityOptional.isEmpty()) {
            throw new CodenfastException(StringConstant.DATA_NOT_FOUND);
        }
        MediaGenre entity = entityOptional.get();
        entity.setPassive(Boolean.TRUE);
        return repository.detach(repository.save(entity));
    }

    @Override
    public List<MediaGenre> save(List<MediaGenre> entityList) throws CodenfastException {
        List<MediaGenre> entityRef = super.save(entityList);
        return repository.saveAll(entityRef);
    }

    @Override
    public List<MediaGenre> update(List<MediaGenre> entityList) throws CodenfastException {
        List<MediaGenre> entityRef = super.update(repository, entityList);
        return repository.saveAll(entityRef);
    }

    @Transactional
    @Override
    public List<MediaGenre> delete(List<MediaGenre> entityList) throws CodenfastException {
        try {
            List<String> idList = entityList.stream().map(MediaGenre::getId).collect(Collectors.toList());
            Map<String, Object> updateParams = new HashMap<>();
            updateParams.put(StringConstant.PASSIVE, Boolean.TRUE);
            List<FilterParam> filterParamList = new java.util.ArrayList<>();
            filterParamList.add(new FilterParam(StringConstant.ID, StringConstant.IN, idList));
            repository.update(MediaGenre.class, updateParams, filterParamList);
            return entityList;
        } catch (Exception e) {
            throw new CodenfastException(e.getMessage(), e);
        }
    }

    @Override
    public List<MediaGenre> grid(RequestGrid requestGrid) throws CodenfastException {
        return super.grid(MediaGenre.class, repository, requestGrid);
    }

    @Override
    public TableModel<MediaGenre> gridTableModel(RequestGrid requestGrid) throws CodenfastException {
        return super.gridTableModel(MediaGenre.class, repository, requestGrid);
    }
}
