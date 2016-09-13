package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.NameType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to define common information related to an address.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:12:37 a. m.
 */
@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
	/**
	 * An additional street name used to further clarify the address.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ADDITIONALSTREETNAME_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "ADDITIONALSTREETNAME_LANGUAGE")) })
	private NameType additionalStreetName;
	/**
	 * A mutually agreed code signifying the format of this address.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ADDRESSFORMATCODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "ADDRESSFORMATCODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "ADDRESSFORMATCODE_AGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "ADDRESSFORMATCODE_AGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "ADDRESSFORMATCODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "ADDRESSFORMATCODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "ADDRESSFORMATCODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "ADDRESSFORMATCODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "ADDRESSFORMATCODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "ADDRESSFORMATCODE_SCHEMEURI")) })
	private CodeType addressFormatCode;
	/**
	 * A mutually agreed code signifying the type of this address.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ADDRESSTYPECODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "ADDRESSTYPECODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "ADDRESSTYPECODE_AGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "ADDRESSTYPECODE_AGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "ADDRESSTYPECODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "ADDRESSTYPECODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "ADDRESSTYPECODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "ADDRESSTYPECODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "ADDRESSTYPECODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "ADDRESSTYPECODE_SCHEMEURI")) })
	private CodeType addressTypeCode;
	/**
	 * The name of the block (an area surrounded by streets and usually
	 * containing several buildings) in which this address is located.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "BLOCKNAME_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "BLOCKNAME_LANGUAGE")) })
	private NameType blockName;
	/**
	 * The name of a building.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "BUILDINGNAME_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "BUILDINGNAME_LANGUAGE")) })
	private NameType buildingName;
	/**
	 * The number of a building within the street.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "BUILDINGNUMBER_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "BUILDINGNUMBER_LANGUAGE")) })
	private TextType buildingNumber;
	/**
	 * The name of a city, town, or village.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "CITYNAME_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "CITYNAME_LANGUAGE")) })
	private NameType cityName;
	/**
	 * The name of the subdivision of a city, town, or village in which this
	 * address is located, such as the name of its district or borough.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "CITYSUBDIVISIONNAME_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "CITYSUBDIVISIONNAME_LANGUAGE")) })
	private NameType citySubdivisionName;
	/**
	 * The political or administrative division of a country in which this
	 * address is located, such as the name of its county, province, or state,
	 * expressed as text.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "COUNTRYSUBENTITY_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "COUNTRYSUBENTITY_LANGUAGE")) })
	private TextType countrySubentity;
	/**
	 * The political or administrative division of a country in which this
	 * address is located, such as a county, province, or state, expressed as a
	 * code (typically nationally agreed).
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "COUNTRYSUBENTITYCODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "COUNTRYSUBENTITYCODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "COUNTRYSUBENTITYCODE_AGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "COUNTRYSUBENTITYCODE_AGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "COUNTRYSUBENTITYCODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "COUNTRYSUBENTITYCODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "COUNTRYSUBENTITYCODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "COUNTRYSUBENTITYCODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "COUNTRYSUBENTITYCODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "COUNTRYSUBENTITYCODE_SCHEMEURI")) })
	private CodeType countrySubentityCode;
	/**
	 * The department of the addressee.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "DEPARTAMENT_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "DEPARTAMENT_LANGUAGE")) })
	private TextType department;
	/**
	 * The district or geographical division of a country or region in which
	 * this address is located.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "DISTRICT_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "DISTRICT_LANGUAGE")) })
	private TextType district;
	/**
	 * An identifiable floor of a building.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "FLOOR_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "FLOOR_LANGUAGE")) })
	private TextType floor;
	/**
	 * An identifier for this address within an agreed scheme of address
	 * identifiers.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "ID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "ID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "ID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "ID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "ID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "ID_SCHEMEDATEURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "ID_SCHEMEURI")) })
	private IdentifierType ID;
	/**
	 * The specific identifable location within a building where mail is
	 * delivered.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "INHOUSEMAIL_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "INHOUSEMAIL_LANGUAGE")) })
	private TextType inhouseMail;
	/**
	 * The name, expressed as text, of a person or department in an organization
	 * to whose attention incoming mail is directed; corresponds to the printed
	 * forms "for the attention of", "FAO", and ATTN:".
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "MARKATTENTION_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "MARKATTENTION_LANGUAGE")) })
	private TextType markAttention;
	/**
	 * The name, expressed as text, of a person or organization at this address
	 * into whose care incoming mail is entrusted; corresponds to the printed
	 * forms "care of" and "c/o".
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "MARKCARE_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "MARKCARE_LANGUAGE")) })
	private TextType markCare;
	/**
	 * An identifier (e.g., a parcel number) for the piece of land associated
	 * with this address.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "PLOTIDENTIFICATION_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "PLOTIDENTIFICATION_LANGUAGE")) })
	private TextType plotIdentification;
	/**
	 * The postal identifier for this address according to the relevant national
	 * postal service, such as a ZIP code or Post Code.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "POSTALZONE_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "POSTALZONE_LANGUAGE")) })
	private TextType postalZone;
	/**
	 * A post office box number registered for postal delivery by a postal
	 * service provider.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "POSTBOX_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "POSTBOX_LANGUAGE")) })
	private TextType postbox;
	/**
	 * The recognized geographic or economic region or group of countries in
	 * which this address is located.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "REGION_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "REGION_LANGUAGE")) })
	private TextType region;
	/**
	 * An identifiable room, suite, or apartment of a building.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ROOM_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "ROOM_LANGUAGE")) })
	private TextType room;
	/**
	 * The name of the street, road, avenue, way, etc. to which the number of
	 * the building is attached.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "STREETNAME_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "STREETNAME_LANGUAGE")) })
	private NameType streetName;
	/**
	 * The time zone in which this address is located (as an offset from
	 * Universal Coordinated Time (UTC)) at the time of exchange.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "TIMEZONEOFFSET_VALUE")),
			@AttributeOverride(name = "languageID", column = @Column(name = "TIMEZONEOFFSET_LANGUAGE")) })
	private TextType timezoneOffset;

	@Transient
	private List<AddressLineEntity> addressLines = new ArrayList<>();

	@OneToMany(mappedBy = "address", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<CountryEntity> countries = new ArrayList<>();

	@Transient
	private List<LocationCoordinateEntity> locationCoordinates = new ArrayList<>();

	@MapsId
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARTY_ID")
	private PartyEntity party;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the additionalStreetName
	 */
	public NameType getAdditionalStreetName() {
		return additionalStreetName;
	}

	/**
	 * @param additionalStreetName
	 *            the additionalStreetName to set
	 */
	public void setAdditionalStreetName(NameType additionalStreetName) {
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
	public NameType getBlockName() {
		return blockName;
	}

	/**
	 * @param blockName
	 *            the blockName to set
	 */
	public void setBlockName(NameType blockName) {
		this.blockName = blockName;
	}

	/**
	 * @return the buildingName
	 */
	public NameType getBuildingName() {
		return buildingName;
	}

	/**
	 * @param buildingName
	 *            the buildingName to set
	 */
	public void setBuildingName(NameType buildingName) {
		this.buildingName = buildingName;
	}

	/**
	 * @return the buildingNumber
	 */
	public TextType getBuildingNumber() {
		return buildingNumber;
	}

	/**
	 * @param buildingNumber
	 *            the buildingNumber to set
	 */
	public void setBuildingNumber(TextType buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	/**
	 * @return the cityName
	 */
	public NameType getCityName() {
		return cityName;
	}

	/**
	 * @param cityName
	 *            the cityName to set
	 */
	public void setCityName(NameType cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return the citySubdivisionName
	 */
	public NameType getCitySubdivisionName() {
		return citySubdivisionName;
	}

	/**
	 * @param citySubdivisionName
	 *            the citySubdivisionName to set
	 */
	public void setCitySubdivisionName(NameType citySubdivisionName) {
		this.citySubdivisionName = citySubdivisionName;
	}

	/**
	 * @return the countrySubentity
	 */
	public TextType getCountrySubentity() {
		return countrySubentity;
	}

	/**
	 * @param countrySubentity
	 *            the countrySubentity to set
	 */
	public void setCountrySubentity(TextType countrySubentity) {
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
	public TextType getDepartment() {
		return department;
	}

	/**
	 * @param department
	 *            the department to set
	 */
	public void setDepartment(TextType department) {
		this.department = department;
	}

	/**
	 * @return the district
	 */
	public TextType getDistrict() {
		return district;
	}

	/**
	 * @param district
	 *            the district to set
	 */
	public void setDistrict(TextType district) {
		this.district = district;
	}

	/**
	 * @return the floor
	 */
	public TextType getFloor() {
		return floor;
	}

	/**
	 * @param floor
	 *            the floor to set
	 */
	public void setFloor(TextType floor) {
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
	public TextType getInhouseMail() {
		return inhouseMail;
	}

	/**
	 * @param inhouseMail
	 *            the inhouseMail to set
	 */
	public void setInhouseMail(TextType inhouseMail) {
		this.inhouseMail = inhouseMail;
	}

	/**
	 * @return the markAttention
	 */
	public TextType getMarkAttention() {
		return markAttention;
	}

	/**
	 * @param markAttention
	 *            the markAttention to set
	 */
	public void setMarkAttention(TextType markAttention) {
		this.markAttention = markAttention;
	}

	/**
	 * @return the markCare
	 */
	public TextType getMarkCare() {
		return markCare;
	}

	/**
	 * @param markCare
	 *            the markCare to set
	 */
	public void setMarkCare(TextType markCare) {
		this.markCare = markCare;
	}

	/**
	 * @return the plotIdentification
	 */
	public TextType getPlotIdentification() {
		return plotIdentification;
	}

	/**
	 * @param plotIdentification
	 *            the plotIdentification to set
	 */
	public void setPlotIdentification(TextType plotIdentification) {
		this.plotIdentification = plotIdentification;
	}

	/**
	 * @return the postalZone
	 */
	public TextType getPostalZone() {
		return postalZone;
	}

	/**
	 * @param postalZone
	 *            the postalZone to set
	 */
	public void setPostalZone(TextType postalZone) {
		this.postalZone = postalZone;
	}

	/**
	 * @return the postbox
	 */
	public TextType getPostbox() {
		return postbox;
	}

	/**
	 * @param postbox
	 *            the postbox to set
	 */
	public void setPostbox(TextType postbox) {
		this.postbox = postbox;
	}

	/**
	 * @return the region
	 */
	public TextType getRegion() {
		return region;
	}

	/**
	 * @param region
	 *            the region to set
	 */
	public void setRegion(TextType region) {
		this.region = region;
	}

	/**
	 * @return the room
	 */
	public TextType getRoom() {
		return room;
	}

	/**
	 * @param room
	 *            the room to set
	 */
	public void setRoom(TextType room) {
		this.room = room;
	}

	/**
	 * @return the streetName
	 */
	public NameType getStreetName() {
		return streetName;
	}

	/**
	 * @param streetName
	 *            the streetName to set
	 */
	public void setStreetName(NameType streetName) {
		this.streetName = streetName;
	}

	/**
	 * @return the timezoneOffset
	 */
	public TextType getTimezoneOffset() {
		return timezoneOffset;
	}

	/**
	 * @param timezoneOffset
	 *            the timezoneOffset to set
	 */
	public void setTimezoneOffset(TextType timezoneOffset) {
		this.timezoneOffset = timezoneOffset;
	}

	/**
	 * @return the addressLines
	 */
	public List<AddressLineEntity> getAddressLines() {
		return addressLines;
	}

	/**
	 * @param addressLines
	 *            the addressLines to set
	 */
	public void setAddressLines(List<AddressLineEntity> addressLines) {
		this.addressLines = addressLines;
	}

	/**
	 * @return the countries
	 */
	public List<CountryEntity> getCountries() {
		return countries;
	}

	/**
	 * @param countries
	 *            the countries to set
	 */
	public void setCountries(List<CountryEntity> countries) {
		this.countries = countries;
	}

	/**
	 * @return the locationCoordinates
	 */
	public List<LocationCoordinateEntity> getLocationCoordinates() {
		return locationCoordinates;
	}

	/**
	 * @param locationCoordinates
	 *            the locationCoordinates to set
	 */
	public void setLocationCoordinates(List<LocationCoordinateEntity> locationCoordinates) {
		this.locationCoordinates = locationCoordinates;
	}

	/**
	 * @return the party
	 */
	public PartyEntity getParty() {
		return party;
	}

	/**
	 * @param party
	 *            the party to set
	 */
	public void setParty(PartyEntity party) {
		this.party = party;
	}

}
