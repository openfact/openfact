package org.openfact.models.xml;

import java.math.BigDecimal;

import org.openfact.models.enums.*;
import org.openfact.models.ubl.CurrencyCodeContentType;
/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 27/07/2016.
 */
public class XmlInvoiceDetails {
    private String id;
    private String invoicedQuantityUnitCode;
    private BigDecimal invoicedQuantityMonto;
    private CurrencyCodeContentType lineExtensionAmountCurrencyCode;
    private BigDecimal lineExtensionAmountMonto;
    private CurrencyCodeContentType priceAmountCurrencyCode;
    private BigDecimal priceAmountMonto;
    private AdditionalInformationType priceTypeCode;
    private BigDecimal taxTotalTaxAmountMonto;
    private CurrencyCodeContentType taxTotalTaxAmountCodigo;
    private BigDecimal taxTotalTaxSubtotalTaxAmountMonto;
    private CurrencyCodeContentType taxTotalTaxSubtotalTaxAmountCodigo;
    private TaxType categoryTaxScheme;
    private CodigoTipoAfectacionIgv taxExemptionReasonCode;
    private String ItemDescription;
    private String ItemDescriptionSellersItemIdentificationId;
    private BigDecimal pricePriceAmountMonto;
    private CurrencyCodeContentType PricePriceAmountCodigo;

    public void setInvoicedQuantity(String codigo, BigDecimal monto) {
        invoicedQuantityUnitCode = codigo;
        invoicedQuantityMonto = monto;
    }

    public void setLineExtensionAmount(CurrencyCodeContentType codigo, BigDecimal monto) {
        lineExtensionAmountCurrencyCode = codigo;
        lineExtensionAmountMonto = monto;
    }

    public void setPricingReferenceAlternativeConditionPricePriceAmount(CurrencyCodeContentType codigo, BigDecimal monto) {
        priceAmountCurrencyCode = codigo;
        priceAmountMonto = monto;
    }

    public void setPricingReferenceAlternativeConditionPricePriceTypeCode(AdditionalInformationType codigo) {
        priceTypeCode = codigo;
    }

    public void setTaxTotalTaxAmount(BigDecimal monto, CurrencyCodeContentType codigo) {
        taxTotalTaxAmountMonto = monto;
        taxTotalTaxAmountCodigo = codigo;
    }

    public void setTaxTotalTaxSubtotalTaxAmount(BigDecimal monto, CurrencyCodeContentType codigo) {
        taxTotalTaxSubtotalTaxAmountMonto = monto;
        taxTotalTaxSubtotalTaxAmountCodigo = codigo;
    }

    public void setTaxTotalTaxSubtotalTaxCategoryTaxScheme(TaxType codigo) {
        categoryTaxScheme = codigo;
    }

    public void setTaxTotalTaxSubtotalTaxCategoryTaxExemptionReasonCode(CodigoTipoAfectacionIgv codigo) {
        taxExemptionReasonCode = codigo;
    }

    public void setPricePriceAmount(BigDecimal monto, CurrencyCodeContentType codigo) {
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

    public CurrencyCodeContentType getLineExtensionAmountCurrencyCode() {
        return lineExtensionAmountCurrencyCode;
    }

    public BigDecimal getLineExtensionAmountMonto() {
        return lineExtensionAmountMonto;
    }

    public CurrencyCodeContentType getPriceAmountCurrencyCode() {
        return priceAmountCurrencyCode;
    }

    public BigDecimal getPriceAmountMonto() {
        return priceAmountMonto;
    }

    public AdditionalInformationType getPriceTypeCode() {
        return priceTypeCode;
    }

    public BigDecimal getTaxTotalTaxAmountMonto() {
        return taxTotalTaxAmountMonto;
    }

    public CurrencyCodeContentType getTaxTotalTaxAmountCodigo() {
        return taxTotalTaxAmountCodigo;
    }

    public BigDecimal getTaxTotalTaxSubtotalTaxAmountMonto() {
        return taxTotalTaxSubtotalTaxAmountMonto;
    }

    public CurrencyCodeContentType getTaxTotalTaxSubtotalTaxAmountCodigo() {
        return taxTotalTaxSubtotalTaxAmountCodigo;
    }

    public TaxType getCategoryTaxScheme() {
        return categoryTaxScheme;
    }

    public CodigoTipoAfectacionIgv getTaxExemptionReasonCode() {
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

    public CurrencyCodeContentType getPricePriceAmountCodigo() {
        return PricePriceAmountCodigo;
    }
}
