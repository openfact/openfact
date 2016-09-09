package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class that outlines the telecommunication supply in details
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:11 a. m.
 */
public class TelecommunicationsSupplyLineAdapter{

	/**
	 * The description of the telecommunication supply line
	 */
	private TextType description; 
	/**
	 * An identifier for this telecommunications supply line.
	 */
	private IdentifierType ID; 
	/**
	 * An amount specifying the cost of this telecommunication line
	 */
	private BigDecimal lineExtensionAmount; 
	/**
	 * The phone number used for this telecommunication supply line
	 */
	private TextType phoneNumber; 
	private List<AllowanceChargeAdapter> allowanceCharges = new ArrayList<>(); 
	private List<ExchangeRateAdapter> exchangeRates = new ArrayList<>(); 
	private List<TaxTotalAdapter> taxTotals = new ArrayList<>(); 
	private List<TelecommunicationsServiceAdapter> telecommunicationsServices = new ArrayList<>(); 

}
