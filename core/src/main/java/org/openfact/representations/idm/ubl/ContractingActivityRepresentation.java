package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.TextType;

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
    private TextType activityType;
    /**
     * A code specifying the nature of the type of business of the organization.
     */
    private CodeType activityTypeCode;

}
