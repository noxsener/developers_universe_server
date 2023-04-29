package com.codenfast.developersuniverse.entitydto.earchvive;

import com.codenfast.developersuniverse.EntityModel;

import java.time.LocalDateTime;
import java.util.List;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
public class ElectronicArchiveDto implements EntityModel {

    private String id;
    private Boolean passive = Boolean.FALSE;
    private LocalDateTime createTime = null;
    private LocalDateTime updateTime = null;
    private String name;
    private String description;
    private String mimeType;
    private String zipMimeType;
    private Integer height;
    private Integer width;
    private Long size;
    private String fileName;
    private String fileLocation;
    private Boolean isFolder;
    private ElectronicArchiveDto electronicArchiveFolder;
    private List<ElectronicArchiveDto> electronicArchiveList;
    private String fileBase64;
}
