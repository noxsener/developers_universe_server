package com.codenfast.developersuniverse.common.entity.schema;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/BusOrCoach


/**A bus (also omnibus or autobus) is a road vehicle designed to carry passengers. Coaches are luxury busses, usually in service for long distance travel.*/
public class BusOrCoach {
                        private String id;
            private Boolean passive = Boolean.FALSE;
            private LocalDateTime createTime = null;
            private LocalDateTime updateTime = null;


    /**
     * The ACRISS Car Classification Code is a code used by many car rental companies, for classifying vehicles. ACRISS stands for Association of Car Rental Industry Systems and Standards.
     */
        private String acrissCode;

    /**
     * The permitted total weight of cargo and installations (e.g. a roof rack) on top of the vehicle.
     * <p>
     * Typical unit code(s): KGM for kilogram, LBR for pound
     * <p>
     * Note 1: You can indicate additional information in the name of the QuantitativeValue node.
     * Note 2: You may also link to a QualitativeValue node that provides additional information using valueReference
     * Note 3: Note that you can use minValue and maxValue to indicate ranges.
     */
            private QuantitativeValue roofLoad;

    /**
     * The time needed to accelerate the vehicle from a given start velocity to a given target velocity.
     * <p>
     * Typical unit code(s): SEC for seconds
     * <p>
     * Note: There are unfortunately no standard unit codes for seconds/0..100 km/h or seconds/0..60 mph. Simply use "SEC" for seconds and indicate the velocities in the name of the QuantitativeValue, or use valueReference with a QuantitativeValue of 0..60 mph or 0..100 km/h to specify the reference speeds.
     */
            private QuantitativeValue accelerationTime;

    /**
     * Indicates the design and body style of the vehicle (e.g. station wagon, hatchback, etc.).
     */
            private QualitativeValue bodyType;

    /**
     * A callsign, as used in broadcasting and radio communications to identify people, radio and TV stations, or vehicles.
     */
        private String callSign;

    /**
     * The available volume for cargo or luggage. For automobiles, this is usually the trunk volume.
     * <p>
     * Typical unit code(s): LTR for liters, FTQ for cubic foot/feet
     * <p>
     * Note: You can use minValue and maxValue to indicate ranges.
     */
            private QuantitativeValue cargoVolume;

    /**
     * The date of the first registration of the vehicle with the respective public authorities.
     */
        private LocalDate dateVehicleFirstRegistered;

    /**
     * The drive wheel configuration, i.e. which roadwheels will receive torque from the vehicle's engine via the drivetrain.
     */
            private DriveWheelConfigurationValue driveWheelConfiguration;

    /**
     * The CO2 emissions in g/km. When used in combination with a QuantitativeValue, put "g/km" into the unitText property of that value, since there is no UN/CEFACT Common Code for "g/km".
     */
        private BigDecimal emissionsCO2;

    /**
     * The capacity of the fuel tank or in the case of electric cars, the battery. If there are multiple components for storage, this should indicate the total of all storage of the same type.
     * <p>
     * Typical unit code(s): LTR for liters, GLL of US gallons, GLI for UK / imperial gallons, AMH for ampere-hours (for electrical vehicles).
     */
            private QuantitativeValue fuelCapacity;

    /**
     * The amount of fuel consumed for traveling a particular distance or temporal duration with the given vehicle (e.g. liters per 100 km).
     * <p>
     * Note 1: There are unfortunately no standard unit codes for liters per 100 km. Use unitText to indicate the unit of measurement, e.g. L/100 km.
     * Note 2: There are two ways of indicating the fuel consumption, fuelConsumption (e.g. 8 liters per 100 km) and fuelEfficiency (e.g. 30 miles per gallon). They are reciprocal.
     * Note 3: Often, the absolute value is useful only when related to driving speed ("at 80 km/h") or usage pattern ("city traffic"). You can use valueReference to link the value for the fuel consumption to another value.
     */
            private QuantitativeValue fuelConsumption;

