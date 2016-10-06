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
@Table(name = "INVOICE_ATTRIBUTE")
@NamedQueries({
        @NamedQuery(name = "getInvoiceAttributesByNameAndValue", query = "select attr from InvoiceAttributeEntity attr where attr.name = :name and attr.value = :value"),
        @NamedQuery(name = "deleteInvoiceAttributesByOrganization", query = "delete from  InvoiceAttributeEntity attr where attr.invoice IN (select u from InvoiceEntity u where u.organization.id=:organizationId)"),
        @NamedQuery(name = "deleteInvoiceAttributesByNameAndInvoice", query = "delete from  InvoiceAttributeEntity attr where attr.invoice.id = :invoiceId and attr.name = :name"),
        @NamedQuery(name = "deleteInvoiceAttributesOtherThan", query = "delete from  InvoiceAttributeEntity attr where attr.invoice.id = :invoiceId and attr.id <> :attrId") })
public class InvoiceAttributeEntity {

    @Id
    @Column(name = "ID", length = 36)
    @Access(AccessType.PROPERTY)
    protected String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    protected InvoiceEntity invoice;

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

    public InvoiceEntity getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceEntity invoice) {
        this.invoice = invoice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (!(o instanceof InvoiceAttributeEntity))
            return false;

        InvoiceAttributeEntity that = (InvoiceAttributeEntity) o;

        if (!id.equals(that.getId()))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
