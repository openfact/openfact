package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A class to describe tendering terms for a tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:29 a. m.
 */
public class TenderingTerms {

    /**
     * Text specifying the things for which variants are accepted.
     */
    private String acceptedVariantsDescription;
    /**
     * Other existing conditions.
     */
    private String additionalConditions;
    /**
     * A code signifying the awarding method in a tendering process (e.g., a
     * method favoring the tender with the lowest price or the tender that is
     * most economically advantageous).
     */
    private String awardingMethodTypeCode;
    /**
     * The amount to be paid to obtain the contract documents and additional
     * documentation.
     */
    private BigDecimal documentationFeeAmount;
    /**
     * The Uniform Resource Identifier (URI) of an electronic registry of
     * economic operators.
     */
    private String economicOperatorRegistryURIID;
    /**
     * The program that funds the tendering process (e.g., EU 6th Framework
     * Program) expressed as text.
     */
    private String fundingProgram;
    /**
     * The program that funds the tendering process (e.g., "National",
     * "European"), expressed as a code.
     */
    private String fundingProgramCode;
    /**
     * The end date until which the candidates can obtain the necessary level of
     * security clearance.
     */
    private LocalDate latestSecurityClearanceDate;
    /**
     * The maximum advertised monetary value of the tendering process.
     */
    private BigDecimal maximumAdvertisementAmount;
    /**
     * Maximum number of variants the tenderer is allowed to present for this
     * tendering project.
     */
    private BigDecimal maximumVariantQuantity;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private String note;
    /**
     * Indicates whether other conditions exist (true) or not (false). If the
     * indicator is true, the description may be provided.
     */
    private boolean otherConditionsIndicator;
    /**
     * A code signifying the frequency of payment in the contract associated
     * with the tendering process.
     */
    private String paymentFrequencyCode;
    /**
     * Textual description of the legal form required for potential tenderers.
     */
    private String priceEvaluationCode;
    /**
     * Text describing the formula for price revision.
     */
    private String priceRevisionFormulaDescription;
    /**
     * An indicator that tenderers are required to provide a curriculum vitae
     * for each participant in the project (true) or are not so required
     * (false).
     */
    private boolean requiredCurriculaIndicator;
    /**
     * An indicator that variants are allowed and unconstrained in number (true)
     * or not allowed (false).
     */
    private boolean variantConstraintIndicator;
    private List<AppealTerms> appealTerms = new ArrayList<>();
    private List<AwardingTerms> awardingTerms = new ArrayList<>();
    private List<BudgetAccountLine> budgetAccountLines = new ArrayList<>();
    private Clause penaltyClause;
    private List<ContractExecutionRequirement> contractExecutionRequirements = new ArrayList<>();
    private DocumentReference environmentalLegislationDocumentReference;
    private DocumentReference procurementLegislationDocumentReference;
    private DocumentReference fiscalLegislationDocumentReference;
    private DocumentReference contractualDocumentReference;
    private DocumentReference callForTendersDocumentReference;
    private DocumentReference employmentLegislationDocumentReference;
    private DocumentReference replacedNoticeDocumentReference;
    private FinancialGuarantee requiredFinancialGuarantee;
    private List<Language> languages = new ArrayList<>();
    private Party tenderEvaluationParty;
    private Party contractResponsibleParty;
    private Party tenderRecipientParty;
    private Party documentProviderParty;
    private Party additionalInformationParty;
    private List<PaymentTerms> paymentTerms = new ArrayList<>();
    private Period warrantyValidityPeriod;
    private Period tenderValidityPeriod;
    private Period contractAcceptancePeriod;
    private SubcontractTerms allowedSubcontractTerms;
    private List<TenderPreparation> tenderPreparations = new ArrayList<>();
    private List<TendererQualificationRequest> tendererQualificationRequests = new ArrayList<>();

    public String getAcceptedVariantsDescription() {
        return acceptedVariantsDescription;
    }

    public void setAcceptedVariantsDescription(String acceptedVariantsDescription) {
        this.acceptedVariantsDescription = acceptedVariantsDescription;
    }

    public String getAdditionalConditions() {
        return additionalConditions;
    }

    public void setAdditionalConditions(String additionalConditions) {
        this.additionalConditions = additionalConditions;
    }

    public String getAwardingMethodTypeCode() {
        return awardingMethodTypeCode;
    }

    public void setAwardingMethodTypeCode(String awardingMethodTypeCode) {
        this.awardingMethodTypeCode = awardingMethodTypeCode;
    }

    public BigDecimal getDocumentationFeeAmount() {
        return documentationFeeAmount;
    }

    public void setDocumentationFeeAmount(BigDecimal documentationFeeAmount) {
        this.documentationFeeAmount = documentationFeeAmount;
    }

