

/**
 * A class to describe a physical attribute.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:48 a. m.
 */
public class Physical Attribute {

	/**
	 * An identifier for this physical attribute.
	 */
	private Identifier. Type AttributeID;
	/**
	 * A description of the physical attribute, expressed as text.
	 */
	private Text. Type Description;
	/**
	 * A description of the physical attribute, expressed as a code.
	 */
	private Code. Type DescriptionCode;
	/**
	 * A code signifying the position of this physical attribute.
	 */
	private Code. Type PositionCode;

	public Physical Attribute(){

	}

	public void finalize() throws Throwable {

	}
	public Identifier. Type getAttributeID(){
		return AttributeID;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Code. Type getDescriptionCode(){
		return DescriptionCode;
	}

	public Code. Type getPositionCode(){
		return PositionCode;
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
	public void setDescriptionCode(Code. Type newVal){
		DescriptionCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPositionCode(Code. Type newVal){
		PositionCode = newVal;
	}
}//end Physical Attribute