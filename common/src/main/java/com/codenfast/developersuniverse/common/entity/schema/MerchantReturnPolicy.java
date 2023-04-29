package com.codenfast.developersuniverse.common.entity.schema;

import java.time.LocalDate;
import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/MerchantReturnPolicy


/**A MerchantReturnPolicy provides information about product return policies associated with an Organization, Product, or Offer.*/
public class MerchantReturnPolicy {
private String id;
private Boolean passive = Boolean.FALSE;
private LocalDateTime createTime = null;
private LocalDateTime updateTime = null;



/**
*A property-value pair representing an additional characteristic of the entity, e.g. a product feature or another characteristic for which there is no matching property in schema.org.

Note: Publishers should be aware that applications designed to use specific schema.org properties (e.g. https://schema.org/width, https://schema.org/color, https://schema.org/gtin13, ...) will typically expect such data to be provided using those properties, rather than using the generic property/value mechanism.
*/
private PropertyValue additionalProperty;

/**
*A country where a particular merchant return policy applies to, for example the two-letter ISO 3166-1 alpha-2 country code.
*/
private Country applicableCountry;

/**
*The type of return fees if the product is returned due to customer remorse.
*/
private ReturnFeesEnumeration customerRemorseReturnFees;

/**
*The method (from an enumeration) by which the customer obtains a return shipping label for a product returned due to customer remorse.
*/
private ReturnLabelSourceEnumeration customerRemorseReturnLabelSource;

/**
*The amount of shipping costs if a product is returned due to customer remorse. Applicable when property customerRemorseReturnFees equals ReturnShippingFees.
*/
private MonetaryAmount customerRemorseReturnShippingFeesAmount;

/**
*Are in-store returns offered? (For more advanced return methods use the returnMethod property.)
*/
private Boolean inStoreReturnsOffered;

/**
*A predefined value from OfferItemCondition specifying the condition of the product or service, or the products or services included in the offer. Also used for product return policies to specify the condition of products accepted for returns.
*/
private OfferItemCondition itemCondition;

/**
*The type of return fees for returns of defect products.
*/
private ReturnFeesEnumeration itemDefectReturnFees;

/**
*The method (from an enumeration) by which the customer obtains a return shipping label for a defect product.
*/
private ReturnLabelSourceEnumeration itemDefectReturnLabelSource;

/**
*Amount of shipping costs for defect product returns. Applicable when property itemDefectReturnFees equals ReturnShippingFees.
*/
private MonetaryAmount itemDefectReturnShippingFeesAmount;

/**
*Specifies either a fixed return date or the number of days (from the delivery date) that a product can be returned. Used when the returnPolicyCategory property is specified as MerchantReturnFiniteReturnWindow. Supersedes productReturnDays.
*/
private LocalDate merchantReturnDays;

/**
*Specifies a Web page or service by URL, for product returns. Supersedes productReturnLink.
*/
private String merchantReturnLink;

/**
*A refund type, from an enumerated list.
*/
private RefundTypeEnumeration refundType;

/**
*Use MonetaryAmount to specify a fixed restocking fee for product returns, or use Number to specify a percentage of the product price paid by the customer.
*/
private MonetaryAmount restockingFee;

/**
*The type of return fees for purchased products (for any return reason).
*/
private ReturnFeesEnumeration returnFees;

/**
*The method (from an enumeration) by which the customer obtains a return shipping label for a product returned for any reason.
*/
private ReturnLabelSourceEnumeration returnLabelSource;

/**
*The type of return method offered, specified from an enumeration.
*/
private ReturnMethodEnumeration returnMethod;

/**
*Specifies an applicable return policy (from an enumeration).
*/
private MerchantReturnEnumeration returnPolicyCategory;

/**
*The country where the product has to be sent to for returns, for example "Ireland" using the name property of Country. You can also provide the two-letter ISO 3166-1 alpha-2 country code. Note that this can be different from the country where the product was originally shipped from or sent to.
*/
private Country returnPolicyCountry;

/**
*Seasonal override of a return policy.
*/
private MerchantReturnPolicySeasonalOverride returnPolicySeasonalOverride;

/**
*Amount of shipping costs for product returns (for any reason). Applicable when property returnFees equals ReturnShippingFees.
*/
private MonetaryAmount returnShippingFeesAmount;

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

private MiddleSchool hasProductReturnPolicyMiddleSchoolParent;
private MobilePhoneStore hasProductReturnPolicyMobilePhoneStoreParent;
private Motel hasProductReturnPolicyMotelParent;
private Motorcycle hasProductReturnPolicyMotorcycleParent;
private MotorcycleDealer hasProductReturnPolicyMotorcycleDealerParent;
private MotorcycleRepair hasProductReturnPolicyMotorcycleRepairParent;
private MotorizedBicycle hasProductReturnPolicyMotorizedBicycleParent;
private MovieRentalStore hasProductReturnPolicyMovieRentalStoreParent;
private MovieTheater hasProductReturnPolicyMovieTheaterParent;
private MovingCompany hasProductReturnPolicyMovingCompanyParent;
private MusicGroup hasProductReturnPolicyMusicGroupParent;
private MusicStore hasProductReturnPolicyMusicStoreParent;
private NailSalon hasProductReturnPolicyNailSalonParent;
private NewsMediaOrganization hasProductReturnPolicyNewsMediaOrganizationParent;
private NGO hasProductReturnPolicyNGOParent;
private NightClub hasProductReturnPolicyNightClubParent;
private Notary hasProductReturnPolicyNotaryParent;
private Offer hasProductReturnPolicyOfferParent;
private OfferForLease hasProductReturnPolicyOfferForLeaseParent;
private OfferForPurchase hasProductReturnPolicyOfferForPurchaseParent;
private OfficeEquipmentStore hasProductReturnPolicyOfficeEquipmentStoreParent;
private OnlineBusiness hasProductReturnPolicyOnlineBusinessParent;
private OnlineStore hasProductReturnPolicyOnlineStoreParent;
private Optician hasProductReturnPolicyOpticianParent;
private Organization hasProductReturnPolicyOrganizationParent;
private OutletStore hasProductReturnPolicyOutletStoreParent;
private PawnShop hasProductReturnPolicyPawnShopParent;
private PerformingGroup hasProductReturnPolicyPerformingGroupParent;
private PetStore hasProductReturnPolicyPetStoreParent;
private Pharmacy hasProductReturnPolicyPharmacyParent;
private Physician hasProductReturnPolicyPhysicianParent;
private Plumber hasProductReturnPolicyPlumberParent;
private PoliceStation hasProductReturnPolicyPoliceStationParent;
private PostOffice hasProductReturnPolicyPostOfficeParent;
private Preschool hasProductReturnPolicyPreschoolParent;
private Product hasProductReturnPolicyProductParent;
private ProductCollection hasProductReturnPolicyProductCollectionParent;
private ProductGroup hasProductReturnPolicyProductGroupParent;
private ProductModel hasProductReturnPolicyProductModelParent;
private ProfessionalService hasProductReturnPolicyProfessionalServiceParent;
private Project hasProductReturnPolicyProjectParent;
private PublicSwimmingPool hasProductReturnPolicyPublicSwimmingPoolParent;
private RadioStation hasProductReturnPolicyRadioStationParent;
private RealEstateAgent hasProductReturnPolicyRealEstateAgentParent;
private RecyclingCenter hasProductReturnPolicyRecyclingCenterParent;
private ResearchOrganization hasProductReturnPolicyResearchOrganizationParent;
private ResearchProject hasProductReturnPolicyResearchProjectParent;
private Resort hasProductReturnPolicyResortParent;
private Restaurant hasProductReturnPolicyRestaurantParent;
private RoofingContractor hasProductReturnPolicyRoofingContractorParent;
private School hasProductReturnPolicySchoolParent;
private SearchRescueOrganization hasProductReturnPolicySearchRescueOrganizationParent;
private SelfStorage hasProductReturnPolicySelfStorageParent;
private ShoeStore hasProductReturnPolicyShoeStoreParent;
private ShoppingCenter hasProductReturnPolicyShoppingCenterParent;
private SkiResort hasProductReturnPolicySkiResortParent;
private SomeProducts hasProductReturnPolicySomeProductsParent;
private SportingGoodsStore hasProductReturnPolicySportingGoodsStoreParent;
private SportsActivityLocation hasProductReturnPolicySportsActivityLocationParent;
private SportsClub hasProductReturnPolicySportsClubParent;
private SportsOrganization hasProductReturnPolicySportsOrganizationParent;
private SportsTeam hasProductReturnPolicySportsTeamParent;
private StadiumOrArena hasProductReturnPolicyStadiumOrArenaParent;
private Store hasProductReturnPolicyStoreParent;
private TattooParlor hasProductReturnPolicyTattooParlorParent;
private TelevisionStation hasProductReturnPolicyTelevisionStationParent;
private TennisComplex hasProductReturnPolicyTennisComplexParent;
private TheaterGroup hasProductReturnPolicyTheaterGroupParent;
private TireShop hasProductReturnPolicyTireShopParent;
private TouristInformationCenter hasProductReturnPolicyTouristInformationCenterParent;
private ToyStore hasProductReturnPolicyToyStoreParent;
private TravelAgency hasProductReturnPolicyTravelAgencyParent;
private Vehicle hasProductReturnPolicyVehicleParent;
private VeterinaryCare hasProductReturnPolicyVeterinaryCareParent;
private WholesaleStore hasProductReturnPolicyWholesaleStoreParent;
private Winery hasProductReturnPolicyWineryParent;
private WorkersUnion hasProductReturnPolicyWorkersUnionParent;
private AccountingService hasProductReturnPolicyAccountingServiceParent;
private AdultEntertainment hasProductReturnPolicyAdultEntertainmentParent;
private AggregateOffer hasProductReturnPolicyAggregateOfferParent;
private Airline hasProductReturnPolicyAirlineParent;
private AmusementPark hasProductReturnPolicyAmusementParkParent;
private AnimalShelter hasProductReturnPolicyAnimalShelterParent;
private ArchiveOrganization hasProductReturnPolicyArchiveOrganizationParent;
private ArtGallery hasProductReturnPolicyArtGalleryParent;
private Attorney hasProductReturnPolicyAttorneyParent;
private AutoBodyShop hasProductReturnPolicyAutoBodyShopParent;
private AutoDealer hasProductReturnPolicyAutoDealerParent;
private AutomatedTeller hasProductReturnPolicyAutomatedTellerParent;
private AutomotiveBusiness hasProductReturnPolicyAutomotiveBusinessParent;
private AutoPartsStore hasProductReturnPolicyAutoPartsStoreParent;
private AutoRental hasProductReturnPolicyAutoRentalParent;
private AutoRepair hasProductReturnPolicyAutoRepairParent;
private AutoWash hasProductReturnPolicyAutoWashParent;
private Bakery hasProductReturnPolicyBakeryParent;
private BankOrCreditUnion hasProductReturnPolicyBankOrCreditUnionParent;
private BarOrPub hasProductReturnPolicyBarOrPubParent;
private BeautySalon hasProductReturnPolicyBeautySalonParent;
private BedAndBreakfast hasProductReturnPolicyBedAndBreakfastParent;
private BikeStore hasProductReturnPolicyBikeStoreParent;
private BookStore hasProductReturnPolicyBookStoreParent;
private BowlingAlley hasProductReturnPolicyBowlingAlleyParent;
private Brewery hasProductReturnPolicyBreweryParent;
private BusOrCoach hasProductReturnPolicyBusOrCoachParent;
private CafeOrCoffeeShop hasProductReturnPolicyCafeOrCoffeeShopParent;
private Campground hasProductReturnPolicyCampgroundParent;
private Car hasProductReturnPolicyCarParent;
private Casino hasProductReturnPolicyCasinoParent;
private ChildCare hasProductReturnPolicyChildCareParent;
private ClothingStore hasProductReturnPolicyClothingStoreParent;
private CollegeOrUniversity hasProductReturnPolicyCollegeOrUniversityParent;
private ComedyClub hasProductReturnPolicyComedyClubParent;
private ComputerStore hasProductReturnPolicyComputerStoreParent;
private Consortium hasProductReturnPolicyConsortiumParent;
private ConvenienceStore hasProductReturnPolicyConvenienceStoreParent;
private Corporation hasProductReturnPolicyCorporationParent;
private CovidTestingFacility hasProductReturnPolicyCovidTestingFacilityParent;
private DanceGroup hasProductReturnPolicyDanceGroupParent;
private DaySpa hasProductReturnPolicyDaySpaParent;
private Dentist hasProductReturnPolicyDentistParent;
private DepartmentStore hasProductReturnPolicyDepartmentStoreParent;
private DiagnosticLab hasProductReturnPolicyDiagnosticLabParent;
private Distillery hasProductReturnPolicyDistilleryParent;
private DryCleaningOrLaundry hasProductReturnPolicyDryCleaningOrLaundryParent;
private EducationalOrganization hasProductReturnPolicyEducationalOrganizationParent;
private Electrician hasProductReturnPolicyElectricianParent;
private ElectronicsStore hasProductReturnPolicyElectronicsStoreParent;
private ElementarySchool hasProductReturnPolicyElementarySchoolParent;
private EmergencyService hasProductReturnPolicyEmergencyServiceParent;
private EmploymentAgency hasProductReturnPolicyEmploymentAgencyParent;
private EntertainmentBusiness hasProductReturnPolicyEntertainmentBusinessParent;
private ExerciseGym hasProductReturnPolicyExerciseGymParent;
private FastFoodRestaurant hasProductReturnPolicyFastFoodRestaurantParent;
private FinancialService hasProductReturnPolicyFinancialServiceParent;
private FireStation hasProductReturnPolicyFireStationParent;
private Florist hasProductReturnPolicyFloristParent;
private FoodEstablishment hasProductReturnPolicyFoodEstablishmentParent;
private FundingAgency hasProductReturnPolicyFundingAgencyParent;
private FundingScheme hasProductReturnPolicyFundingSchemeParent;
private FurnitureStore hasProductReturnPolicyFurnitureStoreParent;
private GardenStore hasProductReturnPolicyGardenStoreParent;
private GasStation hasProductReturnPolicyGasStationParent;
private GeneralContractor hasProductReturnPolicyGeneralContractorParent;
private GolfCourse hasProductReturnPolicyGolfCourseParent;
private GovernmentOffice hasProductReturnPolicyGovernmentOfficeParent;
private GovernmentOrganization hasProductReturnPolicyGovernmentOrganizationParent;
private GroceryStore hasProductReturnPolicyGroceryStoreParent;
private HairSalon hasProductReturnPolicyHairSalonParent;
private HardwareStore hasProductReturnPolicyHardwareStoreParent;
private HealthAndBeautyBusiness hasProductReturnPolicyHealthAndBeautyBusinessParent;
private HealthClub hasProductReturnPolicyHealthClubParent;
private HighSchool hasProductReturnPolicyHighSchoolParent;
private HobbyShop hasProductReturnPolicyHobbyShopParent;
private HomeAndConstructionBusiness hasProductReturnPolicyHomeAndConstructionBusinessParent;
private HomeGoodsStore hasProductReturnPolicyHomeGoodsStoreParent;
private Hospital hasProductReturnPolicyHospitalParent;
private Hostel hasProductReturnPolicyHostelParent;
private Hotel hasProductReturnPolicyHotelParent;
private HousePainter hasProductReturnPolicyHousePainterParent;
private HVACBusiness hasProductReturnPolicyHVACBusinessParent;
private IceCreamShop hasProductReturnPolicyIceCreamShopParent;
private IndividualProduct hasProductReturnPolicyIndividualProductParent;
private InsuranceAgency hasProductReturnPolicyInsuranceAgencyParent;
private InternetCafe hasProductReturnPolicyInternetCafeParent;
private JewelryStore hasProductReturnPolicyJewelryStoreParent;
private LegalService hasProductReturnPolicyLegalServiceParent;
private Library hasProductReturnPolicyLibraryParent;
private LibrarySystem hasProductReturnPolicyLibrarySystemParent;
private LiquorStore hasProductReturnPolicyLiquorStoreParent;
private LocalBusiness hasProductReturnPolicyLocalBusinessParent;
private Locksmith hasProductReturnPolicyLocksmithParent;
private LodgingBusiness hasProductReturnPolicyLodgingBusinessParent;
private MedicalBusiness hasProductReturnPolicyMedicalBusinessParent;
private MedicalClinic hasProductReturnPolicyMedicalClinicParent;
private MedicalOrganization hasProductReturnPolicyMedicalOrganizationParent;
private MensClothingStore hasProductReturnPolicyMensClothingStoreParent;
}