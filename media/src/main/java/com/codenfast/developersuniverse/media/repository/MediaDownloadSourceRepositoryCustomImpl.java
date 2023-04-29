package com.codenfast.developersuniverse.media.repository;


import com.codenfast.developersuniverse.common.entity.media.MediaDownloadSource;
import com.codenfast.developersuniverse.common.repository.BaseRepositoryImpl;

import jakarta.persistence.EntityManager;

public class MediaDownloadSourceRepositoryCustomImpl extends BaseRepositoryImpl<MediaDownloadSource> implements MediaDownloadSourceRepositoryCustom {

    public MediaDownloadSourceRepositoryCustomImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
