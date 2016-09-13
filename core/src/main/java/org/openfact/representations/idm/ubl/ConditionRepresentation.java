package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.MeasureRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to define a measurable condition of an object.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:42 a. m.
 */
public class ConditionRepresentation {

    /**
     * An identifier for the attribute that applies to the condition.
     */
    private IdentifierRepresentation attributeID;
    /**
     * Text describing the attribute that applies to the condition.
     */
    private TextRepresentation description;
    /**
     * The maximum value in a range of measurement for this condition.
     */
    private MeasureRepresentation maximumMeasure;
    /**
     * The measurement value.
     */
    private MeasureRepresentation measure;
    /**
     * The minimum value in a range of measurement for this condition.
     */
    private MeasureRepresentation minimumMeasure;

}
