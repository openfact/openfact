package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document requesting a Transport Service Description, sent from a party with
 * a transport demand (transport user) to a party providing transport services
 * (transport service provider).
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:44 a. m.
 */
public class TransportServiceDescriptionRequest {

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
	 * A code signifying the category of service information requested to be
	 * provided in the Transport Service Description.
	 */
	private String serviceInformationPreferenceCode;
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
	private Party receiverParty;
	private Party transportServiceProviderParty;
	private Party senderParty;
	private Signature m_Signature;
	private TransportationService m_TransportationService;

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
	 * @return the serviceInformationPreferenceCode
	 */
	public String getServiceInformationPreferenceCode() {
		return serviceInformationPreferenceCode;
	}

	/**
	 * @param serviceInformationPreferenceCode
	 *            the serviceInformationPreferenceCode to set
	 */
	public void setServiceInformationPreferenceCode(String serviceInformationPreferenceCode) {
		this.serviceInformationPreferenceCode = serviceInformationPreferenceCode;
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
	 * @return the transportServiceProviderParty
	 */
	public Party getTransportServiceProviderParty() {
		return transportServiceProviderParty;
	}

	/**
	 * @param transportServiceProviderParty
	 *            the transportServiceProviderParty to set
	 */
	public void setTransportServiceProviderParty(Party transportServiceProviderParty) {
		this.transportServiceProviderParty = transportServiceProviderParty;
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
	 * @return the m_TransportationService
	 */
	public TransportationService getM_TransportationService() {
		return m_TransportationService;
	}

	/**
	 * @param m_TransportationService
	 *            the m_TransportationService to set
	 */
	public void setM_TransportationService(TransportationService m_TransportationService) {
		this.m_TransportationService = m_TransportationService;
	}

}// end Transport Service Description Request