package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a line describing a request for a catalogue line.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:25 a. m.
 */
public class CatalogueRequestLine {

	/**
	 * A subdivision of a contract or tender covering the line being requested.
	 */
	private String ContractSubdivision;
	/**
	 * An identifier for the requested catalogue line.
	 */
	private String ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private String Note;
	private Item m_Item;
	private Item Location Quantity Required Item Location Quantity;
	private Period Line Validity Period;

	public Catalogue Request Line(){

	}

	public void finalize() throws Throwable {

	}
	public String getContractSubdivision(){
		return ContractSubdivision;
	}

	public String getID(){
		return ID;
	}

	public Item getItem(){
		return m_Item;
	}

	public Period getLine Validity Period(){
		return Line Validity Period;
	}

	public String getNote(){
		return Note;
	}

	public Item Location Quantity getRequired Item Location Quantity(){
		return Required Item Location Quantity;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setContractSubdivision(String newVal){
		ContractSubdivision = newVal;
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
	public void setItem(Item newVal){
		m_Item = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLine Validity Period(Period newVal){
		Line Validity Period = newVal;
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
	public void setRequired Item Location Quantity(Item Location Quantity newVal){
		Required Item Location Quantity = newVal;
	}
}//end Catalogue Request Line