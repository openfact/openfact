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

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.DocumentReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.TransactionConditionsEntity;
import org.openfact.models.ubl.common.DocumentReferenceModel;
import org.openfact.models.ubl.common.TransactionConditionsModel;

public class TransactionConditionsAdapter
        implements TransactionConditionsModel, JpaModel<TransactionConditionsEntity> {

    protected static final Logger logger = Logger.getLogger(TransactionConditionsAdapter.class);
    protected TransactionConditionsEntity transactionConditions;
    protected EntityManager em;
    protected OpenfactSession session;

    public TransactionConditionsAdapter(OpenfactSession session, EntityManager em,
            TransactionConditionsEntity transactionConditions) {
        this.session = session;
        this.em = em;
        this.transactionConditions = transactionConditions;
    }

    @Override
    public String getID() {
        return this.transactionConditions.getID();
    }

    @Override
    public void setID(String value) {
        this.transactionConditions.setID(value);
    }

    @Override
    public String getActionCode() {
        return this.transactionConditions.getActionCode();
    }

    @Override
    public void setActionCode(String value) {
        this.transactionConditions.setActionCode(value);
    }

    @Override
    public List<String> getDescription() {
        return this.transactionConditions.getDescription();
    }

    @Override
    public void setDescription(List<String> description) {
        this.transactionConditions.setDescription(description);
    }

    @Override
    public List<DocumentReferenceModel> getDocumentReference() {
        return transactionConditions.getDocumentReference().stream()
                .map(f -> new DocumentReferenceAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setDocumentReference(List<DocumentReferenceModel> documentReference) {
        List<DocumentReferenceEntity> entities = documentReference.stream()
                .map(f -> DocumentReferenceAdapter.toEntity(f, em)).collect(Collectors.toList());
        transactionConditions.setDocumentReference(entities);
    }

    @Override
    public String getId() {
        return this.transactionConditions.getId();
    }

    @Override
    public TransactionConditionsEntity getEntity() {
        return transactionConditions;
    }

    public static TransactionConditionsEntity toEntity(TransactionConditionsModel model, EntityManager em) {
        if (model instanceof TransactionConditionsAdapter) {
            return ((TransactionConditionsAdapter) model).getEntity();
        }
        return em.getReference(TransactionConditionsEntity.class, model.getId());
    }

}
