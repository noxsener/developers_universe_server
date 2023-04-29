package com.codenfast.developersuniverse.common.entity.schema;

import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/ShippingRateSettings


/**A ShippingRateSettings represents re-usable pieces of shipping information. It is designed for publication on an URL that may be referenced via the shippingSettingsLink property of an OfferShippingDetails. Several occurrences can be published, distinguished and matched (i.e. identified/referenced) by their different values for shippingLabel.*/
public class ShippingRateSettings {
private String id;
private Boolean passive = Boolean.FALSE;
private LocalDateTime createTime = null;
private LocalDateTime updateTime = null;



/**
*Indicates when shipping to a particular shippingDestination is not available.
*/
private Boolean doesNotShip;

/**
*A monetary value above (or at) which the shipping rate becomes free. Intended to be used via an OfferShippingDetails with shippingSettingsLink matching this ShippingRateSettings.
*/
private DeliveryChargeSpecification freeShippingThreshold;

/**
*This can be marked 'true' to indicate that some published DeliveryTimeSettings or ShippingRateSettings are intended to apply to all OfferShippingDetails published by the same merchant, when referenced by a shippingSettingsLink in those settings. It is not meaningful to use a 'true' value for this property alongside a transitTimeLabel (for DeliveryTimeSettings) or shippingLabel (for ShippingRateSettings), since this property is for use with unlabelled settings.
*/
private Boolean isUnlabelledFallback;

/**
*indicates (possibly multiple) shipping destinations. These can be defined in several ways, e.g. postalCode ranges.
*/
private DefinedRegion shippingDestination;

/**
*Label to match an OfferShippingDetails with a ShippingRateSettings (within the context of a shippingSettingsLink cross-reference).
*/
private String shippingLabel;

/**
*The shipping rate is the cost of shipping to the specified destination. Typically, the maxValue and currency values (of the MonetaryAmount) are most appropriate.
*/
private MonetaryAmount shippingRate;

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