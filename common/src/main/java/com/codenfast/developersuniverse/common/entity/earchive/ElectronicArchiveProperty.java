package com.codenfast.developersuniverse.common.entity.earchive;

import com.codenfast.developersuniverse.EntityModel;
import com.codenfast.developersuniverse.common.converter.YesNoConverter;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "ELECTRONIC_ARCHIVE_PROPERTY", indexes = {
        @Index(columnList = "NAME", name = "ix_electronicarchiveproperty_name"),
        @Index(columnList = "DESCRIPTION", name = "ix_electronicarchiveproperty_description"),
}
)
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
public class ElectronicArchiveProperty implements EntityModel {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "ELECTRONICARCHIVEPROPERTY_ID", unique = true, nullable = false, length = 36)
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

    @Column(name = "NAME", length = 500)
    private String name;

    @Column(name = "DESCRIPTION", length = 4000)
    private String description;

    @Column(name = "VALUE_TYPE")
    private String valueType;
}
