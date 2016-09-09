package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class that outlines the telecommunication supply in details
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:11 a. m.
 */
public class TelecommunicationsSupplyLineAdapter{

	/**
	 * The description of the telecommunication supply line
	 */
	private TextType Description;
	/**
	 * An identifier for this telecommunications supply line.
	 */
	private IdentifierType ID;
	/**
	 * An amount specifying the cost of this telecommunication line
	 */
	private AmountType LineExtensionAmount;
	/**
	 * The phone number used for this telecommunication supply line
	 */
	private TextType PhoneNumber;
	private List<AllowanceChargeAdapter> AllowanceCharges = new ArrayList<>();
	private List<ExchangeRateAdapter> ExchangeRates = new ArrayList<>();
	private List<TaxTotalAdapter> TaxTotals = new ArrayList<>();
	private List<TelecommunicationsServiceAdapter> TelecommunicationsServices = new ArrayList<>();

}
