

/**
 * A class to describe a specific property of an item.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:50 a. m.
 */
public class Item Property {

	/**
	 * An identifier for this property of an item.
	 */
	private Identifier. Type ID;
	/**
	 * A code signifying the importance of this property in using it to describe a
	 * related Item.
	 */
	private Code. Type ImportanceCode;
	/**
	 * The value expressed as a text in case the property is a value in a list. For
	 * example, a colour.
	 */
	private Text. Type ListValue;
	/**
	 * The name of this item property.
	 */
	private Name. Type Name;
	/**
	 * The name of this item property, expressed as a code.
	 */
	private Code. Type NameCode;
	/**
	 * The method of testing the value of this item property.
	 */
	private Text. Type TestMethod;
	/**
	 * The value of this item property, expressed as text.
	 */
	private Text. Type Value;
	/**
	 * Text qualifying the value of the property.
	 */
	private Text. Type ValueQualifier;
	/**
	 * The value of this item property, expressed as a quantity.
	 */
	private Quantity. Type ValueQuantity;
	private Dimension Range Dimension;
	private Item Property Group m_Item Property Group;
	private Item Property Range m_Item Property Range;
	private Period Usability Period;

	public Item Property(){

	}

	public void finalize() throws Throwable {

	}
	public Identifier. Type getID(){
		return ID;
	}

	public Code. Type getImportanceCode(){
		return ImportanceCode;
	}

	public Item Property Group getItem Property Group(){
		return m_Item Property Group;
	}

	public Item Property Range getItem Property Range(){
		return m_Item Property Range;
	}

	public Text. Type getListValue(){
		return ListValue;
	}

	public Name. Type getName(){
		return Name;
	}

	public Code. Type getNameCode(){
		return NameCode;
	}

	public Dimension getRange Dimension(){
		return Range Dimension;
	}

	public Text. Type getTestMethod(){
		return TestMethod;
	}

	public Period getUsability Period(){
		return Usability Period;
	}

	public Text. Type getValue(){
		return Value;
	}

	public Text. Type getValueQualifier(){
		return ValueQualifier;
	}

	public Quantity. Type getValueQuantity(){
		return ValueQuantity;
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
	public void setImportanceCode(Code. Type newVal){
		ImportanceCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setItem Property Group(Item Property Group newVal){
		m_Item Property Group = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setItem Property Range(Item Property Range newVal){
		m_Item Property Range = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setListValue(Text. Type newVal){
		ListValue = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(Name. Type newVal){
		Name = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNameCode(Code. Type newVal){
		NameCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRange Dimension(Dimension newVal){
		Range Dimension = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTestMethod(Text. Type newVal){
		TestMethod = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setUsability Period(Period newVal){
		Usability Period = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValue(Text. Type newVal){
		Value = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValueQualifier(Text. Type newVal){
		ValueQualifier = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValueQuantity(Quantity. Type newVal){
		ValueQuantity = newVal;
	}
}//end Item Property