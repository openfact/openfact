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
	private AllowanceCharge Freight AllowanceCharge;
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
	private TransportEvent Exportation TransportEvent;
	private TransportEvent Actual Arrival TransportEvent;
	private TransportEvent Warehousing TransportEvent;
	private TransportEvent Examination TransportEvent;
	private TransportEvent Actual Departure TransportEvent;
	private TransportEvent Estimated Departure TransportEvent;
	private TransportEvent Requested Departure TransportEvent;
	private TransportEvent Planned Waypoint TransportEvent;
	private TransportEvent Optional Takeover TransportEvent;
	private TransportEvent Availability TransportEvent;
	private TransportEvent Loading TransportEvent;
	private TransportEvent Takeover TransportEvent;
	private TransportEvent Requested Arrival TransportEvent;
	private TransportEvent Requested Waypoint TransportEvent;
	private TransportEvent Planned Departure TransportEvent;
	private TransportEvent Planned Arrival TransportEvent;
	private TransportEvent Detention TransportEvent;
	private TransportEvent Discharge TransportEvent;
	private TransportEvent m_TransportEvent;
	private TransportEvent Actual Waypoint TransportEvent;
	private TransportEvent Delivery TransportEvent;
	private TransportEvent Actual Pickup TransportEvent;
	private TransportEvent Dropoff TransportEvent;
	private TransportEvent Receipt TransportEvent;
	private TransportEvent Acceptance TransportEvent;
	private TransportEvent Storage TransportEvent;
	private TransportEvent Estimated Arrival TransportEvent;
	private TransportMeans m_TransportMeans;

	public ShipmentStage(){

	}

	public void finalize() throws Throwable {

	}
	public TransportEvent getAcceptance TransportEvent(){
		return Acceptance TransportEvent;
	}

	public TransportEvent getActual Arrival TransportEvent(){
		return Actual Arrival TransportEvent;
	}

	public TransportEvent getActual Departure TransportEvent(){
		return Actual Departure TransportEvent;
	}

	public TransportEvent getActual Pickup TransportEvent(){
		return Actual Pickup TransportEvent;
	}

	public TransportEvent getActual Waypoint TransportEvent(){
		return Actual Waypoint TransportEvent;
	}

	public TransportEvent getAvailability TransportEvent(){
		return Availability TransportEvent;
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

	public TransportEvent getDelivery TransportEvent(){
		return Delivery TransportEvent;
	}

	public String getDemurrageInstructions(){
		return DemurrageInstructions;
	}

	public TransportEvent getDetention TransportEvent(){
		return Detention TransportEvent;
	}

	public TransportEvent getDischarge TransportEvent(){
		return Discharge TransportEvent;
	}

	public Person getDriver Person(){
		return Driver Person;
	}

	public TransportEvent getDropoff TransportEvent(){
		return Dropoff TransportEvent;
	}

	public TransportEvent getEstimated Arrival TransportEvent(){
		return Estimated Arrival TransportEvent;
	}

	public TransportEvent getEstimated Departure TransportEvent(){
		return Estimated Departure TransportEvent;
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

	public TransportEvent getExamination TransportEvent(){
		return Examination TransportEvent;
	}

	public TransportEvent getExportation TransportEvent(){
		return Exportation TransportEvent;
	}

	public AllowanceCharge getFreight AllowanceCharge(){
		return Freight AllowanceCharge;
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

	public TransportEvent getLoading TransportEvent(){
		return Loading TransportEvent;
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

	public TransportEvent getOptional Takeover TransportEvent(){
		return Optional Takeover TransportEvent;
	}

	public Person getPassenger Person(){
		return Passenger Person;
	}

	public BigDecimal getPassengerQuantity(){
		return PassengerQuantity;
	}

	public TransportEvent getPlanned Arrival TransportEvent(){
		return Planned Arrival TransportEvent;
	}

	public TransportEvent getPlanned Departure TransportEvent(){
		return Planned Departure TransportEvent;
	}

	public TransportEvent getPlanned Waypoint TransportEvent(){
		return Planned Waypoint TransportEvent;
	}

	public boolean getPreCarriageIndicator(){
		return PreCarriageIndicator;
	}

	public TransportEvent getReceipt TransportEvent(){
		return Receipt TransportEvent;
	}

	public Person getReporting Person(){
		return Reporting Person;
	}

	public TransportEvent getRequested Arrival TransportEvent(){
		return Requested Arrival TransportEvent;
	}

	public TransportEvent getRequested Departure TransportEvent(){
		return Requested Departure TransportEvent;
	}

	public TransportEvent getRequested Waypoint TransportEvent(){
		return Requested Waypoint TransportEvent;
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

	public TransportEvent getStorage TransportEvent(){
		return Storage TransportEvent;
	}

	public String getSuccessiveSequenceID(){
		return SuccessiveSequenceID;
	}

	public TransportEvent getTakeover TransportEvent(){
		return Takeover TransportEvent;
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

	public TransportEvent getTransportEvent(){
		return m_TransportEvent;
	}

	public TransportMeans getTransportMeans(){
		return m_TransportMeans;
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

	public TransportEvent getWarehousing TransportEvent(){
		return Warehousing TransportEvent;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAcceptance TransportEvent(TransportEvent newVal){
		Acceptance TransportEvent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActual Arrival TransportEvent(TransportEvent newVal){
		Actual Arrival TransportEvent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActual Departure TransportEvent(TransportEvent newVal){
		Actual Departure TransportEvent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActual Pickup TransportEvent(TransportEvent newVal){
		Actual Pickup TransportEvent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActual Waypoint TransportEvent(TransportEvent newVal){
		Actual Waypoint TransportEvent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAvailability TransportEvent(TransportEvent newVal){
		Availability TransportEvent = newVal;
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
	public void setDelivery TransportEvent(TransportEvent newVal){
		Delivery TransportEvent = newVal;
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
	public void setDetention TransportEvent(TransportEvent newVal){
		Detention TransportEvent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDischarge TransportEvent(TransportEvent newVal){
		Discharge TransportEvent = newVal;
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
	public void setDropoff TransportEvent(TransportEvent newVal){
		Dropoff TransportEvent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEstimated Arrival TransportEvent(TransportEvent newVal){
		Estimated Arrival TransportEvent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEstimated Departure TransportEvent(TransportEvent newVal){
		Estimated Departure TransportEvent = newVal;
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
	public void setExamination TransportEvent(TransportEvent newVal){
		Examination TransportEvent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExportation TransportEvent(TransportEvent newVal){
		Exportation TransportEvent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFreight AllowanceCharge(AllowanceCharge newVal){
		Freight AllowanceCharge = newVal;
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
	public void setLoading TransportEvent(TransportEvent newVal){
		Loading TransportEvent = newVal;
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
	public void setOptional Takeover TransportEvent(TransportEvent newVal){
		Optional Takeover TransportEvent = newVal;
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
	public void setPlanned Arrival TransportEvent(TransportEvent newVal){
		Planned Arrival TransportEvent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPlanned Departure TransportEvent(TransportEvent newVal){
		Planned Departure TransportEvent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPlanned Waypoint TransportEvent(TransportEvent newVal){
		Planned Waypoint TransportEvent = newVal;
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
	public void setReceipt TransportEvent(TransportEvent newVal){
		Receipt TransportEvent = newVal;
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
	public void setRequested Arrival TransportEvent(TransportEvent newVal){
		Requested Arrival TransportEvent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequested Departure TransportEvent(TransportEvent newVal){
		Requested Departure TransportEvent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRequested Waypoint TransportEvent(TransportEvent newVal){
		Requested Waypoint TransportEvent = newVal;
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
	public void setStorage TransportEvent(TransportEvent newVal){
		Storage TransportEvent = newVal;
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
	public void setTakeover TransportEvent(TransportEvent newVal){
		Takeover TransportEvent = newVal;
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
	public void setTransportEvent(TransportEvent newVal){
		m_TransportEvent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportMeans(TransportMeans newVal){
		m_TransportMeans = newVal;
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
	public void setWarehousing TransportEvent(TransportEvent newVal){
		Warehousing TransportEvent = newVal;
	}
}//end ShipmentStage