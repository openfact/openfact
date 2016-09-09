package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe an application-level response to a document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:37 a. m.
 */
public class DocumentResponseAdapter{

	private List<DocumentReferenceAdapter> DocumentReferences = new ArrayList<>();
	private List<LineResponseAdapter> LineResponses = new ArrayList<>();
	private PartyAdapter RecipientParty;
	private PartyAdapter IssuerParty;
	private List<ResponseAdapter> Responses = new ArrayList<>();

}
