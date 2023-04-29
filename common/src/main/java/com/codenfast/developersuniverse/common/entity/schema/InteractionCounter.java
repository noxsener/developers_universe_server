package com.codenfast.developersuniverse.common.entity.schema;

import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/InteractionCounter


/**A summary of how users have interacted with this CreativeWork. In most cases, authors will use a subtype to specify the specific type of interaction.*/
public class InteractionCounter {
                        private String id;
            private Boolean passive = Boolean.FALSE;
            private LocalDateTime createTime = null;
            private LocalDateTime updateTime = null;


    /**
     * The endTime of something. For a reserved event or service (e.g. FoodEstablishmentReservation), the time that it is expected to end. For actions that span a period of time, when the action was performed. E.g. John wrote a book from January to December. For media, including audio and video, it's the time offset of the end of a clip within a larger file.
     * <p>
     * Note that Event uses startDate/endDate instead of startTime/endTime, even when describing dates with times. This situation may be clarified in future revisions.
     */
        private LocalDateTime endTime;

    /**
     * The WebSite or SoftwareApplication where the interactions took place.
     */
            private SoftwareApplication interactionService;

    /**
     * The Action representing the type of interaction. For up votes, +1s, etc. use LikeAction. For down votes use DislikeAction. Otherwise, use the most specific Action.
     */
            private Action interactionType;

    /**
     * The location of, for example, where an event is happening, where an organization is located, or where an action takes place.
     */
            private Place location;

    /**
     * The startTime of something. For a reserved event or service (e.g. FoodEstablishmentReservation), the time that it is expected to start. For actions that span a period of time, when the action was performed. E.g. John wrote a book from January to December. For media, including audio and video, it's the time offset of the start of a clip within a larger file.
     * <p>
     * Note that Event uses startDate/endDate instead of startTime/endTime, even when describing dates with times. This situation may be clarified in future revisions.
     */
        private LocalDateTime startTime;

    /**
     * The number of interactions for the CreativeWork using the WebSite or SoftwareApplication.
     */
        private String userInteractionCount;

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

