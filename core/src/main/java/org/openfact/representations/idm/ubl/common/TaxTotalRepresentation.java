package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TaxTotalRepresentation {
    private BigDecimal taxAmount;
    private BigDecimal roundingAmount;
    private Boolean taxEvidenceIndicator;
    private List<TaxSubtotalRepresentation> taxSubtotal;
    private String id;

    /**/
    public void addTaxSubtotal(TaxSubtotalRepresentation representation) {
        if (taxSubtotal == null) {
            taxSubtotal = new ArrayList<>();
        }
        taxSubtotal.add(representation);
    }
    /**/

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getTaxAmount() {
        return this.taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Boolean getTaxEvidenceIndicator() {
        return this.taxEvidenceIndicator;
    }

    public void setTaxEvidenceIndicator(Boolean taxEvidenceIndicator) {
        this.taxEvidenceIndicator = taxEvidenceIndicator;
    }

    public List<TaxSubtotalRepresentation> getTaxSubtotal() {
        return this.taxSubtotal;
    }

    public void setTaxSubtotal(List<TaxSubtotalRepresentation> taxSubtotal) {
        this.taxSubtotal = taxSubtotal;
    }

    public BigDecimal getRoundingAmount() {
        return this.roundingAmount;
    }

    public void setRoundingAmount(BigDecimal roundingAmount) {
        this.roundingAmount = roundingAmount;
    }
}