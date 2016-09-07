

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
	private Date. Type AvailabilityDate;
	/**
	 * A code signifying the item's level of availability.
	 */
	private Code. Type AvailabilityStatusCode;
	/**
	 * An identifier for this inventory report line.
	 */
	private Identifier. Type ID;
	/**
	 * The value of the quantity of the item reported that is currently in stock.
	 */
	private Amount. Type InventoryValueAmount;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private Text. Type Note;
	/**
	 * The quantity of the item reported that is currently in stock.
	 */
	private Quantity. Type Quantity;
	private Item m_Item;
	private Location Inventory Location;

	public Inventory Report Line(){

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

	public Location getInventory Location(){
		return Inventory Location;
	}

	public Amount. Type getInventoryValueAmount(){
		return InventoryValueAmount;
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
	public void setInventory Location(Location newVal){
		Inventory Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInventoryValueAmount(Amount. Type newVal){
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
}//end Inventory Report Line