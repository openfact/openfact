package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe the party endorsing a document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:46 a. m.
 */
public class EndorserPartyAdapter{

	/**
	 * A code specifying the role of the party providing the endorsement (e.g., issuer,
	 * embassy, insurance, etc.).
	 */
	private CodeType roleCode;
	/**
	 * A number indicating the order of the endorsement provided by this party in the
	 * sequence in which endorsements are to be applied.
	 */
	private NumericType sequenceNumeric;
	private ContactAdapter signatoryContact;
	private List<PartyAdapter> parties = new ArrayList<>();

}
