package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.NameRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe a regulation.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:20 a. m.
 */
public class RegulationRepresentation {

    /**
     * Text describing a legal reference.
     */
    private TextRepresentation legalReference;
    /**
     * A name for this regulation.
     */
    private NameRepresentation name;
    /**
     * The Uniform Resource Identifier (URI) of an ontology related to this
     * regulation.
     */
    private IdentifierRepresentation ontologyURIID;

}
