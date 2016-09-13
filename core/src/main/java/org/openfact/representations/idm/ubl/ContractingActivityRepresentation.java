package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * The nature of the type of business of the organization.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:04 a. m.
 */
public class ContractingActivityRepresentation {

    /**
     * The nature of the type of business of the organization, expressed as
     * text.
     */
    private TextRepresentation activityType;
    /**
     * A code specifying the nature of the type of business of the organization.
     */
    private CodeRepresentation activityTypeCode;

}
