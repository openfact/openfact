package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.CountryRepresentation;

public class AddressRepresentation {

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
     * An identifier for this address within an agreed scheme of address
     * identifiers.
     */
    private String ID;

    /**
     * The recognized geographic or economic region or group of countries in
     * which this address is located.
     */
    private String region;

    /**
     * The name of the street, road, avenue, way, etc. to which the number of
     * the building is attached.
     */
    private String streetName;

    private CountryRepresentation country;

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
    public String getCountrySubentityCode() {
        return countrySubentityCode;
    }

    /**
     * @param countrySubentityCode
     *            the countrySubentityCode to set
     */
    public void setCountrySubentityCode(String countrySubentityCode) {
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
     * @return the iD
     */
    public String getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(String iD) {
        ID = iD;
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
     * @return the country
     */
    public CountryRepresentation getCountry() {
        return country;
    }

    /**
     * @param country
     *            the country to set
     */
    public void setCountry(CountryRepresentation country) {
        this.country = country;
    }

}
