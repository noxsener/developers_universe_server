package com.codenfast.developersuniverse.entitydto.schema;

import com.codenfast.developersuniverse.EntityModel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/Review


/**A review of an item - for example, of a restaurant, movie, or store.*/
public class Review implements EntityModel {
    private String id;
    private Boolean passive = Boolean.FALSE;
    private LocalDateTime createTime = null;
    private LocalDateTime updateTime = null;


    /**
     * An associated ClaimReview, related by specific common content, topic or claim. The expectation is that this property would be most typically used in cases where a single activity is conducting both claim reviews and media reviews, in which case relatedMediaReview would commonly be used on a ClaimReview, while relatedClaimReview would be used on MediaReview.
     */
    private Review associatedClaimReview;

    /**
     * An associated MediaReview, related by specific common content, topic or claim. The expectation is that this property would be most typically used in cases where a single activity is conducting both claim reviews and media reviews, in which case relatedMediaReview would commonly be used on a ClaimReview, while relatedClaimReview would be used on MediaReview.
     */
    private Review associatedMediaReview;

    /**
     * An associated Review.
     */
    private Review associatedReview;

    /**
     * The item that is being reviewed/rated.
     */
    private Thing itemReviewed;

    /**
     * Provides negative considerations regarding something, most typically in pro/con lists for reviews (alongside positiveNotes). For symmetry
     * <p>
     * In the case of a Review, the property describes the itemReviewed from the perspective of the review; in the case of a Product, the product itself is being described. Since product descriptions tend to emphasise positive claims, it may be relatively unusual to find negativeNotes used in this way. Nevertheless for the sake of symmetry, negativeNotes can be used on Product.
     * <p>
     * The property values can be expressed either as unstructured text (repeated as necessary), or if ordered, as a list (in which case the most negative is at the beginning of the list).
     */
    private ItemList negativeNotes;

    /**
     * Provides positive considerations regarding something, for example product highlights or (alongside negativeNotes) pro/con lists for reviews.
     * <p>
     * In the case of a Review, the property describes the itemReviewed from the perspective of the review; in the case of a Product, the product itself is being described.
     * <p>
     * The property values can be expressed either as unstructured text (repeated as necessary), or if ordered, as a list (in which case the most positive is at the beginning of the list).
     */
    private ItemList positiveNotes;

    /**
     * This Review or Rating is relevant to this part or facet of the itemReviewed.
     */
    private String reviewAspect;

    /**
     * The actual body of the review.
     */
    private String reviewBody;

    /**
     * The rating given in this review. Note that reviews can themselves be rated. The reviewRating applies to rating given by the review. The aggregateRating property applies to the review itself, as a creative work.
     */
    private Rating reviewRating;

    /**
     * The subject matter of the content.
     * Inverse property: subjectOf
     */
    private Thing about;

    /**
     * An abstract is a short description that summarizes a CreativeWork.
     */
    @com.fasterxml.jackson.annotation.JsonProperty("abstract")
    private String abstractValue;

    /**
     * The human sensory perceptual system or cognitive faculty through which a person may process or perceive information. Values should be drawn from the approved vocabulary.
     */
    private String accessMode;

    /**
     * A list of single or combined accessModes that are sufficient to understand all the intellectual content of a resource. Values should be drawn from the approved vocabulary.
     */
    private ItemList accessModeSufficient;

    /**
     * Indicates that the resource is compatible with the referenced accessibility API. Values should be drawn from the approved vocabulary.
     */
    private String accessibilityAPI;

    /**
     * Identifies input methods that are sufficient to fully control the described resource. Values should be drawn from the approved vocabulary.
     */
    private String accessibilityControl;

    /**
     * Content features of the resource, such as accessible media, alternatives and supported enhancements for accessibility. Values should be drawn from the approved vocabulary.
     */
    private String accessibilityFeature;

    /**
     * A characteristic of the described resource that is physiologically dangerous to some users. Related to WCAG 2.0 guideline 2.3. Values should be drawn from the approved vocabulary.
     */
    private String accessibilityHazard;

    /**
     * A human-readable summary of specific accessibility features or deficiencies, consistent with the other accessibility metadata but expressing subtleties such as "short descriptions are present but long descriptions will be needed for non-visual users" or "short descriptions are present and no long descriptions are needed."
     */
    private String accessibilitySummary;

    /**
     * Specifies the Person that is legally accountable for the CreativeWork.
     */
    private Person accountablePerson;

    /**
     * Indicates a page documenting how licenses can be purchased or otherwise acquired, for the current item.
     */
    private CreativeWork acquireLicensePage;

    /**
     * The overall rating, based on a collection of reviews or ratings, of the item.
     */
    private AggregateRating aggregateRating;

    /**
     * A secondary title of the CreativeWork.
     */
    private String alternativeHeadline;

    /**
     * Indicates a page or other link involved in archival of a CreativeWork. In the case of MediaReview, the items in a MediaReviewItem may often become inaccessible, but be archived by archival, journalistic, activist, or law enforcement organizations. In such cases, the referenced page may not directly publish the content.
     */
    private String archivedAt;

    /**
     * The item being described is intended to assess the competency or learning outcome defined by the referenced term.
     */
    private DefinedTerm assesses;

    /**
     * A media object that encodes this CreativeWork. This property is a synonym for encoding.
     */
    private MediaObject associatedMedia;

    /**
     * An intended audience, i.e. a group for whom something was created. Supersedes serviceAudience.
     */
    private java.util.List<Audience> serviceAudience;

    /**
     * An embedded audio object.
     */
    private AudioObject audio;

    /**
     * The author of this content or rating. Please note that author is special in that HTML 5 provides a special mechanism for indicating authorship via the rel tag. That is equivalent to this and may be used interchangeably.
     */
    private Organization author;

    /**
     * An award won by or for this item. Supersedes awards.
     */
    private String award;

    /**
     * Fictional person connected with a creative work.
     */
    private Person character;

    /**
     * A citation or reference to another creative work, such as another publication, web page, scholarly article, etc.
     */
    private CreativeWork citation;

    /**
     * Comments, typically from users.
     */
    private Comment comment;

