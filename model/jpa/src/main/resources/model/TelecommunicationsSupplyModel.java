package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class describing the supply of a telecommunication service, e.g., providing
 * telephone calls.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:10 a. m.
 */
public class TelecommunicationsSupplyModel{

	/**
	 * Text describing the telecommunications supply.
	 */
	private TextType description;
	/**
	 * A code signifying the level of confidentiality of this information for this
	 * telecommunication supply.
	 */
	private CodeType privacyCode;
	/**
	 * The type of telecommunications supply, expressed as text.
	 */
	private TextType telecommunicationsSupplyType;
	/**
	 * The type of telecommunications supply, expressed as a code.
	 */
	private CodeType telecommunicationsSupplyTypeCode;
	/**
	 * The total amount associated with this telecommunications supply.
	 */
	private AmountType totalAmount;
	private List<TelecommunicationsSupplyLineModel> telecommunicationsSupplyLines = new ArrayList<>();

}
