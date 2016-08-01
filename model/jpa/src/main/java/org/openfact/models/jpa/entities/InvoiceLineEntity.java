package org.openfact.models.jpa.entities;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;
import org.openfact.models.enums.TaxType;

@Table(name = "INVOICE_LINE")
@Entity
public class InvoiceLineEntity {

    @Id
    @Column(name = "ID", length = 36)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    private String id;

    // Numero de orden del item
    @NotNull
    @Column(name = "ORDER_NUMBER")
    private int orderNumber;

    // Cantidad
    @NotNull
    @Column(name = "QUANTITY")
    private double quantity;

    // Unidad de medida
    @NotNull
    @Column(name = "UNIT_CODE")
    private String unitCode;

    // No incluye tributos(igv, isc y otros tributos), cargos o descuentos
    @NotNull
    @Column(name = "PRICE")
    private BigDecimal price;

    // Subtotal
    @Formula(value = "QUANTITY * PRICE")
    @Column(name = "EXTENSION_AMMOUNT")
    private BigDecimal extensionAmmount;

    // Incluye incluye tributos (igv, isc y otros tributos), cargos y descuentos
    @Column(name = "AMMOUNT")
    private BigDecimal ammount;

    // Descripcion del producto o servicio
    @NotNull
    @Column(name = "ITEM_DESCRIPTION")
    private String itemDescription;

    // Codigo del producto
    @Column(name = "ITEM_IDENTIFICATION")
    private String itemIdentification;

    // Impuestos como igv, isc y otros
    @NotEmpty
    @ElementCollection
    @MapKeyColumn(name = "NAME")
    @Column(name = "VALUE")
    @CollectionTable(name = "TAX_SUBTOTAL", joinColumns = { @JoinColumn(name = "TAX_SUBTOTAL_ID") })
    private Map<TaxType, BigDecimal> taxs = new HashMap<>();

    // Cargos o Descuentos del item
    @Column(name = "ALLOWANCE_CHARGE")
    private BigDecimal allowanceCharge;

    // Invoice
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "INVOICE_ID")
    private InvoiceEntity invoice;

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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
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

    public BigDecimal getExtensionAmmount() {
        return extensionAmmount;
    }

    public void setExtensionAmmount(BigDecimal extensionAmmount) {
        this.extensionAmmount = extensionAmmount;
    }

    public BigDecimal getAmmount() {
        return ammount;
    }

    public void setAmmount(BigDecimal ammount) {
        this.ammount = ammount;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Map<TaxType, BigDecimal> getTaxs() {
        return taxs;
    }

    public void setTaxs(Map<TaxType, BigDecimal> taxs) {
        this.taxs = taxs;
    }

    public String getItemIdentification() {
        return itemIdentification;
    }

    public void setItemIdentification(String itemIdentification) {
        this.itemIdentification = itemIdentification;
    }

    public BigDecimal getAllowanceCharge() {
        return allowanceCharge;
    }

    public void setAllowanceCharge(BigDecimal allowanceCharge) {
        this.allowanceCharge = allowanceCharge;
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
        InvoiceLineEntity other = (InvoiceLineEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
