package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe the completion of a specific task in the tendering process.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:40 a. m.
 */
public class CompletedTask{

	/**
	 * The average monetary amount of a task such as this completed task.
	 */
	private BigDecimal AnnualAverageAmount;
	/**
	 * Text describing this completed task.
	 */
	private TextType Description;
	/**
	 * A monetary amount corresponding to the financial capacity of the party that
	 * carried out this completed task.
	 */
	private BigDecimal PartyCapacityAmount;
	/**
	 * The actual total monetary amount of this completed task.
	 */
	private BigDecimal TotalTaskAmount;
	private CustomerParty RecipientCustomerParty;
	private List<EvidenceSupplied> EvidenceSupplieds = new ArrayList<>();
	private List<Period> Periods = new ArrayList<>();

}
