package com.codenfast.developersuniverse.entitydto.schema;

import com.codenfast.developersuniverse.EntityModel;

import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/BusinessFunction


/**The business function specifies the type of activity or access (i.e., the bundle of rights) offered by the organization or business person through the offer. Typical are sell, rental or lease, maintenance or repair, manufacture / produce, recycle / dispose, engineering / construction, or installation. Proprietary specifications of access rights are also instances of this class.

 Commonly used values:

 http://purl.org/goodrelations/v1#ConstructionInstallation
 http://purl.org/goodrelations/v1#Dispose
 http://purl.org/goodrelations/v1#LeaseOut
 http://purl.org/goodrelations/v1#Maintain
 http://purl.org/goodrelations/v1#ProvideService
 http://purl.org/goodrelations/v1#Repair
 http://purl.org/goodrelations/v1#Sell
 http://purl.org/goodrelations/v1#Buy*/
public class BusinessFunction implements EntityModel {
                        private String id;
            private Boolean passive = Boolean.FALSE;
            private LocalDateTime createTime = null;
            private LocalDateTime updateTime = null;


        private String name;

}