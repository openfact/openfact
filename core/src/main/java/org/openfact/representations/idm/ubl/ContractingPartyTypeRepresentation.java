package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * The type of contracting party that is independent of its role.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:08 a. m.
 */
public class ContractingPartyTypeRepresentation {

    /**
     * The type of party that is independent of its role, expressed as text.
     */
    private TextRepresentation partyType;
    /**
     * A code specifying the type of party that is independent of its role.
     */
    private CodeRepresentation partyTypeCode;

}
