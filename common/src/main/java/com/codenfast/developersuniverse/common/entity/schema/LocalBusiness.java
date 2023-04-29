package com.codenfast.developersuniverse.common.entity.schema;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/LocalBusiness


/**A particular physical business or branch of an organization. Examples of LocalBusiness include a restaurant, a particular branch of a restaurant chain, a branch of a bank, a medical practice, a club, a bowling alley, etc.*/
public class LocalBusiness {
                        private String id;
            private Boolean passive = Boolean.FALSE;
            private LocalDateTime createTime = null;
            private LocalDateTime updateTime = null;


    /**
     * The currency accepted.
     * <p>
     * Use standard formats: ISO 4217 currency format, e.g. "USD"; Ticker symbol for cryptocurrencies, e.g. "BTC"; well known names for Local Exchange Trading Systems (LETS) and other currency types, e.g. "Ithaca HOUR".
     */
        private String currenciesAccepted;

    /**
     * The general opening hours for a business. Opening hours can be specified as a weekly time range, starting with days, then times per day. Multiple days can be listed with commas ',' separating each day. Day or time ranges are specified using a hyphen '-'.
     * <p>
     * Days are specified using the following two-letter combinations: Mo, Tu, We, Th, Fr, Sa, Su.
     * Times are specified using 24:00 format. For example, 3pm is specified as 15:00, 10am as 10:00.
     * Here is an example: <time itemprop="openingHours" datetime="Tu,Th 16:00-20:00">Tuesdays and Thursdays 4-8pm</time>.
     * If a business is open 7 days a week, then it can be specified as <time itemprop="openingHours" datetime="Mo-Su">Monday through Sunday, all day</time>.
     */
        private String openingHours;

    /**
     * Cash, Credit Card, Cryptocurrency, Local Exchange Tradings System, etc.
     */
        private String paymentAccepted;

    /**
     * The price range of the business, for example $$$.
     */
        private String priceRange;

    /**
     * For a NewsMediaOrganization or other news-related Organization, a statement about public engagement activities (for news media, the newsroom’s), including involving the public - digitally or otherwise -- in coverage decisions, reporting and activities after publication.
     */
            private CreativeWork actionableFeedbackPolicy;

    /**
     * Physical address of the item.
     */
            private PostalAddress address;

    /**
     * The overall rating, based on a collection of reviews or ratings, of the item.
     */
            private AggregateRating aggregateRating;

    /**
     * Alumni of an organization.
     * Inverse property: alumniOf
     */
            private Person alumni;

    /**
     * The geographic area where a service or offered item is provided. Supersedes serviceArea.
     */
        private java.util.List<AdministrativeArea> serviceArea;

    /**
     * An award won by or for this item. Supersedes awards.
     */
        private String award;

    /**
     * The brand(s) associated with a product or service, or the brand(s) maintained by an organization or business person.
     */
            private Brand brand;

    /**
     * A contact point for a person or organization. Supersedes contactPoints.
     */
        private java.util.List<ContactPoint> contactPoints;

    /**
     * For an Organization (e.g. NewsMediaOrganization), a statement describing (in news media, the newsroom’s) disclosure and correction policy for errors.
     */
            private CreativeWork correctionsPolicy;

    /**
     * A relationship between an organization and a department of that organization, also described as an organization (allowing different urls, logos, opening hours). For example: a store with a pharmacy, or a bakery with a cafe.
     */
            private Organization department;

    /**
     * The date that this organization was dissolved.
     */
        private LocalDate dissolutionDate;

    /**
     * Statement on diversity policy by an Organization e.g. a NewsMediaOrganization. For a NewsMediaOrganization, a statement describing the newsroom’s diversity policy on both staffing and sources, typically providing staffing data.
     */
            private CreativeWork diversityPolicy;

    /**
     * For an Organization (often but not necessarily a NewsMediaOrganization), a report on staffing diversity issues. In a news context this might be for example ASNE or RTDNA (US) reports, or self-reported.
     */
            private Article diversityStaffingReport;

