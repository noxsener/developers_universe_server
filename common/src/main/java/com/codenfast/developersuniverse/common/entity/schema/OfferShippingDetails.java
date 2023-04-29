package com.codenfast.developersuniverse.common.entity.schema;

import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/OfferShippingDetails


/**OfferShippingDetails represents information about shipping destinations.

Multiple of these entities can be used to represent different shipping rates for different destinations:

One entity for Alaska/Hawaii. A different one for continental US. A different one for all France.

Multiple of these entities can be used to represent different shipping costs and delivery times.

Two entities that are identical but differ in rate and time:

E.g. Cheaper and slower: $5 in 5-7 days or Fast and expensive: $15 in 1-2 days.*/
public class OfferShippingDetails {
private String id;
private Boolean passive = Boolean.FALSE;
private LocalDateTime createTime = null;
private LocalDateTime updateTime = null;



/**
*The total delay between the receipt of the order and the goods reaching the final customer.
*/
private ShippingDeliveryTime deliveryTime;

/**
*The depth of the item.
*/
private Distance depth;

/**
*Indicates when shipping to a particular shippingDestination is not available.
*/
private Boolean doesNotShip;

/**
*The height of the item.
*/
private Distance height;

/**
*indicates (possibly multiple) shipping destinations. These can be defined in several ways, e.g. postalCode ranges.
*/
private DefinedRegion shippingDestination;

/**
*Label to match an OfferShippingDetails with a ShippingRateSettings (within the context of a shippingSettingsLink cross-reference).
*/
private String shippingLabel;

/**
*Indicates the origin of a shipment, i.e. where it should be coming from.
*/
private DefinedRegion shippingOrigin;

/**
*The shipping rate is the cost of shipping to the specified destination. Typically, the maxValue and currency values (of the MonetaryAmount) are most appropriate.
*/
private MonetaryAmount shippingRate;

/**
*Link to a page containing ShippingRateSettings and DeliveryTimeSettings details.
*/
private String shippingSettingsLink;

/**
*Label to match an OfferShippingDetails with a DeliveryTimeSettings (within the context of a shippingSettingsLink cross-reference).
*/
private String transitTimeLabel;

/**
*The weight of the product or person.
*/
private QuantitativeValue weight;

/**
*The width of the item.
*/
private Distance width;

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