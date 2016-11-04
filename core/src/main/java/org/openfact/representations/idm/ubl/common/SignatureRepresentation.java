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
package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

public class SignatureRepresentation {
    private String idUbl;
    private String note;
    private LocalDate validationDate;
    private LocalTime validationTime;
    private String validatorID;
    private String canonicalizationMethod;
    private String signatureMethod;
    private PartyRepresentation signatoryParty;
    private AttachmentRepresentation digitalSignatureAttachment;
    private DocumentReferenceRepresentation originalDocumentReference;
    private String id;

    public String getIdUbl() {
        return this.idUbl;
    }

    public void setIdUbl(String idUbl) {
        this.idUbl = idUbl;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValidatorID() {
        return this.validatorID;
    }

    public void setValidatorID(String validatorID) {
        this.validatorID = validatorID;
    }

    public PartyRepresentation getSignatoryParty() {
        return this.signatoryParty;
    }

    public void setSignatoryParty(PartyRepresentation signatoryParty) {
        this.signatoryParty = signatoryParty;
    }

    public LocalTime getValidationTime() {
        return this.validationTime;
    }

    public void setValidationTime(LocalTime validationTime) {
        this.validationTime = validationTime;
    }

    public DocumentReferenceRepresentation getOriginalDocumentReference() {
        return this.originalDocumentReference;
    }

    public void setOriginalDocumentReference(DocumentReferenceRepresentation originalDocumentReference) {
        this.originalDocumentReference = originalDocumentReference;
    }

    public LocalDate getValidationDate() {
        return this.validationDate;
    }

    public void setValidationDate(LocalDate validationDate) {
        this.validationDate = validationDate;
    }

    public AttachmentRepresentation getDigitalSignatureAttachment() {
        return this.digitalSignatureAttachment;
    }

    public void setDigitalSignatureAttachment(AttachmentRepresentation digitalSignatureAttachment) {
        this.digitalSignatureAttachment = digitalSignatureAttachment;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSignatureMethod() {
        return this.signatureMethod;
    }

    public void setSignatureMethod(String signatureMethod) {
        this.signatureMethod = signatureMethod;
    }

    public String getCanonicalizationMethod() {
        return this.canonicalizationMethod;
    }

    public void setCanonicalizationMethod(String canonicalizationMethod) {
        this.canonicalizationMethod = canonicalizationMethod;
    }
}