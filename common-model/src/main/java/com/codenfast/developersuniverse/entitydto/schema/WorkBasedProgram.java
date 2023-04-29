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
// https://schema.org/WorkBasedProgram


/**A program with both an educational and employment component. Typically based at a workplace and structured around work-based learning, with the aim of instilling competencies related to an occupation. WorkBasedProgram is used to distinguish programs such as apprenticeships from school, college or other classroom based educational programs.*/
public class WorkBasedProgram implements EntityModel {
private String id;
private Boolean passive = Boolean.FALSE;
private LocalDateTime createTime = null;
private LocalDateTime updateTime = null;



/**
*A category describing the job, preferably using a term from a taxonomy such as BLS O*NET-SOC, ISCO-08 or similar, with the property repeated for each applicable value. Ideally the taxonomy should be identified, and both the textual label and formal code for the category should be provided.

Note: for historical reasons, any textual label and formal code provided as a literal may be assumed to be from O*NET-SOC.
*/
private CategoryCode occupationalCategory;

/**
*The estimated salary earned while in the program.
*/
private MonetaryAmountDistribution trainingSalary;

/**
*The date at which the program stops collecting applications for the next enrollment cycle.
*/
private LocalDate applicationDeadline;

/**
*The date at which the program begins collecting applications for the next enrollment cycle.
*/
private LocalDate applicationStartDate;

/**
*The day of the week for which these opening hours are valid.
*/
private DayOfWeek dayOfWeek;

/**
*A description of the qualification, award, certificate, diploma or other educational credential awarded as a consequence of successful completion of this course or program.
*/
private EducationalOccupationalCredential educationalCredentialAwarded;

/**
*Similar to courseMode, the medium or means of delivery of the program as a whole. The value may either be a text label (e.g. "online", "onsite" or "blended"; "synchronous" or "asynchronous"; "full-time" or "part-time") or a URL reference to a term from a controlled vocabulary (e.g. https://ceds.ed.gov/element/001311#Asynchronous ).
*/
private String educationalProgramMode;

/**
*The end date and time of the item (in ISO 8601 date format).
*/
private LocalDate endDate;

/**
*A financial aid type or program which students may use to pay for tuition or fees associated with the program.
*/
private DefinedTerm financialAidEligible;

/**
*A course or class that is one of the learning opportunities that constitute an educational / occupational program. No information is implied about whether the course is mandatory or optional; no guarantee is implied about whether the course will be available to everyone on the program.
*/
private Course hasCourse;

/**
*The maximum number of students who may be enrolled in the program.
*/
private String maximumEnrollment;

/**
*The number of credits or units awarded by a Course or required to complete an EducationalOccupationalProgram.
*/
private String numberOfCredits;

/**
*A category describing the job, preferably using a term from a taxonomy such as BLS O*NET-SOC, ISCO-08 or similar, with the property repeated for each applicable value. Ideally the taxonomy should be identified, and both the textual label and formal code for the category should be provided.

Note: for historical reasons, any textual label and formal code provided as a literal may be assumed to be from O*NET-SOC.
*/
/**
*A description of the qualification, award, certificate, diploma or other occupational credential awarded as a consequence of successful completion of this course or program.
*/
private EducationalOccupationalCredential occupationalCredentialAwarded;

/**
*An offer to provide this item—for example, an offer to sell a product, rent the DVD of a movie, perform a service, or give away tickets to an event. Use businessFunction to indicate the kind of transaction offered, i.e. sell, lease, etc. This property can also be used to describe a Demand. While this property is listed as expected on a number of common types, it can be used in others. In that case, using a second type, such as Product or a subtype of Product, can clarify the nature of the offer.
Inverse property: itemOffered
*/
private Demand offers;

/**
*Prerequisites for enrolling in the program.
*/
private AlignmentObject programPrerequisites;

/**
*The type of educational or occupational program. For example, classroom, internship, alternance, etc.
*/
private DefinedTerm programType;

/**
*The service provider, service operator, or service performer; the goods producer. Another party (a seller) may offer those services or goods on behalf of the provider. A provider may also serve as the seller. Supersedes carrier.
*/
private java.util.List<Organization> carrier;

/**
*The expected salary upon completing the training.
*/
private MonetaryAmountDistribution salaryUponCompletion;

/**
*The start date and time of the item (in ISO 8601 date format).
*/
private LocalDate startDate;

/**
*The amount of time in a term as defined by the institution. A term is a length of time where students take one or more classes. Semesters and quarters are common units for term.
*/
private Duration termDuration;

/**
*The number of times terms of study are offered per year. Semesters and quarters are common units for term. For example, if the student can only take 2 semesters for the program in one year, then termsPerYear should be 2.
*/
private BigDecimal termsPerYear;

/**
*The time of day the program normally runs. For example, "evenings".
*/
private String timeOfDay;

/**
*The expected length of time to complete the program if attending full-time.
*/
private Duration timeToComplete;

/**
*The estimated salary earned while in the program.
*/
/**
*The number of credits or units a full-time student would be expected to take in 1 term however 'term' is defined by the institution.
*/
private String typicalCreditsPerTerm;

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