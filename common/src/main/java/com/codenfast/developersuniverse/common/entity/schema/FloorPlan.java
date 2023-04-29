package com.codenfast.developersuniverse.common.entity.schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/FloorPlan


/**A FloorPlan is an explicit representation of a collection of similar accommodations, allowing the provision of common information (room counts, sizes, layout diagrams) and offers for rental or sale. In typical use, some ApartmentComplex has an accommodationFloorPlan which is a FloorPlan. A FloorPlan is always in the context of a particular place, either a larger ApartmentComplex or a single Apartment. The visual/spatial aspects of a floor plan (i.e. room layout, see wikipedia) can be indicated using image.*/
public class FloorPlan {
                        private String id;
            private Boolean passive = Boolean.FALSE;
            private LocalDateTime createTime = null;
            private LocalDateTime updateTime = null;


    /**
     * An amenity feature (e.g. a characteristic or service) of the Accommodation. This generic property does not make a statement about whether the feature is included in an offer for the main accommodation or available at extra costs.
     */
            private LocationFeatureSpecification amenityFeature;

    /**
     * The size of the accommodation, e.g. in square meter or squarefoot. Typical unit code(s): MTK for square meter, FTK for square foot, or YDK for square yard
     */
            private QuantitativeValue floorSize;

    /**
     * Indicates some accommodation that this floor plan describes.
     */
            private Accommodation isPlanForApartment;

    /**
     * A schematic image showing the floorplan layout.
     */
            private ImageObject layoutImage;

    /**
     * Indicates the total (available plus unavailable) number of accommodation units in an ApartmentComplex, or the number of accommodation units for a specific FloorPlan (within its specific ApartmentComplex). See also numberOfAvailableAccommodationUnits.
     */
            private QuantitativeValue numberOfAccommodationUnits;

    /**
     * Indicates the number of available accommodation units in an ApartmentComplex, or the number of accommodation units for a specific FloorPlan (within its specific ApartmentComplex). See also numberOfAccommodationUnits.
     */
            private QuantitativeValue numberOfAvailableAccommodationUnits;

    /**
     * The total integer number of bathrooms in some Accommodation, following real estate conventions as documented in RESO: "The simple sum of the number of bathrooms. For example for a property with two Full Bathrooms and one Half Bathroom, the Bathrooms Total Integer will be 3.". See also numberOfRooms.
     */
        private String numberOfBathroomsTotal;

    /**
     * The total integer number of bedrooms in a some Accommodation, ApartmentComplex or FloorPlan.
     */
        private BigDecimal numberOfBedrooms;

    /**
     * Number of full bathrooms - The total number of full and ¾ bathrooms in an Accommodation. This corresponds to the BathroomsFull field in RESO.
     */
        private BigDecimal numberOfFullBathrooms;

    /**
     * Number of partial bathrooms - The total number of half and ¼ bathrooms in an Accommodation. This corresponds to the BathroomsPartial field in RESO.
     */
        private BigDecimal numberOfPartialBathrooms;

    /**
     * The number of rooms (excluding bathrooms and closets) of the accommodation or lodging business. Typical unit code(s): ROM for room or C62 for no unit. The type of room can be put in the unitText property of the QuantitativeValue.
     */
        private BigDecimal numberOfRooms;

    /**
     * Indicates whether pets are allowed to enter the accommodation or lodging business. More detailed information can be put in a text value.
     */
            private Boolean petsAllowed;

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