    /**
     * The number of comments this CreativeWork (e.g. Article, Question or Answer) has received. This is most applicable to works published in Web sites with commenting system; additional comments may exist elsewhere.
     */
    private String commentCount;

    /**
     * Conditions that affect the availability of, or method(s) of access to, an item. Typically used for real world items such as an ArchiveComponent held by an ArchiveOrganization. This property is not suitable for use as a general Web access control mechanism. It is expressed only in natural language.
     * <p>
     * For example "Available by appointment from the Reading Room" or "Accessible only from logged-in accounts ".
     */
    private String conditionsOfAccess;

    /**
     * The location depicted or described in the content. For example, the location in a photograph or painting.
     */
    private Place contentLocation;

    /**
     * Official rating of a piece of content—for example, 'MPAA PG-13'.
     */
    private Rating contentRating;

    /**
     * The specific time described by a creative work, for works (e.g. articles, video objects etc.) that emphasise a particular moment within an Event.
     */
    private LocalDateTime contentReferenceTime;

    /**
     * A secondary contributor to the CreativeWork or Event.
     */
    private Organization contributor;

    /**
     * The party holding the legal copyright to the CreativeWork.
     */
    private Organization copyrightHolder;

    /**
     * Text of a notice appropriate for describing the copyright aspects of this Creative Work, ideally indicating the owner of the copyright for the Work.
     */
    private String copyrightNotice;

    /**
     * The year during which the claimed copyright for the CreativeWork was first asserted.
     */
    private BigDecimal copyrightYear;

    /**
     * Indicates a correction to a CreativeWork, either via a CorrectionComment, textually or in another document.
     */
    private CorrectionComment correction;

    /**
     * The country of origin of something, including products as well as creative works such as movie and TV content.
     * <p>
     * In the case of TV and movie, this would be the country of the principle offices of the production company or individual responsible for the movie. For other kinds of CreativeWork it is difficult to provide fully general guidance, and properties such as contentLocation and locationCreated may be more applicable.
     * <p>
     * In the case of products, the country of origin of the product. The exact interpretation of this may vary by context and product type, and cannot be fully enumerated here.
     */
    private Country countryOfOrigin;

    /**
     * The status of a creative work in terms of its stage in a lifecycle. Example terms include Incomplete, Draft, Published, Obsolete. Some organizations define a set of terms for the stages of their publication lifecycle.
     */
    private DefinedTerm creativeWorkStatus;

    /**
     * The creator/author of this CreativeWork. This is the same as the Author property for CreativeWork.
     */
    private Organization creator;

    /**
     * Text that can be used to credit person(s) and/or organization(s) associated with a published Creative Work.
     */
    private String creditText;

    /**
     * The date on which the CreativeWork was created or the item was added to a DataFeed.
     */
    private LocalDate dateCreated;

    /**
     * The date on which the CreativeWork was most recently modified or when the item's entry was modified within a DataFeed.
     */
    private LocalDate dateModified;

    /**
     * Date of first broadcast/publication.
     */
    private LocalDate datePublished;

    /**
     * A link to the page containing the comments of the CreativeWork.
     */
    private String discussionUrl;

    /**
     * An EIDR (Entertainment Identifier Registry) identifier representing a specific edit / edition for a work of film or television.
     * <p>
     * For example, the motion picture known as "Ghostbusters" whose titleEIDR is "10.5240/7EC7-228A-510A-053E-CBB8-J" has several edits, e.g. "10.5240/1F2A-E1C5-680A-14C6-E76B-I" and "10.5240/8A35-3BEE-6497-5D12-9E4F-3".
     * <p>
     * Since schema.org types like Movie and TVEpisode can be used for both works and their multiple expressions, it is possible to use titleEIDR alone (for a general description), or alongside editEIDR for a more edit-specific description.
     */
    private String editEIDR;

    /**
     * Specifies the Person who edited the CreativeWork.
     */
    private Person editor;

    /**
     * An alignment to an established educational framework.
     * <p>
     * This property should not be used where the nature of the alignment can be described using a simple property, for example to express that a resource teaches or assesses a competency.
     */
    private AlignmentObject educationalAlignment;

    /**
     * The level in terms of progression through an educational or training context. Examples of educational levels include 'beginner', 'intermediate' or 'advanced', and formal sets of level indicators.
     */
    private DefinedTerm educationalLevel;

    /**
     * The purpose of a work in the context of education; for example, 'assignment', 'group work'.
     */
    private DefinedTerm educationalUse;

    /**
     * A media object that encodes this CreativeWork. This property is a synonym for associatedMedia. Supersedes encodings.
     * Inverse property: encodesCreativeWork
     */
    private java.util.List<MediaObject> encodesCreativeWork;

    /**
     * Media type typically expressed using a MIME format (see IANA site and MDN reference), e.g. application/zip for a SoftwareApplication binary, audio/mpeg for .mp3 etc.
     * <p>
     * In cases where a CreativeWork has several media type representations, encoding can be used to indicate each MediaObject alongside particular encodingFormat information.
     * <p>
     * Unregistered or niche encoding and file formats can be indicated instead via the most appropriate URL, e.g. defining Web page or a Wikipedia/Wikidata entry. Supersedes fileFormat.
     */
    private String encodingFormat;

    /**
     * A creative work that this work is an example/instance/realization/derivation of.
     * Inverse property: workExample
     */
    private CreativeWork exampleOfWork;

    /**
     * Date the content expires and is no longer useful or available. For example a VideoObject or NewsArticle whose availability or relevance is time-limited, or a ClaimReview fact check whose publisher wants to indicate that it may no longer be relevant (or helpful to highlight) after some date.
     */
    private LocalDate expires;

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
     * Genre of the creative work, broadcast channel or group.
     */
    private String genre;

    /**
     * Indicates an item or CreativeWork that is part of this item, or CreativeWork (in some sense).
     * Inverse property: isPartOf
     */
    private CreativeWork hasPart;

    /**
     * Headline of the article.
     */
    private String headline;

    /**
     * The language of the content or performance or used in an action. Please use one of the language codes from the IETF BCP 47 standard. See also availableLanguage. Supersedes language.
     */
    private java.util.List<Language> language;

