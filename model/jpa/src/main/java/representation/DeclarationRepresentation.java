package representation;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a declaration by an economic operator of certain
 * characteristics or capabilities in fulfilment of requirements specified in a
 * call for tenders.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:20 a. m.
 */
public class DeclarationRepresentation{

	/**
	 * A code signifying the type of this declaration.
	 */
	private CodeType DeclarationTypeCode;
	/**
	 * Text describing this declaration.
	 */
	private TextType Description;
	/**
	 * The name of this declaration.
	 */
	private NameType Name;
	private List<EvidenceSuppliedRepresentation> EvidenceSupplieds = new ArrayList<>();

}
