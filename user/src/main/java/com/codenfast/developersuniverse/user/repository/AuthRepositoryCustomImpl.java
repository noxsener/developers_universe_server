package com.codenfast.developersuniverse.user.repository;

import com.codenfast.developersuniverse.common.entity.user.Auth;
import com.codenfast.developersuniverse.common.repository.BaseRepositoryImpl;

import jakarta.persistence.EntityManager;


public class AuthRepositoryCustomImpl extends BaseRepositoryImpl<Auth> implements AuthRepositoryCustom {

    public AuthRepositoryCustomImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
