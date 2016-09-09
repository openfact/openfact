package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe the consumption of a utility.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:45 a. m.
 */
public class ConsumptionEntity{

	/**
	 * A code identifying the type of the UtilityStatementEntity required for this
	 * consumption. Explains the kind of utility the statement is about, e.g.. "gas",
	 * "electricity", "telephone"
	 */
	private CodeType utilityStatementTypeCode; 
	private List<AllowanceChargeEntity> allowanceCharges = new ArrayList<>(); 
	private List<EnergyWaterSupplyEntity> energyWaterSupplies = new ArrayList<>(); 
	private MonetaryTotalEntity legalMonetaryTotal; 
	private PeriodEntity mainPeriod; 
	private List<TaxTotalEntity> taxTotals = new ArrayList<>(); 
	private List<TelecommunicationsSupplyEntity> telecommunicationsSupplies = new ArrayList<>(); 

}
