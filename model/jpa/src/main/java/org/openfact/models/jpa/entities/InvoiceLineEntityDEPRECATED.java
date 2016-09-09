package org.openfact.models.jpa.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author carlosthe19916@sistcoop.com
 */

@Entity
@Table(name = "INVOICE_LINE_DEPRECATED")
public class InvoiceLineEntityDEPRECATED {

    @Id
    @Column(name = "ID", length = 36)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    private String id;

    @Column(name = "ORDER_NUMBER")
    private int orderNumber;

    @Column(name = "QUANTITY")
    private BigDecimal quantity;

    @Column(name = "UNIT_CODE")
    private String unitCode;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Formula(value = "QUANTITY * PRICE")
    @Column(name = "EXTENSION_AMOUNT")
    private BigDecimal extensionAmount;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "ALLOWANCE_CHARGE")
    private BigDecimal allowanceCharge;

    @Column(name = "ITEM_DESCRIPTION")
    private String itemDescription;

    @Column(name = "ITEM_IDENTIFICATION")
    private String itemIdentification;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "INVOICE_ID")
    private InvoiceEntityDEPRECATED invoice;

    @OneToMany(mappedBy = "invoiceLine", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<InvoiceLineTaxTotalEntity> taxTotals = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getExtensionAmount() {
        return extensionAmount;
    }

    public void setExtensionAmmount(BigDecimal extensionAmount) {
        this.extensionAmount = extensionAmount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAllowanceCharge() {
        return allowanceCharge;
    }

    public void setAllowanceCharge(BigDecimal allowanceCharge) {
        this.allowanceCharge = allowanceCharge;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemIdentification() {
        return itemIdentification;
    }

    public void setItemIdentification(String itemIdentification) {
        this.itemIdentification = itemIdentification;
    }

    public InvoiceEntityDEPRECATED getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceEntityDEPRECATED invoice) {
        this.invoice = invoice;
    }

    public Set<InvoiceLineTaxTotalEntity> getTaxTotals() {
        return taxTotals;
    }

    public void setTaxTotals(Set<InvoiceLineTaxTotalEntity> taxTotals) {
        this.taxTotals = taxTotals;
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
        InvoiceLineEntityDEPRECATED other = (InvoiceLineEntityDEPRECATED) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
