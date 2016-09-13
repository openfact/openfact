package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.BinaryObjectRepresentation;

/**
 * A class to describe an attached document. An attachment can refer to an
 * external document or be included with the document being exchanged.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:12:47 a. m.
 */
public class AttachmentRepresentation {

    /**
     * A binary large object containing an attached document.
     */
    private BinaryObjectRepresentation embeddedDocumentBinaryObject;
    private List<ExternalReferenceRepresentation> externalReferences = new ArrayList<>();

}
