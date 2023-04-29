package com.codenfast.developersuniverse.entitydto.schema;

import com.codenfast.developersuniverse.EntityModel;

import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/DeliveryMethod


/**A delivery method is a standardized procedure for transferring the product or service to the destination of fulfillment chosen by the customer. Delivery methods are characterized by the means of transportation used, and by the organization or group that is the contracting party for the sending organization or person.

 Commonly used values:

 http://purl.org/goodrelations/v1#DeliveryModeDirectDownload
 http://purl.org/goodrelations/v1#DeliveryModeFreight
 http://purl.org/goodrelations/v1#DeliveryModeMail
 http://purl.org/goodrelations/v1#DeliveryModeOwnFleet
 http://purl.org/goodrelations/v1#DeliveryModePickUp
 http://purl.org/goodrelations/v1#DHL
 http://purl.org/goodrelations/v1#FederalExpress
 http://purl.org/goodrelations/v1#UPS*/
public class DeliveryMethod implements EntityModel {
                        private String id;
            private Boolean passive = Boolean.FALSE;
            private LocalDateTime createTime = null;
            private LocalDateTime updateTime = null;


        private String name;

}