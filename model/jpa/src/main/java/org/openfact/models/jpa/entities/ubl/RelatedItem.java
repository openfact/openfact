package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe the relationship to an item different from the item
 * associated with the item line in which RelatedItem is used.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:22 a. m.
 */
public class RelatedItem {

	/**
	 * Text describing the relationship.
	 */
	private Text. Type Description;
	/**
	 * An identifier for the related item.
	 */
	private Identifier. Type ID;
	/**
	 * The quantity that applies to the relationship.
	 */
	private Quantity. Type Quantity;

	public Related Item(){

	}

	public void finalize() throws Throwable {

	}
	public Text. Type getDescription(){
		return Description;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Quantity. Type getQuantity(){
		return Quantity;
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
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setQuantity(Quantity. Type newVal){
		Quantity = newVal;
	}
}//end Related Item