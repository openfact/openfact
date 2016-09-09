package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a price list.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:56 a. m.
 */
public class PriceListModel{

	/**
	 * An identifier for this price list.
	 */
	private IdentifierType ID;
	/**
	 * A code signifying whether this price list is an original, copy, revision, or
	 * cancellation.
	 */
	private CodeType statusCode;
	private PeriodModel validityPeriod;
	private PriceListModel previousPriceList;

}
