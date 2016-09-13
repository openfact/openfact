package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe the relationship to an item different from the item
 * associated with the item line in which RelatedItemModel is used.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:22 a. m.
 */
public class RelatedItemModel {

    /**
     * Text describing the relationship.
     */
    private TextModel description;
    /**
     * An identifier for the related item.
     */
    private IdentifierModel ID;
    /**
     * The quantity that applies to the relationship.
     */
    private QuantityModel quantity;

}
