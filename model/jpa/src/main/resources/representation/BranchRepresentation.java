package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a branch or a division of an organization.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:13:10 a. m.
 */
public class BranchRepresentation{

	/**
	 * An identifier for this branch or division of an organization.
	 */
	private IdentifierType ID;
	/**
	 * The name of this branch or division of an organization.
	 */
	private nameType name;
	private List<AddressRepresentation> addresses = new ArrayList<>();
	private List<FinancialInstitutionRepresentation> financialInstitutions = new ArrayList<>();

}
