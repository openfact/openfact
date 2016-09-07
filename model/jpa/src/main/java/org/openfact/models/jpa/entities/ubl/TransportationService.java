package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a transportation service.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:52 a. m.
 */
public class TransportationService {

	/**
	 * A code signifying the rate class for freight in this transportation service.
	 */
	private String FreightRateClassCode;
	/**
	 * The name of this transportation service.
	 */
	private String Name;
	/**
	 * In a transport contract, the deadline date by which this transportation service
	 * has to be booked. For example, if this service is scheduled for Wednesday 16
	 * February 2011 at 10 a.m. CET, the nomination date might be Tuesday15 February
	 * 2011.
	 */
	private LocalDate NominationDate;
	/**
	 * In a transport contract, the deadline time by which this transportation service
	 * has to be booked. For example, if this service is scheduled for Wednesday 16
	 * February 2011 at 10 a.m. CET, the nomination date might be Tuesday15 February
	 * 2011 and the nominat
	 */
	private LocalTime NominationTime;
	/**
	 * The priority of this transportation service.
	 */
	private String Priority;
	/**
	 * A number indicating the order of this transportation service in a sequence of
	 * transportation services.
	 */
	private BigDecimal SequenceNumeric;
	/**
	 * A code signifying the tariff class applicable to this transportation service.
	 */
	private String TariffClassCode;
	/**
	 * Text describing this transportation service.
	 */
	private String TransportationServiceDescription;
	/**
	 * The Uniform Resource Identifier (URI) of a document providing additional
	 * details regarding this transportation service.
	 */
	private String TransportationServiceDetailsURIID;
	/**
	 * A code signifying the extent of this transportation service (e.g., door-to-door,
	 * port-to-port).
	 */
	private String TransportServiceCode;
	private Commodity Classification Unsupported Commodity Classification;
	private Commodity Classification Supported Commodity Classification;
	private Commodity Classification m_Commodity Classification;
	private Dimension Total Capacity Dimension;
	private Environmental Emission m_Environmental Emission;
	private Party Responsible Transport Service Provider Party;
	private Period Estimated Duration Period;
	private Service Frequency Scheduled Service Frequency;
	private Shipment Stage m_Shipment Stage;
	private Transport Equipment Unsupported Transport Equipment;
	private Transport Equipment m_Transport Equipment;
	private Transport Equipment Supported Transport Equipment;
	private Transport Event m_Transport Event;

	public Transportation Service(){

	}

	public void finalize() throws Throwable {

	}
	public Commodity Classification getCommodity Classification(){
		return m_Commodity Classification;
	}

	public Environmental Emission getEnvironmental Emission(){
		return m_Environmental Emission;
	}

	public Period getEstimated Duration Period(){
		return Estimated Duration Period;
	}

	public String getFreightRateClassCode(){
		return FreightRateClassCode;
	}

	public String getName(){
		return Name;
	}

	public LocalDate getNominationDate(){
		return NominationDate;
	}

	public LocalTime getNominationTime(){
		return NominationTime;
	}

	public String getPriority(){
		return Priority;
	}

	public Party getResponsible Transport Service Provider Party(){
		return Responsible Transport Service Provider Party;
	}

	public Service Frequency getScheduled Service Frequency(){
		return Scheduled Service Frequency;
	}

	public BigDecimal getSequenceNumeric(){
		return SequenceNumeric;
	}

	public Shipment Stage getShipment Stage(){
		return m_Shipment Stage;
	}

	public Commodity Classification getSupported Commodity Classification(){
		return Supported Commodity Classification;
	}

	public Transport Equipment getSupported Transport Equipment(){
		return Supported Transport Equipment;
	}

	public String getTariffClassCode(){
		return TariffClassCode;
	}

	public Dimension getTotal Capacity Dimension(){
		return Total Capacity Dimension;
	}

	public Transport Equipment getTransport Equipment(){
		return m_Transport Equipment;
	}

	public Transport Event getTransport Event(){
		return m_Transport Event;
	}

	public String getTransportationServiceDescription(){
		return TransportationServiceDescription;
	}

	public String getTransportationServiceDetailsURIID(){
		return TransportationServiceDetailsURIID;
	}

	public String getTransportServiceCode(){
		return TransportServiceCode;
	}

	public Commodity Classification getUnsupported Commodity Classification(){
		return Unsupported Commodity Classification;
	}

	public Transport Equipment getUnsupported Transport Equipment(){
		return Unsupported Transport Equipment;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCommodity Classification(Commodity Classification newVal){
		m_Commodity Classification = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEnvironmental Emission(Environmental Emission newVal){
		m_Environmental Emission = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEstimated Duration Period(Period newVal){
		Estimated Duration Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFreightRateClassCode(String newVal){
		FreightRateClassCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(String newVal){
		Name = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNominationDate(LocalDate newVal){
		NominationDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNominationTime(LocalTime newVal){
		NominationTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPriority(String newVal){
		Priority = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setResponsible Transport Service Provider Party(Party newVal){
		Responsible Transport Service Provider Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setScheduled Service Frequency(Service Frequency newVal){
		Scheduled Service Frequency = newVal;
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
	public void setSupported Commodity Classification(Commodity Classification newVal){
		Supported Commodity Classification = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSupported Transport Equipment(Transport Equipment newVal){
		Supported Transport Equipment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTariffClassCode(String newVal){
		TariffClassCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotal Capacity Dimension(Dimension newVal){
		Total Capacity Dimension = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransport Equipment(Transport Equipment newVal){
		m_Transport Equipment = newVal;
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
	public void setTransportationServiceDescription(String newVal){
		TransportationServiceDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportationServiceDetailsURIID(String newVal){
		TransportationServiceDetailsURIID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportServiceCode(String newVal){
		TransportServiceCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUnsupported Commodity Classification(Commodity Classification newVal){
		Unsupported Commodity Classification = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUnsupported Transport Equipment(Transport Equipment newVal){
		Unsupported Transport Equipment = newVal;
	}
}//end Transportation Service