package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.RateRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe the bond guarantee of a tenderer or bid submitter's
 * actual entry into a contract in the event that it is the successful bidder.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:13 a. m.
 */
public class FinancialGuaranteeRepresentation {

    /**
     * The rate used to calculate the amount of liability in this financial
     * guarantee.
     */
    private RateRepresentation amountRate;
    /**
     * Text describing this financial guarantee.
     */
    private TextRepresentation description;
    /**
     * A code signifying the type of financial guarantee. For instance
     * "Provisional Guarantee" or "Final Guarantee"
     */
    private CodeRepresentation guaranteeTypeCode;
    /**
     * The amount of liability in this financial guarantee.
     */
    private BigDecimal liabilityAmount;
    private PeriodRepresentation constitutionPeriod;

}
