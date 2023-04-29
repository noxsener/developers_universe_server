package com.codenfast.developersuniverse.common.entity.media;

import com.codenfast.developersuniverse.EntityModel;
import com.codenfast.developersuniverse.common.converter.YesNoConverter;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "MEDIA_DOWNLOAD_SOURCE", indexes = {
        @Index(columnList = "NAME", name = "ix_mediadownloadsource_name"),
        @Index(columnList = "TITLE", name = "ix_mediadownloadsource_title"),
        @Index(columnList = "URL", name = "ix_mediadownloadsource_url"),
}
)
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
public class MediaDownloadSource implements EntityModel {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "MEDIADOWNLOADSOURCE_ID", unique = true, nullable = false, length = 36)
    private String id;
    @Column(name = "PASSIVE", length = 1, nullable = false)
    @Convert(converter = YesNoConverter.class)
    private Boolean passive = Boolean.FALSE;
    @CreationTimestamp
    @Column(name = "CREATE_TIME")
    private LocalDateTime createTime = null;
    @UpdateTimestamp
    @Column(name = "UPDATE_TIME")
    private LocalDateTime  updateTime = null;

    @Column(name = "NAME")
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IMAGE_MEDIA_ID")
    private Media image;
    @Column(name = "URL")
    private String url;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "SITE_NAME")
    private String siteName;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "TYPE")
    private String type;
}
