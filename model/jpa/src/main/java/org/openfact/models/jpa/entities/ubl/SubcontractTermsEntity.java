package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe subcontract terms for a tendering process.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:55 a. m.
 */
public class SubcontractTermsEntity{

	/**
	 * The monetary amount assigned to the subcontracted task.
	 */
	private AmountType amount; 
	/**
	 * Text describing the subcontract terms.
	 */
	private TextType description; 
	/**
	 * The maximum percentage allowed to be subcontracted.
	 */
	private PercentType maximumPercent; 
	/**
	 * The minimum percentage allowed to be subcontracted.
	 */
	private PercentType minimumPercent; 
	/**
	 * MF: I agree with the query. Rate?
	 */
	private RateType rate; 
	/**
	 * A code specifying the conditions for subcontracting.
	 */
	private CodeType subcontractingConditionsCode; 
	/**
	 * An indicator that the subcontract price is known (true) or not (false).
	 */
	private IndicatorType unknownPriceIndicator; 

}
