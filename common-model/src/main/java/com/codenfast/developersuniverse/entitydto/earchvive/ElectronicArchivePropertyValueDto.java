package com.codenfast.developersuniverse.entitydto.earchvive;

import com.codenfast.developersuniverse.EntityModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
public class ElectronicArchivePropertyValueDto implements EntityModel {

    private String id;
    private Boolean passive = Boolean.FALSE;
    private LocalDateTime createTime = null;
    private LocalDateTime updateTime = null;
    private String stringValue;
    private BigDecimal numberValue;
    private LocalDateTime dateValue;
    private Boolean booleanValue;
    private ElectronicArchivePropertyDto electronicArchivePropertyDto;
}
