package org.openfact.models.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe the consumption of a utility product.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:56 a. m.
 */
public class UtilityItemModel{

	/**
	 * The type of product consumed, expressed as text.
	 */
	private TextType consumptionType; 
	/**
	 * The type of product consumed, expressed as a code.
	 */
	private CodeType consumptionTypeCode; 
	/**
	 * Information of the actual payments type for the utility Item
	 */
	private TextType currentChargeType; 
	/**
	 * Information of the actual payments type code expressed as a code
	 */
	private CodeType currentChargeTypeCode; 
	/**
	 * Text describing the consumption product.
	 */
	private TextType description; 
	/**
	 * An identifier for this utility item.
	 */
	private IdentifierType ID; 
	/**
	 * Information about the one-time payment type in case everything is paid One time
	 */
	private TextType oneTimeChargeType; 
	/**
	 * Information about the one-time payment type code
	 */
	private CodeType oneTimeChargeTypeCode; 
	/**
	 * The unit packaging quantity.
	 */
	private QuantityType packQuantity; 
	/**
	 * The number of items in a pack.
	 */
	private BigDecimal packSizeNumeric; 
	/**
	 * An identifier for the subscriber to the utility.
	 */
	private IdentifierType subscriberID; 
	/**
	 * Identification of the subscriber type, expressed as text..
	 */
	private TextType subscriberType; 
	/**
	 * The code identifying for the service type.
	 */
	private CodeType subscriberTypeCode; 
	private List<ContractModel> contracts = new ArrayList<>(); 
	private List<TaxCategoryModel> taxCategories = new ArrayList<>(); 

}
