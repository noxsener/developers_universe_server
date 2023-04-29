package com.codenfast.developersuniverse.media.repository;


import com.codenfast.developersuniverse.common.entity.download.DownloadPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DownloadPartRepository extends JpaRepository<DownloadPart, String>, DownloadPartRepositoryCustom {
}
