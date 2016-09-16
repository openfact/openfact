package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public class TaxTotalRepresentation {
    private BigDecimal TaxAmount;
    private BigDecimal RoundingAmount;
    private boolean TaxEvidenceIndicator;
    private List<TaxSubtotalRepresentation> TaxSubtotal;
    private String Id;
}