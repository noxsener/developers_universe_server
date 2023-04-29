package com.codenfast.developersuniverse.entitydto.schema;

import com.codenfast.developersuniverse.EntityModel;

import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/Language


/**Natural languages such as Spanish, Tamil, Hindi, English, etc. Formal language code tags expressed in BCP 47 can be used via the alternateName property. The Language type previously also covered programming languages such as Scheme and Lisp, which are now best represented using ComputerLanguage.*/
public class Language implements EntityModel {
                        private String id;
            private Boolean passive = Boolean.FALSE;
            private LocalDateTime createTime = null;
            private LocalDateTime updateTime = null;


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

            private LearningResource languageLearningResourceParent;
            private Legislation languageLegislationParent;
            private LegislationObject languageLegislationObjectParent;
            private LinkRole languageLinkRoleParent;
            private LiteraryEvent languageLiteraryEventParent;
            private LiveBlogPosting languageLiveBlogPostingParent;
            private Manuscript languageManuscriptParent;
            private Map languageMapParent;
            private MathSolver languageMathSolverParent;
            private MediaGallery languageMediaGalleryParent;
            private MediaObject languageMediaObjectParent;
            private MediaReview languageMediaReviewParent;
            private MediaReviewItem languageMediaReviewItemParent;
            private MedicalScholarlyArticle languageMedicalScholarlyArticleParent;
            private MedicalWebPage languageMedicalWebPageParent;
            private Menu languageMenuParent;
            private MenuSection languageMenuSectionParent;
            private Message languageMessageParent;
            private MobileApplication languageMobileApplicationParent;
            private Movie languageMovieParent;
            private MovieClip languageMovieClipParent;
            private MovieSeries languageMovieSeriesParent;
            private MusicAlbum languageMusicAlbumParent;
            private MusicComposition languageMusicCompositionParent;
            private MusicEvent languageMusicEventParent;
            private MusicPlaylist languageMusicPlaylistParent;
            private MusicRecording languageMusicRecordingParent;
            private MusicRelease languageMusicReleaseParent;
            private MusicVideoObject languageMusicVideoObjectParent;
            private NewsArticle languageNewsArticleParent;
            private Newspaper languageNewspaperParent;
            private NoteDigitalDocument languageNoteDigitalDocumentParent;
            private OnDemandEvent languageOnDemandEventParent;
            private OpinionNewsArticle languageOpinionNewsArticleParent;
            private Painting languagePaintingParent;
            private Periodical languagePeriodicalParent;
            private Photograph languagePhotographParent;
            private Play languagePlayParent;
            private PodcastEpisode languagePodcastEpisodeParent;
            private PodcastSeason languagePodcastSeasonParent;
            private PodcastSeries languagePodcastSeriesParent;
            private Poster languagePosterParent;
            private PresentationDigitalDocument languagePresentationDigitalDocumentParent;
            private ProductCollection languageProductCollectionParent;
            private ProfilePage languageProfilePageParent;
            private PublicationEvent languagePublicationEventParent;
            private PublicationIssue languagePublicationIssueParent;
            private PublicationVolume languagePublicationVolumeParent;
            private QAPage languageQAPageParent;
            private Question languageQuestionParent;
            private Quiz languageQuizParent;
            private Quotation languageQuotationParent;
            private RadioBroadcastService languageRadioBroadcastServiceParent;
            private RadioClip languageRadioClipParent;
            private RadioEpisode languageRadioEpisodeParent;
            private RadioSeason languageRadioSeasonParent;
            private RadioSeries languageRadioSeriesParent;
            private RealEstateListing languageRealEstateListingParent;
            private Recipe languageRecipeParent;
            private Recommendation languageRecommendationParent;
            private ReplyAction languageReplyActionParent;
            private Report languageReportParent;
            private ReportageNewsArticle languageReportageNewsArticleParent;
            private Review languageReviewParent;
            private ReviewNewsArticle languageReviewNewsArticleParent;
            private RsvpAction languageRsvpActionParent;
            private SaleEvent languageSaleEventParent;
            private SatiricalArticle languageSatiricalArticleParent;
            private SchemaOrgTable languageSchemaOrgTableParent;
            private ScholarlyArticle languageScholarlyArticleParent;
            private ScreeningEvent languageScreeningEventParent;
            private Sculpture languageSculptureParent;
            private SearchResultsPage languageSearchResultsPageParent;
            private Season languageSeasonParent;
            private ShareAction languageShareActionParent;
            private SheetMusic languageSheetMusicParent;
            private ShortStory languageShortStoryParent;
            private SiteNavigationElement languageSiteNavigationElementParent;
            private SocialEvent languageSocialEventParent;
            private SocialMediaPosting languageSocialMediaPostingParent;
            private SoftwareApplication languageSoftwareApplicationParent;
            private SoftwareSourceCode languageSoftwareSourceCodeParent;
            private SpecialAnnouncement languageSpecialAnnouncementParent;
            private SportsEvent languageSportsEventParent;
            private SpreadsheetDigitalDocument languageSpreadsheetDigitalDocumentParent;
            private Statement languageStatementParent;
            private TechArticle languageTechArticleParent;
            private TextDigitalDocument languageTextDigitalDocumentParent;
            private TheaterEvent languageTheaterEventParent;
            private Thesis languageThesisParent;
            private ThreeDModel languageThreeDModelParent;
            private TVClip languageTVClipParent;
            private TVEpisode languageTVEpisodeParent;
            private TVSeason languageTVSeasonParent;
            private TVSeries languageTVSeriesParent;
            private UserBlocks languageUserBlocksParent;
            private UserCheckins languageUserCheckinsParent;
            private UserComments languageUserCommentsParent;
            private UserDownloads languageUserDownloadsParent;
            private UserInteraction languageUserInteractionParent;
            private UserLikes languageUserLikesParent;
            private UserPageVisits languageUserPageVisitsParent;
            private UserPlays languageUserPlaysParent;
            private UserPlusOnes languageUserPlusOnesParent;
            private UserReview languageUserReviewParent;
            private UserTweets languageUserTweetsParent;
            private VideoGallery languageVideoGalleryParent;
            private VideoGame languageVideoGameParent;
            private VideoGameClip languageVideoGameClipParent;
            private VideoGameSeries languageVideoGameSeriesParent;
            private VideoObject languageVideoObjectParent;
            private VideoObjectSnapshot languageVideoObjectSnapshotParent;
            private VisualArtsEvent languageVisualArtsEventParent;
            private VisualArtwork languageVisualArtworkParent;
            private WebApplication languageWebApplicationParent;
            private WebContent languageWebContentParent;
            private WebPage languageWebPageParent;
            private WebPageElement languageWebPageElementParent;
            private WebPageTable languageWebPageTableParent;
            private WebSite languageWebSiteParent;
            private WPAdBlock languageWPAdBlockParent;
            private WPFooter languageWPFooterParent;
            private WPHeader languageWPHeaderParent;
            private WPSideBar languageWPSideBarParent;
            private WriteAction languageWriteActionParent;
            private WTable languageWTableParent;
            private APIReference languageAPIReferenceParent;
            private AboutPage languageAboutPageParent;
private AdvertiserContentArticle languageAdvertiserContentArticleParent;
private AmpStory languageAmpStoryParent;
private AnalysisNewsArticle languageAnalysisNewsArticleParent;
private Answer languageAnswerParent;
private ArchiveComponent languageArchiveComponentParent;
private Article languageArticleParent;
private AskAction languageAskActionParent;
private AskPublicNewsArticle languageAskPublicNewsArticleParent;
private Atlas languageAtlasParent;
private Audiobook languageAudiobookParent;
private AudioObject languageAudioObjectParent;
private AudioObjectSnapshot languageAudioObjectSnapshotParent;
private BackgroundNewsArticle languageBackgroundNewsArticleParent;
private Barcode languageBarcodeParent;
private Blog languageBlogParent;
private BlogPosting languageBlogPostingParent;
private Book languageBookParent;
private BookSeries languageBookSeriesParent;
private BroadcastEvent languageBroadcastEventParent;
private BroadcastService languageBroadcastServiceParent;
private BusinessEvent languageBusinessEventParent;
private CategoryCodeSet languageCategoryCodeSetParent;
private Chapter languageChapterParent;
private CheckInAction languageCheckInActionParent;
private CheckOutAction languageCheckOutActionParent;
private CheckoutPage languageCheckoutPageParent;
private ChildrensEvent languageChildrensEventParent;
private Claim languageClaimParent;
private ClaimReview languageClaimReviewParent;
private Clip languageClipParent;
private Code languageCodeParent;
private Collection languageCollectionParent;
private CollectionPage languageCollectionPageParent;
private ComedyEvent languageComedyEventParent;
private ComicCoverArt languageComicCoverArtParent;
private ComicIssue languageComicIssueParent;
private ComicSeries languageComicSeriesParent;
private ComicStory languageComicStoryParent;
private Comment languageCommentParent;
private CommentAction languageCommentActionParent;
private CommunicateAction languageCommunicateActionParent;
private CompleteDataFeed languageCompleteDataFeedParent;
private ConfirmAction languageConfirmActionParent;
private ContactPage languageContactPageParent;
private Conversation languageConversationParent;
private CorrectionComment languageCorrectionCommentParent;
private Course languageCourseParent;
private CourseInstance languageCourseInstanceParent;
private CoverArt languageCoverArtParent;
private CreativeWork languageCreativeWorkParent;
private CreativeWorkSeason languageCreativeWorkSeasonParent;
private CreativeWorkSeries languageCreativeWorkSeriesParent;
private CriticReview languageCriticReviewParent;
private DanceEvent languageDanceEventParent;
private DataCatalog languageDataCatalogParent;
private DataDownload languageDataDownloadParent;
private DataFeed languageDataFeedParent;
private Dataset languageDatasetParent;
private DefinedTermSet languageDefinedTermSetParent;
private DeliveryEvent languageDeliveryEventParent;
private DigitalDocument languageDigitalDocumentParent;
private DiscussionForumPosting languageDiscussionForumPostingParent;
private Drawing languageDrawingParent;
private EducationalOccupationalCredential languageEducationalOccupationalCredentialParent;
private EducationEvent languageEducationEventParent;
private EmailMessage languageEmailMessageParent;
private EmployerReview languageEmployerReviewParent;
private Episode languageEpisodeParent;
private Event languageEventParent;
private EventSeries languageEventSeriesParent;
private ExhibitionEvent languageExhibitionEventParent;
private FAQPage languageFAQPageParent;
private Festival languageFestivalParent;
private FoodEvent languageFoodEventParent;
private Game languageGameParent;
private Guide languageGuideParent;
private Hackathon languageHackathonParent;
private HealthTopicContent languageHealthTopicContentParent;
private HowTo languageHowToParent;
private HowToDirection languageHowToDirectionParent;
private HowToSection languageHowToSectionParent;
private HowToStep languageHowToStepParent;
private HowToTip languageHowToTipParent;
private HyperToc languageHyperTocParent;
private HyperTocEntry languageHyperTocEntryParent;
private ImageGallery languageImageGalleryParent;
private ImageObject languageImageObjectParent;
private ImageObjectSnapshot languageImageObjectSnapshotParent;
private InformAction languageInformActionParent;
private InviteAction languageInviteActionParent;
private ItemPage languageItemPageParent;
}