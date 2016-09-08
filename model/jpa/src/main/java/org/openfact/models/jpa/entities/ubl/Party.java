package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe an organization, sub-organization, or individual
 * fulfilling a role in a business process.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:25 a. m.
 */
public class Party {

	/**
	 * An identifier for the end point of the routing service (e.g., EAN
	 * Location Number, GLN).
	 */
	private String endpointID;
	/**
	 * This party's Industry Classification Code.
	 */
	private String industryClassificationCode;
	/**
	 * An identifier for this party's logo.
	 */
	private String logoReferenceID;
	/**
	 * An indicator that this party is "for the attention of" (FAO) (true) or
	 * not (false).
	 */
	private boolean markAttentionIndicator;
	/**
	 * An indicator that this party is "care of" (c/o) (true) or not (false).
	 */
	private boolean markCareIndicator;
	/**
	 * The Uniform Resource Identifier (URI) that identifies this party's web
	 * site; i. e., the web site's Uniform Resource Locator (URL).
	 */
	private String websiteURIID;
	private Address postalAddress;
	private List<Contact> contacts = new ArrayList<>();
	private List<FinancialAccount> financialAccounts=new ArrayList<>();
	private List<Language> languages = new ArrayList<>();
	private Location physicalLocation;
	private Party agentParty;
	private List<PartyIdentification> partyIdentification=new ArrayList<>();
	private List<PartyLegalEntity> partyLegalEntities=new ArrayList<>();
	private List<PartyName> partyNames=new ArrayList<>();
	private List<PartyTaxScheme> partyTaxSchemes=new ArrayList<>();
	private List<Person> persons=new ArrayList<>();
	private List<PowerOfAttorney> powerOfAttorneies = new ArrayList<>();
	private List<ServiceProviderParty> serviceProviderParties=new ArrayList<>();

	public Party() {

	}

	public void finalize() throws Throwable {

	}

	public String getEndpointID() {
		return endpointID;
	}

	public void setEndpointID(String endpointID) {
		this.endpointID = endpointID;
	}

	public String getIndustryClassificationCode() {
		return industryClassificationCode;
	}

	public void setIndustryClassificationCode(String industryClassificationCode) {
		this.industryClassificationCode = industryClassificationCode;
	}

	public String getLogoReferenceID() {
		return logoReferenceID;
	}

	public void setLogoReferenceID(String logoReferenceID) {
		this.logoReferenceID = logoReferenceID;
	}

	public boolean isMarkAttentionIndicator() {
		return markAttentionIndicator;
	}

	public void setMarkAttentionIndicator(boolean markAttentionIndicator) {
		this.markAttentionIndicator = markAttentionIndicator;
	}

	public boolean isMarkCareIndicator() {
		return markCareIndicator;
	}

	public void setMarkCareIndicator(boolean markCareIndicator) {
		this.markCareIndicator = markCareIndicator;
	}

	public String getWebsiteURIID() {
		return websiteURIID;
	}

	public void setWebsiteURIID(String websiteURIID) {
		this.websiteURIID = websiteURIID;
	}

	public Address getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(Address postalAddress) {
		this.postalAddress = postalAddress;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<FinancialAccount> getFinancialAccounts() {
		return financialAccounts;
	}

	public void setFinancialAccounts(List<FinancialAccount> financialAccounts) {
		this.financialAccounts = financialAccounts;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public Location getPhysicalLocation() {
		return physicalLocation;
	}

	public void setPhysicalLocation(Location physicalLocation) {
		this.physicalLocation = physicalLocation;
	}

	public Party getAgentParty() {
		return agentParty;
	}

	public void setAgentParty(Party agentParty) {
		this.agentParty = agentParty;
	}

	public List<PartyIdentification> getPartyIdentification() {
		return partyIdentification;
	}

	public void setPartyIdentification(List<PartyIdentification> partyIdentification) {
		this.partyIdentification = partyIdentification;
	}

	public List<PartyLegalEntity> getPartyLegalEntities() {
		return partyLegalEntities;
	}

	public void setPartyLegalEntities(List<PartyLegalEntity> partyLegalEntities) {
		this.partyLegalEntities = partyLegalEntities;
	}

	public List<PartyName> getPartyNames() {
		return partyNames;
	}

	public void setPartyNames(List<PartyName> partyNames) {
		this.partyNames = partyNames;
	}

	public List<PartyTaxScheme> getPartyTaxSchemes() {
		return partyTaxSchemes;
	}

	public void setPartyTaxSchemes(List<PartyTaxScheme> partyTaxSchemes) {
		this.partyTaxSchemes = partyTaxSchemes;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public List<PowerOfAttorney> getPowerOfAttorneies() {
		return powerOfAttorneies;
	}

	public void setPowerOfAttorneies(List<PowerOfAttorney> powerOfAttorneies) {
		this.powerOfAttorneies = powerOfAttorneies;
	}

	public List<ServiceProviderParty> getServiceProviderParties() {
		return serviceProviderParties;
	}

	public void setServiceProviderParties(List<ServiceProviderParty> serviceProviderParties) {
		this.serviceProviderParties = serviceProviderParties;
	}
}// end Party