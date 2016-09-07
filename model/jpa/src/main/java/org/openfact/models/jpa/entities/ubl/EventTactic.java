package org.openfact.models.jpa.entities.ubl;


/**
 * A class defining a specific type of action or situation arranged by the Buyer
 * or the Seller to promote the product or products.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:58 a. m.
 */
public class EventTactic {

	/**
	 * Generic field to add additional information or to specify mutually defined
	 * eventTacticTypes that are not currently listed.
	 */
	private String Comment;
	/**
	 * The currencies, units, etc. that describes what is need for the event or
	 * promotion Usage example: Number of pallets per store for a stack display
	 */
	private BigDecimal Quantity;
	private Event Tactic Enumeration m_Event Tactic Enumeration;
	private Period m_Period;

	public Event Tactic(){

	}

	public void finalize() throws Throwable {

	}
	public String getComment(){
		return Comment;
	}

	public Event Tactic Enumeration getEvent Tactic Enumeration(){
		return m_Event Tactic Enumeration;
	}

	public Period getPeriod(){
		return m_Period;
	}

	public BigDecimal getQuantity(){
		return Quantity;
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
	public void setEvent Tactic Enumeration(Event Tactic Enumeration newVal){
		m_Event Tactic Enumeration = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPeriod(Period newVal){
		m_Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setQuantity(BigDecimal newVal){
		Quantity = newVal;
	}
}//end Event Tactic