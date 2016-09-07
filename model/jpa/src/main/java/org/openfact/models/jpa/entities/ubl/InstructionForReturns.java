package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document used to initiate a return of goods. The producer is requesting the
 * return of products that are not selling well, either to use in other places
 * or to free up rack or shelf space.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:46 a. m.
 */
public class InstructionForReturns {

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
    private CustomerParty retailerCustomerParty;
    private List<DocumentReference> documentReferences = new ArrayList<>();
    private List<InstructionForReturnsLine> instructionForReturnsLines = new ArrayList<>();
    private Party manufacturerParty;
    private List<Shipment> shipments = new ArrayList<>();
    private List<Signature> signatures = new ArrayList<>();
    private SupplierParty sellerSupplierParty;

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
     * @return the retailerCustomerParty
     */
    public CustomerParty getRetailerCustomerParty() {
        return retailerCustomerParty;
    }

    /**
     * @param retailerCustomerParty
     *            the retailerCustomerParty to set
     */
    public void setRetailerCustomerParty(CustomerParty retailerCustomerParty) {
        this.retailerCustomerParty = retailerCustomerParty;
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
     * @return the instructionForReturnsLines
     */
    public List<InstructionForReturnsLine> getInstructionForReturnsLines() {
        return instructionForReturnsLines;
    }

    /**
     * @param instructionForReturnsLines
     *            the instructionForReturnsLines to set
     */
    public void setInstructionForReturnsLines(List<InstructionForReturnsLine> instructionForReturnsLines) {
        this.instructionForReturnsLines = instructionForReturnsLines;
    }

    /**
     * @return the manufacturerParty
     */
    public Party getManufacturerParty() {
        return manufacturerParty;
    }

    /**
     * @param manufacturerParty
     *            the manufacturerParty to set
     */
    public void setManufacturerParty(Party manufacturerParty) {
        this.manufacturerParty = manufacturerParty;
    }

    /**
     * @return the shipments
     */
    public List<Shipment> getShipments() {
        return shipments;
    }

    /**
     * @param shipments
     *            the shipments to set
     */
    public void setShipments(List<Shipment> shipments) {
        this.shipments = shipments;
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
     * @return the sellerSupplierParty
     */
    public SupplierParty getSellerSupplierParty() {
        return sellerSupplierParty;
    }

    /**
     * @param sellerSupplierParty
     *            the sellerSupplierParty to set
     */
    public void setSellerSupplierParty(SupplierParty sellerSupplierParty) {
        this.sellerSupplierParty = sellerSupplierParty;
    }

}// end Instruction For Returns