package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document communicating to a tenderer that the contract has been awarded to
 * different tenderer.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:48 a. m.
 */
public class UnawardedNotification {

    /**
     * An identifier, assigned by the sender, for the process file (i.e.,
     * record) to which this document belongs.
     */
    private String contractFolderID;
    /**
     * The name, expressed as text, of this procurement project.
     */
    private String contractName;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private String customizationID;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private String ID;
    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    private LocalDate issueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private LocalTime issueTime;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private String note;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private String profileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private String profileID;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private String UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private String UUID;
    private AppealTerms m_AppealTerms;
    private DocumentReference minutesDocumentReference;
    private DocumentReference additionalDocumentReference;
    private Party receiverParty;
    private Party senderParty;
    private Signature m_Signature;
    private TenderResult m_TenderResult;

    /**
     * @return the contractFolderID
     */
    public String getContractFolderID() {
        return contractFolderID;
    }

    /**
     * @param contractFolderID
     *            the contractFolderID to set
     */
    public void setContractFolderID(String contractFolderID) {
        this.contractFolderID = contractFolderID;
    }

    /**
     * @return the contractName
     */
    public String getContractName() {
        return contractName;
    }

    /**
     * @param contractName
     *            the contractName to set
     */
    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    /**
     * @return the copyIndicator
     */
    public boolean isCopyIndicator() {
        return copyIndicator;
    }

    /**
     * @param copyIndicator
     *            the copyIndicator to set
     */
    public void setCopyIndicator(boolean copyIndicator) {
        this.copyIndicator = copyIndicator;
    }

    /**
     * @return the customizationID
     */
    public String getCustomizationID() {
        return customizationID;
    }

    /**
     * @param customizationID
     *            the customizationID to set
     */
    public void setCustomizationID(String customizationID) {
        this.customizationID = customizationID;
    }

    /**
     * @return the iD
     */
    public String getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * @return the issueDate
     */
    public LocalDate getIssueDate() {
        return issueDate;
    }

    /**
     * @param issueDate
     *            the issueDate to set
     */
    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * @return the issueTime
     */
    public LocalTime getIssueTime() {
        return issueTime;
    }

    /**
     * @param issueTime
     *            the issueTime to set
     */
    public void setIssueTime(LocalTime issueTime) {
        this.issueTime = issueTime;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note
     *            the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the profileExecutionID
     */
    public String getProfileExecutionID() {
        return profileExecutionID;
    }

    /**
     * @param profileExecutionID
     *            the profileExecutionID to set
     */
    public void setProfileExecutionID(String profileExecutionID) {
        this.profileExecutionID = profileExecutionID;
    }

    /**
     * @return the profileID
     */
    public String getProfileID() {
        return profileID;
    }

    /**
     * @param profileID
     *            the profileID to set
     */
    public void setProfileID(String profileID) {
        this.profileID = profileID;
    }

    /**
     * @return the uBLVersionID
     */
    public String getUBLVersionID() {
        return UBLVersionID;
    }

    /**
     * @param uBLVersionID
     *            the uBLVersionID to set
     */
    public void setUBLVersionID(String uBLVersionID) {
        UBLVersionID = uBLVersionID;
    }

    /**
     * @return the uUID
     */
    public String getUUID() {
        return UUID;
    }

    /**
     * @param uUID
     *            the uUID to set
     */
    public void setUUID(String uUID) {
        UUID = uUID;
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
     * @return the minutesDocumentReference
     */
    public DocumentReference getMinutesDocumentReference() {
        return minutesDocumentReference;
    }

    /**
     * @param minutesDocumentReference
     *            the minutesDocumentReference to set
     */
    public void setMinutesDocumentReference(DocumentReference minutesDocumentReference) {
        this.minutesDocumentReference = minutesDocumentReference;
    }

    /**
     * @return the additionalDocumentReference
     */
    public DocumentReference getAdditionalDocumentReference() {
        return additionalDocumentReference;
    }

    /**
     * @param additionalDocumentReference
     *            the additionalDocumentReference to set
     */
    public void setAdditionalDocumentReference(DocumentReference additionalDocumentReference) {
        this.additionalDocumentReference = additionalDocumentReference;
    }

    /**
     * @return the receiverParty
     */
    public Party getReceiverParty() {
        return receiverParty;
    }

    /**
     * @param receiverParty
     *            the receiverParty to set
     */
    public void setReceiverParty(Party receiverParty) {
        this.receiverParty = receiverParty;
    }

    /**
     * @return the senderParty
     */
    public Party getSenderParty() {
        return senderParty;
    }

    /**
     * @param senderParty
     *            the senderParty to set
     */
    public void setSenderParty(Party senderParty) {
        this.senderParty = senderParty;
    }

    /**
     * @return the m_Signature
     */
    public Signature getM_Signature() {
        return m_Signature;
    }

    /**
     * @param m_Signature
     *            the m_Signature to set
     */
    public void setM_Signature(Signature m_Signature) {
        this.m_Signature = m_Signature;
    }

    /**
     * @return the m_TenderResult
     */
    public TenderResult getM_TenderResult() {
        return m_TenderResult;
    }

    /**
     * @param m_TenderResult
     *            the m_TenderResult to set
     */
    public void setM_TenderResult(TenderResult m_TenderResult) {
        this.m_TenderResult = m_TenderResult;
    }

}