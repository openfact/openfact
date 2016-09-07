package org.openfact.models.jpa.entities.ubl2;


/**
 * A class to describe a delivery.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:22 a. m.
 */
public class Delivery {

	/**
	 * The actual date of delivery.
	 */
	private Date. Type ActualDeliveryDate;
	/**
	 * The actual time of delivery.
	 */
	private Time. Type ActualDeliveryTime;
	/**
	 * An identifier for this delivery.
	 */
	private Identifier. Type ID;
	/**
	 * The latest date of delivery allowed by the buyer.
	 */
	private Date. Type LatestDeliveryDate;
	/**
	 * The latest time of delivery allowed by the buyer.
	 */
	private Time. Type LatestDeliveryTime;
	/**
	 * The maximum quantity of items, child consignments, shipments in this delivery.
	 */
	private Quantity. Type MaximumQuantity;
	/**
	 * The minimum quantity of items, child consignments, shipments in this delivery.
	 */
	private Quantity. Type MinimumQuantity;
	/**
	 * The quantity of items, child consignments, shipments in this delivery.
	 */
	private Quantity. Type Quantity;
	/**
	 * An identifier used for approval of access to delivery locations (e.g., port
	 * terminals).
	 */
	private Identifier. Type ReleaseID;
	/**
	 * The delivery Tracking ID (for transport tracking).
	 */
	private Identifier. Type TrackingID;
	private Address Delivery Address;
	private Delivery Unit Maximum Delivery Unit;
	private Delivery Unit Minimum Delivery Unit;
	private Despatch m_Despatch;
	private Period Estimated Delivery Period;
	private Period Promised Delivery Period;
	private Period Requested Delivery Period;
	private Location Delivery Location;
	private Location Alternative Delivery Location;
	private Party Notify Party;
	private Party Carrier Party;
	private Party Delivery Party;
	private Shipment m_Shipment;
	private Delivery Terms m_Delivery Terms;

	public Delivery(){

	}

	public void finalize() throws Throwable {

	}
	public Date. Type getActualDeliveryDate(){
		return ActualDeliveryDate;
	}

	public Time. Type getActualDeliveryTime(){
		return ActualDeliveryTime;
	}

	public Location getAlternative Delivery Location(){
		return Alternative Delivery Location;
	}

	public Party getCarrier Party(){
		return Carrier Party;
	}

	public Address getDelivery Address(){
		return Delivery Address;
	}

	public Location getDelivery Location(){
		return Delivery Location;
	}

	public Party getDelivery Party(){
		return Delivery Party;
	}

	public Delivery Terms getDelivery Terms(){
		return m_Delivery Terms;
	}

	public Despatch getDespatch(){
		return m_Despatch;
	}

	public Period getEstimated Delivery Period(){
		return Estimated Delivery Period;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Date. Type getLatestDeliveryDate(){
		return LatestDeliveryDate;
	}

	public Time. Type getLatestDeliveryTime(){
		return LatestDeliveryTime;
	}

	public Delivery Unit getMaximum Delivery Unit(){
		return Maximum Delivery Unit;
	}

	public Quantity. Type getMaximumQuantity(){
		return MaximumQuantity;
	}

	public Delivery Unit getMinimum Delivery Unit(){
		return Minimum Delivery Unit;
	}

	public Quantity. Type getMinimumQuantity(){
		return MinimumQuantity;
	}

	public Party getNotify Party(){
		return Notify Party;
	}

	public Period getPromised Delivery Period(){
		return Promised Delivery Period;
	}

	public Quantity. Type getQuantity(){
		return Quantity;
	}

	public Identifier. Type getReleaseID(){
		return ReleaseID;
	}

	public Period getRequested Delivery Period(){
		return Requested Delivery Period;
	}

	public Shipment getShipment(){
		return m_Shipment;
	}

	public Identifier. Type getTrackingID(){
		return TrackingID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActualDeliveryDate(Date. Type newVal){
		ActualDeliveryDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActualDeliveryTime(Time. Type newVal){
		ActualDeliveryTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAlternative Delivery Location(Location newVal){
		Alternative Delivery Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCarrier Party(Party newVal){
		Carrier Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDelivery Address(Address newVal){
		Delivery Address = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDelivery Location(Location newVal){
		Delivery Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDelivery Party(Party newVal){
		Delivery Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDelivery Terms(Delivery Terms newVal){
		m_Delivery Terms = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDespatch(Despatch newVal){
		m_Despatch = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEstimated Delivery Period(Period newVal){
		Estimated Delivery Period = newVal;
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
	public void setLatestDeliveryDate(Date. Type newVal){
		LatestDeliveryDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLatestDeliveryTime(Time. Type newVal){
		LatestDeliveryTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximum Delivery Unit(Delivery Unit newVal){
		Maximum Delivery Unit = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumQuantity(Quantity. Type newVal){
		MaximumQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimum Delivery Unit(Delivery Unit newVal){
		Minimum Delivery Unit = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumQuantity(Quantity. Type newVal){
		MinimumQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNotify Party(Party newVal){
		Notify Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPromised Delivery Period(Period newVal){
		Promised Delivery Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setQuantity(Quantity. Type newVal){
		Quantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReleaseID(Identifier. Type newVal){
		ReleaseID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequested Delivery Period(Period newVal){
		Requested Delivery Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setShipment(Shipment newVal){
		m_Shipment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTrackingID(Identifier. Type newVal){
		TrackingID = newVal;
	}
}//end Delivery