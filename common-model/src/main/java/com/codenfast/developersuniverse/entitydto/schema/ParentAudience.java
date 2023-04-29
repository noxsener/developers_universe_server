package com.codenfast.developersuniverse.entitydto.schema;

import com.codenfast.developersuniverse.EntityModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/ParentAudience


/**A set of characteristics describing parents, who can be interested in viewing some content.*/
public class ParentAudience implements EntityModel {
private String id;
private Boolean passive = Boolean.FALSE;
private LocalDateTime createTime = null;
private LocalDateTime updateTime = null;



/**
*Maximal age of the child.
*/
private BigDecimal childMaxAge;

/**
*Minimal age of the child.
*/
private BigDecimal childMinAge;


/**
*Audiences defined by a person's gender.
*/
private String requiredGender;

/**
*Audiences defined by a person's maximum age.
*/
private String requiredMaxAge;

/**
*Audiences defined by a person's minimum age.
*/
private String requiredMinAge;

/**
*The age or age range for the intended audience or person, for example 3-12 months for infants, 1-5 years for toddlers.
*/
private QuantitativeValue suggestedAge;

/**
*The suggested gender of the intended person or audience, for example "male", "female", or "unisex".
*/
private GenderType suggestedGender;

/**
*Maximum recommended age in years for the audience or user.
*/
private BigDecimal suggestedMaxAge;

/**
*A suggested range of body measurements for the intended audience or person, for example inseam between 32 and 34 inches or height between 170 and 190 cm. Typically found on a size chart for wearable products.
*/
private QuantitativeValue suggestedMeasurement;

/**
*Minimum recommended age in years for the audience or user.
*/
private BigDecimal suggestedMinAge;

/**
*The target group associated with a given audience (e.g. veterans, car owners, musicians, etc.).
*/
private String audienceType;

/**
*The geographic area associated with the audience.
*/
private AdministrativeArea geographicArea;

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