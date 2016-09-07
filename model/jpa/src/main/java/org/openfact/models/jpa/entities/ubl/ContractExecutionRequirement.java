package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a requirement for execution of a contract.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:01 a. m.
 */
public class ContractExecution Requirement {

	/**
	 * Text describing this requirement.
	 */
	private Text. Type Description;
	/**
	 * A code signifying the type of party independent of its role.
	 */
	private Code. Type ExecutionRequirementCode;
	/**
	 * A name for this requirement.
	 */
	private Name. Type Name;

	public Contract Execution Requirement(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getDescription(){
		return Description;
	}

	public Code. Type getExecutionRequirementCode(){
		return ExecutionRequirementCode;
	}

	public Name. Type getName(){
		return Name;
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
	public void setExecutionRequirementCode(Code. Type newVal){
		ExecutionRequirementCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(Name. Type newVal){
		Name = newVal;
	}
}//end Contract Execution Requirement