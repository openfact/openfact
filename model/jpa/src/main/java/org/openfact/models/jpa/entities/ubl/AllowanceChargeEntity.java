package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.amountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.NumericType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe information about a charge or discount as applied to a
 * price component.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:12:43 a. m.
 */
public class AllowanceChargeEntity {

    /**
     * The accounting cost centre used by the buyer to account for this
     * allowance or charge, expressed as text.
     */
    private TextType accountingCost;
    /**
     * The accounting cost centre used by the buyer to account for this
     * allowance or charge, expressed as a code.
     */
    private CodeType accountingCostCode;
    /**
     * The reason for this allowance or charge.
     */
    private TextType allowanceChargeReason;
    /**
     * A mutually agreed code signifying the reason for this allowance or
     * charge.
     */
    private AllowanceChargeEntity Reason_CodeTypeallowanceChargeReasonCode;
    /**
     * The monetary amount of this allowance or charge to be applied.
     */
    private amountType amount;
    /**
     * The monetary amount to which the multiplier factor is applied in
     * calculating the amount of this allowance or charge.
     */
    private amountType Baseamount;
    /**
     * An indicator that this AllowanceChargeEntity describes a charge (true) or
     * a discount (false).
     */
    private IndicatorType chargeIndicator;
    /**
     * An identifier for this allowance or charge.
     */
    private IdentifierType ID;
    /**
     * A number by which the base amount is multiplied to calculate the actual
     * amount of this allowance or charge.
     */
    private NumericType multiplierFactorNumeric;
    /**
     * The allowance or charge per item; the total allowance or charge is
     * calculated by multiplying the per unit amount by the quantity of items,
     * either at the level of the individual transaction line or for the total
     * number of items in the document, depending o
     */
    private amountType PerUnitamount;
    /**
     * An indicator that this allowance or charge is prepaid (true) or not
     * (false).
     */
    private IndicatorType prepaidIndicator;
    /**
     * A number indicating the order of this allowance or charge in the sequence
     * of calculations applied when there are multiple allowances or charges.
     */
    private NumericType sequenceNumeric;
    private List<PaymentMeansEntity> paymentMeanses = new ArrayList<>();
    private List<TaxCategoryEntity> taxCategories = new ArrayList<>();
    private List<TaxTotalEntity> taxTotals = new ArrayList<>();

}
