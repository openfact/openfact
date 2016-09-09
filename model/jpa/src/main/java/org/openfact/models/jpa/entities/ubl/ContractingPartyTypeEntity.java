package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * The type of contracting party that is independent of its role.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:08 a. m.
 */
public class ContractingPartyTypeEntity {

    /**
     * The type of party that is independent of its role, expressed as text.
     */
    private TextType PartyType;
    /**
     * A code specifying the type of party that is independent of its role.
     */
    private CodeType PartyTypeCode;

}
