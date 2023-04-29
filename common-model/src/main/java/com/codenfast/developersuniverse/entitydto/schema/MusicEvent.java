package com.codenfast.developersuniverse.entitydto.schema;

import com.codenfast.developersuniverse.EntityModel;

import java.time.LocalDate;
import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/MusicEvent


/**Event type: Music event.*/
public class MusicEvent implements EntityModel {
private String id;
private Boolean passive = Boolean.FALSE;
private LocalDateTime createTime = null;
private LocalDateTime updateTime = null;



/**
*The subject matter of the content.
Inverse property: subjectOf
*/
private Thing about;

/**
*An actor, e.g. in TV, radio, movie, video games etc., or in an event. Actors can be associated with individual items or with a series, episode, clip. Supersedes actors.
*/
private java.util.List<Person> actors;

/**
*The overall rating, based on a collection of reviews or ratings, of the item.
*/
private AggregateRating aggregateRating;

/**
*A person or organization attending the event. Supersedes attendees.
*/
private java.util.List<Organization> attendees;

/**
*An intended audience, i.e. a group for whom something was created. Supersedes serviceAudience.
*/
private java.util.List<Audience> serviceAudience;

/**
*The person or organization who wrote a composition, or who is the composer of a work performed at some event.
*/
private Organization composer;

/**
*A secondary contributor to the CreativeWork or Event.
*/
private Organization contributor;

/**
*A director of e.g. TV, radio, movie, video gaming etc. content, or of an event. Directors can be associated with individual items or with a series, episode, clip. Supersedes directors.
*/
private java.util.List<Person> directors;

/**
*The time admission will commence.
*/
private LocalDateTime doorTime;

/**
*The duration of the item (movie, audio recording, event, etc.) in ISO 8601 date format.
*/
private Duration duration;

/**
*The end date and time of the item (in ISO 8601 date format).
*/
private LocalDate endDate;

/**
*The eventAttendanceMode of an event indicates whether it occurs online, offline, or a mix.
*/
private EventAttendanceModeEnumeration eventAttendanceMode;

/**
*Associates an Event with a Schedule. There are circumstances where it is preferable to share a schedule for a series of repeating events rather than data on the individual events themselves. For example, a website or application might prefer to publish a schedule for a weekly gym class rather than provide data on every event. A schedule could be processed by applications to add forthcoming events to a calendar. An Event that is associated with a Schedule using this property should not have startDate or endDate properties. These are instead defined within the associated Schedule, this avoids any ambiguity for clients using the data. The property might have repeated values to specify different schedules, e.g. for different months or seasons.
*/
private Schedule eventSchedule;

/**
*An eventStatus of an event represents its status; particularly useful when an event is cancelled or rescheduled.
*/
private EventStatusType eventStatus;

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
*The language of the content or performance or used in an action. Please use one of the language codes from the IETF BCP 47 standard. See also availableLanguage. Supersedes language.
*/
private java.util.List<Language> language;

/**
*A flag to signal that the item, event, or place is accessible for free. Supersedes free.
*/
private Boolean isAccessibleForFree;

/**
*Keywords or tags used to describe some item. Multiple textual entries in a keywords list are typically delimited by commas, or by repeating the property.
*/
private DefinedTerm keywords;

/**
*The location of, for example, where an event is happening, where an organization is located, or where an action takes place.
*/
private Place location;

/**
*The total number of individuals that may attend an event or venue.
*/
private String maximumAttendeeCapacity;

/**
*The maximum physical attendee capacity of an Event whose eventAttendanceMode is OfflineEventAttendanceMode (or the offline aspects, in the case of a MixedEventAttendanceMode).
*/
private String maximumPhysicalAttendeeCapacity;

/**
*The maximum physical attendee capacity of an Event whose eventAttendanceMode is OnlineEventAttendanceMode (or the online aspects, in the case of a MixedEventAttendanceMode).
*/
private String maximumVirtualAttendeeCapacity;

/**
*An offer to provide this item—for example, an offer to sell a product, rent the DVD of a movie, perform a service, or give away tickets to an event. Use businessFunction to indicate the kind of transaction offered, i.e. sell, lease, etc. This property can also be used to describe a Demand. While this property is listed as expected on a number of common types, it can be used in others. In that case, using a second type, such as Product or a subtype of Product, can clarify the nature of the offer.
Inverse property: itemOffered
*/
private Demand offers;

/**
*An organizer of an Event.
*/
private Organization organizer;

/**
*A performer at the event—for example, a presenter, musician, musical group or actor. Supersedes performers.
*/
private java.util.List<Organization> performers;

/**
*Used in conjunction with eventStatus for rescheduled or cancelled events. This property contains the previously scheduled start date. For rescheduled events, the startDate property should be used for the newly scheduled start date. In the (rare) case of an event that has been postponed and rescheduled multiple times, this field may be repeated.
*/
private LocalDate previousStartDate;

/**
*The CreativeWork that captured all or part of this Event.
Inverse property: recordedAt
*/
private CreativeWork recordedIn;

/**
*The number of attendee places for an event that remain unallocated.
*/
private String remainingAttendeeCapacity;

/**
*A review of the item. Supersedes reviews.
*/
private java.util.List<Review> reviews;

/**
*A person or organization that supports a thing through a pledge, promise, or financial contribution. E.g. a sponsor of a Medical Study or a corporate sponsor of an event.
*/
private Organization sponsor;

/**
*The start date and time of the item (in ISO 8601 date format).
*/
private LocalDate startDate;

/**
*An Event that is part of this event. For example, a conference event includes many presentations, each of which is a subEvent of the conference. Supersedes subEvents.
Inverse property: superEvent
*/
private java.util.List<Event> superEvent;

/**
*An event that this event is a part of. For example, a collection of individual music performances might each have a music festival as their superEvent.
Inverse property: subEvent
*/
/**
*Organization or person who adapts a creative work to different languages, regional differences and technical requirements of a target market, or that translates during some event.
*/
private Organization translator;

/**
*The typical expected age range, e.g. '7-9', '11-'.
*/
private String typicalAgeRange;

/**
*A work featured in some event, e.g. exhibited in an ExhibitionEvent. Specific subproperties are available for workPerformed (e.g. a play), or a workPresented (a Movie at a ScreeningEvent).
*/
private CreativeWork workFeatured;

/**
*A work performed in some event, for example a play performed in a TheaterEvent.
*/
private CreativeWork workPerformed;

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

}