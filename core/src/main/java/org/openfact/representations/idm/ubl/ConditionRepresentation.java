package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.IdentifierType;
import org.openfact.representations.idm.ubl.type.MeasureType;
import org.openfact.representations.idm.ubl.type.TextType;

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
    private IdentifierType attributeID;
    /**
     * Text describing the attribute that applies to the condition.
     */
    private TextType description;
    /**
     * The maximum value in a range of measurement for this condition.
     */
    private MeasureType maximumMeasure;
    /**
     * The measurement value.
     */
    private MeasureType measure;
    /**
     * The minimum value in a range of measurement for this condition.
     */
    private MeasureType minimumMeasure;

}
