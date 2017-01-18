package org.openfact.ubl.data.xml.entity;

import org.openfact.ubl.data.xml.annotations.ArrayKey;
import org.openfact.ubl.data.xml.annotations.JsonWrapper;
import org.openfact.ubl.data.xml.annotations.SimpleKey;
import org.openfact.ubl.data.xml.mappers.BigdecimalMapper;
import org.openfact.ubl.data.xml.mappers.StringMapper;

import java.math.BigDecimal;
import java.util.List;

@JsonWrapper
public class XmlCreditNoteDocumentLineEntity {

    @SimpleKey(key = {"CreditedQuantity", "content"}, mapper = BigdecimalMapper.class)
    private BigDecimal of_credited_quantity;

    @SimpleKey(key = {"CreditedQuantity", "unitCode"}, mapper = StringMapper.class)
    private String of_unit_code;

    @SimpleKey(key = {"LineExtensionAmount", "content"}, mapper = BigdecimalMapper.class)
    private BigDecimal of_line_extension_amount;

    @ArrayKey(arrayKey = {"TaxTotal"}, fieldKey = {"TaxAmount", "content"}, mapper = BigdecimalMapper.class)
    private List<BigDecimal> of_tt_tax_amount;

    @ArrayKey(arrayKey = {"Item"}, fieldKey = {"Description"}, mapper = StringMapper.class)
    private List<String> of_item_description;

    @ArrayKey(arrayKey = {"PricingReference", "AlternativeConditionPrice"}, fieldKey = {"PriceAmount", "content"}, mapper = BigdecimalMapper.class)
    private List<BigDecimal> of_pricing_reference_acp_price_amount;

    @SimpleKey(key = {"Price", "PriceAmount", "content"}, mapper = BigdecimalMapper.class)
    private BigDecimal of_price_amount;


    public BigDecimal getOf_credited_quantity() {
        return of_credited_quantity;
    }

    public void setOf_credited_quantity(BigDecimal of_credited_quantity) {
        this.of_credited_quantity = of_credited_quantity;
    }

    public String getOf_unit_code() {
        return of_unit_code;
    }

    public void setOf_unit_code(String of_unit_code) {
        this.of_unit_code = of_unit_code;
    }

    public BigDecimal getOf_line_extension_amount() {
        return of_line_extension_amount;
    }

    public void setOf_line_extension_amount(BigDecimal of_line_extension_amount) {
        this.of_line_extension_amount = of_line_extension_amount;
    }

    public List<BigDecimal> getOf_tt_tax_amount() {
        return of_tt_tax_amount;
    }

    public void setOf_tt_tax_amount(List<BigDecimal> of_tt_tax_amount) {
        this.of_tt_tax_amount = of_tt_tax_amount;
    }

    public List<String> getOf_item_description() {
        return of_item_description;
    }

    public void setOf_item_description(List<String> of_item_description) {
        this.of_item_description = of_item_description;
    }

    public List<BigDecimal> getOf_pricing_reference_acp_price_amount() {
        return of_pricing_reference_acp_price_amount;
    }

    public void setOf_pricing_reference_acp_price_amount(List<BigDecimal> of_pricing_reference_acp_price_amount) {
        this.of_pricing_reference_acp_price_amount = of_pricing_reference_acp_price_amount;
    }

    public BigDecimal getOf_price_amount() {
        return of_price_amount;
    }

    public void setOf_price_amount(BigDecimal of_price_amount) {
        this.of_price_amount = of_price_amount;
    }
}
