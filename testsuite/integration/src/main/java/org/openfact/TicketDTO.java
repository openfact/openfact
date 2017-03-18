package org.openfact;

/**
 * Created by admin on 3/18/17.
 */
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.SupplierPartyType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.AdditionalAccountIDType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TicketDTO implements Serializable {

    InvoiceType a;
    AdditionalAccountIDType b;
    private Long id;

    private float price;

    public TicketDTO() {
        SupplierPartyType supplierPartyType = new SupplierPartyType();
        List<AdditionalAccountIDType> additionalAccountID = supplierPartyType.getAdditionalAccountID();
    }

    public TicketDTO(long id, float price) {

        this.id = id;
        this.price = price;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(final float price) {
        this.price = price;
    }

}
