package com.codenfast.developersuniverse.media.service;


import com.codenfast.developersuniverse.common.entity.media.Media;
import com.codenfast.developersuniverse.common.service.BaseService;
import com.codenfast.developersuniverse.model.CodenfastException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface MediaService extends BaseService<Media> {
    void updateMediaLengthInSeconds();
    Media getMedia(String id) throws CodenfastException;
    CompletableFuture<Void> download(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String id);
    void generateMediafileLists();
    List<Media> getMediaFileIndexList() throws IOException;
    CompletableFuture<Void> downloadMediaFileList(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String mediaName);
}
