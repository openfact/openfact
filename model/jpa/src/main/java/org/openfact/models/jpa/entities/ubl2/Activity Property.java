

/**
 * A class to define a name/value pair for a property of an inventory planning
 * activity.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:36 a. m.
 */
public class Activity Property {

	/**
	 * The name of this activity property.
	 */
	private Name. Type Name;
	/**
	 * The value of this activity property.
	 */
	private Text. Type Value;

	public Activity Property(){

	}

	public void finalize() throws Throwable {

	}
	public Name. Type getName(){
		return Name;
	}

	public Text. Type getValue(){
		return Value;
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
	public void setValue(Text. Type newVal){
		Value = newVal;
	}
}//end Activity Property