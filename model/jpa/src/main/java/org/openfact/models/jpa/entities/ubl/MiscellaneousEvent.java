package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe a miscellaneous event associated with a retail event.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:10 a. m.
 */
public class MiscellaneousEvent {

	/**
	 * A code signifying the type of this miscellaneous event. Examples are:
	 * ASSORTMENT_CHARGE DISASTER FORECAST_DECREASE FORECAST_INCREASE
	 * FREIGHT_FLOW_ALLOCATION INVENTORY_POLICY_CHANGE LOCATION_CLOSING
	 * LOCATION_OPENING OTHER OUT_OF_STOCK PACKAGING_LABELING_CH
	 */
	private String MiscellaneousEventTypeCode;
	private EventLineItem m_EventLineItem;

	public MiscellaneousEvent() {

	}

	public void finalize() throws Throwable {

	}

	public EventLineItem getEventLineItem() {
		return m_EventLineItem;
	}

	public String getMiscellaneousEventTypeCode() {
		return MiscellaneousEventTypeCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEventLineItem(EventLineItem newVal) {
		m_EventLineItem = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMiscellaneousEventTypeCode(String newVal) {
		MiscellaneousEventTypeCode = newVal;
	}
}// end Miscellaneous Event