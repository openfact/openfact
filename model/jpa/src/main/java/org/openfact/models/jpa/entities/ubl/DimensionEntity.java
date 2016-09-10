package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.MeasureType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to define a measurable dimension (length, mass, weight, volume, or
 * area) of an item.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:14:30 a. m.
 */
public class DimensionEntity {

    /**
     * An identifier for the attribute to which the measure applies.
     */
    private IdentifierType attributeID;
    /**
     * Text describing the measurement attribute.
     */
    private TextType description;
    /**
     * The maximum value in a range of measurement of this dimension.
     */
    private MeasureType maximumMeasure;
    /**
     * The measurement value.
     */
    private MeasureType measure;
    /**
     * The minimum value in a range of measurement of this dimension.
     */
    private MeasureType minimumMeasure;

}
