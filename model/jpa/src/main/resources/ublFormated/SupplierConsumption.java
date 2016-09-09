package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * The consumption in case the consumption is for one and only one supplier.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:58 a. m.
 */
public class SupplierConsumption{

	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType Description;
	private List<Consumption> Consumptions = new ArrayList<>();
	private List<ConsumptionLine> ConsumptionsLine = new ArrayList<>();
	private List<Contract> Contracts = new ArrayList<>();
	private Party UtilityCustomerParty;
	private Party UtilitySupplierParty;

}
