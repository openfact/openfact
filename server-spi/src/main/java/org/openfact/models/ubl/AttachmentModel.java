package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe an attached document. An attachment can refer to an
 * external document or be included with the document being exchanged.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:12:47 a. m.
 */
public class AttachmentModel {

    /**
     * A binary large object containing an attached document.
     */
    private BinaryObjectModel embeddedDocumentBinaryObject;
    private List<ExternalReferenceModel> externalReferences = new ArrayList<>();

}
