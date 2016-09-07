

/**
 * A class to describe possible extensions to a contract.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:03 a. m.
 */
public class ContractExtension {

	/**
	 * The maximum allowed number of contract extensions.
	 */
	private Numeric. Type MaximumNumberNumeric;
	/**
	 * The fixed minimum number of contract extensions or renewals.
	 */
	private Numeric. Type MinimumNumberNumeric;
	/**
	 * A description for the possible options that can be carried out during the
	 * execution of the contract.
	 */
	private Text. Type OptionsDescription;
	private Period Option Validity Period;
	private Renewal m_Renewal;

	public Contract Extension(){

	}

	public void finalize() throws Throwable {

	}
	public Numeric. Type getMaximumNumberNumeric(){
		return MaximumNumberNumeric;
	}

	public Numeric. Type getMinimumNumberNumeric(){
		return MinimumNumberNumeric;
	}

	public Period getOption Validity Period(){
		return Option Validity Period;
	}

	public Text. Type getOptionsDescription(){
		return OptionsDescription;
	}

	public Renewal getRenewal(){
		return m_Renewal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMaximumNumberNumeric(Numeric. Type newVal){
		MaximumNumberNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumNumberNumeric(Numeric. Type newVal){
		MinimumNumberNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOption Validity Period(Period newVal){
		Option Validity Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setOptionsDescription(Text. Type newVal){
		OptionsDescription = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRenewal(Renewal newVal){
		m_Renewal = newVal;
	}
}//end Contract Extension