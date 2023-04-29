package com.codenfast.developersuniverse.entitydto.schema;

import com.codenfast.developersuniverse.EntityModel;

import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/SizeSpecification


/**Size related properties of a product, typically a size code (name) and optionally a sizeSystem, sizeGroup, and product measurements (hasMeasurement). In addition, the intended audience can be defined through suggestedAge, suggestedGender, and suggested body measurements (suggestedMeasurement).*/
public class SizeSpecification implements EntityModel {
private String id;
private Boolean passive = Boolean.FALSE;
private LocalDateTime createTime = null;
private LocalDateTime updateTime = null;




}