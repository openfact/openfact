package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe the total tax for a particular taxation scheme.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:07 a. m.
 */
public class TaxTotalRepresentation {

    /**
     * The rounding amount (positive or negative) added to the calculated tax
     * total to produce the rounded TaxAmount.
     */
    private BigDecimal roundingAmount;
    /**
     * The total tax amount for a particular taxation scheme, e.g., VAT; the sum
     * of the tax subtotals for each tax category within the taxation scheme.
     */
    private BigDecimal taxAmount;
    /**
     * An indicator that this total is recognized as legal evidence for taxation
     * purposes (true) or not (false).
     */
    private boolean taxEvidenceIndicator;
    /**
     * An indicator that tax is included in the calculation (true) or not
     * (false).
     */
    private boolean taxIncludedIndicator;
    private List<TaxSubtotalRepresentation> taxSubtotals = new ArrayList<>();

}
