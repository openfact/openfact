package org.openfact.models.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe energy taxes.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:47 a. m.
 */
public class EnergyTaxReportModel{

	/**
	 * The monetary amount of taxes (and duties).
	 */
	private BigDecimal taxEnergyAmount; 
	/**
	 * The monetary amount of the balance of taxes owing.
	 */
	private BigDecimal taxEnergyBalanceAmount; 
	/**
	 * The monetary amount of taxes (and duties) paid on account.
	 */
	private BigDecimal taxEnergyOnAccountAmount; 
	private List<TaxSchemeModel> taxSchemes = new ArrayList<>(); 

}
