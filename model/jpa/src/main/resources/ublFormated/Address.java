package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define common information related to an address.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:12:37 a. m.
 */
public class Address{

	/**
	 * An additional street name used to further clarify the address.
	 */
	private NameType AdditionalStreetName;
	/**
	 * A mutually agreed code signifying the format of this address.
	 */
	private CodeType AddressFormatCode;
	/**
	 * A mutually agreed code signifying the type of this address.
	 */
	private CodeType AddressTypeCode;
	/**
	 * The name of the block (an area surrounded by streets and usually containing
	 * several buildings) in which this address is located.
	 */
	private NameType BlockName;
	/**
	 * The name of a building.
	 */
	private NameType BuildingName;
	/**
	 * The number of a building within the street.
	 */
	private TextType BuildingNumber;
	/**
	 * The name of a city, town, or village.
	 */
	private NameType CityName;
	/**
	 * The name of the subdivision of a city, town, or village in which this address
	 * is located, such as the name of its district or borough.
	 */
	private NameType CitySubdivisionName;
	/**
	 * The political or administrative division of a country in which this address is
	 * located, such as the name of its county, province, or state, expressed as text.
	 */
	private TextType CountrySubentity;
	/**
	 * The political or administrative division of a country in which this address is
	 * located, such as a county, province, or state, expressed as a code (typically
	 * nationally agreed).
	 */
	private CodeType CountrySubentityCode;
	/**
	 * The department of the addressee.
	 */
	private TextType Department;
	/**
	 * The district or geographical division of a country or region in which this
	 * address is located.
	 */
	private TextType District;
	/**
	 * An identifiable floor of a building.
	 */
	private TextType Floor;
	/**
	 * An identifier for this address within an agreed scheme of address identifiers.
	 */
	private IdentifierType ID;
	/**
	 * The specific identifable location within a building where mail is delivered.
	 */
	private TextType InhouseMail;
	/**
	 * The name, expressed as text, of a person or department in an organization to
	 * whose attention incoming mail is directed; corresponds to the printed forms
	 * "for the attention of", "FAO", and ATTN:".
	 */
	private TextType MarkAttention;
	/**
	 * The name, expressed as text, of a person or organization at this address into
	 * whose care incoming mail is entrusted; corresponds to the printed forms "care
	 * of" and "c/o".
	 */
	private TextType MarkCare;
	/**
	 * An identifier (e.g., a parcel number) for the piece of land associated with
	 * this address.
	 */
	private TextType PlotIdentification;
	/**
	 * The postal identifier for this address according to the relevant national
	 * postal service, such as a ZIP code or Post Code.
	 */
	private TextType PostalZone;
	/**
	 * A post office box number registered for postal delivery by a postal service
	 * provider.
	 */
	private TextType Postbox;
	/**
	 * The recognized geographic or economic region or group of countries in which
	 * this address is located.
	 */
	private TextType Region;
	/**
	 * An identifiable room, suite, or apartment of a building.
	 */
	private TextType Room;
	/**
	 * The name of the street, road, avenue, way, etc. to which the number of the
	 * building is attached.
	 */
	private NameType StreetName;
	/**
	 * The time zone in which this address is located (as an offset from Universal
	 * Coordinated Time (UTC)) at the time of exchange.
	 */
	private TextType TimezoneOffset;
	private List<AddressLine> AddressLines = new ArrayList<>();
	private List<Country> Countries = new ArrayList<>();
	private List<LocationCoordinate> LocationCoordinates = new ArrayList<>();

}
