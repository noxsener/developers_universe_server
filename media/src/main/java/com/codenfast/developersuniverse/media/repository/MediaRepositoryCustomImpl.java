package com.codenfast.developersuniverse.media.repository;

import com.codenfast.developersuniverse.common.entity.media.Media;
import com.codenfast.developersuniverse.common.repository.BaseRepositoryImpl;

import jakarta.persistence.EntityManager;


public class MediaRepositoryCustomImpl extends BaseRepositoryImpl<Media> implements MediaRepositoryCustom {

    public MediaRepositoryCustomImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
