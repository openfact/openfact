package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a customer party.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:14:16 a. m.
 */
public class CustomerPartyAdapter{

	/**
	 * An identifier for the customer's account, assigned by a third party.
	 */
	private IdentifierType additionalAccountID;
	/**
	 * An identifier for the customer's account, assigned by the customer itself.
	 */
	private IdentifierType customerAssignedAccountID;
	/**
	 * An identifier for the customer's account, assigned by the supplier.
	 */
	private IdentifierType supplierAssignedAccountID;
	private ContactAdapter deliveryContact;
	private ContactAdapter accountingContact;
	private ContactAdapter buyerContact;
	private List<PartyAdapter> parties = new ArrayList<>();

}
