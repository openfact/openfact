package representation;
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
public class ConsumptionLineRepresentation{

	/**
	 * An identifier for this consumption line.
	 */
	private IdentifierType ID;
	/**
	 * The quantity invoiced.
	 */
	private QuantityType invoicedQuantity;
	/**
	 * The monetary amount, including discount, to be charged for this consumption
	 * line.
	 */
	private AmountType lineExtensionAmount;
	/**
	 * An identifier for the transaction line on a related document (such as an
	 * invoice) that covers this consumption line.
	 */
	private IdentifierType parentDocumentLineReferenceID;
	private List<AllowanceChargeRepresentation> allowanceCharges = new ArrayList<>();
	private List<DeliveryRepresentation> deliveries = new ArrayList<>();
	private List<PeriodRepresentation> periods = new ArrayList<>();
	private List<PriceRepresentation> prices = new ArrayList<>();
	private List<TaxTotalRepresentation> taxTotals = new ArrayList<>();
	private List<UnstructuredPriceRepresentation> Unstructuredprices = new ArrayList<>();
	private List<UtilityItemRepresentation> utilityItems = new ArrayList<>();

}
