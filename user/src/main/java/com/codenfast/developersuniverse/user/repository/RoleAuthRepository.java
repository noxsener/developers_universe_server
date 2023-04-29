package com.codenfast.developersuniverse.user.repository;

import com.codenfast.developersuniverse.common.entity.user.RoleAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleAuthRepository extends JpaRepository<RoleAuth, String>, RoleAuthRepositoryCustom {
}
