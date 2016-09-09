package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.NameType;

/**
 * A class to describe a property group or classification.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:51 a. m.
 */
public class ItemPropertyGroupEntity {

    /**
     * An identifier for this group of item properties.
     */
    private IdentifierType ID;
    /**
     * A code signifying the importance of this property group in using it to
     * describe a required Item.
     */
    private CodeType ImportanceCode;
    /**
     * The name of this item property group.
     */
    private NameType Name;

}
