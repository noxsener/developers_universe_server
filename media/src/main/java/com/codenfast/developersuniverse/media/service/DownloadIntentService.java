package com.codenfast.developersuniverse.media.service;

import com.codenfast.developersuniverse.common.entity.download.DownloadIntent;
import com.codenfast.developersuniverse.common.entity.media.Media;
import com.codenfast.developersuniverse.common.service.BaseService;
import com.codenfast.developersuniverse.entitydto.media.MediaDto;
import com.codenfast.developersuniverse.model.CodenfastException;

import java.io.IOException;

public interface DownloadIntentService extends BaseService<DownloadIntent> {
    MediaDto processIntent(Media media) throws CodenfastException, IOException;
}
