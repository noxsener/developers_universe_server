package com.codenfast.developersuniverse.user.repository;

import com.codenfast.developersuniverse.common.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String>, UserRepositoryCustom {
}
