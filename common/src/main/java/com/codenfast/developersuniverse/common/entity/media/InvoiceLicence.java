package com.codenfast.developersuniverse.common.entity.media;

import com.codenfast.developersuniverse.EntityModel;
import com.codenfast.developersuniverse.common.converter.YesNoConverter;
import com.codenfast.developersuniverse.common.entity.download.DownloadIntent;
import com.codenfast.developersuniverse.common.entity.download.DownloadPart;
import com.codenfast.developersuniverse.common.entity.download.DownloadStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "INVOICE_LICENCE", indexes = {
        @Index(columnList = "NAME", name = "ix_invoicelicence_name"),
        @Index(columnList = "DOWNLOADED_URL", name = "ix_invoicelicence_downloadedurl"),
}
)
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
public class InvoiceLicence implements EntityModel {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "INVOICELICENCE_ID", unique = true, nullable = false, length = 36)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEDIA_ID")
    private Media media;

    @Column(name = "ISSUER")
    private String issuer;

    @Column(name = "NAME")
    private String name;
    @Column(name = "DOWNLOADED_URL")
    private String downloadedUrl;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "MIME_TYPE")
    private String mimeType;
    @Column(name = "ZIP_MIME_TYPE")
    private String zipMimeType;

    @Column(name = "HEIGHT")
    private Integer height;
    @Column(name = "WIDTH")
    private Integer width;
    @Column(name= "SIZE",nullable = false)
    private Long size;

    @Column(name = "FILE_NAME")
    private String fileName;
    @Column(name = "FILE_LOCATION")
    private String fileLocation;

    @Lob
    @Column(name = "ATTRIBUTION", columnDefinition = "text")
    private String attributionText;
    @Column(name = "ATTRIBUTION_LINK")
    private String attributionLink;
    @Column(name = "ATTRIBUTION_SOURCE_LINK")
    private String attributionSourceLink;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOWNLOADSTATUS_ID")
    private DownloadStatus status;
    @Column(name = "PARTIAL_DOWNLOAD_SUPPORT", length = 1, nullable = false)
    @Convert(converter = YesNoConverter.class)
    private Boolean partialDownloadSupport;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "invoiceLicence")
    private List<DownloadPart> downloadPartList;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOWNLOADINTENT_ID")
    private DownloadIntent downloadIntent;
    @Transient
    private String fileBase64;
}
