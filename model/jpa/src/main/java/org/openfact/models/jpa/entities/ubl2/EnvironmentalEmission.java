

/**
 * A class to describe an environmental emission.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:50 a. m.
 */
public class EnvironmentalEmission {

	/**
	 * Text describing this environmental emission.
	 */
	private Text. Type Description;
	/**
	 * A code specifying the type of environmental emission.
	 */
	private Code. Type EnvironmentalEmissionTypeCode;
	/**
	 * A value measurement for the environmental emission.
	 */
	private Measure. Type ValueMeasure;
	private Emission Calculation Method m_Emission Calculation Method;

	public Environmental Emission(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getDescription(){
		return Description;
	}

	public Emission Calculation Method getEmission Calculation Method(){
		return m_Emission Calculation Method;
	}

	public Code. Type getEnvironmentalEmissionTypeCode(){
		return EnvironmentalEmissionTypeCode;
	}

	public Measure. Type getValueMeasure(){
		return ValueMeasure;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(Text. Type newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEmission Calculation Method(Emission Calculation Method newVal){
		m_Emission Calculation Method = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEnvironmentalEmissionTypeCode(Code. Type newVal){
		EnvironmentalEmissionTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValueMeasure(Measure. Type newVal){
		ValueMeasure = newVal;
	}
}//end Environmental Emission