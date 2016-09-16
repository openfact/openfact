package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public class TaxTotalRepresentation {
    private BigDecimal taxAmount;
    private BigDecimal roundingAmount;
    private boolean taxEvidenceIndicator;
    private List<TaxSubtotalRepresentation> taxSubtotal;
    private String id;
}
