package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document providing details relating to a transport service, such as
 * transport movement, identification of equipment and goods, subcontracted
 * service providers, etc.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:20:43 a. m.
 */
public class GoodsItemItinerary {

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
	 * The Transport Execution Plan associated with this Goods Item Itinerary.
	 */
	private String transportExecutionPlanReferenceID;
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
	 * Identifies a version of a Goods Item Itinerary in order to distinguish
	 * updates.
	 */
	private String versionID;
	private Consignment referencedConsignment;
	private GoodsItem referencedGoodsItem;
	private Package referencedPackage;
	private Party receiverParty;
	private Party senderParty;
	private List<Signature> signatures = new ArrayList<>();
	private TransportEquipment referencedTransportEquipment;
	private TransportationSegment m_TransportationSegment;

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

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
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

	public String getTransportExecutionPlanReferenceID() {
		return transportExecutionPlanReferenceID;
	}

	public void setTransportExecutionPlanReferenceID(String transportExecutionPlanReferenceID) {
		this.transportExecutionPlanReferenceID = transportExecutionPlanReferenceID;
	}

	public String getUBLVersionID() {
		return UBLVersionID;
	}

	public void setUBLVersionID(String UBLVersionID) {
		this.UBLVersionID = UBLVersionID;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String UUID) {
		this.UUID = UUID;
	}

	public String getVersionID() {
		return versionID;
	}

	public void setVersionID(String versionID) {
		this.versionID = versionID;
	}

	public Consignment getReferencedConsignment() {
		return referencedConsignment;
	}

	public void setReferencedConsignment(Consignment referencedConsignment) {
		this.referencedConsignment = referencedConsignment;
	}

	public GoodsItem getReferencedGoodsItem() {
		return referencedGoodsItem;
	}

	public void setReferencedGoodsItem(GoodsItem referencedGoodsItem) {
		this.referencedGoodsItem = referencedGoodsItem;
	}

	public Package getReferencedPackage() {
		return referencedPackage;
	}

	public void setReferencedPackage(Package referencedPackage) {
		this.referencedPackage = referencedPackage;
	}

	public Party getReceiverParty() {
		return receiverParty;
	}

	public void setReceiverParty(Party receiverParty) {
		this.receiverParty = receiverParty;
	}

	public Party getSenderParty() {
		return senderParty;
	}

	public void setSenderParty(Party senderParty) {
		this.senderParty = senderParty;
	}

	public Signature getM_Signature() {
		return m_Signature;
	}

	public void setM_Signature(Signature m_Signature) {
		this.m_Signature = m_Signature;
	}

	public TransportEquipment getReferencedTransportEquipment() {
		return referencedTransportEquipment;
	}

	public void setReferencedTransportEquipment(TransportEquipment referencedTransportEquipment) {
		this.referencedTransportEquipment = referencedTransportEquipment;
	}

	public TransportationSegment getM_TransportationSegment() {
		return m_TransportationSegment;
	}

	public void setM_TransportationSegment(TransportationSegment m_TransportationSegment) {
		this.m_TransportationSegment = m_TransportationSegment;
	}
}// end Goods Item Itinerary