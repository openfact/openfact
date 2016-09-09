package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe the consumption of a utility.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:45 a. m.
 */
public class ConsumptionModel{

	/**
	 * A code identifying the type of the UtilityStatementModel required for this
	 * consumption. Explains the kind of utility the statement is about, e.g.. "gas",
	 * "electricity", "telephone"
	 */
	private CodeType UtilityStatementTypeCode;
	private List<AllowanceChargeModel> AllowanceCharges = new ArrayList<>();
	private List<EnergyWaterSupplyModel> EnergyWaterSupplies = new ArrayList<>();
	private MonetaryTotalModel LegalMonetaryTotal;
	private PeriodModel MainPeriod;
	private List<TaxTotalModel> TaxTotals = new ArrayList<>();
	private List<TelecommunicationsSupplyModel> TelecommunicationsSupplies = new ArrayList<>();

}
