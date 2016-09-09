package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a category within a classification scheme.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:31 a. m.
 */
public class ClassificationCategoryAdapter{

	/**
	 * The value of a code used to identify this category within the classification
	 * scheme.
	 */
	private TextType codeValue; 
	/**
	 * Text describing this category.
	 */
	private TextType description; 
	/**
	 * The name of this category within the classification scheme.
	 */
	private NameType name; 
	private ClassificationCategoryAdapter categorizesClassificationCategory; 

}
