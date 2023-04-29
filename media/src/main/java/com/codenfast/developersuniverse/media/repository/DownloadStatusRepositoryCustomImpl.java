package com.codenfast.developersuniverse.media.repository;


import com.codenfast.developersuniverse.common.entity.download.DownloadStatus;
import com.codenfast.developersuniverse.common.repository.BaseRepositoryImpl;

import jakarta.persistence.EntityManager;

public class DownloadStatusRepositoryCustomImpl extends BaseRepositoryImpl<DownloadStatus> implements DownloadStatusRepositoryCustom {

    public DownloadStatusRepositoryCustomImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
