package com.codenfast.developersuniverse.media.repository;

import com.codenfast.developersuniverse.common.entity.media.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepository extends JpaRepository<Media, String>, MediaRepositoryCustom {
}
