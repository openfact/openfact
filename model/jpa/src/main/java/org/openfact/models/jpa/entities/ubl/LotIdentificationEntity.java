package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.DateType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;

/**
 * A class for defining a lot identifier (the identifier of a set of item
 * instances that would be used in case of a recall of that item).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:03 a. m.
 */
public class LotIdentificationEntity {

    /**
     * The expiry date of the lot.
     */
    private DateType ExpiryDate;
    /**
     * An identifier for the lot.
     */
    private IdentifierType LotNumberID;
    private ItemPropertyEntity AdditionalItemProperty;

}
