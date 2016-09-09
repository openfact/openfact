package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define the point of consumption for a utility, such as a meter.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:53 a. m.
 */
public class ConsumptionPoint{

	/**
	 * Text describing this consumption point.
	 */
	private TextType Description;
	/**
	 * An identifier for this point of consumption.
	 */
	private IdentifierType ID;
	/**
	 * An identifier for the subscriber responsible for the consumption at this
	 * consumption point.
	 */
	private IdentifierType SubscriberID;
	/**
	 * The type of subscriber, expressed as text.
	 */
	private TextType SubscriberType;
	/**
	 * The type of subscriber, expressed as a code.
	 */
	private CodeType SubscriberTypeCode;
	/**
	 * The total quantity delivered, calculated at this consumption point.
	 */
	private QuantityType TotalDeliveredQuantity;
	private List<Address> Addresses = new ArrayList<>();
	private Meter UtilityMeter;
	private List<WebSiteAccess> WebSiteAccesses = new ArrayList<>();

}