    /**
     * The distance traveled per unit of fuel used; most commonly miles per gallon (mpg) or kilometers per liter (km/L).
     * <p>
     * Note 1: There are unfortunately no standard unit codes for miles per gallon or kilometers per liter. Use unitText to indicate the unit of measurement, e.g. mpg or km/L.
     * Note 2: There are two ways of indicating the fuel consumption, fuelConsumption (e.g. 8 liters per 100 km) and fuelEfficiency (e.g. 30 miles per gallon). They are reciprocal.
     * Note 3: Often, the absolute value is useful only when related to driving speed ("at 80 km/h") or usage pattern ("city traffic"). You can use valueReference to link the value for the fuel economy to another value.
     */
            private QuantitativeValue fuelEfficiency;

    /**
     * The type of fuel suitable for the engine or engines of the vehicle. If the vehicle has only one engine, this property can be attached directly to the vehicle.
     */
            private QualitativeValue fuelType;

    /**
     * A textual description of known damages, both repaired and unrepaired.
     */
        private String knownVehicleDamages;

    /**
     * Indicates that the vehicle meets the respective emission standard.
     */
            private QualitativeValue meetsEmissionStandard;

    /**
     * The total distance travelled by the particular vehicle since its initial production, as read from its odometer.
     * <p>
     * Typical unit code(s): KMT for kilometers, SMI for statute miles
     */
            private QuantitativeValue mileageFromOdometer;

    /**
     * The release date of a vehicle model (often used to differentiate versions of the same make and model).
     */
        private LocalDate modelDate;

    /**
     * The number or type of airbags in the vehicle.
     */
        private BigDecimal numberOfAirbags;

    /**
     * The number of axles.
     * <p>
     * Typical unit code(s): C62
     */
        private BigDecimal numberOfAxles;

    /**
     * The number of doors.
     * <p>
     * Typical unit code(s): C62
     */
        private BigDecimal numberOfDoors;

    /**
     * The total number of forward gears available for the transmission system of the vehicle.
     * <p>
     * Typical unit code(s): C62
     */
        private BigDecimal numberOfForwardGears;

    /**
     * The number of owners of the vehicle, including the current one.
     * <p>
     * Typical unit code(s): C62
     */
        private BigDecimal numberOfPreviousOwners;

    /**
     * The permitted weight of passengers and cargo, EXCLUDING the weight of the empty vehicle.
     * <p>
     * Typical unit code(s): KGM for kilogram, LBR for pound
     * <p>
     * Note 1: Many databases specify the permitted TOTAL weight instead, which is the sum of weight and payload
     * Note 2: You can indicate additional information in the name of the QuantitativeValue node.
     * Note 3: You may also link to a QualitativeValue node that provides additional information using valueReference.
     * Note 4: Note that you can use minValue and maxValue to indicate ranges.
     */
            private QuantitativeValue payload;

    /**
     * The date of production of the item, e.g. vehicle.
     */
        private LocalDate productionDate;

    /**
     * The date the item, e.g. vehicle, was purchased by the current owner.
     */
        private LocalDate purchaseDate;

    /**
     * The number of persons that can be seated (e.g. in a vehicle), both in terms of the physical space available, and in terms of limitations set by law.
     * <p>
     * Typical unit code(s): C62 for persons
     */
        private BigDecimal seatingCapacity;

    /**
     * The speed range of the vehicle. If the vehicle is powered by an engine, the upper limit of the speed range (indicated by maxValue) should be the maximum speed achievable under regular conditions.
     * <p>
     * Typical unit code(s): KMH for km/h, HM for mile per hour (0.447 04 m/s), KNT for knot
     * <p>
     * Note 1: Use minValue and maxValue to indicate the range. Typically, the minimal value is zero. * Note 2: There are many different ways of measuring the speed range. You can link to information about how the given value has been determined using the valueReference property.
     */
            private QuantitativeValue speed;

    /**
     * The position of the steering wheel or similar device (mostly for cars).
     */
            private SteeringPositionValue steeringPosition;

    /**
     * The permitted vertical load (TWR) of a trailer attached to the vehicle. Also referred to as Tongue Load Rating (TLR) or Vertical Load Rating (VLR).
     * <p>
     * Typical unit code(s): KGM for kilogram, LBR for pound
     * <p>
     * Note 1: You can indicate additional information in the name of the QuantitativeValue node.
     * Note 2: You may also link to a QualitativeValue node that provides additional information using valueReference.
     * Note 3: Note that you can use minValue and maxValue to indicate ranges.
     */
            private QuantitativeValue tongueWeight;

