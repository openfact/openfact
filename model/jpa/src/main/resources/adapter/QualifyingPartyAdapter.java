package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe the distinctive features or characteristics qualifying an
 * economic operator to be a party in a tendering process (e.g., number of
 * employees, number of operating units, type of business, technical and financial
 * capabilities, completed p
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:14 a. m.
 */
public class QualifyingPartyAdapter{

	/**
	 * An identifier for an item of evidence to support the classification of this
	 * qualifying party.
	 */
	private IdentifierType businessClassificationEvidenceID;
	/**
	 * An identifier for an item of evidence to support the business identity of this
	 * qualifying party.
	 */
	private IdentifierType businessIdentityEvidenceID;
	/**
	 * The number of people employed by this qualifying party.
	 */
	private QuantityType employeeQuantity;
	/**
	 * The number of years that this qualifying party has been in operation.
	 */
	private QuantityType operatingYearsQuantity;
	/**
	 * The extent to which this party is expected to participate in the tendering
	 * process, expressed as a percentage.
	 */
	private PercentType participationPercent;
	/**
	 * Text describing the personal situation of the qualifying party.
	 */
	private TextType personalSituation;
	/**
	 * A code stating the Tenderer Role.
	 */
	private CodeType tendererRoleCode;
	private CapabilityAdapter technicalCapability;
	private CapabilityAdapter financialCapability;
	private ClassificationSchemeAdapter businessClassificationScheme;
	private List<CompletedTaskAdapter> completedTasks = new ArrayList<>();
	private List<DeclarationAdapter> declarations = new ArrayList<>();
	private List<EconomicOperatorRoleAdapter> economicOperatorRoles = new ArrayList<>();
	private List<PartyAdapter> parties = new ArrayList<>();

}
