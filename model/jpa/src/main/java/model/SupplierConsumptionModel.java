package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * The consumption in case the consumption is for one and only one supplier.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:58 a. m.
 */
public class SupplierConsumptionModel{

	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType Description;
	private List<ConsumptionModel> Consumptions = new ArrayList<>();
	private List<ConsumptionLineModel> ConsumptionsLine = new ArrayList<>();
	private List<ContractModel> Contracts = new ArrayList<>();
	private PartyModel UtilityCustomerParty;
	private PartyModel UtilitySupplierParty;

}
