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

	private List<DocumentReferenceAdapter> documentReferences = new ArrayList<>();
	private List<LineResponseAdapter> lineresponses = new ArrayList<>();
	private PartyAdapter recipientParty;
	private PartyAdapter issuerParty;
	private List<ResponseAdapter> responses = new ArrayList<>();

}
