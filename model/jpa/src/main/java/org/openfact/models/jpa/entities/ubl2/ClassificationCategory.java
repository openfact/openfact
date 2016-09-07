

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
	private Text. Type CodeValue;
	/**
	 * Text describing this category.
	 */
	private Text. Type Description;
	/**
	 * The name of this category within the classification scheme.
	 */
	private Name. Type Name;
	private Classification Category Categorizes Classification Category;

	public Classification Category(){

	}

	public void finalize() throws Throwable {

	}
	public Classification Category getCategorizes Classification Category(){
		return Categorizes Classification Category;
	}

	public Text. Type getCodeValue(){
		return CodeValue;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Name. Type getName(){
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
	public void setCodeValue(Text. Type newVal){
		CodeValue = newVal;
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
	public void setName(Name. Type newVal){
		Name = newVal;
	}
}//end Classification Category