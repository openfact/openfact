

/**
 * A class to describe a particular vehicle or vessel used for the conveyance of
 * goods or persons.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:48 a. m.
 */
public class TransportMeans {

	/**
	 * A code signifying the direction of this means of transport.
	 */
	private Code. Type DirectionCode;
	/**
	 * An identifier for the regular service schedule of this means of transport.
	 */
	private Identifier. Type JourneyID;
	/**
	 * Text describing the country in which this means of transport is registered.
	 */
	private Text. Type RegistrationNationality;
	/**
	 * An identifier for the country in which this means of transport is registered.
	 */
	private Identifier. Type RegistrationNationalityID;
	/**
	 * A code signifying the service regularly provided by the carrier operating this
	 * means of transport.
	 */
	private Code. Type TradeServiceCode;
	/**
	 * A code signifying the type of this means of transport (truck, vessel, etc.).
	 */
	private Code. Type TransportMeansTypeCode;
	private Air Transport m_Air Transport;
	private Dimension Measurement Dimension;
	private Maritime Transport m_Maritime Transport;
	private Party Owner Party;
	private Rail Transport m_Rail Transport;
	private Road Transport m_Road Transport;
	private Stowage m_Stowage;

	public Transport Means(){

	}

	public void finalize() throws Throwable {

	}
	public Air Transport getAir Transport(){
		return m_Air Transport;
	}

	public Code. Type getDirectionCode(){
		return DirectionCode;
	}

	public Identifier. Type getJourneyID(){
		return JourneyID;
	}

	public Maritime Transport getMaritime Transport(){
		return m_Maritime Transport;
	}

	public Dimension getMeasurement Dimension(){
		return Measurement Dimension;
	}

	public Party getOwner Party(){
		return Owner Party;
	}

	public Rail Transport getRail Transport(){
		return m_Rail Transport;
	}

	public Text. Type getRegistrationNationality(){
		return RegistrationNationality;
	}

	public Identifier. Type getRegistrationNationalityID(){
		return RegistrationNationalityID;
	}

	public Road Transport getRoad Transport(){
		return m_Road Transport;
	}

	public Stowage getStowage(){
		return m_Stowage;
	}

	public Code. Type getTradeServiceCode(){
		return TradeServiceCode;
	}

	public Code. Type getTransportMeansTypeCode(){
		return TransportMeansTypeCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAir Transport(Air Transport newVal){
		m_Air Transport = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDirectionCode(Code. Type newVal){
		DirectionCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setJourneyID(Identifier. Type newVal){
		JourneyID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaritime Transport(Maritime Transport newVal){
		m_Maritime Transport = newVal;
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
	public void setOwner Party(Party newVal){
		Owner Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRail Transport(Rail Transport newVal){
		m_Rail Transport = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRegistrationNationality(Text. Type newVal){
		RegistrationNationality = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRegistrationNationalityID(Identifier. Type newVal){
		RegistrationNationalityID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRoad Transport(Road Transport newVal){
		m_Road Transport = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStowage(Stowage newVal){
		m_Stowage = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTradeServiceCode(Code. Type newVal){
		TradeServiceCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTransportMeansTypeCode(Code. Type newVal){
		TransportMeansTypeCode = newVal;
	}
}//end Transport Means