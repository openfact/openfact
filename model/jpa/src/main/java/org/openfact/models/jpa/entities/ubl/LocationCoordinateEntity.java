package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.latitudeDirectionCodeType;
import org.openfact.models.jpa.entities.ublType.MeasureType;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.longitudeDirectionCodeType;

/**
 * A class for defining a set of geographical coordinates (apparently misnamed).
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:02 a. m.
 */
public class LocationCoordinateEntity {

    /**
     * The altitude of the location.
     */
    private MeasureType altitudeMeasure;
    /**
     * A code signifying the location system used.
     */
    private CodeType coordinateSystemCode;
    /**
     * The degree component of a latitude measured in degrees and minutes.
     */
    private MeasureType latitudeDegreesMeasure;
    /**
     * A code signifying the direction of latitude measurement from the equator
     * (north or south).
     */
    private latitudeDirectionCodeType latitudeDirectionCode;
    /**
     * The minutes component of a latitude measured in degrees and minutes
     * (modulo 60).
     */
    private MeasureType latitudeMinutesMeasure;
    /**
     * The degree component of a longitude measured in degrees and minutes.
     */
    private MeasureType longitudeDegreesMeasure;
    /**
     * A code signifying the direction of longitude measurement from the prime
     * meridian (east or west).
     */
    private longitudeDirectionCodeType longitudeDirectionCode;
    /**
     * The minutes component of a longitude measured in degrees and minutes
     * (modulo 60).
     */
    private MeasureType longitudeMinutesMeasure;

}
