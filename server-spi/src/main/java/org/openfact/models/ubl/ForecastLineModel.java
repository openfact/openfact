package org.openfact.models.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * Detailed information about a particular ForecastLineModel within a Forecast
 * Document
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:19 a. m.
 */
public class ForecastLineModel{

	/**
	 * A code signifying the type of forecast. Examples: BASE PROMOTIONAL SEASONAL
	 * TOTAL
	 */
	private CodeType forecastTypeCode; 
	/**
	 * An indicator that the status of the forecast is modifiable (true) or not
	 * (false).
	 */
	private boolean frozenDocumentIndicator; 
	/**
	 * An identifier for this forecast line.
	 */
	private IdentifierType ID; 
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType note; 
	private PeriodModel forecastPeriod; 
	private List<SalesItemModel> salesItems = new ArrayList<>(); 

}
