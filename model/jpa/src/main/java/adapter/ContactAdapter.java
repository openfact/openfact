package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a contactable person or department in an organization.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:58 a. m.
 */
public class ContactAdapter{

	/**
	 * The primary email address of this contact.
	 */
	private TextType ElectronicMail;
	/**
	 * An identifier for this contact.
	 */
	private IdentifierType ID;
	/**
	 * The name of this contact. It is recommended that this be used for a functional
	 * name and not a personal name.
	 */
	private NameType Name;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures; in particular, a textual description of the circumstances under
	 * which this contact can be used (e.g., "emergency" or "after hours").
	 */
	private TextType Note;
	/**
	 * The primary fax number of this contact.
	 */
	private TextType Telefax;
	/**
	 * The primary telephone number of this contact.
	 */
	private TextType Telephone;
	private CommunicationAdapter OtherCommunication;

}
