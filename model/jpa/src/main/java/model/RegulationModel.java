package model;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a regulation.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:20 a. m.
 */
public class RegulationModel{

	/**
	 * Text describing a legal reference.
	 */
	private TextType LegalReference;
	/**
	 * A name for this regulation.
	 */
	private NameType Name;
	/**
	 * The Uniform Resource Identifier (URI) of an ontology related to this regulation.
	 */
	private IdentifierType OntologyURIID;

}
