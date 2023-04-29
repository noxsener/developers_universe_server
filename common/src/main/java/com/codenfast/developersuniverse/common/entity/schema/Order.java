package com.codenfast.developersuniverse.common.entity.schema;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/Order


/**An order is a confirmation of a transaction (a receipt), which can contain multiple line items, each represented by an Offer that has been accepted by the customer.*/
public class Order {
                        private String id;
            private Boolean passive = Boolean.FALSE;
            private LocalDateTime createTime = null;
            private LocalDateTime updateTime = null;


    /**
     * The offer(s) -- e.g., product, quantity and price combinations -- included in the order.
     */
            private Offer acceptedOffer;

    /**
     * The billing address for the order.
     */
            private PostalAddress billingAddress;

    /**
     * An entity that arranges for an exchange between a buyer and a seller. In most cases a broker never acquires or releases ownership of a product or service involved in an exchange. If it is not clear whether an entity is a broker, seller, or buyer, the latter two terms are preferred. Supersedes bookingAgent.
     */
    private java.util.List<Organization> bookingAgent;

    /**
     * A number that confirms the given order or payment has been received.
     */
        private String confirmationNumber;

    /**
     * Party placing the order or paying the invoice.
     */
            private Organization customer;

    /**
     * Any discount applied (to an Order).
     */
        private BigDecimal discount;

    /**
     * Code used to redeem a discount.
     */
        private String discountCode;

    /**
     * The currency of the discount.
     * <p>
     * Use standard formats: ISO 4217 currency format, e.g. "USD"; Ticker symbol for cryptocurrencies, e.g. "BTC"; well known names for Local Exchange Trading Systems (LETS) and other currency types, e.g. "Ithaca HOUR".
     */
        private String discountCurrency;

    /**
     * Indicates whether the offer was accepted as a gift for someone other than the buyer.
     */
            private Boolean isGift;

    /**
     * Date order was placed.
     */
        private LocalDate orderDate;

    /**
     * The delivery of the parcel related to this order or order item.
     */
            private ParcelDelivery orderDelivery;

    /**
     * The identifier of the transaction.
     */
        private String orderNumber;

    /**
     * The current status of the order.
     */
            private OrderStatus orderStatus;

    /**
     * The item ordered.
     */
            private OrderItem orderedItem;

    /**
     * The order is being paid as part of the referenced Invoice.
     */
            private Invoice partOfInvoice;

    /**
     * The date that payment is due. Supersedes paymentDue.
     */
        private LocalDate paymentDueDate;

    /**
     * The name of the credit card or other method of payment for the order.
     */
            private PaymentMethod paymentMethod;

    /**
     * An identifier for the method of payment used (e.g. the last 4 digits of the credit card).
     */
        private String paymentMethodId;

    /**
     * The URL for sending a payment.
     */
        private String paymentUrl;

    /**
     * An entity which offers (sells / leases / lends / loans) the services / goods. A seller may also be a provider. Supersedes merchant, vendor.
     */
    private java.util.List<Organization> vendor;

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