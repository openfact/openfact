package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe the process of a formal offer and response to execute
 * work or supply goods at a stated price.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:27 a. m.
 */
public class TenderingProcessRepresentation {

    /**
     * An indicator that the number of candidates participating in this process
     * has been reduced (true) or not (false).
     */
    private boolean candidateReductionConstraintIndicator;
    /**
     * A code signifying the type of contracting system (e.g., framework
     * agreement, dynamic purchasing system). If the procedure is individual
     * (nonrepetitive), this code should be omitted.
     */
    private CodeRepresentation contractingSystemCode;
    /**
     * Text describing the tendering process.
     */
    private TextRepresentation description;
    /**
     * A code signifying the type of expense for this tendering process.
     */
    private CodeRepresentation expenseCode;
    /**
     * An indicator that the project associated with this tendering process is
     * constrained by a government procurement agreement (true) or not (false).
     */
    private boolean governmentAgreementConstraintIndicator;
    /**
     * An identifier for this tendering process.
     */
    private IdentifierRepresentation ID;
    /**
     * Text describing the negotiation to be followed during the tendering
     * process.
     */
    private TextRepresentation negotiationDescription;
    /**
     * When reopening a tendering process, the identifier of the original
     * framework agreement or dynamic purchasing system.
     */
    private IdentifierRepresentation originalContractingSystemID;
    /**
     * A code signifying the type of presentation of tenders required (e.g., one
     * lot, multiple lots, or all the lots).
     */
    private CodeRepresentation partPresentationCode;
    /**
     * A code signifying the type of this tendering procedure.
     */
    private CodeRepresentation procedureCode;
    /**
     * A code signifying the method to be followed in submitting tenders.
     */
    private CodeRepresentation submissionMethodCode;
    /**
     * A code signifying the urgency of this tendering process.
     */
    private CodeRepresentation urgencyCode;
    private List<AuctionTermsRepresentation> auctionTermses = new ArrayList<>();
    private DocumentReferenceRepresentation noticeDocumentReference;
    private DocumentReferenceRepresentation additionalDocumentReference;
    private List<EconomicOperatorShortListRepresentation> economicOperatorShortLists = new ArrayList<>();
    private EventRepresentation openTenderEvent;
    private List<FrameworkAgreementRepresentation> frameworkAgreements = new ArrayList<>();
    private PeriodRepresentation participationRequestReceptionPeriod;
    private PeriodRepresentation invitationSubmissionPeriod;
    private PeriodRepresentation tenderSubmissionDeadlinePeriod;
    private PeriodRepresentation documentAvailabilityPeriod;
    private List<ProcessJustificationRepresentation> processJustifications = new ArrayList<>();

}
