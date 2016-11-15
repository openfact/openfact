package org.openfact.models.jpa.entities.ubl;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
@NamedQueries({
        @NamedQuery(name = "deleteDebitNoteRequiredActionsByOrganization", query = "delete from DebitNoteRequiredActionEntity action where action.debitNote IN (select u from DebitNoteEntity u where u.organization.id=:organizationId)")
})
@Entity
@Table(name = "DEBIT_NOTE_REQUIRED_ACTION")
@IdClass(DebitNoteRequiredActionEntity.Key.class)
public class DebitNoteRequiredActionEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEBIT_NOTE_ID")
    protected DebitNoteEntity debitNote;

    @Id
    @Column(name = "REQUIRED_ACTION")
    protected String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public DebitNoteEntity getDebitNote() {
        return debitNote;
    }

    public void setDebitNote(DebitNoteEntity debitNote) {
        this.debitNote = debitNote;
    }

    public static class Key implements Serializable {

        protected DebitNoteEntity debitNote;

        protected String action;

        public Key() {
        }

        public Key(DebitNoteEntity debitNote, String action) {
            this.debitNote = debitNote;
            this.action = action;
        }

        public DebitNoteEntity getDebitNote() {
            return debitNote;
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
            if (debitNote != null ? !debitNote.getId().equals(key.debitNote != null ? key.debitNote.getId() : null) : key.debitNote != null)
                return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = debitNote != null ? debitNote.getId().hashCode() : 0;
            result = 31 * result + (action != null ? action.hashCode() : 0);
            return result;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof DebitNoteRequiredActionEntity)) return false;

        DebitNoteRequiredActionEntity key = (DebitNoteRequiredActionEntity) o;

        if (action != key.action) return false;
        if (debitNote != null ? !debitNote.getId().equals(key.debitNote != null ? key.debitNote.getId() : null) : key.debitNote != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = debitNote != null ? debitNote.getId().hashCode() : 0;
        result = 31 * result + (action != null ? action.hashCode() : 0);
        return result;
    }

}
