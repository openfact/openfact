package org.openfact.models.jpa.entities.ubl2;


/**
 * A class to define common information related to an address.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:12:37 a. m.
 */
public class Address {

	/**
	 * An additional street name used to further clarify the address.
	 */
	private Name. Type AdditionalStreetName;
	/**
	 * A mutually agreed code signifying the format of this address.
	 */
	private Code. Type AddressFormatCode;
	/**
	 * A mutually agreed code signifying the type of this address.
	 */
	private Code. Type AddressTypeCode;
	/**
	 * The name of the block (an area surrounded by streets and usually containing
	 * several buildings) in which this address is located.
	 */
	private Name. Type BlockName;
	/**
	 * The name of a building.
	 */
	private Name. Type BuildingName;
	/**
	 * The number of a building within the street.
	 */
	private Text. Type BuildingNumber;
	/**
	 * The name of a city, town, or village.
	 */
	private Name. Type CityName;
	/**
	 * The name of the subdivision of a city, town, or village in which this address
	 * is located, such as the name of its district or borough.
	 */
	private Name. Type CitySubdivisionName;
	/**
	 * The political or administrative division of a country in which this address is
	 * located, such as the name of its county, province, or state, expressed as text.
	 */
	private Text. Type CountrySubentity;
	/**
	 * The political or administrative division of a country in which this address is
	 * located, such as a county, province, or state, expressed as a code (typically
	 * nationally agreed).
	 */
	private Code. Type CountrySubentityCode;
	/**
	 * The department of the addressee.
	 */
	private Text. Type Department;
	/**
	 * The district or geographical division of a country or region in which this
	 * address is located.
	 */
	private Text. Type District;
	/**
	 * An identifiable floor of a building.
	 */
	private Text. Type Floor;
	/**
	 * An identifier for this address within an agreed scheme of address identifiers.
	 */
	private Identifier. Type ID;
	/**
	 * The specific identifable location within a building where mail is delivered.
	 */
	private Text. Type InhouseMail;
	/**
	 * The name, expressed as text, of a person or department in an organization to
	 * whose attention incoming mail is directed; corresponds to the printed forms
	 * "for the attention of", "FAO", and ATTN:".
	 */
	private Text. Type MarkAttention;
	/**
	 * The name, expressed as text, of a person or organization at this address into
	 * whose care incoming mail is entrusted; corresponds to the printed forms "care
	 * of" and "c/o".
	 */
	private Text. Type MarkCare;
	/**
	 * An identifier (e.g., a parcel number) for the piece of land associated with
	 * this address.
	 */
	private Text. Type PlotIdentification;
	/**
	 * The postal identifier for this address according to the relevant national
	 * postal service, such as a ZIP code or Post Code.
	 */
	private Text. Type PostalZone;
	/**
	 * A post office box number registered for postal delivery by a postal service
	 * provider.
	 */
	private Text. Type Postbox;
	/**
	 * The recognized geographic or economic region or group of countries in which
	 * this address is located.
	 */
	private Text. Type Region;
	/**
	 * An identifiable room, suite, or apartment of a building.
	 */
	private Text. Type Room;
	/**
	 * The name of the street, road, avenue, way, etc. to which the number of the
	 * building is attached.
	 */
	private Name. Type StreetName;
	/**
	 * The time zone in which this address is located (as an offset from Universal
	 * Coordinated Time (UTC)) at the time of exchange.
	 */
	private Text. Type TimezoneOffset;
	private Address Line m_Address Line;
	private Country m_Country;
	private Location Coordinate m_Location Coordinate;

	public Address(){

	}

	public void finalize() throws Throwable {

	}
	public Name. Type getAdditionalStreetName(){
		return AdditionalStreetName;
	}

	public Address Line getAddress Line(){
		return m_Address Line;
	}

	public Code. Type getAddressFormatCode(){
		return AddressFormatCode;
	}

	public Code. Type getAddressTypeCode(){
		return AddressTypeCode;
	}

	public Name. Type getBlockName(){
		return BlockName;
	}

	public Name. Type getBuildingName(){
		return BuildingName;
	}

	public Text. Type getBuildingNumber(){
		return BuildingNumber;
	}

	public Name. Type getCityName(){
		return CityName;
	}

	public Name. Type getCitySubdivisionName(){
		return CitySubdivisionName;
	}

	public Country getCountry(){
		return m_Country;
	}

	public Text. Type getCountrySubentity(){
		return CountrySubentity;
	}

	public Code. Type getCountrySubentityCode(){
		return CountrySubentityCode;
	}

	public Text. Type getDepartment(){
		return Department;
	}

	public Text. Type getDistrict(){
		return District;
	}

	public Text. Type getFloor(){
		return Floor;
	}

	public Identifier. Type getID(){
		return ID;
	}

	public Text. Type getInhouseMail(){
		return InhouseMail;
	}

	public Location Coordinate getLocation Coordinate(){
		return m_Location Coordinate;
	}

	public Text. Type getMarkAttention(){
		return MarkAttention;
	}

	public Text. Type getMarkCare(){
		return MarkCare;
	}

	public Text. Type getPlotIdentification(){
		return PlotIdentification;
	}

	public Text. Type getPostalZone(){
		return PostalZone;
	}

	public Text. Type getPostbox(){
		return Postbox;
	}

	public Text. Type getRegion(){
		return Region;
	}

	public Text. Type getRoom(){
		return Room;
	}

	public Name. Type getStreetName(){
		return StreetName;
	}

	public Text. Type getTimezoneOffset(){
		return TimezoneOffset;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAdditionalStreetName(Name. Type newVal){
		AdditionalStreetName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAddress Line(Address Line newVal){
		m_Address Line = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAddressFormatCode(Code. Type newVal){
		AddressFormatCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAddressTypeCode(Code. Type newVal){
		AddressTypeCode = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBlockName(Name. Type newVal){
		BlockName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBuildingName(Name. Type newVal){
		BuildingName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBuildingNumber(Text. Type newVal){
		BuildingNumber = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCityName(Name. Type newVal){
		CityName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCitySubdivisionName(Name. Type newVal){
		CitySubdivisionName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCountry(Country newVal){
		m_Country = newVal;
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
	public void setDepartment(Text. Type newVal){
		Department = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setDistrict(Text. Type newVal){
		District = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFloor(Text. Type newVal){
		Floor = newVal;
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
	public void setInhouseMail(Text. Type newVal){
		InhouseMail = newVal;
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
	public void setMarkAttention(Text. Type newVal){
		MarkAttention = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setMarkCare(Text. Type newVal){
		MarkCare = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPlotIdentification(Text. Type newVal){
		PlotIdentification = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPostalZone(Text. Type newVal){
		PostalZone = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPostbox(Text. Type newVal){
		Postbox = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRegion(Text. Type newVal){
		Region = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setRoom(Text. Type newVal){
		Room = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setStreetName(Name. Type newVal){
		StreetName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setTimezoneOffset(Text. Type newVal){
		TimezoneOffset = newVal;
	}
}//end Address