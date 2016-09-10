package org.openfact.models.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe information about a charge or discount as applied to a
 * price component.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:12:43 a. m.
 */
public class AllowanceChargeModel{

	/**
	 * The accounting cost centre used by the buyer to account for this allowance or
	 * charge, expressed as text.
	 */
	private TextType accountingCost; 
	/**
	 * The accounting cost centre used by the buyer to account for this allowance or
	 * charge, expressed as a code.
	 */
	private CodeType accountingCostCode; 
	/**
	 * The reason for this allowance or charge.
	 */
	private TextType allowanceChargeReason; 
	/**
	 * A mutually agreed code signifying the reason for this allowance or charge.
	 */
	private AllowanceChargeModel reason_CodeTypeAllowanceChargeReasonCode; 
	/**
	 * The monetary amount of this allowance or charge to be applied.
	 */
	private BigDecimal amount; 
	/**
	 * The monetary amount to which the multiplier factor is applied in calculating
	 * the amount of this allowance or charge.
	 */
	private BigDecimal baseAmount; 
	/**
	 * An indicator that this AllowanceChargeModel describes a charge (true) or a discount
	 * (false).
	 */
	private boolean chargeIndicator; 
	/**
	 * An identifier for this allowance or charge.
	 */
	private IdentifierType ID; 
	/**
	 * A number by which the base amount is multiplied to calculate the actual amount
	 * of this allowance or charge.
	 */
	private BigDecimal multiplierFactorNumeric; 
	/**
	 * The allowance or charge per item; the total allowance or charge is calculated
	 * by multiplying the per unit amount by the quantity of items, either at the
	 * level of the individual transaction line or for the total number of items in
	 * the document, depending o
	 */
	private BigDecimal perUnitAmount; 
	/**
	 * An indicator that this allowance or charge is prepaid (true) or not (false).
	 */
	private boolean prepaidIndicator; 
	/**
	 * A number indicating the order of this allowance or charge in the sequence of
	 * calculations applied when there are multiple allowances or charges.
	 */
	private BigDecimal sequenceNumeric; 
	private List<PaymentMeansModel> paymentMeanses = new ArrayList<>(); 
	private List<TaxCategoryModel> taxCategories = new ArrayList<>(); 
	private List<TaxTotalModel> taxTotals = new ArrayList<>(); 

}
