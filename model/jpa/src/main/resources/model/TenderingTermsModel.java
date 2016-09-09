package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe tendering terms for a tendering process.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:29 a. m.
 */
public class TenderingTermsModel{

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
	private BigDecimal documentationFeeAmount; 
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
	private LocalDate latestSecurityClearanceDate; 
	/**
	 * The maximum advertised monetary value of the tendering process.
	 */
	private BigDecimal maximumAdvertisementAmount; 
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
	private boolean otherConditionsIndicator; 
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
	private boolean requiredCurriculaIndicator; 
	/**
	 * An indicator that variants are allowed and unconstrained in number (true) or
	 * not allowed (false).
	 */
	private boolean variantConstraintIndicator; 
	private List<AppealTermsModel> appealTermses = new ArrayList<>(); 
	private List<AwardingTermsModel> awardingTermses = new ArrayList<>(); 
	private List<BudgetAccountModel> lineBudgetAccountLines = new ArrayList<>(); 
	private ClauseModel penaltyClause; 
	private List<ContractExecutionRequirementModel> contractExecutionRequirements = new ArrayList<>(); 
	private DocumentReferenceModel environmentalLegislationDocumentReference; 
	private DocumentReferenceModel procurementLegislationDocumentReference; 
	private DocumentReferenceModel fiscalLegislationDocumentReference; 
	private DocumentReferenceModel contractualDocumentReference; 
	private DocumentReferenceModel callForTendersDocumentReference; 
	private DocumentReferenceModel employmentLegislationDocumentReference; 
	private DocumentReferenceModel replacedNoticeDocumentReference; 
	private FinancialGuaranteeModel requiredFinancialGuarantee; 
	private List<LanguageModel> languages = new ArrayList<>(); 
	private PartyModel tenderEvaluationParty; 
	private PartyModel contractResponsibleParty; 
	private PartyModel tenderRecipientParty; 
	private PartyModel documentProviderParty; 
	private PartyModel additionalInformationParty; 
	private List<PaymentTermsModel> paymentTermses = new ArrayList<>(); 
	private PeriodModel warrantyValidityPeriod; 
	private PeriodModel tenderValidityPeriod; 
	private PeriodModel contractAcceptancePeriod; 
	private SubcontractTermsModel allowedSubcontractTerms; 
	private List<TenderPreparationModel> tenderPreparations = new ArrayList<>(); 
	private List<TendererQualificationRequestModel> tendererQualificationRequests = new ArrayList<>(); 

}