    /**
     * The Dun & Bradstreet DUNS number for identifying an organization or business person.
     */
        private String duns;

    /**
     * Email address.
     */
        private String email;

    /**
     * Someone working for this organization. Supersedes employees.
     */
        private java.util.List<Person> employees;

    /**
     * Statement about ethics policy, e.g. of a NewsMediaOrganization regarding journalistic and publishing practices, or of a Restaurant, a page describing food source policies. In the case of a NewsMediaOrganization, an ethicsPolicy is typically a statement describing the personal, organizational, and corporate standards of behavior expected by the organization.
     */
            private CreativeWork ethicsPolicy;

    /**
     * Upcoming or past event associated with this place, organization, or action. Supersedes events.
     */
        private java.util.List<Event> events;

    /**
     * The fax number.
     */
        private String faxNumber;

    /**
     * A person who founded this organization. Supersedes founders.
     */
        private java.util.List<Person> founders;

    /**
     * The date that this organization was founded.
     */
        private LocalDate foundingDate;

    /**
     * The place where the Organization was founded.
     */
            private Place foundingLocation;

    /**
     * A person or organization that supports (sponsors) something through some kind of financial contribution.
     */
            private Organization funder;

    /**
     * A Grant that directly or indirectly provide funding or sponsorship for this item. See also ownershipFundingInfo.
     * Inverse property: fundedItem
     */
            private Grant funding;

    /**
     * The Global Location Number (GLN, sometimes also referred to as International Location Number or ILN) of the respective organization, person, or place. The GLN is a 13-digit number used to identify parties and physical locations.
     */
        private String globalLocationNumber;

    /**
     * A credential awarded to the Person or Organization.
     */
            private EducationalOccupationalCredential hasCredential;

    /**
     * Specifies a MerchantReturnPolicy that may be applicable. Supersedes hasProductReturnPolicy.
     */
        private java.util.List<MerchantReturnPolicy> hasProductReturnPolicy;

    /**
     * Indicates an OfferCatalog listing for this Organization, Person, or Service.
     */
            private OfferCatalog hasOfferCatalog;

    /**
     * Points-of-Sales operated by the organization or person.
     */
            private Place hasPOS;

    /**
     * The number of interactions for the CreativeWork using the WebSite or SoftwareApplication. The most specific child type of InteractionCounter should be used. Supersedes interactionCount.
     */
        private java.util.List<InteractionCounter> interactionCount;

    /**
     * The International Standard of Industrial Classification of All Economic Activities (ISIC), Revision 4 code for a particular organization, business person, or place.
     */
        private String isicV4;

    /**
     * An organization identifier as defined in ISO 6523(-1). Note that many existing organization identifiers such as leiCode, duns and vatID can be expressed as an ISO 6523 identifier by setting the ICD part of the ISO 6523 identifier accordingly.
     */
        private String iso6523Code;

    /**
     * Keywords or tags used to describe some item. Multiple textual entries in a keywords list are typically delimited by commas, or by repeating the property.
     */
            private DefinedTerm keywords;

    /**
     * Of a Person, and less typically of an Organization, to indicate a topic that is known about - suggesting possible expertise but not implying it. We do not distinguish skill levels here, or relate this to educational content, events, objectives or JobPosting descriptions.
     */
        private String knowsAbout;

    /**
     * Of a Person, and less typically of an Organization, to indicate a known language. We do not distinguish skill levels or reading/writing/speaking/signing here. Use language codes from the IETF BCP 47 standard.
     */
            private Language knowsLanguage;

    /**
     * The official name of the organization, e.g. the registered company name.
     */
        private String legalName;

    /**
     * An organization identifier that uniquely identifies a legal entity as defined in ISO 17442.
     */
        private String leiCode;

    /**
     * The location of, for example, where an event is happening, where an organization is located, or where an action takes place.
     */
            private Place location;

