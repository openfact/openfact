package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;

/**
 * A template for a required document in a tendering process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:17 a. m.
 */
public class TenderRequirementModel {

    /**
     * Text describing this tender requirement.
     */
    private TextType description;
    /**
     * A name of this tender requirement.
     */
    private NameType name;
    private DocumentReferenceModel templateDocumentReference;

}
