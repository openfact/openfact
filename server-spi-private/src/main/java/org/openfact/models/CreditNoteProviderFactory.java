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
package org.openfact.models;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.BillingReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.DocumentReferenceType;
import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import org.openfact.Config;
import org.openfact.models.enums.DocumentType;
import org.openfact.provider.ProviderEvent;
import org.openfact.provider.ProviderEventListener;
import org.openfact.provider.ProviderFactory;
import org.openfact.representations.UblConfigRepresentation;

import java.util.ArrayList;
import java.util.List;

public interface CreditNoteProviderFactory extends ProviderFactory<CreditNoteProvider> {

    Config.Scope getConfig();

    @Override
    default void postInit(OpenfactSessionFactory factory) {
        factory.register(new ProviderEventListener() {
            @Override
            public void onEvent(ProviderEvent event) {
                if (event instanceof CreditNoteModel.CreditNotePostCreateEvent) {

                    UblConfigRepresentation.UblDocument[] documents = UblConfigRepresentation.SINGLETON.getUblDocuments();
                    List<String> documentTypeCode = new ArrayList<>();

                    for (int i = 0; i < documents.length; i++) {
                        DocumentType documentType = DocumentType.getFromString(documents[i].getDenomination());
                        if (documentType.equals(DocumentType.INVOICE)) {
                            for (int j = 0; j < documents[i].getDocumentTypeCode().length; j++) {
                                documentTypeCode.add(documents[i].getDocumentTypeCode()[j]);
                            }
                        }
                    }

                    if (documentTypeCode != null) {
                        CreditNoteModel.CreditNotePostCreateEvent creditNotePostCreatedEvent = (CreditNoteModel.CreditNotePostCreateEvent) event;

                        CreditNoteModel creditNote = creditNotePostCreatedEvent.getCreatedCreditNote();
                        CreditNoteType creditNoteType = creditNote.getCreditNoteType();

                        if (creditNoteType.getBillingReference() != null) {
                            for (BillingReferenceType billingReferenceType : creditNoteType.getBillingReference()) {
                                if (billingReferenceType.getInvoiceDocumentReference() != null) {
                                    DocumentReferenceType documentReferenceType = billingReferenceType.getInvoiceDocumentReference();

                                    String xmlDocumentID = null;
                                    String xmlDocumentTypeCode = null;
                                    if (documentReferenceType.getID() != null) {
                                        xmlDocumentID = documentReferenceType.getIDValue();
                                    }
                                    if (documentReferenceType.getDocumentTypeCode() != null) {
                                        xmlDocumentTypeCode = documentReferenceType.getDocumentTypeCodeValue();
                                    }

                                    if (xmlDocumentID != null && documentReferenceType != null && documentTypeCode.contains(xmlDocumentTypeCode)) {
                                        InvoiceModel invoice = creditNotePostCreatedEvent.getOpenfactSession().invoices().getInvoiceByDocumentId(creditNote.getOrganization(), xmlDocumentID);
                                        AttatchedDocumentModel attatchedDocument = invoice.addAttatchedDocument(DocumentType.CREDIT_NOTE, creditNote.getId());
                                        attatchedDocument.setSingleAttribute("documentId", creditNote.getDocumentId());
                                    }
                                }
                            }
                        }
                    }

                }
            }
        });
    }

}
