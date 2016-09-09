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
public class ConsumptionAdapter{

	/**
	 * A code identifying the type of the UtilityStatementAdapter required for this
	 * consumption. Explains the kind of utility the statement is about, e.g.. "gas",
	 * "electricity", "telephone"
	 */
	private CodeType utilityStatementTypeCode; 
	private List<AllowanceChargeAdapter> allowanceCharges = new ArrayList<>(); 
	private List<EnergyWaterSupplyAdapter> energyWaterSupplies = new ArrayList<>(); 
	private MonetaryTotalAdapter legalMonetaryTotal; 
	private PeriodAdapter mainPeriod; 
	private List<TaxTotalAdapter> taxTotals = new ArrayList<>(); 
	private List<TelecommunicationsSupplyAdapter> telecommunicationsSupplies = new ArrayList<>(); 

}
