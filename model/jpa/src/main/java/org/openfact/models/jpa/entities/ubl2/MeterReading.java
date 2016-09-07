

/**
 * A class to describe a meter reading.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:09 a. m.
 */
public class MeterReading {

	/**
	 * Consumption in the period from PreviousMeterReadingDate to
	 * LatestMeterReadingDate.
	 */
	private Quantity. Type DeliveredQuantity;
	/**
	 * An identifier for this meter reading.
	 */
	private Identifier. Type ID;
	/**
	 * The quantity of the latest meter reading.
	 */
	private Quantity. Type LatestMeterQuantity;
	/**
	 * The date of the latest meter reading.
	 */
	private Date. Type LatestMeterReadingDate;
	/**
	 * The method used for the latest meter reading, expressed as text.
	 */
	private Text. Type LatestMeterReadingMethod;
	/**
	 * The method used for the latest meter reading, expressed as a code.
	 */
	private Code. Type LatestMeterReadingMethodCode;
	/**
	 * Text containing comments on this meter reading.
	 */
	private Text. Type MeterReadingComments;
	/**
	 * The type of this meter reading, expressed as text.
	 */
	private Text. Type MeterReadingType;
	/**
	 * The type of this meter reading, expressed as a code.
	 */
	private Code. Type MeterReadingTypeCode;
	/**
	 * The quantity of the previous meter reading.
	 */
	private Quantity. Type PreviousMeterQuantity;
	/**
	 * The date of the previous meter reading.
	 */
	private Date. Type PreviousMeterReadingDate;
	/**
	 * The method used for the previous meter reading, expressed as text.
	 */
	private Text. Type PreviousMeterReadingMethod;
	/**
	 * The method used for the previous meter reading, expressed as a code.
	 */
	private Code. Type PreviousMeterReadingMethodCode;

	public Meter Reading(){

	}

	public void finalize() throws Throwable {

	}
	public Quantity. Type getDeliveredQuantity(){
		return DeliveredQuantity;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Quantity. Type getLatestMeterQuantity(){
		return LatestMeterQuantity;
	}

	public Date. Type getLatestMeterReadingDate(){
		return LatestMeterReadingDate;
	}

	public Text. Type getLatestMeterReadingMethod(){
		return LatestMeterReadingMethod;
	}

	public Code. Type getLatestMeterReadingMethodCode(){
		return LatestMeterReadingMethodCode;
	}

	public Text. Type getMeterReadingComments(){
		return MeterReadingComments;
	}

	public Text. Type getMeterReadingType(){
		return MeterReadingType;
	}

	public Code. Type getMeterReadingTypeCode(){
		return MeterReadingTypeCode;
	}

	public Quantity. Type getPreviousMeterQuantity(){
		return PreviousMeterQuantity;
	}

	public Date. Type getPreviousMeterReadingDate(){
		return PreviousMeterReadingDate;
	}

	public Text. Type getPreviousMeterReadingMethod(){
		return PreviousMeterReadingMethod;
	}

	public Code. Type getPreviousMeterReadingMethodCode(){
		return PreviousMeterReadingMethodCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDeliveredQuantity(Quantity. Type newVal){
		DeliveredQuantity = newVal;
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
	public void setLatestMeterQuantity(Quantity. Type newVal){
		LatestMeterQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLatestMeterReadingDate(Date. Type newVal){
		LatestMeterReadingDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLatestMeterReadingMethod(Text. Type newVal){
		LatestMeterReadingMethod = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLatestMeterReadingMethodCode(Code. Type newVal){
		LatestMeterReadingMethodCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMeterReadingComments(Text. Type newVal){
		MeterReadingComments = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMeterReadingType(Text. Type newVal){
		MeterReadingType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMeterReadingTypeCode(Code. Type newVal){
		MeterReadingTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPreviousMeterQuantity(Quantity. Type newVal){
		PreviousMeterQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPreviousMeterReadingDate(Date. Type newVal){
		PreviousMeterReadingDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPreviousMeterReadingMethod(Text. Type newVal){
		PreviousMeterReadingMethod = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPreviousMeterReadingMethodCode(Code. Type newVal){
		PreviousMeterReadingMethodCode = newVal;
	}
}//end Meter Reading