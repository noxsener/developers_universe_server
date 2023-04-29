package com.codenfast.developersuniverse.entitydto.schema;

import com.codenfast.developersuniverse.EntityModel;

import java.time.LocalDate;
import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/Organization


/**An organization such as a school, NGO, corporation, club, etc.*/
public class Organization implements EntityModel {
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

private OrganizeAction carrierOrganizeActionParent;
private OutletStore memberOfOutletStoreParent;
private OutletStore subOrganizationOutletStoreParent;
private PaintAction carrierPaintActionParent;
private Painting carrierPaintingParent;
private ParcelDelivery carrierParcelDeliveryParent;
private PawnShop memberOfPawnShopParent;
private PawnShop subOrganizationPawnShopParent;
private PayAction carrierPayActionParent;
private PaymentService bookingAgentPaymentServiceParent;
private PaymentService carrierPaymentServiceParent;
private PerformAction carrierPerformActionParent;
private PerformingGroup memberOfPerformingGroupParent;
private PerformingGroup subOrganizationPerformingGroupParent;
private Periodical carrierPeriodicalParent;
private PetStore memberOfPetStoreParent;
private PetStore subOrganizationPetStoreParent;
private Pharmacy memberOfPharmacyParent;
private Pharmacy subOrganizationPharmacyParent;
private Photograph carrierPhotographParent;
private PhotographAction carrierPhotographActionParent;
private Physician memberOfPhysicianParent;
private Physician subOrganizationPhysicianParent;
private PlanAction carrierPlanActionParent;
private Play carrierPlayParent;
private PlayAction carrierPlayActionParent;
private PlayGameAction carrierPlayGameActionParent;
private Plumber memberOfPlumberParent;
private Plumber subOrganizationPlumberParent;
private PodcastEpisode carrierPodcastEpisodeParent;
private PodcastSeason carrierPodcastSeasonParent;
private PodcastSeries carrierPodcastSeriesParent;
private PoliceStation memberOfPoliceStationParent;
private PoliceStation subOrganizationPoliceStationParent;
private Poster carrierPosterParent;
private PostOffice memberOfPostOfficeParent;
private PostOffice subOrganizationPostOfficeParent;
private PreOrderAction carrierPreOrderActionParent;
private PrependAction carrierPrependActionParent;
private Preschool memberOfPreschoolParent;
private Preschool subOrganizationPreschoolParent;
private PresentationDigitalDocument carrierPresentationDigitalDocumentParent;
private ProductCollection carrierProductCollectionParent;
private ProfessionalService memberOfProfessionalServiceParent;
private ProfessionalService subOrganizationProfessionalServiceParent;
private ProfilePage carrierProfilePageParent;
private ProgramMembership memberOfProgramMembershipParent;
private Project memberOfProjectParent;
private Project subOrganizationProjectParent;
private PublicationEvent attendeesPublicationEventParent;
private PublicationEvent performersPublicationEventParent;
private PublicationIssue carrierPublicationIssueParent;
private PublicationVolume carrierPublicationVolumeParent;
private PublicSwimmingPool memberOfPublicSwimmingPoolParent;
private PublicSwimmingPool subOrganizationPublicSwimmingPoolParent;
private QAPage carrierQAPageParent;
private Question carrierQuestionParent;
private Quiz carrierQuizParent;
private Quotation carrierQuotationParent;
private QuoteAction carrierQuoteActionParent;
private RadioBroadcastService bookingAgentRadioBroadcastServiceParent;
private RadioBroadcastService carrierRadioBroadcastServiceParent;
private RadioClip carrierRadioClipParent;
private RadioEpisode carrierRadioEpisodeParent;
private RadioSeason carrierRadioSeasonParent;
private RadioSeries carrierRadioSeriesParent;
private RadioStation memberOfRadioStationParent;
private RadioStation subOrganizationRadioStationParent;
private ReactAction carrierReactActionParent;
private ReadAction carrierReadActionParent;
private RealEstateAgent memberOfRealEstateAgentParent;
private RealEstateAgent subOrganizationRealEstateAgentParent;
private RealEstateListing carrierRealEstateListingParent;
private ReceiveAction carrierReceiveActionParent;
private Recipe carrierRecipeParent;
private Recommendation carrierRecommendationParent;
private RecyclingCenter memberOfRecyclingCenterParent;
private RecyclingCenter subOrganizationRecyclingCenterParent;
private RegisterAction carrierRegisterActionParent;
private RejectAction carrierRejectActionParent;
private RentAction carrierRentActionParent;
private RentalCarReservation bookingAgentRentalCarReservationParent;
private RentalCarReservation carrierRentalCarReservationParent;
private ReplaceAction carrierReplaceActionParent;
private ReplyAction carrierReplyActionParent;
private Report carrierReportParent;
private ReportageNewsArticle carrierReportageNewsArticleParent;
private ResearchOrganization memberOfResearchOrganizationParent;
private ResearchOrganization subOrganizationResearchOrganizationParent;
private ResearchProject memberOfResearchProjectParent;
private ResearchProject subOrganizationResearchProjectParent;
private Reservation bookingAgentReservationParent;
private Reservation carrierReservationParent;
private ReservationPackage bookingAgentReservationPackageParent;
private ReservationPackage carrierReservationPackageParent;
private ReserveAction carrierReserveActionParent;
private Resort memberOfResortParent;
private Resort subOrganizationResortParent;
private Restaurant memberOfRestaurantParent;
private Restaurant subOrganizationRestaurantParent;
private ResumeAction carrierResumeActionParent;
private ReturnAction carrierReturnActionParent;
private Review carrierReviewParent;
private ReviewAction carrierReviewActionParent;
private ReviewNewsArticle carrierReviewNewsArticleParent;
private RoofingContractor memberOfRoofingContractorParent;
private RoofingContractor subOrganizationRoofingContractorParent;
private RsvpAction carrierRsvpActionParent;
private SaleEvent attendeesSaleEventParent;
private SaleEvent performersSaleEventParent;
private SatiricalArticle carrierSatiricalArticleParent;
private ScheduleAction carrierScheduleActionParent;
private SchemaOrgTable carrierSchemaOrgTableParent;
private ScholarlyArticle carrierScholarlyArticleParent;
private School memberOfSchoolParent;
private School subOrganizationSchoolParent;
private ScreeningEvent attendeesScreeningEventParent;
private ScreeningEvent performersScreeningEventParent;
private Sculpture carrierSculptureParent;
private SearchAction carrierSearchActionParent;
private SearchRescueOrganization memberOfSearchRescueOrganizationParent;
private SearchRescueOrganization subOrganizationSearchRescueOrganizationParent;
private SearchResultsPage carrierSearchResultsPageParent;
private Season carrierSeasonParent;
private SeekToAction carrierSeekToActionParent;
private SelfStorage memberOfSelfStorageParent;
private SelfStorage subOrganizationSelfStorageParent;
private SellAction carrierSellActionParent;
private SendAction carrierSendActionParent;
private Service bookingAgentServiceParent;
private Service carrierServiceParent;
private ShareAction carrierShareActionParent;
private SheetMusic carrierSheetMusicParent;
private ShoeStore memberOfShoeStoreParent;
private ShoeStore subOrganizationShoeStoreParent;
private ShoppingCenter memberOfShoppingCenterParent;
private ShoppingCenter subOrganizationShoppingCenterParent;
private ShortStory carrierShortStoryParent;
private SiteNavigationElement carrierSiteNavigationElementParent;
private SkiResort memberOfSkiResortParent;
private SkiResort subOrganizationSkiResortParent;
private SocialEvent attendeesSocialEventParent;
private SocialEvent performersSocialEventParent;
private SocialMediaPosting carrierSocialMediaPostingParent;
private SoftwareApplication carrierSoftwareApplicationParent;
private SoftwareSourceCode carrierSoftwareSourceCodeParent;
private SolveMathAction carrierSolveMathActionParent;
private SpecialAnnouncement carrierSpecialAnnouncementParent;
private SportingGoodsStore memberOfSportingGoodsStoreParent;
private SportingGoodsStore subOrganizationSportingGoodsStoreParent;
private SportsActivityLocation memberOfSportsActivityLocationParent;
private SportsActivityLocation subOrganizationSportsActivityLocationParent;
private SportsClub memberOfSportsClubParent;
private SportsClub subOrganizationSportsClubParent;
private SportsEvent attendeesSportsEventParent;
private SportsEvent performersSportsEventParent;
private SportsOrganization memberOfSportsOrganizationParent;
private SportsOrganization subOrganizationSportsOrganizationParent;
private SportsTeam memberOfSportsTeamParent;
private SportsTeam subOrganizationSportsTeamParent;
private SpreadsheetDigitalDocument carrierSpreadsheetDigitalDocumentParent;
private StadiumOrArena memberOfStadiumOrArenaParent;
private StadiumOrArena subOrganizationStadiumOrArenaParent;
private Statement carrierStatementParent;
private Store memberOfStoreParent;
private Store subOrganizationStoreParent;
private SubscribeAction carrierSubscribeActionParent;
private SuspendAction carrierSuspendActionParent;
private TakeAction carrierTakeActionParent;
private TattooParlor memberOfTattooParlorParent;
private TattooParlor subOrganizationTattooParlorParent;
private Taxi bookingAgentTaxiParent;
private Taxi carrierTaxiParent;
private TaxiReservation bookingAgentTaxiReservationParent;
private TaxiReservation carrierTaxiReservationParent;
private TaxiService bookingAgentTaxiServiceParent;
private TaxiService carrierTaxiServiceParent;
private TechArticle carrierTechArticleParent;
private TelevisionStation memberOfTelevisionStationParent;
private TelevisionStation subOrganizationTelevisionStationParent;
private TennisComplex memberOfTennisComplexParent;
private TennisComplex subOrganizationTennisComplexParent;
private TextDigitalDocument carrierTextDigitalDocumentParent;
private TheaterEvent attendeesTheaterEventParent;
private TheaterEvent performersTheaterEventParent;
private TheaterGroup memberOfTheaterGroupParent;
private TheaterGroup subOrganizationTheaterGroupParent;
private Thesis carrierThesisParent;
private ThreeDModel carrierThreeDModelParent;
private TieAction carrierTieActionParent;
private TipAction carrierTipActionParent;
private TireShop memberOfTireShopParent;
private TireShop subOrganizationTireShopParent;
private TouristInformationCenter memberOfTouristInformationCenterParent;
private TouristInformationCenter subOrganizationTouristInformationCenterParent;
private TouristTrip carrierTouristTripParent;
private ToyStore memberOfToyStoreParent;
private ToyStore subOrganizationToyStoreParent;
private TrackAction carrierTrackActionParent;
private TradeAction carrierTradeActionParent;
private TrainReservation bookingAgentTrainReservationParent;
private TrainReservation carrierTrainReservationParent;
private TrainTrip carrierTrainTripParent;
private TransferAction carrierTransferActionParent;
private TravelAction carrierTravelActionParent;
private TravelAgency memberOfTravelAgencyParent;
private TravelAgency subOrganizationTravelAgencyParent;
private Trip carrierTripParent;
private TVClip carrierTVClipParent;
private TVEpisode carrierTVEpisodeParent;
private TVSeason carrierTVSeasonParent;
private TVSeries carrierTVSeriesParent;
private UnRegisterAction carrierUnRegisterActionParent;
private UpdateAction carrierUpdateActionParent;
private UseAction carrierUseActionParent;
private UserBlocks attendeesUserBlocksParent;
private UserBlocks performersUserBlocksParent;
private UserCheckins attendeesUserCheckinsParent;
private UserCheckins performersUserCheckinsParent;
private UserComments attendeesUserCommentsParent;
private UserComments performersUserCommentsParent;
private UserDownloads attendeesUserDownloadsParent;
private UserDownloads performersUserDownloadsParent;
private UserInteraction attendeesUserInteractionParent;
private UserInteraction performersUserInteractionParent;
private UserLikes attendeesUserLikesParent;
private UserLikes performersUserLikesParent;
private UserPageVisits attendeesUserPageVisitsParent;
private UserPageVisits performersUserPageVisitsParent;
private UserPlays attendeesUserPlaysParent;
private UserPlays performersUserPlaysParent;
private UserPlusOnes attendeesUserPlusOnesParent;
private UserPlusOnes performersUserPlusOnesParent;
private UserReview carrierUserReviewParent;
private UserTweets attendeesUserTweetsParent;
private UserTweets performersUserTweetsParent;
private VeterinaryCare memberOfVeterinaryCareParent;
private VeterinaryCare subOrganizationVeterinaryCareParent;
private VideoGallery carrierVideoGalleryParent;
private VideoGame carrierVideoGameParent;
private VideoGameClip carrierVideoGameClipParent;
private VideoGameSeries carrierVideoGameSeriesParent;
private VideoObject carrierVideoObjectParent;
private VideoObjectSnapshot carrierVideoObjectSnapshotParent;
private ViewAction carrierViewActionParent;
private VisualArtsEvent attendeesVisualArtsEventParent;
private VisualArtsEvent performersVisualArtsEventParent;
private VisualArtwork carrierVisualArtworkParent;
private VoteAction carrierVoteActionParent;
private WantAction carrierWantActionParent;
private WatchAction carrierWatchActionParent;
private WearAction carrierWearActionParent;
private WebAPI bookingAgentWebAPIParent;
private WebAPI carrierWebAPIParent;
private WebApplication carrierWebApplicationParent;
private WebContent carrierWebContentParent;
private WebPage carrierWebPageParent;
private WebPageElement carrierWebPageElementParent;
private WebPageTable carrierWebPageTableParent;
private WebSite carrierWebSiteParent;
private WholesaleStore memberOfWholesaleStoreParent;
private WholesaleStore subOrganizationWholesaleStoreParent;
private WinAction carrierWinActionParent;
private Winery memberOfWineryParent;
private Winery subOrganizationWineryParent;
private WorkBasedProgram carrierWorkBasedProgramParent;
private WorkersUnion memberOfWorkersUnionParent;
private WorkersUnion subOrganizationWorkersUnionParent;
private WPAdBlock carrierWPAdBlockParent;
private WPFooter carrierWPFooterParent;
private WPHeader carrierWPHeaderParent;
private WPSideBar carrierWPSideBarParent;
private WriteAction carrierWriteActionParent;
private WTable carrierWTableParent;

