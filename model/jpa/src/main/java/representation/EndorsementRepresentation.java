package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe an endorsement of a document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:45 a. m.
 */
public class EndorsementRepresentation{

	/**
	 * The status of this endorsement.
	 */
	private TextType ApprovalStatus;
	/**
	 * An identifier for this endorsement.
	 */
	private IdentifierType DocumentID;
	/**
	 * Remarks provided by the endorsing party.
	 */
	private TextType Remarks;
	private List<EndorserPartyRepresentation> EndorserParties = new ArrayList<>();
	private List<SignatureRepresentation> Signatures = new ArrayList<>();

}