    /**
     * The number of interactions for the CreativeWork using the WebSite or SoftwareApplication. The most specific child type of InteractionCounter should be used. Supersedes interactionCount.
     */
    private java.util.List<InteractionCounter> interactionCount;

    /**
     * The predominant mode of learning supported by the learning resource. Acceptable values are 'active', 'expositive', or 'mixed'.
     */
    private String interactivityType;

    /**
     * Used to indicate a specific claim contained, implied, translated or refined from the content of a MediaObject or other CreativeWork. The interpreting party can be indicated using claimInterpreter.
     */
    private Claim interpretedAsClaim;

    /**
     * A flag to signal that the item, event, or place is accessible for free. Supersedes free.
     */
    private Boolean isAccessibleForFree;

    /**
     * A resource from which this work is derived or from which it is a modification or adaption. Supersedes isBasedOnUrl.
     */
    private java.util.List<CreativeWork> isBasedOnUrl;

    /**
     * Indicates whether this content is family friendly.
     */
    private Boolean isFamilyFriendly;

    /**
     * Indicates an item or CreativeWork that this item, or CreativeWork (in some sense), is part of.
     * Inverse property: hasPart
     */
    private CreativeWork isPartOf;

    /**
     * Keywords or tags used to describe some item. Multiple textual entries in a keywords list are typically delimited by commas, or by repeating the property.
     */
    private DefinedTerm keywords;

    /**
     * The predominant type or kind characterizing the learning resource. For example, 'presentation', 'handout'.
     */
    private DefinedTerm learningResourceType;

    /**
     * A license document that applies to this content, typically indicated by URL.
     */
    private CreativeWork license;

    /**
     * The location where the CreativeWork was created, which may not be the same as the location depicted in the CreativeWork.
     */
    private Place locationCreated;

    /**
     * Indicates the primary entity described in some page or other CreativeWork.
     * Inverse property: mainEntityOfPage
     */
    private Thing mainEntity;

    /**
     * A maintainer of a Dataset, software package (SoftwareApplication), or other Project. A maintainer is a Person or Organization that manages contributions to, and/or publication of, some (typically complex) artifact. It is common for distributions of software and data to be based on "upstream" sources. When maintainer is applied to a specific version of something e.g. a particular version or packaging of a Dataset, it is always possible that the upstream source has a different maintainer. The isBasedOn property can be used to indicate such relationships between datasets to make the different maintenance roles clear. Similarly in the case of software, a package may have dedicated maintainers working on integration into software distributions such as Ubuntu, as well as upstream maintainers of the underlying work.
     */
    private Organization maintainer;

    /**
     * A material that something is made from, e.g. leather, wool, cotton, paper.
     */
    private Product material;

    /**
     * The quantity of the materials being described or an expression of the physical space they occupy.
     */
    private QuantitativeValue materialExtent;

    /**
     * Indicates that the CreativeWork contains a reference to, but is not necessarily about a concept.
     */
    private Thing mentions;

    /**
     * An offer to provide this item—for example, an offer to sell a product, rent the DVD of a movie, perform a service, or give away tickets to an event. Use businessFunction to indicate the kind of transaction offered, i.e. sell, lease, etc. This property can also be used to describe a Demand. While this property is listed as expected on a number of common types, it can be used in others. In that case, using a second type, such as Product or a subtype of Product, can clarify the nature of the offer.
     * Inverse property: itemOffered
     */
    private Demand offers;

    /**
     * A pattern that something has, for example 'polka dot', 'striped', 'Canadian flag'. Values are typically expressed as text, although links to controlled value schemes are also supported.
     */
    private DefinedTerm pattern;

    /**
     * The position of an item in a series or sequence of items.
     */
    private String position;

    /**
     * The person or organization who produced the work (e.g. music album, movie, TV/radio series etc.).
     */
    private Organization producer;

    /**
     * The service provider, service operator, or service performer; the goods producer. Another party (a seller) may offer those services or goods on behalf of the provider. A provider may also serve as the seller. Supersedes carrier.
     */
    private java.util.List<Organization> carrier;

    /**
     * A publication event associated with the item.
     */
    private PublicationEvent publication;

    /**
     * The publisher of the creative work.
     */
    private Organization publisher;

    /**
     * The publishing division which published the comic.
     */
    private Organization publisherImprint;

    /**
     * The publishingPrinciples property indicates (typically via URL) a document describing the editorial principles of an Organization (or individual, e.g. a Person writing a blog) that relate to their activities as a publisher, e.g. ethics or diversity policies. When applied to a CreativeWork (e.g. NewsArticle) the principles are those of the party primarily responsible for the creation of the CreativeWork.
     * <p>
     * While such policies are most typically expressed in natural language, sometimes related information (e.g. indicating a funder) can be expressed using schema.org terminology.
     */
    private CreativeWork publishingPrinciples;

    /**
     * The Event where the CreativeWork was recorded. The CreativeWork may capture all or part of the event.
     * Inverse property: recordedIn
     */
    private Event recordedAt;

    /**
     * The place and time the release was issued, expressed as a PublicationEvent.
     */
    private PublicationEvent releasedEvent;

    /**
     * A review of the item. Supersedes reviews.
     */
    private java.util.List<Review> reviews;

    /**
     * Indicates (by URL or string) a particular version of a schema used in some CreativeWork. This property was created primarily to indicate the use of a specific schema.org release, e.g. 10.0 as a simple string, or more explicitly via URL, https://schema.org/docs/releases.html#v10.0. There may be situations in which other schemas might usefully be referenced this way, e.g. http://dublincore.org/specifications/dublin-core/dces/1999-07-02/ but this has not been carefully explored in the community.
     */
    private String schemaVersion;

    /**
     * Indicates the date on which the current structured data was generated / published. Typically used alongside sdPublisher
     */
    private LocalDate sdDatePublished;

    /**
     * A license document that applies to this structured data, typically indicated by URL.
     */
    private CreativeWork sdLicense;

    /**
     * Indicates the party responsible for generating and publishing the current structured data markup, typically in cases where the structured data is derived automatically from existing published content but published on a different site. For example, student projects and open data initiatives often re-publish existing content with more explicitly structured metadata. The sdPublisher property helps make such practices more explicit.
     */
    private Organization sdPublisher;

