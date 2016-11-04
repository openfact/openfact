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
import org.openfact.models.jpa.entities.ubl.common.ExternalReferenceEntity;
import org.openfact.models.ubl.common.ExternalReferenceModel;

public class ExternalReferenceAdapter implements ExternalReferenceModel, JpaModel<ExternalReferenceEntity> {

    protected static final Logger logger = Logger.getLogger(ExternalReferenceAdapter.class);
    protected ExternalReferenceEntity externalReference;
    protected EntityManager em;
    protected OpenfactSession session;

    public ExternalReferenceAdapter(OpenfactSession session, EntityManager em,
            ExternalReferenceEntity externalReference) {
        this.session = session;
        this.em = em;
        this.externalReference = externalReference;
    }

    @Override
    public String getURI() {
        return this.externalReference.getUri();
    }

    @Override
    public void setURI(String value) {
        this.externalReference.setUri(value);
    }

    @Override
    public String getDocumentHash() {
        return this.externalReference.getDocumentHash();
    }

    @Override
    public void setDocumentHash(String value) {
        this.externalReference.setDocumentHash(value);
    }

    @Override
    public LocalDate getExpiryDate() {
        return this.externalReference.getExpiryDate();
    }

    @Override
    public void setExpiryDate(LocalDate value) {
        this.externalReference.setExpiryDate(value);
    }

    @Override
    public LocalTime getExpiryTime() {
        return this.externalReference.getExpiryTime();
    }

    @Override
    public void setExpiryTime(LocalTime value) {
        this.externalReference.setExpiryTime(value);
    }

    @Override
    public String getId() {
        return this.externalReference.getId();
    }

    public static ExternalReferenceEntity toEntity(ExternalReferenceModel model, EntityManager em) {
        if (model instanceof ExternalReferenceAdapter) {
            return ((ExternalReferenceAdapter) model).getEntity();
        }
        return em.getReference(ExternalReferenceEntity.class, model.getId());
    }

    @Override
    public ExternalReferenceEntity getEntity() {
        return externalReference;
    }

}
