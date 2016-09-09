package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe an application-level response to a document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:37 a. m.
 */
public class DocumentResponse{

	private List<DocumentReference> DocumentReferences = new ArrayList<>();
	private List<LineResponse> LineResponses = new ArrayList<>();
	private Party RecipientParty;
	private Party IssuerParty;
	private List<Response> Responses = new ArrayList<>();

}
