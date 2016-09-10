package org.openfact.models.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a set of payment terms.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:41 a. m.
 */
public class PaymentTermsModel{

	/**
	 * The monetary amount covered by these payment terms.
	 */
	private BigDecimal amount; 
	/**
	 * An identifier for this set of payment terms.
	 */
	private IdentifierType ID; 
	/**
	 * The due date for an installment payment for these payment terms.
	 */
	private LocalDate installmentDueDate; 
	/**
	 * A reference to the payment terms used by the invoicing party. This may have
	 * been requested of the payer by the payee to accompany its remittance.
	 */
	private TextType invoicingPartyReference; 
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType note; 
	/**
	 * The due date for these payment terms.
	 */
	private LocalDate paymentDueDate; 
	/**
	 * An identifier for a means of payment associated with these payment terms.
	 */
	private IdentifierType paymentMeansID; 
	/**
	 * The part of a payment, expressed as a percent, relevant for these payment terms.
	 */
	private BigDecimal paymentPercent; 
	/**
	 * The Uniform Resource Identifier (URI) of a document providing additional
	 * details regarding these payment terms.
	 */
	private IdentifierType paymentTermsDetailsURIID; 
	/**
	 * The monetary amount of the penalty for payment after the settlement period.
	 */
	private BigDecimal penaltyAmount; 
	/**
	 * The penalty for payment after the settlement period, expressed as a percentage
	 * of the payment.
	 */
	private BigDecimal penaltySurchargePercent; 
	/**
	 * An identifier for a reference to a prepaid payment.
	 */
	private IdentifierType prepaidPaymentReferenceID; 
	/**
	 * A code signifying the event during which these terms are offered.
	 */
	private CodeType referenceEventCode; 
	/**
	 * The amount of a settlement discount offered for payment under these payment
	 * terms.
	 */
	private BigDecimal settlementDiscountAmount; 
	/**
	 * The percentage for the settlement discount that is offered for payment under
	 * these payment terms.
	 */
	private BigDecimal settlementDiscountPercent; 
	private List<ExchangeRateModel> exchangeRates = new ArrayList<>(); 
	private PeriodModel settlementPeriod; 
	private PeriodModel penaltyPeriod; 
	private PeriodModel validityPeriod; 

}
