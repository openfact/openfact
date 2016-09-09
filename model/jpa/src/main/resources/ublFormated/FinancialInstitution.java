package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a financial institution.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:14 a. m.
 */
public class FinancialInstitution{

	/**
	 * An identifier for this financial institution. It is recommended that the ISO
	 * 9362 Bank Identification Code (BIC) be used as the ID.
	 */
	private IdentifierType ID;
	/**
	 * The name of this financial institution.
	 */
	private NameType Name;
	private List<Address> Addresses = new ArrayList<>();

}
