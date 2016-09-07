

/**
 * A class to describe a tendering framework agreement.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:22 a. m.
 */
public class Framework Agreement {

	/**
	 * The number of economic operators expected to participate in this framework
	 * agreement.
	 */
	private Quantity. Type ExpectedOperatorQuantity;
	/**
	 * Text describing the frequency with which subsequent contracts will be awarded.
	 */
	private Text. Type Frequency;
	/**
	 * Text describing the justification for this framework agreement.
	 */
	private Text. Type Justification;
	/**
	 * The maximum number of economic operators allowed to participate in this
	 * framework agreement.
	 */
	private Quantity. Type MaximumOperatorQuantity;
	private Period Duration Period;
	private Tender Requirement Subsequent Process Tender Requirement;

	public Framework Agreement(){

	}

	public void finalize() throws Throwable {

	}
	public Period getDuration Period(){
		return Duration Period;
	}

	public Quantity. Type getExpectedOperatorQuantity(){
		return ExpectedOperatorQuantity;
	}

	public Text. Type getFrequency(){
		return Frequency;
	}

	public Text. Type getJustification(){
		return Justification;
	}

	public Quantity. Type getMaximumOperatorQuantity(){
		return MaximumOperatorQuantity;
	}

	public Tender Requirement getSubsequent Process Tender Requirement(){
		return Subsequent Process Tender Requirement;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDuration Period(Period newVal){
		Duration Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExpectedOperatorQuantity(Quantity. Type newVal){
		ExpectedOperatorQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFrequency(Text. Type newVal){
		Frequency = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setJustification(Text. Type newVal){
		Justification = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumOperatorQuantity(Quantity. Type newVal){
		MaximumOperatorQuantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubsequent Process Tender Requirement(Tender Requirement newVal){
		Subsequent Process Tender Requirement = newVal;
	}
}//end Framework Agreement