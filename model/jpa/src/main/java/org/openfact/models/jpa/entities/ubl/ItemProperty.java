package org.openfact.models.jpa.entities.ubl;


/**
 * A class to describe a specific property of an item.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:50 a. m.
 */
public class ItemProperty {

	/**
	 * An identifier for this property of an item.
	 */
	private String ID;
	/**
	 * A code signifying the importance of this property in using it to describe a
	 * related Item.
	 */
	private String ImportanceCode;
	/**
	 * The value expressed as a text in case the property is a value in a list. For
	 * example, a colour.
	 */
	private String ListValue;
	/**
	 * The name of this item property.
	 */
	private String Name;
	/**
	 * The name of this item property, expressed as a code.
	 */
	private String NameCode;
	/**
	 * The method of testing the value of this item property.
	 */
	private String TestMethod;
	/**
	 * The value of this item property, expressed as text.
	 */
	private String Value;
	/**
	 * Text qualifying the value of the property.
	 */
	private String ValueQualifier;
	/**
	 * The value of this item property, expressed as a quantity.
	 */
	private BigDecimal ValueQuantity;
	private Dimension Range Dimension;
	private Item Property Group m_Item Property Group;
	private Item Property Range m_Item Property Range;
	private Period Usability Period;

	public Item Property(){

	}

	public void finalize() throws Throwable {

	}
	public String getID(){
		return ID;
	}

	public String getImportanceCode(){
		return ImportanceCode;
	}

	public Item Property Group getItem Property Group(){
		return m_Item Property Group;
	}

	public Item Property Range getItem Property Range(){
		return m_Item Property Range;
	}

	public String getListValue(){
		return ListValue;
	}

	public String getName(){
		return Name;
	}

	public String getNameCode(){
		return NameCode;
	}

	public Dimension getRange Dimension(){
		return Range Dimension;
	}

	public String getTestMethod(){
		return TestMethod;
	}

	public Period getUsability Period(){
		return Usability Period;
	}

	public String getValue(){
		return Value;
	}

	public String getValueQualifier(){
		return ValueQualifier;
	}

	public BigDecimal getValueQuantity(){
		return ValueQuantity;
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
	public void setListValue(String newVal){
		ListValue = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(String newVal){
		Name = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNameCode(String newVal){
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
	public void setTestMethod(String newVal){
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
	public void setValue(String newVal){
		Value = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValueQualifier(String newVal){
		ValueQualifier = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValueQuantity(BigDecimal newVal){
		ValueQuantity = newVal;
	}
}//end Item Property