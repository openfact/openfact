package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.MeasureRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

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
    private IdentifierRepresentation attributeID;
    /**
     * Text describing this temperature measurement.
     */
    private TextRepresentation description;
    /**
     * The value of this temperature measurement.
     */
    private MeasureRepresentation measure;

}
