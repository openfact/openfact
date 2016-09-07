package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe a location.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:00 a. m.
 */
public class Location {

	/**
	 * Free-form text describing the physical conditions of the location.
	 */
	private String conditions;
	/**
	 * A territorial division of a country, such as a county or state, expressed
	 * as text.
	 */
	private String countrySubentity;
	/**
	 * A territorial division of a country, such as a county or state, expressed
	 * as a code.
	 */
	private String countrySubentityCode;
	/**
	 * Text describing this location.
	 */
	private String description;
	/**
	 * An identifier for this location, e.g., the EAN Location Number, GLN.
	 */
	private String ID;
	/**
	 * The Uniform Resource Identifier (URI) of a document providing information
	 * about this location.
	 */
	private String informationURIID;
	/**
	 * A code signifying the type of location.
	 */
	private String locationTypeCode;
	/**
	 * The name of this location.
	 */
	private String name;
	private Address m_Address;
	private Period validityPeriod;
	private LocationCoordinate m_LocationCoordinate;
	private Location subsidiaryLocation;

	public Location() {

	}

	public void finalize() throws Throwable {

	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public String getCountrySubentity() {
		return countrySubentity;
	}

	public void setCountrySubentity(String countrySubentity) {
		this.countrySubentity = countrySubentity;
	}

	public String getCountrySubentityCode() {
		return countrySubentityCode;
	}

	public void setCountrySubentityCode(String countrySubentityCode) {
		this.countrySubentityCode = countrySubentityCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getInformationURIID() {
		return informationURIID;
	}

	public void setInformationURIID(String informationURIID) {
		this.informationURIID = informationURIID;
	}

	public String getLocationTypeCode() {
		return locationTypeCode;
	}

	public void setLocationTypeCode(String locationTypeCode) {
		this.locationTypeCode = locationTypeCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getM_Address() {
		return m_Address;
	}

	public void setM_Address(Address m_Address) {
		this.m_Address = m_Address;
	}

	public Period getValidityPeriod() {
		return validityPeriod;
	}

	public void setValidityPeriod(Period validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

	public LocationCoordinate getM_LocationCoordinate() {
		return m_LocationCoordinate;
	}

	public void setM_LocationCoordinate(LocationCoordinate m_LocationCoordinate) {
		this.m_LocationCoordinate = m_LocationCoordinate;
	}

	public Location getSubsidiaryLocation() {
		return subsidiaryLocation;
	}

	public void setSubsidiaryLocation(Location subsidiaryLocation) {
		this.subsidiaryLocation = subsidiaryLocation;
	}
}// end Location