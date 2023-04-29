package com.codenfast.developersuniverse.media.repository;

import com.codenfast.developersuniverse.common.entity.music.MediaGenre;
import com.codenfast.developersuniverse.common.repository.BaseRepositoryImpl;

import jakarta.persistence.EntityManager;


public class MediaGenreRepositoryCustomImpl extends BaseRepositoryImpl<MediaGenre> implements MediaGenreRepositoryCustom {

    public MediaGenreRepositoryCustomImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
