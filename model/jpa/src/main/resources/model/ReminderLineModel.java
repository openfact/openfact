package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a ReminderModel document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:24 a. m.
 */
public class ReminderLineModel{

	/**
	 * The buyer's accounting cost centre for this reminder line, expressed as text.
	 */
	private TextType accountingCost; 
	/**
	 * The buyer's accounting cost centre for this reminder line, expressed as a code.
	 */
	private CodeType accountingCostCode; 
	/**
	 * The amount on this reminder line.
	 */
	private BigDecimal amount; 
	/**
	 * An indication that this reminder line contains a balance brought forward (true)
	 * or does not (false).
	 */
	private boolean balanceBroughtForwardIndicator; 
	/**
	 * The amount credited on this reminder line.
	 */
	private BigDecimal creditLineAmount; 
	/**
	 * The amount debited on this reminder line.
	 */
	private BigDecimal debitLineAmount; 
	/**
	 * An identifier for this reminder line.
	 */
	private IdentifierType ID; 
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType note; 
	/**
	 * A code signifying the business purpose for this payment.
	 */
	private CodeType paymentPurposeCode; 
	/**
	 * The penalty for late payment, expressed as a percentage.
	 */
	private BigDecimal penaltySurchargePercent; 
	/**
	 * A universally unique identifier for this reminder line.
	 */
	private IdentifierType UUID; 
	private List<BillingReferenceModel> billingReferences = new ArrayList<>(); 
	private List<ExchangeRateModel> exchangeRates = new ArrayList<>(); 
	private PeriodModel reminderPeriod; 

}
