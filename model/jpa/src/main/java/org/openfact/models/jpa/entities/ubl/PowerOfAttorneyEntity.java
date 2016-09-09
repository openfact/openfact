package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.TextType;
import org.openfact.models.jpa.entities.ublType.TimeType;

/**
 * A class to describe a power of attorney.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:51 a. m.
 */
public class PowerOfAttorneyEntity {

    /**
     * Text describing this power of attorney.
     */
    private TextType description;
    /**
     * An identifier for this power of attorney.
     */
    private IdentifierType ID;
    /**
     * The date on which this power of attorney was issued.
     */
    private DateType issueDate;
    /**
     * The time at which this power of attorney was issued.
     */
    private TimeType issueTime;
    private DocumentReferenceEntity mandateDocumentReference;
    private PartyEntity agentParty;
    private PartyEntity notaryParty;
    private PartyEntity witnessParty;

}
