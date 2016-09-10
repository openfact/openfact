package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.ubl.type.NameType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to define a name/value pair for a property of an inventory planning
 * activity.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:36 a. m.
 */
public class ActivityPropertyEntity {

    /**
     * The name of this activity property.
     */
    private NameType name;
    /**
     * The value of this activity property.
     */
    private TextType value;

}
