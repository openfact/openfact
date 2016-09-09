package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a person.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:46 a. m.
 */
public class PersonRepresentation{

	/**
	 * This person's date of birth.
	 */
	private DateType BirthDate;
	/**
	 * The name of the place where this person was born, expressed as text.
	 */
	private TextType BirthplaceName;
	/**
	 * This person's family name.
	 */
	private NameType FamilyName;
	/**
	 * This person's given name.
	 */
	private NameType FirstName;
	/**
	 * A code (e.g., ISO 5218) signifying the gender of this person.
	 */
	private CodeType GenderCode;
	/**
	 * An identifier for this person.
	 */
	private IdentifierType ID;
	/**
	 * This person's job title (for a particular role) within an organization.
	 */
	private TextType JobTitle;
	/**
	 * This person's middle name(s) or initials.
	 */
	private NameType MiddleName;
	/**
	 * A suffix to this person's name (e.g., PhD, OBE, Jr).
	 */
	private TextType NameSuffix;
	/**
	 * An identifier for this person's nationality.
	 */
	private IdentifierType NationalityID;
	/**
	 * The department or subdivision of an organization that this person belongs to
	 * (in a particular role).
	 */
	private TextType OrganizationDepartment;
	/**
	 * This person's second family name.
	 */
	private NameType OtherName;
	/**
	 * This person's title of address (e.g., Mr, Ms, Dr, Sir).
	 */
	private TextType Title;
	private AddressRepresentation ResidenceAddress;
	private List<ContactRepresentation> Contacts = new ArrayList<>();
	private DocumentReferenceRepresentation IdentityDocumentReference;
	private List<FinancialAccountRepresentation> FinancialAccounts = new ArrayList<>();

}
