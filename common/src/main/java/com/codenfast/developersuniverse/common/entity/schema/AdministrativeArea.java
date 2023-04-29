package com.codenfast.developersuniverse.common.entity.schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/AdministrativeArea


/**A geographical region, typically under the jurisdiction of a particular government.*/
public class AdministrativeArea {
                        private String id;
            private Boolean passive = Boolean.FALSE;
            private LocalDateTime createTime = null;
            private LocalDateTime updateTime = null;


    /**
     * A property-value pair representing an additional characteristic of the entity, e.g. a product feature or another characteristic for which there is no matching property in schema.org.
     * <p>
     * Note: Publishers should be aware that applications designed to use specific schema.org properties (e.g. https://schema.org/width, https://schema.org/color, https://schema.org/gtin13, ...) will typically expect such data to be provided using those properties, rather than using the generic property/value mechanism.
     */
            private PropertyValue additionalProperty;

    /**
     * Physical address of the item.
     */
            private PostalAddress address;

    /**
     * The overall rating, based on a collection of reviews or ratings, of the item.
     */
            private AggregateRating aggregateRating;

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
     * Upcoming or past event associated with this place, organization, or action. Supersedes events.
     */
        private java.util.List<Event> events;

    /**
     * The fax number.
     */
        private String faxNumber;

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
     * The Global Location Number (GLN, sometimes also referred to as International Location Number or ILN) of the respective organization, person, or place. The GLN is a 13-digit number used to identify parties and physical locations.
     */
        private String globalLocationNumber;

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
     * The International Standard of Industrial Classification of All Economic Activities (ISIC), Revision 4 code for a particular organization, business person, or place.
     */
        private String isicV4;

    /**
     * Keywords or tags used to describe some item. Multiple textual entries in a keywords list are typically delimited by commas, or by repeating the property.
     */
            private DefinedTerm keywords;

    /**
     * The latitude of a location. For example 37.42242 (WGS 84).
     */
        private BigDecimal latitude;

    /**
     * An associated logo.
     */
            private ImageObject logo;

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
     * A review of the item. Supersedes reviews.
     */
        private java.util.List<Review> reviews;

    /**
     * A slogan or motto associated with the item.
     */
        private String slogan;

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
     * The telephone number.
     */
        private String telephone;

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

