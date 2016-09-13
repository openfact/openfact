package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a regulation.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:20 a. m.
 */
public class RegulationModel {

    /**
     * Text describing a legal reference.
     */
    private TextModel legalReference;
    /**
     * A name for this regulation.
     */
    private NameModel name;
    /**
     * The Uniform Resource Identifier (URI) of an ontology related to this
     * regulation.
     */
    private IdentifierModel ontologyURIID;

}
