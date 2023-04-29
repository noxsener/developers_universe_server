package com.codenfast.developersuniverse.media.repository;


import com.codenfast.developersuniverse.common.entity.download.DownloadStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DownloadStatusRepository extends JpaRepository<DownloadStatus, String>, DownloadStatusRepositoryCustom {
}
