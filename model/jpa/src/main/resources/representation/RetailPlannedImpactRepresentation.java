package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a planned effect of a retail event (e.g., a promotion or a
 * change in inventory policy) upon supply or demand.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:35 a. m.
 */
public class RetailPlannedImpactRepresentation{

	/**
	 * Estimated monetary value of the planned event as an impact
	 */
	private amountType amount;
	/**
	 * It will have impact on either Sales forecast or OrderRepresentation Forecast
	 */
	private CodeType forecastPurposeCode;
	/**
	 * A code signifying the type of forecast. Examples of values are: BASE
	 * PROMOTIONAL SEASONAL TOTAL
	 */
	private CodeType forecastTypeCode;
	private List<PeriodRepresentation> periods = new ArrayList<>();

}
