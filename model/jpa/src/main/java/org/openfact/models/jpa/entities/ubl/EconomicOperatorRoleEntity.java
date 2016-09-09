package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe the tenderer contracting role.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:40 a. m.
 */
public class EconomicOperatorRoleEntity {

    /**
     * A code specifying the role of the party.
     */
    private CodeType roleCode;
    /**
     * A textual description of the party role.
     */
    private TextType roleDescription;

}
