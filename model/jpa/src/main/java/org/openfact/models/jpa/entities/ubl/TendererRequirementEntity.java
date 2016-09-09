package org.openfact.models.jpa.entities.ubl;
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
public class TendererRequirementEntity{

	/**
	 * Text describing this requirement.
	 */
	private TextType description; 
	/**
	 * The legal reference of the exclusion criterion.
	 */
	private TextType legalReference; 
	/**
	 * A name of this tenderer requirement.
	 */
	private NameType name; 
	/**
	 * A code signifying this requirement.
	 */
	private CodeType tendererRequirementTypeCode; 
	private EvidenceEntity suggestedEvidence; 

}
