package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe the tenderer contracting role.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:40 a. m.
 */
public class EconomicOperatorRole{

	/**
	 * A code specifying the role of the party.
	 */
	private CodeType RoleCode;
	/**
	 * A textual description of the party role.
	 */
	private TextType RoleDescription;

}
