package com.codenfast.developersuniverse.media.repository;

import com.codenfast.developersuniverse.common.entity.media.InvoiceLicence;
import com.codenfast.developersuniverse.common.entity.music.MediaGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceLicenceRepository extends JpaRepository<InvoiceLicence, String>, InvoiceLicenceRepositoryCustom {
}
