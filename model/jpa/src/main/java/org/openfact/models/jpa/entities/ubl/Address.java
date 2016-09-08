package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.NameType;
import org.openfact.models.jpa.entities.ublType.TextType;

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
	private NameType additionalStreetName;

	/**
	 * A mutually agreed code signifying the format of this address.
	 */
	private CodeType addressFormatCode;

	/**
	 * A mutually agreed code signifying the type of this address.
	 */
	private CodeType addressTypeCode;

	/**
	 * The name of the block (an area surrounded by streets and usually
	 * containing several buildings) in which this address is located.
	 */
	private NameType blockName;

	/**
	 * The name of a building.
	 */
	private NameType buildingName;

	/**
	 * The number of a building within the street.
	 */
	private TextType buildingNumber;

	/**
	 * The name of a city, town, or village.
	 */
	private NameType  cityName;

	/**
	 * The name of the subdivision of a city, town, or village in which this
	 * address is located, such as the name of its district or borough.
	 */
	private NameType  citySubdivisionName;

	/**
	 * The political or administrative division of a country in which this
	 * address is located, such as the name of its county, province, or state,
	 * expressed as text.
	 */
	private TextType  countrySubentity;

	/**
	 * The political or administrative division of a country in which this
	 * address is located, such as a county, province, or state, expressed as a
	 * code (typically nationally agreed).
	 */
	private CodeType countrySubentityCode;

	/**
	 * The department of the addressee.
	 */
	private TextType department;

	/**
	 * The district or geographical division of a country or region in which
	 * this address is located.
	 */
	private TextType district;

	/**
	 * An identifiable floor of a building.
	 */
	private TextType floor;

	/**
	 * An identifier for this address within an agreed scheme of address
	 * identifiers.
	 */
	private IdentifierType id;

	/**
	 * The specific identifable location within a building where mail is
	 * delivered.
	 */
	private TextType inhouseMail;

	/**
	 * The name, expressed as text, of a person or department in an organization
	 * to whose attention incoming mail is directed; corresponds to the printed
	 * forms "for the attention of", "FAO", and ATTN:".
	 */
	private TextType markAttention;

	/**
	 * The name, expressed as text, of a person or organization at this address
	 * into whose care incoming mail is entrusted; corresponds to the printed
	 * forms "care of" and "c/o".
	 */
	private TextType markCare;

	/**
	 * An identifier (e.g., a parcel number) for the piece of land associated
	 * with this address.
	 */
	private TextType plotIdentification;

	/**
	 * The postal identifier for this address according to the relevant national
	 * postal service, such as a ZIP code or Post Code.
	 */
	private TextType postalZone;

	/**
	 * A post office box number registered for postal delivery by a postal
	 * service provider.
	 */
	private TextType postbox;

	/**
	 * The recognized geographic or economic region or group of countries in
	 * which this address is located.
	 */
	private TextType region;

	/**
	 * An identifiable room, suite, or apartment of a building.
	 */
	private TextType room;

	/**
	 * The name of the street, road, avenue, way, etc. to which the number of
	 * the building is attached.
	 */
	private NameType streetName;

	/**
	 * The time zone in which this address is located (as an offset from
	 * Universal Coordinated Time (UTC)) at the time of exchange.
	 */
	private TextType timezoneOffset;
	private List<AddressLine> addressLines= new ArrayList<>();
	private List<Country> countries= new ArrayList<>();
	private List<LocationCoordinate> locationCoordinates= new ArrayList<>();

	public NameType getAdditionalStreetName() {
		return additionalStreetName;
	}

	public void setAdditionalStreetName(NameType additionalStreetName) {
		this.additionalStreetName = additionalStreetName;
	}

	public CodeType getAddressFormatCode() {
		return addressFormatCode;
	}

	public void setAddressFormatCode(CodeType addressFormatCode) {
		this.addressFormatCode = addressFormatCode;
	}

	public CodeType getAddressTypeCode() {
		return addressTypeCode;
	}

	public void setAddressTypeCode(CodeType addressTypeCode) {
		this.addressTypeCode = addressTypeCode;
	}

	public NameType getBlockName() {
		return blockName;
	}

	public void setBlockName(NameType blockName) {
		this.blockName = blockName;
	}

	public NameType getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(NameType buildingName) {
		this.buildingName = buildingName;
	}

	public TextType getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(TextType buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public NameType getCityName() {
		return cityName;
	}

	public void setCityName(NameType cityName) {
		this.cityName = cityName;
	}

	public NameType getCitySubdivisionName() {
		return citySubdivisionName;
	}

	public void setCitySubdivisionName(NameType citySubdivisionName) {
		this.citySubdivisionName = citySubdivisionName;
	}

	public TextType getCountrySubentity() {
		return countrySubentity;
	}

	public void setCountrySubentity(TextType countrySubentity) {
		this.countrySubentity = countrySubentity;
	}

	public CodeType getCountrySubentityCode() {
		return countrySubentityCode;
	}

	public void setCountrySubentityCode(CodeType countrySubentityCode) {
		this.countrySubentityCode = countrySubentityCode;
	}

	public TextType getDepartment() {
		return department;
	}

	public void setDepartment(TextType department) {
		this.department = department;
	}

	public TextType getDistrict() {
		return district;
	}

	public void setDistrict(TextType district) {
		this.district = district;
	}

	public TextType getFloor() {
		return floor;
	}

	public void setFloor(TextType floor) {
		this.floor = floor;
	}

	public IdentifierType getId() {
		return id;
	}

	public void setId(IdentifierType id) {
		this.id = id;
	}

	public TextType getInhouseMail() {
		return inhouseMail;
	}

	public void setInhouseMail(TextType inhouseMail) {
		this.inhouseMail = inhouseMail;
	}

	public TextType getMarkAttention() {
		return markAttention;
	}

	public void setMarkAttention(TextType markAttention) {
		this.markAttention = markAttention;
	}

	public TextType getMarkCare() {
		return markCare;
	}

	public void setMarkCare(TextType markCare) {
		this.markCare = markCare;
	}

	public TextType getPlotIdentification() {
		return plotIdentification;
	}

	public void setPlotIdentification(TextType plotIdentification) {
		this.plotIdentification = plotIdentification;
	}

	public TextType getPostalZone() {
		return postalZone;
	}

	public void setPostalZone(TextType postalZone) {
		this.postalZone = postalZone;
	}

	public TextType getPostbox() {
		return postbox;
	}

	public void setPostbox(TextType postbox) {
		this.postbox = postbox;
	}

	public TextType getRegion() {
		return region;
	}

	public void setRegion(TextType region) {
		this.region = region;
	}

	public TextType getRoom() {
		return room;
	}

	public void setRoom(TextType room) {
		this.room = room;
	}

	public NameType getStreetName() {
		return streetName;
	}

	public void setStreetName(NameType streetName) {
		this.streetName = streetName;
	}

	public TextType getTimezoneOffset() {
		return timezoneOffset;
	}

	public void setTimezoneOffset(TextType timezoneOffset) {
		this.timezoneOffset = timezoneOffset;
	}

	public List<AddressLine> getAddressLines() {
		return addressLines;
	}

	public void setAddressLines(List<AddressLine> addressLines) {
		this.addressLines = addressLines;
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
		this.locationCoordinates = locationCoordinates;
	}
}