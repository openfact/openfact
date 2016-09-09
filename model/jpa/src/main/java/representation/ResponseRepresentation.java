package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe an application-level response to a document.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:32 a. m.
 */
public class ResponseRepresentation{

	/**
	 * Text describing this response.
	 */
	private TextType Description;
	/**
	 * The date upon which this response is valid.
	 */
	private DateType EffectiveDate;
	/**
	 * The time at which this response is valid.
	 */
	private TimeType EffectiveTime;
	/**
	 * An identifier for the section (or line) of the document to which this response
	 * applies.
	 */
	private IdentifierType ReferenceID;
	/**
	 * A code signifying the type of response.
	 */
	private CodeType ResponseCode;
	private List<StatusRepresentation> Statuses = new ArrayList<>();

}
