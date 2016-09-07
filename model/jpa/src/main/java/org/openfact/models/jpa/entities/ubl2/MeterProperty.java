

/**
 * The name of this meter property.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:08 a. m.
 */
public class MeterProperty {

	/**
	 * The name of this meter property, expressed as a code.
	 */
	private Name. Type Name;
	/**
	 * The value of this meter property, expressed as text.
	 */
	private Code. Type NameCode;
	/**
	 * The value of this meter property, expressed as a quantity.
	 */
	private Text. Type Value;
	/**
	 * An additional value to qualify the value of the meter
	 */
	private Text. Type ValueQualifier;
	/**
	 * The value of this meter property, expressed as a quantity.
	 */
	private Quantity. Type ValueQuantity;

	public Meter Property(){

	}

	public void finalize() throws Throwable {

	}
	public Name. Type getName(){
		return Name;
	}

	public Code. Type getNameCode(){
		return NameCode;
	}

	public Text. Type getValue(){
		return Value;
	}

	public Text. Type getValueQualifier(){
		return ValueQualifier;
	}

	public Quantity. Type getValueQuantity(){
		return ValueQuantity;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(Name. Type newVal){
		Name = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNameCode(Code. Type newVal){
		NameCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValue(Text. Type newVal){
		Value = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValueQualifier(Text. Type newVal){
		ValueQualifier = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValueQuantity(Quantity. Type newVal){
		ValueQuantity = newVal;
	}
}//end Meter Property