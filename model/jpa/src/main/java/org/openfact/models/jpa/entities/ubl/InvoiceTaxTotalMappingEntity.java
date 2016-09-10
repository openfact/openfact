package org.openfact.models.jpa.entities.ubl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * A document used to request payment.
 * 
 * @author carlosthe19916@sistcoop.com
 * @version 2.0
 * @created 07-Set.-2016 9:20:49 a. m.
 */

@Table(name = "INVOICE_TAXTOTAL_MAPPING")
@Entity
@IdClass(InvoiceTaxTotalMappingEntity.Key.class)
public class InvoiceTaxTotalMappingEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INVOICE_ID")
    protected InvoiceEntity invoice;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taxTotal_ID")
    protected TaxTotalEntity taxTotal;

    /**
     * @return the invoice
     */
    public InvoiceEntity getInvoice() {
        return invoice;
    }

    /**
     * @param invoice
     *            the invoice to set
     */
    public void setInvoice(InvoiceEntity invoice) {
        this.invoice = invoice;
    }

    /**
     * @return the taxTotal
     */
    public TaxTotalEntity getTaxTotal() {
        return taxTotal;
    }

    /**
     * @param taxTotal
     *            the taxTotal to set
     */
    public void setTaxTotal(TaxTotalEntity taxTotal) {
        this.taxTotal = taxTotal;
    }

    public static class Key implements Serializable {

        protected InvoiceEntity invoice;

        protected TaxTotalEntity taxTotal;

        public Key() {

        }

        public Key(InvoiceEntity invoice, TaxTotalEntity taxTotal) {
            this.invoice = invoice;
            this.taxTotal = taxTotal;
        }

        /**
         * @return the invoice
         */
        public InvoiceEntity getInvoice() {
            return invoice;
        }

        /**
         * @return the taxTotal
         */
        public TaxTotalEntity getTaxTotal() {
            return taxTotal;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Key key = (Key) o;

            if (invoice != null ? !invoice.getId().equals(key.invoice != null ? key.invoice.getId() : null)
                    : key.invoice != null)
                return false;
            if (taxTotal != null
                    ? !taxTotal.getId().equals(key.taxTotal != null ? key.taxTotal.getId() : null)
                    : key.taxTotal != null)
                return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = invoice != null ? invoice.getId().hashCode() : 0;
            result = 31 * result + (taxTotal != null ? taxTotal.getId().hashCode() : 0);
            return result;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (!(o instanceof InvoiceTaxTotalMappingEntity))
            return false;

        InvoiceTaxTotalMappingEntity key = (InvoiceTaxTotalMappingEntity) o;

        if (invoice != null ? !invoice.getId().equals(key.invoice != null ? key.invoice.getId() : null)
                : key.invoice != null)
            return false;
        if (taxTotal != null ? !taxTotal.getId().equals(key.taxTotal != null ? key.taxTotal.getId() : null)
                : key.taxTotal != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = invoice != null ? invoice.getId().hashCode() : 0;
        result = 31 * result + (taxTotal != null ? taxTotal.getId().hashCode() : 0);
        return result;
    }

}
