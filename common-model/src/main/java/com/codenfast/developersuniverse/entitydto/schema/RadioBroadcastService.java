package com.codenfast.developersuniverse.entitydto.schema;

import com.codenfast.developersuniverse.EntityModel;

import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/RadioBroadcastService


/**A delivery service through which radio content is provided via broadcast over the air or online.*/
public class RadioBroadcastService implements EntityModel {
private String id;
private Boolean passive = Boolean.FALSE;
private LocalDateTime createTime = null;
private LocalDateTime updateTime = null;



/**
*The media network(s) whose content is broadcast on this station.
*/
private Organization broadcastAffiliateOf;

/**
*The name displayed in the channel guide. For many US affiliates, it is the network name.
*/
private String broadcastDisplayName;

/**
*The frequency used for over-the-air broadcasts. Numeric values or simple ranges, e.g. 87-99. In addition a shortcut idiom is supported for frequences of AM and FM radio channels, e.g. "87 FM".
*/
private BroadcastFrequencySpecification broadcastFrequency;

/**
*The timezone in ISO 8601 format for which the service bases its broadcasts.
*/
private String broadcastTimezone;

/**
*The organization owning or operating the broadcast service.
*/
private Organization broadcaster;

/**
*A callsign, as used in broadcasting and radio communications to identify people, radio and TV stations, or vehicles.
*/
private String callSign;

/**
*A broadcast channel of a broadcast service.
Inverse property: providesBroadcastService
*/
private BroadcastChannel hasBroadcastChannel;

/**
*The language of the content or performance or used in an action. Please use one of the language codes from the IETF BCP 47 standard. See also availableLanguage. Supersedes language.
*/
private java.util.List<Language> language;

/**
*A broadcast service to which the broadcast service may belong to such as regional variations of a national channel.
*/
private BroadcastService parentService;

/**
*The type of screening or video broadcast used (e.g. IMAX, 3D, SD, HD, etc.).
*/
private String videoFormat;

/**
*The overall rating, based on a collection of reviews or ratings, of the item.
*/
private AggregateRating aggregateRating;

/**
*The geographic area where a service or offered item is provided. Supersedes serviceArea.
*/
private java.util.List<AdministrativeArea> serviceArea;

/**
*An intended audience, i.e. a group for whom something was created. Supersedes serviceAudience.
*/
private java.util.List<Audience> serviceAudience;

/**
*A means of accessing the service (e.g. a phone bank, a web site, a location, etc.).
*/
private ServiceChannel availableChannel;

/**
*An award won by or for this item. Supersedes awards.
*/
private String award;

/**
*The brand(s) associated with a product or service, or the brand(s) maintained by an organization or business person.
*/
private Brand brand;

/**
*An entity that arranges for an exchange between a buyer and a seller. In most cases a broker never acquires or releases ownership of a product or service involved in an exchange. If it is not clear whether an entity is a broker, seller, or buyer, the latter two terms are preferred. Supersedes bookingAgent.
*/
private java.util.List<Organization> bookingAgent;

/**
*A category for the item. Greater signs or slashes can be used to informally indicate a category hierarchy.
*/
private CategoryCode category;

/**
*Indicates an OfferCatalog listing for this Organization, Person, or Service.
*/
private OfferCatalog hasOfferCatalog;

/**
*The hours during which this service or contact is available.
*/
private OpeningHoursSpecification hoursAvailable;

/**
*A pointer to another, somehow related product (or multiple products).
*/
private Product isRelatedTo;

/**
*A pointer to another, functionally similar product (or multiple products).
*/
private Product isSimilarTo;

/**
*An associated logo.
*/
private ImageObject logo;

/**
*An offer to provide this item—for example, an offer to sell a product, rent the DVD of a movie, perform a service, or give away tickets to an event. Use businessFunction to indicate the kind of transaction offered, i.e. sell, lease, etc. This property can also be used to describe a Demand. While this property is listed as expected on a number of common types, it can be used in others. In that case, using a second type, such as Product or a subtype of Product, can clarify the nature of the offer.
Inverse property: itemOffered
*/
private Demand offers;

/**
*The service provider, service operator, or service performer; the goods producer. Another party (a seller) may offer those services or goods on behalf of the provider. A provider may also serve as the seller. Supersedes carrier.
*/
private java.util.List<Organization> carrier;

/**
*Indicates the mobility of a provided service (e.g. 'static', 'dynamic').
*/
private String providerMobility;

/**
*A review of the item. Supersedes reviews.
*/
private java.util.List<Review> reviews;

/**
*The tangible thing generated by the service, e.g. a passport, permit, etc. Supersedes produces.
*/
private java.util.List<Thing> produces;

/**
*The type of service being offered, e.g. veterans' benefits, emergency relief, etc.
*/
private GovernmentBenefitsType serviceType;

/**
*A slogan or motto associated with the item.
*/
private String slogan;

/**
*Human-readable terms of service documentation.
*/
private String termsOfService;

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