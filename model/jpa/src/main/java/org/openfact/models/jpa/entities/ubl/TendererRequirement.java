package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe an action or statement required of an economic operator
 * participating in a tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:26 a. m.
 */
public class TendererRequirement {

    /**
     * Text describing this requirement.
     */
    private String Description;
    /**
     * The legal reference of the exclusion criterion.
     */
    private String LegalReference;
    /**
     * A name of this tenderer requirement.
     */
    private String Name;
    /**
     * A code signifying this requirement.
     */
    private String TendererRequirementTypeCode;
    private Evidence SuggestedEvidence;

    /**
     * @return the description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        Description = description;
    }

    /**
     * @return the legalReference
     */
    public String getLegalReference() {
        return LegalReference;
    }

    /**
     * @param legalReference
     *            the legalReference to set
     */
    public void setLegalReference(String legalReference) {
        LegalReference = legalReference;
    }

    /**
     * @return the name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * @return the tendererRequirementTypeCode
     */
    public String getTendererRequirementTypeCode() {
        return TendererRequirementTypeCode;
    }

    /**
     * @param tendererRequirementTypeCode
     *            the tendererRequirementTypeCode to set
     */
    public void setTendererRequirementTypeCode(String tendererRequirementTypeCode) {
        TendererRequirementTypeCode = tendererRequirementTypeCode;
    }

    /**
     * @return the suggestedEvidence
     */
    public Evidence getSuggestedEvidence() {
        return SuggestedEvidence;
    }

    /**
     * @param suggestedEvidence
     *            the suggestedEvidence to set
     */
    public void setSuggestedEvidence(Evidence suggestedEvidence) {
        SuggestedEvidence = suggestedEvidence;
    }

}// end TendererRequirement