            private InternetCafe interactionCountInternetCafeParent;
            private ItemPage interactionCountItemPageParent;
            private JewelryStore interactionCountJewelryStoreParent;
            private LearningResource interactionCountLearningResourceParent;
            private LegalService interactionCountLegalServiceParent;
            private Legislation interactionCountLegislationParent;
            private LegislationObject interactionCountLegislationObjectParent;
            private Library interactionCountLibraryParent;
            private LibrarySystem interactionCountLibrarySystemParent;
            private LiquorStore interactionCountLiquorStoreParent;
            private LiveBlogPosting interactionCountLiveBlogPostingParent;
            private LocalBusiness interactionCountLocalBusinessParent;
            private Locksmith interactionCountLocksmithParent;
            private LodgingBusiness interactionCountLodgingBusinessParent;
            private Manuscript interactionCountManuscriptParent;
            private Map interactionCountMapParent;
            private MathSolver interactionCountMathSolverParent;
            private MediaGallery interactionCountMediaGalleryParent;
            private MediaObject interactionCountMediaObjectParent;
            private MediaReview interactionCountMediaReviewParent;
            private MediaReviewItem interactionCountMediaReviewItemParent;
            private MedicalBusiness interactionCountMedicalBusinessParent;
            private MedicalClinic interactionCountMedicalClinicParent;
            private MedicalOrganization interactionCountMedicalOrganizationParent;
            private MedicalScholarlyArticle interactionCountMedicalScholarlyArticleParent;
            private MedicalWebPage interactionCountMedicalWebPageParent;
            private MensClothingStore interactionCountMensClothingStoreParent;
            private Menu interactionCountMenuParent;
            private MenuSection interactionCountMenuSectionParent;
            private Message interactionCountMessageParent;
            private MiddleSchool interactionCountMiddleSchoolParent;
            private MobileApplication interactionCountMobileApplicationParent;
            private MobilePhoneStore interactionCountMobilePhoneStoreParent;
            private Motel interactionCountMotelParent;
            private MotorcycleDealer interactionCountMotorcycleDealerParent;
            private MotorcycleRepair interactionCountMotorcycleRepairParent;
            private Movie interactionCountMovieParent;
            private MovieClip interactionCountMovieClipParent;
            private MovieRentalStore interactionCountMovieRentalStoreParent;
            private MovieSeries interactionCountMovieSeriesParent;
            private MovieTheater interactionCountMovieTheaterParent;
            private MovingCompany interactionCountMovingCompanyParent;
            private MusicAlbum interactionCountMusicAlbumParent;
            private MusicComposition interactionCountMusicCompositionParent;
            private MusicGroup interactionCountMusicGroupParent;
            private MusicPlaylist interactionCountMusicPlaylistParent;
            private MusicRecording interactionCountMusicRecordingParent;
            private MusicRelease interactionCountMusicReleaseParent;
            private MusicStore interactionCountMusicStoreParent;
            private MusicVideoObject interactionCountMusicVideoObjectParent;
            private NailSalon interactionCountNailSalonParent;
            private NewsArticle interactionCountNewsArticleParent;
            private NewsMediaOrganization interactionCountNewsMediaOrganizationParent;
            private Newspaper interactionCountNewspaperParent;
            private NGO interactionCountNGOParent;
            private NightClub interactionCountNightClubParent;
            private Notary interactionCountNotaryParent;
            private NoteDigitalDocument interactionCountNoteDigitalDocumentParent;
            private OfficeEquipmentStore interactionCountOfficeEquipmentStoreParent;
            private OnlineBusiness interactionCountOnlineBusinessParent;
            private OnlineStore interactionCountOnlineStoreParent;
            private OpinionNewsArticle interactionCountOpinionNewsArticleParent;
            private Optician interactionCountOpticianParent;
            private Organization interactionCountOrganizationParent;
            private OutletStore interactionCountOutletStoreParent;
            private Painting interactionCountPaintingParent;
            private Patient interactionCountPatientParent;
            private PawnShop interactionCountPawnShopParent;
            private PerformingGroup interactionCountPerformingGroupParent;
            private Periodical interactionCountPeriodicalParent;
            private Person interactionCountPersonParent;
            private PetStore interactionCountPetStoreParent;
            private Pharmacy interactionCountPharmacyParent;
            private Photograph interactionCountPhotographParent;
            private Physician interactionCountPhysicianParent;
            private Play interactionCountPlayParent;
            private Plumber interactionCountPlumberParent;
            private PodcastEpisode interactionCountPodcastEpisodeParent;
            private PodcastSeason interactionCountPodcastSeasonParent;
            private PodcastSeries interactionCountPodcastSeriesParent;
            private PoliceStation interactionCountPoliceStationParent;
            private Poster interactionCountPosterParent;
            private PostOffice interactionCountPostOfficeParent;
            private Preschool interactionCountPreschoolParent;
            private PresentationDigitalDocument interactionCountPresentationDigitalDocumentParent;
            private ProductCollection interactionCountProductCollectionParent;
            private ProfessionalService interactionCountProfessionalServiceParent;
            private ProfilePage interactionCountProfilePageParent;
            private Project interactionCountProjectParent;
            private PublicationIssue interactionCountPublicationIssueParent;
            private PublicationVolume interactionCountPublicationVolumeParent;
            private PublicSwimmingPool interactionCountPublicSwimmingPoolParent;
            private QAPage interactionCountQAPageParent;
            private Question interactionCountQuestionParent;
            private Quiz interactionCountQuizParent;
            private Quotation interactionCountQuotationParent;
            private RadioClip interactionCountRadioClipParent;
            private RadioEpisode interactionCountRadioEpisodeParent;
            private RadioSeason interactionCountRadioSeasonParent;
            private RadioSeries interactionCountRadioSeriesParent;
            private RadioStation interactionCountRadioStationParent;
            private RealEstateAgent interactionCountRealEstateAgentParent;
            private RealEstateListing interactionCountRealEstateListingParent;
            private Recipe interactionCountRecipeParent;
            private Recommendation interactionCountRecommendationParent;
            private RecyclingCenter interactionCountRecyclingCenterParent;
            private Report interactionCountReportParent;
            private ReportageNewsArticle interactionCountReportageNewsArticleParent;
            private ResearchOrganization interactionCountResearchOrganizationParent;
            private ResearchProject interactionCountResearchProjectParent;
            private Resort interactionCountResortParent;
            private Restaurant interactionCountRestaurantParent;
            private Review interactionCountReviewParent;
            private ReviewNewsArticle interactionCountReviewNewsArticleParent;
            private RoofingContractor interactionCountRoofingContractorParent;
            private SatiricalArticle interactionCountSatiricalArticleParent;
            private SchemaOrgTable interactionCountSchemaOrgTableParent;
            private ScholarlyArticle interactionCountScholarlyArticleParent;
            private School interactionCountSchoolParent;
            private Sculpture interactionCountSculptureParent;
            private SearchRescueOrganization interactionCountSearchRescueOrganizationParent;
            private SearchResultsPage interactionCountSearchResultsPageParent;
            private Season interactionCountSeasonParent;
            private SelfStorage interactionCountSelfStorageParent;
            private SheetMusic interactionCountSheetMusicParent;
            private ShoeStore interactionCountShoeStoreParent;
            private ShoppingCenter interactionCountShoppingCenterParent;
            private ShortStory interactionCountShortStoryParent;
            private SiteNavigationElement interactionCountSiteNavigationElementParent;
            private SkiResort interactionCountSkiResortParent;
            private SocialMediaPosting interactionCountSocialMediaPostingParent;
            private SoftwareApplication interactionCountSoftwareApplicationParent;
            private SoftwareSourceCode interactionCountSoftwareSourceCodeParent;
            private SpecialAnnouncement interactionCountSpecialAnnouncementParent;
            private SportingGoodsStore interactionCountSportingGoodsStoreParent;
            private SportsActivityLocation interactionCountSportsActivityLocationParent;
            private SportsClub interactionCountSportsClubParent;
            private SportsOrganization interactionCountSportsOrganizationParent;
            private SportsTeam interactionCountSportsTeamParent;
            private SpreadsheetDigitalDocument interactionCountSpreadsheetDigitalDocumentParent;
            private StadiumOrArena interactionCountStadiumOrArenaParent;
            private Statement interactionCountStatementParent;
            private Store interactionCountStoreParent;
            private TattooParlor interactionCountTattooParlorParent;
            private TechArticle interactionCountTechArticleParent;
            private TelevisionStation interactionCountTelevisionStationParent;
            private TennisComplex interactionCountTennisComplexParent;
            private TextDigitalDocument interactionCountTextDigitalDocumentParent;
            private TheaterGroup interactionCountTheaterGroupParent;
            private Thesis interactionCountThesisParent;
            private ThreeDModel interactionCountThreeDModelParent;
            private TireShop interactionCountTireShopParent;
            private TouristInformationCenter interactionCountTouristInformationCenterParent;
            private ToyStore interactionCountToyStoreParent;
            private TravelAgency interactionCountTravelAgencyParent;
            private TVClip interactionCountTVClipParent;
            private TVEpisode interactionCountTVEpisodeParent;
            private TVSeason interactionCountTVSeasonParent;
            private TVSeries interactionCountTVSeriesParent;
            private UserReview interactionCountUserReviewParent;
            private VeterinaryCare interactionCountVeterinaryCareParent;
            private VideoGallery interactionCountVideoGalleryParent;
            private VideoGame interactionCountVideoGameParent;
            private VideoGameClip interactionCountVideoGameClipParent;
            private VideoGameSeries interactionCountVideoGameSeriesParent;
            private VideoObject interactionCountVideoObjectParent;
            private VideoObjectSnapshot interactionCountVideoObjectSnapshotParent;
            private VisualArtwork interactionCountVisualArtworkParent;
            private WebApplication interactionCountWebApplicationParent;
            private WebContent interactionCountWebContentParent;
            private WebPage interactionCountWebPageParent;
            private WebPageElement interactionCountWebPageElementParent;
            private WebPageTable interactionCountWebPageTableParent;
            private WebSite interactionCountWebSiteParent;
            private WholesaleStore interactionCountWholesaleStoreParent;
            private Winery interactionCountWineryParent;
            private WorkersUnion interactionCountWorkersUnionParent;
            private WPAdBlock interactionCountWPAdBlockParent;
            private WPFooter interactionCountWPFooterParent;
            private WPHeader interactionCountWPHeaderParent;
            private WPSideBar interactionCountWPSideBarParent;
            private WTable interactionCountWTableParent;
            private APIReference interactionCountAPIReferenceParent;