    /**
     * A standardized size of a product or creative work, specified either through a simple textual string (for example 'XL', '32Wx34L'), a QuantitativeValue with a unitCode, or a comprehensive and structured SizeSpecification; in other cases, the width, height, depth and weight properties may be more applicable.
     */
    private DefinedTerm size;

    /**
     * The Organization on whose behalf the creator was working.
     */
    private Organization sourceOrganization;

    /**
     * The "spatial" property can be used in cases when more specific properties (e.g. locationCreated, spatialCoverage, contentLocation) are not known to be appropriate.
     */
    private Place spatial;

    /**
     * The spatialCoverage of a CreativeWork indicates the place(s) which are the focus of the content. It is a subproperty of contentLocation intended primarily for more technical and detailed materials. For example with a Dataset, it indicates areas that the dataset describes: a dataset of New York weather would have spatialCoverage which was the place: the state of New York.
     */
    private Place spatialCoverage;

    /**
     * A person or organization that supports a thing through a pledge, promise, or financial contribution. E.g. a sponsor of a Medical Study or a corporate sponsor of an event.
     */
    private Organization sponsor;

    /**
     * The item being described is intended to help a person learn the competency or learning outcome defined by the referenced term.
     */
    private DefinedTerm teaches;

    /**
     * The "temporal" property can be used in cases where more specific properties (e.g. temporalCoverage, dateCreated, dateModified, datePublished) are not known to be appropriate.
     */
    private LocalDateTime temporal;

    /**
     * The temporalCoverage of a CreativeWork indicates the period that the content applies to, i.e. that it describes, either as a DateTime or as a textual string indicating a time period in ISO 8601 time interval format. In the case of a Dataset it will typically indicate the relevant time period in a precise notation (e.g. for a 2011 census dataset, the year 2011 would be written "2011/2012"). Other forms of content, e.g. ScholarlyArticle, Book, TVSeries or TVEpisode, may indicate their temporalCoverage in broader terms - textually or via well-known URL. Written works such as books may sometimes have precise temporal coverage too, e.g. a work set in 1939 - 1945 can be indicated in ISO 8601 interval format format via "1939/1945".
     * <p>
     * Open-ended date ranges can be written with ".." in place of the end date. For example, "2015-11/.." indicates a range beginning in November 2015 and with no specified final date. This is tentative and might be updated in future when ISO 8601 is officially updated. Supersedes datasetTimeInterval.
     */
    private LocalDateTime temporalCoverage;

    /**
     * The textual content of this CreativeWork.
     */
    private String text;

    /**
     * A thumbnail image relevant to the Thing.
     */
    private String thumbnailUrl;

    /**
     * Approximate or typical time it takes to work with or through this learning resource for the typical intended target audience, e.g. 'PT30M', 'PT1H25M'.
     */
    private Duration timeRequired;

    /**
     * The work that this work has been translated from. E.g. 物种起源 is a translationOf “On the Origin of Species”.
     * Inverse property: workTranslation
     */
    private CreativeWork translationOfWork;

    /**
     * Organization or person who adapts a creative work to different languages, regional differences and technical requirements of a target market, or that translates during some event.
     */
    private Organization translator;

    /**
     * The typical expected age range, e.g. '7-9', '11-'.
     */
    private String typicalAgeRange;

    /**
     * The schema.org usageInfo property indicates further information about a CreativeWork. This property is applicable both to works that are freely available and to those that require payment or other transactions. It can reference additional information, e.g. community expectations on preferred linking and citation conventions, as well as purchasing details. For something that can be commercially licensed, usageInfo can provide detailed, resource-specific information about licensing options.
     * <p>
     * This property can be used alongside the license property which indicates license(s) applicable to some piece of content. The usageInfo property can provide information about other licensing options, e.g. acquiring commercial usage rights for an image that is also available under non-commercial creative commons licenses.
     */
    private CreativeWork usageInfo;

    /**
     * The version of the CreativeWork embodied by a specified resource.
     */
    private BigDecimal version;

    /**
     * An embedded video object.
     */
    private Clip video;

    /**
     * Example/instance/realization/derivation of the concept of this creative work. E.g. the paperback edition, first edition, or e-book.
     * Inverse property: exampleOfWork
     */
    private CreativeWork workExample;

    /**
     * A work that is a translation of the content of this work. E.g. 西遊記 has an English workTranslation “Journey to the West”, a German workTranslation “Monkeys Pilgerfahrt” and a Vietnamese translation Tây du ký bình khảo.
     * Inverse property: translationOfWork
     */
    private CreativeWork workTranslation;

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

