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

	private Package m_Package;
	private Shipment m_Shipment;

	public OrderedShipment() {

	}

	public void finalize() throws Throwable {

	}

	public Package getM_Package() {
		return m_Package;
	}

	public void setM_Package(Package m_Package) {
		this.m_Package = m_Package;
	}

	public Shipment getM_Shipment() {
		return m_Shipment;
	}

	public void setM_Shipment(Shipment m_Shipment) {
		this.m_Shipment = m_Shipment;
	}
}// end Ordered Shipment