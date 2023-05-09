package com.codenfast.developersuniverse.media.repository;

import com.codenfast.developersuniverse.common.entity.media.InvoiceLicence;
import com.codenfast.developersuniverse.common.repository.BaseRepositoryImpl;
import jakarta.persistence.EntityManager;


public class InvoiceLicenceRepositoryCustomImpl extends BaseRepositoryImpl<InvoiceLicence> implements InvoiceLicenceRepositoryCustom {

    public InvoiceLicenceRepositoryCustomImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
