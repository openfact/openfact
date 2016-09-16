package org.openfact.representations.idm.ubl.common;

import java.math.BigDecimal;
import java.util.List;

public class TaxTotalModel {
    protected BigDecimal TaxAmount;
    protected BigDecimal RoundingAmount;
    protected boolean TaxEvidenceIndicator;
    protected List<TaxSubtotalModel> TaxSubtotal;
    protected String Id;
}