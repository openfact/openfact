package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * A class to describe information related to an item in a sales context
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:37 a. m.
 */
public class SalesItemEntity {

	/**
	 * The quantity the given information are related to
	 */
	private QuantityType quantity;
	private List<ActivityPropertyEntity> activityProperties = new ArrayList<>();
	private List<ItemEntity> items = new ArrayList<>();
	private PriceEntity taxExclusivePrice;
	private PriceEntity taxInclusivePrice;

}