    private ReviewNewsArticle reviewsReviewNewsArticleParent;
    private RiverBodyOfWater reviewsRiverBodyOfWaterParent;
    private RoofingContractor reviewsRoofingContractorParent;
    private Room reviewsRoomParent;
    private RVPark reviewsRVParkParent;
    private SaleEvent reviewsSaleEventParent;
    private SatiricalArticle reviewsSatiricalArticleParent;
    private SchemaOrgTable reviewsSchemaOrgTableParent;
    private ScholarlyArticle reviewsScholarlyArticleParent;
    private School reviewsSchoolParent;
    private SchoolDistrict reviewsSchoolDistrictParent;
    private ScreeningEvent reviewsScreeningEventParent;
    private Sculpture reviewsSculptureParent;
    private SeaBodyOfWater reviewsSeaBodyOfWaterParent;
    private SearchRescueOrganization reviewsSearchRescueOrganizationParent;
    private SearchResultsPage reviewsSearchResultsPageParent;
    private Season reviewsSeasonParent;
    private SelfStorage reviewsSelfStorageParent;
    private Service reviewsServiceParent;
    private SheetMusic reviewsSheetMusicParent;
    private ShoeStore reviewsShoeStoreParent;
    private ShoppingCenter reviewsShoppingCenterParent;
    private ShortStory reviewsShortStoryParent;
    private SingleFamilyResidence reviewsSingleFamilyResidenceParent;
    private SiteNavigationElement reviewsSiteNavigationElementParent;
    private SkiResort reviewsSkiResortParent;
    private SocialEvent reviewsSocialEventParent;
    private SocialMediaPosting reviewsSocialMediaPostingParent;
    private SoftwareApplication reviewsSoftwareApplicationParent;
    private SoftwareSourceCode reviewsSoftwareSourceCodeParent;
    private SomeProducts reviewsSomeProductsParent;
    private SpecialAnnouncement reviewsSpecialAnnouncementParent;
    private SportingGoodsStore reviewsSportingGoodsStoreParent;
    private SportsActivityLocation reviewsSportsActivityLocationParent;
    private SportsClub reviewsSportsClubParent;
    private SportsEvent reviewsSportsEventParent;
    private SportsOrganization reviewsSportsOrganizationParent;
    private SportsTeam reviewsSportsTeamParent;
    private SpreadsheetDigitalDocument reviewsSpreadsheetDigitalDocumentParent;
    private StadiumOrArena reviewsStadiumOrArenaParent;
    private State reviewsStateParent;
    private Statement reviewsStatementParent;
    private Store reviewsStoreParent;
    private SubwayStation reviewsSubwayStationParent;
    private Suite reviewsSuiteParent;
    private Synagogue reviewsSynagogueParent;
    private TattooParlor reviewsTattooParlorParent;
    private Taxi reviewsTaxiParent;
    private TaxiService reviewsTaxiServiceParent;
    private TaxiStand reviewsTaxiStandParent;
    private TechArticle reviewsTechArticleParent;
    private TelevisionStation reviewsTelevisionStationParent;
    private TennisComplex reviewsTennisComplexParent;
    private TextDigitalDocument reviewsTextDigitalDocumentParent;
    private TheaterEvent reviewsTheaterEventParent;
    private TheaterGroup reviewsTheaterGroupParent;
    private Thesis reviewsThesisParent;
    private ThreeDModel reviewsThreeDModelParent;
    private TireShop reviewsTireShopParent;
    private TouristAttraction reviewsTouristAttractionParent;
    private TouristDestination reviewsTouristDestinationParent;
    private TouristInformationCenter reviewsTouristInformationCenterParent;
    private ToyStore reviewsToyStoreParent;
    private TrainStation reviewsTrainStationParent;
    private TravelAgency reviewsTravelAgencyParent;
    private TVClip reviewsTVClipParent;
    private TVEpisode reviewsTVEpisodeParent;
    private TVSeason reviewsTVSeasonParent;
    private TVSeries reviewsTVSeriesParent;
    private UserBlocks reviewsUserBlocksParent;
    private UserCheckins reviewsUserCheckinsParent;
    private UserComments reviewsUserCommentsParent;
    private UserDownloads reviewsUserDownloadsParent;
    private UserInteraction reviewsUserInteractionParent;
    private UserLikes reviewsUserLikesParent;
    private UserPageVisits reviewsUserPageVisitsParent;
    private UserPlays reviewsUserPlaysParent;
    private UserPlusOnes reviewsUserPlusOnesParent;
    private UserReview reviewsUserReviewParent;
    private UserTweets reviewsUserTweetsParent;
    private Vehicle reviewsVehicleParent;
    private VeterinaryCare reviewsVeterinaryCareParent;
    private VideoGallery reviewsVideoGalleryParent;
    private VideoGame reviewsVideoGameParent;
    private VideoGameClip reviewsVideoGameClipParent;
    private VideoGameSeries reviewsVideoGameSeriesParent;
    private VideoObject reviewsVideoObjectParent;
    private VideoObjectSnapshot reviewsVideoObjectSnapshotParent;
    private VisualArtsEvent reviewsVisualArtsEventParent;
    private VisualArtwork reviewsVisualArtworkParent;
    private Volcano reviewsVolcanoParent;
    private Waterfall reviewsWaterfallParent;
    private WebAPI reviewsWebAPIParent;
    private WebApplication reviewsWebApplicationParent;
    private WebContent reviewsWebContentParent;
    private WebPage reviewsWebPageParent;
    private WebPageElement reviewsWebPageElementParent;
    private WebPageTable reviewsWebPageTableParent;
    private WebSite reviewsWebSiteParent;
    private WholesaleStore reviewsWholesaleStoreParent;
    private Winery reviewsWineryParent;
    private WorkersUnion reviewsWorkersUnionParent;
    private WPAdBlock reviewsWPAdBlockParent;
    private WPFooter reviewsWPFooterParent;
    private WPHeader reviewsWPHeaderParent;
    private WPSideBar reviewsWPSideBarParent;
    private WTable reviewsWTableParent;
    private Zoo reviewsZooParent;
    private APIReference reviewsAPIReferenceParent;
    private AboutPage reviewsAboutPageParent;
    private Accommodation reviewsAccommodationParent;
    private AccountingService reviewsAccountingServiceParent;
    private AdministrativeArea reviewsAdministrativeAreaParent;
    private AdultEntertainment reviewsAdultEntertainmentParent;
    private AdvertiserContentArticle reviewsAdvertiserContentArticleParent;
    private AggregateOffer reviewsAggregateOfferParent;
    private Airline reviewsAirlineParent;
    private Airport reviewsAirportParent;
    private AmpStory reviewsAmpStoryParent;
    private AmusementPark reviewsAmusementParkParent;
    private AnalysisNewsArticle reviewsAnalysisNewsArticleParent;
    private AnimalShelter reviewsAnimalShelterParent;
    private Answer reviewsAnswerParent;
    private Apartment reviewsApartmentParent;
    private ApartmentComplex reviewsApartmentComplexParent;
    private Aquarium reviewsAquariumParent;
    private ArchiveComponent reviewsArchiveComponentParent;
    private ArchiveOrganization reviewsArchiveOrganizationParent;
    private ArtGallery reviewsArtGalleryParent;
    private Article reviewsArticleParent;
    private AskPublicNewsArticle reviewsAskPublicNewsArticleParent;
    private Atlas reviewsAtlasParent;
    private Attorney reviewsAttorneyParent;
    private Audiobook reviewsAudiobookParent;
    private AudioObject reviewsAudioObjectParent;
    private AudioObjectSnapshot reviewsAudioObjectSnapshotParent;
    private AutoBodyShop reviewsAutoBodyShopParent;
    private AutoDealer reviewsAutoDealerParent;
    private AutomatedTeller reviewsAutomatedTellerParent;
    private AutomotiveBusiness reviewsAutomotiveBusinessParent;
    private AutoPartsStore reviewsAutoPartsStoreParent;
    private AutoRental reviewsAutoRentalParent;
    private AutoRepair reviewsAutoRepairParent;
    private AutoWash reviewsAutoWashParent;
    private BackgroundNewsArticle reviewsBackgroundNewsArticleParent;
    private Bakery reviewsBakeryParent;
    private BankAccount reviewsBankAccountParent;
    private BankOrCreditUnion reviewsBankOrCreditUnionParent;
    private Barcode reviewsBarcodeParent;
    private BarOrPub reviewsBarOrPubParent;
    private Beach reviewsBeachParent;
    private BeautySalon reviewsBeautySalonParent;
    private BedAndBreakfast reviewsBedAndBreakfastParent;
    private BikeStore reviewsBikeStoreParent;
    private Blog reviewsBlogParent;
    private BlogPosting reviewsBlogPostingParent;
    private BoatTerminal reviewsBoatTerminalParent;
    private BodyOfWater reviewsBodyOfWaterParent;
    private Book reviewsBookParent;
    private BookSeries reviewsBookSeriesParent;
    private BookStore reviewsBookStoreParent;
    private BowlingAlley reviewsBowlingAlleyParent;
    private Brand reviewsBrandParent;
    private Brewery reviewsBreweryParent;
    private Bridge reviewsBridgeParent;
    private BroadcastEvent reviewsBroadcastEventParent;
    private BroadcastService reviewsBroadcastServiceParent;
    private BrokerageAccount reviewsBrokerageAccountParent;
    private BuddhistTemple reviewsBuddhistTempleParent;
    private BusinessEvent reviewsBusinessEventParent;
    private BusOrCoach reviewsBusOrCoachParent;
    private BusStation reviewsBusStationParent;
    private BusStop reviewsBusStopParent;
    private CableOrSatelliteService reviewsCableOrSatelliteServiceParent;
    private CafeOrCoffeeShop reviewsCafeOrCoffeeShopParent;
    private Campground reviewsCampgroundParent;
    private CampingPitch reviewsCampingPitchParent;
    private Canal reviewsCanalParent;
    private Car reviewsCarParent;
    private Casino reviewsCasinoParent;
    private CategoryCodeSet reviewsCategoryCodeSetParent;
    private CatholicChurch reviewsCatholicChurchParent;
    private Cemetery reviewsCemeteryParent;
    private Chapter reviewsChapterParent;
    private CheckoutPage reviewsCheckoutPageParent;
    private ChildCare reviewsChildCareParent;
    private ChildrensEvent reviewsChildrensEventParent;
    private Church reviewsChurchParent;
    private City reviewsCityParent;
    private CityHall reviewsCityHallParent;
    private CivicStructure reviewsCivicStructureParent;
    private Claim reviewsClaimParent;
    private ClaimReview reviewsClaimReviewParent;
    private Clip reviewsClipParent;
    private ClothingStore reviewsClothingStoreParent;
    private Code reviewsCodeParent;
    private Collection reviewsCollectionParent;
    private CollectionPage reviewsCollectionPageParent;
    private CollegeOrUniversity reviewsCollegeOrUniversityParent;
    private ComedyClub reviewsComedyClubParent;
    private ComedyEvent reviewsComedyEventParent;
    private ComicCoverArt reviewsComicCoverArtParent;
    private ComicIssue reviewsComicIssueParent;
    private ComicSeries reviewsComicSeriesParent;
    private ComicStory reviewsComicStoryParent;
    private Comment reviewsCommentParent;
    private CompleteDataFeed reviewsCompleteDataFeedParent;
    private ComputerStore reviewsComputerStoreParent;
    private Consortium reviewsConsortiumParent;
    private ContactPage reviewsContactPageParent;
    private Continent reviewsContinentParent;
    private ConvenienceStore reviewsConvenienceStoreParent;
    private Conversation reviewsConversationParent;
    private Corporation reviewsCorporationParent;
    private CorrectionComment reviewsCorrectionCommentParent;
    private Country reviewsCountryParent;
    private Course reviewsCourseParent;
    private CourseInstance reviewsCourseInstanceParent;
    private Courthouse reviewsCourthouseParent;
    private CoverArt reviewsCoverArtParent;
    private CovidTestingFacility reviewsCovidTestingFacilityParent;
    private CreativeWork reviewsCreativeWorkParent;
    private CreativeWorkSeason reviewsCreativeWorkSeasonParent;
    private CreativeWorkSeries reviewsCreativeWorkSeriesParent;
    private Crematorium reviewsCrematoriumParent;
    private CriticReview reviewsCriticReviewParent;
    private CurrencyConversionService reviewsCurrencyConversionServiceParent;
    private DanceEvent reviewsDanceEventParent;
    private DanceGroup reviewsDanceGroupParent;
    private DataCatalog reviewsDataCatalogParent;
    private DataDownload reviewsDataDownloadParent;
    private DataFeed reviewsDataFeedParent;
    private Dataset reviewsDatasetParent;
    private DaySpa reviewsDaySpaParent;
    private DefenceEstablishment reviewsDefenceEstablishmentParent;
    private DefinedTermSet reviewsDefinedTermSetParent;
    private DeliveryEvent reviewsDeliveryEventParent;
    private Dentist reviewsDentistParent;
    private DepartmentStore reviewsDepartmentStoreParent;
    private DepositAccount reviewsDepositAccountParent;
    private DiagnosticLab reviewsDiagnosticLabParent;
    private DigitalDocument reviewsDigitalDocumentParent;
    private DiscussionForumPosting reviewsDiscussionForumPostingParent;
    private Distillery reviewsDistilleryParent;
    private Drawing reviewsDrawingParent;
    private DryCleaningOrLaundry reviewsDryCleaningOrLaundryParent;
    private EducationalOccupationalCredential reviewsEducationalOccupationalCredentialParent;
    private EducationalOrganization reviewsEducationalOrganizationParent;
    private EducationEvent reviewsEducationEventParent;
    private Electrician reviewsElectricianParent;
    private ElectronicsStore reviewsElectronicsStoreParent;
    private ElementarySchool reviewsElementarySchoolParent;
    private EmailMessage reviewsEmailMessageParent;
    private Embassy reviewsEmbassyParent;
    private EmergencyService reviewsEmergencyServiceParent;
    private EmployerReview reviewsEmployerReviewParent;
    private EmploymentAgency reviewsEmploymentAgencyParent;
    private EntertainmentBusiness reviewsEntertainmentBusinessParent;
    private Episode reviewsEpisodeParent;
    private Event reviewsEventParent;
    private EventSeries reviewsEventSeriesParent;
    private EventVenue reviewsEventVenueParent;
    private ExerciseGym reviewsExerciseGymParent;
    private ExhibitionEvent reviewsExhibitionEventParent;
    private FAQPage reviewsFAQPageParent;
    private FastFoodRestaurant reviewsFastFoodRestaurantParent;
    private Festival reviewsFestivalParent;
    private FinancialProduct reviewsFinancialProductParent;
    private FinancialService reviewsFinancialServiceParent;
    private FireStation reviewsFireStationParent;
    private Florist reviewsFloristParent;
    private FoodEstablishment reviewsFoodEstablishmentParent;
    private FoodEvent reviewsFoodEventParent;
    private FoodService reviewsFoodServiceParent;
    private FundingAgency reviewsFundingAgencyParent;
    private FundingScheme reviewsFundingSchemeParent;
    private FurnitureStore reviewsFurnitureStoreParent;
    private Game reviewsGameParent;
    private GardenStore reviewsGardenStoreParent;
    private GasStation reviewsGasStationParent;
    private GatedResidenceCommunity reviewsGatedResidenceCommunityParent;
    private GeneralContractor reviewsGeneralContractorParent;
    private GolfCourse reviewsGolfCourseParent;
    private GovernmentBuilding reviewsGovernmentBuildingParent;
    private GovernmentOffice reviewsGovernmentOfficeParent;
    private GovernmentOrganization reviewsGovernmentOrganizationParent;
    private GovernmentService reviewsGovernmentServiceParent;
    private GroceryStore reviewsGroceryStoreParent;
    private Guide reviewsGuideParent;
    private Hackathon reviewsHackathonParent;
    private HairSalon reviewsHairSalonParent;
    private HardwareStore reviewsHardwareStoreParent;
    private HealthAndBeautyBusiness reviewsHealthAndBeautyBusinessParent;
    private HealthClub reviewsHealthClubParent;
    private HealthTopicContent reviewsHealthTopicContentParent;
    private HighSchool reviewsHighSchoolParent;
    private HinduTemple reviewsHinduTempleParent;
    private HobbyShop reviewsHobbyShopParent;
    private HomeAndConstructionBusiness reviewsHomeAndConstructionBusinessParent;
    private HomeGoodsStore reviewsHomeGoodsStoreParent;
    private Hospital reviewsHospitalParent;
    private Hostel reviewsHostelParent;
    private Hotel reviewsHotelParent;
    private HotelRoom reviewsHotelRoomParent;
    private House reviewsHouseParent;
    private HousePainter reviewsHousePainterParent;
    private HowTo reviewsHowToParent;
    private HowToDirection reviewsHowToDirectionParent;
    private HowToSection reviewsHowToSectionParent;
    private HowToStep reviewsHowToStepParent;
    private HowToTip reviewsHowToTipParent;
    private HVACBusiness reviewsHVACBusinessParent;
    private HyperToc reviewsHyperTocParent;
    private HyperTocEntry reviewsHyperTocEntryParent;
    private IceCreamShop reviewsIceCreamShopParent;
    private ImageGallery reviewsImageGalleryParent;
    private ImageObject reviewsImageObjectParent;
    private ImageObjectSnapshot reviewsImageObjectSnapshotParent;
    private IndividualProduct reviewsIndividualProductParent;
    private InsuranceAgency reviewsInsuranceAgencyParent;
    private InternetCafe reviewsInternetCafeParent;
    private InvestmentFund reviewsInvestmentFundParent;
    private InvestmentOrDeposit reviewsInvestmentOrDepositParent;
    private ItemPage reviewsItemPageParent;
    private JewelryStore reviewsJewelryStoreParent;
    private LakeBodyOfWater reviewsLakeBodyOfWaterParent;
    private Landform reviewsLandformParent;
    private LandmarksOrHistoricalBuildings reviewsLandmarksOrHistoricalBuildingsParent;
    private LearningResource reviewsLearningResourceParent;
    private LegalService reviewsLegalServiceParent;
    private Legislation reviewsLegislationParent;
    private LegislationObject reviewsLegislationObjectParent;
    private LegislativeBuilding reviewsLegislativeBuildingParent;
    private Library reviewsLibraryParent;
    private LibrarySystem reviewsLibrarySystemParent;
    private LiquorStore reviewsLiquorStoreParent;
    private LiteraryEvent reviewsLiteraryEventParent;
    private LiveBlogPosting reviewsLiveBlogPostingParent;
    private LoanOrCredit reviewsLoanOrCreditParent;
    private LocalBusiness reviewsLocalBusinessParent;
    private Locksmith reviewsLocksmithParent;
    private LodgingBusiness reviewsLodgingBusinessParent;
    private Manuscript reviewsManuscriptParent;
    private Map reviewsMapParent;
    private MathSolver reviewsMathSolverParent;
    private MediaGallery reviewsMediaGalleryParent;
    private MediaObject reviewsMediaObjectParent;
    private MediaReview reviewsMediaReviewParent;
    private MediaReviewItem reviewsMediaReviewItemParent;
    private MedicalBusiness reviewsMedicalBusinessParent;
    private MedicalClinic reviewsMedicalClinicParent;
    private MedicalOrganization reviewsMedicalOrganizationParent;
    private MedicalScholarlyArticle reviewsMedicalScholarlyArticleParent;
    private MedicalWebPage reviewsMedicalWebPageParent;
    private MeetingRoom reviewsMeetingRoomParent;
    private MensClothingStore reviewsMensClothingStoreParent;
    private Menu reviewsMenuParent;
    private MenuSection reviewsMenuSectionParent;
    private Message reviewsMessageParent;
    private MiddleSchool reviewsMiddleSchoolParent;
    private MobileApplication reviewsMobileApplicationParent;
    private MobilePhoneStore reviewsMobilePhoneStoreParent;
    private MortgageLoan reviewsMortgageLoanParent;
    private Mosque reviewsMosqueParent;
    private Motel reviewsMotelParent;
    private Motorcycle reviewsMotorcycleParent;
    private MotorcycleDealer reviewsMotorcycleDealerParent;
    private MotorcycleRepair reviewsMotorcycleRepairParent;
    private MotorizedBicycle reviewsMotorizedBicycleParent;
    private Mountain reviewsMountainParent;
    private Movie reviewsMovieParent;
    private MovieClip reviewsMovieClipParent;
    private MovieRentalStore reviewsMovieRentalStoreParent;
    private MovieSeries reviewsMovieSeriesParent;
    private MovieTheater reviewsMovieTheaterParent;
    private MovingCompany reviewsMovingCompanyParent;
    private Museum reviewsMuseumParent;
    private MusicAlbum reviewsMusicAlbumParent;
    private MusicComposition reviewsMusicCompositionParent;
    private MusicEvent reviewsMusicEventParent;
    private MusicGroup reviewsMusicGroupParent;
    private MusicPlaylist reviewsMusicPlaylistParent;
    private MusicRecording reviewsMusicRecordingParent;
    private MusicRelease reviewsMusicReleaseParent;
    private MusicStore reviewsMusicStoreParent;
    private MusicVenue reviewsMusicVenueParent;
    private MusicVideoObject reviewsMusicVideoObjectParent;
    private NailSalon reviewsNailSalonParent;
    private NewsArticle reviewsNewsArticleParent;
    private NewsMediaOrganization reviewsNewsMediaOrganizationParent;
    private Newspaper reviewsNewspaperParent;
    private NGO reviewsNGOParent;
    private NightClub reviewsNightClubParent;
    private Notary reviewsNotaryParent;
    private NoteDigitalDocument reviewsNoteDigitalDocumentParent;
    private OceanBodyOfWater reviewsOceanBodyOfWaterParent;
    private Offer reviewsOfferParent;
    private OfferForLease reviewsOfferForLeaseParent;
    private OfferForPurchase reviewsOfferForPurchaseParent;
    private OfficeEquipmentStore reviewsOfficeEquipmentStoreParent;
    private OnDemandEvent reviewsOnDemandEventParent;
    private OnlineBusiness reviewsOnlineBusinessParent;
    private OnlineStore reviewsOnlineStoreParent;
    private OpinionNewsArticle reviewsOpinionNewsArticleParent;
    private Optician reviewsOpticianParent;
    private Organization reviewsOrganizationParent;
    private OutletStore reviewsOutletStoreParent;
    private Painting reviewsPaintingParent;
    private Park reviewsParkParent;
    private ParkingFacility reviewsParkingFacilityParent;
    private PawnShop reviewsPawnShopParent;
    private PaymentService reviewsPaymentServiceParent;
    private PerformingArtsTheater reviewsPerformingArtsTheaterParent;
    private PerformingGroup reviewsPerformingGroupParent;
    private Periodical reviewsPeriodicalParent;
    private PetStore reviewsPetStoreParent;
    private Pharmacy reviewsPharmacyParent;
    private Photograph reviewsPhotographParent;
    private Physician reviewsPhysicianParent;
    private Place reviewsPlaceParent;
    private PlaceOfWorship reviewsPlaceOfWorshipParent;
    private Play reviewsPlayParent;
    private Playground reviewsPlaygroundParent;
    private Plumber reviewsPlumberParent;
    private PodcastEpisode reviewsPodcastEpisodeParent;
    private PodcastSeason reviewsPodcastSeasonParent;
    private PodcastSeries reviewsPodcastSeriesParent;
    private PoliceStation reviewsPoliceStationParent;
    private Pond reviewsPondParent;
    private Poster reviewsPosterParent;
    private PostOffice reviewsPostOfficeParent;
    private Preschool reviewsPreschoolParent;
    private PresentationDigitalDocument reviewsPresentationDigitalDocumentParent;
    private Product reviewsProductParent;
    private ProductCollection reviewsProductCollectionParent;
    private ProductGroup reviewsProductGroupParent;
    private ProductModel reviewsProductModelParent;
    private ProfessionalService reviewsProfessionalServiceParent;
    private ProfilePage reviewsProfilePageParent;
    private Project reviewsProjectParent;
    private PublicationEvent reviewsPublicationEventParent;
    private PublicationIssue reviewsPublicationIssueParent;
    private PublicationVolume reviewsPublicationVolumeParent;
    private PublicSwimmingPool reviewsPublicSwimmingPoolParent;
    private PublicToilet reviewsPublicToiletParent;
    private QAPage reviewsQAPageParent;
    private Question reviewsQuestionParent;
    private Quiz reviewsQuizParent;
    private Quotation reviewsQuotationParent;
    private RadioBroadcastService reviewsRadioBroadcastServiceParent;
    private RadioClip reviewsRadioClipParent;
    private RadioEpisode reviewsRadioEpisodeParent;
    private RadioSeason reviewsRadioSeasonParent;
    private RadioSeries reviewsRadioSeriesParent;
    private RadioStation reviewsRadioStationParent;
    private RealEstateAgent reviewsRealEstateAgentParent;
    private RealEstateListing reviewsRealEstateListingParent;
    private Recipe reviewsRecipeParent;
    private Recommendation reviewsRecommendationParent;
    private RecyclingCenter reviewsRecyclingCenterParent;
    private Report reviewsReportParent;
    private ReportageNewsArticle reviewsReportageNewsArticleParent;
    private ResearchOrganization reviewsResearchOrganizationParent;
    private ResearchProject reviewsResearchProjectParent;
    private Reservoir reviewsReservoirParent;
    private Residence reviewsResidenceParent;
    private Resort reviewsResortParent;
    private Restaurant reviewsRestaurantParent;
    private Review reviewsReviewParent;
}