    /**
     * An associated logo.
     */
            private ImageObject logo;

    /**
     * A pointer to products or services offered by the organization or person.
     * Inverse property: offeredBy
     */
            private Offer makesOffer;

    /**
     * A member of an Organization or a ProgramMembership. Organizations can be members of organizations; ProgramMembership is typically for individuals. Supersedes members, musicGroupMember.
     * Inverse property: memberOf
     */
        private java.util.List<Organization> memberOf;

/**
 *An Organization (or ProgramMembership) to which this Person or Organization belongs.
 Inverse property: member
 */
    /**
     * The North American Industry Classification System (NAICS) code for a particular organization or business person.
     */
        private String naics;

    /**
     * nonprofitStatus indicates the legal status of a non-profit organization in its primary place of business.
     */
            private NonprofitType nonprofitStatus;

    /**
     * The number of employees in an organization, e.g. business.
     */
            private QuantitativeValue numberOfEmployees;

    /**
     * For an Organization (often but not necessarily a NewsMediaOrganization), a description of organizational ownership structure; funding and grants. In a news/media setting, this is with particular reference to editorial independence. Note that the funder is also available and can be used to make basic funder information machine-readable.
     */
            private AboutPage ownershipFundingInfo;

    /**
     * Products owned by the organization or person.
     */
            private OwnershipInfo owns;

    /**
     * The larger organization that this organization is a subOrganization of, if any. Supersedes branchOf.
     * Inverse property: subOrganization
     */
        private java.util.List<Organization> subOrganization;

    /**
     * The publishingPrinciples property indicates (typically via URL) a document describing the editorial principles of an Organization (or individual, e.g. a Person writing a blog) that relate to their activities as a publisher, e.g. ethics or diversity policies. When applied to a CreativeWork (e.g. NewsArticle) the principles are those of the party primarily responsible for the creation of the CreativeWork.
     * <p>
     * While such policies are most typically expressed in natural language, sometimes related information (e.g. indicating a funder) can be expressed using schema.org terminology.
     */
            private CreativeWork publishingPrinciples;

    /**
     * A review of the item. Supersedes reviews.
     */
        private java.util.List<Review> reviews;

    /**
     * A pointer to products or services sought by the organization or person (demand).
     */
            private Demand seeks;

    /**
     * A slogan or motto associated with the item.
     */
        private String slogan;

    /**
     * A person or organization that supports a thing through a pledge, promise, or financial contribution. E.g. a sponsor of a Medical Study or a corporate sponsor of an event.
     */
            private Organization sponsor;

/**
 *A relationship between two organizations where the first includes the second, e.g., as a subsidiary. See also: the more specific 'department' property.
 Inverse property: parentOrganization
 */
    /**
     * The Tax / Fiscal ID of the organization or person, e.g. the TIN in the US or the CIF/NIF in Spain.
     */
        private String taxID;

    /**
     * The telephone number.
     */
        private String telephone;

    /**
     * For an Organization (typically a NewsMediaOrganization), a statement about policy on use of unnamed sources and the decision process required.
     */
            private CreativeWork unnamedSourcesPolicy;

    /**
     * The Value-added Tax ID of the organization or person.
     */
        private String vatID;

    /**
     * A property-value pair representing an additional characteristic of the entity, e.g. a product feature or another characteristic for which there is no matching property in schema.org.
     * <p>
     * Note: Publishers should be aware that applications designed to use specific schema.org properties (e.g. https://schema.org/width, https://schema.org/color, https://schema.org/gtin13, ...) will typically expect such data to be provided using those properties, rather than using the generic property/value mechanism.
     */
            private PropertyValue additionalProperty;

/**
 *Physical address of the item.
 */
/**
 *The overall rating, based on a collection of reviews or ratings, of the item.
 */
    /**
     * An amenity feature (e.g. a characteristic or service) of the Accommodation. This generic property does not make a statement about whether the feature is included in an offer for the main accommodation or available at extra costs.
     */
            private LocationFeatureSpecification amenityFeature;

