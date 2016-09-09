package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe energy taxes.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:47 a. m.
 */
public class EnergyTaxReportRepresentation{

	/**
	 * The monetary amount of taxes (and duties).
	 */
	private AmountType TaxEnergyAmount;
	/**
	 * The monetary amount of the balance of taxes owing.
	 */
	private AmountType TaxEnergyBalanceAmount;
	/**
	 * The monetary amount of taxes (and duties) paid on account.
	 */
	private AmountType TaxEnergyOnAccountAmount;
	private List<TaxSchemeRepresentation> TaxSchemes = new ArrayList<>();

}
