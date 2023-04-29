package com.codenfast.developersuniverse.common.entity.schema;

import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/WarrantyScope


/**A range of services that will be provided to a customer free of charge in case of a defect or malfunction of a product.

Commonly used values:

http://purl.org/goodrelations/v1#Labor-BringIn
http://purl.org/goodrelations/v1#PartsAndLabor-BringIn
http://purl.org/goodrelations/v1#PartsAndLabor-PickUp*/
public class WarrantyScope {
private String id;
private Boolean passive = Boolean.FALSE;
private LocalDateTime createTime = null;
private LocalDateTime updateTime = null;




}