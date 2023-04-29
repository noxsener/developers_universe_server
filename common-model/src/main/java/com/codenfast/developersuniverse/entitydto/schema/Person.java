package com.codenfast.developersuniverse.entitydto.schema;

import com.codenfast.developersuniverse.EntityModel;

import java.time.LocalDate;
import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/Person


/**A person (alive, dead, undead, or fictional).*/
public class Person implements EntityModel {
    private String id;
    private Boolean passive = Boolean.FALSE;
    private LocalDateTime createTime = null;
    private LocalDateTime updateTime = null;


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

    private PetStore employeesPetStoreParent;
    private PetStore foundersPetStoreParent;
    private Pharmacy employeesPharmacyParent;
    private Pharmacy foundersPharmacyParent;
    private Physician employeesPhysicianParent;
    private Physician foundersPhysicianParent;
    private Plumber employeesPlumberParent;
    private Plumber foundersPlumberParent;
    private PodcastEpisode actorsPodcastEpisodeParent;
    private PodcastEpisode directorsPodcastEpisodeParent;
    private PodcastSeason actorsPodcastSeasonParent;
    private PodcastSeason directorsPodcastSeasonParent;
    private PodcastSeries actorsPodcastSeriesParent;
    private PoliceStation employeesPoliceStationParent;
    private PoliceStation foundersPoliceStationParent;
    private PostOffice employeesPostOfficeParent;
    private PostOffice foundersPostOfficeParent;
    private Preschool employeesPreschoolParent;
    private Preschool foundersPreschoolParent;
    private ProfessionalService employeesProfessionalServiceParent;
    private ProfessionalService foundersProfessionalServiceParent;
    private Project employeesProjectParent;
    private Project foundersProjectParent;
    private PublicationEvent actorsPublicationEventParent;
    private PublicationEvent directorsPublicationEventParent;
    private PublicSwimmingPool employeesPublicSwimmingPoolParent;
    private PublicSwimmingPool foundersPublicSwimmingPoolParent;
    private RadioClip actorsRadioClipParent;
    private RadioClip directorsRadioClipParent;
    private RadioEpisode actorsRadioEpisodeParent;
    private RadioEpisode directorsRadioEpisodeParent;
    private RadioSeason actorsRadioSeasonParent;
    private RadioSeason directorsRadioSeasonParent;
    private RadioSeries actorsRadioSeriesParent;
    private RadioSeries directorsRadioSeriesParent;
    private RadioStation employeesRadioStationParent;
    private RadioStation foundersRadioStationParent;
    private RealEstateAgent employeesRealEstateAgentParent;
    private RealEstateAgent foundersRealEstateAgentParent;
    private RecyclingCenter employeesRecyclingCenterParent;
    private RecyclingCenter foundersRecyclingCenterParent;
    private ResearchOrganization employeesResearchOrganizationParent;
    private ResearchOrganization foundersResearchOrganizationParent;
    private ResearchProject employeesResearchProjectParent;
    private ResearchProject foundersResearchProjectParent;
    private Resort employeesResortParent;
    private Resort foundersResortParent;
    private Restaurant employeesRestaurantParent;
    private Restaurant foundersRestaurantParent;
    private RoofingContractor employeesRoofingContractorParent;
    private RoofingContractor foundersRoofingContractorParent;
    private SaleEvent actorsSaleEventParent;
    private SaleEvent directorsSaleEventParent;
    private School employeesSchoolParent;
    private School foundersSchoolParent;
    private ScreeningEvent actorsScreeningEventParent;
    private ScreeningEvent directorsScreeningEventParent;
    private SearchRescueOrganization employeesSearchRescueOrganizationParent;
    private SearchRescueOrganization foundersSearchRescueOrganizationParent;
    private SelfStorage employeesSelfStorageParent;
    private SelfStorage foundersSelfStorageParent;
    private ShoeStore employeesShoeStoreParent;
    private ShoeStore foundersShoeStoreParent;
    private ShoppingCenter employeesShoppingCenterParent;
    private ShoppingCenter foundersShoppingCenterParent;
    private SkiResort employeesSkiResortParent;
    private SkiResort foundersSkiResortParent;
    private SocialEvent actorsSocialEventParent;
    private SocialEvent directorsSocialEventParent;
    private SportingGoodsStore employeesSportingGoodsStoreParent;
    private SportingGoodsStore foundersSportingGoodsStoreParent;
    private SportsActivityLocation employeesSportsActivityLocationParent;
    private SportsActivityLocation foundersSportsActivityLocationParent;
    private SportsClub employeesSportsClubParent;
    private SportsClub foundersSportsClubParent;
    private SportsEvent actorsSportsEventParent;
    private SportsEvent directorsSportsEventParent;
    private SportsOrganization employeesSportsOrganizationParent;
    private SportsOrganization foundersSportsOrganizationParent;
    private SportsTeam employeesSportsTeamParent;
    private SportsTeam foundersSportsTeamParent;
    private StadiumOrArena employeesStadiumOrArenaParent;
    private StadiumOrArena foundersStadiumOrArenaParent;
    private Store employeesStoreParent;
    private Store foundersStoreParent;
    private TattooParlor employeesTattooParlorParent;
    private TattooParlor foundersTattooParlorParent;
    private TelevisionStation employeesTelevisionStationParent;
    private TelevisionStation foundersTelevisionStationParent;
    private TennisComplex employeesTennisComplexParent;
    private TennisComplex foundersTennisComplexParent;
    private TheaterEvent actorsTheaterEventParent;
    private TheaterEvent directorsTheaterEventParent;
    private TheaterGroup employeesTheaterGroupParent;
    private TheaterGroup foundersTheaterGroupParent;
    private TireShop employeesTireShopParent;
    private TireShop foundersTireShopParent;
    private TouristInformationCenter employeesTouristInformationCenterParent;
    private TouristInformationCenter foundersTouristInformationCenterParent;
    private ToyStore employeesToyStoreParent;
    private ToyStore foundersToyStoreParent;
    private TravelAgency employeesTravelAgencyParent;
    private TravelAgency foundersTravelAgencyParent;
    private TVClip actorsTVClipParent;
    private TVClip directorsTVClipParent;
    private TVEpisode actorsTVEpisodeParent;
    private TVEpisode directorsTVEpisodeParent;
    private TVSeason actorsTVSeasonParent;
    private TVSeason directorsTVSeasonParent;
    private TVSeries actorsTVSeriesParent;
    private TVSeries directorsTVSeriesParent;
    private UserBlocks actorsUserBlocksParent;
    private UserBlocks directorsUserBlocksParent;
    private UserCheckins actorsUserCheckinsParent;
    private UserCheckins directorsUserCheckinsParent;
    private UserComments actorsUserCommentsParent;
    private UserComments directorsUserCommentsParent;
    private UserDownloads actorsUserDownloadsParent;
    private UserDownloads directorsUserDownloadsParent;
    private UserInteraction actorsUserInteractionParent;
    private UserInteraction directorsUserInteractionParent;
    private UserLikes actorsUserLikesParent;
    private UserLikes directorsUserLikesParent;
    private UserPageVisits actorsUserPageVisitsParent;
    private UserPageVisits directorsUserPageVisitsParent;
    private UserPlays actorsUserPlaysParent;
    private UserPlays directorsUserPlaysParent;
    private UserPlusOnes actorsUserPlusOnesParent;
    private UserPlusOnes directorsUserPlusOnesParent;
    private UserTweets actorsUserTweetsParent;
    private UserTweets directorsUserTweetsParent;
    private VeterinaryCare employeesVeterinaryCareParent;
    private VeterinaryCare foundersVeterinaryCareParent;
    private VideoGame actorsVideoGameParent;
    private VideoGame directorsVideoGameParent;
    private VideoGameClip actorsVideoGameClipParent;
    private VideoGameClip directorsVideoGameClipParent;
    private VideoGameSeries actorsVideoGameSeriesParent;
    private VideoGameSeries directorsVideoGameSeriesParent;
    private VideoObject actorsVideoObjectParent;
    private VideoObject directorsVideoObjectParent;
    private VideoObjectSnapshot actorsVideoObjectSnapshotParent;
    private VideoObjectSnapshot directorsVideoObjectSnapshotParent;
    private VisualArtsEvent actorsVisualArtsEventParent;
    private VisualArtsEvent directorsVisualArtsEventParent;
    private WholesaleStore employeesWholesaleStoreParent;
    private WholesaleStore foundersWholesaleStoreParent;
    private Winery employeesWineryParent;
    private Winery foundersWineryParent;
    private WorkersUnion employeesWorkersUnionParent;
    private WorkersUnion foundersWorkersUnionParent;
    private AccountingService employeesAccountingServiceParent;
    private AccountingService foundersAccountingServiceParent;
    private AdultEntertainment employeesAdultEntertainmentParent;
    private AdultEntertainment foundersAdultEntertainmentParent;
    private Airline employeesAirlineParent;
    private Airline foundersAirlineParent;
    private AmusementPark employeesAmusementParkParent;
    private AmusementPark foundersAmusementParkParent;
    private AnimalShelter employeesAnimalShelterParent;
    private AnimalShelter foundersAnimalShelterParent;
    private ArchiveOrganization employeesArchiveOrganizationParent;
    private ArchiveOrganization foundersArchiveOrganizationParent;
    private ArtGallery employeesArtGalleryParent;
    private ArtGallery foundersArtGalleryParent;
    private Attorney employeesAttorneyParent;
    private Attorney foundersAttorneyParent;
    private AutoBodyShop employeesAutoBodyShopParent;
    private AutoBodyShop foundersAutoBodyShopParent;
    private AutoDealer employeesAutoDealerParent;
    private AutoDealer foundersAutoDealerParent;
    private AutomatedTeller employeesAutomatedTellerParent;
    private AutomatedTeller foundersAutomatedTellerParent;
    private AutomotiveBusiness employeesAutomotiveBusinessParent;
    private AutomotiveBusiness foundersAutomotiveBusinessParent;
    private AutoPartsStore employeesAutoPartsStoreParent;
    private AutoPartsStore foundersAutoPartsStoreParent;
    private AutoRental employeesAutoRentalParent;
    private AutoRental foundersAutoRentalParent;
    private AutoRepair employeesAutoRepairParent;
    private AutoRepair foundersAutoRepairParent;
    private AutoWash employeesAutoWashParent;
    private AutoWash foundersAutoWashParent;
    private Bakery employeesBakeryParent;
    private Bakery foundersBakeryParent;
    private BankOrCreditUnion employeesBankOrCreditUnionParent;
    private BankOrCreditUnion foundersBankOrCreditUnionParent;
    private BarOrPub employeesBarOrPubParent;
    private BarOrPub foundersBarOrPubParent;
    private BeautySalon employeesBeautySalonParent;
    private BeautySalon foundersBeautySalonParent;
    private BedAndBreakfast employeesBedAndBreakfastParent;
    private BedAndBreakfast foundersBedAndBreakfastParent;
    private BikeStore employeesBikeStoreParent;
    private BikeStore foundersBikeStoreParent;
    private BookStore employeesBookStoreParent;
    private BookStore foundersBookStoreParent;
    private BowlingAlley employeesBowlingAlleyParent;
    private BowlingAlley foundersBowlingAlleyParent;
    private Brewery employeesBreweryParent;
    private Brewery foundersBreweryParent;
    private BroadcastEvent actorsBroadcastEventParent;
    private BroadcastEvent directorsBroadcastEventParent;
    private BusinessEvent actorsBusinessEventParent;
    private BusinessEvent directorsBusinessEventParent;
    private CafeOrCoffeeShop employeesCafeOrCoffeeShopParent;
    private CafeOrCoffeeShop foundersCafeOrCoffeeShopParent;
    private Campground employeesCampgroundParent;
    private Campground foundersCampgroundParent;
    private Casino employeesCasinoParent;
    private Casino foundersCasinoParent;
    private ChildCare employeesChildCareParent;
    private ChildCare foundersChildCareParent;
    private ChildrensEvent actorsChildrensEventParent;
    private ChildrensEvent directorsChildrensEventParent;
    private Clip actorsClipParent;
    private Clip directorsClipParent;
    private ClothingStore employeesClothingStoreParent;
    private ClothingStore foundersClothingStoreParent;
    private CollegeOrUniversity employeesCollegeOrUniversityParent;
    private CollegeOrUniversity foundersCollegeOrUniversityParent;
    private ComedyClub employeesComedyClubParent;
    private ComedyClub foundersComedyClubParent;
    private ComedyEvent actorsComedyEventParent;
    private ComedyEvent directorsComedyEventParent;
    private ComputerStore employeesComputerStoreParent;
    private ComputerStore foundersComputerStoreParent;
    private Consortium employeesConsortiumParent;
    private Consortium foundersConsortiumParent;
    private ConvenienceStore employeesConvenienceStoreParent;
    private ConvenienceStore foundersConvenienceStoreParent;
    private Corporation employeesCorporationParent;
    private Corporation foundersCorporationParent;
    private CourseInstance actorsCourseInstanceParent;
    private CourseInstance directorsCourseInstanceParent;
    private CovidTestingFacility employeesCovidTestingFacilityParent;
    private CovidTestingFacility foundersCovidTestingFacilityParent;
    private CreativeWorkSeason actorsCreativeWorkSeasonParent;
    private CreativeWorkSeason directorsCreativeWorkSeasonParent;
    private DanceEvent actorsDanceEventParent;
    private DanceEvent directorsDanceEventParent;
    private DanceGroup employeesDanceGroupParent;
    private DanceGroup foundersDanceGroupParent;
    private DaySpa employeesDaySpaParent;
    private DaySpa foundersDaySpaParent;
    private DeliveryEvent actorsDeliveryEventParent;
    private DeliveryEvent directorsDeliveryEventParent;
    private Dentist employeesDentistParent;
    private Dentist foundersDentistParent;
    private DepartmentStore employeesDepartmentStoreParent;
    private DepartmentStore foundersDepartmentStoreParent;
    private DiagnosticLab employeesDiagnosticLabParent;
    private DiagnosticLab foundersDiagnosticLabParent;
    private Distillery employeesDistilleryParent;
    private Distillery foundersDistilleryParent;
    private DryCleaningOrLaundry employeesDryCleaningOrLaundryParent;
    private DryCleaningOrLaundry foundersDryCleaningOrLaundryParent;
    private EducationalOrganization employeesEducationalOrganizationParent;
    private EducationalOrganization foundersEducationalOrganizationParent;
    private EducationEvent actorsEducationEventParent;
    private EducationEvent directorsEducationEventParent;
    private Electrician employeesElectricianParent;
    private Electrician foundersElectricianParent;
    private ElectronicsStore employeesElectronicsStoreParent;
    private ElectronicsStore foundersElectronicsStoreParent;
    private ElementarySchool employeesElementarySchoolParent;
    private ElementarySchool foundersElementarySchoolParent;
    private EmergencyService employeesEmergencyServiceParent;
    private EmergencyService foundersEmergencyServiceParent;
    private EmploymentAgency employeesEmploymentAgencyParent;
    private EmploymentAgency foundersEmploymentAgencyParent;
    private EntertainmentBusiness employeesEntertainmentBusinessParent;
    private EntertainmentBusiness foundersEntertainmentBusinessParent;
    private Episode actorsEpisodeParent;
    private Episode directorsEpisodeParent;
    private Event actorsEventParent;
    private Event directorsEventParent;
    private EventSeries actorsEventSeriesParent;
    private EventSeries directorsEventSeriesParent;
    private ExerciseGym employeesExerciseGymParent;
    private ExerciseGym foundersExerciseGymParent;
    private ExhibitionEvent actorsExhibitionEventParent;
    private ExhibitionEvent directorsExhibitionEventParent;
    private FastFoodRestaurant employeesFastFoodRestaurantParent;
    private FastFoodRestaurant foundersFastFoodRestaurantParent;
    private Festival actorsFestivalParent;
    private Festival directorsFestivalParent;
    private FinancialService employeesFinancialServiceParent;
    private FinancialService foundersFinancialServiceParent;
    private FireStation employeesFireStationParent;
    private FireStation foundersFireStationParent;
    private Florist employeesFloristParent;
    private Florist foundersFloristParent;
    private FoodEstablishment employeesFoodEstablishmentParent;
    private FoodEstablishment foundersFoodEstablishmentParent;
    private FoodEvent actorsFoodEventParent;
    private FoodEvent directorsFoodEventParent;
    private FundingAgency employeesFundingAgencyParent;
    private FundingAgency foundersFundingAgencyParent;
    private FundingScheme employeesFundingSchemeParent;
    private FundingScheme foundersFundingSchemeParent;
    private FurnitureStore employeesFurnitureStoreParent;
    private FurnitureStore foundersFurnitureStoreParent;
    private GardenStore employeesGardenStoreParent;
    private GardenStore foundersGardenStoreParent;
    private GasStation employeesGasStationParent;
    private GasStation foundersGasStationParent;
    private GeneralContractor employeesGeneralContractorParent;
    private GeneralContractor foundersGeneralContractorParent;
    private GolfCourse employeesGolfCourseParent;
    private GolfCourse foundersGolfCourseParent;
    private GovernmentOffice employeesGovernmentOfficeParent;
    private GovernmentOffice foundersGovernmentOfficeParent;
    private GovernmentOrganization employeesGovernmentOrganizationParent;
    private GovernmentOrganization foundersGovernmentOrganizationParent;
    private GroceryStore employeesGroceryStoreParent;
    private GroceryStore foundersGroceryStoreParent;
    private Hackathon actorsHackathonParent;
    private Hackathon directorsHackathonParent;
    private HairSalon employeesHairSalonParent;
    private HairSalon foundersHairSalonParent;
    private HardwareStore employeesHardwareStoreParent;
    private HardwareStore foundersHardwareStoreParent;
    private HealthAndBeautyBusiness employeesHealthAndBeautyBusinessParent;
    private HealthAndBeautyBusiness foundersHealthAndBeautyBusinessParent;
    private HealthClub employeesHealthClubParent;
    private HealthClub foundersHealthClubParent;
    private HighSchool employeesHighSchoolParent;
    private HighSchool foundersHighSchoolParent;
    private HobbyShop employeesHobbyShopParent;
    private HobbyShop foundersHobbyShopParent;
    private HomeAndConstructionBusiness employeesHomeAndConstructionBusinessParent;
    private HomeAndConstructionBusiness foundersHomeAndConstructionBusinessParent;
    private HomeGoodsStore employeesHomeGoodsStoreParent;
    private HomeGoodsStore foundersHomeGoodsStoreParent;
    private Hospital employeesHospitalParent;
    private Hospital foundersHospitalParent;
    private Hostel employeesHostelParent;
    private Hostel foundersHostelParent;
    private Hotel employeesHotelParent;
    private Hotel foundersHotelParent;
    private HousePainter employeesHousePainterParent;
    private HousePainter foundersHousePainterParent;
    private HVACBusiness employeesHVACBusinessParent;
    private HVACBusiness foundersHVACBusinessParent;
    private IceCreamShop employeesIceCreamShopParent;
    private IceCreamShop foundersIceCreamShopParent;
    private InsuranceAgency employeesInsuranceAgencyParent;
    private InsuranceAgency foundersInsuranceAgencyParent;
    private InternetCafe employeesInternetCafeParent;
    private InternetCafe foundersInternetCafeParent;
    private JewelryStore employeesJewelryStoreParent;
    private JewelryStore foundersJewelryStoreParent;
    private LegalService employeesLegalServiceParent;
    private LegalService foundersLegalServiceParent;
    private Library employeesLibraryParent;
    private Library foundersLibraryParent;
    private LibrarySystem employeesLibrarySystemParent;
    private LibrarySystem foundersLibrarySystemParent;
    private LiquorStore employeesLiquorStoreParent;
    private LiquorStore foundersLiquorStoreParent;
    private LiteraryEvent actorsLiteraryEventParent;
    private LiteraryEvent directorsLiteraryEventParent;
    private LocalBusiness employeesLocalBusinessParent;
    private LocalBusiness foundersLocalBusinessParent;
    private Locksmith employeesLocksmithParent;
    private Locksmith foundersLocksmithParent;
    private LodgingBusiness employeesLodgingBusinessParent;
    private LodgingBusiness foundersLodgingBusinessParent;
    private MedicalBusiness employeesMedicalBusinessParent;
    private MedicalBusiness foundersMedicalBusinessParent;
    private MedicalClinic employeesMedicalClinicParent;
    private MedicalClinic foundersMedicalClinicParent;
    private MedicalOrganization employeesMedicalOrganizationParent;
    private MedicalOrganization foundersMedicalOrganizationParent;
    private MensClothingStore employeesMensClothingStoreParent;
    private MensClothingStore foundersMensClothingStoreParent;
    private MiddleSchool employeesMiddleSchoolParent;
    private MiddleSchool foundersMiddleSchoolParent;
    private MobilePhoneStore employeesMobilePhoneStoreParent;
    private MobilePhoneStore foundersMobilePhoneStoreParent;
    private Motel employeesMotelParent;
    private Motel foundersMotelParent;
    private MotorcycleDealer employeesMotorcycleDealerParent;
    private MotorcycleDealer foundersMotorcycleDealerParent;
    private MotorcycleRepair employeesMotorcycleRepairParent;
    private MotorcycleRepair foundersMotorcycleRepairParent;
    private Movie actorsMovieParent;
    private Movie directorsMovieParent;
    private MovieClip actorsMovieClipParent;
    private MovieClip directorsMovieClipParent;
    private MovieRentalStore employeesMovieRentalStoreParent;
    private MovieRentalStore foundersMovieRentalStoreParent;
    private MovieSeries actorsMovieSeriesParent;
    private MovieSeries directorsMovieSeriesParent;
    private MovieTheater employeesMovieTheaterParent;
    private MovieTheater foundersMovieTheaterParent;
    private MovingCompany employeesMovingCompanyParent;
    private MovingCompany foundersMovingCompanyParent;
    private MusicEvent actorsMusicEventParent;
    private MusicEvent directorsMusicEventParent;
    private MusicGroup employeesMusicGroupParent;
    private MusicGroup foundersMusicGroupParent;
    private MusicStore employeesMusicStoreParent;
    private MusicStore foundersMusicStoreParent;
    private NailSalon employeesNailSalonParent;
    private NailSalon foundersNailSalonParent;
    private NewsMediaOrganization employeesNewsMediaOrganizationParent;
    private NewsMediaOrganization foundersNewsMediaOrganizationParent;
    private NGO employeesNGOParent;
    private NGO foundersNGOParent;
    private NightClub employeesNightClubParent;
    private NightClub foundersNightClubParent;
    private Notary employeesNotaryParent;
    private Notary foundersNotaryParent;
    private OfficeEquipmentStore employeesOfficeEquipmentStoreParent;
    private OfficeEquipmentStore foundersOfficeEquipmentStoreParent;
    private OnDemandEvent actorsOnDemandEventParent;
    private OnDemandEvent directorsOnDemandEventParent;
    private OnlineBusiness employeesOnlineBusinessParent;
    private OnlineBusiness foundersOnlineBusinessParent;
    private OnlineStore employeesOnlineStoreParent;
    private OnlineStore foundersOnlineStoreParent;
    private Optician employeesOpticianParent;
    private Optician foundersOpticianParent;
    private Organization employeesOrganizationParent;
    private Organization foundersOrganizationParent;
    private OutletStore employeesOutletStoreParent;
    private OutletStore foundersOutletStoreParent;
    private Patient colleaguesPatientParent;
    private Patient parentsPatientParent;
    private Patient siblingsPatientParent;
    private PawnShop employeesPawnShopParent;
    private PawnShop foundersPawnShopParent;
    private PerformingGroup employeesPerformingGroupParent;
    private PerformingGroup foundersPerformingGroupParent;
    private Person colleaguesPersonParent;
    private Person parentsPersonParent;
    private Person siblingsPersonParent;
}