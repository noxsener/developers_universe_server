package com.codenfast.developersuniverse.media.repository;

import com.codenfast.developersuniverse.common.entity.music.Genre;
import com.codenfast.developersuniverse.common.repository.BaseRepositoryImpl;

import jakarta.persistence.EntityManager;


public class GenreRepositoryCustomImpl extends BaseRepositoryImpl<Genre> implements GenreRepositoryCustom {

    public GenreRepositoryCustomImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
