

/**
 * A class to describe a period of time.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:45 a. m.
 */
public class Period {

	/**
	 * A description of this period, expressed as text.
	 */
	private Text. Type Description;
	/**
	 * A description of this period, expressed as a code.
	 */
	private Code. Type DescriptionCode;
	/**
	 * The duration of this period, expressed as an ISO 8601 code.
	 */
	private Measure. Type DurationMeasure;
	/**
	 * The date on which this period ends.
	 */
	private Date. Type EndDate;
	/**
	 * The time at which this period ends.
	 */
	private Time. Type EndTime;
	/**
	 * The date on which this period begins.
	 */
	private Date. Type StartDate;
	/**
	 * The time at which this period begins.
	 */
	private Time. Type StartTime;

	public Period(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getDescription(){
		return Description;
	}

	public Code. Type getDescriptionCode(){
		return DescriptionCode;
	}

	public Measure. Type getDurationMeasure(){
		return DurationMeasure;
	}

	public Date. Type getEndDate(){
		return EndDate;
	}

	public Time. Type getEndTime(){
		return EndTime;
	}

	public Date. Type getStartDate(){
		return StartDate;
	}

	public Time. Type getStartTime(){
		return StartTime;
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
	public void setDescriptionCode(Code. Type newVal){
		DescriptionCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDurationMeasure(Measure. Type newVal){
		DurationMeasure = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEndDate(Date. Type newVal){
		EndDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEndTime(Time. Type newVal){
		EndTime = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStartDate(Date. Type newVal){
		StartDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStartTime(Time. Type newVal){
		StartTime = newVal;
	}
}//end Period