    /**
     * The permitted weight of a trailer attached to the vehicle.
     * <p>
     * Typical unit code(s): KGM for kilogram, LBR for pound * Note 1: You can indicate additional information in the name of the QuantitativeValue node. * Note 2: You may also link to a QualitativeValue node that provides additional information using valueReference. * Note 3: Note that you can use minValue and maxValue to indicate ranges.
     */
            private QuantitativeValue trailerWeight;

    /**
     * A short text indicating the configuration of the vehicle, e.g. '5dr hatchback ST 2.5 MT 225 hp' or 'limited edition'.
     */
        private String vehicleConfiguration;

    /**
     * Information about the engine or engines of the vehicle.
     */
            private EngineSpecification vehicleEngine;

    /**
     * The Vehicle Identification Number (VIN) is a unique serial number used by the automotive industry to identify individual motor vehicles.
     */
        private String vehicleIdentificationNumber;

    /**
     * The color or color combination of the interior of the vehicle.
     */
        private String vehicleInteriorColor;

    /**
     * The type or material of the interior of the vehicle (e.g. synthetic fabric, leather, wood, etc.). While most interior types are characterized by the material used, an interior type can also be based on vehicle usage or target audience.
     */
        private String vehicleInteriorType;

    /**
     * The release date of a vehicle model (often used to differentiate versions of the same make and model).
     */
        private LocalDate vehicleModelDate;

    /**
     * The number of passengers that can be seated in the vehicle, both in terms of the physical space available, and in terms of limitations set by law.
     * <p>
     * Typical unit code(s): C62 for persons.
     */
        private BigDecimal vehicleSeatingCapacity;

    /**
     * Indicates whether the vehicle has been used for special purposes, like commercial rental, driving school, or as a taxi. The legislation in many countries requires this information to be revealed when offering a car for sale.
     */
            private CarUsageType vehicleSpecialUsage;

    /**
     * The type of component used for transmitting the power from a rotating power source to the wheels or other relevant component(s) ("gearbox" for cars).
     */
            private QualitativeValue vehicleTransmission;

    /**
     * The permitted total weight of the loaded vehicle, including passengers and cargo and the weight of the empty vehicle.
     * <p>
     * Typical unit code(s): KGM for kilogram, LBR for pound
     * <p>
     * Note 1: You can indicate additional information in the name of the QuantitativeValue node.
     * Note 2: You may also link to a QualitativeValue node that provides additional information using valueReference.
     * Note 3: Note that you can use minValue and maxValue to indicate ranges.
     */
            private QuantitativeValue weightTotal;

    /**
     * The distance between the centers of the front and rear wheels.
     * <p>
     * Typical unit code(s): CMT for centimeters, MTR for meters, INH for inches, FOT for foot/feet
     */
            private QuantitativeValue wheelbase;

    /**
     * A property-value pair representing an additional characteristic of the entity, e.g. a product feature or another characteristic for which there is no matching property in schema.org.
     * <p>
     * Note: Publishers should be aware that applications designed to use specific schema.org properties (e.g. https://schema.org/width, https://schema.org/color, https://schema.org/gtin13, ...) will typically expect such data to be provided using those properties, rather than using the generic property/value mechanism.
     */
            private PropertyValue additionalProperty;

    /**
     * The overall rating, based on a collection of reviews or ratings, of the item.
     */
            private AggregateRating aggregateRating;

    /**
     * An Amazon Standard Identification Number (ASIN) is a 10-character alphanumeric unique identifier assigned by Amazon.com and its partners for product identification within the Amazon organization (summary from Wikipedia's article).
     * <p>
     * Note also that this is a definition for how to include ASINs in Schema.org data, and not a definition of ASINs in general - see documentation from Amazon for authoritative details. ASINs are most commonly encoded as text strings, but the [asin] property supports URL/URI as potential values too.
     */
        private String asin;

    /**
     * An intended audience, i.e. a group for whom something was created. Supersedes serviceAudience.
     */
        private java.util.List<Audience> serviceAudience;

