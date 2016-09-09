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
public class TenderingTerms{

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
	private List<AppealTerms> AppealTermses = new ArrayList<>();
	private List<AwardingTerms> AwardingTermses = new ArrayList<>();
	private List<BudgetAccount> LineBudgetAccountLines = new ArrayList<>();
	private Clause PenaltyClause;
	private List<ContractExecutionRequirement> ContractExecutionRequirements = new ArrayList<>();
	private DocumentReference EnvironmentalLegislationDocumentReference;
	private DocumentReference ProcurementLegislationDocumentReference;
	private DocumentReference FiscalLegislationDocumentReference;
	private DocumentReference ContractualDocumentReference;
	private DocumentReference CallForTendersDocumentReference;
	private DocumentReference EmploymentLegislationDocumentReference;
	private DocumentReference ReplacedNoticeDocumentReference;
	private FinancialGuarantee RequiredFinancialGuarantee;
	private List<Language> Languages = new ArrayList<>();
	private Party TenderEvaluationParty;
	private Party ContractResponsibleParty;
	private Party TenderRecipientParty;
	private Party DocumentProviderParty;
	private Party AdditionalInformationParty;
	private List<PaymentTerms> PaymentTermses = new ArrayList<>();
	private Period WarrantyValidityPeriod;
	private Period TenderValidityPeriod;
	private Period ContractAcceptancePeriod;
	private SubcontractTerms AllowedSubcontractTerms;
	private List<TenderPreparation> TenderPreparations = new ArrayList<>();
	private List<TendererQualificationRequest> TendererQualificationRequests = new ArrayList<>();

}
