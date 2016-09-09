package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a branch or a division of an organization.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:13:10 a. m.
 */
public class Branch{

	/**
	 * An identifier for this branch or division of an organization.
	 */
	private IdentifierType ID;
	/**
	 * The name of this branch or division of an organization.
	 */
	private NameType Name;
	private List<Address> Addresses = new ArrayList<>();
	private List<FinancialInstitution> FinancialInstitutions = new ArrayList<>();

}
