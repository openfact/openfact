

/**
 * A class to define a line in a Performance History.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:42 a. m.
 */
public class Performance Data Line {

	/**
	 * An identifier for this performance data line.
	 */
	private Identifier. Type ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private Text. Type Note;
	/**
	 * A code signifying the measure of performance applicable to the reported
	 * attribute.
	 */
	private Code. Type PerformanceMetricTypeCode;
	/**
	 * The value of the reported attribute.
	 */
	private Quantity. Type PerformanceValueQuantity;
	private Item m_Item;
	private Period m_Period;

	public Performance Data Line(){

	}

	public void finalize() throws Throwable {

	}
	public Identifier. Type getID(){
		return ID;
	}

	public Item getItem(){
		return m_Item;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Code. Type getPerformanceMetricTypeCode(){
		return PerformanceMetricTypeCode;
	}

	public Quantity. Type getPerformanceValueQuantity(){
		return PerformanceValueQuantity;
	}

	public Period getPeriod(){
		return m_Period;
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
	public void setItem(Item newVal){
		m_Item = newVal;
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
	public void setPerformanceMetricTypeCode(Code. Type newVal){
		PerformanceMetricTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPerformanceValueQuantity(Quantity. Type newVal){
		PerformanceValueQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPeriod(Period newVal){
		m_Period = newVal;
	}
}//end Performance Data Line