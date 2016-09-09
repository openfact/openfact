package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a contract.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:59 a. m.
 */
public class Contract{

	/**
	 * The type of this contract, expressed as text, such as "Cost plus award fee" and
	 * "Cost plus fixed fee" from UNCEFACT Contract Type code list.
	 */
	private TextType ContractType;
	/**
	 * The type of this contract, expressed as a code, such as "Cost plus award fee"
	 * and "Cost plus fixed fee" from UNCEFACT Contract Type code list.
	 */
	private CodeType ContractTypeCode;
	/**
	 * Text describing this contract.
	 */
	private TextType Description;
	/**
	 * An identifier for this contract.
	 */
	private IdentifierType ID;
	/**
	 * The date on which this contract was issued.
	 */
	private LocalDate IssueDate;
	/**
	 * The time at which this contract was issued.
	 */
	private LocalTime IssueTime;
	/**
	 * In a transportation contract, the deadline date by which the services referred
	 * to in the transport execution plan have to be booked. For example, if this
	 * service is a carrier service scheduled for Wednesday 16 February 2011 at 10 a.m.
	 * CET, the nomination 
	 */
	private LocalDate NominationDate;
	/**
	 * In a transportation contract, the deadline time by which the services referred
	 * to in the transport execution plan have to be booked. For example, if this
	 * service is a carrier service scheduled for Wednesday 16 February 2011 at 10 a.m.
	 * CET, the nomination 
	 */
	private LocalTime NominationTime;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType Note;
	/**
	 * An identifier for the current version of this contract.
	 */
	private IdentifierType VersionID;
	private Delivery ContractualDelivery;
	private DocumentReference ContractDocumentReference;
	private Period ValidityPeriod;
	private Period NominationPeriod;

}
