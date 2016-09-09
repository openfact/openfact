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
	private CodeType UtilityStatementTypeCode;
	private List<AllowanceChargeRepresentation> AllowanceCharges = new ArrayList<>();
	private List<EnergyWaterSupplyRepresentation> EnergyWaterSupplies = new ArrayList<>();
	private MonetaryTotalRepresentation LegalMonetaryTotal;
	private PeriodRepresentation MainPeriod;
	private List<TaxTotalRepresentation> TaxTotals = new ArrayList<>();
	private List<TelecommunicationsSupplyRepresentation> TelecommunicationsSupplies = new ArrayList<>();

}
