package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe the consumption of a utility.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:45 a. m.
 */
public class Consumption{

	/**
	 * A code identifying the type of the UtilityStatement required for this
	 * consumption. Explains the kind of utility the statement is about, e.g.. "gas",
	 * "electricity", "telephone"
	 */
	private CodeType UtilityStatementTypeCode;
	private List<AllowanceCharge> AllowanceCharges = new ArrayList<>();
	private List<EnergyWaterSupply> EnergyWaterSupplies = new ArrayList<>();
	private MonetaryTotal LegalMonetaryTotal;
	private Period MainPeriod;
	private List<TaxTotal> TaxTotals = new ArrayList<>();
	private List<TelecommunicationsSupply> TelecommunicationsSupplies = new ArrayList<>();

}
