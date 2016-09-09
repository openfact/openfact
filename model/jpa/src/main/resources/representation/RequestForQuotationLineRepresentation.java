package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a Request for Quotation.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:28 a. m.
 */
public class RequestForQuotationLineRepresentation{

	/**
	 * An identifier for this line in the request for quotation.
	 */
	private IdentifierType ID; 
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType note; 
	/**
	 * An indication whether this line is optional (true) or not (false) for purposes
	 * of this request for quotation.
	 */
	private IndicatorType optionalLineItemIndicator; 
	/**
	 * A code signifying the level of confidentiality of this request for quotation
	 * line.
	 */
	private CodeType privacyCode; 
	/**
	 * A code signifying the security classification of this request for quotation
	 * line.
	 */
	private CodeType securityClassificationCode; 
	/**
	 * A universally unique identifier for this line in the request for quotation.
	 */
	private IdentifierType UUID; 
	private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>(); 
	private List<LineItemRepresentation> lineItems = new ArrayList<>(); 

}
