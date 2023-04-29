package com.codenfast.developersuniverse.media.service;

import com.codenfast.developersuniverse.common.entity.media.InvoiceLicence;
import com.codenfast.developersuniverse.common.service.BaseService;
import com.codenfast.developersuniverse.model.CodenfastException;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.concurrent.CompletableFuture;

public interface InvoiceLicenceService extends BaseService<InvoiceLicence> {
    InvoiceLicence getInvoiceLicence(String id) throws CodenfastException;
    CompletableFuture<Void> download(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String id);
}
