package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * The evaluation that the Contracting Authority party requests to fulfill to
 * the tenderers.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:24 a. m.
 */
public class TendererQualificationRequest {

    /**
     * The legal status requested for potential tenderers, expressed as text
     */
    private String CompanyLegalForm;
    /**
     * The legal status requested for potential tenderers, expressed as a code.
     */
    private String CompanyLegalFormCode;
    /**
     * Text describing the evaluation requirements for this tenderer.
     */
    private String Description;
    /**
     * Textual description of the legal form required for potential tenderers.
     */
    private BigDecimal EmployeeQuantity;
    /**
     * Textual description of the legal form required for potential tenderers.
     */
    private BigDecimal OperatingYearsQuantity;
    /**
     * Text describing the personal situation of the economic operators in this
     * tendering process.
     */
    private String PersonalSituation;
    private ClassificationScheme RequiredBusinessClassificationScheme;
    private EconomicOperatorRole m_EconomicOperatorRole;
    private EvaluationCriterion TechnicalEvaluationCriterion;
    private TenderingTerms FinancialEvaluationCriterion;
    private TendererRequirement SpecificTendererRequirement;

    /**
     * @return the companyLegalForm
     */
    public String getCompanyLegalForm() {
        return CompanyLegalForm;
    }

    /**
     * @param companyLegalForm
     *            the companyLegalForm to set
     */
    public void setCompanyLegalForm(String companyLegalForm) {
        CompanyLegalForm = companyLegalForm;
    }

    /**
     * @return the companyLegalFormCode
     */
    public String getCompanyLegalFormCode() {
        return CompanyLegalFormCode;
    }

    /**
     * @param companyLegalFormCode
     *            the companyLegalFormCode to set
     */
    public void setCompanyLegalFormCode(String companyLegalFormCode) {
        CompanyLegalFormCode = companyLegalFormCode;
    }

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
     * @return the employeeQuantity
     */
    public BigDecimal getEmployeeQuantity() {
        return EmployeeQuantity;
    }

    /**
     * @param employeeQuantity
     *            the employeeQuantity to set
     */
    public void setEmployeeQuantity(BigDecimal employeeQuantity) {
        EmployeeQuantity = employeeQuantity;
    }

    /**
     * @return the operatingYearsQuantity
     */
    public BigDecimal getOperatingYearsQuantity() {
        return OperatingYearsQuantity;
    }

    /**
     * @param operatingYearsQuantity
     *            the operatingYearsQuantity to set
     */
    public void setOperatingYearsQuantity(BigDecimal operatingYearsQuantity) {
        OperatingYearsQuantity = operatingYearsQuantity;
    }

    /**
     * @return the personalSituation
     */
    public String getPersonalSituation() {
        return PersonalSituation;
    }

    /**
     * @param personalSituation
     *            the personalSituation to set
     */
    public void setPersonalSituation(String personalSituation) {
        PersonalSituation = personalSituation;
    }

    /**
     * @return the requiredBusinessClassificationScheme
     */
    public ClassificationScheme getRequiredBusinessClassificationScheme() {
        return RequiredBusinessClassificationScheme;
    }

    /**
     * @param requiredBusinessClassificationScheme
     *            the requiredBusinessClassificationScheme to set
     */
    public void setRequiredBusinessClassificationScheme(
            ClassificationScheme requiredBusinessClassificationScheme) {
        RequiredBusinessClassificationScheme = requiredBusinessClassificationScheme;
    }

    /**
     * @return the m_EconomicOperatorRole
     */
    public EconomicOperatorRole getM_EconomicOperatorRole() {
        return m_EconomicOperatorRole;
    }

    /**
     * @param m_EconomicOperatorRole
     *            the m_EconomicOperatorRole to set
     */
    public void setM_EconomicOperatorRole(EconomicOperatorRole m_EconomicOperatorRole) {
        this.m_EconomicOperatorRole = m_EconomicOperatorRole;
    }

    /**
     * @return the technicalEvaluationCriterion
     */
    public EvaluationCriterion getTechnicalEvaluationCriterion() {
        return TechnicalEvaluationCriterion;
    }

    /**
     * @param technicalEvaluationCriterion
     *            the technicalEvaluationCriterion to set
     */
    public void setTechnicalEvaluationCriterion(EvaluationCriterion technicalEvaluationCriterion) {
        TechnicalEvaluationCriterion = technicalEvaluationCriterion;
    }

    /**
     * @return the financialEvaluationCriterion
     */
    public TenderingTerms getFinancialEvaluationCriterion() {
        return FinancialEvaluationCriterion;
    }

    /**
     * @param financialEvaluationCriterion
     *            the financialEvaluationCriterion to set
     */
    public void setFinancialEvaluationCriterion(TenderingTerms financialEvaluationCriterion) {
        FinancialEvaluationCriterion = financialEvaluationCriterion;
    }

    /**
     * @return the specificTendererRequirement
     */
    public TendererRequirement getSpecificTendererRequirement() {
        return SpecificTendererRequirement;
    }

    /**
     * @param specificTendererRequirement
     *            the specificTendererRequirement to set
     */
    public void setSpecificTendererRequirement(TendererRequirement specificTendererRequirement) {
        SpecificTendererRequirement = specificTendererRequirement;
    }

}// end TendererQualificationRequest