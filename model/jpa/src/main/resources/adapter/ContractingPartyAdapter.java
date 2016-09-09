package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe an individual, a group, or a body having a procurement role
 * in a tendering process.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:06 a. m.
 */
public class ContractingPartyAdapter{

	/**
	 * The buyer profile is typically located on a web site where the contracting
	 * party publishes its procurement opportunities
	 */
	private IdentifierType buyerProfileURIID;
	private List<ContractingActivityAdapter> contractingActivities = new ArrayList<>();
	private List<ContractingPartyAdapter> typeContractingPartyTypes = new ArrayList<>();
	private List<PartyAdapter> parties = new ArrayList<>();

}
