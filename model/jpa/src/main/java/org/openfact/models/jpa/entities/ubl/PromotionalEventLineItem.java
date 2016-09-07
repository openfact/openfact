package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe a line item associated with a promotional event.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:10 a. m.
 */
public class PromotionalEventLineItem {

	/**
	 * The amount associated with this promotional event line item.
	 */
	private BigDecimal Amount;
	private EventLineItem m_EventLineItem;

	public PromotionalEventLineItem() {

	}

	public void finalize() throws Throwable {

	}

	public BigDecimal getAmount() {
		return Amount;
	}

	public EventLineItem getEventLineItem() {
		return m_EventLineItem;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAmount(BigDecimal newVal) {
		Amount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEventLineItem(EventLineItem newVal) {
		m_EventLineItem = newVal;
	}
}// end Promotional Event Line Item