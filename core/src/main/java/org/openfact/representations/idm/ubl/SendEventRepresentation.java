package org.openfact.representations.idm.ubl;

import java.util.Map;

public class SendEventRepresentation {
	private String id;
	private String ID;
	private boolean accepted;
	private String Description;
	private String Note;
	private String ResponseCode;
	private String Error;
	private String DigestValue;
	private String barCode;
	private byte[] xmlDoument;
	private byte[] documentResponse;
	private byte[] customerDoument;
	private Map<String, String> sendWarning;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public String getResponseCode() {
		return ResponseCode;
	}

	public void setResponseCode(String responseCode) {
		ResponseCode = responseCode;
	}

	public String getError() {
		return Error;
	}

	public void setError(String error) {
		Error = error;
	}

	public String getDigestValue() {
		return DigestValue;
	}

	public void setDigestValue(String digestValue) {
		DigestValue = digestValue;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public byte[] getXmlDoument() {
		return xmlDoument;
	}

	public void setXmlDoument(byte[] xmlDoument) {
		this.xmlDoument = xmlDoument;
	}

	public byte[] getDocumentResponse() {
		return documentResponse;
	}

	public void setDocumentResponse(byte[] documentResponse) {
		this.documentResponse = documentResponse;
	}

	public byte[] getCustomerDoument() {
		return customerDoument;
	}

	public void setCustomerDoument(byte[] customerDoument) {
		this.customerDoument = customerDoument;
	}

	public Map<String, String> getSendWarning() {
		return sendWarning;
	}

	public void setSendWarning(Map<String, String> sendWarning) {
		this.sendWarning = sendWarning;
	}

}
