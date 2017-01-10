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

import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;
import org.openfact.models.enums.DocumentType;
import org.openfact.provider.ProviderFactory;

public interface DebitNoteProviderFactory extends ProviderFactory<DebitNoteProvider> {

    @Override
    default void postInit(OpenfactSessionFactory factory) {
        factory.register(event -> {
            if (event instanceof DebitNoteModel.DebitNotePostCreateEvent) {
                DebitNoteModel.DebitNotePostCreateEvent debitNotePostCreatedEvent = (DebitNoteModel.DebitNotePostCreateEvent) event;
                DebitNoteModel debitNoteModel = debitNotePostCreatedEvent.getCreatedDebitNote();
                DebitNoteType debitNoteType = debitNoteModel.getDebitNoteType();

                if (debitNoteType.getBillingReference() != null) {
                    debitNoteType.getBillingReference().stream()
                            .filter(p -> p.getInvoiceDocumentReference() != null)
                            .map(f -> f.getInvoiceDocumentReference())
                            .filter(p -> p.getID() != null && p.getIDValue() != null)
                            .forEach(c -> {
                                InvoiceModel invoice = debitNotePostCreatedEvent.getOpenfactSession().invoices().getInvoiceByDocumentId(debitNoteModel.getOrganization(), c.getIDValue());
                                AttatchedDocumentModel attatchedDocument = invoice.addAttatchedDocument(DocumentType.DEBIT_NOTE, debitNoteModel.getId());
                                attatchedDocument.setSingleAttribute("documentId", debitNoteModel.getDocumentId());
                            });
                }
            }
        });
    }

}
