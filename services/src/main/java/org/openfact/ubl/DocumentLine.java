package org.openfact.ubl;

import java.math.BigDecimal;

public class DocumentLine {
    private BigDecimal invoiced_quantity;
    private String unit_code;
    private BigDecimal line_extension_amount;
    private BigDecimal tt_tax_amount;
    private String i_description;
    private BigDecimal pr_acp_price_amount;
    private BigDecimal p_price_amount;

    public BigDecimal getPr_acp_price_amount() {
        return pr_acp_price_amount;
    }

    public void setPr_acp_price_amount(BigDecimal pr_acp_price_amount) {
        this.pr_acp_price_amount = pr_acp_price_amount;
    }

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

    public BigDecimal getTt_tax_amount() {
        return tt_tax_amount;
    }

    public void setTt_tax_amount(BigDecimal tt_tax_amount) {
        this.tt_tax_amount = tt_tax_amount;
    }

    public String getI_description() {
        return i_description;
    }

    public void setI_description(String i_description) {
        this.i_description = i_description;
    }

    public BigDecimal getP_price_amount() {
        return p_price_amount;
    }

    public void setP_price_amount(BigDecimal p_price_amount) {
        this.p_price_amount = p_price_amount;
    }
}
