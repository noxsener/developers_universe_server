package com.codenfast.developersuniverse.common.entity.schema;

import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/ContactPoint


/**A contact point—for example, a Customer Complaints department.*/
public class ContactPoint {
                        private String id;
            private Boolean passive = Boolean.FALSE;
            private LocalDateTime createTime = null;
            private LocalDateTime updateTime = null;


    /**
     * The geographic area where a service or offered item is provided. Supersedes serviceArea.
     */
        private java.util.List<AdministrativeArea> serviceArea;

    /**
     * A language someone may use with or at the item, service or place. Please use one of the language codes from the IETF BCP 47 standard. See also inLanguage.
     */
            private Language availableLanguage;

    /**
     * An option available on this contact point (e.g. a toll-free number or support for hearing-impaired callers).
     */
            private ContactPointOption contactOption;

    /**
     * A person or organization can have different contact points, for different purposes. For example, a sales contact point, a PR contact point and so on. This property is used to specify the kind of contact point.
     */
        private String contactType;

    /**
     * Email address.
     */
        private String email;

    /**
     * The fax number.
     */
        private String faxNumber;

    /**
     * The hours during which this service or contact is available.
     */
            private OpeningHoursSpecification hoursAvailable;

    /**
     * The product or service this support contact point is related to (such as product support for a particular product line). This can be a specific product or product line (e.g. "iPhone") or a general category of products or services (e.g. "smartphones").
     */
            private Product productSupported;

    /**
     * The telephone number.
     */
        private String telephone;

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

