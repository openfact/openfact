package org.openfact.models.jpa.entities.ubl;

/**
 * A class to specify which day of the week a transport service is operational.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:40 a. m.
 */
public class ServiceFrequency {

	/**
	 * A day of the week, expressed as code.
	 */
	private String WeekDayCode;

	public ServiceFrequency() {

	}

	public void finalize() throws Throwable {

	}

	public String getWeekDayCode() {
		return WeekDayCode;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setWeekDayCode(String newVal) {
		WeekDayCode = newVal;
	}
}// end Service Frequency