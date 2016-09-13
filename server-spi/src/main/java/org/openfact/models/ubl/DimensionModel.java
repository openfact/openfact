package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;

/**
 * A class to define a measurable dimension (length, mass, weight, volume, or
 * area) of an item.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:14:30 a. m.
 */
public class DimensionModel {

    /**
     * An identifier for the attribute to which the measure applies.
     */
    private IdentifierModel attributeID;
    /**
     * Text describing the measurement attribute.
     */
    private TextModel description;
    /**
     * The maximum value in a range of measurement of this dimension.
     */
    private MeasureModel maximumMeasure;
    /**
     * The measurement value.
     */
    private MeasureModel measure;
    /**
     * The minimum value in a range of measurement of this dimension.
     */
    private MeasureModel minimumMeasure;

}
