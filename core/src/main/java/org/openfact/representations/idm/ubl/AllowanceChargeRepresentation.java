package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe information about a charge or discount as applied to a
 * price component.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:12:43 a. m.
 */
public class AllowanceChargeRepresentation {

    /**
     * The accounting cost centre used by the buyer to account for this
     * allowance or charge, expressed as text.
     */
    private TextRepresentation accountingCost;
    /**
     * The accounting cost centre used by the buyer to account for this
     * allowance or charge, expressed as a code.
     */
    private CodeRepresentation accountingCostCode;
    /**
     * The reason for this allowance or charge.
     */
    private TextRepresentation allowanceChargeReason;
    /**
     * A mutually agreed code signifying the reason for this allowance or
     * charge.
     */
    private AllowanceChargeRepresentation reason_CodeTypeAllowanceChargeReasonCode;
    /**
     * The monetary amount of this allowance or charge to be applied.
     */
    private BigDecimal amount;
    /**
     * The monetary amount to which the multiplier factor is applied in
     * calculating the amount of this allowance or charge.
     */
    private BigDecimal baseAmount;
    /**
     * An indicator that this AllowanceChargeRepresentation describes a charge
     * (true) or a discount (false).
     */
    private boolean chargeIndicator;
    /**
     * An identifier for this allowance or charge.
     */
    private IdentifierRepresentation ID;
    /**
     * A number by which the base amount is multiplied to calculate the actual
     * amount of this allowance or charge.
     */
    private BigDecimal multiplierFactorNumeric;
    /**
     * The allowance or charge per item; the total allowance or charge is
     * calculated by multiplying the per unit amount by the quantity of items,
     * either at the level of the individual transaction line or for the total
     * number of items in the document, depending o
     */
    private BigDecimal perUnitAmount;
    /**
     * An indicator that this allowance or charge is prepaid (true) or not
     * (false).
     */
    private boolean prepaidIndicator;
    /**
     * A number indicating the order of this allowance or charge in the sequence
     * of calculations applied when there are multiple allowances or charges.
     */
    private BigDecimal sequenceNumeric;
    private List<PaymentMeansRepresentation> paymentMeanses = new ArrayList<>();
    private List<TaxCategoryRepresentation> taxCategories = new ArrayList<>();
    private List<TaxTotalRepresentation> taxTotals = new ArrayList<>();

}
