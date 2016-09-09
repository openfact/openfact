package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe the consumption of a utility.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:45 a. m.
 */
public class ConsumptionAdapter{

	/**
	 * A code identifying the type of the UtilityStatementAdapter required for this
	 * consumption. Explains the kind of utility the statement is about, e.g.. "gas",
	 * "electricity", "telephone"
	 */
	private CodeType UtilityStatementTypeCode;
	private List<AllowanceChargeAdapter> AllowanceCharges = new ArrayList<>();
	private List<EnergyWaterSupplyAdapter> EnergyWaterSupplies = new ArrayList<>();
	private MonetaryTotalAdapter LegalMonetaryTotal;
	private PeriodAdapter MainPeriod;
	private List<TaxTotalAdapter> TaxTotals = new ArrayList<>();
	private List<TelecommunicationsSupplyAdapter> TelecommunicationsSupplies = new ArrayList<>();

}
