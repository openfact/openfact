
package org.openfact.representations.idm;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class InvoiceLineRepresentation {

    private String id;

    @Min(value = 1)
    private Integer orderNumber;

    @NotNull
    @Min(value = 0)
    private double quantity;

    @NotNull
    @Size(min = 1, max = 20)
    private String unitCode;

    @NotNull
    @Min(value = 0)
    private BigDecimal price;

    @Min(value = 0)
    private BigDecimal ammount;

    @NotNull
    @Size(min = 1, max = 200)
    private String itemDescription;

    @Size(min = 1, max = 100)
    private String itemIdentification;

    @NotNull
    @Min(value = 0)
    private BigDecimal igv;

    @Min(value = 0)
    private BigDecimal isc;

    @Min(value = 0)
    private BigDecimal otherTaxs;

    @Min(value = 0)
    private BigDecimal allowanceCharge;

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
