package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class for describing the terms of a trade agreement.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:33 a. m.
 */
public class TradingTerms{

	/**
	 * Text describing the terms of a trade agreement.
	 */
	private TextType Information;
	/**
	 * A reference quoting the basis of the terms
	 */
	private TextType Reference;
	private Address ApplicableAddress;

}
