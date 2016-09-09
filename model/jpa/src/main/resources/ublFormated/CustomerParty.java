package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a customer party.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:14:16 a. m.
 */
public class CustomerParty{

	/**
	 * An identifier for the customer's account, assigned by a third party.
	 */
	private IdentifierType AdditionalAccountID;
	/**
	 * An identifier for the customer's account, assigned by the customer itself.
	 */
	private IdentifierType CustomerAssignedAccountID;
	/**
	 * An identifier for the customer's account, assigned by the supplier.
	 */
	private IdentifierType SupplierAssignedAccountID;
	private Contact DeliveryContact;
	private Contact AccountingContact;
	private Contact BuyerContact;
	private List<Party> Parties = new ArrayList<>();

}
