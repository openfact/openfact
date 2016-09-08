package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to define the point of consumption for a utility, such as a meter.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:53 a. m.
 */
public class ConsumptionPoint {

	/**
	 * Text describing this consumption point.
	 */
	private String description;
	/**
	 * An identifier for this point of consumption.
	 */
	private String ID;
	/**
	 * An identifier for the subscriber responsible for the consumption at this
	 * consumption point.
	 */
	private String subscriberID;
	/**
	 * The type of subscriber, expressed as text.
	 */
	private String subscriberType;
	/**
	 * The type of subscriber, expressed as a code.
	 */
	private String subscriberTypeCode;
	/**
	 * The total quantity delivered, calculated at this consumption point.
	 */
	private BigDecimal totalDeliveredQuantity;
	private List<Address> address= new ArrayList<>();
	private Meter utilityMeter;
	private List<WebSiteAccess> webSiteAccess= new ArrayList<>();

	public ConsumptionPoint() {

	}

	public void finalize() throws Throwable {

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getSubscriberID() {
		return subscriberID;
	}

	public void setSubscriberID(String subscriberID) {
		this.subscriberID = subscriberID;
	}

	public String getSubscriberType() {
		return subscriberType;
	}

	public void setSubscriberType(String subscriberType) {
		this.subscriberType = subscriberType;
	}

	public String getSubscriberTypeCode() {
		return subscriberTypeCode;
	}

	public void setSubscriberTypeCode(String subscriberTypeCode) {
		this.subscriberTypeCode = subscriberTypeCode;
	}

	public BigDecimal getTotalDeliveredQuantity() {
		return totalDeliveredQuantity;
	}

	public void setTotalDeliveredQuantity(BigDecimal totalDeliveredQuantity) {
		this.totalDeliveredQuantity = totalDeliveredQuantity;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public Meter getUtilityMeter() {
		return utilityMeter;
	}

	public void setUtilityMeter(Meter utilityMeter) {
		this.utilityMeter = utilityMeter;
	}

	public List<WebSiteAccess> getWebSiteAccess() {
		return webSiteAccess;
	}

	public void setWebSiteAccess(List<WebSiteAccess> webSiteAccess) {
		this.webSiteAccess = webSiteAccess;
	}
}// end Consumption Point