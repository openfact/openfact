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
	private String specificationID;
	private List<EventTactic> eventTactics=new ArrayList<>();
	private List<PromotionalEventLineItem> promotionalEventLineItems=new ArrayList<>();

	public PromotionalSpecification() {

	}

	public void finalize() throws Throwable {

	}

	public String getSpecificationID() {
		return specificationID;
	}

	public void setSpecificationID(String specificationID) {
		this.specificationID = specificationID;
	}

	public List<EventTactic> getEventTactics() {
		return eventTactics;
	}

	public void setEventTactics(List<EventTactic> eventTactics) {
		this.eventTactics = eventTactics;
	}

	public List<PromotionalEventLineItem> getPromotionalEventLineItems() {
		return promotionalEventLineItems;
	}

	public void setPromotionalEventLineItems(List<PromotionalEventLineItem> promotionalEventLineItems) {
		this.promotionalEventLineItems = promotionalEventLineItems;
	}
}// end Promotional Specification