package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to define common information related to an address.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:12:37 a. m.
 */
public class Address {

	/**
	 * An additional street name used to further clarify the address.
	 */
	private String additionalStreetName;

	/**
	 * A mutually agreed code signifying the format of this address.
	 */
	private String addressFormatCode;

	/**
	 * A mutually agreed code signifying the type of this address.
	 */
	private String addressTypeCode;

	/**
	 * The name of the block (an area surrounded by streets and usually
	 * containing several buildings) in which this address is located.
	 */
	private String blockName;

	/**
	 * The name of a building.
	 */
	private String buildingName;

	/**
	 * The number of a building within the street.
	 */
	private String buildingNumber;

	/**
	 * The name of a city, town, or village.
	 */
	private String cityName;

	/**
	 * The name of the subdivision of a city, town, or village in which this
	 * address is located, such as the name of its district or borough.
	 */
	private String citySubdivisionName;

	/**
	 * The political or administrative division of a country in which this
	 * address is located, such as the name of its county, province, or state,
	 * expressed as text.
	 */
	private String countrySubentity;

	/**
	 * The political or administrative division of a country in which this
	 * address is located, such as a county, province, or state, expressed as a
	 * code (typically nationally agreed).
	 */
	private String countrySubentityCode;

	/**
	 * The department of the addressee.
	 */
	private String department;

	/**
	 * The district or geographical division of a country or region in which
	 * this address is located.
	 */
	private String district;

	/**
	 * An identifiable floor of a building.
	 */
	private String floor;

	/**
	 * An identifier for this address within an agreed scheme of address
	 * identifiers.
	 */
	private String id;

	/**
	 * The specific identifable location within a building where mail is
	 * delivered.
	 */
	private String inhouseMail;

	/**
	 * The name, expressed as text, of a person or department in an organization
	 * to whose attention incoming mail is directed; corresponds to the printed
	 * forms "for the attention of", "FAO", and ATTN:".
	 */
	private String markAttention;

	/**
	 * The name, expressed as text, of a person or organization at this address
	 * into whose care incoming mail is entrusted; corresponds to the printed
	 * forms "care of" and "c/o".
	 */
	private String markCare;

	/**
	 * An identifier (e.g., a parcel number) for the piece of land associated
	 * with this address.
	 */
	private String plotIdentification;

	/**
	 * The postal identifier for this address according to the relevant national
	 * postal service, such as a ZIP code or Post Code.
	 */
	private String postalZone;

	/**
	 * A post office box number registered for postal delivery by a postal
	 * service provider.
	 */
	private String postbox;

	/**
	 * The recognized geographic or economic region or group of countries in
	 * which this address is located.
	 */
	private String region;

	/**
	 * An identifiable room, suite, or apartment of a building.
	 */
	private String room;

	/**
	 * The name of the street, road, avenue, way, etc. to which the number of
	 * the building is attached.
	 */
	private String streetName;

	/**
	 * The time zone in which this address is located (as an offset from
	 * Universal Coordinated Time (UTC)) at the time of exchange.
	 */
	private String timezoneOffset;
	private List<AddressLine> addressLines= new ArrayList<>();
	private List<Country> countries= new ArrayList<>();
	private List<LocationCoordinate> locationCoordinates= new ArrayList<>();

	public String getAdditionalStreetName() {
		return additionalStreetName;
	}

	public void setAdditionalStreetName(String additionalStreetName) {
		this.additionalStreetName = additionalStreetName;
	}

	public String getAddressFormatCode() {
		return addressFormatCode;
	}

	public void setAddressFormatCode(String addressFormatCode) {
		this.addressFormatCode = addressFormatCode;
	}

	public String getAddressTypeCode() {
		return addressTypeCode;
	}

	public void setAddressTypeCode(String addressTypeCode) {
		this.addressTypeCode = addressTypeCode;
	}

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCitySubdivisionName() {
		return citySubdivisionName;
	}

	public void setCitySubdivisionName(String citySubdivisionName) {
		this.citySubdivisionName = citySubdivisionName;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInhouseMail() {
		return inhouseMail;
	}

	public void setInhouseMail(String inhouseMail) {
		this.inhouseMail = inhouseMail;
	}

	public String getMarkAttention() {
		return markAttention;
	}

	public void setMarkAttention(String markAttention) {
		this.markAttention = markAttention;
	}

	public String getMarkCare() {
		return markCare;
	}

	public void setMarkCare(String markCare) {
		this.markCare = markCare;
	}

	public String getPlotIdentification() {
		return plotIdentification;
	}

	public void setPlotIdentification(String plotIdentification) {
		this.plotIdentification = plotIdentification;
	}

	public String getPostalZone() {
		return postalZone;
	}

	public void setPostalZone(String postalZone) {
		this.postalZone = postalZone;
	}

	public String getPostbox() {
		return postbox;
	}

	public void setPostbox(String postbox) {
		this.postbox = postbox;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getTimezoneOffset() {
		return timezoneOffset;
	}

	public void setTimezoneOffset(String timezoneOffset) {
		this.timezoneOffset = timezoneOffset;
	}

	public List<AddressLine> getAddressLines() {
		return addressLines;
	}

	public void setAddressLines(List<AddressLine> addressLines) {
		addressLines = addressLines;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public List<LocationCoordinate> getLocationCoordinates() {
		return locationCoordinates;
	}

	public void setLocationCoordinates(List<LocationCoordinate> locationCoordinates) {
		locationCoordinates = locationCoordinates;
	}
}