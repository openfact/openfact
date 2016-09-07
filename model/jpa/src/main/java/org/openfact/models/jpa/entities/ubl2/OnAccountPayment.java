

/**
 * A scheduled prepayment (on-account payment) for a estimated utility consumption
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:14 a. m.
 */
public class On Account Payment {

	/**
	 * The estimated consumed quantity covered by the payment.
	 */
	private Quantity. Type EstimatedConsumedQuantity;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private Text. Type Note;
	private Payment Terms m_Payment Terms;

	public On Account Payment(){

	}

	public void finalize() throws Throwable {

	}
	public Quantity. Type getEstimatedConsumedQuantity(){
		return EstimatedConsumedQuantity;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Payment Terms getPayment Terms(){
		return m_Payment Terms;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEstimatedConsumedQuantity(Quantity. Type newVal){
		EstimatedConsumedQuantity = newVal;
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
	public void setPayment Terms(Payment Terms newVal){
		m_Payment Terms = newVal;
	}
}//end On Account Payment