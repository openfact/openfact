package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.IdentifierType;

public class AddressRepresentation {

    /**
     * An additional street name used to further clarify the address.
     */
    private String additionalStreetName;
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
    private CodeType countrySubentityCode;
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
    private IdentifierType ID;
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
    private List<AddressLineRepresentation> addressLines = new ArrayList<>();
    private List<CountryRepresentation> countries = new ArrayList<>();
    private List<LocationCoordinateRepresentation> locationCoordinates = new ArrayList<>();

    /**
     * @return the additionalStreetName
     */
    public String getAdditionalStreetName() {
        return additionalStreetName;
    }

    /**
     * @param additionalStreetName
     *            the additionalStreetName to set
     */
    public void setAdditionalStreetName(String additionalStreetName) {
        this.additionalStreetName = additionalStreetName;
    }

    /**
     * @return the addressFormatCode
     */
    public CodeType getAddressFormatCode() {
        return addressFormatCode;
    }

    /**
     * @param addressFormatCode
     *            the addressFormatCode to set
     */
    public void setAddressFormatCode(CodeType addressFormatCode) {
        this.addressFormatCode = addressFormatCode;
    }

    /**
     * @return the addressTypeCode
     */
    public CodeType getAddressTypeCode() {
        return addressTypeCode;
    }

    /**
     * @param addressTypeCode
     *            the addressTypeCode to set
     */
    public void setAddressTypeCode(CodeType addressTypeCode) {
        this.addressTypeCode = addressTypeCode;
    }

    /**
     * @return the blockName
     */
    public String getBlockName() {
        return blockName;
    }

    /**
     * @param blockName
     *            the blockName to set
     */
    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    /**
     * @return the buildingName
     */
    public String getBuildingName() {
        return buildingName;
    }

    /**
     * @param buildingName
     *            the buildingName to set
     */
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    /**
     * @return the buildingNumber
     */
    public String getBuildingNumber() {
        return buildingNumber;
    }

    /**
     * @param buildingNumber
     *            the buildingNumber to set
     */
    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    /**
     * @return the cityName
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @param cityName
     *            the cityName to set
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * @return the citySubdivisionName
     */
    public String getCitySubdivisionName() {
        return citySubdivisionName;
    }

    /**
     * @param citySubdivisionName
     *            the citySubdivisionName to set
     */
    public void setCitySubdivisionName(String citySubdivisionName) {
        this.citySubdivisionName = citySubdivisionName;
    }

    /**
     * @return the countrySubentity
     */
    public String getCountrySubentity() {
        return countrySubentity;
    }

    /**
     * @param countrySubentity
     *            the countrySubentity to set
     */
    public void setCountrySubentity(String countrySubentity) {
        this.countrySubentity = countrySubentity;
    }

    /**
     * @return the countrySubentityCode
     */
    public CodeType getCountrySubentityCode() {
        return countrySubentityCode;
    }

    /**
     * @param countrySubentityCode
     *            the countrySubentityCode to set
     */
    public void setCountrySubentityCode(CodeType countrySubentityCode) {
        this.countrySubentityCode = countrySubentityCode;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department
     *            the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return the district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param district
     *            the district to set
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * @return the floor
     */
    public String getFloor() {
        return floor;
    }

    /**
     * @param floor
     *            the floor to set
     */
    public void setFloor(String floor) {
        this.floor = floor;
    }

    /**
     * @return the iD
     */
    public IdentifierType getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(IdentifierType iD) {
        ID = iD;
    }

    /**
     * @return the inhouseMail
     */
    public String getInhouseMail() {
        return inhouseMail;
    }

    /**
     * @param inhouseMail
     *            the inhouseMail to set
     */
    public void setInhouseMail(String inhouseMail) {
        this.inhouseMail = inhouseMail;
    }

    /**
     * @return the markAttention
     */
    public String getMarkAttention() {
        return markAttention;
    }

    /**
     * @param markAttention
     *            the markAttention to set
     */
    public void setMarkAttention(String markAttention) {
        this.markAttention = markAttention;
    }

    /**
     * @return the markCare
     */
    public String getMarkCare() {
        return markCare;
    }

    /**
     * @param markCare
     *            the markCare to set
     */
    public void setMarkCare(String markCare) {
        this.markCare = markCare;
    }

    /**
     * @return the plotIdentification
     */
    public String getPlotIdentification() {
        return plotIdentification;
    }

    /**
     * @param plotIdentification
     *            the plotIdentification to set
     */
    public void setPlotIdentification(String plotIdentification) {
        this.plotIdentification = plotIdentification;
    }

    /**
     * @return the postalZone
     */
    public String getPostalZone() {
        return postalZone;
    }

    /**
     * @param postalZone
     *            the postalZone to set
     */
    public void setPostalZone(String postalZone) {
        this.postalZone = postalZone;
    }

    /**
     * @return the postbox
     */
    public String getPostbox() {
        return postbox;
    }

    /**
     * @param postbox
     *            the postbox to set
     */
    public void setPostbox(String postbox) {
        this.postbox = postbox;
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region
     *            the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return the room
     */
    public String getRoom() {
        return room;
    }

    /**
     * @param room
     *            the room to set
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * @return the streetName
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * @param streetName
     *            the streetName to set
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * @return the timezoneOffset
     */
    public String getTimezoneOffset() {
        return timezoneOffset;
    }

    /**
     * @param timezoneOffset
     *            the timezoneOffset to set
     */
    public void setTimezoneOffset(String timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
    }

    /**
     * @return the addressLines
     */
    public List<AddressLineRepresentation> getAddressLines() {
        return addressLines;
    }

    /**
     * @param addressLines
     *            the addressLines to set
     */
    public void setAddressLines(List<AddressLineRepresentation> addressLines) {
        this.addressLines = addressLines;
    }

    /**
     * @return the countries
     */
    public List<CountryRepresentation> getCountries() {
        return countries;
    }

    /**
     * @param countries
     *            the countries to set
     */
    public void setCountries(List<CountryRepresentation> countries) {
        this.countries = countries;
    }

    /**
     * @return the locationCoordinates
     */
    public List<LocationCoordinateRepresentation> getLocationCoordinates() {
        return locationCoordinates;
    }

    /**
     * @param locationCoordinates
     *            the locationCoordinates to set
     */
    public void setLocationCoordinates(List<LocationCoordinateRepresentation> locationCoordinates) {
        this.locationCoordinates = locationCoordinates;
    }

}
