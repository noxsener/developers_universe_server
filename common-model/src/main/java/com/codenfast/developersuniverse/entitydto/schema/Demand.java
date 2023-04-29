package com.codenfast.developersuniverse.entitydto.schema;

import com.codenfast.developersuniverse.EntityModel;

import java.time.LocalDate;
import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/Demand


/**A demand entity represents the public, not necessarily binding, not necessarily exclusive, announcement by an organization or person to seek a certain type of goods or services. For describing demand using this type, the very same properties used for Offer apply.*/
public class Demand implements EntityModel {
    private String id;
    private Boolean passive = Boolean.FALSE;
    private LocalDateTime createTime = null;
    private LocalDateTime updateTime = null;


    /**
     * The payment method(s) accepted by seller for this offer.
     */
    private LoanOrCredit acceptedPaymentMethod;

    /**
     * The amount of time that is required between accepting the offer and the actual usage of the resource or service.
     */
    private QuantitativeValue advanceBookingRequirement;

    /**
     * The geographic area where a service or offered item is provided. Supersedes serviceArea.
     */
    private java.util.List<AdministrativeArea> serviceArea;

    /**
     * An Amazon Standard Identification Number (ASIN) is a 10-character alphanumeric unique identifier assigned by Amazon.com and its partners for product identification within the Amazon organization (summary from Wikipedia's article).
     * <p>
     * Note also that this is a definition for how to include ASINs in Schema.org data, and not a definition of ASINs in general - see documentation from Amazon for authoritative details. ASINs are most commonly encoded as text strings, but the [asin] property supports URL/URI as potential values too.
     */
    private String asin;

    /**
     * The availability of this item—for example In stock, Out of stock, Pre-order, etc.
     */
    private ItemAvailability availability;

    /**
     * The end of the availability of the product or service included in the offer.
     */
    private LocalDate availabilityEnds;

    /**
     * The beginning of the availability of the product or service included in the offer.
     */
    private LocalDate availabilityStarts;

    /**
     * The place(s) from which the offer can be obtained (e.g. store locations).
     */
    private Place availableAtOrFrom;

    /**
     * The delivery method(s) available for this offer.
     */
    private DeliveryMethod availableDeliveryMethod;

    /**
     * The business function (e.g. sell, lease, repair, dispose) of the offer or component of a bundle (TypeAndQuantityNode). The default is http://purl.org/goodrelations/v1#Sell.
     */
    private BusinessFunction businessFunction;

    /**
     * The typical delay between the receipt of the order and the goods either leaving the warehouse or being prepared for pickup, in case the delivery method is on site pickup.
     */
    private QuantitativeValue deliveryLeadTime;

    /**
     * The type(s) of customers for which the given offer is valid.
     */
    private BusinessEntityType eligibleCustomerType;

    /**
     * The duration for which the given offer is valid.
     */
    private QuantitativeValue eligibleDuration;

    /**
     * The interval and unit of measurement of ordering quantities for which the offer or price specification is valid. This allows e.g. specifying that a certain freight charge is valid only for a certain quantity.
     */
    private QuantitativeValue eligibleQuantity;

    /**
     * The ISO 3166-1 (ISO 3166-1 alpha-2) or ISO 3166-2 code, the place, or the GeoShape for the geo-political region(s) for which the offer or delivery charge specification is valid.
     * <p>
     * See also ineligibleRegion.
     */
    private GeoShape eligibleRegion;

    /**
     * The transaction volume, in a monetary unit, for which the offer or price specification is valid, e.g. for indicating a minimal purchasing volume, to express free shipping above a certain order volume, or to limit the acceptance of credit cards to purchases to a certain minimal amount.
     */
    private PriceSpecification eligibleTransactionVolume;

