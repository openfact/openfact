package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to define a reference to a line in a document.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:57 a. m.
 */
public class LineReferenceModel {

    /**
     * Identifies the referenced line in the document.
     */
    private IdentifierType lineID;
    /**
     * A code signifying the status of the referenced line with respect to its
     * original state.
     */
    private LineStatusCodeType lineStatusCode;
    /**
     * A universally unique identifier for this line reference.
     */
    private IdentifierType UUID;
    private List<DocumentReferenceModel> documentReferences = new ArrayList<>();

}
