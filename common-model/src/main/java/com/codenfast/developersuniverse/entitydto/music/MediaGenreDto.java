package com.codenfast.developersuniverse.entitydto.music;

import com.codenfast.developersuniverse.entitydto.media.MediaDto;

import java.time.LocalDateTime;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
public class MediaGenreDto {
    private String id;
    private Boolean passive = Boolean.FALSE;
    private LocalDateTime createTime = null;
    private LocalDateTime updateTime = null;

    private MediaDto media;
    private GenreDto genre;
}
