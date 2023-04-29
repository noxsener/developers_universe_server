package com.codenfast.developersuniverse.offlinedbinfo.repository;


import com.codenfast.developersuniverse.common.entity.OfflineDbInfo;
import com.codenfast.developersuniverse.common.repository.BaseRepositoryImpl;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class OfflineDbInfoRepositoryCustomImpl extends BaseRepositoryImpl<OfflineDbInfo> implements OfflineDbInfoRepositoryCustom {

    public OfflineDbInfoRepositoryCustomImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
