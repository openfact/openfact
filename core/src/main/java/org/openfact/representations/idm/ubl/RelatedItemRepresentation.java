package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.IdentifierType;
import org.openfact.representations.idm.ubl.type.QuantityType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * A class to describe the relationship to an item different from the item
 * associated with the item line in which RelatedItemRepresentation is used.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:22 a. m.
 */
public class RelatedItemRepresentation {

    /**
     * Text describing the relationship.
     */
    private TextType description;
    /**
     * An identifier for the related item.
     */
    private IdentifierType ID;
    /**
     * The quantity that applies to the relationship.
     */
    private QuantityType quantity;

}