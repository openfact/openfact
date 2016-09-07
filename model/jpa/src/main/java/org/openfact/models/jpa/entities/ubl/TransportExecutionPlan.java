package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document used in the negotiation of a transport service between a transport
 * user and a transport service provider.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:37 a. m.
 */
public class TransportExecutionPlan {

	/**
	 * Indicates whether this document is a copy (true) or not (false).
	 */
	private boolean CopyIndicator;
	/**
	 * Identifies a user-defined customization of UBL for a specific use.
	 */
	private String CustomizationID;
	/**
	 * A code signifying the status of the Transport Execution Plan (updated,
	 * cancelled, confirmed, etc.)
	 */
	private String DocumentStatusCode;
	/**
	 * A code signifying a reason associated with the status of a Transport
	 * Execution Plan.
	 */
	private String DocumentStatusReasonCode;
	/**
	 * A reason for the status assigned to the Transport Execution Plan,
	 * expressed in text.
	 */
	private String DocumentStatusReasonDescription;
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
	 * Remarks from the transport service provider regarding the transport
	 * operations referred to in the Transport Execution Plan.
	 */
	private String TransportServiceProviderRemarks;
	/**
	 * Remarks from the transport user regarding the transport operations
	 * referred to in the Transport Execution Plan.
	 */
	private String TransportUserRemarks;
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
	 * Indicates the current version of the Transport Execution Plan.
	 */
	private String VersionID;
	private Consignment m_Consignment;
	private Contract TransportContract;
	private DocumentReference TransportExecutionPlanDocumentReference;
	private DocumentReference TransportExecutionPlanRequestDocumentReference;
	private DocumentReference TransportServiceDescriptionDocumentReference;
	private DocumentReference AdditionalDocumentReference;
	private Location ToLocation;
	private Location FromLocation;
	private Location AtLocation;
	private Party SenderParty;
	private Party TransportUserParty;
	private Party ReceiverParty;
	private Party BillToParty;
	private Party TransportServiceProviderParty;
	private Period ServiceStartTimePeriod;
	private Period ServiceEndTimePeriod;
	private Period ValidityPeriod;
	private Period TransportUserResponseRequiredPeriod;
	private Period TransportServiceProviderResponseRequiredPeriod;
	private List<Signature> signatures = new ArrayList<>();
	private TransportExecutionTerms m_TransportExecutionTerms;
	private TransportationService AdditionalTransportationService;
	private TransportationService MainTransportationService;

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
	 * @return the documentStatusCode
	 */
	public String getDocumentStatusCode() {
		return DocumentStatusCode;
	}

	/**
	 * @param documentStatusCode
	 *            the documentStatusCode to set
	 */
	public void setDocumentStatusCode(String documentStatusCode) {
		DocumentStatusCode = documentStatusCode;
	}

	/**
	 * @return the documentStatusReasonCode
	 */
	public String getDocumentStatusReasonCode() {
		return DocumentStatusReasonCode;
	}

	/**
	 * @param documentStatusReasonCode
	 *            the documentStatusReasonCode to set
	 */
	public void setDocumentStatusReasonCode(String documentStatusReasonCode) {
		DocumentStatusReasonCode = documentStatusReasonCode;
	}

	/**
	 * @return the documentStatusReasonDescription
	 */
	public String getDocumentStatusReasonDescription() {
		return DocumentStatusReasonDescription;
	}

