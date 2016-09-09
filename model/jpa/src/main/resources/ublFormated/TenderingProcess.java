package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe the process of a formal offer and response to execute work
 * or supply goods at a stated price.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:27 a. m.
 */
public class TenderingProcess{

	/**
	 * An indicator that the number of candidates participating in this process has
	 * been reduced (true) or not (false).
	 */
	private IndicatorType CandidateReductionConstraintIndicator;
	/**
	 * A code signifying the type of contracting system (e.g., framework agreement,
	 * dynamic purchasing system). If the procedure is individual (nonrepetitive),
	 * this code should be omitted.
	 */
	private CodeType ContractingSystemCode;
	/**
	 * Text describing the tendering process.
	 */
	private TextType Description;
	/**
	 * A code signifying the type of expense for this tendering process.
	 */
	private CodeType ExpenseCode;
	/**
	 * An indicator that the project associated with this tendering process is
	 * constrained by a government procurement agreement (true) or not (false).
	 */
	private IndicatorType GovernmentAgreementConstraintIndicator;
	/**
	 * An identifier for this tendering process.
	 */
	private IdentifierType ID;
	/**
	 * Text describing the negotiation to be followed during the tendering process.
	 */
	private TextType NegotiationDescription;
	/**
	 * When reopening a tendering process, the identifier of the original framework
	 * agreement or dynamic purchasing system.
	 */
	private IdentifierType OriginalContractingSystemID;
	/**
	 * A code signifying the type of presentation of tenders required (e.g., one lot,
	 * multiple lots, or all the lots).
	 */
	private CodeType PartPresentationCode;
	/**
	 * A code signifying the type of this tendering procedure.
	 */
	private CodeType ProcedureCode;
	/**
	 * A code signifying the method to be followed in submitting tenders.
	 */
	private CodeType SubmissionMethodCode;
	/**
	 * A code signifying the urgency of this tendering process.
	 */
	private CodeType UrgencyCode;
	private List<AuctionTerms> AuctionTermses = new ArrayList<>();
	private DocumentReference NoticeDocumentReference;
	private DocumentReference AdditionalDocumentReference;
	private List<EconomicOperatorShortList> EconomicOperatorShortLists = new ArrayList<>();
	private Event OpenTenderEvent;
	private List<FrameworkAgreement> FrameworkAgreements = new ArrayList<>();
	private Period ParticipationRequestReceptionPeriod;
	private Period InvitationSubmissionPeriod;
	private Period TenderSubmissionDeadlinePeriod;
	private Period DocumentAvailabilityPeriod;
	private List<ProcessJustification> ProcessJustifications = new ArrayList<>();

}
