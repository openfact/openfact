

/**
 * The consumption for a specific party for given consumption point provided by a
 * numbers of suppliers. An enterprise can have one utility statement for several
 * parties (e.g. a ministry of defence receiving a telephone bill). In this way
 * each subscriber cons
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:57 a. m.
 */
public class SubscriberConsumption {

	/**
	 * The identifier tor this specification.
	 */
	private Identifier. Type ConsumptionID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private Text. Type Note;
	/**
	 * The code which specifies the type of this specification, e.g. an on account
	 * specification or the yearly specification.
	 */
	private Code. Type SpecificationTypeCode;
	/**
	 * The total quantity consumed, as calculated from meter readings.
	 */
	private Quantity. Type TotalMeteredQuantity;
	private Consumption m_Consumption;
	private Consumption Point Utility Consumption Point;
	private On Account Payment m_On Account Payment;
	private Party Subscriber Party;
	private Supplier Consumption m_Supplier Consumption;

	public Subscriber Consumption(){

	}

	public void finalize() throws Throwable {

	}
	public Consumption getConsumption(){
		return m_Consumption;
	}

	public Identifier. Type getConsumptionID(){
		return ConsumptionID;
	}

	public Text. Type getNote(){
		return Note;
	}

	public On Account Payment getOn Account Payment(){
		return m_On Account Payment;
	}

	public Code. Type getSpecificationTypeCode(){
		return SpecificationTypeCode;
	}

	public Party getSubscriber Party(){
		return Subscriber Party;
	}

	public Supplier Consumption getSupplier Consumption(){
		return m_Supplier Consumption;
	}

	public Quantity. Type getTotalMeteredQuantity(){
		return TotalMeteredQuantity;
	}

	public Consumption Point getUtility Consumption Point(){
		return Utility Consumption Point;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumption(Consumption newVal){
		m_Consumption = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConsumptionID(Identifier. Type newVal){
		ConsumptionID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNote(Text. Type newVal){
		Note = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOn Account Payment(On Account Payment newVal){
		m_On Account Payment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSpecificationTypeCode(Code. Type newVal){
		SpecificationTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubscriber Party(Party newVal){
		Subscriber Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSupplier Consumption(Supplier Consumption newVal){
		m_Supplier Consumption = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTotalMeteredQuantity(Quantity. Type newVal){
		TotalMeteredQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUtility Consumption Point(Consumption Point newVal){
		Utility Consumption Point = newVal;
	}
}//end Subscriber Consumption