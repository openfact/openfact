package org.openfact.models.jpa.entities.ubl;

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
    private String Conditions;
    /**
     * A territorial division of a country, such as a county or state, expressed
     * as text.
     */
    private String CountrySubentity;
    /**
     * A territorial division of a country, such as a county or state, expressed
     * as a code.
     */
    private String CountrySubentityCode;
    /**
     * Text describing this location.
     */
    private String Description;
    /**
     * An identifier for this location, e.g., the EAN Location Number, GLN.
     */
    private String ID;
    /**
     * The Uniform Resource Identifier (URI) of a document providing information
     * about this location.
     */
    private String InformationURIID;
    /**
     * A code signifying the type of location.
     */
    private String LocationTypeCode;
    /**
     * The name of this location.
     */
    private String Name;
    private Address m_Address;
    private Period Validity Period;
    private Location Coordinate
    m_Location Coordinate;
    private Location Subsidiary Location;

    public Location() {

    }

    public void finalize() throws Throwable {

    }

    public Address getAddress() {
        return m_Address;
    }

    public String getConditions() {
        return Conditions;
    }

    public String getCountrySubentity() {
        return CountrySubentity;
    }

    public String getCountrySubentityCode() {
        return CountrySubentityCode;
    }

    public String getDescription() {
        return Description;
    }

    public String getID() {
        return ID;
    }

    public String getInformationURIID() {
        return InformationURIID;
    }

    public Location Coordinate

    getLocation Coordinate(){
		return m_Location Coordinate;
	}

    public String getLocationTypeCode() {
        return LocationTypeCode;
    }

    public String getName() {
        return Name;
    }

    public Location getSubsidiary

    Location(){
		return Subsidiary Location;
	}

    public Period getValidity

    Period(){
		return Validity Period;
	}

    /**
     * 
     * @param newVal
     */
    public void setAddress(Address newVal) {
        m_Address = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setConditions(String newVal) {
        Conditions = newVal;
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
    public void setDescription(String newVal) {
        Description = newVal;
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
    public void setInformationURIID(String newVal) {
        InformationURIID = newVal;
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
    public void setLocationTypeCode(String newVal) {
        LocationTypeCode = newVal;
    }

    /**
     * 
     * @param newVal
     */
    public void setName(String newVal) {
        Name = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setSubsidiary

    Location(Location newVal) {
        Subsidiary Location = newVal;
    }

    /**
	 * 
	 * @param newVal
	 */
	public void setValidity

    Period(Period newVal){
		Validity Period = newVal;
	}
}// end Location