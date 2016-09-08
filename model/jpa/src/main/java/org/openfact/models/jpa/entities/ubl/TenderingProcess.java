package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe the process of a formal offer and response to execute
 * work or supply goods at a stated price.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:27 a. m.
 */
public class TenderingProcess {

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
    private String contractingSystemCode;
    /**
     * Text describing the tendering process.
     */
    private String description;
    /**
     * A code signifying the type of expense for this tendering process.
     */
    private String expenseCode;
    /**
     * An indicator that the project associated with this tendering process is
     * constrained by a government procurement agreement (true) or not (false).
     */
    private boolean governmentAgreementConstraintIndicator;
    /**
     * An identifier for this tendering process.
     */
    private String id;
    /**
     * Text describing the negotiation to be followed during the tendering
     * process.
     */
    private String negotiationDescription;
    /**
     * When reopening a tendering process, the identifier of the original
     * framework agreement or dynamic purchasing system.
     */
    private String originalContractingSystemID;
    /**
     * A code signifying the type of presentation of tenders required (e.g., one
     * lot, multiple lots, or all the lots).
     */
    private String partPresentationCode;
    /**
     * A code signifying the type of this tendering procedure.
     */
    private String procedureCode;
    /**
     * A code signifying the method to be followed in submitting tenders.
     */
    private String submissionMethodCode;
    /**
     * A code signifying the urgency of this tendering process.
     */
    private String urgencyCode;
    private List<AuctionTerms> auctionTerms = new ArrayList<>();
    private DocumentReference noticeDocumentReference;
    private DocumentReference additionalDocumentReference;
    private List<EconomicOperatorShortList> economicOperatorShortLists = new ArrayList<>();
    private Event openTenderEvent;
    private List<FrameworkAgreement> frameworkAgreements = new ArrayList<>();
    private Period participationRequestReceptionPeriod;
    private Period invitationSubmissionPeriod;
    private Period ienderSubmissionDeadlinePeriod;
    private Period documentAvailabilityPeriod;
    private List<ProcessJustification> processJustifications = new ArrayList<>();

    public boolean isCandidateReductionConstraintIndicator() {
        return candidateReductionConstraintIndicator;
    }

    public void setCandidateReductionConstraintIndicator(boolean candidateReductionConstraintIndicator) {
        this.candidateReductionConstraintIndicator = candidateReductionConstraintIndicator;
    }

    public String getContractingSystemCode() {
        return contractingSystemCode;
    }

    public void setContractingSystemCode(String contractingSystemCode) {
        this.contractingSystemCode = contractingSystemCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpenseCode() {
        return expenseCode;
    }

    public void setExpenseCode(String expenseCode) {
        this.expenseCode = expenseCode;
    }

    public boolean isGovernmentAgreementConstraintIndicator() {
        return governmentAgreementConstraintIndicator;
    }

    public void setGovernmentAgreementConstraintIndicator(boolean governmentAgreementConstraintIndicator) {
        this.governmentAgreementConstraintIndicator = governmentAgreementConstraintIndicator;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNegotiationDescription() {
        return negotiationDescription;
    }

    public void setNegotiationDescription(String negotiationDescription) {
        this.negotiationDescription = negotiationDescription;
    }

    public String getOriginalContractingSystemID() {
        return originalContractingSystemID;
    }

    public void setOriginalContractingSystemID(String originalContractingSystemID) {
        this.originalContractingSystemID = originalContractingSystemID;
    }

    public String getPartPresentationCode() {
        return partPresentationCode;
    }

    public void setPartPresentationCode(String partPresentationCode) {
        this.partPresentationCode = partPresentationCode;
    }

    public String getProcedureCode() {
        return procedureCode;
    }

    public void setProcedureCode(String procedureCode) {
        this.procedureCode = procedureCode;
    }

    public String getSubmissionMethodCode() {
        return submissionMethodCode;
    }

    public void setSubmissionMethodCode(String submissionMethodCode) {
        this.submissionMethodCode = submissionMethodCode;
    }

    public String getUrgencyCode() {
        return urgencyCode;
    }

    public void setUrgencyCode(String urgencyCode) {
        this.urgencyCode = urgencyCode;
    }

    public List<AuctionTerms> getAuctionTerms() {
        return auctionTerms;
    }

    public void setAuctionTerms(List<AuctionTerms> auctionTerms) {
        this.auctionTerms = auctionTerms;
    }

    public DocumentReference getNoticeDocumentReference() {
        return noticeDocumentReference;
    }

    public void setNoticeDocumentReference(DocumentReference noticeDocumentReference) {
        this.noticeDocumentReference = noticeDocumentReference;
    }

    public DocumentReference getAdditionalDocumentReference() {
        return additionalDocumentReference;
    }

    public void setAdditionalDocumentReference(DocumentReference additionalDocumentReference) {
        this.additionalDocumentReference = additionalDocumentReference;
    }

    public List<EconomicOperatorShortList> getEconomicOperatorShortLists() {
        return economicOperatorShortLists;
    }

    public void setEconomicOperatorShortLists(List<EconomicOperatorShortList> economicOperatorShortLists) {
        this.economicOperatorShortLists = economicOperatorShortLists;
    }

    public Event getOpenTenderEvent() {
        return openTenderEvent;
    }

    public void setOpenTenderEvent(Event openTenderEvent) {
        this.openTenderEvent = openTenderEvent;
    }

    public List<FrameworkAgreement> getFrameworkAgreements() {
        return frameworkAgreements;
    }

    public void setFrameworkAgreements(List<FrameworkAgreement> frameworkAgreements) {
        this.frameworkAgreements = frameworkAgreements;
    }

    public Period getParticipationRequestReceptionPeriod() {
        return participationRequestReceptionPeriod;
    }

    public void setParticipationRequestReceptionPeriod(Period participationRequestReceptionPeriod) {
        this.participationRequestReceptionPeriod = participationRequestReceptionPeriod;
    }

    public Period getInvitationSubmissionPeriod() {
        return invitationSubmissionPeriod;
    }

    public void setInvitationSubmissionPeriod(Period invitationSubmissionPeriod) {
        this.invitationSubmissionPeriod = invitationSubmissionPeriod;
    }

    public Period getIenderSubmissionDeadlinePeriod() {
        return ienderSubmissionDeadlinePeriod;
    }

    public void setIenderSubmissionDeadlinePeriod(Period ienderSubmissionDeadlinePeriod) {
        this.ienderSubmissionDeadlinePeriod = ienderSubmissionDeadlinePeriod;
    }

    public Period getDocumentAvailabilityPeriod() {
        return documentAvailabilityPeriod;
    }

    public void setDocumentAvailabilityPeriod(Period documentAvailabilityPeriod) {
        this.documentAvailabilityPeriod = documentAvailabilityPeriod;
    }

    public List<ProcessJustification> getProcessJustifications() {
        return processJustifications;
    }

    public void setProcessJustifications(List<ProcessJustification> processJustifications) {
        this.processJustifications = processJustifications;
    }
}// end Tendering Process