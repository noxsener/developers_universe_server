package com.codenfast.developersuniverse.entitydto.schema;

import com.codenfast.developersuniverse.EntityModel;

import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/Audience


/**Intended audience for an item, i.e. the group for whom the item was created.*/
public class Audience implements EntityModel {
                        private String id;
            private Boolean passive = Boolean.FALSE;
            private LocalDateTime createTime = null;
            private LocalDateTime updateTime = null;


    /**
     * The target group associated with a given audience (e.g. veterans, car owners, musicians, etc.).
     */
        private String audienceType;

    /**
     * The geographic area associated with the audience.
     */
            private AdministrativeArea geographicArea;

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

            private Audiobook serviceAudienceAudiobookParent;
            private AudioObject serviceAudienceAudioObjectParent;
            private AudioObjectSnapshot serviceAudienceAudioObjectSnapshotParent;
            private BackgroundNewsArticle serviceAudienceBackgroundNewsArticleParent;
            private BankAccount serviceAudienceBankAccountParent;
            private Barcode serviceAudienceBarcodeParent;
            private BedAndBreakfast serviceAudienceBedAndBreakfastParent;
            private Blog serviceAudienceBlogParent;
            private BlogPosting serviceAudienceBlogPostingParent;
            private Book serviceAudienceBookParent;
            private BookSeries serviceAudienceBookSeriesParent;
            private BroadcastEvent serviceAudienceBroadcastEventParent;
            private BroadcastService serviceAudienceBroadcastServiceParent;
            private BrokerageAccount serviceAudienceBrokerageAccountParent;
            private BusinessEvent serviceAudienceBusinessEventParent;
            private BusOrCoach serviceAudienceBusOrCoachParent;
            private CableOrSatelliteService serviceAudienceCableOrSatelliteServiceParent;
            private Campground serviceAudienceCampgroundParent;
            private Car serviceAudienceCarParent;
            private CategoryCodeSet serviceAudienceCategoryCodeSetParent;
            private Chapter serviceAudienceChapterParent;
            private CheckoutPage serviceAudienceCheckoutPageParent;
            private ChildrensEvent serviceAudienceChildrensEventParent;
            private Claim serviceAudienceClaimParent;
            private ClaimReview serviceAudienceClaimReviewParent;
            private Clip serviceAudienceClipParent;
            private Code serviceAudienceCodeParent;
            private Collection serviceAudienceCollectionParent;
            private CollectionPage serviceAudienceCollectionPageParent;
            private ComedyEvent serviceAudienceComedyEventParent;
            private ComicCoverArt serviceAudienceComicCoverArtParent;
            private ComicIssue serviceAudienceComicIssueParent;
            private ComicSeries serviceAudienceComicSeriesParent;
            private ComicStory serviceAudienceComicStoryParent;
            private Comment serviceAudienceCommentParent;
            private CompleteDataFeed serviceAudienceCompleteDataFeedParent;
            private ContactPage serviceAudienceContactPageParent;
            private Conversation serviceAudienceConversationParent;
            private CorrectionComment serviceAudienceCorrectionCommentParent;
            private Course serviceAudienceCourseParent;
            private CourseInstance serviceAudienceCourseInstanceParent;
            private CoverArt serviceAudienceCoverArtParent;
            private CreativeWork serviceAudienceCreativeWorkParent;
            private CreativeWorkSeason serviceAudienceCreativeWorkSeasonParent;
            private CreativeWorkSeries serviceAudienceCreativeWorkSeriesParent;
            private CriticReview serviceAudienceCriticReviewParent;
            private CurrencyConversionService serviceAudienceCurrencyConversionServiceParent;
            private DanceEvent serviceAudienceDanceEventParent;
            private DataCatalog serviceAudienceDataCatalogParent;
            private DataDownload serviceAudienceDataDownloadParent;
            private DataFeed serviceAudienceDataFeedParent;
            private Dataset serviceAudienceDatasetParent;
            private DefinedTermSet serviceAudienceDefinedTermSetParent;
            private DeliveryEvent serviceAudienceDeliveryEventParent;
            private DepositAccount serviceAudienceDepositAccountParent;
            private DigitalDocument serviceAudienceDigitalDocumentParent;
            private DiscussionForumPosting serviceAudienceDiscussionForumPostingParent;
            private Drawing serviceAudienceDrawingParent;
            private EducationalOccupationalCredential serviceAudienceEducationalOccupationalCredentialParent;
            private EducationEvent serviceAudienceEducationEventParent;
            private EmailMessage serviceAudienceEmailMessageParent;
            private EmployerReview serviceAudienceEmployerReviewParent;
            private Episode serviceAudienceEpisodeParent;
            private Event serviceAudienceEventParent;
            private EventSeries serviceAudienceEventSeriesParent;
            private ExerciseAction serviceAudienceExerciseActionParent;
            private ExhibitionEvent serviceAudienceExhibitionEventParent;
            private FAQPage serviceAudienceFAQPageParent;
            private Festival serviceAudienceFestivalParent;
            private FinancialProduct serviceAudienceFinancialProductParent;
            private FoodEvent serviceAudienceFoodEventParent;
            private FoodService serviceAudienceFoodServiceParent;
            private Game serviceAudienceGameParent;
            private GovernmentService serviceAudienceGovernmentServiceParent;
            private Guide serviceAudienceGuideParent;
            private Hackathon serviceAudienceHackathonParent;
            private HealthTopicContent serviceAudienceHealthTopicContentParent;
            private Hostel serviceAudienceHostelParent;
            private Hotel serviceAudienceHotelParent;
            private HowTo serviceAudienceHowToParent;
            private HowToDirection serviceAudienceHowToDirectionParent;
            private HowToSection serviceAudienceHowToSectionParent;
            private HowToStep serviceAudienceHowToStepParent;
            private HowToTip serviceAudienceHowToTipParent;
            private HyperToc serviceAudienceHyperTocParent;
            private HyperTocEntry serviceAudienceHyperTocEntryParent;
            private ImageGallery serviceAudienceImageGalleryParent;
            private ImageObject serviceAudienceImageObjectParent;
            private ImageObjectSnapshot serviceAudienceImageObjectSnapshotParent;
            private IndividualProduct serviceAudienceIndividualProductParent;
            private InvestmentFund serviceAudienceInvestmentFundParent;
            private InvestmentOrDeposit serviceAudienceInvestmentOrDepositParent;
            private ItemPage serviceAudienceItemPageParent;
            private LearningResource serviceAudienceLearningResourceParent;
            private Legislation serviceAudienceLegislationParent;
            private LegislationObject serviceAudienceLegislationObjectParent;
            private LiteraryEvent serviceAudienceLiteraryEventParent;
            private LiveBlogPosting serviceAudienceLiveBlogPostingParent;
            private LoanOrCredit serviceAudienceLoanOrCreditParent;
            private LodgingBusiness serviceAudienceLodgingBusinessParent;
            private Manuscript serviceAudienceManuscriptParent;
            private Map serviceAudienceMapParent;
            private MathSolver serviceAudienceMathSolverParent;
            private MediaGallery serviceAudienceMediaGalleryParent;
            private MediaObject serviceAudienceMediaObjectParent;
            private MediaReview serviceAudienceMediaReviewParent;
            private MediaReviewItem serviceAudienceMediaReviewItemParent;
            private MedicalScholarlyArticle serviceAudienceMedicalScholarlyArticleParent;
            private MedicalWebPage serviceAudienceMedicalWebPageParent;
            private Menu serviceAudienceMenuParent;
            private MenuSection serviceAudienceMenuSectionParent;
            private Message serviceAudienceMessageParent;
            private MobileApplication serviceAudienceMobileApplicationParent;
            private MortgageLoan serviceAudienceMortgageLoanParent;
            private Motel serviceAudienceMotelParent;
            private Motorcycle serviceAudienceMotorcycleParent;
            private MotorizedBicycle serviceAudienceMotorizedBicycleParent;
            private Movie serviceAudienceMovieParent;
            private MovieClip serviceAudienceMovieClipParent;
            private MovieSeries serviceAudienceMovieSeriesParent;
            private MusicAlbum serviceAudienceMusicAlbumParent;
            private MusicComposition serviceAudienceMusicCompositionParent;
            private MusicEvent serviceAudienceMusicEventParent;
            private MusicPlaylist serviceAudienceMusicPlaylistParent;
            private MusicRecording serviceAudienceMusicRecordingParent;
            private MusicRelease serviceAudienceMusicReleaseParent;
            private MusicVideoObject serviceAudienceMusicVideoObjectParent;
            private NewsArticle serviceAudienceNewsArticleParent;
            private Newspaper serviceAudienceNewspaperParent;
            private NoteDigitalDocument serviceAudienceNoteDigitalDocumentParent;
            private OnDemandEvent serviceAudienceOnDemandEventParent;
            private OpinionNewsArticle serviceAudienceOpinionNewsArticleParent;
            private Painting serviceAudiencePaintingParent;
            private PaymentService serviceAudiencePaymentServiceParent;
            private PerformAction serviceAudiencePerformActionParent;
            private Periodical serviceAudiencePeriodicalParent;
            private Photograph serviceAudiencePhotographParent;
            private Play serviceAudiencePlayParent;
            private PlayAction serviceAudiencePlayActionParent;
            private PodcastEpisode serviceAudiencePodcastEpisodeParent;
            private PodcastSeason serviceAudiencePodcastSeasonParent;
            private PodcastSeries serviceAudiencePodcastSeriesParent;
            private Poster serviceAudiencePosterParent;
            private PresentationDigitalDocument serviceAudiencePresentationDigitalDocumentParent;
            private Product serviceAudienceProductParent;
            private ProductCollection serviceAudienceProductCollectionParent;
            private ProductGroup serviceAudienceProductGroupParent;
            private ProductModel serviceAudienceProductModelParent;
            private ProfilePage serviceAudienceProfilePageParent;
            private PublicationEvent serviceAudiencePublicationEventParent;
            private PublicationIssue serviceAudiencePublicationIssueParent;
            private PublicationVolume serviceAudiencePublicationVolumeParent;
            private QAPage serviceAudienceQAPageParent;
            private Question serviceAudienceQuestionParent;
            private Quiz serviceAudienceQuizParent;
            private Quotation serviceAudienceQuotationParent;
            private RadioBroadcastService serviceAudienceRadioBroadcastServiceParent;
            private RadioClip serviceAudienceRadioClipParent;
            private RadioEpisode serviceAudienceRadioEpisodeParent;
            private RadioSeason serviceAudienceRadioSeasonParent;
            private RadioSeries serviceAudienceRadioSeriesParent;
            private RealEstateListing serviceAudienceRealEstateListingParent;
            private Recipe serviceAudienceRecipeParent;
            private Recommendation serviceAudienceRecommendationParent;
            private Report serviceAudienceReportParent;
            private ReportageNewsArticle serviceAudienceReportageNewsArticleParent;
            private Resort serviceAudienceResortParent;
            private Review serviceAudienceReviewParent;
            private ReviewNewsArticle serviceAudienceReviewNewsArticleParent;
            private SaleEvent serviceAudienceSaleEventParent;
            private SatiricalArticle serviceAudienceSatiricalArticleParent;
            private SchemaOrgTable serviceAudienceSchemaOrgTableParent;
            private ScholarlyArticle serviceAudienceScholarlyArticleParent;
            private ScreeningEvent serviceAudienceScreeningEventParent;
            private Sculpture serviceAudienceSculptureParent;
            private SearchResultsPage serviceAudienceSearchResultsPageParent;
            private Season serviceAudienceSeasonParent;
            private Service serviceAudienceServiceParent;
            private SheetMusic serviceAudienceSheetMusicParent;
            private ShortStory serviceAudienceShortStoryParent;
            private SiteNavigationElement serviceAudienceSiteNavigationElementParent;
            private SkiResort serviceAudienceSkiResortParent;
            private SocialEvent serviceAudienceSocialEventParent;
            private SocialMediaPosting serviceAudienceSocialMediaPostingParent;
            private SoftwareApplication serviceAudienceSoftwareApplicationParent;
            private SoftwareSourceCode serviceAudienceSoftwareSourceCodeParent;
            private SomeProducts serviceAudienceSomeProductsParent;
            private SpecialAnnouncement serviceAudienceSpecialAnnouncementParent;
            private SportsEvent serviceAudienceSportsEventParent;
            private SpreadsheetDigitalDocument serviceAudienceSpreadsheetDigitalDocumentParent;
            private Statement serviceAudienceStatementParent;
            private Taxi serviceAudienceTaxiParent;
            private TaxiService serviceAudienceTaxiServiceParent;
            private TechArticle serviceAudienceTechArticleParent;
            private TextDigitalDocument serviceAudienceTextDigitalDocumentParent;
            private TheaterEvent serviceAudienceTheaterEventParent;
            private Thesis serviceAudienceThesisParent;
            private ThreeDModel serviceAudienceThreeDModelParent;
            private TVClip serviceAudienceTVClipParent;
            private TVEpisode serviceAudienceTVEpisodeParent;
            private TVSeason serviceAudienceTVSeasonParent;
            private TVSeries serviceAudienceTVSeriesParent;
            private UserBlocks serviceAudienceUserBlocksParent;
            private UserCheckins serviceAudienceUserCheckinsParent;
            private UserComments serviceAudienceUserCommentsParent;
            private UserDownloads serviceAudienceUserDownloadsParent;
            private UserInteraction serviceAudienceUserInteractionParent;
            private UserLikes serviceAudienceUserLikesParent;
            private UserPageVisits serviceAudienceUserPageVisitsParent;
            private UserPlays serviceAudienceUserPlaysParent;
            private UserPlusOnes serviceAudienceUserPlusOnesParent;
            private UserReview serviceAudienceUserReviewParent;
            private UserTweets serviceAudienceUserTweetsParent;
            private Vehicle serviceAudienceVehicleParent;
            private VideoGallery serviceAudienceVideoGalleryParent;
            private VideoGame serviceAudienceVideoGameParent;
            private VideoGameClip serviceAudienceVideoGameClipParent;
            private VideoGameSeries serviceAudienceVideoGameSeriesParent;
            private VideoObject serviceAudienceVideoObjectParent;
            private VideoObjectSnapshot serviceAudienceVideoObjectSnapshotParent;
            private VisualArtsEvent serviceAudienceVisualArtsEventParent;
            private VisualArtwork serviceAudienceVisualArtworkParent;
            private WebAPI serviceAudienceWebAPIParent;
            private WebApplication serviceAudienceWebApplicationParent;
            private WebContent serviceAudienceWebContentParent;
            private WebPage serviceAudienceWebPageParent;
            private WebPageElement serviceAudienceWebPageElementParent;
            private WebPageTable serviceAudienceWebPageTableParent;
            private WebSite serviceAudienceWebSiteParent;
            private WPAdBlock serviceAudienceWPAdBlockParent;
            private WPFooter serviceAudienceWPFooterParent;
            private WPHeader serviceAudienceWPHeaderParent;
            private WPSideBar serviceAudienceWPSideBarParent;
            private WTable serviceAudienceWTableParent;
            private APIReference serviceAudienceAPIReferenceParent;
            private AboutPage serviceAudienceAboutPageParent;
private AdvertiserContentArticle serviceAudienceAdvertiserContentArticleParent;
private AmpStory serviceAudienceAmpStoryParent;
private AnalysisNewsArticle serviceAudienceAnalysisNewsArticleParent;
private Answer serviceAudienceAnswerParent;
private ArchiveComponent serviceAudienceArchiveComponentParent;
private Article serviceAudienceArticleParent;
private AskPublicNewsArticle serviceAudienceAskPublicNewsArticleParent;
private Atlas serviceAudienceAtlasParent;
}