            private ConvenienceStore contactPointsConvenienceStoreParent;
            private Corporation contactPointsCorporationParent;
            private CovidTestingFacility contactPointsCovidTestingFacilityParent;
            private DanceGroup contactPointsDanceGroupParent;
            private DaySpa contactPointsDaySpaParent;
            private Dentist contactPointsDentistParent;
            private DepartmentStore contactPointsDepartmentStoreParent;
            private DiagnosticLab contactPointsDiagnosticLabParent;
            private Distillery contactPointsDistilleryParent;
            private DryCleaningOrLaundry contactPointsDryCleaningOrLaundryParent;
            private EducationalOrganization contactPointsEducationalOrganizationParent;
            private Electrician contactPointsElectricianParent;
            private ElectronicsStore contactPointsElectronicsStoreParent;
            private ElementarySchool contactPointsElementarySchoolParent;
            private EmergencyService contactPointsEmergencyServiceParent;
            private EmploymentAgency contactPointsEmploymentAgencyParent;
            private EntertainmentBusiness contactPointsEntertainmentBusinessParent;
            private ExerciseGym contactPointsExerciseGymParent;
            private FastFoodRestaurant contactPointsFastFoodRestaurantParent;
            private FinancialService contactPointsFinancialServiceParent;
            private FireStation contactPointsFireStationParent;
            private Florist contactPointsFloristParent;
            private FoodEstablishment contactPointsFoodEstablishmentParent;
            private FundingAgency contactPointsFundingAgencyParent;
            private FundingScheme contactPointsFundingSchemeParent;
            private FurnitureStore contactPointsFurnitureStoreParent;
            private GardenStore contactPointsGardenStoreParent;
            private GasStation contactPointsGasStationParent;
            private GeneralContractor contactPointsGeneralContractorParent;
            private GolfCourse contactPointsGolfCourseParent;
            private GovernmentOffice contactPointsGovernmentOfficeParent;
            private GovernmentOrganization contactPointsGovernmentOrganizationParent;
            private GroceryStore contactPointsGroceryStoreParent;
            private HairSalon contactPointsHairSalonParent;
            private HardwareStore contactPointsHardwareStoreParent;
            private HealthAndBeautyBusiness contactPointsHealthAndBeautyBusinessParent;
            private HealthClub contactPointsHealthClubParent;
            private HealthInsurancePlan contactPointsHealthInsurancePlanParent;
            private HighSchool contactPointsHighSchoolParent;
            private HobbyShop contactPointsHobbyShopParent;
            private HomeAndConstructionBusiness contactPointsHomeAndConstructionBusinessParent;
            private HomeGoodsStore contactPointsHomeGoodsStoreParent;
            private Hospital contactPointsHospitalParent;
            private Hostel contactPointsHostelParent;
            private Hotel contactPointsHotelParent;
            private HousePainter contactPointsHousePainterParent;
            private HVACBusiness contactPointsHVACBusinessParent;
            private IceCreamShop contactPointsIceCreamShopParent;
            private InsuranceAgency contactPointsInsuranceAgencyParent;
            private InternetCafe contactPointsInternetCafeParent;
            private JewelryStore contactPointsJewelryStoreParent;
            private LegalService contactPointsLegalServiceParent;
            private Library contactPointsLibraryParent;
            private LibrarySystem contactPointsLibrarySystemParent;
            private LiquorStore contactPointsLiquorStoreParent;
            private LocalBusiness contactPointsLocalBusinessParent;
            private Locksmith contactPointsLocksmithParent;
            private LodgingBusiness contactPointsLodgingBusinessParent;
            private MedicalBusiness contactPointsMedicalBusinessParent;
            private MedicalClinic contactPointsMedicalClinicParent;
            private MedicalOrganization contactPointsMedicalOrganizationParent;
            private MensClothingStore contactPointsMensClothingStoreParent;
            private MiddleSchool contactPointsMiddleSchoolParent;
            private MobilePhoneStore contactPointsMobilePhoneStoreParent;
            private Motel contactPointsMotelParent;
            private MotorcycleDealer contactPointsMotorcycleDealerParent;
            private MotorcycleRepair contactPointsMotorcycleRepairParent;
            private MovieRentalStore contactPointsMovieRentalStoreParent;
            private MovieTheater contactPointsMovieTheaterParent;
            private MovingCompany contactPointsMovingCompanyParent;
            private MusicGroup contactPointsMusicGroupParent;
            private MusicStore contactPointsMusicStoreParent;
            private NailSalon contactPointsNailSalonParent;
            private NewsMediaOrganization contactPointsNewsMediaOrganizationParent;
            private NGO contactPointsNGOParent;
            private NightClub contactPointsNightClubParent;
            private Notary contactPointsNotaryParent;
            private OfficeEquipmentStore contactPointsOfficeEquipmentStoreParent;
            private OnlineBusiness contactPointsOnlineBusinessParent;
            private OnlineStore contactPointsOnlineStoreParent;
            private Optician contactPointsOpticianParent;
            private Organization contactPointsOrganizationParent;
            private OutletStore contactPointsOutletStoreParent;
            private Patient contactPointsPatientParent;
            private PawnShop contactPointsPawnShopParent;
            private PerformingGroup contactPointsPerformingGroupParent;
            private Person contactPointsPersonParent;
            private PetStore contactPointsPetStoreParent;
            private Pharmacy contactPointsPharmacyParent;
            private Physician contactPointsPhysicianParent;
            private Plumber contactPointsPlumberParent;
            private PoliceStation contactPointsPoliceStationParent;
            private PostOffice contactPointsPostOfficeParent;
            private Preschool contactPointsPreschoolParent;
            private ProfessionalService contactPointsProfessionalServiceParent;
            private Project contactPointsProjectParent;
            private PublicSwimmingPool contactPointsPublicSwimmingPoolParent;
            private RadioStation contactPointsRadioStationParent;
            private RealEstateAgent contactPointsRealEstateAgentParent;
            private RecyclingCenter contactPointsRecyclingCenterParent;
            private ResearchOrganization contactPointsResearchOrganizationParent;
            private ResearchProject contactPointsResearchProjectParent;
            private Resort contactPointsResortParent;
            private Restaurant contactPointsRestaurantParent;
            private RoofingContractor contactPointsRoofingContractorParent;
            private School contactPointsSchoolParent;
            private SearchRescueOrganization contactPointsSearchRescueOrganizationParent;
            private SelfStorage contactPointsSelfStorageParent;
            private ShoeStore contactPointsShoeStoreParent;
            private ShoppingCenter contactPointsShoppingCenterParent;
            private SkiResort contactPointsSkiResortParent;
            private SportingGoodsStore contactPointsSportingGoodsStoreParent;
            private SportsActivityLocation contactPointsSportsActivityLocationParent;
            private SportsClub contactPointsSportsClubParent;
            private SportsOrganization contactPointsSportsOrganizationParent;
            private SportsTeam contactPointsSportsTeamParent;
            private StadiumOrArena contactPointsStadiumOrArenaParent;
            private Store contactPointsStoreParent;
            private TattooParlor contactPointsTattooParlorParent;
            private TelevisionStation contactPointsTelevisionStationParent;
            private TennisComplex contactPointsTennisComplexParent;
            private TheaterGroup contactPointsTheaterGroupParent;
            private TireShop contactPointsTireShopParent;
            private TouristInformationCenter contactPointsTouristInformationCenterParent;
            private ToyStore contactPointsToyStoreParent;
            private TravelAgency contactPointsTravelAgencyParent;
            private VeterinaryCare contactPointsVeterinaryCareParent;
            private WholesaleStore contactPointsWholesaleStoreParent;
            private Winery contactPointsWineryParent;
            private WorkersUnion contactPointsWorkersUnionParent;
private AccountingService contactPointsAccountingServiceParent;
private AdultEntertainment contactPointsAdultEntertainmentParent;
private Airline contactPointsAirlineParent;
private AmusementPark contactPointsAmusementParkParent;
private AnimalShelter contactPointsAnimalShelterParent;
private ArchiveOrganization contactPointsArchiveOrganizationParent;
private ArtGallery contactPointsArtGalleryParent;
private Attorney contactPointsAttorneyParent;
private AutoBodyShop contactPointsAutoBodyShopParent;
private AutoDealer contactPointsAutoDealerParent;
private AutomatedTeller contactPointsAutomatedTellerParent;
private AutomotiveBusiness contactPointsAutomotiveBusinessParent;
private AutoPartsStore contactPointsAutoPartsStoreParent;
private AutoRental contactPointsAutoRentalParent;
private AutoRepair contactPointsAutoRepairParent;
private AutoWash contactPointsAutoWashParent;
private Bakery contactPointsBakeryParent;
private BankOrCreditUnion contactPointsBankOrCreditUnionParent;
private BarOrPub contactPointsBarOrPubParent;
private BeautySalon contactPointsBeautySalonParent;
private BedAndBreakfast contactPointsBedAndBreakfastParent;
private BikeStore contactPointsBikeStoreParent;
private BookStore contactPointsBookStoreParent;
private BowlingAlley contactPointsBowlingAlleyParent;
private Brewery contactPointsBreweryParent;
private CafeOrCoffeeShop contactPointsCafeOrCoffeeShopParent;
private Campground contactPointsCampgroundParent;
private Casino contactPointsCasinoParent;
private ChildCare contactPointsChildCareParent;
private ClothingStore contactPointsClothingStoreParent;
private CollegeOrUniversity contactPointsCollegeOrUniversityParent;
private ComedyClub contactPointsComedyClubParent;
private ComputerStore contactPointsComputerStoreParent;
private Consortium contactPointsConsortiumParent;
}