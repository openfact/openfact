package org.openfact.models.jpa.entities.ubl;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

@Entity
@Table(name = "CREDIT_NOTE_ATTRIBUTE")
@NamedQueries({
        @NamedQuery(name = "getCreditNoteAttributesByNameAndValue", query = "select attr from CreditNoteAttributeEntity attr where attr.name = :name and attr.value = :value"),
        @NamedQuery(name = "deleteCreditNoteAttributesByOrganization", query = "delete from  CreditNoteAttributeEntity attr where attr.creditNote IN (select u from CreditNoteEntity u where u.organization.id=:organizationId)"),
        @NamedQuery(name = "deleteCreditNoteAttributesByNameAndCreditNote", query = "delete from  CreditNoteAttributeEntity attr where attr.creditNote.id = :creditNoteId and attr.name = :name"),
        @NamedQuery(name = "deleteCreditNoteAttributesOtherThan", query = "delete from  CreditNoteAttributeEntity attr where attr.creditNote.id = :creditNoteId and attr.id <> :attrId") })
public class CreditNoteAttributeEntity {

    @Id
    @Column(name = "ID", length = 36)
    @Access(AccessType.PROPERTY)
    protected String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    protected CreditNoteEntity creditNote;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "VALUE")
    protected String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public CreditNoteEntity getCreditNote() {
        return creditNote;
    }

    public void setCreditNote(CreditNoteEntity creditNote) {
        this.creditNote = creditNote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (!(o instanceof CreditNoteAttributeEntity))
            return false;

        CreditNoteAttributeEntity that = (CreditNoteAttributeEntity) o;

        if (!id.equals(that.getId()))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
