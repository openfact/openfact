

/**
 * The nature of the type of business of the organization.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:04 a. m.
 */
public class Contracting Activity {

	/**
	 * The nature of the type of business of the organization, expressed as text.
	 */
	private Text. Type ActivityType;
	/**
	 * A code specifying the nature of the type of business of the organization.
	 */
	private Code. Type ActivityTypeCode;

	public Contracting Activity(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getActivityType(){
		return ActivityType;
	}

	public Code. Type getActivityTypeCode(){
		return ActivityTypeCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActivityType(Text. Type newVal){
		ActivityType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActivityTypeCode(Code. Type newVal){
		ActivityTypeCode = newVal;
	}
}//end Contracting Activity