package com.codenfast.developersuniverse.entitydto.schema;

import com.codenfast.developersuniverse.EntityModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/RentalCarReservation


/**A reservation for a rental car.

Note: This type is for information about actual reservations, e.g. in confirmation emails or HTML pages with individual confirmations of reservations.*/
public class RentalCarReservation implements EntityModel {
private String id;
private Boolean passive = Boolean.FALSE;
private LocalDateTime createTime = null;
private LocalDateTime updateTime = null;



/**
*Where a rental car can be dropped off.
*/
private Place dropoffLocation;

/**
*When a rental car can be dropped off.
*/
private LocalDateTime dropoffTime;

/**
*Where a taxi will pick up a passenger or a rental car can be picked up.
*/
private Place pickupLocation;

/**
*When a taxi will pick up a passenger or a rental car can be picked up.
*/
private LocalDateTime pickupTime;

/**
*The date and time the reservation was booked.
*/
private LocalDateTime bookingTime;

/**
*An entity that arranges for an exchange between a buyer and a seller. In most cases a broker never acquires or releases ownership of a product or service involved in an exchange. If it is not clear whether an entity is a broker, seller, or buyer, the latter two terms are preferred. Supersedes bookingAgent.
*/
private java.util.List<Organization> bookingAgent;

/**
*The date and time the reservation was modified.
*/
private LocalDateTime modifiedTime;

/**
*The currency of the price, or a price component when attached to PriceSpecification and its subtypes.

Use standard formats: ISO 4217 currency format, e.g. "USD"; Ticker symbol for cryptocurrencies, e.g. "BTC"; well known names for Local Exchange Trading Systems (LETS) and other currency types, e.g. "Ithaca HOUR".
*/
private String priceCurrency;

/**
*Any membership in a frequent flyer, hotel loyalty program, etc. being applied to the reservation.
*/
private ProgramMembership programMembershipUsed;

/**
*The service provider, service operator, or service performer; the goods producer. Another party (a seller) may offer those services or goods on behalf of the provider. A provider may also serve as the seller. Supersedes carrier.
*/
private java.util.List<Organization> carrier;

/**
*The thing -- flight, event, restaurant, etc. being reserved.
*/
private Thing reservationFor;

/**
*A unique identifier for the reservation.
*/
private String reservationId;

/**
*The current status of the reservation.
*/
private ReservationStatusType reservationStatus;

/**
*A ticket associated with the reservation.
*/
private Ticket reservedTicket;

/**
*The total price for the reservation or ticket, including applicable taxes, shipping, etc.

Usage guidelines:

Use values from 0123456789 (Unicode 'DIGIT ZERO' (U+0030) to 'DIGIT NINE' (U+0039)) rather than superficially similar Unicode symbols.
Use '.' (Unicode 'FULL STOP' (U+002E)) rather than ',' to indicate a decimal point. Avoid using these symbols as a readability separator.
*/
private BigDecimal totalPrice;

/**
*The person or organization the reservation or ticket is for.
*/
private Organization underName;

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