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
public class DocumentResponseModel{

	private List<DocumentReferenceModel> documentReferences = new ArrayList<>(); 
	private List<LineResponseModel> lineresponses = new ArrayList<>(); 
	private PartyModel recipientParty; 
	private PartyModel issuerParty; 
	private List<ResponseModel> responses = new ArrayList<>(); 

}
