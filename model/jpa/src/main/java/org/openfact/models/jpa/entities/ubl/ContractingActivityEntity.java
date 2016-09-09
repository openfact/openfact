package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * The nature of the type of business of the organization.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:04 a. m.
 */
public class ContractingActivityEntity {

    /**
     * The nature of the type of business of the organization, expressed as
     * text.
     */
    private TextType ActivityType;
    /**
     * A code specifying the nature of the type of business of the organization.
     */
    private CodeType ActivityTypeCode;

}
