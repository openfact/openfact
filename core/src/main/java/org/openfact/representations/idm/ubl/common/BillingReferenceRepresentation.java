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
package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class BillingReferenceRepresentation {
    private DocumentReferenceRepresentation invoiceDocumentReference;
    private DocumentReferenceRepresentation selfBilledInvoiceDocumentReference;
    private DocumentReferenceRepresentation creditNoteDocumentReference;
    private DocumentReferenceRepresentation selfBilledCreditNoteDocumentReference;
    private DocumentReferenceRepresentation debitNoteDocumentReference;
    private DocumentReferenceRepresentation reminderDocumentReference;
    private DocumentReferenceRepresentation additionalDocumentReference;
    private List<BillingReferenceLineRepresentation> billingReferenceLine;
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DocumentReferenceRepresentation getInvoiceDocumentReference() {
        return this.invoiceDocumentReference;
    }

    public void setInvoiceDocumentReference(DocumentReferenceRepresentation invoiceDocumentReference) {
        this.invoiceDocumentReference = invoiceDocumentReference;
    }

    public List<BillingReferenceLineRepresentation> getBillingReferenceLine() {
        return this.billingReferenceLine;
    }

    public void setBillingReferenceLine(List<BillingReferenceLineRepresentation> billingReferenceLine) {
        this.billingReferenceLine = billingReferenceLine;
    }

    public DocumentReferenceRepresentation getCreditNoteDocumentReference() {
        return this.creditNoteDocumentReference;
    }

    public void setCreditNoteDocumentReference(DocumentReferenceRepresentation creditNoteDocumentReference) {
        this.creditNoteDocumentReference = creditNoteDocumentReference;
    }

    public DocumentReferenceRepresentation getAdditionalDocumentReference() {
        return this.additionalDocumentReference;
    }

    public void setAdditionalDocumentReference(DocumentReferenceRepresentation additionalDocumentReference) {
        this.additionalDocumentReference = additionalDocumentReference;
    }

    public DocumentReferenceRepresentation getSelfBilledCreditNoteDocumentReference() {
        return this.selfBilledCreditNoteDocumentReference;
    }

    public void setSelfBilledCreditNoteDocumentReference(
            DocumentReferenceRepresentation selfBilledCreditNoteDocumentReference) {
        this.selfBilledCreditNoteDocumentReference = selfBilledCreditNoteDocumentReference;
    }

    public DocumentReferenceRepresentation getDebitNoteDocumentReference() {
        return this.debitNoteDocumentReference;
    }

    public void setDebitNoteDocumentReference(DocumentReferenceRepresentation debitNoteDocumentReference) {
        this.debitNoteDocumentReference = debitNoteDocumentReference;
    }

    public DocumentReferenceRepresentation getSelfBilledInvoiceDocumentReference() {
        return this.selfBilledInvoiceDocumentReference;
    }

    public void setSelfBilledInvoiceDocumentReference(
            DocumentReferenceRepresentation selfBilledInvoiceDocumentReference) {
        this.selfBilledInvoiceDocumentReference = selfBilledInvoiceDocumentReference;
    }

    public DocumentReferenceRepresentation getReminderDocumentReference() {
        return this.reminderDocumentReference;
    }

    public void setReminderDocumentReference(DocumentReferenceRepresentation reminderDocumentReference) {
        this.reminderDocumentReference = reminderDocumentReference;
    }
}