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

import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import org.openfact.Config;
import org.openfact.models.enums.DocumentType;
import org.openfact.provider.ProviderFactory;

public interface CreditNoteProviderFactory extends ProviderFactory<CreditNoteProvider> {

    @Override
    default void postInit(OpenfactSessionFactory factory) {
        factory.register(event -> {
            if (event instanceof CreditNoteModel.CreditNotePostCreateEvent) {
                CreditNoteModel.CreditNotePostCreateEvent creditNotePostCreatedEvent = (CreditNoteModel.CreditNotePostCreateEvent) event;
                CreditNoteModel creditNoteModel = creditNotePostCreatedEvent.getCreatedCreditNote();
                CreditNoteType creditNoteType = creditNoteModel.getCreditNoteType();

                if (creditNoteType.getBillingReference() != null) {
                    creditNoteType.getBillingReference().stream()
                            .filter(p -> p.getInvoiceDocumentReference() != null)
                            .map(f -> f.getInvoiceDocumentReference())
                            .filter(p -> p.getID() != null && p.getIDValue() != null)
                            .forEach(c -> {
                                InvoiceModel invoice = creditNotePostCreatedEvent.getOpenfactSession().invoices().getInvoiceByDocumentId(creditNoteModel.getOrganization(), c.getIDValue());
                                AttatchedDocumentModel attatchedDocument = invoice.addAttatchedDocument(DocumentType.CREDIT_NOTE, creditNoteModel.getId());
                                attatchedDocument.setSingleAttribute("documentId", creditNoteModel.getDocumentId());
                            });
                }
            }
        });
    }

}
