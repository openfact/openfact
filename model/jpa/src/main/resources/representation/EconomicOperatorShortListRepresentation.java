package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to provide information about the preselection of a short list of
 * economic operators for consideration as possible candidates in a tendering
 * process.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:41 a. m.
 */
public class EconomicOperatorShortListRepresentation{

	/**
	 * The number of economic operators expected to be on the short list.
	 */
	private QuantityType expectedQuantity; 
	/**
	 * Text describing the criteria used to restrict the number of candidates.
	 */
	private TextType limitationDescription; 
	/**
	 * The maximum number of economic operators on the short list.
	 */
	private QuantityType maximumQuantity; 
	/**
	 * The minimum number of economic operators on the short list.
	 */
	private QuantityType minimumQuantity; 
	private PartyRepresentation preSelectedParty; 

}
