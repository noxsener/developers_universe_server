package com.codenfast.developersuniverse.user.repository;

import com.codenfast.developersuniverse.common.entity.user.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, String>, UserAuthRepositoryCustom {
}
