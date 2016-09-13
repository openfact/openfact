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
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.IdentifierType;

/**
 * A class to describe an organization, sub-organization, or individual
 * fulfilling a role in a business process.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:25 a. m.
 */
@Entity
@Table(name = "PARTY")
public class PartyEntity {
	@Id
	@Column(name = "ID_OP", length = 36)
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	private String id;
	/**
	 * An identifier for the end point of the routing service (e.g., EAN
	 * Location Number, GLN).
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "ENDPOINTID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "ENDPOINTID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "ENDPOINTID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "ENDPOINTID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "ENDPOINTID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "ENDPOINTID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "ENDPOINTID_SCHEMEDATEURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "ENDPOINTID_SCHEMEURI")) })
	private IdentifierType endpointID;
	/**
	 * This party's Industry Classification Code.
	 */
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "value", column = @Column(name = "INDUSTRYCLASSIFICATIONCODE_VALUE")),
			@AttributeOverride(name = "listID", column = @Column(name = "INDUSTRYCLASSIFICATIONCODE_LISTID")),
			@AttributeOverride(name = "listAgencyID", column = @Column(name = "INDUSTRYCLASSIFICATIONCODE_AGENCYID")),
			@AttributeOverride(name = "listAgencyName", column = @Column(name = "INDUSTRYCLASSIFICATIONCODE_AGENCYNAME")),
			@AttributeOverride(name = "listName", column = @Column(name = "INDUSTRYCLASSIFICATIONCODE_LISTNAME")),
			@AttributeOverride(name = "listVersionID", column = @Column(name = "INDUSTRYCLASSIFICATIONCODE_LISTVERSIONID")),
			@AttributeOverride(name = "name", column = @Column(name = "INDUSTRYCLASSIFICATIONCODE_NAME")),
			@AttributeOverride(name = "languageID", column = @Column(name = "INDUSTRYCLASSIFICATIONCODE_LANGUAGEID")),
			@AttributeOverride(name = "listURI", column = @Column(name = "INDUSTRYCLASSIFICATIONCODE_LISTURI")),
			@AttributeOverride(name = "listSchemeURI", column = @Column(name = "INDUSTRYCLASSIFICATIONCODE_SCHEMEURI")) })
	private CodeType industryClassificationCode;
	/**
	 * An identifier for this party's logo.
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "LOGOREFERENCEID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "LOGOREFERENCEID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "LOGOREFERENCEID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "LOGOREFERENCEID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "LOGOREFERENCEID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "LOGOREFERENCEID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "LOGOREFERENCEID_SCHEMEDATEURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "LOGOREFERENCEID_SCHEMEURI")) })
	private IdentifierType logoReferenceID;
	/**
	 * An indicator that this party is "for the attention of" (FAO) (true) or
	 * not (false).
	 */
	@Type(type = "org.hibernate.type.NumericBooleanType")
	@Column(name = "MARK_ATTENTION_INDICATOR")
	private boolean markAttentionIndicator;
	/**
	 * An indicator that this party is "care of" (c/o) (true) or not (false).
	 */
	@Type(type = "org.hibernate.type.NumericBooleanType")
	@Column(name = "MARK_CARE_INDICATOR")
	private boolean markCareIndicator;
	/**
	 * The Uniform Resource Identifier (URI) that identifies this party's web
	 * site; i. e., the web site's Uniform Resource Locator (URL).
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "value", column = @Column(name = "WEBSITEURIID_VALUE")),
			@AttributeOverride(name = "schemeID", column = @Column(name = "WEBSITEURIID_SCHEMEID")),
			@AttributeOverride(name = "schemeName", column = @Column(name = "WEBSITEURIID_SCHEMENAME")),
			@AttributeOverride(name = "schemeAgencyID", column = @Column(name = "WEBSITEURIID_SCHEMEAGENCYID")),
			@AttributeOverride(name = "schemeAgencyName", column = @Column(name = "WEBSITEURIID_SCHEMEAGENCYNAME")),
			@AttributeOverride(name = "schemeVersionID", column = @Column(name = "WEBSITEURIID_SCHEMEVERSIONID")),
			@AttributeOverride(name = "schemeDataURI", column = @Column(name = "WEBSITEURIID_SCHEMEDATEURI")),
			@AttributeOverride(name = "schemeURI", column = @Column(name = "WEBSITEURIID_SCHEMEURI")) })
	private IdentifierType websiteURIID;


	@OneToOne(mappedBy = "party", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private AddressEntity postalAddress;

	@Transient
	private List<ContactEntity> contacts = new ArrayList<>();

	@Transient
	private List<FinancialAccountEntity> financialAccounts = new ArrayList<>();

	@Transient
	private List<LanguageEntity> languages = new ArrayList<>();

	@Transient
	private LocationEntity physicalLocation;

	@Transient
	private List<PartyEntity> agentParty = new ArrayList<>();

	@Transient
	private List<PartyIdentificationEntity> partyIdentifications = new ArrayList<>();

	@OneToMany(mappedBy = "party", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<PartyLegalEntity> partyLegalEntities = new ArrayList<>();

	@OneToMany(mappedBy = "party", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<PartyNameEntity> partyNames = new ArrayList<>();

	@Transient
	private List<PartyEntity> taxSchemePartyTaxSchemes = new ArrayList<>();

	@Transient
	private List<PersonEntity> persons = new ArrayList<>();

	@Transient
	private List<PowerOfAttorneyEntity> powerOfAttorneys = new ArrayList<>();

	@Transient
	private List<ServiceProviderPartyEntity> serviceProviderParties = new ArrayList<>();

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the endpointID
	 */
	public IdentifierType getEndpointID() {
		return endpointID;
	}

	/**
	 * @param endpointID the endpointID to set
	 */
	public void setEndpointID(IdentifierType endpointID) {
		this.endpointID = endpointID;
	}

	/**
	 * @return the industryClassificationCode
	 */
	public CodeType getIndustryClassificationCode() {
		return industryClassificationCode;
	}

	/**
	 * @param industryClassificationCode the industryClassificationCode to set
	 */
	public void setIndustryClassificationCode(CodeType industryClassificationCode) {
		this.industryClassificationCode = industryClassificationCode;
	}

	/**
	 * @return the logoReferenceID
	 */
	public IdentifierType getLogoReferenceID() {
		return logoReferenceID;
	}

	/**
	 * @param logoReferenceID the logoReferenceID to set
	 */
	public void setLogoReferenceID(IdentifierType logoReferenceID) {
		this.logoReferenceID = logoReferenceID;
	}

	/**
	 * @return the markAttentionIndicator
	 */
	public boolean isMarkAttentionIndicator() {
		return markAttentionIndicator;
	}

	/**
	 * @param markAttentionIndicator the markAttentionIndicator to set
	 */
	public void setMarkAttentionIndicator(boolean markAttentionIndicator) {
		this.markAttentionIndicator = markAttentionIndicator;
	}

	/**
	 * @return the markCareIndicator
	 */
	public boolean isMarkCareIndicator() {
		return markCareIndicator;
	}

	/**
	 * @param markCareIndicator the markCareIndicator to set
	 */
	public void setMarkCareIndicator(boolean markCareIndicator) {
		this.markCareIndicator = markCareIndicator;
	}

	/**
	 * @return the websiteURIID
	 */
	public IdentifierType getWebsiteURIID() {
		return websiteURIID;
	}

	/**
	 * @param websiteURIID the websiteURIID to set
	 */
	public void setWebsiteURIID(IdentifierType websiteURIID) {
		this.websiteURIID = websiteURIID;
	}

	/**
	 * @return the postalAddress
	 */
	public AddressEntity getPostalAddress() {
		return postalAddress;
	}

	/**
	 * @param postalAddress the postalAddress to set
	 */
	public void setPostalAddress(AddressEntity postalAddress) {
		this.postalAddress = postalAddress;
	}

	/**
	 * @return the contacts
	 */
	public List<ContactEntity> getContacts() {
		return contacts;
	}

	/**
	 * @param contacts the contacts to set
	 */
	public void setContacts(List<ContactEntity> contacts) {
		this.contacts = contacts;
	}

	/**
	 * @return the financialAccounts
	 */
	public List<FinancialAccountEntity> getFinancialAccounts() {
		return financialAccounts;
	}

	/**
	 * @param financialAccounts the financialAccounts to set
	 */
	public void setFinancialAccounts(List<FinancialAccountEntity> financialAccounts) {
		this.financialAccounts = financialAccounts;
	}

	/**
	 * @return the languages
	 */
	public List<LanguageEntity> getLanguages() {
		return languages;
	}

	/**
	 * @param languages the languages to set
	 */
	public void setLanguages(List<LanguageEntity> languages) {
		this.languages = languages;
	}

	/**
	 * @return the physicalLocation
	 */
	public LocationEntity getPhysicalLocation() {
		return physicalLocation;
	}

	/**
	 * @param physicalLocation the physicalLocation to set
	 */
	public void setPhysicalLocation(LocationEntity physicalLocation) {
		this.physicalLocation = physicalLocation;
	}

	/**
	 * @return the agentParty
	 */
	public List<PartyEntity> getAgentParty() {
		return agentParty;
	}

	/**
	 * @param agentParty the agentParty to set
	 */
	public void setAgentParty(List<PartyEntity> agentParty) {
		this.agentParty = agentParty;
	}

	/**
	 * @return the partyIdentifications
	 */
	public List<PartyIdentificationEntity> getPartyIdentifications() {
		return partyIdentifications;
	}

	/**
	 * @param partyIdentifications the partyIdentifications to set
	 */
	public void setPartyIdentifications(List<PartyIdentificationEntity> partyIdentifications) {
		this.partyIdentifications = partyIdentifications;
	}

	/**
	 * @return the partyLegalEntities
	 */
	public List<PartyLegalEntity> getPartyLegalEntities() {
		return partyLegalEntities;
	}

	/**
	 * @param partyLegalEntities the partyLegalEntities to set
	 */
	public void setPartyLegalEntities(List<PartyLegalEntity> partyLegalEntities) {
		this.partyLegalEntities = partyLegalEntities;
	}

	/**
	 * @return the partyNames
	 */
	public List<PartyNameEntity> getPartyNames() {
		return partyNames;
	}

	/**
	 * @param partyNames the partyNames to set
	 */
	public void setPartyNames(List<PartyNameEntity> partyNames) {
		this.partyNames = partyNames;
	}

	/**
	 * @return the taxSchemePartyTaxSchemes
	 */
	public List<PartyEntity> getTaxSchemePartyTaxSchemes() {
		return taxSchemePartyTaxSchemes;
	}

	/**
	 * @param taxSchemePartyTaxSchemes the taxSchemePartyTaxSchemes to set
	 */
	public void setTaxSchemePartyTaxSchemes(List<PartyEntity> taxSchemePartyTaxSchemes) {
		this.taxSchemePartyTaxSchemes = taxSchemePartyTaxSchemes;
	}

	/**
	 * @return the persons
	 */
	public List<PersonEntity> getPersons() {
		return persons;
	}

	/**
	 * @param persons the persons to set
	 */
	public void setPersons(List<PersonEntity> persons) {
		this.persons = persons;
	}

	/**
	 * @return the powerOfAttorneys
	 */
	public List<PowerOfAttorneyEntity> getPowerOfAttorneys() {
		return powerOfAttorneys;
	}

	/**
	 * @param powerOfAttorneys the powerOfAttorneys to set
	 */
	public void setPowerOfAttorneys(List<PowerOfAttorneyEntity> powerOfAttorneys) {
		this.powerOfAttorneys = powerOfAttorneys;
	}

	/**
	 * @return the serviceProviderParties
	 */
	public List<ServiceProviderPartyEntity> getServiceProviderParties() {
		return serviceProviderParties;
	}

	/**
	 * @param serviceProviderParties the serviceProviderParties to set
	 */
	public void setServiceProviderParties(List<ServiceProviderPartyEntity> serviceProviderParties) {
		this.serviceProviderParties = serviceProviderParties;
	}
	
	

}
