

/**
 * A class to describe a location.
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:00 a. m.
 */
public class Location {

	/**
	 * Free-form text describing the physical conditions of the location.
	 */
	private Text. Type Conditions;
	/**
	 * A territorial division of a country, such as a county or state, expressed as
	 * text.
	 */
	private Text. Type CountrySubentity;
	/**
	 * A territorial division of a country, such as a county or state, expressed as a
	 * code.
	 */
	private Code. Type CountrySubentityCode;
	/**
	 * Text describing this location.
	 */
	private Text. Type Description;
	/**
	 * An identifier for this location, e.g., the EAN Location Number, GLN.
	 */
	private Identifier. Type ID;
	/**
	 * The Uniform Resource Identifier (URI) of a document providing information about
	 * this location.
	 */
	private Identifier. Type InformationURIID;
	/**
	 * A code signifying the type of location.
	 */
	private Code. Type LocationTypeCode;
	/**
	 * The name of this location.
	 */
	private Name. Type Name;
	private Address m_Address;
	private Period Validity Period;
	private Location Coordinate m_Location Coordinate;
	private Location Subsidiary Location;

	public Location(){

	}

	public void finalize() throws Throwable {

	}
	public Address getAddress(){
		return m_Address;
	}

	public Text. Type getConditions(){
		return Conditions;
	}

	public Text. Type getCountrySubentity(){
		return CountrySubentity;
	}

	public Code. Type getCountrySubentityCode(){
		return CountrySubentityCode;
	}

	public Text. Type getDescription(){
		return Description;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Identifier. Type getInformationURIID(){
		return InformationURIID;
	}

	public Location Coordinate getLocation Coordinate(){
		return m_Location Coordinate;
	}

	public Code. Type getLocationTypeCode(){
		return LocationTypeCode;
	}

	public Name. Type getName(){
		return Name;
	}

	public Location getSubsidiary Location(){
		return Subsidiary Location;
	}

	public Period getValidity Period(){
		return Validity Period;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAddress(Address newVal){
		m_Address = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setConditions(Text. Type newVal){
		Conditions = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCountrySubentity(Text. Type newVal){
		CountrySubentity = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCountrySubentityCode(Code. Type newVal){
		CountrySubentityCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDescription(Text. Type newVal){
		Description = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setID(Identifier. Type newVal){
		ID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInformationURIID(Identifier. Type newVal){
		InformationURIID = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLocation Coordinate(Location Coordinate newVal){
		m_Location Coordinate = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLocationTypeCode(Code. Type newVal){
		LocationTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setName(Name. Type newVal){
		Name = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSubsidiary Location(Location newVal){
		Subsidiary Location = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setValidity Period(Period newVal){
		Validity Period = newVal;
	}
}//end Location