package com.codenfast.developersuniverse.common.entity.earchive;

import com.codenfast.developersuniverse.EntityModel;
import com.codenfast.developersuniverse.common.converter.YesNoConverter;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ELECTRONIC_ARCHIVE", indexes = {
        @Index(columnList = "NAME", name = "ix_electronicarchive_name"),
        @Index(columnList = "DESCRIPTION", name = "ix_electronicarchive_description"),
}
)
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
public class ElectronicArchive implements EntityModel {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "ELECTRONICARCHIVE_ID", unique = true, nullable = false, length = 36)
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

    @Column(name = "NAME")
    private String name;
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
    @Column(name = "SIZE", nullable = false)
    private Long size;

    @Column(name = "FILE_NAME")
    private String fileName;
    @Column(name = "FILE_LOCATION")
    private String fileLocation;

    @Column(name = "IS_FOLDER", length = 1, nullable = false)
    @Convert(converter = YesNoConverter.class)
    private Boolean isFolder;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ELECTRONICARCHIVEFOLDER_ID")
    private ElectronicArchive electronicArchiveFolder;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "electronicArchiveFolder")
    private List<ElectronicArchive> electronicArchiveList;

    @Transient
    private String fileBase64;
}
