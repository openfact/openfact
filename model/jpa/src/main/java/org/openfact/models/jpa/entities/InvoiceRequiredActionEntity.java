package org.openfact.models.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "INVOICE_REQUIRED_ACTION")
/*@NamedQueries({
        @NamedQuery(name = "getInvoiceRequiredActions", query = "select action from InvoiceRequiredActionEntity action where action.invoice IN (select u from InvoiceEntity u)"),
        @NamedQuery(name = "getInvoiceRequiredActionsByActionName", query = "select action from InvoiceRequiredActionEntity action where action.invoice IN (select u from InvoiceEntity u) AND action.action=:actionName"),
        @NamedQuery(name = "getInvoiceRequiredActionsByActionNameAndOrganization", query = "select action from InvoiceRequiredActionEntity action where action.invoice IN (select u from InvoiceEntity u where u.organization.id=:organizationId) AND action.action=:actionName"),
        @NamedQuery(name = "deleteInvoiceRequiredActionsByOrganization", query = "delete from InvoiceRequiredActionEntity action where action.invoice IN (select u from InvoiceEntity u where u.organization.id=:organizationId)") })*/
@IdClass(InvoiceRequiredActionEntity.Key.class)
public class InvoiceRequiredActionEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INVOICE_ID")
    protected InvoiceEntityDEPRECATED invoice;

    @Id
    @Column(name = "REQUIRED_ACTION")
    protected String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public InvoiceEntityDEPRECATED getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceEntityDEPRECATED invoice) {
        this.invoice = invoice;
    }

    public static class Key implements Serializable {

        protected InvoiceEntityDEPRECATED invoice;

        protected String action;

        public Key() {
        }

        public Key(InvoiceEntityDEPRECATED invoice, String action) {
            this.invoice = invoice;
            this.action = action;
        }

        public InvoiceEntityDEPRECATED getInvoice() {
            return invoice;
        }

        public String getAction() {
            return action;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Key key = (Key) o;

            if (action != key.action)
                return false;
            if (invoice != null ? !invoice.getId().equals(key.invoice != null ? key.invoice.getId() : null)
                    : key.invoice != null)
                return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = invoice != null ? invoice.getId().hashCode() : 0;
            result = 31 * result + (action != null ? action.hashCode() : 0);
            return result;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (!(o instanceof InvoiceRequiredActionEntity))
            return false;

        InvoiceRequiredActionEntity key = (InvoiceRequiredActionEntity) o;

        if (action != key.action)
            return false;
        if (invoice != null ? !invoice.getId().equals(key.invoice != null ? key.invoice.getId() : null)
                : key.invoice != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = invoice != null ? invoice.getId().hashCode() : 0;
        result = 31 * result + (action != null ? action.hashCode() : 0);
        return result;
    }

}
