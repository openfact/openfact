

/**
 * A class to describe one segment or leg in a transportation service.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:51 a. m.
 */
public class Transportation Segment {

	/**
	 * A number indicating the order of this segment in the sequence of transportation
	 * segments making up a transportation service.
	 */
	private Numeric. Type SequenceNumeric;
	/**
	 * An identifier for the transport execution plan governing this transportation
	 * segment.
	 */
	private Identifier. Type TransportExecutionPlanReferenceID;
	private Consignment Referenced Consignment;
	private Party Transport Service Provider Party;
	private Shipment Stage m_Shipment Stage;
	private Transportation Service m_Transportation Service;

	public Transportation Segment(){

	}

	public void finalize() throws Throwable {

	}
	public Consignment getReferenced Consignment(){
		return Referenced Consignment;
	}

	public Numeric. Type getSequenceNumeric(){
		return SequenceNumeric;
	}

	public Shipment Stage getShipment Stage(){
		return m_Shipment Stage;
	}

	public Party getTransport Service Provider Party(){
		return Transport Service Provider Party;
	}

	public Transportation Service getTransportation Service(){
		return m_Transportation Service;
	}

	public Identifier. Type getTransportExecutionPlanReferenceID(){
		return TransportExecutionPlanReferenceID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReferenced Consignment(Consignment newVal){
		Referenced Consignment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSequenceNumeric(Numeric. Type newVal){
		SequenceNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setShipment Stage(Shipment Stage newVal){
		m_Shipment Stage = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransport Service Provider Party(Party newVal){
		Transport Service Provider Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportation Service(Transportation Service newVal){
		m_Transportation Service = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportExecutionPlanReferenceID(Identifier. Type newVal){
		TransportExecutionPlanReferenceID = newVal;
	}
}//end Transportation Segment