package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe an action or statement required of an economic operator
 * participating in a tendering process.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:26 a. m.
 */
public class TendererRequirement{

	/**
	 * Text describing this requirement.
	 */
	private TextType Description;
	/**
	 * The legal reference of the exclusion criterion.
	 */
	private TextType LegalReference;
	/**
	 * A name of this tenderer requirement.
	 */
	private NameType Name;
	/**
	 * A code signifying this requirement.
	 */
	private CodeType TendererRequirementTypeCode;
	private Evidence SuggestedEvidence;

}
