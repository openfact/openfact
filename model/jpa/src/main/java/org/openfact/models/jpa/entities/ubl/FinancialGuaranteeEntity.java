package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import org.openfact.models.jpa.entities.ublType.*;

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
	private RateType amountRate;
	/**
	 * Text describing this financial guarantee.
	 */
	private TextType description;
	/**
	 * A code signifying the type of financial guarantee. For instance
	 * "Provisional Guarantee" or "Final Guarantee"
	 */
	private CodeType guaranteeTypeCode;
	/**
	 * The amount of liability in this financial guarantee.
	 */
	private BigDecimal liabilityAmount;
	private PeriodEntity constitutionPeriod;

}
