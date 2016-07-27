
package org.openfact.representations.idm;

import java.math.BigDecimal;

public class InvoiceLineRepresentation {

    private String id;
    private int orderNumber;
    private double quantity;
    private String unitCode;
    private BigDecimal price;
    private BigDecimal ammount;
    private String itemDescription;
    private String itemIdentification;

    private BigDecimal igv;
    private BigDecimal isc;
    private BigDecimal otherTaxs;

    private BigDecimal allowanceCharge;

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

    public BigDecimal getIgv() {
        return igv;
    }

    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }

    public BigDecimal getIsc() {
        return isc;
    }

    public void setIsc(BigDecimal isc) {
        this.isc = isc;
    }

    public BigDecimal getOtherTaxs() {
        return otherTaxs;
    }

    public void setOtherTaxs(BigDecimal otherTaxs) {
        this.otherTaxs = otherTaxs;
    }

    public BigDecimal getAllowanceCharge() {
        return allowanceCharge;
    }

    public void setAllowanceCharge(BigDecimal allowanceCharge) {
        this.allowanceCharge = allowanceCharge;
    }

}
