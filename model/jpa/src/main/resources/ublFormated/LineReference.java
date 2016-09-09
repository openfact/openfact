package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a reference to a line in a document.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:57 a. m.
 */
public class LineReference{

	/**
	 * Identifies the referenced line in the document.
	 */
	private IdentifierType LineID;
	/**
	 * A code signifying the status of the referenced line with respect to its
	 * original state.
	 */
	private LineStatusCodeType LineStatusCode;
	/**
	 * A universally unique identifier for this line reference.
	 */
	private IdentifierType UUID;
	private List<DocumentReference> DocumentReferences = new ArrayList<>();

}
