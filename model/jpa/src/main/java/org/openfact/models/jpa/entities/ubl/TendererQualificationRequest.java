package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

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
    private String companyLegalForm;
    /**
     * The legal status requested for potential tenderers, expressed as a code.
     */
    private String companyLegalFormCode;
    /**
     * Text describing the evaluation requirements for this tenderer.
     */
    private String description;
    /**
     * Textual description of the legal form required for potential tenderers.
     */
    private BigDecimal employeeQuantity;
    /**
     * Textual description of the legal form required for potential tenderers.
     */
    private BigDecimal operatingYearsQuantity;
    /**
     * Text describing the personal situation of the economic operators in this
     * tendering process.
     */
    private String personalSituation;
    private ClassificationScheme requiredBusinessClassificationScheme;
    private List<EconomicOperatorRole> economicOperatorRoles = new ArrayList<>();
    private EvaluationCriterion technicalEvaluationCriterion;
    private TenderingTerms financialEvaluationCriterion;
    private TendererRequirement specificTendererRequirement;

    public String getCompanyLegalForm() {
        return companyLegalForm;
    }

    public void setCompanyLegalForm(String companyLegalForm) {
        this.companyLegalForm = companyLegalForm;
    }

    public String getCompanyLegalFormCode() {
        return companyLegalFormCode;
    }

    public void setCompanyLegalFormCode(String companyLegalFormCode) {
        this.companyLegalFormCode = companyLegalFormCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getEmployeeQuantity() {
        return employeeQuantity;
    }

    public void setEmployeeQuantity(BigDecimal employeeQuantity) {
        this.employeeQuantity = employeeQuantity;
    }

    public BigDecimal getOperatingYearsQuantity() {
        return operatingYearsQuantity;
    }

    public void setOperatingYearsQuantity(BigDecimal operatingYearsQuantity) {
        this.operatingYearsQuantity = operatingYearsQuantity;
    }

    public String getPersonalSituation() {
        return personalSituation;
    }

    public void setPersonalSituation(String personalSituation) {
        this.personalSituation = personalSituation;
    }

    public ClassificationScheme getRequiredBusinessClassificationScheme() {
        return requiredBusinessClassificationScheme;
    }

    public void setRequiredBusinessClassificationScheme(ClassificationScheme requiredBusinessClassificationScheme) {
        this.requiredBusinessClassificationScheme = requiredBusinessClassificationScheme;
    }

    public List<EconomicOperatorRole> getEconomicOperatorRoles() {
        return economicOperatorRoles;
    }

    public void setEconomicOperatorRoles(List<EconomicOperatorRole> economicOperatorRoles) {
        this.economicOperatorRoles = economicOperatorRoles;
    }

    public EvaluationCriterion getTechnicalEvaluationCriterion() {
        return technicalEvaluationCriterion;
    }

    public void setTechnicalEvaluationCriterion(EvaluationCriterion technicalEvaluationCriterion) {
        this.technicalEvaluationCriterion = technicalEvaluationCriterion;
    }

    public TenderingTerms getFinancialEvaluationCriterion() {
        return financialEvaluationCriterion;
    }

    public void setFinancialEvaluationCriterion(TenderingTerms financialEvaluationCriterion) {
        this.financialEvaluationCriterion = financialEvaluationCriterion;
    }

    public TendererRequirement getSpecificTendererRequirement() {
        return specificTendererRequirement;
    }

    public void setSpecificTendererRequirement(TendererRequirement specificTendererRequirement) {
        this.specificTendererRequirement = specificTendererRequirement;
    }
}