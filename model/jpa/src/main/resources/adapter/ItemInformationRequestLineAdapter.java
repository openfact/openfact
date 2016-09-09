package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in an ItemInformationRequestAdapter asking a trading
 * partner for item information.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:44 a. m.
 */
public class ItemInformationRequestLineAdapter{

	/**
	 * The information request can be either about supply chain activity or about
	 * forecasts or about performance metrics, so it should be optional
	 */
	private CodeType forecastTypeCode; 
	/**
	 * A code signifying a measure of performance.
	 */
	private CodeType performanceMetricTypeCode; 
	/**
	 * A code used to identify the type of supply chain activity about which
	 * information request is issued. Examples: CANCELED_ORDERS EMERGENCY_ORDERS
	 * ON_HAND ORDERS
	 */
	private CodeType supplyChainActivityTypeCode; 
	/**
	 * A code signifying the frequency with which item information should be sent to
	 * the requester.
	 */
	private CodeType timeFrequencyCode; 
	private List<PeriodAdapter> periods = new ArrayList<>(); 
	private List<SalesItemAdapter> salesItems = new ArrayList<>(); 

}