    /**
     * A short textual code (also called "store code") that uniquely identifies a place of business. The code is typically assigned by the parentOrganization and used in structured URLs.
     * <p>
     * For example, in the URL http://www.starbucks.co.uk/store-locator/etc/detail/3047 the code "3047" is a branchCode for a particular branch.
     */
        private String branchCode;

    /**
     * The basic containment relation between a place and one that contains it. Supersedes containedIn.
     * Inverse property: containsPlace
     */
        private java.util.List<Place> containsPlace;

/**
 *The basic containment relation between a place and another that it contains.
 Inverse property: containedInPlace
 */
/**
 *Upcoming or past event associated with this place, organization, or action. Supersedes events.
 */
/**
 *The fax number.
 */
    /**
     * The geo coordinates of the place.
     */
            private GeoCoordinates geo;

    /**
     * Represents a relationship between two geometries (or the places they represent), relating a containing geometry to a contained geometry. "a contains b iff no points of b lie in the exterior of a, and at least one point of the interior of b lies in the interior of a". As defined in DE-9IM.
     */
            private GeospatialGeometry geoContains;

    /**
     * Represents a relationship between two geometries (or the places they represent), relating a geometry to another that covers it. As defined in DE-9IM.
     */
            private GeospatialGeometry geoCoveredBy;

    /**
     * Represents a relationship between two geometries (or the places they represent), relating a covering geometry to a covered geometry. "Every point of b is a point of (the interior or boundary of) a". As defined in DE-9IM.
     */
            private GeospatialGeometry geoCovers;

    /**
     * Represents a relationship between two geometries (or the places they represent), relating a geometry to another that crosses it: "a crosses b: they have some but not all interior points in common, and the dimension of the intersection is less than that of at least one of them". As defined in DE-9IM.
     */
            private GeospatialGeometry geoCrosses;

    /**
     * Represents spatial relations in which two geometries (or the places they represent) are topologically disjoint: "they have no point in common. They form a set of disconnected geometries." (A symmetric relationship, as defined in DE-9IM.)
     */
            private GeospatialGeometry geoDisjoint;

    /**
     * Represents spatial relations in which two geometries (or the places they represent) are topologically equal, as defined in DE-9IM. "Two geometries are topologically equal if their interiors intersect and no part of the interior or boundary of one geometry intersects the exterior of the other" (a symmetric relationship).
     */
            private GeospatialGeometry geoEquals;

    /**
     * Represents spatial relations in which two geometries (or the places they represent) have at least one point in common. As defined in DE-9IM.
     */
            private GeospatialGeometry geoIntersects;

    /**
     * Represents a relationship between two geometries (or the places they represent), relating a geometry to another that geospatially overlaps it, i.e. they have some but not all points in common. As defined in DE-9IM.
     */
            private GeospatialGeometry geoOverlaps;

    /**
     * Represents spatial relations in which two geometries (or the places they represent) touch: "they have at least one boundary point in common, but no interior points." (A symmetric relationship, as defined in DE-9IM.)
     */
            private GeospatialGeometry geoTouches;

    /**
     * Represents a relationship between two geometries (or the places they represent), relating a geometry to one that contains it, i.e. it is inside (i.e. within) its interior. As defined in DE-9IM.
     */
            private GeospatialGeometry geoWithin;

/**
 *The Global Location Number (GLN, sometimes also referred to as International Location Number or ILN) of the respective organization, person, or place. The GLN is a 13-digit number used to identify parties and physical locations.
 */
    /**
     * Indicates whether some facility (e.g. FoodEstablishment, CovidTestingFacility) offers a service that can be used by driving through in a car. In the case of CovidTestingFacility such facilities could potentially help with social distancing from other potentially-infected users.
     */
            private Boolean hasDriveThroughService;

