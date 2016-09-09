package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a regulation.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:20 a. m.
 */
public class RegulationAdapter{

	/**
	 * Text describing a legal reference.
	 */
	private TextType legalReference; 
	/**
	 * A name for this regulation.
	 */
	private NameType name; 
	/**
	 * The Uniform Resource Identifier (URI) of an ontology related to this regulation.
	 */
	private IdentifierType ontologyURIID; 

}
