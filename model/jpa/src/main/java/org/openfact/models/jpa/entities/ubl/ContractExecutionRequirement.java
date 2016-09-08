package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

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
	private String description;
	/**
	 * A code signifying the type of party independent of its role.
	 */
	private String executionRequirementCode;
	/**
	 * A name for this requirement.
	 */
	private String name;

	public ContractExecutionRequirement() {

	}

	public void finalize() throws Throwable {

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExecutionRequirementCode() {
		return executionRequirementCode;
	}

	public void setExecutionRequirementCode(String executionRequirementCode) {
		this.executionRequirementCode = executionRequirementCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}// end ContractExecutionRequirement