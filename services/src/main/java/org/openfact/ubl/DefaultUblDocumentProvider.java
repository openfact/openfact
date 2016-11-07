/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.ubl;

import com.helger.ubl21.UBL21Writer;
import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;
import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.CreditNoteModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.utils.ModelToType;
import org.w3c.dom.Document;

public class DefaultUblDocumentProvider implements UblDocumentProvider {

    private static final Logger log = Logger.getLogger(DefaultUblDocumentProvider.class);

    protected OpenfactSession session;

    public DefaultUblDocumentProvider(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public void close() {

    }

    @Override
    public Document getDocument(OrganizationModel organization, InvoiceModel invoice) {
        InvoiceType invoiceType = ModelToType.toType(invoice);
        return UBL21Writer.invoice().getAsDocument(invoiceType);
    }

    @Override
    public Document getDocument(OrganizationModel organization, CreditNoteModel creditNote) {
        CreditNoteType creditNoteType = ModelToType.toType(creditNote);
        return UBL21Writer.creditNote().getAsDocument(creditNoteType);
    }

    @Override
    public Document getDocument(OrganizationModel organization, DebitNoteModel debitNote) {
        DebitNoteType debitNoteType = ModelToType.toType(debitNote);
        return UBL21Writer.debitNote().getAsDocument(debitNoteType);
    }

}
