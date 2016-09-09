package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a taxation scheme (e.g., VAT, State tax, County tax).
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:04 a. m.
 */
public class TaxSchemeEntity{

	/**
	 * A code signifying the currency in which the tax is collected and reported.
	 */
	private CurrencyCodeType codeTypeCurrencyCode; 
	/**
	 * An identifier for this taxation scheme.
	 */
	private IdentifierType ID; 
	/**
	 * The name of this taxation scheme.
	 */
	private NameType name; 
	/**
	 * A code signifying the type of tax.
	 */
	private CodeType taxTypeCode; 
	private AddressEntity jurisdictionRegionAddress; 

}
