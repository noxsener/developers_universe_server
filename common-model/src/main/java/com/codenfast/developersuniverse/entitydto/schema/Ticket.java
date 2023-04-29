package com.codenfast.developersuniverse.entitydto.schema;

import com.codenfast.developersuniverse.EntityModel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/Ticket


/**Used to describe a ticket to an event, a flight, a bus ride, etc.*/
public class Ticket implements EntityModel {
    private String id;
    private Boolean passive = Boolean.FALSE;
    private LocalDateTime createTime = null;
    private LocalDateTime updateTime = null;


    /**
     * The date the ticket was issued.
     */
    private LocalDate dateIssued;

    /**
     * The organization issuing the ticket or permit.
     */
    private Organization issuedBy;

    /**
     * The currency of the price, or a price component when attached to PriceSpecification and its subtypes.
     * <p>
     * Use standard formats: ISO 4217 currency format, e.g. "USD"; Ticker symbol for cryptocurrencies, e.g. "BTC"; well known names for Local Exchange Trading Systems (LETS) and other currency types, e.g. "Ithaca HOUR".
     */
    private String priceCurrency;

    /**
     * The unique identifier for the ticket.
     */
    private String ticketNumber;

    /**
     * Reference to an asset (e.g., Barcode, QR code image or PDF) usable for entrance.
     */
    private String ticketToken;

    /**
     * The seat associated with the ticket.
     */
    private Seat ticketedSeat;

    /**
     * The total price for the reservation or ticket, including applicable taxes, shipping, etc.
     * <p>
     * Usage guidelines:
     * <p>
     * Use values from 0123456789 (Unicode 'DIGIT ZERO' (U+0030) to 'DIGIT NINE' (U+0039)) rather than superficially similar Unicode symbols.
     * Use '.' (Unicode 'FULL STOP' (U+002E)) rather than ',' to indicate a decimal point. Avoid using these symbols as a readability separator.
     */
    private BigDecimal totalPrice;

    /**
     * The person or organization the reservation or ticket is for.
     */
    private Organization underName;

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

}