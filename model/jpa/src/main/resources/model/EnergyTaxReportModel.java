package org.openfact.models.jpa.entities.ubl;
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
	private AmountType taxEnergyAmount; 
	/**
	 * The monetary amount of the balance of taxes owing.
	 */
	private AmountType taxEnergyBalanceAmount; 
	/**
	 * The monetary amount of taxes (and duties) paid on account.
	 */
	private AmountType taxEnergyOnAccountAmount; 
	private List<TaxSchemeModel> taxSchemes = new ArrayList<>(); 

}
