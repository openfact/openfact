

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
	private Amount. Type CallBaseAmount;
	/**
	 * In the case of a telephone call, the date of the call.
	 */
	private Date. Type CallDate;
	/**
	 * The amount to be payed for the call
	 */
	private Amount. Type CallExtensionAmount;
	/**
	 * In the case of a telephone call, the time of the call.
	 */
	private Time. Type CallTime;
	/**
	 * An identifier for this telecommunications service.
	 */
	private Identifier. Type ID;
	/**
	 * The title of a movie delivered via this telecommunications service.
	 */
	private Text. Type MovieTitle;
	/**
	 * A pay-per-view delivered via this telecommunications service.
	 */
	private Text. Type PayPerView;
	/**
	 * The number of calls.
	 */
	private Quantity. Type Quantity;
	/**
	 * Statement of the roaming partner name.
	 */
	private Name. Type RoamingPartnerName;
	/**
	 * In the case of a telephone call, the phone number called.
	 */
	private Text. Type ServiceNumberCalled;
	/**
	 * The telecommunications call described as a text
	 */
	private Text. Type TelecommunicationsServiceCall;
	/**
	 * The telecommunications call described as a code
	 */
	private Code. Type TelecommunicationsServiceCallCode;
	/**
	 * The telecommunications category, expressed as text.
	 */
	private Text. Type TelecommunicationsServiceCategory;
	/**
	 * The telecommunications category, expressed as a code.
	 */
	private Code. Type TelecommunicationsServiceCategoryCode;
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

	public Amount. Type getCallBaseAmount(){
		return CallBaseAmount;
	}

	public Date. Type getCallDate(){
		return CallDate;
	}

	public Amount. Type getCallExtensionAmount(){
		return CallExtensionAmount;
	}

	public Time. Type getCallTime(){
		return CallTime;
	}

	public Country getCountry(){
		return m_Country;
	}

	public Exchange Rate getExchange Rate(){
		return m_Exchange Rate;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Text. Type getMovieTitle(){
		return MovieTitle;
	}

	public Text. Type getPayPerView(){
		return PayPerView;
	}

	public Price getPrice(){
		return m_Price;
	}

	public Quantity. Type getQuantity(){
		return Quantity;
	}

	public Name. Type getRoamingPartnerName(){
		return RoamingPartnerName;
	}

	public Text. Type getServiceNumberCalled(){
		return ServiceNumberCalled;
	}

	public Tax Total getTax Total(){
		return m_Tax Total;
	}

	public Text. Type getTelecommunicationsServiceCall(){
		return TelecommunicationsServiceCall;
	}

	public Code. Type getTelecommunicationsServiceCallCode(){
		return TelecommunicationsServiceCallCode;
	}

	public Text. Type getTelecommunicationsServiceCategory(){
		return TelecommunicationsServiceCategory;
	}

	public Code. Type getTelecommunicationsServiceCategoryCode(){
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
	public void setCallBaseAmount(Amount. Type newVal){
		CallBaseAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCallDate(Date. Type newVal){
		CallDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCallExtensionAmount(Amount. Type newVal){
		CallExtensionAmount = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCallTime(Time. Type newVal){
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
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMovieTitle(Text. Type newVal){
		MovieTitle = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPayPerView(Text. Type newVal){
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
	public void setQuantity(Quantity. Type newVal){
		Quantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRoamingPartnerName(Name. Type newVal){
		RoamingPartnerName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setServiceNumberCalled(Text. Type newVal){
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
	public void setTelecommunicationsServiceCall(Text. Type newVal){
		TelecommunicationsServiceCall = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTelecommunicationsServiceCallCode(Code. Type newVal){
		TelecommunicationsServiceCallCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTelecommunicationsServiceCategory(Text. Type newVal){
		TelecommunicationsServiceCategory = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTelecommunicationsServiceCategoryCode(Code. Type newVal){
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