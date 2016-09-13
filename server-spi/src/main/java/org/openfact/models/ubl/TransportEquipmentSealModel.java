package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a device (a transport equipment seal) for securing the
 * doors of a shipping container.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:39 a. m.
 */
public class TransportEquipmentSealModel {

    /**
     * The condition of this transport equipment seal.
     */
    private TextModel condition;
    /**
     * An identifier for this transport equipment seal.
     */
    private IdentifierModel ID;
    /**
     * The role of the sealing party.
     */
    private TextModel sealingPartyType;
    /**
     * A code signifying the type of party that issues and is responsible for
     * this transport equipment seal.
     */
    private CodeModel sealIssuerTypeCode;
    /**
     * A code signifying the condition of this transport equipment seal.
     */
    private CodeModel sealStatusCode;

}