package org.openfact.models.ubl;

import java.time.LocalDate;

import org.openfact.models.ubl.type.*;

/**
 * A class for defining a lot identifier (the identifier of a set of item
 * instances that would be used in case of a recall of that item).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:03 a. m.
 */
public class LotIdentificationModel {

    /**
     * The expiry date of the lot.
     */
    private LocalDate expiryDate;
    /**
     * An identifier for the lot.
     */
    private IdentifierModel lotNumberID;
    private ItemPropertyModel additionalItemProperty;

}
