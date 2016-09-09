package model;
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
	private TextType AcceptedVariantsDescription;
	/**
	 * Other existing conditions.
	 */
	private TextType AdditionalConditions;
	/**
	 * A code signifying the awarding method in a tendering process (e.g., a method
	 * favoring the tender with the lowest price or the tender that is most
	 * economically advantageous).
	 */
	private CodeType AwardingMethodTypeCode;
	/**
	 * The amount to be paid to obtain the contract documents and additional
	 * documentation.
	 */
	private AmountType DocumentationFeeAmount;
	/**
	 * The Uniform Resource Identifier (URI) of an electronic registry of economic
	 * operators.
	 */
	private IdentifierType EconomicOperatorRegistryURIID;
	/**
	 * The program that funds the tendering process (e.g., EU 6th Framework Program)
	 * expressed as text.
	 */
	private TextType FundingProgram;
	/**
	 * The program that funds the tendering process (e.g., "National", "European"),
	 * expressed as a code.
	 */
	private CodeType FundingProgramCode;
	/**
	 * The end date until which the candidates can obtain the necessary level of
	 * security clearance.
	 */
	private DateType LatestSecurityClearanceDate;
	/**
	 * The maximum advertised monetary value of the tendering process.
	 */
	private AmountType MaximumAdvertisementAmount;
	/**
	 * Maximum number of variants the tenderer is allowed to present for this
	 * tendering project.
	 */
	private QuantityType MaximumVariantQuantity;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType Note;
	/**
	 * Indicates whether other conditions exist (true) or not (false). If the
	 * indicator is true, the description may be provided.
	 */
	private IndicatorType OtherConditionsIndicator;
	/**
	 * A code signifying the frequency of payment in the contract associated with the
	 * tendering process.
	 */
	private CodeType PaymentFrequencyCode;
	/**
	 * Textual description of the legal form required for potential tenderers.
	 */
	private CodeType PriceEvaluationCode;
	/**
	 * Text describing the formula for price revision.
	 */
	private TextType PriceRevisionFormulaDescription;
	/**
	 * An indicator that tenderers are required to provide a curriculum vitae for each
	 * participant in the project (true) or are not so required (false).
	 */
	private IndicatorType RequiredCurriculaIndicator;
	/**
	 * An indicator that variants are allowed and unconstrained in number (true) or
	 * not allowed (false).
	 */
	private IndicatorType VariantConstraintIndicator;
	private List<AppealTermsModel> AppealTermses = new ArrayList<>();
	private List<AwardingTermsModel> AwardingTermses = new ArrayList<>();
	private List<BudgetAccountModel> LineBudgetAccountLines = new ArrayList<>();
	private ClauseModel PenaltyClause;
	private List<ContractExecutionRequirementModel> ContractExecutionRequirements = new ArrayList<>();
	private DocumentReferenceModel EnvironmentalLegislationDocumentReference;
	private DocumentReferenceModel ProcurementLegislationDocumentReference;
	private DocumentReferenceModel FiscalLegislationDocumentReference;
	private DocumentReferenceModel ContractualDocumentReference;
	private DocumentReferenceModel CallForTendersDocumentReference;
	private DocumentReferenceModel EmploymentLegislationDocumentReference;
	private DocumentReferenceModel ReplacedNoticeDocumentReference;
	private FinancialGuaranteeModel RequiredFinancialGuarantee;
	private List<LanguageModel> Languages = new ArrayList<>();
	private PartyModel TenderEvaluationParty;
	private PartyModel ContractResponsibleParty;
	private PartyModel TenderRecipientParty;
	private PartyModel DocumentProviderParty;
	private PartyModel AdditionalInformationParty;
	private List<PaymentTermsModel> PaymentTermses = new ArrayList<>();
	private PeriodModel WarrantyValidityPeriod;
	private PeriodModel TenderValidityPeriod;
	private PeriodModel ContractAcceptancePeriod;
	private SubcontractTermsModel AllowedSubcontractTerms;
	private List<TenderPreparationModel> TenderPreparations = new ArrayList<>();
	private List<TendererQualificationRequestModel> TendererQualificationRequests = new ArrayList<>();

}
