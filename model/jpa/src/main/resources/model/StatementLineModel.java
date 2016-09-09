package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a StatementModel of account.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:49 a. m.
 */
public class StatementLineModel{

	/**
	 * The balance amount on this statement line.
	 */
	private AmountType balanceAmount;
	/**
	 * An indication that this statement line contains an outstanding balance from the
	 * previous bill(s) (true) or does not (false).
	 */
	private IndicatorType balanceBroughtForwardIndicator;
	/**
	 * The amount credited on this statement line.
	 */
	private AmountType creditLineAmount;
	/**
	 * The amount debited on this statement line.
	 */
	private AmountType debitLineAmount;
	/**
	 * An identifier for this statement line.
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
	 * A universally unique identifier for this statement line.
	 */
	private IdentifierType UUID;
	private List<AllowanceChargeModel> allowanceCharges = new ArrayList<>();
	private List<BillingReferenceModel> billingReferences = new ArrayList<>();
	private CustomerPartyModel buyerCustomerParty;
	private CustomerPartyModel originatorCustomerParty;
	private CustomerPartyModel accountingCustomerParty;
	private List<DocumentReferenceModel> documentReferences = new ArrayList<>();
	private List<ExchangeRateModel> exchangeRates = new ArrayList<>();
	private PartyModel payeeParty;
	private PaymentModel collectedPayment;
	private List<PaymentMeansModel> paymentMeanses = new ArrayList<>();
	private List<PaymentTermsModel> paymentTermses = new ArrayList<>();
	private PeriodModel invoicePeriod;
	private SupplierPartyModel accountingSupplierParty;
	private SupplierPartyModel sellerSupplierParty;

}
