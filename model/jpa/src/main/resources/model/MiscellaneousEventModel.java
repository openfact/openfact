package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a miscellaneous event associated with a retail event.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:10 a. m.
 */
public class MiscellaneousEventModel{

	/**
	 * A code signifying the type of this miscellaneous event. Examples are:
	 * ASSORTMENT_CHARGE DISASTER FORECAST_DECREASE FORECAST_INCREASE
	 * FREIGHT_FLOW_ALLOCATION INVENTORY_POLICY_CHANGE LOCATION_CLOSING
	 * LOCATION_OPENING OTHER OUT_OF_STOCK PACKAGING_LABELING_CH
	 */
	private CodeType miscellaneousEventTypeCode; 
	private List<EventModel> lineItemEventLineItems = new ArrayList<>(); 

}
