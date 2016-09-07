package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to describe a contract.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:59 a. m.
 */
public class Contract {

    /**
     * The type of this contract, expressed as text, such as "Cost plus award
     * fee" and "Cost plus fixed fee" from UNCEFACT Contract Type code list.
     */
    private String ContractType;
    /**
     * The type of this contract, expressed as a code, such as "Cost plus award
     * fee" and "Cost plus fixed fee" from UNCEFACT Contract Type code list.
     */
    private String ContractTypeCode;
    /**
     * Text describing this contract.
     */
    private String Description;
    /**
     * An identifier for this contract.
     */
    private String ID;
    /**
     * The date on which this contract was issued.
     */
    private LocalDate IssueDate;
    /**
     * The time at which this contract was issued.
     */
    private LocalTime IssueTime;
    /**
     * In a transportation contract, the deadline date by which the services
     * referred to in the transport execution plan have to be booked. For
     * example, if this service is a carrier service scheduled for Wednesday 16
     * February 2011 at 10 a.m. CET, the nomination
     */
    private LocalDate NominationDate;
    /**
     * In a transportation contract, the deadline time by which the services
     * referred to in the transport execution plan have to be booked. For
     * example, if this service is a carrier service scheduled for Wednesday 16
     * February 2011 at 10 a.m. CET, the nomination
     */
    private LocalTime NominationTime;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private String Note;
    /**
     * An identifier for the current version of this contract.
     */
    private String VersionID;
    private Delivery ContractualDelivery;
    private DocumentReference ContractDocumentReference;
    private Period ValidityPeriod;
    private Period NominationPeriod;

    public Contract() {

    }

    public void finalize() throws Throwable {

    }

    /**
     * @return the contractType
     */
    public String getContractType() {
        return ContractType;
    }

    /**
     * @param contractType
     *            the contractType to set
     */
    public void setContractType(String contractType) {
        ContractType = contractType;
    }

    /**
     * @return the contractTypeCode
     */
    public String getContractTypeCode() {
        return ContractTypeCode;
    }

    /**
     * @param contractTypeCode
     *            the contractTypeCode to set
     */
    public void setContractTypeCode(String contractTypeCode) {
        ContractTypeCode = contractTypeCode;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        Description = description;
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
     * @return the nominationDate
     */
    public LocalDate getNominationDate() {
        return NominationDate;
    }

    /**
     * @param nominationDate
     *            the nominationDate to set
     */
    public void setNominationDate(LocalDate nominationDate) {
        NominationDate = nominationDate;
    }

    /**
     * @return the nominationTime
     */
    public LocalTime getNominationTime() {
        return NominationTime;
    }

    /**
     * @param nominationTime
     *            the nominationTime to set
     */
    public void setNominationTime(LocalTime nominationTime) {
        NominationTime = nominationTime;
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
     * @return the contractualDelivery
     */
    public Delivery getContractualDelivery() {
        return ContractualDelivery;
    }

    /**
     * @param contractualDelivery
     *            the contractualDelivery to set
     */
    public void setContractualDelivery(Delivery contractualDelivery) {
        ContractualDelivery = contractualDelivery;
    }

    /**
     * @return the contractDocumentReference
     */
    public DocumentReference getContractDocumentReference() {
        return ContractDocumentReference;
    }

    /**
     * @param contractDocumentReference
     *            the contractDocumentReference to set
     */
    public void setContractDocumentReference(DocumentReference contractDocumentReference) {
        ContractDocumentReference = contractDocumentReference;
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
     * @return the nominationPeriod
     */
    public Period getNominationPeriod() {
        return NominationPeriod;
    }

    /**
     * @param nominationPeriod
     *            the nominationPeriod to set
     */
    public void setNominationPeriod(Period nominationPeriod) {
        NominationPeriod = nominationPeriod;
    }

}// end Contract