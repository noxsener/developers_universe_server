package com.codenfast.developersuniverse.offlinedbinfo.repository;


import com.codenfast.developersuniverse.common.entity.OfflineDbInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfflineDbInfoRepository extends JpaRepository<OfflineDbInfo, String>, OfflineDbInfoRepositoryCustom {
}
