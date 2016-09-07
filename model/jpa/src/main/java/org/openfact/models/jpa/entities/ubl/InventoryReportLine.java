package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a line in an Inventory Report.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:35 a. m.
 */
public class InventoryReportLine {

	/**
	 * The date from which the goods will be available. If not present, the goods are
	 * available now.
	 */
	private LocalDate AvailabilityDate;
	/**
	 * A code signifying the item's level of availability.
	 */
	private String AvailabilityStatusCode;
	/**
	 * An identifier for this inventory report line.
	 */
	private String ID;
	/**
	 * The value of the quantity of the item reported that is currently in stock.
	 */
	private BigDecimal InventoryValueAmount;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private String Note;
	/**
	 * The quantity of the item reported that is currently in stock.
	 */
	private BigDecimal Quantity;
	private Item m_Item;
	private Location Inventory Location;

	public Inventory Report Line(){

	}

	public void finalize() throws Throwable {

	}
	public LocalDate getAvailabilityDate(){
		return AvailabilityDate;
	}

	public String getAvailabilityStatusCode(){
		return AvailabilityStatusCode;
	}

	public String getID(){
		return ID;
	}

	public Location getInventory Location(){
		return Inventory Location;
	}

	public BigDecimal getInventoryValueAmount(){
		return InventoryValueAmount;
	}

	public Item getItem(){
		return m_Item;
	}

	public String getNote(){
		return Note;
	}

	public BigDecimal getQuantity(){
		return Quantity;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAvailabilityDate(LocalDate newVal){
		AvailabilityDate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAvailabilityStatusCode(String newVal){
		AvailabilityStatusCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(String newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInventory Location(Location newVal){
		Inventory Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInventoryValueAmount(BigDecimal newVal){
		InventoryValueAmount = newVal;
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
	public void setNote(String newVal){
		Note = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setQuantity(BigDecimal newVal){
		Quantity = newVal;
	}
}//end Inventory Report Line