    public String getEconomicOperatorRegistryURIID() {
        return economicOperatorRegistryURIID;
    }

    public void setEconomicOperatorRegistryURIID(String economicOperatorRegistryURIID) {
        this.economicOperatorRegistryURIID = economicOperatorRegistryURIID;
    }

    public String getFundingProgram() {
        return fundingProgram;
    }

    public void setFundingProgram(String fundingProgram) {
        this.fundingProgram = fundingProgram;
    }

    public String getFundingProgramCode() {
        return fundingProgramCode;
    }

    public void setFundingProgramCode(String fundingProgramCode) {
        this.fundingProgramCode = fundingProgramCode;
    }

    public LocalDate getLatestSecurityClearanceDate() {
        return latestSecurityClearanceDate;
    }

    public void setLatestSecurityClearanceDate(LocalDate latestSecurityClearanceDate) {
        this.latestSecurityClearanceDate = latestSecurityClearanceDate;
    }

    public BigDecimal getMaximumAdvertisementAmount() {
        return maximumAdvertisementAmount;
    }

    public void setMaximumAdvertisementAmount(BigDecimal maximumAdvertisementAmount) {
        this.maximumAdvertisementAmount = maximumAdvertisementAmount;
    }

    public BigDecimal getMaximumVariantQuantity() {
        return maximumVariantQuantity;
    }

