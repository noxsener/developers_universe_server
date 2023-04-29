package com.codenfast.developersuniverse.user.repository;

import com.codenfast.developersuniverse.common.entity.user.Role;
import com.codenfast.developersuniverse.common.repository.BaseRepositoryImpl;

import jakarta.persistence.EntityManager;


public class RoleRepositoryCustomImpl extends BaseRepositoryImpl<Role> implements RoleRepositoryCustom {

    public RoleRepositoryCustomImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
