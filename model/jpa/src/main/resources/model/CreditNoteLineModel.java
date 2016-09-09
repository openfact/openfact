package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a CreditNoteModel or SelfBilledCreditNote.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:14 a. m.
 */
public class CreditNoteLineModel{

	/**
	 * The buyer's accounting cost centre for this credit note line, expressed as text.
	 */
	private TextType accountingCost; 
	/**
	 * The buyer's accounting cost centre for this credit note line, expressed as a
	 * code.
	 */
	private CodeType accountingCostCode; 
	/**
	 * The quantity of items credited in this credit note line.
	 */
	private QuantityType creditedQuantity; 
	/**
	 * An indicator that this credit note line is free of charge (true) or not (false).
	 * The default is false.
	 */
	private IndicatorType freeOfChargeIndicator; 
	/**
	 * An identifier for this credit note line.
	 */
	private IdentifierType ID; 
	/**
	 * The total amount for this credit note line, including allowance charges but
	 * exclusive of taxes.
	 */
	private AmountType lineExtensionAmount; 
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
	 * The date of this credit note line, used to indicate the point at which tax
	 * becomes applicable.
	 */
	private DateType taxPointDate; 
	/**
	 * A universally unique identifier for this credit note line.
	 */
	private IdentifierType UUID; 
	private List<AllowanceChargeModel> allowanceCharges = new ArrayList<>(); 
	private List<BillingReferenceModel> billingReferences = new ArrayList<>(); 
	private CreditNoteLineModel subCreditNoteLine; 
	private List<DeliveryModel> deliveries = new ArrayList<>(); 
	private List<DeliveryTermsModel> deliveriesTerms = new ArrayList<>(); 
	private List<DocumentReferenceModel> documentReferences = new ArrayList<>(); 
	private List<ItemModel> items = new ArrayList<>(); 
	private LineReferenceModel receiptLineReference; 
	private LineReferenceModel despatchLineReference; 
	private List<OrderLineReferenceModel> orderLineReferences = new ArrayList<>(); 
	private PartyModel originatorParty; 
	private List<PaymentTermsModel> paymentTermses = new ArrayList<>(); 
	private PeriodModel invoicePeriod; 
	private List<PriceModel> prices = new ArrayList<>(); 
	private PriceExtensionModel itemPriceExtension; 
	private List<PricingReferenceModel> pricingReferences = new ArrayList<>(); 
	private ResponseModel discrepancyResponse; 
	private List<TaxTotalModel> taxTotals = new ArrayList<>(); 

}
