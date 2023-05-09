package com.codenfast.developersuniverse.user.repository;

import com.codenfast.developersuniverse.common.entity.user.RoleAuth;
import com.codenfast.developersuniverse.common.repository.BaseRepositoryImpl;
import jakarta.persistence.EntityManager;


public class RoleAuthRepositoryCustomImpl extends BaseRepositoryImpl<RoleAuth> implements RoleAuthRepositoryCustom {

    public RoleAuthRepositoryCustomImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
