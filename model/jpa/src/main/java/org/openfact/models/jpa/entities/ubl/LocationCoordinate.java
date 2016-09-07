package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class for defining a set of geographical coordinates (apparently misnamed).
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:02 a. m.
 */
public class LocationCoordinate {

	/**
	 * The altitude of the location.
	 */
	private BigDecimal altitudeMeasure;
	/**
	 * A code signifying the location system used.
	 */
	private String coordinateSystemCode;
	/**
	 * The degree component of a latitude measured in degrees and minutes.
	 */
	private BigDecimal latitudeDegreesMeasure;
	/**
	 * A code signifying the direction of latitude measurement from the equator
	 * (north or south).
	 */
	private String latitudeDirectionCode;
	/**
	 * The minutes component of a latitude measured in degrees and minutes
	 * (modulo 60).
	 */
	private BigDecimal latitudeMinutesMeasure;
	/**
	 * The degree component of a longitude measured in degrees and minutes.
	 */
	private BigDecimal longitudeDegreesMeasure;
	/**
	 * A code signifying the direction of longitude measurement from the prime
	 * meridian (east or west).
	 */
	private String longitudeDirectionCode;
	/**
	 * The minutes component of a longitude measured in degrees and minutes
	 * (modulo 60).
	 */
	private BigDecimal longitudeMinutesMeasure;

	public LocationCoordinate() {
	}

	public void finalize() throws Throwable {

	}

	public BigDecimal getAltitudeMeasure() {
		return altitudeMeasure;
	}

	public void setAltitudeMeasure(BigDecimal altitudeMeasure) {
		this.altitudeMeasure = altitudeMeasure;
	}

	public String getCoordinateSystemCode() {
		return coordinateSystemCode;
	}

	public void setCoordinateSystemCode(String coordinateSystemCode) {
		this.coordinateSystemCode = coordinateSystemCode;
	}

	public BigDecimal getLatitudeDegreesMeasure() {
		return latitudeDegreesMeasure;
	}

	public void setLatitudeDegreesMeasure(BigDecimal latitudeDegreesMeasure) {
		this.latitudeDegreesMeasure = latitudeDegreesMeasure;
	}

	public String getLatitudeDirectionCode() {
		return latitudeDirectionCode;
	}

	public void setLatitudeDirectionCode(String latitudeDirectionCode) {
		this.latitudeDirectionCode = latitudeDirectionCode;
	}

	public BigDecimal getLatitudeMinutesMeasure() {
		return latitudeMinutesMeasure;
	}

	public void setLatitudeMinutesMeasure(BigDecimal latitudeMinutesMeasure) {
		this.latitudeMinutesMeasure = latitudeMinutesMeasure;
	}

	public BigDecimal getLongitudeDegreesMeasure() {
		return longitudeDegreesMeasure;
	}

	public void setLongitudeDegreesMeasure(BigDecimal longitudeDegreesMeasure) {
		this.longitudeDegreesMeasure = longitudeDegreesMeasure;
	}

	public String getLongitudeDirectionCode() {
		return longitudeDirectionCode;
	}

	public void setLongitudeDirectionCode(String longitudeDirectionCode) {
		this.longitudeDirectionCode = longitudeDirectionCode;
	}

	public BigDecimal getLongitudeMinutesMeasure() {
		return longitudeMinutesMeasure;
	}

	public void setLongitudeMinutesMeasure(BigDecimal longitudeMinutesMeasure) {
		this.longitudeMinutesMeasure = longitudeMinutesMeasure;
	}
}// end Location Coordinate