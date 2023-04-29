package com.codenfast.developersuniverse.entitydto.schema;

import com.codenfast.developersuniverse.EntityModel;

import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/PostalAddress


/**The mailing address.*/
public class PostalAddress implements EntityModel {
private String id;
private Boolean passive = Boolean.FALSE;
private LocalDateTime createTime = null;
private LocalDateTime updateTime = null;



/**
*The country. For example, USA. You can also provide the two-letter ISO 3166-1 alpha-2 country code.
*/
private Country addressCountry;

/**
*The locality in which the street address is, and which is in the region. For example, Mountain View.
*/
private String addressLocality;

/**
*The region in which the locality is, and which is in the country. For example, California or another appropriate first-level Administrative division.
*/
private String addressRegion;

/**
*The post office box number for PO box addresses.
*/
private String postOfficeBoxNumber;

/**
*The postal code. For example, 94043.
*/
private String postalCode;

/**
*The street address. For example, 1600 Amphitheatre Pkwy.
*/
private String streetAddress;

/**
*The geographic area where a service or offered item is provided. Supersedes serviceArea.
*/
private java.util.List<AdministrativeArea> serviceArea;

/**
*A language someone may use with or at the item, service or place. Please use one of the language codes from the IETF BCP 47 standard. See also inLanguage.
*/
private Language availableLanguage;

/**
*An option available on this contact point (e.g. a toll-free number or support for hearing-impaired callers).
*/
private ContactPointOption contactOption;

/**
*A person or organization can have different contact points, for different purposes. For example, a sales contact point, a PR contact point and so on. This property is used to specify the kind of contact point.
*/
private String contactType;

/**
*Email address.
*/
private String email;

/**
*The fax number.
*/
private String faxNumber;

/**
*The hours during which this service or contact is available.
*/
private OpeningHoursSpecification hoursAvailable;

/**
*The product or service this support contact point is related to (such as product support for a particular product line). This can be a specific product or product line (e.g. "iPhone") or a general category of products or services (e.g. "smartphones").
*/
private Product productSupported;

/**
*The telephone number.
*/
private String telephone;

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