package org.openfact.models.ubl;

import java.util.Map;

public interface SendEventModel {
	String getId();

	void setId(String id);

	String getID();

	void setID(String ID);

	boolean isAccepted();

	void setAccepted(boolean accepted);

	String getDescription();

	void setDescription(String description);

	String getNote();

	void setNote(String note);

	String getResponseCode();

	void setResponseCode(String responseCode);

	String getError();

	void setError(String error);

	String getDigestValue();

	void setDigestValue(String digestValue);

	String getbarCode();

	void setbarCode(String barCode);

	byte[] getXmlDoument();

	void setXmlDocument(byte[] xmlDocument);

	byte[] getDocumentResponse();

	void setDocumentResponse(byte[] documentResponse);

	byte[] getCustomerDoument();

	void setCustomerDoument(byte[] customerDoument);

	Map<String, String> getSendWarning();

	void setSendWarning(Map<String, String> sendWarning);
}
