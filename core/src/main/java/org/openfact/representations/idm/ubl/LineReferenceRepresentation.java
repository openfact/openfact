package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.LineStatusCodeRepresentation;

/**
 * A class to define a reference to a line in a document.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:57 a. m.
 */
public class LineReferenceRepresentation {

    /**
     * Identifies the referenced line in the document.
     */
    private IdentifierRepresentation lineID;
    /**
     * A code signifying the status of the referenced line with respect to its
     * original state.
     */
    private LineStatusCodeRepresentation lineStatusCode;
    /**
     * A universally unique identifier for this line reference.
     */
    private IdentifierRepresentation UUID;
    private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>();

}
