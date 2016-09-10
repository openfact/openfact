package org.openfact.models.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a StockAvailabilityReportModel describing the
 * availability of an item of sale.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:52 a. m.
 */
public class StockAvailabilityReportLineModel{

	/**
	 * The date from which the item will be available. A date identical to or earlier
	 * than the IssueDate of the StockAvailabilityReportModel means that the item is
	 * available now
	 */
	private LocalDate availabilityDate; 
	/**
	 * A code signifying the level of availability of the item.
	 */
	private CodeType availabilityStatusCode; 
	/**
	 * An identifier for this stock availability line.
	 */
	private IdentifierType ID; 
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType note; 
	/**
	 * The quantity of the item currently in stock.
	 */
	private QuantityType quantity; 
	/**
	 * The monetary value of the quantity of the item currently in stock.
	 */
	private BigDecimal valueAmount; 
	private List<ItemModel> items = new ArrayList<>(); 

}
