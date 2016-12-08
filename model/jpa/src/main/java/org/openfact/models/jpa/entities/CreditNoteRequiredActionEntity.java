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
import java.io.Serializable;

@NamedQueries({
        @NamedQuery(name = "deleteCreditNoteRequiredActionsByOrganization", query = "delete from CreditNoteRequiredActionEntity action where action.creditNote IN (select u from CreditNoteEntity u where u.organizationId=:organizationId)")
})
@Entity
@Table(name = "CREDIT_NOTE_REQUIRED_ACTION")
@IdClass(CreditNoteRequiredActionEntity.Key.class)
public class CreditNoteRequiredActionEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREDIT_NOTE_ID")
    protected CreditNoteEntity creditNote;

    @Id
    @Column(name = "REQUIRED_ACTION")
    protected String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public CreditNoteEntity getCreditNote() {
        return creditNote;
    }

    public void setCreditNote(CreditNoteEntity creditNote) {
        this.creditNote = creditNote;
    }

    public static class Key implements Serializable {
        
        protected CreditNoteEntity creditNote;

        protected String action;

        public Key() {
        }

        public Key(CreditNoteEntity creditNote, String action) {
            this.creditNote = creditNote;
            this.action = action;
        }

        public CreditNoteEntity getCreditNote() {
            return creditNote;
        }

        public String getAction() {
            return action;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            if (action != key.action) return false;
            if (creditNote != null ? !creditNote.getId().equals(key.creditNote != null ? key.creditNote.getId() : null) : key.creditNote != null)
                return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = creditNote != null ? creditNote.getId().hashCode() : 0;
            result = 31 * result + (action != null ? action.hashCode() : 0);
            return result;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof CreditNoteRequiredActionEntity)) return false;

        CreditNoteRequiredActionEntity key = (CreditNoteRequiredActionEntity) o;

        if (action != key.action) return false;
        if (creditNote != null ? !creditNote.getId().equals(key.creditNote != null ? key.creditNote.getId() : null) : key.creditNote != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = creditNote != null ? creditNote.getId().hashCode() : 0;
        result = 31 * result + (action != null ? action.hashCode() : 0);
        return result;
    }
    
}
