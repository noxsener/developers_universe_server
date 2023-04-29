package com.codenfast.developersuniverse.user.repository;

import com.codenfast.developersuniverse.common.entity.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String>, UserRoleRepositoryCustom {
}
