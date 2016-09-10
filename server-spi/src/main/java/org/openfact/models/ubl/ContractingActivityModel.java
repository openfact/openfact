package org.openfact.models.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * The nature of the type of business of the organization.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:04 a. m.
 */
public class ContractingActivityModel{

	/**
	 * The nature of the type of business of the organization, expressed as text.
	 */
	private TextType activityType; 
	/**
	 * A code specifying the nature of the type of business of the organization.
	 */
	private CodeType activityTypeCode; 

}
