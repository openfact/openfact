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

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue(value = "DEBIT_NOTE")
@NamedQueries(value = {
        @NamedQuery(name = "getAllAttachedDocumentByDebitNoteId", query = "select s from DebitNoteAttatchedDocumentEntity s where debitNote.id=:debitNoteId"),
        @NamedQuery(name = "deleteDebitNoteAttatchedDocumentByOrganization", query = "delete from DebitNoteAttatchedDocumentEntity doc where doc.debitNote IN (select i from DebitNoteEntity i where i.organizationId=:organizationId)"),
        @NamedQuery(name = "deleteDebitNoteAttachedDocumentsByOrganizationTypeAndDocumentId", query = "delete from DebitNoteAttatchedDocumentEntity doc where doc.documentType=:documentType and doc.documentId=:documentId and doc.debitNote IN (select i from DebitNoteEntity i where i.organizationId=:organizationId)")
})
public class DebitNoteAttatchedDocumentEntity extends AttatchedDocumentEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "DEBIT_NOTE")
    private DebitNoteEntity debitNote;

    public DebitNoteEntity getDebitNote() {
        return debitNote;
    }

    public void setDebitNote(DebitNoteEntity debitNote) {
        this.debitNote = debitNote;
    }
}
