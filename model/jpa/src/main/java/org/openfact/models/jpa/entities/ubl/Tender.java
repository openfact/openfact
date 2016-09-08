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
    private String contractFolderID;
    /**
     * Short title of a contract associated with this Tender.
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
    private String id;
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
     * A code to specify the type of tender (economical or objective criteria
     * versus technical or subjective criteria)
     */
    private String tenderTypeCode;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private String ublVersionID;
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

    public String getContractFolderID() {
        return contractFolderID;
    }

    public void setContractFolderID(String contractFolderID) {
        this.contractFolderID = contractFolderID;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public boolean isCopyIndicator() {
        return copyIndicator;
    }

    public void setCopyIndicator(boolean copyIndicator) {
        this.copyIndicator = copyIndicator;
    }

    public String getCustomizationID() {
        return customizationID;
    }

    public void setCustomizationID(String customizationID) {
        this.customizationID = customizationID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalTime getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(LocalTime issueTime) {
        this.issueTime = issueTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getProfileExecutionID() {
        return profileExecutionID;
    }

    public void setProfileExecutionID(String profileExecutionID) {
        this.profileExecutionID = profileExecutionID;
    }

    public String getProfileID() {
        return profileID;
    }

    public void setProfileID(String profileID) {
        this.profileID = profileID;
    }

    public String getTenderTypeCode() {
        return tenderTypeCode;
    }

    public void setTenderTypeCode(String tenderTypeCode) {
        this.tenderTypeCode = tenderTypeCode;
    }

    public String getUblVersionID() {
        return ublVersionID;
    }

    public void setUblVersionID(String ublVersionID) {
        this.ublVersionID = ublVersionID;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public List<ContractingParty> getContractingParties() {
        return contractingParties;
    }

    public void setContractingParties(List<ContractingParty> contractingParties) {
        this.contractingParties = contractingParties;
    }

    public CustomerParty getOriginatorCustomerParty() {
        return OriginatorCustomerParty;
    }

    public void setOriginatorCustomerParty(CustomerParty originatorCustomerParty) {
        OriginatorCustomerParty = originatorCustomerParty;
    }

    public List<DocumentReference> getDocumentReferences() {
        return documentReferences;
    }

    public void setDocumentReferences(List<DocumentReference> documentReferences) {
        this.documentReferences = documentReferences;
    }

    public DocumentReference getTendererQualificationDocumentReference() {
        return TendererQualificationDocumentReference;
    }

    public void setTendererQualificationDocumentReference(DocumentReference tendererQualificationDocumentReference) {
        TendererQualificationDocumentReference = tendererQualificationDocumentReference;
    }

    public Party getSubcontractorParty() {
        return SubcontractorParty;
    }

    public void setSubcontractorParty(Party subcontractorParty) {
        SubcontractorParty = subcontractorParty;
    }

    public Party getTendererParty() {
        return TendererParty;
    }

    public void setTendererParty(Party tendererParty) {
        TendererParty = tendererParty;
    }

    public Period getValidityPeriod() {
        return ValidityPeriod;
    }

    public void setValidityPeriod(Period validityPeriod) {
        ValidityPeriod = validityPeriod;
    }

    public List<Signature> getSignatures() {
        return signatures;
    }

    public void setSignatures(List<Signature> signatures) {
        this.signatures = signatures;
    }

    public List<TenderedProject> getTenderedProjects() {
        return tenderedProjects;
    }

    public void setTenderedProjects(List<TenderedProject> tenderedProjects) {
        this.tenderedProjects = tenderedProjects;
    }
}