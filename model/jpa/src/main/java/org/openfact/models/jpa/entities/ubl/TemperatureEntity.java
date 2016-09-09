package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.measureType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe a measurement of temperature.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:18:13 a. m.
 */
public class TemperatureEntity {

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
    private measureType measure;

}
