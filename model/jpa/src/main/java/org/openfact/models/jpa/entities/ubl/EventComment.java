package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

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
	private String Comment;
	/**
	 * The date on which this comment was made.
	 */
	private LocalDate IssueDate;
	/**
	 * The time at which this comment was made.
	 */
	private LocalTime IssueTime;

	public Event Comment(){

	}

	public void finalize() throws Throwable {

	}
	public String getComment(){
		return Comment;
	}

	public LocalDate getIssueDate(){
		return IssueDate;
	}

	public LocalTime getIssueTime(){
		return IssueTime;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setComment(String newVal){
		Comment = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueDate(LocalDate newVal){
		IssueDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setIssueTime(LocalTime newVal){
		IssueTime = newVal;
	}
}//end Event Comment