    public void setMaximumVariantQuantity(BigDecimal maximumVariantQuantity) {
        this.maximumVariantQuantity = maximumVariantQuantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isOtherConditionsIndicator() {
        return otherConditionsIndicator;
    }

    public void setOtherConditionsIndicator(boolean otherConditionsIndicator) {
        this.otherConditionsIndicator = otherConditionsIndicator;
    }

    public String getPaymentFrequencyCode() {
        return paymentFrequencyCode;
    }

    public void setPaymentFrequencyCode(String paymentFrequencyCode) {
        this.paymentFrequencyCode = paymentFrequencyCode;
    }

    public String getPriceEvaluationCode() {
        return priceEvaluationCode;
    }

    public void setPriceEvaluationCode(String priceEvaluationCode) {
        this.priceEvaluationCode = priceEvaluationCode;
    }

    public String getPriceRevisionFormulaDescription() {
        return priceRevisionFormulaDescription;
    }

    public void setPriceRevisionFormulaDescription(String priceRevisionFormulaDescription) {
        this.priceRevisionFormulaDescription = priceRevisionFormulaDescription;
    }

    public boolean isRequiredCurriculaIndicator() {
        return requiredCurriculaIndicator;
    }

    public void setRequiredCurriculaIndicator(boolean requiredCurriculaIndicator) {
        this.requiredCurriculaIndicator = requiredCurriculaIndicator;
    }

    public boolean isVariantConstraintIndicator() {
        return variantConstraintIndicator;
    }

    public void setVariantConstraintIndicator(boolean variantConstraintIndicator) {
        this.variantConstraintIndicator = variantConstraintIndicator;
    }

    public List<AppealTerms> getAppealTerms() {
        return appealTerms;
    }

    public void setAppealTerms(List<AppealTerms> appealTerms) {
        this.appealTerms = appealTerms;
    }

    public List<AwardingTerms> getAwardingTerms() {
        return awardingTerms;
    }

    public void setAwardingTerms(List<AwardingTerms> awardingTerms) {
        this.awardingTerms = awardingTerms;
    }

    public List<BudgetAccountLine> getBudgetAccountLines() {
        return budgetAccountLines;
    }

    public void setBudgetAccountLines(List<BudgetAccountLine> budgetAccountLines) {
        this.budgetAccountLines = budgetAccountLines;
    }

    public Clause getPenaltyClause() {
        return penaltyClause;
    }

    public void setPenaltyClause(Clause penaltyClause) {
        this.penaltyClause = penaltyClause;
    }

    public List<ContractExecutionRequirement> getContractExecutionRequirements() {
        return contractExecutionRequirements;
    }

    public void setContractExecutionRequirements(List<ContractExecutionRequirement> contractExecutionRequirements) {
        this.contractExecutionRequirements = contractExecutionRequirements;
    }

    public DocumentReference getEnvironmentalLegislationDocumentReference() {
        return environmentalLegislationDocumentReference;
    }

    public void setEnvironmentalLegislationDocumentReference(DocumentReference environmentalLegislationDocumentReference) {
        this.environmentalLegislationDocumentReference = environmentalLegislationDocumentReference;
    }

    public DocumentReference getProcurementLegislationDocumentReference() {
        return procurementLegislationDocumentReference;
    }

    public void setProcurementLegislationDocumentReference(DocumentReference procurementLegislationDocumentReference) {
        this.procurementLegislationDocumentReference = procurementLegislationDocumentReference;
    }

    public DocumentReference getFiscalLegislationDocumentReference() {
        return fiscalLegislationDocumentReference;
    }

    public void setFiscalLegislationDocumentReference(DocumentReference fiscalLegislationDocumentReference) {
        this.fiscalLegislationDocumentReference = fiscalLegislationDocumentReference;
    }

    public DocumentReference getContractualDocumentReference() {
        return contractualDocumentReference;
    }

    public void setContractualDocumentReference(DocumentReference contractualDocumentReference) {
        this.contractualDocumentReference = contractualDocumentReference;
    }

    public DocumentReference getCallForTendersDocumentReference() {
        return callForTendersDocumentReference;
    }

    public void setCallForTendersDocumentReference(DocumentReference callForTendersDocumentReference) {
        this.callForTendersDocumentReference = callForTendersDocumentReference;
    }

    public DocumentReference getEmploymentLegislationDocumentReference() {
        return employmentLegislationDocumentReference;
    }

    public void setEmploymentLegislationDocumentReference(DocumentReference employmentLegislationDocumentReference) {
        this.employmentLegislationDocumentReference = employmentLegislationDocumentReference;
    }

    public DocumentReference getReplacedNoticeDocumentReference() {
        return replacedNoticeDocumentReference;
    }

    public void setReplacedNoticeDocumentReference(DocumentReference replacedNoticeDocumentReference) {
        this.replacedNoticeDocumentReference = replacedNoticeDocumentReference;
    }

    public FinancialGuarantee getRequiredFinancialGuarantee() {
        return requiredFinancialGuarantee;
    }

    public void setRequiredFinancialGuarantee(FinancialGuarantee requiredFinancialGuarantee) {
        this.requiredFinancialGuarantee = requiredFinancialGuarantee;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public Party getTenderEvaluationParty() {
        return tenderEvaluationParty;
    }

    public void setTenderEvaluationParty(Party tenderEvaluationParty) {
        this.tenderEvaluationParty = tenderEvaluationParty;
    }

    public Party getContractResponsibleParty() {
        return contractResponsibleParty;
    }

    public void setContractResponsibleParty(Party contractResponsibleParty) {
        this.contractResponsibleParty = contractResponsibleParty;
    }

    public Party getTenderRecipientParty() {
        return tenderRecipientParty;
    }

    public void setTenderRecipientParty(Party tenderRecipientParty) {
        this.tenderRecipientParty = tenderRecipientParty;
    }

    public Party getDocumentProviderParty() {
        return documentProviderParty;
    }

    public void setDocumentProviderParty(Party documentProviderParty) {
        this.documentProviderParty = documentProviderParty;
    }

    public Party getAdditionalInformationParty() {
        return additionalInformationParty;
    }

    public void setAdditionalInformationParty(Party additionalInformationParty) {
        this.additionalInformationParty = additionalInformationParty;
    }

    public List<PaymentTerms> getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(List<PaymentTerms> paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public Period getWarrantyValidityPeriod() {
        return warrantyValidityPeriod;
    }

    public void setWarrantyValidityPeriod(Period warrantyValidityPeriod) {
        this.warrantyValidityPeriod = warrantyValidityPeriod;
    }

    public Period getTenderValidityPeriod() {
        return tenderValidityPeriod;
    }

    public void setTenderValidityPeriod(Period tenderValidityPeriod) {
        this.tenderValidityPeriod = tenderValidityPeriod;
    }

    public Period getContractAcceptancePeriod() {
        return contractAcceptancePeriod;
    }

    public void setContractAcceptancePeriod(Period contractAcceptancePeriod) {
        this.contractAcceptancePeriod = contractAcceptancePeriod;
    }

    public SubcontractTerms getAllowedSubcontractTerms() {
        return allowedSubcontractTerms;
    }

    public void setAllowedSubcontractTerms(SubcontractTerms allowedSubcontractTerms) {
        this.allowedSubcontractTerms = allowedSubcontractTerms;
    }

    public List<TenderPreparation> getTenderPreparations() {
        return tenderPreparations;
    }

    public void setTenderPreparations(List<TenderPreparation> tenderPreparations) {
        this.tenderPreparations = tenderPreparations;
    }

    public List<TendererQualificationRequest> getTendererQualificationRequests() {
        return tendererQualificationRequests;
    }

    public void setTendererQualificationRequests(List<TendererQualificationRequest> tendererQualificationRequests) {
        this.tendererQualificationRequests = tendererQualificationRequests;
    }
}// end Tendering Terms