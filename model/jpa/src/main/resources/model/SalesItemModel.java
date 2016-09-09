package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe information related to an item in a sales context
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:37 a. m.
 */
public class SalesItemModel{

	/**
	 * The quantity the given information are related to
	 */
	private QuantityType quantity; 
	private List<ActivityPropertyModel> activityProperties = new ArrayList<>(); 
	private List<ItemModel> items = new ArrayList<>(); 
	private PriceModel taxExclusivePrice; 
	private PriceModel taxInclusivePrice; 

}
