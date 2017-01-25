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

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
@NamedQueries({
        @NamedQuery(name = "deleteInvoiceRequiredActionsByOrganization", query = "delete from InvoiceRequiredActionEntity action where action.invoice IN (select u from UblDocumentEntity u where u.organizationId=:organizationId)")
})
@Entity
@Table(name = "INVOICE_REQUIRED_ACTION")
@IdClass(InvoiceRequiredActionEntity.Key.class)
public class InvoiceRequiredActionEntity {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INVOICE_ID")
    protected UblDocumentEntity invoice;

    @Id
    @Column(name = "REQUIRED_ACTION")
    protected String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public UblDocumentEntity getInvoice() {
        return invoice;
    }

    public void setInvoice(UblDocumentEntity invoice) {
        this.invoice = invoice;
    }

    public static class Key implements Serializable {

        protected UblDocumentEntity invoice;

        protected String action;

        public Key() {
        }

        public Key(UblDocumentEntity invoice, String action) {
            this.invoice = invoice;
            this.action = action;
        }

        public UblDocumentEntity getInvoice() {
            return invoice;
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
            if (invoice != null ? !invoice.getId().equals(key.invoice != null ? key.invoice.getId() : null) : key.invoice != null)
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
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof InvoiceRequiredActionEntity)) return false;

        InvoiceRequiredActionEntity key = (InvoiceRequiredActionEntity) o;

        if (action != key.action) return false;
        if (invoice != null ? !invoice.getId().equals(key.invoice != null ? key.invoice.getId() : null) : key.invoice != null)
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
