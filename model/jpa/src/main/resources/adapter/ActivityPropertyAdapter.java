package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a name/value pair for a property of an inventory planning
 * activity.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:36 a. m.
 */
public class ActivityPropertyAdapter{

	/**
	 * The name of this activity property.
	 */
	private NameType name; 
	/**
	 * The value of this activity property.
	 */
	private TextType value; 

}
