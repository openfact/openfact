package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a specific property of an item.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:50 a. m.
 */
public class ItemPropertyEntity{

	/**
	 * An identifier for this property of an item.
	 */
	private IdentifierType ID; 
	/**
	 * A code signifying the importance of this property in using it to describe a
	 * related Item.
	 */
	private CodeType importanceCode; 
	/**
	 * The value expressed as a text in case the property is a value in a list. For
	 * example, a colour.
	 */
	private TextType listValue; 
	/**
	 * The name of this item property.
	 */
	private NameType name; 
	/**
	 * The name of this item property, expressed as a code.
	 */
	private CodeType nameCode; 
	/**
	 * The method of testing the value of this item property.
	 */
	private TextType testMethod; 
	/**
	 * The value of this item property, expressed as text.
	 */
	private TextType value; 
	/**
	 * Text qualifying the value of the property.
	 */
	private TextType valueQualifier; 
	/**
	 * The value of this item property, expressed as a quantity.
	 */
	private QuantityType valueQuantity; 
	private DimensionEntity rangeDimension; 
	private List<ItemPropertyEntity> groupItemPropertyGroups = new ArrayList<>(); 
	private List<ItemPropertyEntity> rangeItemPropertyRanges = new ArrayList<>(); 
	private PeriodEntity usabilityPeriod; 

}