            private AdultEntertainment serviceAreaAdultEntertainmentParent;
            private AggregateOffer serviceAreaAggregateOfferParent;
            private Airline serviceAreaAirlineParent;
            private AmusementPark serviceAreaAmusementParkParent;
            private AnimalShelter serviceAreaAnimalShelterParent;
            private ArchiveOrganization serviceAreaArchiveOrganizationParent;
            private ArtGallery serviceAreaArtGalleryParent;
            private Attorney serviceAreaAttorneyParent;
            private AutoBodyShop serviceAreaAutoBodyShopParent;
            private AutoDealer serviceAreaAutoDealerParent;
            private AutomatedTeller serviceAreaAutomatedTellerParent;
            private AutomotiveBusiness serviceAreaAutomotiveBusinessParent;
            private AutoPartsStore serviceAreaAutoPartsStoreParent;
            private AutoRental serviceAreaAutoRentalParent;
            private AutoRepair serviceAreaAutoRepairParent;
            private AutoWash serviceAreaAutoWashParent;
            private Bakery serviceAreaBakeryParent;
            private BankAccount serviceAreaBankAccountParent;
            private BankOrCreditUnion serviceAreaBankOrCreditUnionParent;
            private BarOrPub serviceAreaBarOrPubParent;
            private BeautySalon serviceAreaBeautySalonParent;
            private BedAndBreakfast serviceAreaBedAndBreakfastParent;
            private BikeStore serviceAreaBikeStoreParent;
            private BookStore serviceAreaBookStoreParent;
            private BowlingAlley serviceAreaBowlingAlleyParent;
            private Brewery serviceAreaBreweryParent;
            private BroadcastService serviceAreaBroadcastServiceParent;
            private BrokerageAccount serviceAreaBrokerageAccountParent;
            private CableOrSatelliteService serviceAreaCableOrSatelliteServiceParent;
            private CafeOrCoffeeShop serviceAreaCafeOrCoffeeShopParent;
            private Campground serviceAreaCampgroundParent;
            private Casino serviceAreaCasinoParent;
            private ChildCare serviceAreaChildCareParent;
            private ClothingStore serviceAreaClothingStoreParent;
            private CollegeOrUniversity serviceAreaCollegeOrUniversityParent;
            private ComedyClub serviceAreaComedyClubParent;
            private ComputerStore serviceAreaComputerStoreParent;
            private Consortium serviceAreaConsortiumParent;
            private ContactPoint serviceAreaContactPointParent;
            private ConvenienceStore serviceAreaConvenienceStoreParent;
            private Corporation serviceAreaCorporationParent;
            private CovidTestingFacility serviceAreaCovidTestingFacilityParent;
            private CurrencyConversionService serviceAreaCurrencyConversionServiceParent;
            private DanceGroup serviceAreaDanceGroupParent;
            private DaySpa serviceAreaDaySpaParent;
            private DeliveryChargeSpecification serviceAreaDeliveryChargeSpecificationParent;
            private Demand serviceAreaDemandParent;
            private Dentist serviceAreaDentistParent;
            private DepartmentStore serviceAreaDepartmentStoreParent;
            private DepositAccount serviceAreaDepositAccountParent;
            private DiagnosticLab serviceAreaDiagnosticLabParent;
            private Distillery serviceAreaDistilleryParent;
            private DryCleaningOrLaundry serviceAreaDryCleaningOrLaundryParent;
            private EducationalOrganization serviceAreaEducationalOrganizationParent;
            private Electrician serviceAreaElectricianParent;
            private ElectronicsStore serviceAreaElectronicsStoreParent;
            private ElementarySchool serviceAreaElementarySchoolParent;
            private EmergencyService serviceAreaEmergencyServiceParent;
            private EmploymentAgency serviceAreaEmploymentAgencyParent;
            private EntertainmentBusiness serviceAreaEntertainmentBusinessParent;
            private ExerciseGym serviceAreaExerciseGymParent;
            private FastFoodRestaurant serviceAreaFastFoodRestaurantParent;
            private FinancialProduct serviceAreaFinancialProductParent;
            private FinancialService serviceAreaFinancialServiceParent;
            private FireStation serviceAreaFireStationParent;
            private Florist serviceAreaFloristParent;
            private FoodEstablishment serviceAreaFoodEstablishmentParent;
            private FoodService serviceAreaFoodServiceParent;
            private FundingAgency serviceAreaFundingAgencyParent;
            private FundingScheme serviceAreaFundingSchemeParent;
            private FurnitureStore serviceAreaFurnitureStoreParent;
            private GardenStore serviceAreaGardenStoreParent;
            private GasStation serviceAreaGasStationParent;
            private GeneralContractor serviceAreaGeneralContractorParent;
            private GolfCourse serviceAreaGolfCourseParent;
            private GovernmentOffice serviceAreaGovernmentOfficeParent;
            private GovernmentOrganization serviceAreaGovernmentOrganizationParent;
            private GovernmentService serviceAreaGovernmentServiceParent;
            private GroceryStore serviceAreaGroceryStoreParent;
            private HairSalon serviceAreaHairSalonParent;
            private HardwareStore serviceAreaHardwareStoreParent;
            private HealthAndBeautyBusiness serviceAreaHealthAndBeautyBusinessParent;
            private HealthClub serviceAreaHealthClubParent;
            private HighSchool serviceAreaHighSchoolParent;
            private HobbyShop serviceAreaHobbyShopParent;
            private HomeAndConstructionBusiness serviceAreaHomeAndConstructionBusinessParent;
            private HomeGoodsStore serviceAreaHomeGoodsStoreParent;
            private Hospital serviceAreaHospitalParent;
            private Hostel serviceAreaHostelParent;
            private Hotel serviceAreaHotelParent;
            private HousePainter serviceAreaHousePainterParent;
            private HVACBusiness serviceAreaHVACBusinessParent;
            private IceCreamShop serviceAreaIceCreamShopParent;
            private InsuranceAgency serviceAreaInsuranceAgencyParent;
            private InternetCafe serviceAreaInternetCafeParent;
            private InvestmentFund serviceAreaInvestmentFundParent;
            private InvestmentOrDeposit serviceAreaInvestmentOrDepositParent;
            private JewelryStore serviceAreaJewelryStoreParent;
            private LegalService serviceAreaLegalServiceParent;
            private Library serviceAreaLibraryParent;
            private LibrarySystem serviceAreaLibrarySystemParent;
            private LiquorStore serviceAreaLiquorStoreParent;
            private LoanOrCredit serviceAreaLoanOrCreditParent;
            private LocalBusiness serviceAreaLocalBusinessParent;
            private Locksmith serviceAreaLocksmithParent;
            private LodgingBusiness serviceAreaLodgingBusinessParent;
            private MedicalBusiness serviceAreaMedicalBusinessParent;
            private MedicalClinic serviceAreaMedicalClinicParent;
            private MedicalOrganization serviceAreaMedicalOrganizationParent;
            private MensClothingStore serviceAreaMensClothingStoreParent;
            private MiddleSchool serviceAreaMiddleSchoolParent;
            private MobilePhoneStore serviceAreaMobilePhoneStoreParent;
            private MortgageLoan serviceAreaMortgageLoanParent;
            private Motel serviceAreaMotelParent;
            private MotorcycleDealer serviceAreaMotorcycleDealerParent;
            private MotorcycleRepair serviceAreaMotorcycleRepairParent;
            private MovieRentalStore serviceAreaMovieRentalStoreParent;
            private MovieTheater serviceAreaMovieTheaterParent;
            private MovingCompany serviceAreaMovingCompanyParent;
            private MusicGroup serviceAreaMusicGroupParent;
            private MusicStore serviceAreaMusicStoreParent;
            private NailSalon serviceAreaNailSalonParent;
            private NewsMediaOrganization serviceAreaNewsMediaOrganizationParent;
            private NGO serviceAreaNGOParent;
            private NightClub serviceAreaNightClubParent;
            private Notary serviceAreaNotaryParent;
            private Offer serviceAreaOfferParent;
            private OfferForLease serviceAreaOfferForLeaseParent;
            private OfferForPurchase serviceAreaOfferForPurchaseParent;
            private OfficeEquipmentStore serviceAreaOfficeEquipmentStoreParent;
            private OnlineBusiness serviceAreaOnlineBusinessParent;
            private OnlineStore serviceAreaOnlineStoreParent;
            private Optician serviceAreaOpticianParent;
            private Organization serviceAreaOrganizationParent;
            private OutletStore serviceAreaOutletStoreParent;
            private PawnShop serviceAreaPawnShopParent;
            private PaymentService serviceAreaPaymentServiceParent;
            private PerformingGroup serviceAreaPerformingGroupParent;
            private PetStore serviceAreaPetStoreParent;
            private Pharmacy serviceAreaPharmacyParent;
            private Physician serviceAreaPhysicianParent;
            private Plumber serviceAreaPlumberParent;
            private PoliceStation serviceAreaPoliceStationParent;
            private PostalAddress serviceAreaPostalAddressParent;
            private PostOffice serviceAreaPostOfficeParent;
            private Preschool serviceAreaPreschoolParent;
            private ProfessionalService serviceAreaProfessionalServiceParent;
            private Project serviceAreaProjectParent;
            private PublicSwimmingPool serviceAreaPublicSwimmingPoolParent;
            private RadioBroadcastService serviceAreaRadioBroadcastServiceParent;
            private RadioStation serviceAreaRadioStationParent;
            private RealEstateAgent serviceAreaRealEstateAgentParent;
            private RecyclingCenter serviceAreaRecyclingCenterParent;
            private ResearchOrganization serviceAreaResearchOrganizationParent;
            private ResearchProject serviceAreaResearchProjectParent;
            private Resort serviceAreaResortParent;
            private Restaurant serviceAreaRestaurantParent;
            private RoofingContractor serviceAreaRoofingContractorParent;
            private School serviceAreaSchoolParent;
            private SearchRescueOrganization serviceAreaSearchRescueOrganizationParent;
            private SelfStorage serviceAreaSelfStorageParent;
            private Service serviceAreaServiceParent;
            private ShoeStore serviceAreaShoeStoreParent;
            private ShoppingCenter serviceAreaShoppingCenterParent;
            private SkiResort serviceAreaSkiResortParent;
            private SportingGoodsStore serviceAreaSportingGoodsStoreParent;
            private SportsActivityLocation serviceAreaSportsActivityLocationParent;
            private SportsClub serviceAreaSportsClubParent;
            private SportsOrganization serviceAreaSportsOrganizationParent;
            private SportsTeam serviceAreaSportsTeamParent;
            private StadiumOrArena serviceAreaStadiumOrArenaParent;
            private Store serviceAreaStoreParent;
            private TattooParlor serviceAreaTattooParlorParent;
            private Taxi serviceAreaTaxiParent;
            private TaxiService serviceAreaTaxiServiceParent;
            private TelevisionStation serviceAreaTelevisionStationParent;
            private TennisComplex serviceAreaTennisComplexParent;
            private TheaterGroup serviceAreaTheaterGroupParent;
            private TireShop serviceAreaTireShopParent;
            private TouristInformationCenter serviceAreaTouristInformationCenterParent;
            private ToyStore serviceAreaToyStoreParent;
            private TravelAgency serviceAreaTravelAgencyParent;
            private VeterinaryCare serviceAreaVeterinaryCareParent;
            private WebAPI serviceAreaWebAPIParent;
            private WholesaleStore serviceAreaWholesaleStoreParent;
            private Winery serviceAreaWineryParent;
            private WorkersUnion serviceAreaWorkersUnionParent;
private AccountingService serviceAreaAccountingServiceParent;
}