    /**
     * An award won by or for this item. Supersedes awards.
     */
        private String award;

    /**
     * The brand(s) associated with a product or service, or the brand(s) maintained by an organization or business person.
     */
            private Brand brand;

    /**
     * A category for the item. Greater signs or slashes can be used to informally indicate a category hierarchy.
     */
            private CategoryCode category;

    /**
     * The color of the product.
     */
        private String color;

    /**
     * The place where the product was assembled.
     */
        private String countryOfAssembly;

    /**
     * The place where the item (typically Product) was last processed and tested before importation.
     */
        private String countryOfLastProcessing;

    /**
     * The country of origin of something, including products as well as creative works such as movie and TV content.
     * <p>
     * In the case of TV and movie, this would be the country of the principle offices of the production company or individual responsible for the movie. For other kinds of CreativeWork it is difficult to provide fully general guidance, and properties such as contentLocation and locationCreated may be more applicable.
     * <p>
     * In the case of products, the country of origin of the product. The exact interpretation of this may vary by context and product type, and cannot be fully enumerated here.
     */
            private Country countryOfOrigin;

    /**
     * The depth of the item.
     */
            private Distance depth;

    /**
     * A Grant that directly or indirectly provide funding or sponsorship for this item. See also ownershipFundingInfo.
     * Inverse property: fundedItem
     */
            private Grant funding;

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
     * Used to tag an item to be intended or suitable for consumption or use by adults only.
     */
            private AdultOrientedEnumeration hasAdultConsideration;

    /**
     * Defines the energy efficiency Category (also known as "class" or "rating") for a product according to an international energy efficiency standard.
     */
            private EnergyConsumptionDetails hasEnergyConsumptionDetails;

    /**
     * A product measurement, for example the inseam of pants, the wheel size of a bicycle, or the gauge of a screw. Usually an exact measurement, but can also be a range of measurements for adjustable products, for example belts and ski bindings.
     */
            private QuantitativeValue hasMeasurement;

    /**
     * Specifies a MerchantReturnPolicy that may be applicable. Supersedes hasProductReturnPolicy.
     */
        private java.util.List<MerchantReturnPolicy> hasProductReturnPolicy;

    /**
     * The height of the item.
     */
            private Distance height;

    /**
     * Indicates the productGroupID for a ProductGroup that this product isVariantOf.
     */
        private String inProductGroupWithID;

    /**
     * A pointer to another product (or multiple products) for which this product is an accessory or spare part.
     */
            private Product isAccessoryOrSparePartFor;

    /**
     * A pointer to another product (or multiple products) for which this product is a consumable.
     */
            private Product isConsumableFor;

    /**
     * Indicates whether this content is family friendly.
     */
            private Boolean isFamilyFriendly;

    /**
     * A pointer to another, somehow related product (or multiple products).
     */
            private Product isRelatedTo;

    /**
     * A pointer to another, functionally similar product (or multiple products).
     */
            private Product isSimilarTo;

    /**
     * Indicates the kind of product that this is a variant of. In the case of ProductModel, this is a pointer (from a ProductModel) to a base product from which this product is a variant. It is safe to infer that the variant inherits all product features from the base model, unless defined locally. This is not transitive. In the case of a ProductGroup, the group description also serves as a template, representing a set of Products that vary on explicitly defined, specific dimensions only (so it defines both a set of variants, as well as which values distinguish amongst those variants). When used with ProductGroup, this property can apply to any Product included in the group.
     * Inverse property: hasVariant
     */
            private ProductGroup isVariantOf;

    /**
     * A predefined value from OfferItemCondition specifying the condition of the product or service, or the products or services included in the offer. Also used for product return policies to specify the condition of products accepted for returns.
     */
            private OfferItemCondition itemCondition;

    /**
     * Keywords or tags used to describe some item. Multiple textual entries in a keywords list are typically delimited by commas, or by repeating the property.
     */
            private DefinedTerm keywords;

    /**
     * An associated logo.
     */
            private ImageObject logo;

    /**
     * The manufacturer of the product.
     */
            private Organization manufacturer;

    /**
     * A material that something is made from, e.g. leather, wool, cotton, paper.
     */
            private Product material;

