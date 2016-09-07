package org.openfact.ubl;

import java.math.BigDecimal;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.CurrencyCodeType;

public class DetalleFactura {

    private String id;
    private String invoicedQuantityUnitCode;
    private BigDecimal invoicedQuantityMonto;
    private CurrencyCodeType lineExtensionAmountCurrencyCode;
    private BigDecimal lineExtensionAmountMonto;
    private CurrencyCodeType priceAmountCurrencyCode;
    private BigDecimal priceAmountMonto;
    private String priceTypeCode;
    private BigDecimal taxTotalTaxAmountMonto;
    private CurrencyCodeType taxTotalTaxAmountCodigo;
    private BigDecimal taxTotalTaxSubtotalTaxAmountMonto;
    private CurrencyCodeType taxTotalTaxSubtotalTaxAmountCodigo;
    private String categoryTaxScheme;
    private String taxExemptionReasonCode;
    private String ItemDescription;
    private String ItemDescriptionSellersItemIdentificationId;
    private BigDecimal pricePriceAmountMonto;
    private CurrencyCodeType PricePriceAmountCodigo;

    public void setInvoicedQuantity(String codigo, BigDecimal monto) {
        invoicedQuantityUnitCode = codigo;
        invoicedQuantityMonto = monto;
    }

    public void setLineExtensionAmount(CurrencyCodeType codigo, BigDecimal monto) {
        lineExtensionAmountCurrencyCode = codigo;
        lineExtensionAmountMonto = monto;
    }

    public void setPricingReferenceAlternativeConditionPricePriceAmount(CurrencyCodeType codigo, BigDecimal monto) {
        priceAmountCurrencyCode = codigo;
        priceAmountMonto = monto;
    }

    public void setPricingReferenceAlternativeConditionPricePriceTypeCode(String codigo) {
        priceTypeCode = codigo;
    }

    public void setTaxTotalTaxAmount(BigDecimal monto, CurrencyCodeType codigo) {
        taxTotalTaxAmountMonto = monto;
        taxTotalTaxAmountCodigo = codigo;
    }

    public void setTaxTotalTaxSubtotalTaxAmount(BigDecimal monto, CurrencyCodeType codigo) {
        taxTotalTaxSubtotalTaxAmountMonto = monto;
        taxTotalTaxSubtotalTaxAmountCodigo = codigo;
    }

    public void setTaxTotalTaxSubtotalTaxCategoryTaxScheme(String codigo) {
        categoryTaxScheme = codigo;
    }

    public void setTaxTotalTaxSubtotalTaxCategoryTaxExemptionReasonCode(String codigo) {
        taxExemptionReasonCode = codigo;
    }

    public void setPricePriceAmount(BigDecimal monto, CurrencyCodeType codigo) {
        pricePriceAmountMonto = monto;
        PricePriceAmountCodigo = codigo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInvoicedQuantityUnitCode() {
        return invoicedQuantityUnitCode;
    }

    public BigDecimal getInvoicedQuantityMonto() {
        return invoicedQuantityMonto;
    }

    public CurrencyCodeType getLineExtensionAmountCurrencyCode() {
        return lineExtensionAmountCurrencyCode;
    }

    public BigDecimal getLineExtensionAmountMonto() {
        return lineExtensionAmountMonto;
    }

    public CurrencyCodeType getPriceAmountCurrencyCode() {
        return priceAmountCurrencyCode;
    }

    public BigDecimal getPriceAmountMonto() {
        return priceAmountMonto;
    }

    public String getPriceTypeCode() {
        return priceTypeCode;
    }

    public BigDecimal getTaxTotalTaxAmountMonto() {
        return taxTotalTaxAmountMonto;
    }

    public CurrencyCodeType getTaxTotalTaxAmountCodigo() {
        return taxTotalTaxAmountCodigo;
    }

    public BigDecimal getTaxTotalTaxSubtotalTaxAmountMonto() {
        return taxTotalTaxSubtotalTaxAmountMonto;
    }

    public CurrencyCodeType getTaxTotalTaxSubtotalTaxAmountCodigo() {
        return taxTotalTaxSubtotalTaxAmountCodigo;
    }

    public String getCategoryTaxScheme() {
        return categoryTaxScheme;
    }

    public String getTaxExemptionReasonCode() {
        return taxExemptionReasonCode;
    }

    public String getItemDescription() {
        return ItemDescription;
    }

    public void setItemDescription(String descripcion) {
        ItemDescription = descripcion;
    }

    public String getItemDescriptionSellersItemIdentificationId() {
        return ItemDescriptionSellersItemIdentificationId;
    }

    public void setItemDescriptionSellersItemIdentificationId(String codigoProducto) {
        ItemDescriptionSellersItemIdentificationId = codigoProducto;
    }

    public BigDecimal getPricePriceAmountMonto() {
        return pricePriceAmountMonto;
    }

    public CurrencyCodeType getPricePriceAmountCodigo() {
        return PricePriceAmountCodigo;
    }
}