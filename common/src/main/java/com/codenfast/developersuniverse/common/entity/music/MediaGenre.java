package com.codenfast.developersuniverse.common.entity.music;

import com.codenfast.developersuniverse.EntityModel;
import com.codenfast.developersuniverse.common.converter.YesNoConverter;
import com.codenfast.developersuniverse.common.entity.media.Media;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "MEDIA_GENRE", indexes = {
        @Index(columnList = "MEDIA_ID", name = "ix_mediagenre_media")
}
)
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
public class MediaGenre implements EntityModel {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "MEDIAGENRE_ID", unique = true, nullable = false, length = 36)
    private String id;
    @Column(name = "PASSIVE", length = 1, nullable = false)
    @Convert(converter = YesNoConverter.class)
    private Boolean passive = Boolean.FALSE;
    @CreationTimestamp
    @Column(name = "CREATE_TIME")
    private LocalDateTime createTime = null;
    @UpdateTimestamp
    @Column(name = "UPDATE_TIME")
    private LocalDateTime updateTime = null;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEDIA_ID")
    private Media media;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GENRE_ID")
    private Genre genre;
}
