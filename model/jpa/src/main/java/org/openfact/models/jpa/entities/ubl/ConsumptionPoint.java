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
	private String Description;
	/**
	 * An identifier for this point of consumption.
	 */
	private String ID;
	/**
	 * An identifier for the subscriber responsible for the consumption at this
	 * consumption point.
	 */
	private String SubscriberID;
	/**
	 * The type of subscriber, expressed as text.
	 */
	private String SubscriberType;
	/**
	 * The type of subscriber, expressed as a code.
	 */
	private String SubscriberTypeCode;
	/**
	 * The total quantity delivered, calculated at this consumption point.
	 */
	private BigDecimal TotalDeliveredQuantity;
	private Address m_Address;
	private Meter UtilityMeter;
	private WebSiteAccess m_WebSiteAccess;

	public ConsumptionPoint() {

	}

	public void finalize() throws Throwable {

	}

	/**
	 * @return the m_Address
	 */
	public Address getM_Address() {
		return m_Address;
	}

	/**
	 * @param m_Address
	 *            the m_Address to set
	 */
	public void setM_Address(Address m_Address) {
		this.m_Address = m_Address;
	}

	/**
	 * @return the utilityMeter
	 */
	public Meter getUtilityMeter() {
		return UtilityMeter;
	}

	/**
	 * @param utilityMeter
	 *            the utilityMeter to set
	 */
	public void setUtilityMeter(Meter utilityMeter) {
		UtilityMeter = utilityMeter;
	}

	/**
	 * @return the m_WebSiteAccess
	 */
	public WebSiteAccess getM_WebSiteAccess() {
		return m_WebSiteAccess;
	}

	/**
	 * @param m_WebSiteAccess
	 *            the m_WebSiteAccess to set
	 */
	public void setM_WebSiteAccess(WebSiteAccess m_WebSiteAccess) {
		this.m_WebSiteAccess = m_WebSiteAccess;
	}

	public Address getAddress() {
		return m_Address;
	}

	public String getDescription() {
		return Description;
	}

	public String getID() {
		return ID;
	}

	public String getSubscriberID() {
		return SubscriberID;
	}

	public String getSubscriberType() {
		return SubscriberType;
	}

	public String getSubscriberTypeCode() {
		return SubscriberTypeCode;
	}

	public BigDecimal getTotalDeliveredQuantity() {
		return TotalDeliveredQuantity;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAddress(Address newVal) {
		m_Address = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(String newVal) {
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal) {
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubscriberID(String newVal) {
		SubscriberID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubscriberType(String newVal) {
		SubscriberType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubscriberTypeCode(String newVal) {
		SubscriberTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalDeliveredQuantity(BigDecimal newVal) {
		TotalDeliveredQuantity = newVal;
	}

}// end Consumption Point