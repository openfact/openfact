package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document declaring the qualifications of a tenderer.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:32 a. m.
 */
public class TendererQualification {

    /**
     * An identifier, assigned by the sender, for the process file (i.e.,
     * record) to which this document belongs.
     */
    private String ContractFolderID;
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
     * Identifies the previous version of the Tenderer Qualification which is
     * superceded by this version.
     */
    private String PreviousVersionID;
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
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private String UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private String UUID;
    /**
     * Indicates the current version of the Tenderer Qualification.
     */
    private String VersionID;
    private List<ContractingParty> contractingParties = new ArrayList<>();
    private DocumentReference AdditionalDocumentReference;
    private List<Evidence> evidences = new ArrayList<>();
    private List<Signature> signatures = new ArrayList<>();
    private TendererPartyQualification m_TendererPartyQualification;

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
     * @return the previousVersionID
     */
    public String getPreviousVersionID() {
        return PreviousVersionID;
    }

    /**
     * @param previousVersionID
     *            the previousVersionID to set
     */
    public void setPreviousVersionID(String previousVersionID) {
        PreviousVersionID = previousVersionID;
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
     * @return the versionID
     */
    public String getVersionID() {
        return VersionID;
    }

    /**
     * @param versionID
     *            the versionID to set
     */
    public void setVersionID(String versionID) {
        VersionID = versionID;
    }

    /**
     * @return the contractingParties
     */
    public List<ContractingParty> getContractingParties() {
        return contractingParties;
    }

    /**
     * @param contractingParties
     *            the contractingParties to set
     */
    public void setContractingParties(List<ContractingParty> contractingParties) {
        this.contractingParties = contractingParties;
    }

    /**
     * @return the additionalDocumentReference
     */
    public DocumentReference getAdditionalDocumentReference() {
        return AdditionalDocumentReference;
    }

    /**
     * @param additionalDocumentReference
     *            the additionalDocumentReference to set
     */
    public void setAdditionalDocumentReference(DocumentReference additionalDocumentReference) {
        AdditionalDocumentReference = additionalDocumentReference;
    }

    /**
     * @return the evidences
     */
    public List<Evidence> getEvidences() {
        return evidences;
    }

    /**
     * @param evidences
     *            the evidences to set
     */
    public void setEvidences(List<Evidence> evidences) {
        this.evidences = evidences;
    }

    /**
     * @return the signatures
     */
    public List<Signature> getSignatures() {
        return signatures;
    }

    /**
     * @param signatures
     *            the signatures to set
     */
    public void setSignatures(List<Signature> signatures) {
        this.signatures = signatures;
    }

    /**
     * @return the m_TendererPartyQualification
     */
    public TendererPartyQualification getM_TendererPartyQualification() {
        return m_TendererPartyQualification;
    }

    /**
     * @param m_TendererPartyQualification
     *            the m_TendererPartyQualification to set
     */
    public void setM_TendererPartyQualification(TendererPartyQualification m_TendererPartyQualification) {
        this.m_TendererPartyQualification = m_TendererPartyQualification;
    }

}// end Tenderer Qualification