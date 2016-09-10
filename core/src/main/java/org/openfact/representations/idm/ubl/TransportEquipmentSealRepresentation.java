package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.IdentifierType;
import org.openfact.representations.idm.ubl.type.TextType;

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
    private TextType condition;
    /**
     * An identifier for this transport equipment seal.
     */
    private IdentifierType ID;
    /**
     * The role of the sealing party.
     */
    private TextType sealingPartyType;
    /**
     * A code signifying the type of party that issues and is responsible for
     * this transport equipment seal.
     */
    private CodeType sealIssuerTypeCode;
    /**
     * A code signifying the condition of this transport equipment seal.
     */
    private CodeType sealStatusCode;

}
