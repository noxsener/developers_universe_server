package com.codenfast.developersuniverse.user.repository;

import com.codenfast.developersuniverse.common.entity.user.User;
import com.codenfast.developersuniverse.common.repository.BaseRepositoryImpl;
import jakarta.persistence.EntityManager;


public class UserRepositoryCustomImpl extends BaseRepositoryImpl<User> implements UserRepositoryCustom {

    public UserRepositoryCustomImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
