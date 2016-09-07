package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a line describing a pricing update to a catalogue line.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:21 a. m.
 */
public class CataloguePricingUpdateLine {

	/**
	 * An identifier for the catalogue line to be updated.
	 */
	private String ID;
	private Customer Party Contractor Customer Party;
	private Item Location Quantity Required Item Location Quantity;
	private Supplier Party Seller Supplier Party;

	public Catalogue Pricing Update Line(){

	}

	public void finalize() throws Throwable {

	}
	public Customer Party getContractor Customer Party(){
		return Contractor Customer Party;
	}

	public String getID(){
		return ID;
	}

	public Item Location Quantity getRequired Item Location Quantity(){
		return Required Item Location Quantity;
	}

	public Supplier Party getSeller Supplier Party(){
		return Seller Supplier Party;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContractor Customer Party(Customer Party newVal){
		Contractor Customer Party = newVal;
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
	public void setRequired Item Location Quantity(Item Location Quantity newVal){
		Required Item Location Quantity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSeller Supplier Party(Supplier Party newVal){
		Seller Supplier Party = newVal;
	}
}//end Catalogue Pricing Update Line