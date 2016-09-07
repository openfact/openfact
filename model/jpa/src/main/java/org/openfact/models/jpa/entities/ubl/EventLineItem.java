package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to define a line item describing the expected impacts associated with
 * a retail event involving a specific product at a specific location.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:56 a. m.
 */
public class EventLineItem {

	/**
	 * The number of this event line item.
	 */
	private BigDecimal lineNumberNumeric;
	private Item supplyItem;
	private Location participatingLocationsLocation;
	private List<RetailPlannedImpact> retailPlannedImpacts=new ArrayList<>();

	public BigDecimal getLineNumberNumeric() {
		return lineNumberNumeric;
	}

	public void setLineNumberNumeric(BigDecimal lineNumberNumeric) {
		this.lineNumberNumeric = lineNumberNumeric;
	}

	public Item getSupplyItem() {
		return supplyItem;
	}

	public void setSupplyItem(Item supplyItem) {
		this.supplyItem = supplyItem;
	}

	public Location getParticipatingLocationsLocation() {
		return participatingLocationsLocation;
	}

	public void setParticipatingLocationsLocation(Location participatingLocationsLocation) {
		this.participatingLocationsLocation = participatingLocationsLocation;
	}

	public List<RetailPlannedImpact> getRetailPlannedImpact() {
		return retailPlannedImpacts;
	}

	public void setRetailPlannedImpact(List<RetailPlannedImpact> retailPlannedImpacts) {
		this.retailPlannedImpacts = retailPlannedImpacts;
	}
}// end Event Line Item