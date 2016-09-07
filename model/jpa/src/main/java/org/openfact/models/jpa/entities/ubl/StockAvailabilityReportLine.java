package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a line in a Stock Availability Report describing the
 * availability of an item of sale.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:52 a. m.
 */
public class StockAvailabilityReportLine {

	/**
	 * The date from which the item will be available. A date identical to or earlier
	 * than the IssueDate of the Stock Availability Report means that the item is
	 * available now
	 */
	private Date. Type AvailabilityDate;
	/**
	 * A code signifying the level of availability of the item.
	 */
	private Code. Type AvailabilityStatusCode;
	/**
	 * An identifier for this stock availability line.
	 */
	private Identifier. Type ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private Text. Type Note;
	/**
	 * The quantity of the item currently in stock.
	 */
	private Quantity. Type Quantity;
	/**
	 * The monetary value of the quantity of the item currently in stock.
	 */
	private Amount. Type ValueAmount;
	private Item m_Item;

	public Stock Availability Report Line(){

	}

	public void finalize() throws Throwable {

	}
	public Date. Type getAvailabilityDate(){
		return AvailabilityDate;
	}

	public Code. Type getAvailabilityStatusCode(){
		return AvailabilityStatusCode;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Item getItem(){
		return m_Item;
	}

	public Text. Type getNote(){
		return Note;
	}

	public Quantity. Type getQuantity(){
		return Quantity;
	}

	public Amount. Type getValueAmount(){
		return ValueAmount;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAvailabilityDate(Date. Type newVal){
		AvailabilityDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAvailabilityStatusCode(Code. Type newVal){
		AvailabilityStatusCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setItem(Item newVal){
		m_Item = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNote(Text. Type newVal){
		Note = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setQuantity(Quantity. Type newVal){
		Quantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValueAmount(Amount. Type newVal){
		ValueAmount = newVal;
	}
}//end Stock Availability Report Line