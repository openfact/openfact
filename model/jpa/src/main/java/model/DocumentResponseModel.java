package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe an application-level response to a document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:37 a. m.
 */
public class DocumentResponseModel{

	private List<DocumentReferenceModel> DocumentReferences = new ArrayList<>();
	private List<LineResponseModel> LineResponses = new ArrayList<>();
	private PartyModel RecipientParty;
	private PartyModel IssuerParty;
	private List<ResponseModel> Responses = new ArrayList<>();

}
