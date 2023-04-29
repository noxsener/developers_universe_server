package com.codenfast.developersuniverse.media.repository;


import com.codenfast.developersuniverse.common.entity.download.DownloadIntent;
import com.codenfast.developersuniverse.common.repository.BaseRepositoryImpl;

import jakarta.persistence.EntityManager;

public class DownloadIntentRepositoryCustomImpl extends BaseRepositoryImpl<DownloadIntent> implements DownloadIntentRepositoryCustom {

    public DownloadIntentRepositoryCustomImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
