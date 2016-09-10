package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.IdentifierType;
import org.openfact.representations.idm.ubl.type.MeasureType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * A class to describe a measurement of temperature.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:18:13 a. m.
 */
public class TemperatureRepresentation {

    /**
     * An identifier for this temperature measurement.
     */
    private IdentifierType attributeID;
    /**
     * Text describing this temperature measurement.
     */
    private TextType description;
    /**
     * The value of this temperature measurement.
     */
    private MeasureType measure;

}
