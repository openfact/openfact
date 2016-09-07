package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document sent by a contracting party to an economic operator acknowledging
 * receipt of a Tender.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:30 a. m.
 */
public class TenderReceipt {

    /**
     * An identifier, assigned by the sender, for the process file (i.e.,
     * record) to which this document belongs.
     */
    private String ContractFolderID;
    /**
     * Short title of a contract associated with this Tender.
     */
    private String ContractName;
    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean CopyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private String CustomizationID;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private String ID;
    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    private LocalDate IssueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private LocalTime IssueTime;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private String Note;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private String ProfileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private String ProfileID;
    /**
     * The date, assigned by the sender, on which the Tender Receipt was
     * created.
     */
    private LocalDate RegisteredDate;
    /**
     * The time, assigned by the sender, at which the Tender Receipt was
     * created.
     */
    private LocalTime RegisteredTime;
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
    private DocumentReference TenderDocumentReference;
    private Party SenderParty;
    private Party ReceiverParty;
    private Signature m_Signature;

    /**
     * @return the contractFolderID
     */
    public String getContractFolderID() {
        return ContractFolderID;
    }

    /**
     * @param contractFolderID
     *            the contractFolderID to set
     */
    public void setContractFolderID(String contractFolderID) {
        ContractFolderID = contractFolderID;
    }

    /**
     * @return the contractName
     */
    public String getContractName() {
        return ContractName;
    }

    /**
     * @param contractName
     *            the contractName to set
     */
    public void setContractName(String contractName) {
        ContractName = contractName;
    }

    /**
     * @return the copyIndicator
     */
    public boolean isCopyIndicator() {
        return CopyIndicator;
    }

    /**
     * @param copyIndicator
     *            the copyIndicator to set
     */
    public void setCopyIndicator(boolean copyIndicator) {
        CopyIndicator = copyIndicator;
    }

    /**
     * @return the customizationID
     */
    public String getCustomizationID() {
        return CustomizationID;
    }

    /**
     * @param customizationID
     *            the customizationID to set
     */
    public void setCustomizationID(String customizationID) {
        CustomizationID = customizationID;
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
        return IssueDate;
    }

    /**
     * @param issueDate
     *            the issueDate to set
     */
    public void setIssueDate(LocalDate issueDate) {
        IssueDate = issueDate;
    }

    /**
     * @return the issueTime
     */
    public LocalTime getIssueTime() {
        return IssueTime;
    }

    /**
     * @param issueTime
     *            the issueTime to set
     */
    public void setIssueTime(LocalTime issueTime) {
        IssueTime = issueTime;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return Note;
    }

    /**
     * @param note
     *            the note to set
     */
    public void setNote(String note) {
        Note = note;
    }

    /**
     * @return the profileExecutionID
     */
    public String getProfileExecutionID() {
        return ProfileExecutionID;
    }

    /**
     * @param profileExecutionID
     *            the profileExecutionID to set
     */
    public void setProfileExecutionID(String profileExecutionID) {
        ProfileExecutionID = profileExecutionID;
    }

    /**
     * @return the profileID
     */
    public String getProfileID() {
        return ProfileID;
    }

    /**
     * @param profileID
     *            the profileID to set
     */
    public void setProfileID(String profileID) {
        ProfileID = profileID;
    }

    /**
     * @return the registeredDate
     */
    public LocalDate getRegisteredDate() {
        return RegisteredDate;
    }

    /**
     * @param registeredDate
     *            the registeredDate to set
     */
    public void setRegisteredDate(LocalDate registeredDate) {
        RegisteredDate = registeredDate;
    }

    /**
     * @return the registeredTime
     */
    public LocalTime getRegisteredTime() {
        return RegisteredTime;
    }

    /**
     * @param registeredTime
     *            the registeredTime to set
     */
    public void setRegisteredTime(LocalTime registeredTime) {
        RegisteredTime = registeredTime;
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
     * @return the tenderDocumentReference
     */
    public DocumentReference getTenderDocumentReference() {
        return TenderDocumentReference;
    }

    /**
     * @param tenderDocumentReference
     *            the tenderDocumentReference to set
     */
    public void setTenderDocumentReference(DocumentReference tenderDocumentReference) {
        TenderDocumentReference = tenderDocumentReference;
    }

    /**
     * @return the senderParty
     */
    public Party getSenderParty() {
        return SenderParty;
    }

    /**
     * @param senderParty
     *            the senderParty to set
     */
    public void setSenderParty(Party senderParty) {
        SenderParty = senderParty;
    }

    /**
     * @return the receiverParty
     */
    public Party getReceiverParty() {
        return ReceiverParty;
    }

    /**
     * @param receiverParty
     *            the receiverParty to set
     */
    public void setReceiverParty(Party receiverParty) {
        ReceiverParty = receiverParty;
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

}// end Tender Receipt