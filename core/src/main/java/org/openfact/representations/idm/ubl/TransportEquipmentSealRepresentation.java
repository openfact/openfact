package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe a device (a transport equipment seal) for securing the
 * doors of a shipping container.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:39 a. m.
 */
public class TransportEquipmentSealRepresentation {

    /**
     * The condition of this transport equipment seal.
     */
    private TextRepresentation condition;
    /**
     * An identifier for this transport equipment seal.
     */
    private IdentifierRepresentation ID;
    /**
     * The role of the sealing party.
     */
    private TextRepresentation sealingPartyType;
    /**
     * A code signifying the type of party that issues and is responsible for
     * this transport equipment seal.
     */
    private CodeRepresentation sealIssuerTypeCode;
    /**
     * A code signifying the condition of this transport equipment seal.
     */
    private CodeRepresentation sealStatusCode;

}
