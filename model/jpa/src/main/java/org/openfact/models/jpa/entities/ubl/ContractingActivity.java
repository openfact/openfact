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
	private String activityType;
	/**
	 * A code specifying the nature of the type of business of the organization.
	 */
	private String activityTypeCode;

	public ContractingActivity() {

	}

	public void finalize() throws Throwable {

	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getActivityTypeCode() {
		return activityTypeCode;
	}

	public void setActivityTypeCode(String activityTypeCode) {
		this.activityTypeCode = activityTypeCode;
	}
}// end Contracting Activity