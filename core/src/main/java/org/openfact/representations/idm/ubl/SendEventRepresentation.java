/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.representations.idm.ubl;

import java.util.Map;

public class SendEventRepresentation {
	private String id;
	private String documentId;
	private boolean accepted;
	private String description;
	private String note;
	private String responseCode;
	private String errorMessage;
	private String digestValue;
	private String barCode;
	private byte[] documentSubmitted;
	private byte[] documentResponse;
	private byte[] customerDocument;
	private Map<String, String> warning;
	private Map<String, String> success;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getDigestValue() {
		return digestValue;
	}

	public void setDigestValue(String digestValue) {
		this.digestValue = digestValue;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public byte[] getDocumentSubmitted() {
		return documentSubmitted;
	}

	public void setDocumentSubmitted(byte[] documentSubmitted) {
		this.documentSubmitted = documentSubmitted;
	}

	public byte[] getDocumentResponse() {
		return documentResponse;
	}

	public void setDocumentResponse(byte[] documentResponse) {
		this.documentResponse = documentResponse;
	}

	public Map<String, String> getWarning() {
		return warning;
	}

	public void setWarning(Map<String, String> warning) {
		this.warning = warning;
	}

	public Map<String, String> getSuccess() {
		return success;
	}

	public void setSuccess(Map<String, String> success) {
		this.success = success;
	}

	public byte[] getCustomerDocument() {
		return customerDocument;
	}

	public void setCustomerDocument(byte[] customerDocument) {
		this.customerDocument = customerDocument;
	}

}
