package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a line in an Instruction for Returns.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:33 a. m.
 */
public class InstructionForReturnsLine {

	/**
	 * An identifier for this instruction for returns line.
	 */
	private Identifier. Type ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private Text. Type Note;
	/**
	 * The quantity of goods being returned.
	 */
	private Quantity. Type Quantity;
	private Item m_Item;
	private Party Manufacturer Party;

	public Instruction For Returns Line(){

	}

	public void finalize() throws Throwable {

	}
	public Identifier. Type getID(){
		return ID;
	}

	public Item getItem(){
		return m_Item;
	}

	public Party getManufacturer Party(){
		return Manufacturer Party;
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
	public void setManufacturer Party(Party newVal){
		Manufacturer Party = newVal;
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
}//end Instruction For Returns Line