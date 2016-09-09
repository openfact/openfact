package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a RemittanceAdvice.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:25 a. m.
 */
public class RemittanceAdviceLineAdapter{

	/**
	 * The monetary balance associated with this remittance advice line.
	 */
	private AmountType BalanceAmount;
	/**
	 * The amount credited on this remittance advice line.
	 */
	private AmountType CreditLineAmount;
	/**
	 * The amount debited on this remittance advice line.
	 */
	private AmountType DebitLineAmount;
	/**
	 * An identifier for this remittance advice line.
	 */
	private IdentifierType ID;
	/**
	 * A reference to the order for payment used by the invoicing party. This may have
	 * been requested of the payer by the payee to accompany its remittance.
	 */
	private TextType InvoicingPartyReference;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType Note;
	/**
	 * A code signifying the business purpose for this payment.
	 */
	private CodeType PaymentPurposeCode;
	/**
	 * A universally unique identifier for this remittance advice line.
	 */
	private IdentifierType UUID;
	private List<BillingReferenceAdapter> BillingReferences = new ArrayList<>();
	private CustomerPartyAdapter OriginatorCustomerParty;
	private CustomerPartyAdapter AccountingCustomerParty;
	private CustomerPartyAdapter BuyerCustomerParty;
	private List<DocumentReferenceAdapter> DocumentReferences = new ArrayList<>();
	private List<ExchangeRateAdapter> ExchangeRates = new ArrayList<>();
	private PartyAdapter PayeeParty;
	private PeriodAdapter InvoicePeriod;
	private SupplierPartyAdapter AccountingSupplierParty;
	private SupplierPartyAdapter SellerSupplierParty;

}
