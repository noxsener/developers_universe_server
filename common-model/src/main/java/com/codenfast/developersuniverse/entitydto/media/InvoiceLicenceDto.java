package com.codenfast.developersuniverse.entitydto.media;

import com.codenfast.developersuniverse.EntityModel;
import com.codenfast.developersuniverse.entitydto.download.DownloadIntentDto;
import com.codenfast.developersuniverse.entitydto.download.DownloadPartDto;
import com.codenfast.developersuniverse.entitydto.download.DownloadStatusDto;

import java.time.LocalDateTime;
import java.util.List;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
public class InvoiceLicenceDto implements EntityModel {
    private String id;
    private Boolean passive = Boolean.FALSE;
    private LocalDateTime createTime = null;
    private LocalDateTime  updateTime = null;
    private MediaDto media;
    private String issuer;
    private String name;
    private String downloadedUrl;
    private String description;
    private String mimeType;
    private String zipMimeType;
    private Integer height;
    private Integer width;
    private Long size;
    private String fileName;
    private String fileLocation;
    private String attributionText;
    private String attributionLink;
    private String attributionSourceLink;
    private DownloadStatusDto status;
    private Boolean partialDownloadSupport;
    private List<DownloadPartDto> downloadPartList;
    private DownloadIntentDto downloadIntent;
    private String fileBase64;
}
