package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a RemittanceAdvice.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:25 a. m.
 */
public class RemittanceAdviceLineEntity{

	/**
	 * The monetary balance associated with this remittance advice line.
	 */
	private AmountType balanceAmount; 
	/**
	 * The amount credited on this remittance advice line.
	 */
	private AmountType creditLineAmount; 
	/**
	 * The amount debited on this remittance advice line.
	 */
	private AmountType debitLineAmount; 
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
	private List<BillingReferenceEntity> billingReferences = new ArrayList<>(); 
	private CustomerPartyEntity originatorCustomerParty; 
	private CustomerPartyEntity accountingCustomerParty; 
	private CustomerPartyEntity buyerCustomerParty; 
	private List<DocumentReferenceEntity> documentReferences = new ArrayList<>(); 
	private List<ExchangeRateEntity> exchangeRates = new ArrayList<>(); 
	private PartyEntity payeeParty; 
	private PeriodEntity invoicePeriod; 
	private SupplierPartyEntity accountingSupplierParty; 
	private SupplierPartyEntity sellerSupplierParty; 

}
