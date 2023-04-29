package com.codenfast.developersuniverse.common.entity.download;

import com.codenfast.developersuniverse.EntityModel;
import com.codenfast.developersuniverse.common.converter.YesNoConverter;
import com.codenfast.developersuniverse.common.entity.media.InvoiceLicence;
import com.codenfast.developersuniverse.common.entity.media.Media;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "DOWNLOAD_PART", indexes = {
        @Index(columnList = "MEDIA_ID", name = "ix_downloadpart_media")
}
)
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
public class DownloadPart implements EntityModel {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "DOWNLOADPART_ID", unique = true, nullable = false, length = 36)
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
    @JoinColumn(name = "INVOICELICENCE_ID")
    private InvoiceLicence invoiceLicence;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOWNLOADSTATUS_ID")
    private DownloadStatus status;

    @Column(name= "PART_NUMBER", nullable = false)
    private Integer partNumber;

    @Column(name = "BYTE_RANGE_START", nullable = false)
    private Long byteRangeStart;

    @Column(name = "BYTE_RANGE_END", nullable = false)
    private Long byteRangeEnd;

    @Column(name = "PART_FILE_NAME", nullable = false)
    private String partFileName;
}
