package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document whereby an economic operator (the tenderer) makes a formal offer
 * (the tender) to a contracting authority to execute an order for the supply or
 * purchase of goods, or for the execution of work, according to the terms of a
 * proposed contract.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:28 a. m.
 */
public class Tender {

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
     * A code to specify the type of tender (economical or objective criteria
     * versus technical or subjective criteria)
     */
    private String TenderTypeCode;
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
    private List<ContractingParty> contractingParties = new ArrayList<>();
    private CustomerParty OriginatorCustomerParty;
    private List<DocumentReference> documentReferences = new ArrayList<>();
    private DocumentReference TendererQualificationDocumentReference;
    private Party SubcontractorParty;
    private Party TendererParty;
    private Period ValidityPeriod;
    private List<Signature> signatures = new ArrayList<>();
    private List<TenderedProject> tenderedProjects = new ArrayList<>();

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
     * @return the tenderTypeCode
     */
    public String getTenderTypeCode() {
        return TenderTypeCode;
    }

    /**
     * @param tenderTypeCode
     *            the tenderTypeCode to set
     */
    public void setTenderTypeCode(String tenderTypeCode) {
        TenderTypeCode = tenderTypeCode;
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
     * @return the originatorCustomerParty
     */
    public CustomerParty getOriginatorCustomerParty() {
        return OriginatorCustomerParty;
    }

    /**
     * @param originatorCustomerParty
     *            the originatorCustomerParty to set
     */
    public void setOriginatorCustomerParty(CustomerParty originatorCustomerParty) {
        OriginatorCustomerParty = originatorCustomerParty;
    }

    /**
     * @return the documentReferences
     */
    public List<DocumentReference> getDocumentReferences() {
        return documentReferences;
    }

    /**
     * @param documentReferences
     *            the documentReferences to set
     */
    public void setDocumentReferences(List<DocumentReference> documentReferences) {
        this.documentReferences = documentReferences;
    }

    /**
     * @return the tendererQualificationDocumentReference
     */
    public DocumentReference getTendererQualificationDocumentReference() {
        return TendererQualificationDocumentReference;
    }

    /**
     * @param tendererQualificationDocumentReference
     *            the tendererQualificationDocumentReference to set
     */
    public void setTendererQualificationDocumentReference(
            DocumentReference tendererQualificationDocumentReference) {
        TendererQualificationDocumentReference = tendererQualificationDocumentReference;
    }

    /**
     * @return the subcontractorParty
     */
    public Party getSubcontractorParty() {
        return SubcontractorParty;
    }

    /**
     * @param subcontractorParty
     *            the subcontractorParty to set
     */
    public void setSubcontractorParty(Party subcontractorParty) {
        SubcontractorParty = subcontractorParty;
    }

    /**
     * @return the tendererParty
     */
    public Party getTendererParty() {
        return TendererParty;
    }

    /**
     * @param tendererParty
     *            the tendererParty to set
     */
    public void setTendererParty(Party tendererParty) {
        TendererParty = tendererParty;
    }

    /**
     * @return the validityPeriod
     */
    public Period getValidityPeriod() {
        return ValidityPeriod;
    }

    /**
     * @param validityPeriod
     *            the validityPeriod to set
     */
    public void setValidityPeriod(Period validityPeriod) {
        ValidityPeriod = validityPeriod;
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
     * @return the tenderedProjects
     */
    public List<TenderedProject> getTenderedProjects() {
        return tenderedProjects;
    }

    /**
     * @param tenderedProjects
     *            the tenderedProjects to set
     */
    public void setTenderedProjects(List<TenderedProject> tenderedProjects) {
        this.tenderedProjects = tenderedProjects;
    }

}