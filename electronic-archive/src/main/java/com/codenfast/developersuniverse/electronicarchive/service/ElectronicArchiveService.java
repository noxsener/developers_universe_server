package com.codenfast.developersuniverse.electronicarchive.service;

import com.codenfast.developersuniverse.common.entity.earchive.ElectronicArchive;
import com.codenfast.developersuniverse.model.ElectronicArchiveLoginModel;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public interface ElectronicArchiveService {

    ElectronicArchive upload(ElectronicArchiveLoginModel electronicArchiveLoginModel, ElectronicArchive folder, ElectronicArchive file) throws IOException;
    ElectronicArchive delete(ElectronicArchiveLoginModel electronicArchiveLoginModel,ElectronicArchive file) throws IOException;
    CompletableFuture<Void> download(ElectronicArchiveLoginModel electronicArchiveLoginModel, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ElectronicArchive file) throws IOException;
}
