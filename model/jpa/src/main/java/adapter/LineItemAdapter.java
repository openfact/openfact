package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a line item.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:55 a. m.
 */
public class LineItemAdapter{

	/**
	 * The buyer's accounting cost centre for this line item, expressed as text.
	 */
	private TextType AccountingCost;
	/**
	 * The buyer's accounting cost centre for this line item, expressed as a code.
	 */
	private CodeType AccountingCostCode;
	/**
	 * An indicator that back order is allowed (true) or not (false).
	 */
	private IndicatorType BackOrderAllowedIndicator;
	/**
	 * An identifier for this line item, assigned by the buyer.
	 */
	private IdentifierType ID;
	/**
	 * A code signifying the inspection requirements for the item associated with this
	 * line item.
	 */
	private CodeType InspectionMethodCode;
	/**
	 * The total amount for this line item, including allowance charges but net of
	 * taxes.
	 */
	private AmountType LineExtensionAmount;
	/**
	 * A code signifying the status of this line item with respect to its original
	 * state.
	 */
	private LineStatusCodeType LineStatusCode;
	/**
	 * The maximum back order quantity of the item associated with this line (where
	 * back order is allowed).
	 */
	private QuantityType MaximumBackorderQuantity;
	/**
	 * The maximum quantity of the item associated with this line.
	 */
	private QuantityType MaximumQuantity;
	/**
	 * The minimum back order quantity of the item associated with this line (where
	 * back order is allowed).
	 */
	private QuantityType MinimumBackorderQuantity;
	/**
	 * The minimum quantity of the item associated with this line.
	 */
	private QuantityType MinimumQuantity;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType Note;
	/**
	 * An indicator that a partial delivery is allowed (true) or not (false).
	 */
	private IndicatorType PartialDeliveryIndicator;
	/**
	 * The quantity of items associated with this line item.
	 */
	private QuantityType Quantity;
	/**
	 * An identifier for this line item, assigned by the seller.
	 */
	private IdentifierType SalesOrderID;
	/**
	 * The total tax amount for this line item.
	 */
	private AmountType TotalTaxAmount;
	/**
	 * A universally unique identifier for this line item.
	 */
	private IdentifierType UUID;
	/**
	 * Text describing a warranty (provided by WarrantyParty) for the good or service
	 * described in this line item.
	 */
	private TextType WarrantyInformation;
	private List<AllowanceChargeAdapter> AllowanceCharges = new ArrayList<>();
	private List<DeliveryAdapter> Deliveries = new ArrayList<>();
	private List<DeliveryTermsAdapter> DeliveriesTerms = new ArrayList<>();
	private List<ItemAdapter> Items = new ArrayList<>();
	private LineItemAdapter SubLineItem;
	private List<LineReferenceAdapter> LineReferences = new ArrayList<>();
	private PartyAdapter OriginatorParty;
	private PartyAdapter WarrantyParty;
	private PeriodAdapter WarrantyValidityPeriod;
	private List<OrderedShipmentAdapter> OrderedShipments = new ArrayList<>();
	private List<PriceAdapter> Prices = new ArrayList<>();
	private PriceExtensionAdapter ItemPriceExtension;
	private List<PricingReferenceAdapter> PricingReferences = new ArrayList<>();
	private List<TaxTotalAdapter> TaxTotals = new ArrayList<>();

}
