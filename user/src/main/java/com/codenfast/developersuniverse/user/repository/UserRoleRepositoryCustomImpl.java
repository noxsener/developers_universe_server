package com.codenfast.developersuniverse.user.repository;

import com.codenfast.developersuniverse.common.entity.user.UserRole;
import com.codenfast.developersuniverse.common.repository.BaseRepositoryImpl;

import jakarta.persistence.EntityManager;


public class UserRoleRepositoryCustomImpl extends BaseRepositoryImpl<UserRole> implements UserRoleRepositoryCustom {

    public UserRoleRepositoryCustomImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