            private APIReference carrierAPIReferenceParent;
            private AboutPage carrierAboutPageParent;
            private AcceptAction carrierAcceptActionParent;
private AccountingService memberOfAccountingServiceParent;
private AccountingService subOrganizationAccountingServiceParent;
private AchieveAction carrierAchieveActionParent;
private Action carrierActionParent;
private ActivateAction carrierActivateActionParent;
private AddAction carrierAddActionParent;
private AdultEntertainment memberOfAdultEntertainmentParent;
private AdultEntertainment subOrganizationAdultEntertainmentParent;
private AdvertiserContentArticle carrierAdvertiserContentArticleParent;
private AggregateOffer vendorAggregateOfferParent;
private AgreeAction carrierAgreeActionParent;
private Airline memberOfAirlineParent;
private Airline subOrganizationAirlineParent;
private AllocateAction carrierAllocateActionParent;
private AmpStory carrierAmpStoryParent;
private AmusementPark memberOfAmusementParkParent;
private AmusementPark subOrganizationAmusementParkParent;
private AnalysisNewsArticle carrierAnalysisNewsArticleParent;
private AnimalShelter memberOfAnimalShelterParent;
private AnimalShelter subOrganizationAnimalShelterParent;
private Answer carrierAnswerParent;
private AppendAction carrierAppendActionParent;
private ApplyAction carrierApplyActionParent;
private ArchiveComponent carrierArchiveComponentParent;
private ArchiveOrganization memberOfArchiveOrganizationParent;
private ArchiveOrganization subOrganizationArchiveOrganizationParent;
private ArriveAction carrierArriveActionParent;
private ArtGallery memberOfArtGalleryParent;
private ArtGallery subOrganizationArtGalleryParent;
private Article carrierArticleParent;
private AskAction carrierAskActionParent;
private AskPublicNewsArticle carrierAskPublicNewsArticleParent;
private AssessAction carrierAssessActionParent;
private AssignAction carrierAssignActionParent;
private Atlas carrierAtlasParent;
private Attorney memberOfAttorneyParent;
private Attorney subOrganizationAttorneyParent;
private Audiobook carrierAudiobookParent;
private AudioObject carrierAudioObjectParent;
private AudioObjectSnapshot carrierAudioObjectSnapshotParent;
private AuthorizeAction carrierAuthorizeActionParent;
private AutoBodyShop memberOfAutoBodyShopParent;
private AutoBodyShop subOrganizationAutoBodyShopParent;
private AutoDealer memberOfAutoDealerParent;
private AutoDealer subOrganizationAutoDealerParent;
private AutomatedTeller memberOfAutomatedTellerParent;
private AutomatedTeller subOrganizationAutomatedTellerParent;
private AutomotiveBusiness memberOfAutomotiveBusinessParent;
private AutomotiveBusiness subOrganizationAutomotiveBusinessParent;
private AutoPartsStore memberOfAutoPartsStoreParent;
private AutoPartsStore subOrganizationAutoPartsStoreParent;
private AutoRental memberOfAutoRentalParent;
private AutoRental subOrganizationAutoRentalParent;
private AutoRepair memberOfAutoRepairParent;
private AutoRepair subOrganizationAutoRepairParent;
private AutoWash memberOfAutoWashParent;
private AutoWash subOrganizationAutoWashParent;
private BackgroundNewsArticle carrierBackgroundNewsArticleParent;
private Bakery memberOfBakeryParent;
private Bakery subOrganizationBakeryParent;
private BankAccount bookingAgentBankAccountParent;
private BankAccount carrierBankAccountParent;
private BankOrCreditUnion memberOfBankOrCreditUnionParent;
private BankOrCreditUnion subOrganizationBankOrCreditUnionParent;
private Barcode carrierBarcodeParent;
private BarOrPub memberOfBarOrPubParent;
private BarOrPub subOrganizationBarOrPubParent;
private BeautySalon memberOfBeautySalonParent;
private BeautySalon subOrganizationBeautySalonParent;
private BedAndBreakfast memberOfBedAndBreakfastParent;
private BedAndBreakfast subOrganizationBedAndBreakfastParent;
private BefriendAction carrierBefriendActionParent;
private BikeStore memberOfBikeStoreParent;
private BikeStore subOrganizationBikeStoreParent;
private Blog carrierBlogParent;
private BlogPosting carrierBlogPostingParent;
private BoatReservation bookingAgentBoatReservationParent;
private BoatReservation carrierBoatReservationParent;
private BoatTrip carrierBoatTripParent;
private Book carrierBookParent;
private BookmarkAction carrierBookmarkActionParent;
private BookSeries carrierBookSeriesParent;
private BookStore memberOfBookStoreParent;
private BookStore subOrganizationBookStoreParent;
private BorrowAction carrierBorrowActionParent;
private BowlingAlley memberOfBowlingAlleyParent;
private BowlingAlley subOrganizationBowlingAlleyParent;
private Brewery memberOfBreweryParent;
private Brewery subOrganizationBreweryParent;
private BroadcastEvent attendeesBroadcastEventParent;
private BroadcastEvent performersBroadcastEventParent;
private BroadcastService bookingAgentBroadcastServiceParent;
private BroadcastService carrierBroadcastServiceParent;
private BrokerageAccount bookingAgentBrokerageAccountParent;
private BrokerageAccount carrierBrokerageAccountParent;
private BusinessEvent attendeesBusinessEventParent;
private BusinessEvent performersBusinessEventParent;
private BusReservation bookingAgentBusReservationParent;
private BusReservation carrierBusReservationParent;
private BusTrip carrierBusTripParent;
private BuyAction vendorBuyActionParent;
private BuyAction carrierBuyActionParent;
private CableOrSatelliteService bookingAgentCableOrSatelliteServiceParent;
private CableOrSatelliteService carrierCableOrSatelliteServiceParent;
private CafeOrCoffeeShop memberOfCafeOrCoffeeShopParent;
private CafeOrCoffeeShop subOrganizationCafeOrCoffeeShopParent;
private Campground memberOfCampgroundParent;
private Campground subOrganizationCampgroundParent;
private CancelAction carrierCancelActionParent;
private Casino memberOfCasinoParent;
private Casino subOrganizationCasinoParent;
private CategoryCodeSet carrierCategoryCodeSetParent;
private Chapter carrierChapterParent;
private CheckAction carrierCheckActionParent;
private CheckInAction carrierCheckInActionParent;
private CheckOutAction carrierCheckOutActionParent;
private CheckoutPage carrierCheckoutPageParent;
private ChildCare memberOfChildCareParent;
private ChildCare subOrganizationChildCareParent;
private ChildrensEvent attendeesChildrensEventParent;
private ChildrensEvent performersChildrensEventParent;
private ChooseAction carrierChooseActionParent;
private Claim carrierClaimParent;
private ClaimReview carrierClaimReviewParent;
private Clip carrierClipParent;
private ClothingStore memberOfClothingStoreParent;
private ClothingStore subOrganizationClothingStoreParent;
private Code carrierCodeParent;
private Collection carrierCollectionParent;
private CollectionPage carrierCollectionPageParent;
private CollegeOrUniversity memberOfCollegeOrUniversityParent;
private CollegeOrUniversity subOrganizationCollegeOrUniversityParent;
private ComedyClub memberOfComedyClubParent;
private ComedyClub subOrganizationComedyClubParent;
private ComedyEvent attendeesComedyEventParent;
private ComedyEvent performersComedyEventParent;
private ComicCoverArt carrierComicCoverArtParent;
private ComicIssue carrierComicIssueParent;
private ComicSeries carrierComicSeriesParent;
private ComicStory carrierComicStoryParent;
private Comment carrierCommentParent;
private CommentAction carrierCommentActionParent;
private CommunicateAction carrierCommunicateActionParent;
private CompleteDataFeed carrierCompleteDataFeedParent;
private ComputerStore memberOfComputerStoreParent;
private ComputerStore subOrganizationComputerStoreParent;
private ConfirmAction carrierConfirmActionParent;
private Consortium memberOfConsortiumParent;
private Consortium subOrganizationConsortiumParent;
private ConsumeAction carrierConsumeActionParent;
private ContactPage carrierContactPageParent;
private ControlAction carrierControlActionParent;
private ConvenienceStore memberOfConvenienceStoreParent;
private ConvenienceStore subOrganizationConvenienceStoreParent;
private Conversation carrierConversationParent;
private CookAction carrierCookActionParent;
private Corporation memberOfCorporationParent;
private Corporation subOrganizationCorporationParent;
private CorrectionComment carrierCorrectionCommentParent;
private Course carrierCourseParent;
private CourseInstance attendeesCourseInstanceParent;
private CourseInstance performersCourseInstanceParent;
private CoverArt carrierCoverArtParent;
private CovidTestingFacility memberOfCovidTestingFacilityParent;
private CovidTestingFacility subOrganizationCovidTestingFacilityParent;
private CreateAction carrierCreateActionParent;
private CreativeWork carrierCreativeWorkParent;
private CreativeWorkSeason carrierCreativeWorkSeasonParent;
private CreativeWorkSeries carrierCreativeWorkSeriesParent;
private CriticReview carrierCriticReviewParent;
private CurrencyConversionService bookingAgentCurrencyConversionServiceParent;
private CurrencyConversionService carrierCurrencyConversionServiceParent;
private DanceEvent attendeesDanceEventParent;
private DanceEvent performersDanceEventParent;
private DanceGroup memberOfDanceGroupParent;
private DanceGroup subOrganizationDanceGroupParent;
private DataCatalog carrierDataCatalogParent;
private DataDownload carrierDataDownloadParent;
private DataFeed carrierDataFeedParent;
private Dataset carrierDatasetParent;
private DaySpa memberOfDaySpaParent;
private DaySpa subOrganizationDaySpaParent;
private DeactivateAction carrierDeactivateActionParent;
private DefinedTermSet carrierDefinedTermSetParent;
private DeleteAction carrierDeleteActionParent;
private DeliveryEvent attendeesDeliveryEventParent;
private DeliveryEvent performersDeliveryEventParent;
private Demand vendorDemandParent;
private Dentist memberOfDentistParent;
private Dentist subOrganizationDentistParent;
private DepartAction carrierDepartActionParent;
private DepartmentStore memberOfDepartmentStoreParent;
private DepartmentStore subOrganizationDepartmentStoreParent;
private DepositAccount bookingAgentDepositAccountParent;
private DepositAccount carrierDepositAccountParent;
private DiagnosticLab memberOfDiagnosticLabParent;
private DiagnosticLab subOrganizationDiagnosticLabParent;
private DigitalDocument carrierDigitalDocumentParent;
private DisagreeAction carrierDisagreeActionParent;
private DiscoverAction carrierDiscoverActionParent;
private DiscussionForumPosting carrierDiscussionForumPostingParent;
private DislikeAction carrierDislikeActionParent;
private Distillery memberOfDistilleryParent;
private Distillery subOrganizationDistilleryParent;
private DonateAction carrierDonateActionParent;
private DownloadAction carrierDownloadActionParent;
private DrawAction carrierDrawActionParent;
private Drawing carrierDrawingParent;
private DrinkAction carrierDrinkActionParent;
private DryCleaningOrLaundry memberOfDryCleaningOrLaundryParent;
private DryCleaningOrLaundry subOrganizationDryCleaningOrLaundryParent;
private EatAction carrierEatActionParent;
private EducationalOccupationalCredential carrierEducationalOccupationalCredentialParent;
private EducationalOccupationalProgram carrierEducationalOccupationalProgramParent;
private EducationalOrganization memberOfEducationalOrganizationParent;
private EducationalOrganization subOrganizationEducationalOrganizationParent;
private EducationEvent attendeesEducationEventParent;
private EducationEvent performersEducationEventParent;
private Electrician memberOfElectricianParent;
private Electrician subOrganizationElectricianParent;
private ElectronicsStore memberOfElectronicsStoreParent;
private ElectronicsStore subOrganizationElectronicsStoreParent;
private ElementarySchool memberOfElementarySchoolParent;
private ElementarySchool subOrganizationElementarySchoolParent;
private EmailMessage carrierEmailMessageParent;
private EmergencyService memberOfEmergencyServiceParent;
private EmergencyService subOrganizationEmergencyServiceParent;
private EmployerReview carrierEmployerReviewParent;
private EmploymentAgency memberOfEmploymentAgencyParent;
private EmploymentAgency subOrganizationEmploymentAgencyParent;
private EndorseAction carrierEndorseActionParent;
private EntertainmentBusiness memberOfEntertainmentBusinessParent;
private EntertainmentBusiness subOrganizationEntertainmentBusinessParent;
private Episode carrierEpisodeParent;
private Event attendeesEventParent;
private Event performersEventParent;
private EventReservation bookingAgentEventReservationParent;
private EventReservation carrierEventReservationParent;
private EventSeries attendeesEventSeriesParent;
private EventSeries performersEventSeriesParent;
private ExerciseAction carrierExerciseActionParent;
private ExerciseGym memberOfExerciseGymParent;
private ExerciseGym subOrganizationExerciseGymParent;
private ExhibitionEvent attendeesExhibitionEventParent;
private ExhibitionEvent performersExhibitionEventParent;
private FAQPage carrierFAQPageParent;
private FastFoodRestaurant memberOfFastFoodRestaurantParent;
private FastFoodRestaurant subOrganizationFastFoodRestaurantParent;
private Festival attendeesFestivalParent;
private Festival performersFestivalParent;
private FilmAction carrierFilmActionParent;
private FinancialProduct bookingAgentFinancialProductParent;
private FinancialProduct carrierFinancialProductParent;
private FinancialService memberOfFinancialServiceParent;
private FinancialService subOrganizationFinancialServiceParent;
private FindAction carrierFindActionParent;
private FireStation memberOfFireStationParent;
private FireStation subOrganizationFireStationParent;
private Flight vendorFlightParent;
private Flight carrierFlightParent;
private FlightReservation bookingAgentFlightReservationParent;
private FlightReservation carrierFlightReservationParent;
private Florist memberOfFloristParent;
private Florist subOrganizationFloristParent;
private FollowAction carrierFollowActionParent;
private FoodEstablishment memberOfFoodEstablishmentParent;
private FoodEstablishment subOrganizationFoodEstablishmentParent;
private FoodEstablishmentReservation bookingAgentFoodEstablishmentReservationParent;
private FoodEstablishmentReservation carrierFoodEstablishmentReservationParent;
private FoodEvent attendeesFoodEventParent;
private FoodEvent performersFoodEventParent;
private FoodService bookingAgentFoodServiceParent;
private FoodService carrierFoodServiceParent;
private FundingAgency memberOfFundingAgencyParent;
private FundingAgency subOrganizationFundingAgencyParent;
private FundingScheme memberOfFundingSchemeParent;
private FundingScheme subOrganizationFundingSchemeParent;
private FurnitureStore memberOfFurnitureStoreParent;
private FurnitureStore subOrganizationFurnitureStoreParent;
private Game carrierGameParent;
private GardenStore memberOfGardenStoreParent;
private GardenStore subOrganizationGardenStoreParent;
private GasStation memberOfGasStationParent;
private GasStation subOrganizationGasStationParent;
private GeneralContractor memberOfGeneralContractorParent;
private GeneralContractor subOrganizationGeneralContractorParent;
private GiveAction carrierGiveActionParent;
private GolfCourse memberOfGolfCourseParent;
private GolfCourse subOrganizationGolfCourseParent;
private GovernmentOffice memberOfGovernmentOfficeParent;
private GovernmentOffice subOrganizationGovernmentOfficeParent;
private GovernmentOrganization memberOfGovernmentOrganizationParent;
private GovernmentOrganization subOrganizationGovernmentOrganizationParent;
private GovernmentService bookingAgentGovernmentServiceParent;
private GovernmentService carrierGovernmentServiceParent;
private GroceryStore memberOfGroceryStoreParent;
private GroceryStore subOrganizationGroceryStoreParent;
private Guide carrierGuideParent;
private Hackathon attendeesHackathonParent;
private Hackathon performersHackathonParent;
private HairSalon memberOfHairSalonParent;
private HairSalon subOrganizationHairSalonParent;
private HardwareStore memberOfHardwareStoreParent;
private HardwareStore subOrganizationHardwareStoreParent;
private HealthAndBeautyBusiness memberOfHealthAndBeautyBusinessParent;
private HealthAndBeautyBusiness subOrganizationHealthAndBeautyBusinessParent;
private HealthClub memberOfHealthClubParent;
private HealthClub subOrganizationHealthClubParent;
private HealthTopicContent carrierHealthTopicContentParent;
private HighSchool memberOfHighSchoolParent;
private HighSchool subOrganizationHighSchoolParent;
private HobbyShop memberOfHobbyShopParent;
private HobbyShop subOrganizationHobbyShopParent;
private HomeAndConstructionBusiness memberOfHomeAndConstructionBusinessParent;
private HomeAndConstructionBusiness subOrganizationHomeAndConstructionBusinessParent;
private HomeGoodsStore memberOfHomeGoodsStoreParent;
private HomeGoodsStore subOrganizationHomeGoodsStoreParent;
private Hospital memberOfHospitalParent;
private Hospital subOrganizationHospitalParent;
private Hostel memberOfHostelParent;
private Hostel subOrganizationHostelParent;
private Hotel memberOfHotelParent;
private Hotel subOrganizationHotelParent;
private HousePainter memberOfHousePainterParent;
private HousePainter subOrganizationHousePainterParent;
private HowTo carrierHowToParent;
private HowToDirection carrierHowToDirectionParent;
private HowToSection carrierHowToSectionParent;
private HowToStep carrierHowToStepParent;
private HowToTip carrierHowToTipParent;
private HVACBusiness memberOfHVACBusinessParent;
private HVACBusiness subOrganizationHVACBusinessParent;
private HyperToc carrierHyperTocParent;
private HyperTocEntry carrierHyperTocEntryParent;
private IceCreamShop memberOfIceCreamShopParent;
private IceCreamShop subOrganizationIceCreamShopParent;
private IgnoreAction carrierIgnoreActionParent;
private ImageGallery carrierImageGalleryParent;
private ImageObject carrierImageObjectParent;
private ImageObjectSnapshot carrierImageObjectSnapshotParent;
private InformAction carrierInformActionParent;
private InsertAction carrierInsertActionParent;
private InstallAction carrierInstallActionParent;
private InsuranceAgency memberOfInsuranceAgencyParent;
private InsuranceAgency subOrganizationInsuranceAgencyParent;
private InteractAction carrierInteractActionParent;
private InternetCafe memberOfInternetCafeParent;
private InternetCafe subOrganizationInternetCafeParent;
private InvestmentFund bookingAgentInvestmentFundParent;
private InvestmentFund carrierInvestmentFundParent;
private InvestmentOrDeposit bookingAgentInvestmentOrDepositParent;
private InvestmentOrDeposit carrierInvestmentOrDepositParent;
private InviteAction carrierInviteActionParent;
private Invoice bookingAgentInvoiceParent;
private Invoice carrierInvoiceParent;
private ItemPage carrierItemPageParent;
private JewelryStore memberOfJewelryStoreParent;
private JewelryStore subOrganizationJewelryStoreParent;
private JoinAction carrierJoinActionParent;
private LearningResource carrierLearningResourceParent;
private LeaveAction carrierLeaveActionParent;
private LegalService memberOfLegalServiceParent;
private LegalService subOrganizationLegalServiceParent;
private Legislation carrierLegislationParent;
private LegislationObject carrierLegislationObjectParent;
private LendAction carrierLendActionParent;
private Library memberOfLibraryParent;
private Library subOrganizationLibraryParent;
private LibrarySystem memberOfLibrarySystemParent;
private LibrarySystem subOrganizationLibrarySystemParent;
private LikeAction carrierLikeActionParent;
private LiquorStore memberOfLiquorStoreParent;
private LiquorStore subOrganizationLiquorStoreParent;
private ListenAction carrierListenActionParent;
private LiteraryEvent attendeesLiteraryEventParent;
private LiteraryEvent performersLiteraryEventParent;
private LiveBlogPosting carrierLiveBlogPostingParent;
private LoanOrCredit bookingAgentLoanOrCreditParent;
private LoanOrCredit carrierLoanOrCreditParent;
private LocalBusiness memberOfLocalBusinessParent;
private LocalBusiness subOrganizationLocalBusinessParent;
private Locksmith memberOfLocksmithParent;
private Locksmith subOrganizationLocksmithParent;
private LodgingBusiness memberOfLodgingBusinessParent;
private LodgingBusiness subOrganizationLodgingBusinessParent;
private LodgingReservation bookingAgentLodgingReservationParent;
private LodgingReservation carrierLodgingReservationParent;
private LoseAction carrierLoseActionParent;
private Manuscript carrierManuscriptParent;
private Map carrierMapParent;
private MarryAction carrierMarryActionParent;
private MathSolver carrierMathSolverParent;
private MediaGallery carrierMediaGalleryParent;
private MediaObject carrierMediaObjectParent;
private MediaReview carrierMediaReviewParent;
private MediaReviewItem carrierMediaReviewItemParent;
private MedicalBusiness memberOfMedicalBusinessParent;
private MedicalBusiness subOrganizationMedicalBusinessParent;
private MedicalClinic memberOfMedicalClinicParent;
private MedicalClinic subOrganizationMedicalClinicParent;
private MedicalOrganization memberOfMedicalOrganizationParent;
private MedicalOrganization subOrganizationMedicalOrganizationParent;
private MedicalScholarlyArticle carrierMedicalScholarlyArticleParent;
private MedicalWebPage carrierMedicalWebPageParent;
private MensClothingStore memberOfMensClothingStoreParent;
private MensClothingStore subOrganizationMensClothingStoreParent;
private Menu carrierMenuParent;
private MenuSection carrierMenuSectionParent;
private Message carrierMessageParent;
private MiddleSchool memberOfMiddleSchoolParent;
private MiddleSchool subOrganizationMiddleSchoolParent;
private MobileApplication carrierMobileApplicationParent;
private MobilePhoneStore memberOfMobilePhoneStoreParent;
private MobilePhoneStore subOrganizationMobilePhoneStoreParent;
private MoneyTransfer carrierMoneyTransferParent;
private MortgageLoan bookingAgentMortgageLoanParent;
private MortgageLoan carrierMortgageLoanParent;
private Motel memberOfMotelParent;
private Motel subOrganizationMotelParent;
private MotorcycleDealer memberOfMotorcycleDealerParent;
private MotorcycleDealer subOrganizationMotorcycleDealerParent;
private MotorcycleRepair memberOfMotorcycleRepairParent;
private MotorcycleRepair subOrganizationMotorcycleRepairParent;
private MoveAction carrierMoveActionParent;
private Movie carrierMovieParent;
private MovieClip carrierMovieClipParent;
private MovieRentalStore memberOfMovieRentalStoreParent;
private MovieRentalStore subOrganizationMovieRentalStoreParent;
private MovieSeries carrierMovieSeriesParent;
private MovieTheater memberOfMovieTheaterParent;
private MovieTheater subOrganizationMovieTheaterParent;
private MovingCompany memberOfMovingCompanyParent;
private MovingCompany subOrganizationMovingCompanyParent;
private MusicAlbum carrierMusicAlbumParent;
private MusicComposition carrierMusicCompositionParent;
private MusicEvent attendeesMusicEventParent;
private MusicEvent performersMusicEventParent;
private MusicGroup memberOfMusicGroupParent;
private MusicGroup subOrganizationMusicGroupParent;
private MusicPlaylist carrierMusicPlaylistParent;
private MusicRecording carrierMusicRecordingParent;
private MusicRelease carrierMusicReleaseParent;
private MusicStore memberOfMusicStoreParent;
private MusicStore subOrganizationMusicStoreParent;
private MusicVideoObject carrierMusicVideoObjectParent;
private NailSalon memberOfNailSalonParent;
private NailSalon subOrganizationNailSalonParent;
private NewsArticle carrierNewsArticleParent;
private NewsMediaOrganization memberOfNewsMediaOrganizationParent;
private NewsMediaOrganization subOrganizationNewsMediaOrganizationParent;
private Newspaper carrierNewspaperParent;
private NGO memberOfNGOParent;
private NGO subOrganizationNGOParent;
private NightClub memberOfNightClubParent;
private NightClub subOrganizationNightClubParent;
private Notary memberOfNotaryParent;
private Notary subOrganizationNotaryParent;
private NoteDigitalDocument carrierNoteDigitalDocumentParent;
private Offer vendorOfferParent;
private OfferForLease vendorOfferForLeaseParent;
private OfferForPurchase vendorOfferForPurchaseParent;
private OfficeEquipmentStore memberOfOfficeEquipmentStoreParent;
private OfficeEquipmentStore subOrganizationOfficeEquipmentStoreParent;
private OnDemandEvent attendeesOnDemandEventParent;
private OnDemandEvent performersOnDemandEventParent;
private OnlineBusiness memberOfOnlineBusinessParent;
private OnlineBusiness subOrganizationOnlineBusinessParent;
private OnlineStore memberOfOnlineStoreParent;
private OnlineStore subOrganizationOnlineStoreParent;
private OpinionNewsArticle carrierOpinionNewsArticleParent;
private Optician memberOfOpticianParent;
private Optician subOrganizationOpticianParent;
private Order bookingAgentOrderParent;
private Order vendorOrderParent;
private OrderAction carrierOrderActionParent;
private Organization memberOfOrganizationParent;
private Organization subOrganizationOrganizationParent;
}