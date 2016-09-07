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
	private EventTacticEnumeration m_EventTacticEnumeration;
	private Period m_Period;

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

	public EventTacticEnumeration getM_EventTacticEnumeration() {
		return m_EventTacticEnumeration;
	}

	public void setM_EventTacticEnumeration(EventTacticEnumeration m_EventTacticEnumeration) {
		this.m_EventTacticEnumeration = m_EventTacticEnumeration;
	}

	public Period getM_Period() {
		return m_Period;
	}

	public void setM_Period(Period m_Period) {
		this.m_Period = m_Period;
	}
}// end Event Tactic