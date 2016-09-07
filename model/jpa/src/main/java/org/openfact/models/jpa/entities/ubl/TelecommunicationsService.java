package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a telecommunications service (e.g., a telephone call or a
 * video on demand service).
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:09 a. m.
 */
public class TelecommunicationsService {

	/**
	 * The amount to be payed as the base for one call
	 */
	private BigDecimal CallBaseAmount;
	/**
	 * In the case of a telephone call, the date of the call.
	 */
	private LocalDate CallDate;
	/**
	 * The amount to be payed for the call
	 */
	private BigDecimal CallExtensionAmount;
	/**
	 * In the case of a telephone call, the time of the call.
	 */
	private LocalTime CallTime;
	/**
	 * An identifier for this telecommunications service.
	 */
	private String ID;
	/**
	 * The title of a movie delivered via this telecommunications service.
	 */
	private String MovieTitle;
	/**
	 * A pay-per-view delivered via this telecommunications service.
	 */
	private String PayPerView;
	/**
	 * The number of calls.
	 */
	private BigDecimal Quantity;
	/**
	 * Statement of the roaming partner name.
	 */
	private String RoamingPartnerName;
	/**
	 * In the case of a telephone call, the phone number called.
	 */
	private String ServiceNumberCalled;
	/**
	 * The telecommunications call described as a text
	 */
	private String TelecommunicationsServiceCall;
	/**
	 * The telecommunications call described as a code
	 */
	private String TelecommunicationsServiceCallCode;
	/**
	 * The telecommunications category, expressed as text.
	 */
	private String TelecommunicationsServiceCategory;
	/**
	 * The telecommunications category, expressed as a code.
	 */
	private String TelecommunicationsServiceCategoryCode;
	private Allowance Charge m_Allowance Charge;
	private Country m_Country;
	private Duty Call Duty;
	private Duty Time Duty;
	private Exchange Rate m_Exchange Rate;
	private Price m_Price;
	private Tax Total m_Tax Total;

	public Telecommunications Service(){

	}

	public void finalize() throws Throwable {

	}
	public Allowance Charge getAllowance Charge(){
		return m_Allowance Charge;
	}

	public Duty getCall Duty(){
		return Call Duty;
	}

	public BigDecimal getCallBaseAmount(){
		return CallBaseAmount;
	}

	public LocalDate getCallDate(){
		return CallDate;
	}

	public BigDecimal getCallExtensionAmount(){
		return CallExtensionAmount;
	}

	public LocalTime getCallTime(){
		return CallTime;
	}

	public Country getCountry(){
		return m_Country;
	}

	public Exchange Rate getExchange Rate(){
		return m_Exchange Rate;
	}

	public String getID(){
		return ID;
	}

	public String getMovieTitle(){
		return MovieTitle;
	}

	public String getPayPerView(){
		return PayPerView;
	}

	public Price getPrice(){
		return m_Price;
	}

	public BigDecimal getQuantity(){
		return Quantity;
	}

	public String getRoamingPartnerName(){
		return RoamingPartnerName;
	}

	public String getServiceNumberCalled(){
		return ServiceNumberCalled;
	}

	public Tax Total getTax Total(){
		return m_Tax Total;
	}

	public String getTelecommunicationsServiceCall(){
		return TelecommunicationsServiceCall;
	}

	public String getTelecommunicationsServiceCallCode(){
		return TelecommunicationsServiceCallCode;
	}

	public String getTelecommunicationsServiceCategory(){
		return TelecommunicationsServiceCategory;
	}

	public String getTelecommunicationsServiceCategoryCode(){
		return TelecommunicationsServiceCategoryCode;
	}

	public Duty getTime Duty(){
		return Time Duty;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAllowance Charge(Allowance Charge newVal){
		m_Allowance Charge = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCall Duty(Duty newVal){
		Call Duty = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCallBaseAmount(BigDecimal newVal){
		CallBaseAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCallDate(LocalDate newVal){
		CallDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCallExtensionAmount(BigDecimal newVal){
		CallExtensionAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCallTime(LocalTime newVal){
		CallTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCountry(Country newVal){
		m_Country = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExchange Rate(Exchange Rate newVal){
		m_Exchange Rate = newVal;
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
	public void setMovieTitle(String newVal){
		MovieTitle = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayPerView(String newVal){
		PayPerView = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrice(Price newVal){
		m_Price = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setQuantity(BigDecimal newVal){
		Quantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRoamingPartnerName(String newVal){
		RoamingPartnerName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setServiceNumberCalled(String newVal){
		ServiceNumberCalled = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTax Total(Tax Total newVal){
		m_Tax Total = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTelecommunicationsServiceCall(String newVal){
		TelecommunicationsServiceCall = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTelecommunicationsServiceCallCode(String newVal){
		TelecommunicationsServiceCallCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTelecommunicationsServiceCategory(String newVal){
		TelecommunicationsServiceCategory = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTelecommunicationsServiceCategoryCode(String newVal){
		TelecommunicationsServiceCategoryCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTime Duty(Duty newVal){
		Time Duty = newVal;
	}
}//end Telecommunications Service