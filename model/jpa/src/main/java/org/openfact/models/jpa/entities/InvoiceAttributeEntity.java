package org.openfact.models.jpa.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "INVOICE_ATTRIBUTE")
/*@NamedQueries({
        @NamedQuery(name = "getAttributesByNameAndValue", query = "select attr from InvoiceAttributeEntity attr where attr.name = :name and attr.value = :value"),
        @NamedQuery(name = "deleteInvoiceAttributesByOrganization", query = "delete from  InvoiceAttributeEntity attr where attr.invoice IN (select u from InvoiceEntity u where u.organization.id=:organizationId)"),
        @NamedQuery(name = "deleteInvoiceAttributesByNameAndInvoice", query = "delete from  InvoiceAttributeEntity attr where attr.invoice.id = :invoiceId and attr.name = :name") })*/
public class InvoiceAttributeEntity {

    @Id
    @Column(name = "ID", length = 36)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    protected String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    protected InvoiceEntityDEPRECATED invoice;

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

    public InvoiceEntityDEPRECATED getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceEntityDEPRECATED invoice) {
        this.invoice = invoice;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InvoiceAttributeEntity other = (InvoiceAttributeEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
