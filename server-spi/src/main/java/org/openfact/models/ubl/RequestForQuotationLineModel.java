package org.openfact.models.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a Request for Quotation.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:28 a. m.
 */
public class RequestForQuotationLineModel{

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
	private boolean optionalLineItemIndicator; 
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
	private List<DocumentReferenceModel> documentReferences = new ArrayList<>(); 
	private List<LineItemModel> lineItems = new ArrayList<>(); 

}
