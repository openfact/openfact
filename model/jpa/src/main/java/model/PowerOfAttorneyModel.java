package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a power of attorney.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:51 a. m.
 */
public class PowerOfAttorneyModel{

	/**
	 * Text describing this power of attorney.
	 */
	private TextType Description;
	/**
	 * An identifier for this power of attorney.
	 */
	private IdentifierType ID;
	/**
	 * The date on which this power of attorney was issued.
	 */
	private DateType IssueDate;
	/**
	 * The time at which this power of attorney was issued.
	 */
	private TimeType IssueTime;
	private DocumentReferenceModel MandateDocumentReference;
	private PartyModel AgentParty;
	private PartyModel NotaryParty;
	private PartyModel WitnessParty;

}
