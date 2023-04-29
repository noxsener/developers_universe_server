package com.codenfast.developersuniverse.media.service;

import com.codenfast.developersuniverse.common.entity.media.Media;
import com.codenfast.developersuniverse.entitydto.media.MediaDto;
import com.codenfast.developersuniverse.model.CodenfastException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface DownloadManagerService {
    Media getMedia(String id);
    Media addDownloadQueue(Media media) throws CodenfastException;
    Media generateMediaFromUrl(Media media) throws IOException, InterruptedException, NoSuchFieldException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, CodenfastException;
    void cancelMedia(String id);
    void retryMedia(String id) throws CodenfastException;
    List<Media> waitingMediaList() throws CodenfastException;
    MediaDto downloadingProcess(Media media) throws NoSuchFieldException, IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, CodenfastException;
}
