package com.codenfast.developersuniverse.media.repository;


import com.codenfast.developersuniverse.common.entity.download.DownloadIntent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DownloadIntentRepository extends JpaRepository<DownloadIntent, String>, DownloadIntentRepositoryCustom {
}
