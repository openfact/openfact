package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * The consumption in case the consumption is for one and only one supplier.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:58 a. m.
 */
public class SupplierConsumptionAdapter{

	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType Description;
	private List<ConsumptionAdapter> Consumptions = new ArrayList<>();
	private List<ConsumptionLineAdapter> ConsumptionsLine = new ArrayList<>();
	private List<ContractAdapter> Contracts = new ArrayList<>();
	private PartyAdapter UtilityCustomerParty;
	private PartyAdapter UtilitySupplierParty;

}
