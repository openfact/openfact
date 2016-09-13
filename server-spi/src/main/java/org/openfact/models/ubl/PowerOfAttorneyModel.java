package org.openfact.models.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a power of attorney.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:51 a. m.
 */
public class PowerOfAttorneyModel {

    /**
     * Text describing this power of attorney.
     */
    private TextModel description;
    /**
     * An identifier for this power of attorney.
     */
    private IdentifierModel ID;
    /**
     * The date on which this power of attorney was issued.
     */
    private LocalDate issueDate;
    /**
     * The time at which this power of attorney was issued.
     */
    private LocalTime issueTime;
    private DocumentReferenceModel mandateDocumentReference;
    private PartyModel agentParty;
    private PartyModel notaryParty;
    private PartyModel witnessParty;

}
