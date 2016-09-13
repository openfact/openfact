package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.MeasureRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to define a measurable dimension (length, mass, weight, volume, or
 * area) of an item.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:14:30 a. m.
 */
public class DimensionRepresentation {

    /**
     * An identifier for the attribute to which the measure applies.
     */
    private IdentifierRepresentation attributeID;
    /**
     * Text describing the measurement attribute.
     */
    private TextRepresentation description;
    /**
     * The maximum value in a range of measurement of this dimension.
     */
    private MeasureRepresentation maximumMeasure;
    /**
     * The measurement value.
     */
    private MeasureRepresentation measure;
    /**
     * The minimum value in a range of measurement of this dimension.
     */
    private MeasureRepresentation minimumMeasure;

}
