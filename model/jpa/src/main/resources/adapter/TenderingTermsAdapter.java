package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe tendering terms for a tendering process.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:29 a. m.
 */
public class TenderingTermsAdapter{

	/**
	 * Text specifying the things for which variants are accepted.
	 */
	private TextType acceptedVariantsDescription; 
	/**
	 * Other existing conditions.
	 */
	private TextType additionalConditions; 
	/**
	 * A code signifying the awarding method in a tendering process (e.g., a method
	 * favoring the tender with the lowest price or the tender that is most
	 * economically advantageous).
	 */
	private CodeType awardingMethodTypeCode; 
	/**
	 * The amount to be paid to obtain the contract documents and additional
	 * documentation.
	 */
	private AmountType documentationFeeAmount; 
	/**
	 * The Uniform Resource Identifier (URI) of an electronic registry of economic
	 * operators.
	 */
	private IdentifierType economicOperatorRegistryURIID; 
	/**
	 * The program that funds the tendering process (e.g., EU 6th Framework Program)
	 * expressed as text.
	 */
	private TextType fundingProgram; 
	/**
	 * The program that funds the tendering process (e.g., "National", "European"),
	 * expressed as a code.
	 */
	private CodeType fundingProgramCode; 
	/**
	 * The end date until which the candidates can obtain the necessary level of
	 * security clearance.
	 */
	private DateType latestSecurityClearanceDate; 
	/**
	 * The maximum advertised monetary value of the tendering process.
	 */
	private AmountType maximumAdvertisementAmount; 
	/**
	 * Maximum number of variants the tenderer is allowed to present for this
	 * tendering project.
	 */
	private QuantityType maximumVariantQuantity; 
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType note; 
	/**
	 * Indicates whether other conditions exist (true) or not (false). If the
	 * indicator is true, the description may be provided.
	 */
	private IndicatorType otherConditionsIndicator; 
	/**
	 * A code signifying the frequency of payment in the contract associated with the
	 * tendering process.
	 */
	private CodeType paymentFrequencyCode; 
	/**
	 * Textual description of the legal form required for potential tenderers.
	 */
	private CodeType priceEvaluationCode; 
	/**
	 * Text describing the formula for price revision.
	 */
	private TextType priceRevisionFormulaDescription; 
	/**
	 * An indicator that tenderers are required to provide a curriculum vitae for each
	 * participant in the project (true) or are not so required (false).
	 */
	private IndicatorType requiredCurriculaIndicator; 
	/**
	 * An indicator that variants are allowed and unconstrained in number (true) or
	 * not allowed (false).
	 */
	private IndicatorType variantConstraintIndicator; 
	private List<AppealTermsAdapter> appealTermses = new ArrayList<>(); 
	private List<AwardingTermsAdapter> awardingTermses = new ArrayList<>(); 
	private List<BudgetAccountAdapter> lineBudgetAccountLines = new ArrayList<>(); 
	private ClauseAdapter penaltyClause; 
	private List<ContractExecutionRequirementAdapter> contractExecutionRequirements = new ArrayList<>(); 
	private DocumentReferenceAdapter environmentalLegislationDocumentReference; 
	private DocumentReferenceAdapter procurementLegislationDocumentReference; 
	private DocumentReferenceAdapter fiscalLegislationDocumentReference; 
	private DocumentReferenceAdapter contractualDocumentReference; 
	private DocumentReferenceAdapter callForTendersDocumentReference; 
	private DocumentReferenceAdapter employmentLegislationDocumentReference; 
	private DocumentReferenceAdapter replacedNoticeDocumentReference; 
	private FinancialGuaranteeAdapter requiredFinancialGuarantee; 
	private List<LanguageAdapter> languages = new ArrayList<>(); 
	private PartyAdapter tenderEvaluationParty; 
	private PartyAdapter contractResponsibleParty; 
	private PartyAdapter tenderRecipientParty; 
	private PartyAdapter documentProviderParty; 
	private PartyAdapter additionalInformationParty; 
	private List<PaymentTermsAdapter> paymentTermses = new ArrayList<>(); 
	private PeriodAdapter warrantyValidityPeriod; 
	private PeriodAdapter tenderValidityPeriod; 
	private PeriodAdapter contractAcceptancePeriod; 
	private SubcontractTermsAdapter allowedSubcontractTerms; 
	private List<TenderPreparationAdapter> tenderPreparations = new ArrayList<>(); 
	private List<TendererQualificationRequestAdapter> tendererQualificationRequests = new ArrayList<>(); 

}
