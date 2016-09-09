package org.openfact.models.jpa.entities.ubl;
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

	private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>(); 
	private List<LineResponseRepresentation> lineresponses = new ArrayList<>(); 
	private PartyRepresentation recipientParty; 
	private PartyRepresentation issuerParty; 
	private List<ResponseRepresentation> responses = new ArrayList<>(); 

}
