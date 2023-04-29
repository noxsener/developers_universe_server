package com.codenfast.developersuniverse.common.entity.schema;

import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/CreditCard


/**A card payment method of a particular brand or name. Used to mark up a particular payment method and/or the financial product/service that supplies the card account.

 Commonly used values:

 http://purl.org/goodrelations/v1#AmericanExpress
 http://purl.org/goodrelations/v1#DinersClub
 http://purl.org/goodrelations/v1#Discover
 http://purl.org/goodrelations/v1#JCB
 http://purl.org/goodrelations/v1#MasterCard
 http://purl.org/goodrelations/v1#VISA*/
public class CreditCard {
                        private String id;
            private Boolean passive = Boolean.FALSE;
            private LocalDateTime createTime = null;
            private LocalDateTime updateTime = null;


        private String name;

}