package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe an ordered shipment.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:20 a. m.
 */
public class OrderedShipment {

	private List<Package> packages = new ArrayList<>();
	private List<Shipment> shipments = new ArrayList<>();

	public OrderedShipment() {

	}

	public void finalize() throws Throwable {

	}

	public List<Package> getPackages() {
		return packages;
	}

	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}

	public List<Shipment> getShipments() {
		return shipments;
	}

	public void setShipments(List<Shipment> shipments) {
		this.shipments = shipments;
	}
}// end Ordered Shipment