    /**
     * The mobileUrl property is provided for specific situations in which data consumers need to determine whether one of several provided URLs is a dedicated 'mobile site'.
     * <p>
     * To discourage over-use, and reflecting intial usecases, the property is expected only on Product and Offer, rather than Thing. The general trend in web technology is towards responsive design in which content can be flexibly adapted to a wide range of browsing environments. Pages and sites referenced with the long-established url property should ideally also be usable on a wide variety of devices, including mobile phones. In most cases, it would be pointless and counter productive to attempt to update all url markup to use mobileUrl for more mobile-oriented pages. The property is intended for the case when items (primarily Product and Offer) have extra URLs hosted on an additional "mobile site" alongside the main one. It should not be taken as an endorsement of this publication style.
     */
        private String mobileUrl;

    /**
     * The model of the product. Use with the URL of a ProductModel or a textual representation of the model identifier. The URL of the ProductModel can be from an external source. It is recommended to additionally provide strong product identifiers via the gtin8/gtin13/gtin14 and mpn properties.
     */
            private ProductModel model;

    /**
     * The Manufacturer Part Number (MPN) of the product, or the product to which the offer refers.
     */
        private String mpn;

    /**
     * Provides negative considerations regarding something, most typically in pro/con lists for reviews (alongside positiveNotes). For symmetry
     * <p>
     * In the case of a Review, the property describes the itemReviewed from the perspective of the review; in the case of a Product, the product itself is being described. Since product descriptions tend to emphasise positive claims, it may be relatively unusual to find negativeNotes used in this way. Nevertheless for the sake of symmetry, negativeNotes can be used on Product.
     * <p>
     * The property values can be expressed either as unstructured text (repeated as necessary), or if ordered, as a list (in which case the most negative is at the beginning of the list).
     */
            private ItemList negativeNotes;

    /**
     * Indicates the NATO stock number (nsn) of a Product.
     */
        private String nsn;

    /**
     * An offer to provide this item—for example, an offer to sell a product, rent the DVD of a movie, perform a service, or give away tickets to an event. Use businessFunction to indicate the kind of transaction offered, i.e. sell, lease, etc. This property can also be used to describe a Demand. While this property is listed as expected on a number of common types, it can be used in others. In that case, using a second type, such as Product or a subtype of Product, can clarify the nature of the offer.
     * Inverse property: itemOffered
     */
            private Demand offers;

    /**
     * A pattern that something has, for example 'polka dot', 'striped', 'Canadian flag'. Values are typically expressed as text, although links to controlled value schemes are also supported.
     */
            private DefinedTerm pattern;

    /**
     * Provides positive considerations regarding something, for example product highlights or (alongside negativeNotes) pro/con lists for reviews.
     * <p>
     * In the case of a Review, the property describes the itemReviewed from the perspective of the review; in the case of a Product, the product itself is being described.
     * <p>
     * The property values can be expressed either as unstructured text (repeated as necessary), or if ordered, as a list (in which case the most positive is at the beginning of the list).
     */
            private ItemList positiveNotes;

    /**
     * The product identifier, such as ISBN. For example: meta itemprop="productID" content="isbn:123-456-789".
     */
        private String productID;

/**
 *The date of production of the item, e.g. vehicle.
 */
/**
 *The date the item, e.g. vehicle, was purchased by the current owner.
 */
    /**
     * The release date of a product or product model. This can be used to distinguish the exact variant of a product.
     */
        private LocalDate releaseDate;

    /**
     * A review of the item. Supersedes reviews.
     */
        private java.util.List<Review> reviews;

    /**
     * A standardized size of a product or creative work, specified either through a simple textual string (for example 'XL', '32Wx34L'), a QuantitativeValue with a unitCode, or a comprehensive and structured SizeSpecification; in other cases, the width, height, depth and weight properties may be more applicable.
     */
            private DefinedTerm size;

    /**
     * The Stock Keeping Unit (SKU), i.e. a merchant-specific identifier for a product or service, or the product to which the offer refers.
     */
        private String sku;

    /**
     * A slogan or motto associated with the item.
     */
        private String slogan;

    /**
     * The weight of the product or person.
     */
            private QuantitativeValue weight;

    /**
     * The width of the item.
     */
            private Distance width;

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