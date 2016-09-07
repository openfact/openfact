

/**
 * A class to describe the tenderer contracting role.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:40 a. m.
 */
public class EconomicOperatorRole {

	/**
	 * A code specifying the role of the party.
	 */
	private Code. Type RoleCode;
	/**
	 * A textual description of the party role.
	 */
	private Text. Type RoleDescription;

	public Economic Operator Role(){

	}

	public void finalize() throws Throwable {

	}
	public Code. Type getRoleCode(){
		return RoleCode;
	}

	public Text. Type getRoleDescription(){
		return RoleDescription;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRoleCode(Code. Type newVal){
		RoleCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRoleDescription(Text. Type newVal){
		RoleDescription = newVal;
	}
}//end Economic Operator Role