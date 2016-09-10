package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a property group or classification.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:51 a. m.
 */
public class ItemPropertyGroupModel {

    /**
     * An identifier for this group of item properties.
     */
    private IdentifierType ID;
    /**
     * A code signifying the importance of this property group in using it to
     * describe a required Item.
     */
    private CodeType importanceCode;
    /**
     * The name of this item property group.
     */
    private NameType name;

}
