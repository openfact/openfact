

/**
 * A class for assigning identifying information to an item.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:42 a. m.
 */
public class Item Identification {

	/**
	 * An identifier for a system of barcodes.
	 */
	private Identifier. Type BarcodeSymbologyID;
	/**
	 * An extended identifier for the item that identifies the item with specific
	 * properties, e.g., Item 123 = Chair / Item 123 Ext 45 = brown chair. Two chairs
	 * can have the same item number, but one is brown. The other is white.
	 */
	private Identifier. Type ExtendedID;
	/**
	 * An identifier for the item.
	 */
	private Identifier. Type ID;
	private Dimension Measurement Dimension;
	private Party Issuer Party;
	private Physical Attribute m_Physical Attribute;

	public Item Identification(){

	}

	public void finalize() throws Throwable {

	}
	public Identifier. Type getBarcodeSymbologyID(){
		return BarcodeSymbologyID;
	}

	public Identifier. Type getExtendedID(){
		return ExtendedID;
	}

	public Identifier. Type getID(){
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
	public void setBarcodeSymbologyID(Identifier. Type newVal){
		BarcodeSymbologyID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExtendedID(Identifier. Type newVal){
		ExtendedID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(Identifier. Type newVal){
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