            private APIReference interactionCountAboutPageParent;
private AccountingService interactionCountAccountingServiceParent;
private AdultEntertainment interactionCountAdultEntertainmentParent;
private AdvertiserContentArticle interactionCountAdvertiserContentArticleParent;
private Airline interactionCountAirlineParent;
private AmpStory interactionCountAmpStoryParent;
private AmusementPark interactionCountAmusementParkParent;
private AnalysisNewsArticle interactionCountAnalysisNewsArticleParent;
private AnimalShelter interactionCountAnimalShelterParent;
private Answer interactionCountAnswerParent;
private ArchiveComponent interactionCountArchiveComponentParent;
private ArchiveOrganization interactionCountArchiveOrganizationParent;
private ArtGallery interactionCountArtGalleryParent;
private Article interactionCountArticleParent;
private AskPublicNewsArticle interactionCountAskPublicNewsArticleParent;
private Atlas interactionCountAtlasParent;
private Attorney interactionCountAttorneyParent;
private Audiobook interactionCountAudiobookParent;
private AudioObject interactionCountAudioObjectParent;
private AudioObjectSnapshot interactionCountAudioObjectSnapshotParent;
private AutoBodyShop interactionCountAutoBodyShopParent;
private AutoDealer interactionCountAutoDealerParent;
private AutomatedTeller interactionCountAutomatedTellerParent;
private AutomotiveBusiness interactionCountAutomotiveBusinessParent;
private AutoPartsStore interactionCountAutoPartsStoreParent;
private AutoRental interactionCountAutoRentalParent;
private AutoRepair interactionCountAutoRepairParent;
private AutoWash interactionCountAutoWashParent;
private BackgroundNewsArticle interactionCountBackgroundNewsArticleParent;
private Bakery interactionCountBakeryParent;
private BankOrCreditUnion interactionCountBankOrCreditUnionParent;
private Barcode interactionCountBarcodeParent;
private BarOrPub interactionCountBarOrPubParent;
private BeautySalon interactionCountBeautySalonParent;
private BedAndBreakfast interactionCountBedAndBreakfastParent;
private BikeStore interactionCountBikeStoreParent;
private Blog interactionCountBlogParent;
private BlogPosting interactionCountBlogPostingParent;
private Book interactionCountBookParent;
private BookSeries interactionCountBookSeriesParent;
private BookStore interactionCountBookStoreParent;
private BowlingAlley interactionCountBowlingAlleyParent;
private Brewery interactionCountBreweryParent;
private CafeOrCoffeeShop interactionCountCafeOrCoffeeShopParent;
private Campground interactionCountCampgroundParent;
private Casino interactionCountCasinoParent;
private CategoryCodeSet interactionCountCategoryCodeSetParent;
private Chapter interactionCountChapterParent;
private CheckoutPage interactionCountCheckoutPageParent;
private ChildCare interactionCountChildCareParent;
private Claim interactionCountClaimParent;
private ClaimReview interactionCountClaimReviewParent;
private Clip interactionCountClipParent;
private ClothingStore interactionCountClothingStoreParent;
private Code interactionCountCodeParent;
private Collection interactionCountCollectionParent;
private CollectionPage interactionCountCollectionPageParent;
private CollegeOrUniversity interactionCountCollegeOrUniversityParent;
private ComedyClub interactionCountComedyClubParent;
private ComicCoverArt interactionCountComicCoverArtParent;
private ComicIssue interactionCountComicIssueParent;
private ComicSeries interactionCountComicSeriesParent;
private ComicStory interactionCountComicStoryParent;
private Comment interactionCountCommentParent;
private CompleteDataFeed interactionCountCompleteDataFeedParent;
private ComputerStore interactionCountComputerStoreParent;
private Consortium interactionCountConsortiumParent;
private ContactPage interactionCountContactPageParent;
private ConvenienceStore interactionCountConvenienceStoreParent;
private Conversation interactionCountConversationParent;
private Corporation interactionCountCorporationParent;
private CorrectionComment interactionCountCorrectionCommentParent;
private Course interactionCountCourseParent;
private CoverArt interactionCountCoverArtParent;
private CovidTestingFacility interactionCountCovidTestingFacilityParent;
private CreativeWork interactionCountCreativeWorkParent;
private CreativeWorkSeason interactionCountCreativeWorkSeasonParent;
private CreativeWorkSeries interactionCountCreativeWorkSeriesParent;
private CriticReview interactionCountCriticReviewParent;
private DanceGroup interactionCountDanceGroupParent;
private DataCatalog interactionCountDataCatalogParent;
private DataDownload interactionCountDataDownloadParent;
private DataFeed interactionCountDataFeedParent;
private Dataset interactionCountDatasetParent;
private DaySpa interactionCountDaySpaParent;
private DefinedTermSet interactionCountDefinedTermSetParent;
private Dentist interactionCountDentistParent;
private DepartmentStore interactionCountDepartmentStoreParent;
private DiagnosticLab interactionCountDiagnosticLabParent;
private DigitalDocument interactionCountDigitalDocumentParent;
private DiscussionForumPosting interactionCountDiscussionForumPostingParent;
private Distillery interactionCountDistilleryParent;
private Drawing interactionCountDrawingParent;
private DryCleaningOrLaundry interactionCountDryCleaningOrLaundryParent;
private EducationalOccupationalCredential interactionCountEducationalOccupationalCredentialParent;
private EducationalOrganization interactionCountEducationalOrganizationParent;
private Electrician interactionCountElectricianParent;
private ElectronicsStore interactionCountElectronicsStoreParent;
private ElementarySchool interactionCountElementarySchoolParent;
private EmailMessage interactionCountEmailMessageParent;
private EmergencyService interactionCountEmergencyServiceParent;
private EmployerReview interactionCountEmployerReviewParent;
private EmploymentAgency interactionCountEmploymentAgencyParent;
private EntertainmentBusiness interactionCountEntertainmentBusinessParent;
private Episode interactionCountEpisodeParent;
private ExerciseGym interactionCountExerciseGymParent;
private FAQPage interactionCountFAQPageParent;
private FastFoodRestaurant interactionCountFastFoodRestaurantParent;
private FinancialService interactionCountFinancialServiceParent;
private FireStation interactionCountFireStationParent;
private Florist interactionCountFloristParent;
private FoodEstablishment interactionCountFoodEstablishmentParent;
private FundingAgency interactionCountFundingAgencyParent;
private FundingScheme interactionCountFundingSchemeParent;
private FurnitureStore interactionCountFurnitureStoreParent;
private Game interactionCountGameParent;
private GardenStore interactionCountGardenStoreParent;
private GasStation interactionCountGasStationParent;
private GeneralContractor interactionCountGeneralContractorParent;
private GolfCourse interactionCountGolfCourseParent;
private GovernmentOffice interactionCountGovernmentOfficeParent;
private GovernmentOrganization interactionCountGovernmentOrganizationParent;
private GroceryStore interactionCountGroceryStoreParent;
private Guide interactionCountGuideParent;
private HairSalon interactionCountHairSalonParent;
private HardwareStore interactionCountHardwareStoreParent;
private HealthAndBeautyBusiness interactionCountHealthAndBeautyBusinessParent;
private HealthClub interactionCountHealthClubParent;
private HealthTopicContent interactionCountHealthTopicContentParent;
private HighSchool interactionCountHighSchoolParent;
private HobbyShop interactionCountHobbyShopParent;
private HomeAndConstructionBusiness interactionCountHomeAndConstructionBusinessParent;
private HomeGoodsStore interactionCountHomeGoodsStoreParent;
private Hospital interactionCountHospitalParent;
private Hostel interactionCountHostelParent;
private Hotel interactionCountHotelParent;
private HousePainter interactionCountHousePainterParent;
private HowTo interactionCountHowToParent;
private HowToDirection interactionCountHowToDirectionParent;
private HowToSection interactionCountHowToSectionParent;
private HowToStep interactionCountHowToStepParent;
private HowToTip interactionCountHowToTipParent;
private HVACBusiness interactionCountHVACBusinessParent;
private HyperToc interactionCountHyperTocParent;
private HyperTocEntry interactionCountHyperTocEntryParent;
private IceCreamShop interactionCountIceCreamShopParent;
private ImageGallery interactionCountImageGalleryParent;
private ImageObject interactionCountImageObjectParent;
private ImageObjectSnapshot interactionCountImageObjectSnapshotParent;
private InsuranceAgency interactionCountInsuranceAgencyParent;
}