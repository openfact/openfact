package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.LatitudeDirectionCodeRepresentation;
import org.openfact.representations.idm.ubl.type.MeasureRepresentation;
import org.openfact.representations.idm.ubl.type.LongitudeDirectionCodeRepresentation;

/**
 * A class for defining a set of geographical coordinates (apparently misnamed).
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:02 a. m.
 */
public class LocationCoordinateRepresentation {

    /**
     * The altitude of the location.
     */
    private MeasureRepresentation altitudeMeasure;
    /**
     * A code signifying the location system used.
     */
    private CodeRepresentation coordinateSystemCode;
    /**
     * The degree component of a latitude measured in degrees and minutes.
     */
    private MeasureRepresentation latitudeDegreesMeasure;
    /**
     * A code signifying the direction of latitude measurement from the equator
     * (north or south).
     */
    private LatitudeDirectionCodeRepresentation latitudeDirectionCode;
    /**
     * The minutes component of a latitude measured in degrees and minutes
     * (modulo 60).
     */
    private MeasureRepresentation latitudeMinutesMeasure;
    /**
     * The degree component of a longitude measured in degrees and minutes.
     */
    private MeasureRepresentation longitudeDegreesMeasure;
    /**
     * A code signifying the direction of longitude measurement from the prime
     * meridian (east or west).
     */
    private LongitudeDirectionCodeRepresentation longitudeDirectionCode;
    /**
     * The minutes component of a longitude measured in degrees and minutes
     * (modulo 60).
     */
    private MeasureRepresentation longitudeMinutesMeasure;

}
