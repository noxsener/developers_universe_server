package com.codenfast.developersuniverse.common.entity.schema;

import java.time.LocalDate;
import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/ParcelDelivery


/**The delivery of a parcel either via the postal service or a commercial service.*/
public class ParcelDelivery {
private String id;
private Boolean passive = Boolean.FALSE;
private LocalDateTime createTime = null;
private LocalDateTime updateTime = null;



/**
*Destination address.
*/
private PostalAddress deliveryAddress;

/**
*New entry added as the package passes through each leg of its journey (from shipment to final delivery).
*/
private DeliveryEvent deliveryStatus;

/**
*The earliest date the package may arrive.
*/
private LocalDate expectedArrivalFrom;

/**
*The latest date the package may arrive.
*/
private LocalDate expectedArrivalUntil;

/**
*Method used for delivery or shipping.
*/
private DeliveryMethod hasDeliveryMethod;

/**
*Item(s) being shipped.
*/
private Product itemShipped;

/**
*Shipper's address.
*/
private PostalAddress originAddress;

/**
*The overall order the items in this delivery were included in.
*/
private Order partOfOrder;

/**
*The service provider, service operator, or service performer; the goods producer. Another party (a seller) may offer those services or goods on behalf of the provider. A provider may also serve as the seller. Supersedes carrier.
*/
private java.util.List<Organization> carrier;

/**
*Shipper tracking number.
*/
private String trackingNumber;

/**
*Tracking url for the parcel delivery.
*/
private String trackingUrl;

/**
*An additional type for the item, typically used for adding more specific types from external vocabularies in microdata syntax. This is a relationship between something and a class that the thing is in. In RDFa syntax, it is better to use the native RDFa syntax - the 'typeof' attribute - for multiple types. Schema.org tools may have only weaker understanding of extra types, in particular those defined externally.
*/
private String additionalType;

/**
*An alias for the item.
*/
private String alternateName;

/**
*A description of the item.
*/
private String description;

/**
*A sub property of description. A short description of the item used to disambiguate from other, similar items. Information from other properties (in particular, name) may be necessary for the description to be useful for disambiguation.
*/
private String disambiguatingDescription;

/**
*The identifier property represents any kind of identifier for any kind of Thing, such as ISBNs, GTIN codes, UUIDs etc. Schema.org provides dedicated properties for representing many of these, either as textual strings or as URL (URI) links. See background notes for more details.
*/
private PropertyValue identifier;

/**
*An image of the item. This can be a URL or a fully described ImageObject.
*/
private ImageObject image;

/**
*Indicates a page (or other CreativeWork) for which this thing is the main entity being described. See background notes for details.
Inverse property: mainEntity
*/
private CreativeWork mainEntityOfPage;

/**
*The name of the item.
*/
private String name;

/**
*Indicates a potential Action, which describes an idealized action in which this thing would play an 'object' role.
*/
private Action potentialAction;

/**
*URL of a reference Web page that unambiguously indicates the item's identity. E.g. the URL of the item's Wikipedia page, Wikidata entry, or official website.
*/
private String sameAs;

/**
*A CreativeWork or Event about this Thing.
Inverse property: about
*/
private CreativeWork subjectOf;

/**
*URL of the item.
*/
private String url;

}