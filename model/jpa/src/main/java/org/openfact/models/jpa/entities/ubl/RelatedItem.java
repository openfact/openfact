package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

import org.openfact.models.jpa.entities.ubl2.Related;

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
	private String Description;
	/**
	 * An identifier for the related item.
	 */
	private String ID;
	/**
	 * The quantity that applies to the relationship.
	 */
	private BigDecimal Quantity;

	public Related Item(){

	}

	public void finalize() throws Throwable {

	}
	public String getDescription(){
		return Description;
	}

	public String getID(){
		return ID;
	}

	public BigDecimal getQuantity(){
		return Quantity;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(String newVal){
		Description = newVal;
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
	public void setQuantity(BigDecimal newVal){
		Quantity = newVal;
	}
}//end Related Item