package org.openfact.ubl;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.InvoiceLineType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

import java.math.BigDecimal;
import java.util.List;

@XmlClass(element = "InvoiceLine")
public class XmlUBlDocumentLine {

    @XmlField(key = {"InvoicedQuantity", "content"})
    private BigDecimal invoiced_quantity;

    @XmlField(key = {"InvoicedQuantity", "unitCode"})
    private String unit_code;

    @XmlField(key = {"LineExtensionAmount", "content"})
    private BigDecimal line_extension_amount;

    @XmlArrayField(keys = {"TaxTotal"}, key = {"TaxAmount", "content"})
    private List<BigDecimal> tt_tax_amount;

    @XmlArrayField(keys = {"Item"}, key = {"Description"})
    private List<String> item_description;

    @XmlArrayField(keys = {"PricingReference", "AlternativeConditionPrice"}, key = {"PriceAmount", "content"})
    private List<BigDecimal> pricing_reference_acp_price_amount;

    @XmlField(key = {"Price", "PriceAmount", "content"})
    private BigDecimal price_price_amount;

    public BigDecimal getInvoiced_quantity() {
        return invoiced_quantity;
    }

    public void setInvoiced_quantity(BigDecimal invoiced_quantity) {
        this.invoiced_quantity = invoiced_quantity;
    }

    public String getUnit_code() {
        return unit_code;
    }

    public void setUnit_code(String unit_code) {
        this.unit_code = unit_code;
    }

    public BigDecimal getLine_extension_amount() {
        return line_extension_amount;
    }

    public void setLine_extension_amount(BigDecimal line_extension_amount) {
        this.line_extension_amount = line_extension_amount;
    }

    public List<BigDecimal> getTt_tax_amount() {
        return tt_tax_amount;
    }

    public void setTt_tax_amount(List<BigDecimal> tt_tax_amount) {
        this.tt_tax_amount = tt_tax_amount;
    }

    public List<String> getItem_description() {
        return item_description;
    }

    public void setItem_description(List<String> item_description) {
        this.item_description = item_description;
    }

    public List<BigDecimal> getPricing_reference_acp_price_amount() {
        return pricing_reference_acp_price_amount;
    }

    public void setPricing_reference_acp_price_amount(List<BigDecimal> pricing_reference_acp_price_amount) {
        this.pricing_reference_acp_price_amount = pricing_reference_acp_price_amount;
    }

    public BigDecimal getPrice_price_amount() {
        return price_price_amount;
    }

    public void setPrice_price_amount(BigDecimal price_price_amount) {
        this.price_price_amount = price_price_amount;
    }
}
