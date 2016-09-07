package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe one stage of movement in a transport of goods.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:45 a. m.
 */
public class ShipmentStage {

	/**
	 * The total number of crew aboard a transport means.
	 */
	private BigDecimal CrewQuantity;
	/**
	 * Text of instructions relating to demurrage (the case in which a vessel is
	 * prevented from loading or discharging cargo within the stipulated laytime).
	 */
	private String DemurrageInstructions;
	/**
	 * The estimated date of delivery in this shipment stage.
	 */
	private LocalDate EstimatedDeliveryDate;
	/**
	 * The estimated time of delivery in this shipment stage.
	 */
	private LocalTime EstimatedDeliveryTime;
	/**
	 * An identifier for this shipment stage.
	 */
	private String ID;
	/**
	 * Text of instructions applicable to a shipment stage.
	 */
	private String Instructions;
	/**
	 * An identifier for the loading sequence (of consignments) associated with this
	 * shipment stage.
	 */
	private String LoadingSequenceID;
	/**
	 * An indicator that this stage takes place after the main carriage of the
	 * shipment (true) or not (false).
	 */
	private boolean OnCarriageIndicator;
	/**
	 * The total number of passengers aboard a transport means.
	 */
	private BigDecimal PassengerQuantity;
	/**
	 * An indicator that this stage takes place before the main carriage of the
	 * shipment (true) or not (false).
	 */
	private boolean PreCarriageIndicator;
	/**
	 * The delivery date required by the buyer in this shipment stage.
	 */
	private LocalDate RequiredDeliveryDate;
	/**
	 * The delivery time required by the buyer in this shipment stage.
	 */
	private LocalTime RequiredDeliveryTime;
	/**
	 * Identifies the successive loading sequence (of consignments) associated with a
	 * shipment stage.
	 */
	private String SuccessiveSequenceID;
	/**
	 * A code signifying the direction of transit in this shipment stage.
	 */
	private String TransitDirectionCode;
	/**
	 * A code signifying the kind of transport means (truck, vessel, etc.) used for
	 * this shipment stage.
	 */
	private String TransportMeansTypeCode;
	/**
	 * A code signifying the method of transport used for this shipment stage.
	 */
	private Transport Mode_ String TransportModeCode;
	private Allowance Charge Freight Allowance Charge;
	private Location Loading Port Location;
	private Location Transship Port Location;
	private Location Unloading Port Location;
	private Location Freight Charge Location;
	private Party Customs Agent Party;
	private Party Terminal Operator Party;
	private Party Carrier Party;
	private Period Estimated Transit Period;
	private Period Transit Period;
	private Person Reporting Person;
	private Person Ships Surgeon Person;
	private Person Master Person;
	private Person Crew Member Person;
	private Person Driver Person;
	private Person Passenger Person;
	private Person Security Officer Person;
	private Transport Event Exportation Transport Event;
	private Transport Event Actual Arrival Transport Event;
	private Transport Event Warehousing Transport Event;
	private Transport Event Examination Transport Event;
	private Transport Event Actual Departure Transport Event;
	private Transport Event Estimated Departure Transport Event;
	private Transport Event Requested Departure Transport Event;
	private Transport Event Planned Waypoint Transport Event;
	private Transport Event Optional Takeover Transport Event;
	private Transport Event Availability Transport Event;
	private Transport Event Loading Transport Event;
	private Transport Event Takeover Transport Event;
	private Transport Event Requested Arrival Transport Event;
	private Transport Event Requested Waypoint Transport Event;
	private Transport Event Planned Departure Transport Event;
	private Transport Event Planned Arrival Transport Event;
	private Transport Event Detention Transport Event;
	private Transport Event Discharge Transport Event;
	private Transport Event m_Transport Event;
	private Transport Event Actual Waypoint Transport Event;
	private Transport Event Delivery Transport Event;
	private Transport Event Actual Pickup Transport Event;
	private Transport Event Dropoff Transport Event;
	private Transport Event Receipt Transport Event;
	private Transport Event Acceptance Transport Event;
	private Transport Event Storage Transport Event;
	private Transport Event Estimated Arrival Transport Event;
	private Transport Means m_Transport Means;

	public Shipment Stage(){

	}

	public void finalize() throws Throwable {

	}
	public Transport Event getAcceptance Transport Event(){
		return Acceptance Transport Event;
	}

	public Transport Event getActual Arrival Transport Event(){
		return Actual Arrival Transport Event;
	}

	public Transport Event getActual Departure Transport Event(){
		return Actual Departure Transport Event;
	}

