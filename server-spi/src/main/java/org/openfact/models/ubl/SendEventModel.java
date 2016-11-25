package org.openfact.models.ubl;

import java.util.Map;

public interface SendEventModel {

	String getId();

	String getDocumentId();

	boolean getAccepted();

	String getDescription();

	String getNote();

	String getResponseCode();

	String getErrorMessage();

	String getDigestValue();

	String getBarCode();

	byte[] getDocumentSubmitted();

	byte[] getDocumentResponse();

	byte[] getCustomerDocument();

	Map<String, String> getWarning();

	Map<String, String> getSuccess();

	void setDocumentId(String documentId);

	void setAccepted(boolean accepted);

	void setDescription(String description);

	void setNote(String note);

	void setResponseCode(String responseCode);

	void setErrorMessage(String errorMessage);

	void setDigestValue(String digestValue);

	void setBarCode(String barCode);

	void setDocumentSubmitted(byte[] documentSubmitted);

	void setDocumentResponse(byte[] documentResponse);

	void setCustomerDocument(byte[] customerDocument);

	void setWarning(Map<String, String> warning);

	void setSuccess(Map<String, String> success);

}