	/**
	 * @param documentStatusReasonDescription
	 *            the documentStatusReasonDescription to set
	 */
	public void setDocumentStatusReasonDescription(String documentStatusReasonDescription) {
		DocumentStatusReasonDescription = documentStatusReasonDescription;
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
	 * @return the transportServiceProviderRemarks
	 */
	public String getTransportServiceProviderRemarks() {
		return TransportServiceProviderRemarks;
	}

	/**
	 * @param transportServiceProviderRemarks
	 *            the transportServiceProviderRemarks to set
	 */
	public void setTransportServiceProviderRemarks(String transportServiceProviderRemarks) {
		TransportServiceProviderRemarks = transportServiceProviderRemarks;
	}

	/**
	 * @return the transportUserRemarks
	 */
	public String getTransportUserRemarks() {
		return TransportUserRemarks;
	}

	/**
	 * @param transportUserRemarks
	 *            the transportUserRemarks to set
	 */
	public void setTransportUserRemarks(String transportUserRemarks) {
		TransportUserRemarks = transportUserRemarks;
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
	 * @return the m_Consignment
	 */
	public Consignment getM_Consignment() {
		return m_Consignment;
	}

	/**
	 * @param m_Consignment
	 *            the m_Consignment to set
	 */
	public void setM_Consignment(Consignment m_Consignment) {
		this.m_Consignment = m_Consignment;
	}

	/**
	 * @return the transportContract
	 */
	public Contract getTransportContract() {
		return TransportContract;
	}

	/**
	 * @param transportContract
	 *            the transportContract to set
	 */
	public void setTransportContract(Contract transportContract) {
		TransportContract = transportContract;
	}

	/**
	 * @return the transportExecutionPlanDocumentReference
	 */
	public DocumentReference getTransportExecutionPlanDocumentReference() {
		return TransportExecutionPlanDocumentReference;
	}

	/**
	 * @param transportExecutionPlanDocumentReference
	 *            the transportExecutionPlanDocumentReference to set
	 */
	public void setTransportExecutionPlanDocumentReference(DocumentReference transportExecutionPlanDocumentReference) {
		TransportExecutionPlanDocumentReference = transportExecutionPlanDocumentReference;
	}

	/**
	 * @return the transportExecutionPlanRequestDocumentReference
	 */
	public DocumentReference getTransportExecutionPlanRequestDocumentReference() {
		return TransportExecutionPlanRequestDocumentReference;
	}

	/**
	 * @param transportExecutionPlanRequestDocumentReference
	 *            the transportExecutionPlanRequestDocumentReference to set
	 */
	public void setTransportExecutionPlanRequestDocumentReference(
			DocumentReference transportExecutionPlanRequestDocumentReference) {
		TransportExecutionPlanRequestDocumentReference = transportExecutionPlanRequestDocumentReference;
	}

	/**
	 * @return the transportServiceDescriptionDocumentReference
	 */
	public DocumentReference getTransportServiceDescriptionDocumentReference() {
		return TransportServiceDescriptionDocumentReference;
	}

	/**
	 * @param transportServiceDescriptionDocumentReference
	 *            the transportServiceDescriptionDocumentReference to set
	 */
	public void setTransportServiceDescriptionDocumentReference(
			DocumentReference transportServiceDescriptionDocumentReference) {
		TransportServiceDescriptionDocumentReference = transportServiceDescriptionDocumentReference;
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
	 * @return the toLocation
	 */
	public Location getToLocation() {
		return ToLocation;
	}

	/**
	 * @param toLocation
	 *            the toLocation to set
	 */
	public void setToLocation(Location toLocation) {
		ToLocation = toLocation;
	}

	/**
	 * @return the fromLocation
	 */
	public Location getFromLocation() {
		return FromLocation;
	}

	/**
	 * @param fromLocation
	 *            the fromLocation to set
	 */
	public void setFromLocation(Location fromLocation) {
		FromLocation = fromLocation;
	}

	/**
	 * @return the atLocation
	 */
	public Location getAtLocation() {
		return AtLocation;
	}

	/**
	 * @param atLocation
	 *            the atLocation to set
	 */
	public void setAtLocation(Location atLocation) {
		AtLocation = atLocation;
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
	 * @return the transportUserParty
	 */
	public Party getTransportUserParty() {
		return TransportUserParty;
	}

	/**
	 * @param transportUserParty
	 *            the transportUserParty to set
	 */
	public void setTransportUserParty(Party transportUserParty) {
		TransportUserParty = transportUserParty;
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
	 * @return the billToParty
	 */
	public Party getBillToParty() {
		return BillToParty;
	}

	/**
	 * @param billToParty
	 *            the billToParty to set
	 */
	public void setBillToParty(Party billToParty) {
		BillToParty = billToParty;
	}

	/**
	 * @return the transportServiceProviderParty
	 */
	public Party getTransportServiceProviderParty() {
		return TransportServiceProviderParty;
	}

	/**
	 * @param transportServiceProviderParty
	 *            the transportServiceProviderParty to set
	 */
	public void setTransportServiceProviderParty(Party transportServiceProviderParty) {
		TransportServiceProviderParty = transportServiceProviderParty;
	}

	/**
	 * @return the serviceStartTimePeriod
	 */
	public Period getServiceStartTimePeriod() {
		return ServiceStartTimePeriod;
	}

	/**
	 * @param serviceStartTimePeriod
	 *            the serviceStartTimePeriod to set
	 */
	public void setServiceStartTimePeriod(Period serviceStartTimePeriod) {
		ServiceStartTimePeriod = serviceStartTimePeriod;
	}

	/**
	 * @return the serviceEndTimePeriod
	 */
	public Period getServiceEndTimePeriod() {
		return ServiceEndTimePeriod;
	}

	/**
	 * @param serviceEndTimePeriod
	 *            the serviceEndTimePeriod to set
	 */
	public void setServiceEndTimePeriod(Period serviceEndTimePeriod) {
		ServiceEndTimePeriod = serviceEndTimePeriod;
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
	 * @return the transportUserResponseRequiredPeriod
	 */
	public Period getTransportUserResponseRequiredPeriod() {
		return TransportUserResponseRequiredPeriod;
	}

	/**
	 * @param transportUserResponseRequiredPeriod
	 *            the transportUserResponseRequiredPeriod to set
	 */
	public void setTransportUserResponseRequiredPeriod(Period transportUserResponseRequiredPeriod) {
		TransportUserResponseRequiredPeriod = transportUserResponseRequiredPeriod;
	}

	/**
	 * @return the transportServiceProviderResponseRequiredPeriod
	 */
	public Period getTransportServiceProviderResponseRequiredPeriod() {
		return TransportServiceProviderResponseRequiredPeriod;
	}

	/**
	 * @param transportServiceProviderResponseRequiredPeriod
	 *            the transportServiceProviderResponseRequiredPeriod to set
	 */
	public void setTransportServiceProviderResponseRequiredPeriod(
			Period transportServiceProviderResponseRequiredPeriod) {
		TransportServiceProviderResponseRequiredPeriod = transportServiceProviderResponseRequiredPeriod;
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
	 * @return the m_TransportExecutionTerms
	 */
	public TransportExecutionTerms getM_TransportExecutionTerms() {
		return m_TransportExecutionTerms;
	}

	/**
	 * @param m_TransportExecutionTerms
	 *            the m_TransportExecutionTerms to set
	 */
	public void setM_TransportExecutionTerms(TransportExecutionTerms m_TransportExecutionTerms) {
		this.m_TransportExecutionTerms = m_TransportExecutionTerms;
	}

	/**
	 * @return the additionalTransportationService
	 */
	public TransportationService getAdditionalTransportationService() {
		return AdditionalTransportationService;
	}

	/**
	 * @param additionalTransportationService
	 *            the additionalTransportationService to set
	 */
	public void setAdditionalTransportationService(TransportationService additionalTransportationService) {
		AdditionalTransportationService = additionalTransportationService;
	}

	/**
	 * @return the mainTransportationService
	 */
	public TransportationService getMainTransportationService() {
		return MainTransportationService;
	}

	/**
	 * @param mainTransportationService
	 *            the mainTransportationService to set
	 */
	public void setMainTransportationService(TransportationService mainTransportationService) {
		MainTransportationService = mainTransportationService;
	}

}// end Transport Execution Plan