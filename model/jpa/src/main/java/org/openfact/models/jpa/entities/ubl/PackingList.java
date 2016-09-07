package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document describing how goods are packed.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:21:05 a. m.
 */
public class PackingList {

	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private String CustomizationID;
	/**
	 * Textual description of the document instance.
	 */
	private String Description;
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
	 * Text, assigned by the sender, that identifies this document to business
	 * users.
	 */
	private String Name;
	/**
	 * Free-form text pertinent to this document, conveying information that is
	 * not contained explicitly in other structures.
	 */
	private String Note;
	/**
	 * Contains other free-text-based instructions related to the shipment to
	 * the forwarders or carriers. This should only be used where such
	 * information cannot be represented in other structured information
	 * entities within the document.
	 */
	private String OtherInstruction;
	/**
	 * Identifies an instance of executing a profile, to associate all
	 * transactions in a collaboration.
	 */
	private String ProfileExecutionID;
	/**
	 * Identifies a user-defined profile of the subset of UBL being used.
	 */
	private String ProfileID;
	/**
	 * Identifies the earliest version of the UBL 2 schema for this document
	 * type that defines all of the elements that might be encountered in the
	 * current instance.
	 */
	private String UBLVersionID;
	/**
	 * A universally unique identifier for an instance of this document..
	 */
	private String UUID;
	/**
	 * Version identifier of a Packing List.
	 */
	private String VersionID;
	private DocumentDistribution m_DocumentDistribution;
	private List<DocumentReference> documentReferences = new ArrayList<>();
	private Party ConsignorParty;
	private Party CarrierParty;
	private Party FreightForwarderParty;
	private List<Shipment> shipments = new ArrayList<>();
	private List<Signature> signatures = new ArrayList<>();

	public PackingList() {

	}

	public void finalize() throws Throwable {

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
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		Name = name;
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
	 * @return the otherInstruction
	 */
	public String getOtherInstruction() {
		return OtherInstruction;
	}

	/**
	 * @param otherInstruction
	 *            the otherInstruction to set
	 */
	public void setOtherInstruction(String otherInstruction) {
		OtherInstruction = otherInstruction;
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
	 * @return the m_DocumentDistribution
	 */
	public DocumentDistribution getM_DocumentDistribution() {
		return m_DocumentDistribution;
	}

	/**
	 * @param m_DocumentDistribution
	 *            the m_DocumentDistribution to set
	 */
	public void setM_DocumentDistribution(DocumentDistribution m_DocumentDistribution) {
		this.m_DocumentDistribution = m_DocumentDistribution;
	}

	/**
	 * @return the m_DocumentReference
	 */
	public DocumentReference getM_DocumentReference() {
		return m_DocumentReference;
	}

	/**
	 * @param m_DocumentReference
	 *            the m_DocumentReference to set
	 */
	public void setM_DocumentReference(DocumentReference m_DocumentReference) {
		this.m_DocumentReference = m_DocumentReference;
	}

	/**
	 * @return the consignorParty
	 */
	public Party getConsignorParty() {
		return ConsignorParty;
	}

	/**
	 * @param consignorParty
	 *            the consignorParty to set
	 */
	public void setConsignorParty(Party consignorParty) {
		ConsignorParty = consignorParty;
	}

	/**
	 * @return the carrierParty
	 */
	public Party getCarrierParty() {
		return CarrierParty;
	}

	/**
	 * @param carrierParty
	 *            the carrierParty to set
	 */
	public void setCarrierParty(Party carrierParty) {
		CarrierParty = carrierParty;
	}

	/**
	 * @return the freightForwarderParty
	 */
	public Party getFreightForwarderParty() {
		return FreightForwarderParty;
	}

	/**
	 * @param freightForwarderParty
	 *            the freightForwarderParty to set
	 */
	public void setFreightForwarderParty(Party freightForwarderParty) {
		FreightForwarderParty = freightForwarderParty;
	}

	/**
	 * @return the m_Shipment
	 */
	public Shipment getM_Shipment() {
		return m_Shipment;
	}

	/**
	 * @param m_Shipment
	 *            the m_Shipment to set
	 */
	public void setM_Shipment(Shipment m_Shipment) {
		this.m_Shipment = m_Shipment;
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

}// end Packing List