package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a payment mandate.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:37 a. m.
 */
public class PaymentMandateModel{

	/**
	 * An identifier for this payment mandate.
	 */
	private IdentifierType ID; 
	/**
	 * A code signifying the type of this payment mandate.
	 */
	private CodeType mandateTypeCode; 
	/**
	 * The maximum amount to be paid within a single instruction.
	 */
	private BigDecimal maximumPaidAmount; 
	/**
	 * The number of maximum payment instructions allowed within the validity period.
	 */
	private BigDecimal maximumPaymentInstructionsNumeric; 
	/**
	 * An identifier for a signature applied by a signatory party.
	 */
	private IdentifierType signatureID; 
	private List<ClauseModel> clauses = new ArrayList<>(); 
	private FinancialAccountModel payerFinancialAccount; 
	private PartyModel payerParty; 
	private PeriodModel validityPeriod; 
	private PeriodModel paymentReversalPeriod; 

}
