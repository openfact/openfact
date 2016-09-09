package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a RemittanceAdvice.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:25 a. m.
 */
public class RemittanceAdviceLineModel{

	/**
	 * The monetary balance associated with this remittance advice line.
	 */
	private BigDecimal balanceAmount; 
	/**
	 * The amount credited on this remittance advice line.
	 */
	private BigDecimal creditLineAmount; 
	/**
	 * The amount debited on this remittance advice line.
	 */
	private BigDecimal debitLineAmount; 
	/**
	 * An identifier for this remittance advice line.
	 */
	private IdentifierType ID; 
	/**
	 * A reference to the order for payment used by the invoicing party. This may have
	 * been requested of the payer by the payee to accompany its remittance.
	 */
	private TextType invoicingPartyReference; 
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
	 * A universally unique identifier for this remittance advice line.
	 */
	private IdentifierType UUID; 
	private List<BillingReferenceModel> billingReferences = new ArrayList<>(); 
	private CustomerPartyModel originatorCustomerParty; 
	private CustomerPartyModel accountingCustomerParty; 
	private CustomerPartyModel buyerCustomerParty; 
	private List<DocumentReferenceModel> documentReferences = new ArrayList<>(); 
	private List<ExchangeRateModel> exchangeRates = new ArrayList<>(); 
	private PartyModel payeeParty; 
	private PeriodModel invoicePeriod; 
	private SupplierPartyModel accountingSupplierParty; 
	private SupplierPartyModel sellerSupplierParty; 

}
