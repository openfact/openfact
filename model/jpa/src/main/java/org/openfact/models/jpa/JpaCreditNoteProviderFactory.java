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
package org.openfact.models.jpa;

import javax.persistence.EntityManager;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.BillingReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.DocumentReferenceType;
import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import org.openfact.Config;
import org.openfact.connections.jpa.JpaConnectionProvider;
import org.openfact.models.*;
import org.openfact.models.enums.DocumentType;
import org.openfact.provider.ProviderEvent;
import org.openfact.provider.ProviderEventListener;

public class JpaCreditNoteProviderFactory implements CreditNoteProviderFactory {

    private Config.Scope config;

    @Override
    public CreditNoteProvider create(OpenfactSession session) {
        EntityManager em = session.getProvider(JpaConnectionProvider.class).getEntityManager();
        return new JpaCreditNoteProvider(session, em);
    }

    @Override
    public void init(Config.Scope config) {
        this.config = config;
    }

    @Override
    public void postInit(OpenfactSessionFactory factory) {
        String documentTypeCode = config.get("documentTypeCode");
        if(documentTypeCode != null) {

            factory.register(new ProviderEventListener() {
                @Override
                public void onEvent(ProviderEvent event) {
                    if(event instanceof CreditNoteModel.CreditNotePostCreateEvent) {
                        CreditNoteModel.CreditNotePostCreateEvent creditNotePostCreatedEvent = (CreditNoteModel.CreditNotePostCreateEvent) event;

                        CreditNoteModel creditNote = creditNotePostCreatedEvent.getCreatedCreditNote();
                        CreditNoteType creditNoteType = creditNote.getCreditNoteType();

                        if (creditNoteType.getBillingReference() != null) {
                            for (BillingReferenceType billingReferenceType : creditNoteType.getBillingReference()) {
                                if(billingReferenceType.getInvoiceDocumentReference() != null) {
                                    DocumentReferenceType documentReferenceType = billingReferenceType.getInvoiceDocumentReference();

                                    String xmlDocumentID = null;
                                    String xmlDocumentTypeCode = null;
                                    if(documentReferenceType.getID() != null) {
                                        xmlDocumentID = documentReferenceType.getIDValue();
                                    }
                                    if(documentReferenceType.getDocumentTypeCode() != null) {
                                        xmlDocumentTypeCode = documentReferenceType.getDocumentTypeCodeValue();
                                    }

                                    if(xmlDocumentID != null && documentReferenceType != null && documentTypeCode.equals(xmlDocumentTypeCode)) {
                                        InvoiceModel invoice = creditNotePostCreatedEvent.getOpenfactSession().invoices().getInvoiceByDocumentId(creditNote.getOrganization(), xmlDocumentID);
                                        AttatchedDocumentModel attatchedDocument = invoice.addAttatchedDocument(DocumentType.CREDIT_NOTE, creditNote.getId());
                                        attatchedDocument.setSingleAttribute("documentId", creditNote.getDocumentId());
                                        attatchedDocument.setSingleAttribute("issueDate", creditNote.getIssueDateTime().toString());
                                        attatchedDocument.setSingleAttribute("payableAmount", creditNote.getPayableAmount().toString());
                                    }
                                }
                            }
                        }

                    }
                }
            });

        }
    }

    @Override
    public String getId() {
        return "jpa";
    }

    @Override
    public void close() {
    }

}
