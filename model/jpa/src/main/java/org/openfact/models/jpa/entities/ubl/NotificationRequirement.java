package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a notification requirement.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:13 a. m.
 */
public class NotificationRequirement {

	/**
	 * A code signifying the type of notification (e.g., pickup status).
	 */
	private Code. Type NotificationTypeCode;
	/**
	 * The length of time between the occurrence of a given event and the issuance of
	 * a notification.
	 */
	private Measure. Type PostEventNotificationDurationMeasure;
	/**
	 * The length of time to elapse between the issuance of a notification and the
	 * occurrence of the event it relates to.
	 */
	private Measure. Type PreEventNotificationDurationMeasure;
	private Location Notification Location;
	private Period Notification Period;
	private Party Notify Party;

	public Notification Requirement(){

	}

	public void finalize() throws Throwable {

	}
	public Location getNotification Location(){
		return Notification Location;
	}

	public Period getNotification Period(){
		return Notification Period;
	}

	public Code. Type getNotificationTypeCode(){
		return NotificationTypeCode;
	}

	public Party getNotify Party(){
		return Notify Party;
	}

	public Measure. Type getPostEventNotificationDurationMeasure(){
		return PostEventNotificationDurationMeasure;
	}

	public Measure. Type getPreEventNotificationDurationMeasure(){
		return PreEventNotificationDurationMeasure;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNotification Location(Location newVal){
		Notification Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNotification Period(Period newVal){
		Notification Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNotificationTypeCode(Code. Type newVal){
		NotificationTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNotify Party(Party newVal){
		Notify Party = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPostEventNotificationDurationMeasure(Measure. Type newVal){
		PostEventNotificationDurationMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPreEventNotificationDurationMeasure(Measure. Type newVal){
		PreEventNotificationDurationMeasure = newVal;
	}
}//end Notification Requirement