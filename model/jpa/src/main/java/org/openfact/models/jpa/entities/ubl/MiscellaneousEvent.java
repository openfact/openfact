package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a miscellaneous event associated with a retail event.
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
	private Code. Type MiscellaneousEventTypeCode;
	private Event Line Item m_Event Line Item;

	public Miscellaneous Event(){

	}

	public void finalize() throws Throwable {

	}
	public Event Line Item getEvent Line Item(){
		return m_Event Line Item;
	}

	public Code. Type getMiscellaneousEventTypeCode(){
		return MiscellaneousEventTypeCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEvent Line Item(Event Line Item newVal){
		m_Event Line Item = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMiscellaneousEventTypeCode(Code. Type newVal){
		MiscellaneousEventTypeCode = newVal;
	}
}//end Miscellaneous Event