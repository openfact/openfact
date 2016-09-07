

/**
 * A class to define comments about a retail event.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:55 a. m.
 */
public class EventComment {

	/**
	 * Text commenting on the event.
	 */
	private Text. Type Comment;
	/**
	 * The date on which this comment was made.
	 */
	private Date. Type IssueDate;
	/**
	 * The time at which this comment was made.
	 */
	private Time. Type IssueTime;

	public Event Comment(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getComment(){
		return Comment;
	}

	public Date. Type getIssueDate(){
		return IssueDate;
	}

	public Time. Type getIssueTime(){
		return IssueTime;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setComment(Text. Type newVal){
		Comment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueDate(Date. Type newVal){
		IssueDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueTime(Time. Type newVal){
		IssueTime = newVal;
	}
}//end Event Comment