package com.codenfast.developersuniverse.common.entity.schema;

import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/PaymentMethod


/**A payment method is a standardized procedure for transferring the monetary amount for a purchase. Payment methods are characterized by the legal and technical structures used, and by the organization or group carrying out the transaction.

Commonly used values:

http://purl.org/goodrelations/v1#ByBankTransferInAdvance
http://purl.org/goodrelations/v1#ByInvoice
http://purl.org/goodrelations/v1#Cash
http://purl.org/goodrelations/v1#CheckInAdvance
http://purl.org/goodrelations/v1#COD
http://purl.org/goodrelations/v1#DirectDebit
http://purl.org/goodrelations/v1#GoogleCheckout
http://purl.org/goodrelations/v1#PayPal
http://purl.org/goodrelations/v1#PaySwarm*/
public class PaymentMethod {
private String id;
private Boolean passive = Boolean.FALSE;
private LocalDateTime createTime = null;
private LocalDateTime updateTime = null;




}