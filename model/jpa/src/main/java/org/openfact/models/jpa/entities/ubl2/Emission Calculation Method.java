

/**
 * A class to define how an environmental emission is calculated.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:43 a. m.
 */
public class EmissionCalculationMethod {

	/**
	 * A code signifying the method used to calculate the emission.
	 */
	private Code. Type CalculationMethodCode;
	/**
	 * A code signifying whether a piece of transport equipment is full, partially
	 * full, or empty. This indication is used as a parameter when calculating the
	 * environmental emission.
	 */
	private Code. Type FullnessIndicationCode;
	private Location Measurement To Location;
	private Location Measurement From Location;

	public Emission Calculation Method(){

	}

	public void finalize() throws Throwable {

	}
	public Code. Type getCalculationMethodCode(){
		return CalculationMethodCode;
	}

	public Code. Type getFullnessIndicationCode(){
		return FullnessIndicationCode;
	}

	public Location getMeasurement From Location(){
		return Measurement From Location;
	}

	public Location getMeasurement To Location(){
		return Measurement To Location;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCalculationMethodCode(Code. Type newVal){
		CalculationMethodCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFullnessIndicationCode(Code. Type newVal){
		FullnessIndicationCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMeasurement From Location(Location newVal){
		Measurement From Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMeasurement To Location(Location newVal){
		Measurement To Location = newVal;
	}
}//end Emission Calculation Method