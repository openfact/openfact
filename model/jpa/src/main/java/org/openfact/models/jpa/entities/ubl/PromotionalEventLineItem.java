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
	private BigDecimal amount;
	private List<EventLineItem> eventLineItems=new ArrayList<>();

	public PromotionalEventLineItem() {

	}

	public void finalize() throws Throwable {

	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public List<EventLineItem> getEventLineItems() {
		return eventLineItems;
	}

	public void setEventLineItems(List<EventLineItem> eventLineItems) {
		this.eventLineItems = eventLineItems;
	}
}// end Promotional Event Line Item