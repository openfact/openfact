package org.openfact.models.jpa.entities.ubl;


/**
 * A class for assigning identifying information to an item.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:42 a. m.
 */
public class ItemIdentification {

	/**
	 * An identifier for a system of barcodes.
	 */
	private String BarcodeSymbologyID;
	/**
	 * An extended identifier for the item that identifies the item with specific
	 * properties, e.g., Item 123 = Chair / Item 123 Ext 45 = brown chair. Two chairs
	 * can have the same item number, but one is brown. The other is white.
	 */
	private String ExtendedID;
	/**
	 * An identifier for the item.
	 */
	private String ID;
	private Dimension Measurement Dimension;
	private Party Issuer Party;
	private Physical Attribute m_Physical Attribute;

	public Item Identification(){

	}

	public void finalize() throws Throwable {

	}
	public String getBarcodeSymbologyID(){
		return BarcodeSymbologyID;
	}

	public String getExtendedID(){
		return ExtendedID;
	}

	public String getID(){
		return ID;
	}

	public Party getIssuer Party(){
		return Issuer Party;
	}

	public Dimension getMeasurement Dimension(){
		return Measurement Dimension;
	}

	public Physical Attribute getPhysical Attribute(){
		return m_Physical Attribute;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBarcodeSymbologyID(String newVal){
		BarcodeSymbologyID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExtendedID(String newVal){
		ExtendedID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssuer Party(Party newVal){
		Issuer Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMeasurement Dimension(Dimension newVal){
		Measurement Dimension = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPhysical Attribute(Physical Attribute newVal){
		m_Physical Attribute = newVal;
	}
}//end Item Identification