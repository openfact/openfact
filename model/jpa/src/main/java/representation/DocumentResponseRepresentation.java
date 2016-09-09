package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe an application-level response to a document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:37 a. m.
 */
public class DocumentResponseRepresentation{

	private List<DocumentReferenceRepresentation> DocumentReferences = new ArrayList<>();
	private List<LineResponseRepresentation> LineResponses = new ArrayList<>();
	private PartyRepresentation RecipientParty;
	private PartyRepresentation IssuerParty;
	private List<ResponseRepresentation> Responses = new ArrayList<>();

}
