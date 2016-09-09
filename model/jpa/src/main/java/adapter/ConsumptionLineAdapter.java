package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a line item for utility consumption. To specify more than
 * one utility item, use separate consumption lines.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:52 a. m.
 */
public class ConsumptionLineAdapter{

	/**
	 * An identifier for this consumption line.
	 */
	private IdentifierType ID;
	/**
	 * The quantity invoiced.
	 */
	private QuantityType InvoicedQuantity;
	/**
	 * The monetary amount, including discount, to be charged for this consumption
	 * line.
	 */
	private AmountType LineExtensionAmount;
	/**
	 * An identifier for the transaction line on a related document (such as an
	 * invoice) that covers this consumption line.
	 */
	private IdentifierType ParentDocumentLineReferenceID;
	private List<AllowanceChargeAdapter> AllowanceCharges = new ArrayList<>();
	private List<DeliveryAdapter> Deliveries = new ArrayList<>();
	private List<PeriodAdapter> Periods = new ArrayList<>();
	private List<PriceAdapter> Prices = new ArrayList<>();
	private List<TaxTotalAdapter> TaxTotals = new ArrayList<>();
	private List<UnstructuredPriceAdapter> UnstructuredPrices = new ArrayList<>();
	private List<UtilityItemAdapter> UtilityItems = new ArrayList<>();

}
