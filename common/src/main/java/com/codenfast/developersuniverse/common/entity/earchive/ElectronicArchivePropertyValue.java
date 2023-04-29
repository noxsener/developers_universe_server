package com.codenfast.developersuniverse.common.entity.earchive;

import com.codenfast.developersuniverse.EntityModel;
import com.codenfast.developersuniverse.common.converter.YesNoConverter;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ELECTRONIC_ARCHIVE_PROPERTY_VALUE", indexes = {
        @Index(columnList = "ELECTRONICARCHIVEPROPERTY_ID,STRING_VALUE", name = "ix_electronicarchiveproperty_stringvalue"),
        @Index(columnList = "ELECTRONICARCHIVEPROPERTY_ID,NUMBER_VALUE", name = "ix_electronicarchiveproperty_numbervalue"),
        @Index(columnList = "ELECTRONICARCHIVEPROPERTY_ID,DATE_VALUE", name = "ix_electronicarchiveproperty_datevalue"),
}
)
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
public class ElectronicArchivePropertyValue implements EntityModel {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "ELECTRONICARCHIVEPROPERTYVALUE_ID", unique = true, nullable = false, length = 36)
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

    @Column(name = "STRING_VALUE", length = 4000)
    private String stringValue;

    @Column(name = "NUMBER_VALUE", precision = 19, scale = 4)
    private BigDecimal numberValue;

    @Column(name = "DATE_VALUE")
    private LocalDateTime dateValue;

    @Column(name = "BOOLEAN_VALUE")
    @Convert(converter = YesNoConverter.class)
    private Boolean booleanValue;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ELECTRONICARCHIVEPROPERTY_ID")
    private ElectronicArchiveProperty electronicArchiveProperty;
}
