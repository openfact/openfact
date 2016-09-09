package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe the consumption of a utility.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:45 a. m.
 */
public class ConsumptionRepresentation{

	/**
	 * A code identifying the type of the UtilityStatementRepresentation required for this
	 * consumption. Explains the kind of utility the statement is about, e.g.. "gas",
	 * "electricity", "telephone"
	 */
	private CodeType utilityStatementTypeCode;
	private List<AllowanceChargeRepresentation> allowanceCharges = new ArrayList<>();
	private List<EnergyWaterSupplyRepresentation> energyWaterSupplies = new ArrayList<>();
	private MonetaryTotalRepresentation legalMonetaryTotal;
	private PeriodRepresentation mainPeriod;
	private List<TaxTotalRepresentation> taxTotals = new ArrayList<>();
	private List<TelecommunicationsSupplyRepresentation> telecommunicationsSupplies = new ArrayList<>();

}
