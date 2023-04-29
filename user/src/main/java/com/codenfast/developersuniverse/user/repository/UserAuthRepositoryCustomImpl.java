package com.codenfast.developersuniverse.user.repository;

import com.codenfast.developersuniverse.common.entity.user.UserAuth;
import com.codenfast.developersuniverse.common.repository.BaseRepositoryImpl;

import jakarta.persistence.EntityManager;


public class UserAuthRepositoryCustomImpl extends BaseRepositoryImpl<UserAuth> implements UserAuthRepositoryCustom {

    public UserAuthRepositoryCustomImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
