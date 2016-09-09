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
public class TenderingProcessEntity{

	/**
	 * An indicator that the number of candidates participating in this process has
	 * been reduced (true) or not (false).
	 */
	private IndicatorType candidateReductionConstraintIndicator; 
	/**
	 * A code signifying the type of contracting system (e.g., framework agreement,
	 * dynamic purchasing system). If the procedure is individual (nonrepetitive),
	 * this code should be omitted.
	 */
	private CodeType contractingSystemCode; 
	/**
	 * Text describing the tendering process.
	 */
	private TextType description; 
	/**
	 * A code signifying the type of expense for this tendering process.
	 */
	private CodeType expenseCode; 
	/**
	 * An indicator that the project associated with this tendering process is
	 * constrained by a government procurement agreement (true) or not (false).
	 */
	private IndicatorType governmentAgreementConstraintIndicator; 
	/**
	 * An identifier for this tendering process.
	 */
	private IdentifierType ID; 
	/**
	 * Text describing the negotiation to be followed during the tendering process.
	 */
	private TextType negotiationDescription; 
	/**
	 * When reopening a tendering process, the identifier of the original framework
	 * agreement or dynamic purchasing system.
	 */
	private IdentifierType originalContractingSystemID; 
	/**
	 * A code signifying the type of presentation of tenders required (e.g., one lot,
	 * multiple lots, or all the lots).
	 */
	private CodeType partPresentationCode; 
	/**
	 * A code signifying the type of this tendering procedure.
	 */
	private CodeType procedureCode; 
	/**
	 * A code signifying the method to be followed in submitting tenders.
	 */
	private CodeType submissionMethodCode; 
	/**
	 * A code signifying the urgency of this tendering process.
	 */
	private CodeType urgencyCode; 
	private List<AuctionTermsEntity> auctionTermses = new ArrayList<>(); 
	private DocumentReferenceEntity noticeDocumentReference; 
	private DocumentReferenceEntity additionalDocumentReference; 
	private List<EconomicOperatorShortListEntity> economicOperatorShortLists = new ArrayList<>(); 
	private EventEntity openTenderEvent; 
	private List<FrameworkAgreementEntity> frameworkAgreements = new ArrayList<>(); 
	private PeriodEntity participationRequestReceptionPeriod; 
	private PeriodEntity invitationSubmissionPeriod; 
	private PeriodEntity tenderSubmissionDeadlinePeriod; 
	private PeriodEntity documentAvailabilityPeriod; 
	private List<ProcessJustificationEntity> processJustifications = new ArrayList<>(); 

}