	public Transport Event getActual Pickup Transport Event(){
		return Actual Pickup Transport Event;
	}

	public Transport Event getActual Waypoint Transport Event(){
		return Actual Waypoint Transport Event;
	}

	public Transport Event getAvailability Transport Event(){
		return Availability Transport Event;
	}

	public Party getCarrier Party(){
		return Carrier Party;
	}

	public Person getCrew Member Person(){
		return Crew Member Person;
	}

	public BigDecimal getCrewQuantity(){
		return CrewQuantity;
	}

	public Party getCustoms Agent Party(){
		return Customs Agent Party;
	}

	public Transport Event getDelivery Transport Event(){
		return Delivery Transport Event;
	}

	public String getDemurrageInstructions(){
		return DemurrageInstructions;
	}

	public Transport Event getDetention Transport Event(){
		return Detention Transport Event;
	}

	public Transport Event getDischarge Transport Event(){
		return Discharge Transport Event;
	}

	public Person getDriver Person(){
		return Driver Person;
	}

	public Transport Event getDropoff Transport Event(){
		return Dropoff Transport Event;
	}

	public Transport Event getEstimated Arrival Transport Event(){
		return Estimated Arrival Transport Event;
	}

	public Transport Event getEstimated Departure Transport Event(){
		return Estimated Departure Transport Event;
	}

	public Period getEstimated Transit Period(){
		return Estimated Transit Period;
	}

	public LocalDate getEstimatedDeliveryDate(){
		return EstimatedDeliveryDate;
	}

	public LocalTime getEstimatedDeliveryTime(){
		return EstimatedDeliveryTime;
	}

	public Transport Event getExamination Transport Event(){
		return Examination Transport Event;
	}

	public Transport Event getExportation Transport Event(){
		return Exportation Transport Event;
	}

	public Allowance Charge getFreight Allowance Charge(){
		return Freight Allowance Charge;
	}

	public Location getFreight Charge Location(){
		return Freight Charge Location;
	}

	public String getID(){
		return ID;
	}

	public String getInstructions(){
		return Instructions;
	}

	public Location getLoading Port Location(){
		return Loading Port Location;
	}

	public Transport Event getLoading Transport Event(){
		return Loading Transport Event;
	}

	public String getLoadingSequenceID(){
		return LoadingSequenceID;
	}

	public Person getMaster Person(){
		return Master Person;
	}

	public boolean getOnCarriageIndicator(){
		return OnCarriageIndicator;
	}

	public Transport Event getOptional Takeover Transport Event(){
		return Optional Takeover Transport Event;
	}

	public Person getPassenger Person(){
		return Passenger Person;
	}

	public BigDecimal getPassengerQuantity(){
		return PassengerQuantity;
	}

	public Transport Event getPlanned Arrival Transport Event(){
		return Planned Arrival Transport Event;
	}

	public Transport Event getPlanned Departure Transport Event(){
		return Planned Departure Transport Event;
	}

	public Transport Event getPlanned Waypoint Transport Event(){
		return Planned Waypoint Transport Event;
	}

	public boolean getPreCarriageIndicator(){
		return PreCarriageIndicator;
	}

	public Transport Event getReceipt Transport Event(){
		return Receipt Transport Event;
	}

	public Person getReporting Person(){
		return Reporting Person;
	}

	public Transport Event getRequested Arrival Transport Event(){
		return Requested Arrival Transport Event;
	}

	public Transport Event getRequested Departure Transport Event(){
		return Requested Departure Transport Event;
	}

	public Transport Event getRequested Waypoint Transport Event(){
		return Requested Waypoint Transport Event;
	}

	public LocalDate getRequiredDeliveryDate(){
		return RequiredDeliveryDate;
	}

	public LocalTime getRequiredDeliveryTime(){
		return RequiredDeliveryTime;
	}

	public Person getSecurity Officer Person(){
		return Security Officer Person;
	}

	public Person getShips Surgeon Person(){
		return Ships Surgeon Person;
	}

	public Transport Event getStorage Transport Event(){
		return Storage Transport Event;
	}

	public String getSuccessiveSequenceID(){
		return SuccessiveSequenceID;
	}

	public Transport Event getTakeover Transport Event(){
		return Takeover Transport Event;
	}

	public Party getTerminal Operator Party(){
		return Terminal Operator Party;
	}

	public Period getTransit Period(){
		return Transit Period;
	}

	public String getTransitDirectionCode(){
		return TransitDirectionCode;
	}

	public Transport Event getTransport Event(){
		return m_Transport Event;
	}

	public Transport Means getTransport Means(){
		return m_Transport Means;
	}

