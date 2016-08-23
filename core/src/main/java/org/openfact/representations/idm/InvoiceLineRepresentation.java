
package org.openfact.representations.idm;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class InvoiceLineRepresentation {

    private String id;
    private Integer orderNumber;
    private BigDecimal quantity;
    private String unitCode;
    private BigDecimal price;
    private BigDecimal ammount;
    private String itemDescription;
    private String itemIdentification;
    private BigDecimal allowanceCharge;

    private Set<InvoiceLineTotalTaxRepresentation> totalTaxs = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
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

    public Set<InvoiceLineTotalTaxRepresentation> getTotalTaxs() {
        return totalTaxs;
    }

    public void setTotalTaxs(Set<InvoiceLineTotalTaxRepresentation> totalTaxs) {
        this.totalTaxs = totalTaxs;
    }

}
