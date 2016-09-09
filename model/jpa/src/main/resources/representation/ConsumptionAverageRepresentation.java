package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define an average consumption as a monetary amount.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:47 a. m.
 */
public class ConsumptionAverageRepresentation{

	/**
	 * The average monetary amount of the consumption.
	 */
	private AmountType averageAmount; 
	/**
	 * A description of the average consumed.
	 */
	private TextType description; 

}
