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
@DiscriminatorValue(value = "CREDIT_NOTE")
@NamedQueries(value = {
        @NamedQuery(name = "getAllSendEventByCreditNoteId", query = "select s from CreditNoteSendEventEntity s where s.creditNote.id=:creditNoteId"),
        @NamedQuery(name = "getCreditNoteSendEventCountByCreditNote", query = "select count(s) from CreditNoteSendEventEntity s where s.creditNote.id = :creditNoteId"),
        @NamedQuery(name = "deleteCreditNoteSendEventByOrganization", query = "delete from CreditNoteSendEventEntity event where event.creditNote IN (select i from CreditNoteEntity i where i.organizationId=:organizationId)")
})
public class CreditNoteSendEventEntity extends SendEventEntity {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "CREDIT_NOTE_ID")
    private CreditNoteEntity creditNote;

    public CreditNoteEntity getCreditNote() {
        return creditNote;
    }

    public void setCreditNote(CreditNoteEntity creditNote) {
        this.creditNote = creditNote;
    }

}
