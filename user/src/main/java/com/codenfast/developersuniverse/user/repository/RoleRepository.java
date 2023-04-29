package com.codenfast.developersuniverse.user.repository;

import com.codenfast.developersuniverse.common.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String>, RoleRepositoryCustom {
}
