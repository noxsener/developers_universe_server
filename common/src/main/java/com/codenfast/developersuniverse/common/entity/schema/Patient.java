package com.codenfast.developersuniverse.common.entity.schema;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/Patient


/**A patient is any person recipient of health care services.*/
public class Patient {
                        private String id;
            private Boolean passive = Boolean.FALSE;
            private LocalDateTime createTime = null;
            private LocalDateTime updateTime = null;

/**
 *Specifying the health condition(s) of a patient, medical study, or other target audience.
 */
    /**
     * Audiences defined by a person's gender.
     */
        private String requiredGender;

    /**
     * Audiences defined by a person's maximum age.
     */
        private String requiredMaxAge;

    /**
     * Audiences defined by a person's minimum age.
     */
        private String requiredMinAge;

    /**
     * The age or age range for the intended audience or person, for example 3-12 months for infants, 1-5 years for toddlers.
     */
            private QuantitativeValue suggestedAge;

    /**
     * The suggested gender of the intended person or audience, for example "male", "female", or "unisex".
     */
            private GenderType suggestedGender;

    /**
     * Maximum recommended age in years for the audience or user.
     */
        private BigDecimal suggestedMaxAge;

    /**
     * A suggested range of body measurements for the intended audience or person, for example inseam between 32 and 34 inches or height between 170 and 190 cm. Typically found on a size chart for wearable products.
     */
            private QuantitativeValue suggestedMeasurement;

    /**
     * Minimum recommended age in years for the audience or user.
     */
        private BigDecimal suggestedMinAge;

    /**
     * The target group associated with a given audience (e.g. veterans, car owners, musicians, etc.).
     */
        private String audienceType;

    /**
     * The geographic area associated with the audience.
     */
            private AdministrativeArea geographicArea;

    /**
     * An additional name for a Person, can be used for a middle name.
     */
        private String additionalName;

    /**
     * Physical address of the item.
     */
            private PostalAddress address;

    /**
     * An organization that this person is affiliated with. For example, a school/university, a club, or a team.
     */
            private Organization affiliation;

    /**
     * An organization that the person is an alumni of.
     * Inverse property: alumni
     */
            private EducationalOrganization alumniOf;

    /**
     * An award won by or for this item. Supersedes awards.
     */
        private String award;

    /**
     * Date of birth.
     */
        private LocalDate birthDate;

    /**
     * The place where the person was born.
     */
            private Place birthPlace;

    /**
     * The brand(s) associated with a product or service, or the brand(s) maintained by an organization or business person.
     */
            private Brand brand;

    /**
     * A callsign, as used in broadcasting and radio communications to identify people, radio and TV stations, or vehicles.
     */
        private String callSign;

    /**
     * A child of the person.
     */
            private Person children;

    /**
     * A colleague of the person. Supersedes colleagues.
     */
    private java.util.List<Person> colleagues;

    /**
     * A contact point for a person or organization. Supersedes contactPoints.
     */
    private java.util.List<ContactPoint> contactPoints;

    /**
     * Date of death.
     */
        private LocalDate deathDate;

    /**
     * The place where the person died.
     */
            private Place deathPlace;

    /**
     * The Dun & Bradstreet DUNS number for identifying an organization or business person.
     */
        private String duns;

    /**
     * Email address.
     */
        private String email;

    /**
     * Family name. In the U.S., the last name of a Person.
     */
        private String familyName;

    /**
     * The fax number.
     */
        private String faxNumber;

    /**
     * The most generic uni-directional social relation.
     */
            private Person follows;

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
     * Gender of something, typically a Person, but possibly also fictional characters, animals, etc. While https://schema.org/Male and https://schema.org/Female may be used, text strings are also acceptable for people who do not identify as a binary gender. The gender property can also be used in an extended sense to cover e.g. the gender of sports teams. As with the gender of individuals, we do not try to enumerate all possibilities. A mixed-gender SportsTeam can be indicated with a text value of "Mixed".
     */
            private GenderType gender;

    /**
     * Given name. In the U.S., the first name of a Person.
     */
        private String givenName;

    /**
     * The Global Location Number (GLN, sometimes also referred to as International Location Number or ILN) of the respective organization, person, or place. The GLN is a 13-digit number used to identify parties and physical locations.
     */
        private String globalLocationNumber;

    /**
     * A credential awarded to the Person or Organization.
     */
            private EducationalOccupationalCredential hasCredential;

