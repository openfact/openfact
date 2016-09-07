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
	private String AcceptedVariantsDescription;
	/**
	 * Other existing conditions.
	 */
	private String AdditionalConditions;
	/**
	 * A code signifying the awarding method in a tendering process (e.g., a
	 * method favoring the tender with the lowest price or the tender that is
	 * most economically advantageous).
	 */
	private String AwardingMethodTypeCode;
	/**
	 * The amount to be paid to obtain the contract documents and additional
	 * documentation.
	 */
	private BigDecimal DocumentationFeeAmount;
	/**
	 * The Uniform Resource Identifier (URI) of an electronic registry of
	 * economic operators.
	 */
	private String EconomicOperatorRegistryURIID;
	/**
	 * The program that funds the tendering process (e.g., EU 6th Framework
	 * Program) expressed as text.
	 */
	private String FundingProgram;
	/**
	 * The program that funds the tendering process (e.g., "National",
	 * "European"), expressed as a code.
	 */
	private String FundingProgramCode;
	/**
	 * The end date until which the candidates can obtain the necessary level of
	 * security clearance.
	 */
	private LocalDate LatestSecurityClearanceDate;
	/**
	 * The maximum advertised monetary value of the tendering process.
	 */
	private BigDecimal MaximumAdvertisementAmount;
	/**
	 * Maximum number of variants the tenderer is allowed to present for this
	 * tendering project.
	 */
	private BigDecimal MaximumVariantQuantity;
	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	private String Note;
	/**
	 * Indicates whether other conditions exist (true) or not (false). If the
	 * indicator is true, the description may be provided.
	 */
	private boolean OtherConditionsIndicator;
	/**
	 * A code signifying the frequency of payment in the contract associated
	 * with the tendering process.
	 */
	private String PaymentFrequencyCode;
	/**
	 * Textual description of the legal form required for potential tenderers.
	 */
	private String PriceEvaluationCode;
	/**
	 * Text describing the formula for price revision.
	 */
	private String PriceRevisionFormulaDescription;
	/**
	 * An indicator that tenderers are required to provide a curriculum vitae
	 * for each participant in the project (true) or are not so required
	 * (false).
	 */
	private boolean RequiredCurriculaIndicator;
	/**
	 * An indicator that variants are allowed and unconstrained in number (true)
	 * or not allowed (false).
	 */
	private boolean VariantConstraintIndicator;
	private AppealTerms m_AppealTerms;
	private AwardingTerms m_AwardingTerms;
	private BudgetAccountLine m_BudgetAccountLine;
	private Clause PenaltyClause;
	private ContractExecutionRequirement m_ContractExecutionRequirement;
	private DocumentReference EnvironmentalLegislationDocumentReference;
	private DocumentReference ProcurementLegislationDocumentReference;
	private DocumentReference FiscalLegislationDocumentReference;
	private DocumentReference ContractualDocumentReference;
	private DocumentReference CallForTendersDocumentReference;
	private DocumentReference EmploymentLegislationDocumentReference;
	private DocumentReference ReplacedNoticeDocumentReference;
	private FinancialGuarantee RequiredFinancialGuarantee;
	private Language m_Language;
	private Party TenderEvaluationParty;
	private Party ContractResponsibleParty;
	private Party TenderRecipientParty;
	private Party DocumentProviderParty;
	private Party AdditionalInformationParty;
	private PaymentTerms m_PaymentTerms;
	private Period WarrantyValidityPeriod;
	private Period TenderValidityPeriod;
	private Period ContractAcceptancePeriod;
	private SubcontractTerms AllowedSubcontractTerms;
	private TenderPreparation m_TenderPreparation;
	private TendererQualificationRequest m_TendererQualificationRequest;

	/**
	 * @return the acceptedVariantsDescription
	 */
	public String getAcceptedVariantsDescription() {
		return AcceptedVariantsDescription;
	}

	/**
	 * @param acceptedVariantsDescription
	 *            the acceptedVariantsDescription to set
	 */
	public void setAcceptedVariantsDescription(String acceptedVariantsDescription) {
		AcceptedVariantsDescription = acceptedVariantsDescription;
	}

	/**
	 * @return the additionalConditions
	 */
	public String getAdditionalConditions() {
		return AdditionalConditions;
	}

	/**
	 * @param additionalConditions
	 *            the additionalConditions to set
	 */
	public void setAdditionalConditions(String additionalConditions) {
		AdditionalConditions = additionalConditions;
	}

	/**
	 * @return the awardingMethodTypeCode
	 */
	public String getAwardingMethodTypeCode() {
		return AwardingMethodTypeCode;
	}

	/**
	 * @param awardingMethodTypeCode
	 *            the awardingMethodTypeCode to set
	 */
	public void setAwardingMethodTypeCode(String awardingMethodTypeCode) {
		AwardingMethodTypeCode = awardingMethodTypeCode;
	}

	/**
	 * @return the documentationFeeAmount
	 */
	public BigDecimal getDocumentationFeeAmount() {
		return DocumentationFeeAmount;
	}

	/**
	 * @param documentationFeeAmount
	 *            the documentationFeeAmount to set
	 */
	public void setDocumentationFeeAmount(BigDecimal documentationFeeAmount) {
		DocumentationFeeAmount = documentationFeeAmount;
	}

	/**
	 * @return the economicOperatorRegistryURIID
	 */
	public String getEconomicOperatorRegistryURIID() {
		return EconomicOperatorRegistryURIID;
	}

	/**
	 * @param economicOperatorRegistryURIID
	 *            the economicOperatorRegistryURIID to set
	 */
	public void setEconomicOperatorRegistryURIID(String economicOperatorRegistryURIID) {
		EconomicOperatorRegistryURIID = economicOperatorRegistryURIID;
	}

	/**
	 * @return the fundingProgram
	 */
	public String getFundingProgram() {
		return FundingProgram;
	}

	/**
	 * @param fundingProgram
	 *            the fundingProgram to set
	 */
	public void setFundingProgram(String fundingProgram) {
		FundingProgram = fundingProgram;
	}

	/**
	 * @return the fundingProgramCode
	 */
	public String getFundingProgramCode() {
		return FundingProgramCode;
	}

	/**
	 * @param fundingProgramCode
	 *            the fundingProgramCode to set
	 */
	public void setFundingProgramCode(String fundingProgramCode) {
		FundingProgramCode = fundingProgramCode;
	}

	/**
	 * @return the latestSecurityClearanceDate
	 */
	public LocalDate getLatestSecurityClearanceDate() {
		return LatestSecurityClearanceDate;
	}

	/**
	 * @param latestSecurityClearanceDate
	 *            the latestSecurityClearanceDate to set
	 */
	public void setLatestSecurityClearanceDate(LocalDate latestSecurityClearanceDate) {
		LatestSecurityClearanceDate = latestSecurityClearanceDate;
	}

	/**
	 * @return the maximumAdvertisementAmount
	 */
	public BigDecimal getMaximumAdvertisementAmount() {
		return MaximumAdvertisementAmount;
	}

	/**
	 * @param maximumAdvertisementAmount
	 *            the maximumAdvertisementAmount to set
	 */
	public void setMaximumAdvertisementAmount(BigDecimal maximumAdvertisementAmount) {
		MaximumAdvertisementAmount = maximumAdvertisementAmount;
	}

	/**
	 * @return the maximumVariantQuantity
	 */
	public BigDecimal getMaximumVariantQuantity() {
		return MaximumVariantQuantity;
	}

	/**
	 * @param maximumVariantQuantity
	 *            the maximumVariantQuantity to set
	 */
	public void setMaximumVariantQuantity(BigDecimal maximumVariantQuantity) {
		MaximumVariantQuantity = maximumVariantQuantity;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return Note;
	}

	/**
	 * @param note
	 *            the note to set
	 */
	public void setNote(String note) {
		Note = note;
	}

	/**
	 * @return the otherConditionsIndicator
	 */
	public boolean isOtherConditionsIndicator() {
		return OtherConditionsIndicator;
	}

	/**
	 * @param otherConditionsIndicator
	 *            the otherConditionsIndicator to set
	 */
	public void setOtherConditionsIndicator(boolean otherConditionsIndicator) {
		OtherConditionsIndicator = otherConditionsIndicator;
	}

	/**
	 * @return the paymentFrequencyCode
	 */
	public String getPaymentFrequencyCode() {
		return PaymentFrequencyCode;
	}

	/**
	 * @param paymentFrequencyCode
	 *            the paymentFrequencyCode to set
	 */
	public void setPaymentFrequencyCode(String paymentFrequencyCode) {
		PaymentFrequencyCode = paymentFrequencyCode;
	}

	/**
	 * @return the priceEvaluationCode
	 */
	public String getPriceEvaluationCode() {
		return PriceEvaluationCode;
	}

	/**
	 * @param priceEvaluationCode
	 *            the priceEvaluationCode to set
	 */
	public void setPriceEvaluationCode(String priceEvaluationCode) {
		PriceEvaluationCode = priceEvaluationCode;
	}

	/**
	 * @return the priceRevisionFormulaDescription
	 */
	public String getPriceRevisionFormulaDescription() {
		return PriceRevisionFormulaDescription;
	}

	/**
	 * @param priceRevisionFormulaDescription
	 *            the priceRevisionFormulaDescription to set
	 */
	public void setPriceRevisionFormulaDescription(String priceRevisionFormulaDescription) {
		PriceRevisionFormulaDescription = priceRevisionFormulaDescription;
	}

	/**
	 * @return the requiredCurriculaIndicator
	 */
	public boolean isRequiredCurriculaIndicator() {
		return RequiredCurriculaIndicator;
	}

	/**
	 * @param requiredCurriculaIndicator
	 *            the requiredCurriculaIndicator to set
	 */
	public void setRequiredCurriculaIndicator(boolean requiredCurriculaIndicator) {
		RequiredCurriculaIndicator = requiredCurriculaIndicator;
	}

	/**
	 * @return the variantConstraintIndicator
	 */
	public boolean isVariantConstraintIndicator() {
		return VariantConstraintIndicator;
	}

	/**
	 * @param variantConstraintIndicator
	 *            the variantConstraintIndicator to set
	 */
	public void setVariantConstraintIndicator(boolean variantConstraintIndicator) {
		VariantConstraintIndicator = variantConstraintIndicator;
	}

	/**
	 * @return the m_AppealTerms
	 */
	public AppealTerms getM_AppealTerms() {
		return m_AppealTerms;
	}

	/**
	 * @param m_AppealTerms
	 *            the m_AppealTerms to set
	 */
	public void setM_AppealTerms(AppealTerms m_AppealTerms) {
		this.m_AppealTerms = m_AppealTerms;
	}

	/**
	 * @return the m_AwardingTerms
	 */
	public AwardingTerms getM_AwardingTerms() {
		return m_AwardingTerms;
	}

	/**
	 * @param m_AwardingTerms
	 *            the m_AwardingTerms to set
	 */
	public void setM_AwardingTerms(AwardingTerms m_AwardingTerms) {
		this.m_AwardingTerms = m_AwardingTerms;
	}

	/**
	 * @return the m_BudgetAccountLine
	 */
	public BudgetAccountLine getM_BudgetAccountLine() {
		return m_BudgetAccountLine;
	}

	/**
	 * @param m_BudgetAccountLine
	 *            the m_BudgetAccountLine to set
	 */
	public void setM_BudgetAccountLine(BudgetAccountLine m_BudgetAccountLine) {
		this.m_BudgetAccountLine = m_BudgetAccountLine;
	}

	/**
	 * @return the penaltyClause
	 */
	public Clause getPenaltyClause() {
		return PenaltyClause;
	}

	/**
	 * @param penaltyClause
	 *            the penaltyClause to set
	 */
	public void setPenaltyClause(Clause penaltyClause) {
		PenaltyClause = penaltyClause;
	}

	/**
	 * @return the m_ContractExecutionRequirement
	 */
	public ContractExecutionRequirement getM_ContractExecutionRequirement() {
		return m_ContractExecutionRequirement;
	}

	/**
	 * @param m_ContractExecutionRequirement
	 *            the m_ContractExecutionRequirement to set
	 */
	public void setM_ContractExecutionRequirement(ContractExecutionRequirement m_ContractExecutionRequirement) {
		this.m_ContractExecutionRequirement = m_ContractExecutionRequirement;
	}

	/**
	 * @return the environmentalLegislationDocumentReference
	 */
	public DocumentReference getEnvironmentalLegislationDocumentReference() {
		return EnvironmentalLegislationDocumentReference;
	}

	/**
	 * @param environmentalLegislationDocumentReference
	 *            the environmentalLegislationDocumentReference to set
	 */
	public void setEnvironmentalLegislationDocumentReference(
			DocumentReference environmentalLegislationDocumentReference) {
		EnvironmentalLegislationDocumentReference = environmentalLegislationDocumentReference;
	}

	/**
	 * @return the procurementLegislationDocumentReference
	 */
	public DocumentReference getProcurementLegislationDocumentReference() {
		return ProcurementLegislationDocumentReference;
	}

	/**
	 * @param procurementLegislationDocumentReference
	 *            the procurementLegislationDocumentReference to set
	 */
	public void setProcurementLegislationDocumentReference(DocumentReference procurementLegislationDocumentReference) {
		ProcurementLegislationDocumentReference = procurementLegislationDocumentReference;
	}

	/**
	 * @return the fiscalLegislationDocumentReference
	 */
	public DocumentReference getFiscalLegislationDocumentReference() {
		return FiscalLegislationDocumentReference;
	}

	/**
	 * @param fiscalLegislationDocumentReference
	 *            the fiscalLegislationDocumentReference to set
	 */
	public void setFiscalLegislationDocumentReference(DocumentReference fiscalLegislationDocumentReference) {
		FiscalLegislationDocumentReference = fiscalLegislationDocumentReference;
	}

	/**
	 * @return the contractualDocumentReference
	 */
	public DocumentReference getContractualDocumentReference() {
		return ContractualDocumentReference;
	}

	/**
	 * @param contractualDocumentReference
	 *            the contractualDocumentReference to set
	 */
	public void setContractualDocumentReference(DocumentReference contractualDocumentReference) {
		ContractualDocumentReference = contractualDocumentReference;
	}

	/**
	 * @return the callForTendersDocumentReference
	 */
	public DocumentReference getCallForTendersDocumentReference() {
		return CallForTendersDocumentReference;
	}

	/**
	 * @param callForTendersDocumentReference
	 *            the callForTendersDocumentReference to set
	 */
	public void setCallForTendersDocumentReference(DocumentReference callForTendersDocumentReference) {
		CallForTendersDocumentReference = callForTendersDocumentReference;
	}

	/**
	 * @return the employmentLegislationDocumentReference
	 */
	public DocumentReference getEmploymentLegislationDocumentReference() {
		return EmploymentLegislationDocumentReference;
	}

	/**
	 * @param employmentLegislationDocumentReference
	 *            the employmentLegislationDocumentReference to set
	 */
	public void setEmploymentLegislationDocumentReference(DocumentReference employmentLegislationDocumentReference) {
		EmploymentLegislationDocumentReference = employmentLegislationDocumentReference;
	}

	/**
	 * @return the replacedNoticeDocumentReference
	 */
	public DocumentReference getReplacedNoticeDocumentReference() {
		return ReplacedNoticeDocumentReference;
	}

	/**
	 * @param replacedNoticeDocumentReference
	 *            the replacedNoticeDocumentReference to set
	 */
	public void setReplacedNoticeDocumentReference(DocumentReference replacedNoticeDocumentReference) {
		ReplacedNoticeDocumentReference = replacedNoticeDocumentReference;
	}

	/**
	 * @return the requiredFinancialGuarantee
	 */
	public FinancialGuarantee getRequiredFinancialGuarantee() {
		return RequiredFinancialGuarantee;
	}

	/**
	 * @param requiredFinancialGuarantee
	 *            the requiredFinancialGuarantee to set
	 */
	public void setRequiredFinancialGuarantee(FinancialGuarantee requiredFinancialGuarantee) {
		RequiredFinancialGuarantee = requiredFinancialGuarantee;
	}

	/**
	 * @return the m_Language
	 */
	public Language getM_Language() {
		return m_Language;
	}

	/**
	 * @param m_Language
	 *            the m_Language to set
	 */
	public void setM_Language(Language m_Language) {
		this.m_Language = m_Language;
	}

	/**
	 * @return the tenderEvaluationParty
	 */
	public Party getTenderEvaluationParty() {
		return TenderEvaluationParty;
	}

	/**
	 * @param tenderEvaluationParty
	 *            the tenderEvaluationParty to set
	 */
	public void setTenderEvaluationParty(Party tenderEvaluationParty) {
		TenderEvaluationParty = tenderEvaluationParty;
	}

	/**
	 * @return the contractResponsibleParty
	 */
	public Party getContractResponsibleParty() {
		return ContractResponsibleParty;
	}

	/**
	 * @param contractResponsibleParty
	 *            the contractResponsibleParty to set
	 */
	public void setContractResponsibleParty(Party contractResponsibleParty) {
		ContractResponsibleParty = contractResponsibleParty;
	}

	/**
	 * @return the tenderRecipientParty
	 */
	public Party getTenderRecipientParty() {
		return TenderRecipientParty;
	}

	/**
	 * @param tenderRecipientParty
	 *            the tenderRecipientParty to set
	 */
	public void setTenderRecipientParty(Party tenderRecipientParty) {
		TenderRecipientParty = tenderRecipientParty;
	}

	/**
	 * @return the documentProviderParty
	 */
	public Party getDocumentProviderParty() {
		return DocumentProviderParty;
	}

	/**
	 * @param documentProviderParty
	 *            the documentProviderParty to set
	 */
	public void setDocumentProviderParty(Party documentProviderParty) {
		DocumentProviderParty = documentProviderParty;
	}

	/**
	 * @return the additionalInformationParty
	 */
	public Party getAdditionalInformationParty() {
		return AdditionalInformationParty;
	}

	/**
	 * @param additionalInformationParty
	 *            the additionalInformationParty to set
	 */
	public void setAdditionalInformationParty(Party additionalInformationParty) {
		AdditionalInformationParty = additionalInformationParty;
	}

	/**
	 * @return the m_PaymentTerms
	 */
	public PaymentTerms getM_PaymentTerms() {
		return m_PaymentTerms;
	}

	/**
	 * @param m_PaymentTerms
	 *            the m_PaymentTerms to set
	 */
	public void setM_PaymentTerms(PaymentTerms m_PaymentTerms) {
		this.m_PaymentTerms = m_PaymentTerms;
	}

	/**
	 * @return the warrantyValidityPeriod
	 */
	public Period getWarrantyValidityPeriod() {
		return WarrantyValidityPeriod;
	}

	/**
	 * @param warrantyValidityPeriod
	 *            the warrantyValidityPeriod to set
	 */
	public void setWarrantyValidityPeriod(Period warrantyValidityPeriod) {
		WarrantyValidityPeriod = warrantyValidityPeriod;
	}

	/**
	 * @return the tenderValidityPeriod
	 */
	public Period getTenderValidityPeriod() {
		return TenderValidityPeriod;
	}

	/**
	 * @param tenderValidityPeriod
	 *            the tenderValidityPeriod to set
	 */
	public void setTenderValidityPeriod(Period tenderValidityPeriod) {
		TenderValidityPeriod = tenderValidityPeriod;
	}

	/**
	 * @return the contractAcceptancePeriod
	 */
	public Period getContractAcceptancePeriod() {
		return ContractAcceptancePeriod;
	}

	/**
	 * @param contractAcceptancePeriod
	 *            the contractAcceptancePeriod to set
	 */
	public void setContractAcceptancePeriod(Period contractAcceptancePeriod) {
		ContractAcceptancePeriod = contractAcceptancePeriod;
	}

	/**
	 * @return the allowedSubcontractTerms
	 */
	public SubcontractTerms getAllowedSubcontractTerms() {
		return AllowedSubcontractTerms;
	}

	/**
	 * @param allowedSubcontractTerms
	 *            the allowedSubcontractTerms to set
	 */
	public void setAllowedSubcontractTerms(SubcontractTerms allowedSubcontractTerms) {
		AllowedSubcontractTerms = allowedSubcontractTerms;
	}

	/**
	 * @return the m_TenderPreparation
	 */
	public TenderPreparation getM_TenderPreparation() {
		return m_TenderPreparation;
	}

	/**
	 * @param m_TenderPreparation
	 *            the m_TenderPreparation to set
	 */
	public void setM_TenderPreparation(TenderPreparation m_TenderPreparation) {
		this.m_TenderPreparation = m_TenderPreparation;
	}

	/**
	 * @return the m_TendererQualificationRequest
	 */
	public TendererQualificationRequest getM_TendererQualificationRequest() {
		return m_TendererQualificationRequest;
	}

	/**
	 * @param m_TendererQualificationRequest
	 *            the m_TendererQualificationRequest to set
	 */
	public void setM_TendererQualificationRequest(TendererQualificationRequest m_TendererQualificationRequest) {
		this.m_TendererQualificationRequest = m_TendererQualificationRequest;
	}

}// end Tendering Terms