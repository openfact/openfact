package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class defining a specific type of action or situation arranged by the Buyer
 * or the Seller to promote the product or products.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:58 a. m.
 */
public class EventTactic {

	/**
	 * Generic field to add additional information or to specify mutually
	 * defined eventTacticTypes that are not currently listed.
	 */
	private String comment;
	/**
	 * The currencies, units, etc. that describes what is need for the event or
	 * promotion Usage example: Number of pallets per store for a stack display
	 */
	private BigDecimal quantity;
	private List<EventTacticEnumeration> eventTacticEnumerations=new ArrayList<>();
	private List<Period> periods=new ArrayList<>();

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public List<EventTacticEnumeration> getEventTacticEnumerations() {
		return eventTacticEnumerations;
	}

	public void setEventTacticEnumerations(List<EventTacticEnumeration> eventTacticEnumerations) {
		this.eventTacticEnumerations = eventTacticEnumerations;
	}

	public List<Period> getPeriods() {
		return periods;
	}

	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}
}// end Event Tactic