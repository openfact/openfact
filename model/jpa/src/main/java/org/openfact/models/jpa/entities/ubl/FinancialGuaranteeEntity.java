package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.RateType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe the bond guarantee of a tenderer or bid submitter's
 * actual entry into a contract in the event that it is the successful bidder.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:13 a. m.
 */
public class FinancialGuaranteeEntity {

    /**
     * The rate used to calculate the amount of liability in this financial
     * guarantee.
     */
    private RateType AmountRate;
    /**
     * Text describing this financial guarantee.
     */
    private TextType Description;
    /**
     * A code signifying the type of financial guarantee. For instance
     * "Provisional Guarantee" or "Final Guarantee"
     */
    private CodeType GuaranteeTypeCode;
    /**
     * The amount of liability in this financial guarantee.
     */
    private AmountType LiabilityAmount;
    private PeriodEntity ConstitutionPeriod;

}
