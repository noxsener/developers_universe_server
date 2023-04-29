package com.codenfast.developersuniverse.common.entity.schema;

import java.time.LocalDate;
import java.time.LocalDateTime;

@lombok.Data
@lombok.NoArgsConstructor
@lombok.EqualsAndHashCode(of = "id")
@lombok.ToString(of = "id")
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
// https://schema.org/JobPosting


/**A listing that describes a job opening in a certain organization.*/
public class JobPosting {
                        private String id;
            private Boolean passive = Boolean.FALSE;
            private LocalDateTime createTime = null;
            private LocalDateTime updateTime = null;


    /**
     * The location(s) applicants can apply from. This is usually used for telecommuting jobs where the applicant does not need to be in a physical office. Note: This should not be used for citizenship or work visa requirements.
     */
            private AdministrativeArea applicantLocationRequirements;

    /**
     * Contact details for further information relevant to this job posting.
     */
            private ContactPoint applicationContact;

    /**
     * The base salary of the job or of an employee in an EmployeeRole.
     */
            private MonetaryAmount baseSalary;

    /**
     * Publication date of an online listing.
     */
        private LocalDate datePosted;

    /**
     * Indicates whether an url that is associated with a JobPosting enables direct application for the job, via the posting website. A job posting is considered to have directApply of True if an application process for the specified job can be directly initiated via the url(s) given (noting that e.g. multiple internet domains might nevertheless be involved at an implementation level). A value of False is appropriate if there is no clear path to applying directly online for the specified job, navigating directly from the JobPosting url(s) supplied.
     */
            private Boolean directApply;

    /**
     * Educational background needed for the position or Occupation.
     */
            private EducationalOccupationalCredential educationRequirements;

    /**
     * The legal requirements such as citizenship, visa and other documentation required for an applicant to this job.
     */
        private String eligibilityToWorkRequirement;

    /**
     * A description of the employer, career opportunities and work environment for this position.
     */
        private String employerOverview;

    /**
     * Type of employment (e.g. full-time, part-time, contract, temporary, seasonal, internship).
     */
        private String employmentType;

    /**
     * Indicates the department, unit and/or facility where the employee reports and/or in which the job is to be performed.
     */
            private Organization employmentUnit;

    /**
     * An estimated salary for a job posting or occupation, based on a variety of variables including, but not limited to industry, job title, and location. Estimated salaries are often computed by outside organizations rather than the hiring organization, who may not have committed to the estimated value.
     */
            private MonetaryAmount estimatedSalary;

    /**
     * Indicates whether a JobPosting will accept experience (as indicated by OccupationalExperienceRequirements) in place of its formal educational qualifications (as indicated by educationRequirements). If true, indicates that satisfying one of these requirements is sufficient.
     */
            private Boolean experienceInPlaceOfEducation;

    /**
     * Description of skills and experience needed for the position or Occupation.
     */
            private OccupationalExperienceRequirements experienceRequirements;

    /**
     * Organization or Person offering the job position.
     */
            private Organization hiringOrganization;

    /**
     * Description of bonus and commission compensation aspects of the job. Supersedes incentives.
     */
        private String incentiveCompensation;

    /**
     * The industry associated with the job position.
     */
            private DefinedTerm industry;

    /**
     * Description of benefits associated with the job. Supersedes benefits.
     */
        private String jobBenefits;

    /**
     * An indicator as to whether a position is available for an immediate start.
     */
            private Boolean jobImmediateStart;

    /**
     * A (typically single) geographic location associated with the job position.
     */
            private Place jobLocation;

    /**
     * A description of the job location (e.g. TELECOMMUTE for telecommute jobs).
     */
        private String jobLocationType;

    /**
     * The date on which a successful applicant for this job would be expected to start work. Choose a specific date in the future or use the jobImmediateStart property to indicate the position is to be filled as soon as possible.
     */
        private LocalDate jobStartDate;

    /**
     * A category describing the job, preferably using a term from a taxonomy such as BLS O*NET-SOC, ISCO-08 or similar, with the property repeated for each applicable value. Ideally the taxonomy should be identified, and both the textual label and formal code for the category should be provided.
     * <p>
     * Note: for historical reasons, any textual label and formal code provided as a literal may be assumed to be from O*NET-SOC.
     */
            private CategoryCode occupationalCategory;

    /**
     * A description of the types of physical activity associated with the job. Defined terms such as those in O*net may be used, but note that there is no way to specify the level of ability as well as its nature when using a defined term.
     */
            private DefinedTerm physicalRequirement;

    /**
     * Specific qualifications required for this role or Occupation.
     */
            private EducationalOccupationalCredential qualifications;

    /**
     * The Occupation for the JobPosting.
     */
            private Occupation relevantOccupation;

    /**
     * Responsibilities associated with this role or Occupation.
     */
        private String responsibilities;

    /**
     * The currency (coded using ISO 4217) used for the main salary information in this job posting or for this employee.
     */
        private String salaryCurrency;

    /**
     * A description of any security clearance requirements of the job.
     */
        private String securityClearanceRequirement;

    /**
     * A description of any sensory requirements and levels necessary to function on the job, including hearing and vision. Defined terms such as those in O*net may be used, but note that there is no way to specify the level of ability as well as its nature when using a defined term.
     */
            private DefinedTerm sensoryRequirement;

    /**
     * A statement of knowledge, skill, ability, task or any other assertion expressing a competency that is desired or required to fulfill this role or to work in this occupation.
     */
            private DefinedTerm skills;

    /**
     * Any special commitments associated with this job posting. Valid entries include VeteranCommit, MilitarySpouseCommit, etc.
     */
        private String specialCommitments;

    /**
     * The title of the job.
     */
        private String title;

    /**
     * The number of positions open for this job posting. Use a positive integer. Do not use if the number of positions is unclear or not known.
     */
        private String totalJobOpenings;

    /**
     * The date after when the item is not valid. For example the end of an offer, salary period, or a period of opening hours.
     */
        private LocalDate validThrough;

    /**
     * The typical working hours for this job (e.g. 1st shift, night shift, 8am-5pm).
     */
        private String workHours;

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