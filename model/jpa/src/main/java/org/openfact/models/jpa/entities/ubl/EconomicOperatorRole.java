package org.openfact.models.jpa.entities.ubl;


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
	private String RoleCode;
	/**
	 * A textual description of the party role.
	 */
	private String RoleDescription;

	public Economic Operator Role(){

	}

	public void finalize() throws Throwable {

	}
	public String getRoleCode(){
		return RoleCode;
	}

	public String getRoleDescription(){
		return RoleDescription;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRoleCode(String newVal){
		RoleCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRoleDescription(String newVal){
		RoleDescription = newVal;
	}
}//end Economic Operator Role