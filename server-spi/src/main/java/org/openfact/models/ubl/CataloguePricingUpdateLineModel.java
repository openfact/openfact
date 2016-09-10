package org.openfact.models.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line describing a pricing update to a catalogue line.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:21 a. m.
 */
public class CataloguePricingUpdateLineModel{

	/**
	 * An identifier for the catalogue line to be updated.
	 */
	private IdentifierType ID; 
	private CustomerPartyModel contractorCustomerParty; 
	private ItemLocationQuantityModel requiredItemLocationQuantity; 
	private SupplierPartyModel sellerSupplierParty; 

}
