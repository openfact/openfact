package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe tendering terms for a tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:29 a. m.
 */
public class TenderingTermsRepresentation {

    /**
     * Text specifying the things for which variants are accepted.
     */
    private TextRepresentation acceptedVariantsDescription;
    /**
     * Other existing conditions.
     */
    private TextRepresentation additionalConditions;
    /**
     * A code signifying the awarding method in a tendering process (e.g., a
     * method favoring the tender with the lowest price or the tender that is
     * most economically advantageous).
     */
    private CodeRepresentation awardingMethodTypeCode;
    /**
     * The amount to be paid to obtain the contract documents and additional
     * documentation.
     */
    private BigDecimal documentationFeeAmount;
    /**
     * The Uniform Resource Identifier (URI) of an electronic registry of
     * economic operators.
     */
    private IdentifierRepresentation economicOperatorRegistryURIID;
    /**
     * The program that funds the tendering process (e.g., EU 6th Framework
     * Program) expressed as text.
     */
    private TextRepresentation fundingProgram;
    /**
     * The program that funds the tendering process (e.g., "National",
     * "European"), expressed as a code.
     */
    private CodeRepresentation fundingProgramCode;
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
    private QuantityRepresentation maximumVariantQuantity;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextRepresentation note;
    /**
     * Indicates whether other conditions exist (true) or not (false). If the
     * indicator is true, the description may be provided.
     */
    private boolean otherConditionsIndicator;
    /**
     * A code signifying the frequency of payment in the contract associated
     * with the tendering process.
     */
    private CodeRepresentation paymentFrequencyCode;
    /**
     * Textual description of the legal form required for potential tenderers.
     */
    private CodeRepresentation priceEvaluationCode;
    /**
     * Text describing the formula for price revision.
     */
    private TextRepresentation priceRevisionFormulaDescription;
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
    private List<AppealTermsRepresentation> appealTermses = new ArrayList<>();
    private List<AwardingTermsRepresentation> awardingTermses = new ArrayList<>();
    private List<BudgetAccountRepresentation> lineBudgetAccountLines = new ArrayList<>();
    private ClauseRepresentation penaltyClause;
    private List<ContractExecutionRequirementRepresentation> contractExecutionRequirements = new ArrayList<>();
    private DocumentReferenceRepresentation environmentalLegislationDocumentReference;
    private DocumentReferenceRepresentation procurementLegislationDocumentReference;
    private DocumentReferenceRepresentation fiscalLegislationDocumentReference;
    private DocumentReferenceRepresentation contractualDocumentReference;
    private DocumentReferenceRepresentation callForTendersDocumentReference;
    private DocumentReferenceRepresentation employmentLegislationDocumentReference;
    private DocumentReferenceRepresentation replacedNoticeDocumentReference;
    private FinancialGuaranteeRepresentation requiredFinancialGuarantee;
    private List<LanguageRepresentation> languages = new ArrayList<>();
    private PartyRepresentation tenderEvaluationParty;
    private PartyRepresentation contractResponsibleParty;
    private PartyRepresentation tenderRecipientParty;
    private PartyRepresentation documentProviderParty;
    private PartyRepresentation additionalInformationParty;
    private List<PaymentTermsRepresentation> paymentTermses = new ArrayList<>();
    private PeriodRepresentation warrantyValidityPeriod;
    private PeriodRepresentation tenderValidityPeriod;
    private PeriodRepresentation contractAcceptancePeriod;
    private SubcontractTermsRepresentation allowedSubcontractTerms;
    private List<TenderPreparationRepresentation> tenderPreparations = new ArrayList<>();
    private List<TendererQualificationRequestRepresentation> tendererQualificationRequests = new ArrayList<>();

}
