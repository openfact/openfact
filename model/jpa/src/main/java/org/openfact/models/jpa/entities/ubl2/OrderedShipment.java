

/**
 * A class to describe an ordered shipment.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:20 a. m.
 */
public class OrderedShipment {

	private Package m_Package;
	private Shipment m_Shipment;

	public Ordered Shipment(){

	}

	public void finalize() throws Throwable {

	}
	public Package getPackage(){
		return m_Package;
	}

	public Shipment getShipment(){
		return m_Shipment;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPackage(Package newVal){
		m_Package = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setShipment(Shipment newVal){
		m_Shipment = newVal;
	}
}//end Ordered Shipment