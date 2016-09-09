package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * The charging rate used for both call charging and time dependent charging
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:38 a. m.
 */
public class Duty{

	/**
	 * The amount of this duty.
	 */
	private AmountType Amount;
	/**
	 * Text describing this duty.
	 */
	private TextType Duty;
	/**
	 * The type of this charge rate, expressed as a code.
	 */
	private CodeType DutyCode;
	private List<TaxCategory> TaxCategories = new ArrayList<>();

}
