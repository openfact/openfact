package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe a promotional event as a set of item locations that share
 * a set of promotional tactics.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:11 a. m.
 */
public class PromotionalSpecification {

	/**
	 * An identifier for this promotional specification.
	 */
	private String SpecificationID;
	private EventTactic m_EventTactic;
	private PromotionalEventLineItem m_PromotionalEventLineItem;

	public PromotionalSpecification() {

	}

	public void finalize() throws Throwable {

	}

	public EventTactic getEventTactic() {
		return m_EventTactic;
	}

	public PromotionalEventLineItem getPromotionalEventLineItem() {
		return m_PromotionalEventLineItem;
	}

	public String getSpecificationID() {
		return SpecificationID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEventTactic(EventTactic newVal) {
		m_EventTactic = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPromotionalEventLineItem(PromotionalEventLineItem newVal) {
		m_PromotionalEventLineItem = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSpecificationID(String newVal) {
		SpecificationID = newVal;
	}
}// end Promotional Specification