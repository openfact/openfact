package model;
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
	private List<BillingReferenceModel> BillingReferences = new ArrayList<>();
	private CustomerPartyModel OriginatorCustomerParty;
	private CustomerPartyModel AccountingCustomerParty;
	private CustomerPartyModel BuyerCustomerParty;
	private List<DocumentReferenceModel> DocumentReferences = new ArrayList<>();
	private List<ExchangeRateModel> ExchangeRates = new ArrayList<>();
	private PartyModel PayeeParty;
	private PeriodModel InvoicePeriod;
	private SupplierPartyModel AccountingSupplierParty;
	private SupplierPartyModel SellerSupplierParty;

}
