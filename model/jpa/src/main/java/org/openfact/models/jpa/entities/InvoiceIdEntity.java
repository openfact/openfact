package org.openfact.models.jpa.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author carlosthe19916@sistcoop.com
 */

@Entity
@Table(name = "INVOICE_ID")
@NamedQueries({
        @NamedQuery(name = "getLastInvoiceIdSeriesByOrganization", query = "select max(invoiceId.series) from InvoiceIdEntity invoiceId inner join invoiceId.invoice invoice inner join invoice.organization organization where organization.id = :organizationId"),
        @NamedQuery(name = "getLastInvoiceIdNumberOfSeriesByOrganization", query = "select max(invoiceId.number) from InvoiceIdEntity invoiceId inner join invoiceId.invoice invoice inner join invoice.organization organization where organization.id = :organizationId and invoiceId.series = :series") })
public class InvoiceIdEntity {

    @Id
    @Access(AccessType.PROPERTY)
    @Column(name = "INVOICE_ID", length = 36)
    private String id;

    @NotNull
    @Column(name = "SERIES")
    private int series;

    @NotNull
    @Column(name = "NUMBER")
    private int number;

    @NotNull
    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INVOICE_ID")
    private InvoiceEntity invoice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public InvoiceEntity getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceEntity invoice) {
        this.invoice = invoice;
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
        InvoiceIdEntity other = (InvoiceIdEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
