package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe one segment or leg in a transportation service.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:51 a. m.
 */
public class TransportationSegment {

	/**
	 * A number indicating the order of this segment in the sequence of transportation
	 * segments making up a transportation service.
	 */
	private BigDecimal SequenceNumeric;
	/**
	 * An identifier for the transport execution plan governing this transportation
	 * segment.
	 */
	private String TransportExecutionPlanReferenceID;
	private Consignment Referenced Consignment;
	private Party Transport Service Provider Party;
	private Shipment Stage m_Shipment Stage;
	private TransportationService m_TransportationService;

	public Transportation Segment(){

	}

	public void finalize() throws Throwable {

	}
	public Consignment getReferenced Consignment(){
		return Referenced Consignment;
	}

	public BigDecimal getSequenceNumeric(){
		return SequenceNumeric;
	}

	public Shipment Stage getShipment Stage(){
		return m_Shipment Stage;
	}

	public Party getTransport Service Provider Party(){
		return Transport Service Provider Party;
	}

	public TransportationService getTransportationService(){
		return m_TransportationService;
	}

	public String getTransportExecutionPlanReferenceID(){
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
	public void setSequenceNumeric(BigDecimal newVal){
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
	public void setTransportationService(TransportationService newVal){
		m_TransportationService = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportExecutionPlanReferenceID(String newVal){
		TransportExecutionPlanReferenceID = newVal;
	}
}//end Transportation Segment