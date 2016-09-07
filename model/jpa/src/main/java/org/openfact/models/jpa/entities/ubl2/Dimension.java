

/**
 * A class to define a measurable dimension (length, mass, weight, volume, or
 * area) of an item.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:14:30 a. m.
 */
public class Dimension {

	/**
	 * An identifier for the attribute to which the measure applies.
	 */
	private Identifier. Type AttributeID;
	/**
	 * Text describing the measurement attribute.
	 */
	private Text. Type Description;
	/**
	 * The maximum value in a range of measurement of this dimension.
	 */
	private Measure. Type MaximumMeasure;
	/**
	 * The measurement value.
	 */
	private Measure. Type Measure;
	/**
	 * The minimum value in a range of measurement of this dimension.
	 */
	private Measure. Type MinimumMeasure;

	public Dimension(){

	}

	public void finalize() throws Throwable {

	}
	public Identifier. Type getAttributeID(){
		return AttributeID;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Measure. Type getMaximumMeasure(){
		return MaximumMeasure;
	}

	public Measure. Type getMeasure(){
		return Measure;
	}

	public Measure. Type getMinimumMeasure(){
		return MinimumMeasure;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAttributeID(Identifier. Type newVal){
		AttributeID = newVal;
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
	public void setMaximumMeasure(Measure. Type newVal){
		MaximumMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMeasure(Measure. Type newVal){
		Measure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMinimumMeasure(Measure. Type newVal){
		MinimumMeasure = newVal;
	}
}//end Dimension