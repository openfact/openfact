package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a Statement of account.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:49 a. m.
 */
public class StatementLine{

	/**
	 * The balance amount on this statement line.
	 */
	private AmountType BalanceAmount;
	/**
	 * An indication that this statement line contains an outstanding balance from the
	 * previous bill(s) (true) or does not (false).
	 */
	private IndicatorType BalanceBroughtForwardIndicator;
	/**
	 * The amount credited on this statement line.
	 */
	private AmountType CreditLineAmount;
	/**
	 * The amount debited on this statement line.
	 */
	private AmountType DebitLineAmount;
	/**
	 * An identifier for this statement line.
	 */
	private IdentifierType ID;
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
	 * A universally unique identifier for this statement line.
	 */
	private IdentifierType UUID;
	private List<AllowanceCharge> AllowanceCharges = new ArrayList<>();
	private List<BillingReference> BillingReferences = new ArrayList<>();
	private CustomerParty BuyerCustomerParty;
	private CustomerParty OriginatorCustomerParty;
	private CustomerParty AccountingCustomerParty;
	private List<DocumentReference> DocumentReferences = new ArrayList<>();
	private List<ExchangeRate> ExchangeRates = new ArrayList<>();
	private Party PayeeParty;
	private Payment CollectedPayment;
	private List<PaymentMeans> PaymentMeanses = new ArrayList<>();
	private List<PaymentTerms> PaymentTermses = new ArrayList<>();
	private Period InvoicePeriod;
	private SupplierParty AccountingSupplierParty;
	private SupplierParty SellerSupplierParty;

}
