package org.openfact.ubl.data.xml.entity;

import org.openfact.ubl.data.xml.annotations.ArrayKey;
import org.openfact.ubl.data.xml.annotations.JsonWrapper;
import org.openfact.ubl.data.xml.annotations.SimpleKey;
import org.openfact.ubl.data.xml.mappers.BigdecimalMapper;
import org.openfact.ubl.data.xml.mappers.StringMapper;

import java.math.BigDecimal;
import java.util.List;

@JsonWrapper(key = "InvoiceLine")
public class XmlDocumentLineEntity {

    @SimpleKey(key = {"InvoicedQuantity", "content"}, mapper = BigdecimalMapper.class)
    private BigDecimal invoiced_quantity;

    @SimpleKey(key = {"InvoicedQuantity", "unitCode"}, mapper = StringMapper.class)
    private String unit_code;

    @SimpleKey(key = {"LineExtensionAmount", "content"}, mapper = BigdecimalMapper.class)
    private BigDecimal line_extension_amount;

    @ArrayKey(arrayKey = {"TaxTotal"}, fieldKey = {"TaxAmount", "content"}, mapper = BigdecimalMapper.class)
    private List<BigDecimal> tt_tax_amount;

    @ArrayKey(arrayKey = {"Item"}, fieldKey = {"Description"}, mapper = StringMapper.class)
    private List<String> item_description;

    @ArrayKey(arrayKey = {"PricingReference", "AlternativeConditionPrice"}, fieldKey = {"PriceAmount", "content"}, mapper = BigdecimalMapper.class)
    private List<BigDecimal> pricing_reference_acp_price_amount;

    @SimpleKey(key = {"Price", "PriceAmount", "content"}, mapper = BigdecimalMapper.class)
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
