package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * Detailed information about a particular ForecastLine within a Forecast
 * Document
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:19 a. m.
 */
public class ForecastLine{

	/**
	 * A code signifying the type of forecast. Examples: BASE PROMOTIONAL SEASONAL
	 * TOTAL
	 */
	private CodeType ForecastTypeCode;
	/**
	 * An indicator that the status of the forecast is modifiable (true) or not
	 * (false).
	 */
	private IndicatorType FrozenDocumentIndicator;
	/**
	 * An identifier for this forecast line.
	 */
	private IdentifierType ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType Note;
	private Period ForecastPeriod;
	private List<SalesItem> SalesItems = new ArrayList<>();

}
