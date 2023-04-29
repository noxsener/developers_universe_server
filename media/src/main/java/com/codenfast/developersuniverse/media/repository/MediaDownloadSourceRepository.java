package com.codenfast.developersuniverse.media.repository;

import com.codenfast.developersuniverse.common.entity.media.MediaDownloadSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaDownloadSourceRepository extends JpaRepository<MediaDownloadSource, String>, MediaDownloadSourceRepositoryCustom {
}
