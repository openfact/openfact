package org.openfact.models.jpa.entities.ubl;


/**
 * A class to define a category within a classification scheme.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:31 a. m.
 */
public class ClassificationCategory {

	/**
	 * The value of a code used to identify this category within the classification
	 * scheme.
	 */
	private String CodeValue;
	/**
	 * Text describing this category.
	 */
	private String Description;
	/**
	 * The name of this category within the classification scheme.
	 */
	private String Name;
	private Classification Category Categorizes Classification Category;

	public Classification Category(){

	}

	public void finalize() throws Throwable {

	}
	public Classification Category getCategorizes Classification Category(){
		return Categorizes Classification Category;
	}

	public String getCodeValue(){
		return CodeValue;
	}

	public String getDescription(){
		return Description;
	}

	public String getName(){
		return Name;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCategorizes Classification Category(Classification Category newVal){
		Categorizes Classification Category = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCodeValue(String newVal){
		CodeValue = newVal;
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
	public void setName(String newVal){
		Name = newVal;
	}
}//end Classification Category