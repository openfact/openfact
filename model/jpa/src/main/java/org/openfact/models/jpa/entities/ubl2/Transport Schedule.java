

/**
 * Describes the location and schedule relating to a transport means.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:49 a. m.
 */
public class Transport Schedule {

	/**
	 * The reference date for the transport schedule status.
	 */
	private Date. Type ReferenceDate;
	/**
	 * The reference time for the transport schedule status.
	 */
	private Time. Type ReferenceTime;
	/**
	 * The reliability of the transport schedule status, expressed as a percentage.
	 */
	private Percent. Type ReliabilityPercent;
	/**
	 * Remarks related to the transport schedule status.
	 */
	private Text. Type Remarks;
	/**
	 * A number indicating the order of this status in the sequence in which statuses
	 * are to be presented.
	 */
	private Numeric. Type SequenceNumeric;
	private Location Status Location;
	private Transport Event Actual Departure Transport Event;
	private Transport Event Estimated Departure Transport Event;
	private Transport Event Estimated Arrival Transport Event;
	private Transport Event Planned Departure Transport Event;
	private Transport Event Actual Arrival Transport Event;
	private Transport Event Planned Arrival Transport Event;

	public Transport Schedule(){

	}

	public void finalize() throws Throwable {

	}
	public Transport Event getActual Arrival Transport Event(){
		return Actual Arrival Transport Event;
	}

	public Transport Event getActual Departure Transport Event(){
		return Actual Departure Transport Event;
	}

	public Transport Event getEstimated Arrival Transport Event(){
		return Estimated Arrival Transport Event;
	}

	public Transport Event getEstimated Departure Transport Event(){
		return Estimated Departure Transport Event;
	}

	public Transport Event getPlanned Arrival Transport Event(){
		return Planned Arrival Transport Event;
	}

	public Transport Event getPlanned Departure Transport Event(){
		return Planned Departure Transport Event;
	}

	public Date. Type getReferenceDate(){
		return ReferenceDate;
	}

	public Time. Type getReferenceTime(){
		return ReferenceTime;
	}

	public Percent. Type getReliabilityPercent(){
		return ReliabilityPercent;
	}

	public Text. Type getRemarks(){
		return Remarks;
	}

	public Numeric. Type getSequenceNumeric(){
		return SequenceNumeric;
	}

	public Location getStatus Location(){
		return Status Location;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActual Arrival Transport Event(Transport Event newVal){
		Actual Arrival Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setActual Departure Transport Event(Transport Event newVal){
		Actual Departure Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEstimated Arrival Transport Event(Transport Event newVal){
		Estimated Arrival Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEstimated Departure Transport Event(Transport Event newVal){
		Estimated Departure Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPlanned Arrival Transport Event(Transport Event newVal){
		Planned Arrival Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPlanned Departure Transport Event(Transport Event newVal){
		Planned Departure Transport Event = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReferenceDate(Date. Type newVal){
		ReferenceDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReferenceTime(Time. Type newVal){
		ReferenceTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setReliabilityPercent(Percent. Type newVal){
		ReliabilityPercent = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRemarks(Text. Type newVal){
		Remarks = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSequenceNumeric(Numeric. Type newVal){
		SequenceNumeric = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStatus Location(Location newVal){
		Status Location = newVal;
	}
}//end Transport Schedule