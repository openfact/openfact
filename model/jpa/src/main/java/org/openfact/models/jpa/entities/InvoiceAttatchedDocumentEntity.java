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
package org.openfact.models.jpa.entities;

import org.openfact.models.jpa.entities.CreditNoteEntity;
import org.openfact.models.jpa.entities.SendEventEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue(value = "INVOICE")
@NamedQueries(value = {
        @NamedQuery(name = "getAllAttachedDocumentByInvoiceId", query = "select s from InvoiceAttatchedDocumentEntity s where invoice.id=:invoiceId"),
        @NamedQuery(name = "deleteInvoiceAttatchedDocumentByOrganization", query = "delete from InvoiceAttatchedDocumentEntity doc where doc.invoice IN (select i from InvoiceEntity i where i.organizationId=:organizationId)"),
        @NamedQuery(name = "deleteInvoiceAttachedDocumentsByOrganizationTypeAndDocumentId", query = "delete from InvoiceAttatchedDocumentEntity doc where doc.documentType=:documentType and doc.documentId=:documentId and doc.invoice IN (select i from InvoiceEntity i where i.organizationId=:organizationId)")
})
public class InvoiceAttatchedDocumentEntity extends AttatchedDocumentEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "INVOICE_ID")
    private InvoiceEntity invoice;

    public InvoiceEntity getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceEntity invoice) {
        this.invoice = invoice;
    }
}
