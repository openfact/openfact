package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;
import org.openfact.models.ubl.type.LongitudeDirectionCodeModel;

/**
 * A class for defining a set of geographical coordinates (apparently misnamed).
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:02 a. m.
 */
public class LocationCoordinateModel {

    /**
     * The altitude of the location.
     */
    private MeasureModel altitudeMeasure;
    /**
     * A code signifying the location system used.
     */
    private CodeModel coordinateSystemCode;
    /**
     * The degree component of a latitude measured in degrees and minutes.
     */
    private MeasureModel latitudeDegreesMeasure;
    /**
     * A code signifying the direction of latitude measurement from the equator
     * (north or south).
     */
    private LatitudeDirectionCodeModel latitudeDirectionCode;
    /**
     * The minutes component of a latitude measured in degrees and minutes
     * (modulo 60).
     */
    private MeasureModel latitudeMinutesMeasure;
    /**
     * The degree component of a longitude measured in degrees and minutes.
     */
    private MeasureModel longitudeDegreesMeasure;
    /**
     * A code signifying the direction of longitude measurement from the prime
     * meridian (east or west).
     */
    private LongitudeDirectionCodeModel longitudeDirectionCode;
    /**
     * The minutes component of a longitude measured in degrees and minutes
     * (modulo 60).
     */
    private MeasureModel longitudeMinutesMeasure;

}
