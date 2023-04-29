package com.codenfast.developersuniverse.entitydto.schema;

import com.codenfast.developersuniverse.EntityModel;

import java.time.LocalDate;
import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/TheaterGroup


/**A theater group or company, for example, the Royal Shakespeare Company or Druid Theatre.*/
public class TheaterGroup implements EntityModel {
private String id;
private Boolean passive = Boolean.FALSE;
private LocalDateTime createTime = null;
private LocalDateTime updateTime = null;



/**
*For a NewsMediaOrganization or other news-related Organization, a statement about public engagement activities (for news media, the newsroom’s), including involving the public - digitally or otherwise -- in coverage decisions, reporting and activities after publication.
*/
private CreativeWork actionableFeedbackPolicy;

/**
*Physical address of the item.
*/
private PostalAddress address;

/**
*The overall rating, based on a collection of reviews or ratings, of the item.
*/
private AggregateRating aggregateRating;

/**
*Alumni of an organization.
Inverse property: alumniOf
*/
private Person alumni;

/**
*The geographic area where a service or offered item is provided. Supersedes serviceArea.
*/
private java.util.List<AdministrativeArea> serviceArea;

/**
*An award won by or for this item. Supersedes awards.
*/
private String award;

/**
*The brand(s) associated with a product or service, or the brand(s) maintained by an organization or business person.
*/
private Brand brand;

/**
*A contact point for a person or organization. Supersedes contactPoints.
*/
private java.util.List<ContactPoint> contactPoints;

/**
*For an Organization (e.g. NewsMediaOrganization), a statement describing (in news media, the newsroom’s) disclosure and correction policy for errors.
*/
private CreativeWork correctionsPolicy;

/**
*A relationship between an organization and a department of that organization, also described as an organization (allowing different urls, logos, opening hours). For example: a store with a pharmacy, or a bakery with a cafe.
*/
private Organization department;

/**
*The date that this organization was dissolved.
*/
private LocalDate dissolutionDate;

/**
*Statement on diversity policy by an Organization e.g. a NewsMediaOrganization. For a NewsMediaOrganization, a statement describing the newsroom’s diversity policy on both staffing and sources, typically providing staffing data.
*/
private CreativeWork diversityPolicy;

/**
*For an Organization (often but not necessarily a NewsMediaOrganization), a report on staffing diversity issues. In a news context this might be for example ASNE or RTDNA (US) reports, or self-reported.
*/
private Article diversityStaffingReport;

/**
*The Dun & Bradstreet DUNS number for identifying an organization or business person.
*/
private String duns;

/**
*Email address.
*/
private String email;

/**
*Someone working for this organization. Supersedes employees.
*/
private java.util.List<Person> employees;

/**
*Statement about ethics policy, e.g. of a NewsMediaOrganization regarding journalistic and publishing practices, or of a Restaurant, a page describing food source policies. In the case of a NewsMediaOrganization, an ethicsPolicy is typically a statement describing the personal, organizational, and corporate standards of behavior expected by the organization.
*/
private CreativeWork ethicsPolicy;

/**
*Upcoming or past event associated with this place, organization, or action. Supersedes events.
*/
private java.util.List<Event> events;

/**
*The fax number.
*/
private String faxNumber;

/**
*A person who founded this organization. Supersedes founders.
*/
private java.util.List<Person> founders;

/**
*The date that this organization was founded.
*/
private LocalDate foundingDate;

/**
*The place where the Organization was founded.
*/
private Place foundingLocation;

/**
*A person or organization that supports (sponsors) something through some kind of financial contribution.
*/
private Organization funder;

/**
*A Grant that directly or indirectly provide funding or sponsorship for this item. See also ownershipFundingInfo.
Inverse property: fundedItem
*/
private Grant funding;

/**
*The Global Location Number (GLN, sometimes also referred to as International Location Number or ILN) of the respective organization, person, or place. The GLN is a 13-digit number used to identify parties and physical locations.
*/
private String globalLocationNumber;

/**
*A credential awarded to the Person or Organization.
*/
private EducationalOccupationalCredential hasCredential;

/**
*Specifies a MerchantReturnPolicy that may be applicable. Supersedes hasProductReturnPolicy.
*/
private java.util.List<MerchantReturnPolicy> hasProductReturnPolicy;

/**
*Indicates an OfferCatalog listing for this Organization, Person, or Service.
*/
private OfferCatalog hasOfferCatalog;

/**
*Points-of-Sales operated by the organization or person.
*/
private Place hasPOS;

/**
*The number of interactions for the CreativeWork using the WebSite or SoftwareApplication. The most specific child type of InteractionCounter should be used. Supersedes interactionCount.
*/
private java.util.List<InteractionCounter> interactionCount;

/**
*The International Standard of Industrial Classification of All Economic Activities (ISIC), Revision 4 code for a particular organization, business person, or place.
*/
private String isicV4;

/**
*An organization identifier as defined in ISO 6523(-1). Note that many existing organization identifiers such as leiCode, duns and vatID can be expressed as an ISO 6523 identifier by setting the ICD part of the ISO 6523 identifier accordingly.
*/
private String iso6523Code;

/**
*Keywords or tags used to describe some item. Multiple textual entries in a keywords list are typically delimited by commas, or by repeating the property.
*/
private DefinedTerm keywords;

/**
*Of a Person, and less typically of an Organization, to indicate a topic that is known about - suggesting possible expertise but not implying it. We do not distinguish skill levels here, or relate this to educational content, events, objectives or JobPosting descriptions.
*/
private String knowsAbout;

/**
*Of a Person, and less typically of an Organization, to indicate a known language. We do not distinguish skill levels or reading/writing/speaking/signing here. Use language codes from the IETF BCP 47 standard.
*/
private Language knowsLanguage;

/**
*The official name of the organization, e.g. the registered company name.
*/
private String legalName;

/**
*An organization identifier that uniquely identifies a legal entity as defined in ISO 17442.
*/
private String leiCode;

/**
*The location of, for example, where an event is happening, where an organization is located, or where an action takes place.
*/
private Place location;

/**
*An associated logo.
*/
private ImageObject logo;

/**
*A pointer to products or services offered by the organization or person.
Inverse property: offeredBy
*/
private Offer makesOffer;

/**
*A member of an Organization or a ProgramMembership. Organizations can be members of organizations; ProgramMembership is typically for individuals. Supersedes members, musicGroupMember.
Inverse property: memberOf
*/
private java.util.List<Organization> memberOf;

/**
*An Organization (or ProgramMembership) to which this Person or Organization belongs.
Inverse property: member
*/
/**
*The North American Industry Classification System (NAICS) code for a particular organization or business person.
*/
private String naics;

/**
*nonprofitStatus indicates the legal status of a non-profit organization in its primary place of business.
*/
private NonprofitType nonprofitStatus;

/**
*The number of employees in an organization, e.g. business.
*/
private QuantitativeValue numberOfEmployees;

/**
*For an Organization (often but not necessarily a NewsMediaOrganization), a description of organizational ownership structure; funding and grants. In a news/media setting, this is with particular reference to editorial independence. Note that the funder is also available and can be used to make basic funder information machine-readable.
*/
private AboutPage ownershipFundingInfo;

/**
*Products owned by the organization or person.
*/
private OwnershipInfo owns;

/**
*The larger organization that this organization is a subOrganization of, if any. Supersedes branchOf.
Inverse property: subOrganization
*/
private java.util.List<Organization> subOrganization;

/**
*The publishingPrinciples property indicates (typically via URL) a document describing the editorial principles of an Organization (or individual, e.g. a Person writing a blog) that relate to their activities as a publisher, e.g. ethics or diversity policies. When applied to a CreativeWork (e.g. NewsArticle) the principles are those of the party primarily responsible for the creation of the CreativeWork.

While such policies are most typically expressed in natural language, sometimes related information (e.g. indicating a funder) can be expressed using schema.org terminology.
*/
private CreativeWork publishingPrinciples;

/**
*A review of the item. Supersedes reviews.
*/
private java.util.List<Review> reviews;

/**
*A pointer to products or services sought by the organization or person (demand).
*/
private Demand seeks;

/**
*A slogan or motto associated with the item.
*/
private String slogan;

/**
*A person or organization that supports a thing through a pledge, promise, or financial contribution. E.g. a sponsor of a Medical Study or a corporate sponsor of an event.
*/
private Organization sponsor;

/**
*A relationship between two organizations where the first includes the second, e.g., as a subsidiary. See also: the more specific 'department' property.
Inverse property: parentOrganization
*/
/**
*The Tax / Fiscal ID of the organization or person, e.g. the TIN in the US or the CIF/NIF in Spain.
*/
private String taxID;

/**
*The telephone number.
*/
private String telephone;

/**
*For an Organization (typically a NewsMediaOrganization), a statement about policy on use of unnamed sources and the decision process required.
*/
private CreativeWork unnamedSourcesPolicy;

/**
*The Value-added Tax ID of the organization or person.
*/
private String vatID;

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