    /**
     * A Global Trade Item Number (GTIN). GTINs identify trade items, including products and services, using numeric identification codes.
     * <p>
     * The GS1 digital link specifications express GTINs as URLs (URIs, IRIs, etc.). Details including regular expression examples can be found in, Section 6 of the GS1 URI Syntax specification; see also schema.org tracking issue for schema.org-specific discussion. A correct gtin value should be a valid GTIN, which means that it should be an all-numeric string of either 8, 12, 13 or 14 digits, or a "GS1 Digital Link" URL based on such a string. The numeric component should also have a valid GS1 check digit and meet the other rules for valid GTINs. See also GS1's GTIN Summary and Wikipedia for more details. Left-padding of the gtin values is not required or encouraged. The gtin property generalizes the earlier gtin8, gtin12, gtin13, and gtin14 properties.
     * <p>
     * Note also that this is a definition for how to include GTINs in Schema.org data, and not a definition of GTINs in general - see the GS1 documentation for authoritative details.
     */
    private String gtin;

    /**
     * The GTIN-12 code of the product, or the product to which the offer refers. The GTIN-12 is the 12-digit GS1 Identification Key composed of a U.P.C. Company Prefix, Item Reference, and Check Digit used to identify trade items. See GS1 GTIN Summary for more details.
     */
    private String gtin12;

    /**
     * The GTIN-13 code of the product, or the product to which the offer refers. This is equivalent to 13-digit ISBN codes and EAN UCC-13. Former 12-digit UPC codes can be converted into a GTIN-13 code by simply adding a preceding zero. See GS1 GTIN Summary for more details.
     */
    private String gtin13;

    /**
     * The GTIN-14 code of the product, or the product to which the offer refers. See GS1 GTIN Summary for more details.
     */
    private String gtin14;

    /**
     * The GTIN-8 code of the product, or the product to which the offer refers. This code is also known as EAN/UCC-8 or 8-digit EAN. See GS1 GTIN Summary for more details.
     */
    private String gtin8;

    /**
     * This links to a node or nodes indicating the exact quantity of the products included in an Offer or ProductCollection.
     */
    private TypeAndQuantityNode includesObject;

    /**
     * The ISO 3166-1 (ISO 3166-1 alpha-2) or ISO 3166-2 code, the place, or the GeoShape for the geo-political region(s) for which the offer or delivery charge specification is not valid, e.g. a region where the transaction is not allowed.
     * <p>
     * See also eligibleRegion.
     */
    private GeoShape ineligibleRegion;

    /**
     * The current approximate inventory level for the item or items.
     */
    private QuantitativeValue inventoryLevel;

    /**
     * A predefined value from OfferItemCondition specifying the condition of the product or service, or the products or services included in the offer. Also used for product return policies to specify the condition of products accepted for returns.
     */
    private OfferItemCondition itemCondition;

    /**
     * An item being offered (or demanded). The transactional nature of the offer or demand is documented using businessFunction, e.g. sell, lease etc. While several common expected types are listed explicitly in this definition, others can be used. Using a second type, such as Product or a subtype of Product, can clarify the nature of the offer.
     * Inverse property: offers
     */
    private AggregateOffer itemOffered;

    /**
     * The Manufacturer Part Number (MPN) of the product, or the product to which the offer refers.
     */
    private String mpn;

    /**
     * One or more detailed price specifications, indicating the unit price and delivery or payment charges.
     */
    private PriceSpecification priceSpecification;

    /**
     * An entity which offers (sells / leases / lends / loans) the services / goods. A seller may also be a provider. Supersedes merchant, vendor.
     */
    private java.util.List<Organization> vendor;

    /**
     * The serial number or any alphanumeric identifier of a particular product. When attached to an offer, it is a shortcut for the serial number of the product included in the offer.
     */
    private String serialNumber;

    /**
     * The Stock Keeping Unit (SKU), i.e. a merchant-specific identifier for a product or service, or the product to which the offer refers.
     */
    private String sku;

    /**
     * The date when the item becomes valid.
     */
    private LocalDate validFrom;

    /**
     * The date after when the item is not valid. For example the end of an offer, salary period, or a period of opening hours.
     */
    private LocalDate validThrough;

    /**
     * The warranty promise(s) included in the offer. Supersedes warrantyPromise.
     */
    private java.util.List<WarrantyPromise> warrantyPromise;

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