	public String getTransportMeansTypeCode(){
		return TransportMeansTypeCode;
	}

	public Transport Mode_ String getTransportModeCode(){
		return TransportModeCode;
	}

	public Location getTransship Port Location(){
		return Transship Port Location;
	}

	public Location getUnloading Port Location(){
		return Unloading Port Location;
	}

	public Transport Event getWarehousing Transport Event(){
		return Warehousing Transport Event;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAcceptance Transport Event(Transport Event newVal){
		Acceptance Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActual Arrival Transport Event(Transport Event newVal){
		Actual Arrival Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActual Departure Transport Event(Transport Event newVal){
		Actual Departure Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActual Pickup Transport Event(Transport Event newVal){
		Actual Pickup Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActual Waypoint Transport Event(Transport Event newVal){
		Actual Waypoint Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAvailability Transport Event(Transport Event newVal){
		Availability Transport Event = newVal;
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
	public void setCrew Member Person(Person newVal){
		Crew Member Person = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCrewQuantity(BigDecimal newVal){
		CrewQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCustoms Agent Party(Party newVal){
		Customs Agent Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDelivery Transport Event(Transport Event newVal){
		Delivery Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDemurrageInstructions(String newVal){
		DemurrageInstructions = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDetention Transport Event(Transport Event newVal){
		Detention Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDischarge Transport Event(Transport Event newVal){
		Discharge Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDriver Person(Person newVal){
		Driver Person = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDropoff Transport Event(Transport Event newVal){
		Dropoff Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEstimated Arrival Transport Event(Transport Event newVal){
		Estimated Arrival Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEstimated Departure Transport Event(Transport Event newVal){
		Estimated Departure Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEstimated Transit Period(Period newVal){
		Estimated Transit Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEstimatedDeliveryDate(LocalDate newVal){
		EstimatedDeliveryDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEstimatedDeliveryTime(LocalTime newVal){
		EstimatedDeliveryTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExamination Transport Event(Transport Event newVal){
		Examination Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExportation Transport Event(Transport Event newVal){
		Exportation Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFreight Allowance Charge(Allowance Charge newVal){
		Freight Allowance Charge = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFreight Charge Location(Location newVal){
		Freight Charge Location = newVal;
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
	public void setInstructions(String newVal){
		Instructions = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLoading Port Location(Location newVal){
		Loading Port Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLoading Transport Event(Transport Event newVal){
		Loading Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLoadingSequenceID(String newVal){
		LoadingSequenceID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaster Person(Person newVal){
		Master Person = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOnCarriageIndicator(boolean newVal){
		OnCarriageIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOptional Takeover Transport Event(Transport Event newVal){
		Optional Takeover Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPassenger Person(Person newVal){
		Passenger Person = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPassengerQuantity(BigDecimal newVal){
		PassengerQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPlanned Arrival Transport Event(Transport Event newVal){
		Planned Arrival Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPlanned Departure Transport Event(Transport Event newVal){
		Planned Departure Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPlanned Waypoint Transport Event(Transport Event newVal){
		Planned Waypoint Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPreCarriageIndicator(boolean newVal){
		PreCarriageIndicator = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReceipt Transport Event(Transport Event newVal){
		Receipt Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReporting Person(Person newVal){
		Reporting Person = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequested Arrival Transport Event(Transport Event newVal){
		Requested Arrival Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequested Departure Transport Event(Transport Event newVal){
		Requested Departure Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequested Waypoint Transport Event(Transport Event newVal){
		Requested Waypoint Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequiredDeliveryDate(LocalDate newVal){
		RequiredDeliveryDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequiredDeliveryTime(LocalTime newVal){
		RequiredDeliveryTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSecurity Officer Person(Person newVal){
		Security Officer Person = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setShips Surgeon Person(Person newVal){
		Ships Surgeon Person = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStorage Transport Event(Transport Event newVal){
		Storage Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSuccessiveSequenceID(String newVal){
		SuccessiveSequenceID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTakeover Transport Event(Transport Event newVal){
		Takeover Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTerminal Operator Party(Party newVal){
		Terminal Operator Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransit Period(Period newVal){
		Transit Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransitDirectionCode(String newVal){
		TransitDirectionCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransport Event(Transport Event newVal){
		m_Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransport Means(Transport Means newVal){
		m_Transport Means = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportMeansTypeCode(String newVal){
		TransportMeansTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportModeCode(Transport Mode_ String newVal){
		TransportModeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransship Port Location(Location newVal){
		Transship Port Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUnloading Port Location(Location newVal){
		Unloading Port Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWarehousing Transport Event(Transport Event newVal){
		Warehousing Transport Event = newVal;
	}
}//end Shipment Stage