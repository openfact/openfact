package org.openfact.models.jpa.entities.ubl;

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
    private String AdditionalStreetName;
    /**
     * A mutually agreed code signifying the format of this address.
     */
    private String AddressFormatCode;
    /**
     * A mutually agreed code signifying the type of this address.
     */
    private String AddressTypeCode;
    /**
     * The name of the block (an area surrounded by streets and usually
     * containing several buildings) in which this address is located.
     */
    private String BlockName;
    /**
     * The name of a building.
     */
    private String BuildingName;
    /**
     * The number of a building within the street.
     */
    private String BuildingNumber;
    /**
     * The name of a city, town, or village.
     */
    private String CityName;
    /**
     * The name of the subdivision of a city, town, or village in which this
     * address is located, such as the name of its district or borough.
     */
    private String CitySubdivisionName;
    /**
     * The political or administrative division of a country in which this
     * address is located, such as the name of its county, province, or state,
     * expressed as text.
     */
    private String CountrySubentity;
    /**
     * The political or administrative division of a country in which this
     * address is located, such as a county, province, or state, expressed as a
     * code (typically nationally agreed).
     */
    private String CountrySubentityCode;
    /**
     * The department of the addressee.
     */
    private String Department;
    /**
     * The district or geographical division of a country or region in which
     * this address is located.
     */
    private String District;
    /**
     * An identifiable floor of a building.
     */
    private String Floor;
    /**
     * An identifier for this address within an agreed scheme of address
     * identifiers.
     */
    private String ID;
    /**
     * The specific identifable location within a building where mail is
     * delivered.
     */
    private String InhouseMail;
    /**
     * The name, expressed as text, of a person or department in an organization
     * to whose attention incoming mail is directed; corresponds to the printed
     * forms "for the attention of", "FAO", and ATTN:".
     */
    private String MarkAttention;
    /**
     * The name, expressed as text, of a person or organization at this address
     * into whose care incoming mail is entrusted; corresponds to the printed
     * forms "care of" and "c/o".
     */
    private String MarkCare;
    /**
     * An identifier (e.g., a parcel number) for the piece of land associated
     * with this address.
     */
    private String PlotIdentification;
    /**
     * The postal identifier for this address according to the relevant national
     * postal service, such as a ZIP code or Post Code.
     */
    private String PostalZone;
    /**
     * A post office box number registered for postal delivery by a postal
     * service provider.
     */
    private String Postbox;
    /**
     * The recognized geographic or economic region or group of countries in
     * which this address is located.
     */
    private String Region;
    /**
     * An identifiable room, suite, or apartment of a building.
     */
    private String Room;
    /**
     * The name of the street, road, avenue, way, etc. to which the number of
     * the building is attached.
     */
    private String StreetName;
    /**
     * The time zone in which this address is located (as an offset from
     * Universal Coordinated Time (UTC)) at the time of exchange.
     */
    private String TimezoneOffset;
    private Address Line
    m_Address Line;
    private Country m_Country;
    private Location Coordinate
    m_Location Coordinate;

    public Address() {

    }

    public void finalize() throws Throwable {

    }

    public String getAdditionalStreetName() {
        return AdditionalStreetName;
    }

    public Address Line

    getAddress Line(){
		return m_Address Line;
	}

    public String getAddressFormatCode() {
        return AddressFormatCode;
    }

    public String getAddressTypeCode() {
        return AddressTypeCode;
    }

    public String getBlockName() {
        return BlockName;
    }

    public String getBuildingName() {
        return BuildingName;
    }

    public String getBuildingNumber() {
        return BuildingNumber;
    }

    public String getCityName() {
        return CityName;
    }

    public String getCitySubdivisionName() {
        return CitySubdivisionName;
    }

    public Country getCountry() {
        return m_Country;
    }

    public String getCountrySubentity() {
        return CountrySubentity;
    }

    public String getCountrySubentityCode() {
        return CountrySubentityCode;
    }

    public String getDepartment() {
        return Department;
    }

    public String getDistrict() {
        return District;
    }

    public String getFloor() {
        return Floor;
    }

    public String getID() {
        return ID;
    }

    public String getInhouseMail() {
        return InhouseMail;
    }

    public Location Coordinate

    getLocation Coordinate(){
		return m_Location Coordinate;
	}

    public String getMarkAttention() {
        return MarkAttention;
    }

    public String getMarkCare() {
        return MarkCare;
    }

    public String getPlotIdentification() {
        return PlotIdentification;
    }

    public String getPostalZone() {
        return PostalZone;
    }

    public String getPostbox() {
        return Postbox;
    }

    public String getRegion() {
        return Region;
    }

    public String getRoom() {
        return Room;
    }

    public String getStreetName() {
        return StreetName;
    }

    public String getTimezoneOffset() {
        return TimezoneOffset;
    }

    /**
     * 
     * @param newVal
     */
    public void setAdditionalStreetName(String newVal) {
        AdditionalStreetName = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setAddress

    Line(Address Line newVal){
		m_Address Line = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setAddressFormatCode(String newVal) {
        AddressFormatCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setAddressTypeCode(String newVal) {
        AddressTypeCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setBlockName(String newVal) {
        BlockName = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setBuildingName(String newVal) {
        BuildingName = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setBuildingNumber(String newVal) {
        BuildingNumber = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setCityName(String newVal) {
        CityName = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setCitySubdivisionName(String newVal) {
        CitySubdivisionName = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setCountry(Country newVal) {
        m_Country = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setCountrySubentity(String newVal) {
        CountrySubentity = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setCountrySubentityCode(String newVal) {
        CountrySubentityCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDepartment(String newVal) {
        Department = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setDistrict(String newVal) {
        District = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setFloor(String newVal) {
        Floor = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setID(String newVal) {
        ID = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setInhouseMail(String newVal) {
        InhouseMail = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setLocation

    Coordinate(Location Coordinate newVal){
		m_Location Coordinate = newVal;
	}

    /**
     * 
     * @param newVal
     */
    public void setMarkAttention(String newVal) {
        MarkAttention = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setMarkCare(String newVal) {
        MarkCare = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPlotIdentification(String newVal) {
        PlotIdentification = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPostalZone(String newVal) {
        PostalZone = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setPostbox(String newVal) {
        Postbox = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setRegion(String newVal) {
        Region = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setRoom(String newVal) {
        Room = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setStreetName(String newVal) {
        StreetName = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setTimezoneOffset(String newVal) {
        TimezoneOffset = newVal;
    }
}// end Address