package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.ubl.type.TextType;

/**
 * A class to describe a range of values for an item property.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:53 a. m.
 */
public class ItemPropertyRangeEntity {

    /**
     * The maximum value in this range of values.
     */
    private TextType maximumValue;
    /**
     * The minimum value in this range of values.
     */
    private TextType minimumValue;

}
