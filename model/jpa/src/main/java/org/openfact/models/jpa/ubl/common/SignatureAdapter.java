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
package org.openfact.models.jpa.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.SignatureEntity;
import org.openfact.models.ubl.common.AttachmentModel;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.SignatureModel;

public class SignatureAdapter implements SignatureModel, JpaModel<SignatureEntity> {

    protected static final Logger logger = Logger.getLogger(SignatureAdapter.class);
    protected SignatureEntity signature;
    protected EntityManager em;
    protected OpenfactSession session;

    public SignatureAdapter(OpenfactSession session, EntityManager em, SignatureEntity signature) {
        this.session = session;
        this.em = em;
        this.signature = signature;
    }

    @Override
    public String getID() {
        return this.signature.getID();
    }

    @Override
    public void setID(String value) {
        this.signature.setID(value);
    }

    @Override
    public String getNote() {
        return this.signature.getNote();
    }

    @Override
    public void setNote(String value) {
        this.signature.setNote(value);
    }

    @Override
    public LocalDate getValidationDate() {
        return this.signature.getValidationDate();
    }

    @Override
    public void setValidationDate(LocalDate value) {
        this.signature.setValidationDate(value);
    }

    @Override
    public LocalTime getValidationTime() {
        return this.signature.getValidationTime();
    }

    @Override
    public void setValidationTime(LocalTime value) {
        this.signature.setValidationTime(value);
    }

    @Override
    public String getValidatorID() {
        return this.signature.getValidatorID();
    }

    @Override
    public void setValidatorID(String value) {
        this.signature.setValidatorID(value);
    }

    @Override
    public String getCanonicalizationMethod() {
        return this.signature.getCanonicalizationMethod();
    }

    @Override
    public void setCanonicalizationMethod(String value) {
        this.signature.setCanonicalizationMethod(value);
    }

    @Override
    public String getSignatureMethod() {
        return this.signature.getSignatureMethod();
    }

    @Override
    public void setSignatureMethod(String value) {
        this.signature.setSignatureMethod(value);
    }

    @Override
    public PartyModel getSignatoryParty() {
        return new PartyAdapter(session, em, signature.getSignatoryParty());
    }

    @Override
    public void setSignatoryParty(PartyModel value) {
        this.signature.setSignatoryParty(PartyAdapter.toEntity(value, em));
    }

    @Override
    public AttachmentModel getDigitalSignatureAttachment() {
        return new AttachmentAdapter(session, em, signature.getDigitalSignatureAttachment());
    }

    @Override
    public void setDigitalSignatureAttachment(AttachmentModel value) {
        this.signature.setDigitalSignatureAttachment(AttachmentAdapter.toEntity(value, em));
    }

    @Override
    public DocumentReferenceModel getOriginalDocumentReference() {
        return new DocumentReferenceAdapter(session, em, signature.getOriginalDocumentReference());
    }

    @Override
    public void setOriginalDocumentReference(DocumentReferenceModel value) {
        this.signature.setOriginalDocumentReference(DocumentReferenceAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return this.signature.getId();
    }

    @Override
    public SignatureEntity getEntity() {
        return signature;
    }

    public static SignatureEntity toEntity(SignatureModel model, EntityManager em) {
        if (model instanceof SignatureAdapter) {
            return ((SignatureAdapter) model).getEntity();
        }
        return em.getReference(SignatureEntity.class, model.getId());
    }
}
