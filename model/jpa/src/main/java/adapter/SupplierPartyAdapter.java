package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a supplier party.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:00 a. m.
 */
public class SupplierPartyAdapter{

	/**
	 * An additional identifier for this supplier party.
	 */
	private IdentifierType AdditionalAccountID;
	/**
	 * An identifier for this supplier party, assigned by the customer.
	 */
	private IdentifierType CustomerAssignedAccountID;
	/**
	 * Text describing the supplier's ability to send invoice data via a purchase card
	 * provider (e.g., VISA, MasterCard, American Express).
	 */
	private TextType DataSendingCapability;
	private ContactAdapter SellerContact;
	private ContactAdapter AccountingContact;
	private ContactAdapter DespatchContact;
	private List<PartyAdapter> Parties = new ArrayList<>();

}
