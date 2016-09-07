package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class for assigning identifying information to an item.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:42 a. m.
 */
public class ItemIdentification {

	/**
	 * An identifier for a system of barcodes.
	 */
	private String barcodeSymbologyID;
	/**
	 * An extended identifier for the item that identifies the item with
	 * specific properties, e.g., Item 123 = Chair / Item 123 Ext 45 = brown
	 * chair. Two chairs can have the same item number, but one is brown. The
	 * other is white.
	 */
	private String extendedID;
	/**
	 * An identifier for the item.
	 */
	private String ID;
	private Dimension measurementDimension;
	private Party issuerParty;
	private PhysicalAttribute m_PhysicalAttribute;

	public String getBarcodeSymbologyID() {
		return barcodeSymbologyID;
	}

	public void setBarcodeSymbologyID(String barcodeSymbologyID) {
		this.barcodeSymbologyID = barcodeSymbologyID;
	}

	public String getExtendedID() {
		return extendedID;
	}

	public void setExtendedID(String extendedID) {
		this.extendedID = extendedID;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public Dimension getMeasurementDimension() {
		return measurementDimension;
	}

	public void setMeasurementDimension(Dimension measurementDimension) {
		this.measurementDimension = measurementDimension;
	}

	public Party getIssuerParty() {
		return issuerParty;
	}

	public void setIssuerParty(Party issuerParty) {
		this.issuerParty = issuerParty;
	}

	public PhysicalAttribute getM_PhysicalAttribute() {
		return m_PhysicalAttribute;
	}

	public void setM_PhysicalAttribute(PhysicalAttribute m_PhysicalAttribute) {
		this.m_PhysicalAttribute = m_PhysicalAttribute;
	}
}// end Item Identification