    /**
     * A URL to a map of the place. Supersedes map, maps.
     */
        private java.util.List<Map> maps;

    /**
     * A flag to signal that the item, event, or place is accessible for free. Supersedes free.
     */
            private Boolean isAccessibleForFree;

/**
 *The International Standard of Industrial Classification of All Economic Activities (ISIC), Revision 4 code for a particular organization, business person, or place.
 */
/**
 *Keywords or tags used to describe some item. Multiple textual entries in a keywords list are typically delimited by commas, or by repeating the property.
 */
    /**
     * The latitude of a location. For example 37.42242 (WGS 84).
     */
        private BigDecimal latitude;

/**
 *An associated logo.
 */
    /**
     * The longitude of a location. For example -122.08585 (WGS 84).
     */
        private BigDecimal longitude;

    /**
     * The total number of individuals that may attend an event or venue.
     */
        private String maximumAttendeeCapacity;

    /**
     * The opening hours of a certain place.
     */
            private OpeningHoursSpecification openingHoursSpecification;

    /**
     * A photograph of this place. Supersedes photos.
     */
        private java.util.List<ImageObject> photos;

    /**
     * A flag to signal that the Place is open to public visitors. If this property is omitted there is no assumed default boolean value
     */
            private Boolean publicAccess;

/**
 *A review of the item. Supersedes reviews.
 */
/**
 *A slogan or motto associated with the item.
 */
    /**
     * Indicates whether it is allowed to smoke in the place, e.g. in the restaurant, hotel or hotel room.
     */
            private Boolean smokingAllowed;

    /**
     * The special opening hours of a certain place.
     * <p>
     * Use this to explicitly override general opening hours brought in scope by openingHoursSpecification or openingHours.
     */
            private OpeningHoursSpecification specialOpeningHoursSpecification;

/**
 *The telephone number.
 */
    /**
     * A page providing information on how to book a tour of some Place, such as an Accommodation or ApartmentComplex in a real estate setting, as well as other kinds of tours as appropriate.
     */
        private String tourBookingPage;

    /**
     * An additional type for the item, typically used for adding more specific types from external vocabularies in microdata syntax. This is a relationship between something and a class that the thing is in. In RDFa syntax, it is better to use the native RDFa syntax - the 'typeof' attribute - for multiple types. Schema.org tools may have only weaker understanding of extra types, in particular those defined externally.
     */
        private String additionalType;

    /**
     * An alias for the item.
     */
        private String alternateName;

    /**
     * A description of the item.
     */
        private String description;

    /**
     * A sub property of description. A short description of the item used to disambiguate from other, similar items. Information from other properties (in particular, name) may be necessary for the description to be useful for disambiguation.
     */
        private String disambiguatingDescription;

    /**
     * The identifier property represents any kind of identifier for any kind of Thing, such as ISBNs, GTIN codes, UUIDs etc. Schema.org provides dedicated properties for representing many of these, either as textual strings or as URL (URI) links. See background notes for more details.
     */
            private PropertyValue identifier;

    /**
     * An image of the item. This can be a URL or a fully described ImageObject.
     */
            private ImageObject image;

    /**
     * Indicates a page (or other CreativeWork) for which this thing is the main entity being described. See background notes for details.
     * Inverse property: mainEntity
     */
            private CreativeWork mainEntityOfPage;

    /**
     * The name of the item.
     */
        private String name;

    /**
     * Indicates a potential Action, which describes an idealized action in which this thing would play an 'object' role.
     */
            private Action potentialAction;

    /**
     * URL of a reference Web page that unambiguously indicates the item's identity. E.g. the URL of the item's Wikipedia page, Wikidata entry, or official website.
     */
        private String sameAs;

    /**
     * A CreativeWork or Event about this Thing.
     * Inverse property: about
     */
            private CreativeWork subjectOf;

    /**
     * URL of the item.
     */
        private String url;

}