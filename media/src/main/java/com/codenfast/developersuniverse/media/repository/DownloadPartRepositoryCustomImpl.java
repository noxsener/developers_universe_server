package com.codenfast.developersuniverse.media.repository;


import com.codenfast.developersuniverse.common.entity.download.DownloadPart;
import com.codenfast.developersuniverse.common.repository.BaseRepositoryImpl;

import jakarta.persistence.EntityManager;

public class DownloadPartRepositoryCustomImpl extends BaseRepositoryImpl<DownloadPart> implements DownloadPartRepositoryCustom {

    public DownloadPartRepositoryCustomImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
