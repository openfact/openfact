package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.BinaryObjectType;

/**
 * A class to describe an attached document. An attachment can refer to an
 * external document or be included with the document being exchanged.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:12:47 a. m.
 */
public class AttachmentEntity {

    /**
     * A binary large object containing an attached document.
     */
    private BinaryObjectType embeddedDocumentBinaryObject;
    private List<ExternalReferenceEntity> externalReferences = new ArrayList<>();

}
