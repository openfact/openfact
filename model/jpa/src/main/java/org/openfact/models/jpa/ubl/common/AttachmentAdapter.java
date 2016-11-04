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

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.AttachmentEntity;
import org.openfact.models.ubl.common.AttachmentModel;
import org.openfact.models.ubl.common.BinaryObjectModel;
import org.openfact.models.ubl.common.ExternalReferenceModel;

public class AttachmentAdapter implements AttachmentModel, JpaModel<AttachmentEntity> {

    protected static final Logger logger = Logger.getLogger(AttachmentAdapter.class);
    protected AttachmentEntity attachment;
    protected EntityManager em;
    protected OpenfactSession session;

    public AttachmentAdapter(OpenfactSession session, EntityManager em, AttachmentEntity attachment) {
        this.session = session;
        this.em = em;
        this.attachment = attachment;
    }

    @Override
    public BinaryObjectModel getEmbeddedDocumentBinaryObject() {
        return new BinaryObjectAdapter(session, em, attachment.getEmbeddedDocumentBinaryObject());
    }

    @Override
    public void setEmbeddedDocumentBinaryObject(BinaryObjectModel value) {
        attachment.setEmbeddedDocumentBinaryObject(BinaryObjectAdapter.toEntity(value, em));
    }

    @Override
    public ExternalReferenceModel getExternalReference() {
        return new ExternalReferenceAdapter(session, em, attachment.getExternalReference());
    }

    @Override
    public void setExternalReference(ExternalReferenceModel value) {
        attachment.setExternalReference(ExternalReferenceAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return attachment.getId();
    }

    @Override
    public AttachmentEntity getEntity() {
        return attachment;
    }

    public static AttachmentEntity toEntity(AttachmentModel model, EntityManager em) {
        if (model instanceof AllowanceChargeAdapter) {
            return ((AttachmentAdapter) model).getEntity();
        }
        return em.getReference(AttachmentEntity.class, model.getId());
    }

}
