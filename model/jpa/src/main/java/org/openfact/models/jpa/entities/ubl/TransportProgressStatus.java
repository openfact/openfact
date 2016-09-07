package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document sent from a Transportation Network Manager to a Transport Service
 * Provider giving the status of the whereabouts and schedule of the transport
 * means involved in a transport service.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:40 a. m.
 */
public class TransportProgressStatus {

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
	 * Indicates whether transport progress information is available.
	 */
	private boolean statusAvailableIndicator;
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
	private DocumentReference transportProgressStatusRequestDocumentReference;
	private Party senderParty;
	private Party receiverParty;
	private Party sourceIssuerParty;
	private Signature m_Signature;
	private TransportMeans m_TransportMeans;
	private TransportSchedule m_TransportSchedule;

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
	 * @return the statusAvailableIndicator
	 */
	public boolean isStatusAvailableIndicator() {
		return statusAvailableIndicator;
	}

	/**
	 * @param statusAvailableIndicator
	 *            the statusAvailableIndicator to set
	 */
	public void setStatusAvailableIndicator(boolean statusAvailableIndicator) {
		this.statusAvailableIndicator = statusAvailableIndicator;
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
	 * @return the transportProgressStatusRequestDocumentReference
	 */
	public DocumentReference getTransportProgressStatusRequestDocumentReference() {
		return transportProgressStatusRequestDocumentReference;
	}

	/**
	 * @param transportProgressStatusRequestDocumentReference
	 *            the transportProgressStatusRequestDocumentReference to set
	 */
	public void setTransportProgressStatusRequestDocumentReference(
			DocumentReference transportProgressStatusRequestDocumentReference) {
		this.transportProgressStatusRequestDocumentReference = transportProgressStatusRequestDocumentReference;
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
	 * @return the sourceIssuerParty
	 */
	public Party getSourceIssuerParty() {
		return sourceIssuerParty;
	}

	/**
	 * @param sourceIssuerParty
	 *            the sourceIssuerParty to set
	 */
	public void setSourceIssuerParty(Party sourceIssuerParty) {
		this.sourceIssuerParty = sourceIssuerParty;
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
	 * @return the m_TransportMeans
	 */
	public TransportMeans getM_TransportMeans() {
		return m_TransportMeans;
	}

	/**
	 * @param m_TransportMeans
	 *            the m_TransportMeans to set
	 */
	public void setM_TransportMeans(TransportMeans m_TransportMeans) {
		this.m_TransportMeans = m_TransportMeans;
	}

	/**
	 * @return the m_TransportSchedule
	 */
	public TransportSchedule getM_TransportSchedule() {
		return m_TransportSchedule;
	}

	/**
	 * @param m_TransportSchedule
	 *            the m_TransportSchedule to set
	 */
	public void setM_TransportSchedule(TransportSchedule m_TransportSchedule) {
		this.m_TransportSchedule = m_TransportSchedule;
	}

}