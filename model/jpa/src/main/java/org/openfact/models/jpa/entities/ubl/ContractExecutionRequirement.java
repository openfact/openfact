package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe a requirement for execution of a contract.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:01 a. m.
 */
public class ContractExecutionRequirement {

	/**
	 * Text describing this requirement.
	 */
	private String Description;
	/**
	 * A code signifying the type of party independent of its role.
	 */
	private String ExecutionRequirementCode;
	/**
	 * A name for this requirement.
	 */
	private String Name;

	public ContractExecutionRequirement() {

	}

	public void finalize() throws Throwable {

	}

	public String getDescription() {
		return Description;
	}

	public String getExecutionRequirementCode() {
		return ExecutionRequirementCode;
	}

	public String getName() {
		return Name;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(String newVal) {
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setExecutionRequirementCode(String newVal) {
		ExecutionRequirementCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(String newVal) {
		Name = newVal;
	}
}// end Contract Execution Requirement