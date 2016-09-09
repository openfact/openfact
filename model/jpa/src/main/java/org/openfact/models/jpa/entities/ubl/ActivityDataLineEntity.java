package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to associate a time period and locations (activity data) with an item
 * for inventory planning purposes.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:32 a. m.
 */
public class ActivityDataLineEntity{

	/**
	 * An identifier for this activity data line.
	 */
	private IdentifierType ID; 
	/**
	 * A code signifying the type of supply chain activity.
	 */
	private CodeType supplyChainActivityTypeCode; 
	private CustomerPartyEntity buyerCustomerParty; 
	private LocationEntity activityOriginLocation; 
	private PeriodEntity activityPeriod; 
	private LocationEntity activityFinalLocation; 
	private List<SalesItemEntity> salesItems = new ArrayList<>(); 
	private SupplierPartyEntity sellerSupplierParty; 

}