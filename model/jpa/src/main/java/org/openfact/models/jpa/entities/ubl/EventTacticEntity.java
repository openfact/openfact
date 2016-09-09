package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * A class defining a specific type of action or situation arranged by the Buyer
 * or the Seller to promote the product or products.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:58 a. m.
 */
public class EventTacticEntity {

	/**
	 * Generic field to add additional information or to specify mutually
	 * defined eventTacticTypes that are not currently listed.
	 */
	private TextType comment;
	/**
	 * The currencies, units, etc. that describes what is need for the event or
	 * promotion Usage example: Number of pallets per store for a stack display
	 */
	private QuantityType quantity;
	private List<EventTacticEnumerationEntity> eventTacticEnumerations = new ArrayList<>();
	private List<PeriodEntity> periods = new ArrayList<>();

}
