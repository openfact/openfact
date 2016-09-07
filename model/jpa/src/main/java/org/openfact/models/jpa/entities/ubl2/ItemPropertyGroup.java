

/**
 * A class to describe a property group or classification.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:51 a. m.
 */
public class ItemPropertyGroup {

	/**
	 * An identifier for this group of item properties.
	 */
	private Identifier. Type ID;
	/**
	 * A code signifying the importance of this property group in using it to describe
	 * a required Item.
	 */
	private Code. Type ImportanceCode;
	/**
	 * The name of this item property group.
	 */
	private Name. Type Name;

	public Item Property Group(){

	}

	public void finalize() throws Throwable {

	}
	public Identifier. Type getID(){
		return ID;
	}

	public Code. Type getImportanceCode(){
		return ImportanceCode;
	}

	public Name. Type getName(){
		return Name;
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
	public void setImportanceCode(Code. Type newVal){
		ImportanceCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(Name. Type newVal){
		Name = newVal;
	}
}//end Item Property Group