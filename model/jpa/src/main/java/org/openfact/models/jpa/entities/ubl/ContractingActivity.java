package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * The nature of the type of business of the organization.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:04 a. m.
 */
public class ContractingActivity {

	/**
	 * The nature of the type of business of the organization, expressed as
	 * text.
	 */
	private String ActivityType;
	/**
	 * A code specifying the nature of the type of business of the organization.
	 */
	private String ActivityTypeCode;

	public ContractingActivity() {

	}

	public void finalize() throws Throwable {

	}

	public String getActivityType() {
		return ActivityType;
	}

	public String getActivityTypeCode() {
		return ActivityTypeCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActivityType(String newVal) {
		ActivityType = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActivityTypeCode(String newVal) {
		ActivityTypeCode = newVal;
	}
}// end Contracting Activity