    /**
     * The Person's occupation. For past professions, use Role for expressing dates.
     */
            private Occupation hasOccupation;

    /**
     * Indicates an OfferCatalog listing for this Organization, Person, or Service.
     */
            private OfferCatalog hasOfferCatalog;

    /**
     * Points-of-Sales operated by the organization or person.
     */
            private Place hasPOS;

    /**
     * The height of the item.
     */
            private Distance height;

    /**
     * A contact location for a person's residence.
     */
            private ContactPoint homeLocation;

    /**
     * An honorific prefix preceding a Person's name such as Dr/Mrs/Mr.
     */
        private String honorificPrefix;

    /**
     * An honorific suffix following a Person's name such as M.D./PhD/MSCSW.
     */
        private String honorificSuffix;

    /**
     * The number of interactions for the CreativeWork using the WebSite or SoftwareApplication. The most specific child type of InteractionCounter should be used. Supersedes interactionCount.
     */
    private java.util.List<InteractionCounter> interactionCount;

    /**
     * The International Standard of Industrial Classification of All Economic Activities (ISIC), Revision 4 code for a particular organization, business person, or place.
     */
        private String isicV4;

    /**
     * The job title of the person (for example, Financial Manager).
     */
            private DefinedTerm jobTitle;

    /**
     * The most generic bi-directional social/work relation.
     */
            private Person knows;

    /**
     * Of a Person, and less typically of an Organization, to indicate a topic that is known about - suggesting possible expertise but not implying it. We do not distinguish skill levels here, or relate this to educational content, events, objectives or JobPosting descriptions.
     */
        private String knowsAbout;

    /**
     * Of a Person, and less typically of an Organization, to indicate a known language. We do not distinguish skill levels or reading/writing/speaking/signing here. Use language codes from the IETF BCP 47 standard.
     */
            private Language knowsLanguage;

    /**
     * A pointer to products or services offered by the organization or person.
     * Inverse property: offeredBy
     */
            private Offer makesOffer;

    /**
     * An Organization (or ProgramMembership) to which this Person or Organization belongs.
     * Inverse property: member
     */
            private Organization memberOf;

    /**
     * The North American Industry Classification System (NAICS) code for a particular organization or business person.
     */
        private String naics;

    /**
     * Nationality of the person.
     */
            private Country nationality;

    /**
     * The total financial value of the person as calculated by subtracting assets from liabilities.
     */
            private MonetaryAmount netWorth;

    /**
     * Products owned by the organization or person.
     */
            private OwnershipInfo owns;

    /**
     * A parent of this person. Supersedes parents.
     */
    private java.util.List<Person> parents;

    /**
     * Event that this person is a performer or participant in.
     */
            private Event performerIn;

    /**
     * The publishingPrinciples property indicates (typically via URL) a document describing the editorial principles of an Organization (or individual, e.g. a Person writing a blog) that relate to their activities as a publisher, e.g. ethics or diversity policies. When applied to a CreativeWork (e.g. NewsArticle) the principles are those of the party primarily responsible for the creation of the CreativeWork.
     * <p>
     * While such policies are most typically expressed in natural language, sometimes related information (e.g. indicating a funder) can be expressed using schema.org terminology.
     */
            private CreativeWork publishingPrinciples;

    /**
     * The most generic familial relation.
     */
            private Person relatedTo;

    /**
     * A pointer to products or services sought by the organization or person (demand).
     */
            private Demand seeks;

    /**
     * A sibling of the person. Supersedes siblings.
     */
    private java.util.List<Person> siblings;

    /**
     * A person or organization that supports a thing through a pledge, promise, or financial contribution. E.g. a sponsor of a Medical Study or a corporate sponsor of an event.
     */
            private Organization sponsor;

    /**
     * The person's spouse.
     */
            private Person spouse;

    /**
     * The Tax / Fiscal ID of the organization or person, e.g. the TIN in the US or the CIF/NIF in Spain.
     */
        private String taxID;

    /**
     * The telephone number.
     */
        private String telephone;

    /**
     * The Value-added Tax ID of the organization or person.
     */
        private String vatID;

    /**
     * The weight of the product or person.
     */
            private QuantitativeValue weight;

    /**
     * A contact location for a person's place of work.
     */
            private ContactPoint workLocation;

    /**
     * Organizations that the person works for.
     */
            private Organization worksFor;

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