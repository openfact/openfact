package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe an endorsement of a document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:45 a. m.
 */
public class EndorsementAdapter{

	/**
	 * The status of this endorsement.
	 */
	private TextType approvalStatus;
	/**
	 * An identifier for this endorsement.
	 */
	private IdentifierType documentID;
	/**
	 * remarks provided by the endorsing party.
	 */
	private TextType remarks;
	private List<EndorserPartyAdapter> endorserParties = new ArrayList<>();
	private List<SignatureAdapter> signatures = new ArrayList<>();

}
