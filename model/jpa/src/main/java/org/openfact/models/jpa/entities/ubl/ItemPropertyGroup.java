package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a property group or classification.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:51 a. m.
 */
public class ItemPropertyGroup {

	/**
	 * An identifier for this group of item properties.
	 */
	private String ID;
	/**
	 * A code signifying the importance of this property group in using it to describe
	 * a required Item.
	 */
	private String ImportanceCode;
	/**
	 * The name of this item property group.
	 */
	private String Name;

	public Item Property Group(){

	}

	public void finalize() throws Throwable {

	}
	public String getID(){
		return ID;
	}

	public String getImportanceCode(){
		return ImportanceCode;
	}

	public String getName(){
		return Name;
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
	public void setImportanceCode(String newVal){
		ImportanceCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(String newVal){
		Name = newVal;
	}
}//end Item Property Group