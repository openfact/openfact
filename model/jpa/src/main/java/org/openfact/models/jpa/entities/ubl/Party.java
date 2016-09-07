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
	private String EndpointID;
	/**
	 * This party's Industry Classification Code.
	 */
	private String IndustryClassificationCode;
	/**
	 * An identifier for this party's logo.
	 */
	private String LogoReferenceID;
	/**
	 * An indicator that this party is "for the attention of" (FAO) (true) or
	 * not (false).
	 */
	private boolean MarkAttentionIndicator;
	/**
	 * An indicator that this party is "care of" (c/o) (true) or not (false).
	 */
	private boolean MarkCareIndicator;
	/**
	 * The Uniform Resource Identifier (URI) that identifies this party's web
	 * site; i. e., the web site's Uniform Resource Locator (URL).
	 */
	private String WebsiteURIID;
	private Address PostalAddress;
	private Contact m_Contact;
	private FinancialAccount m_FinancialAccount;
	private Language m_Language;
	private Location PhysicalLocation;
	private Party AgentParty;
	private PartyIdentification m_PartyIdentification;
	private PartyLegalEntity m_PartyLegalEntity;
	private PartyName m_PartyName;
	private PartyTaxScheme m_PartyTaxScheme;
	private Person m_Person;
	private PowerOfAttorney m_PowerOfAttorney;
	private ServiceProviderParty m_ServiceProviderParty;

	public Party() {

	}

	public void finalize() throws Throwable {

	}

	/**
	 * @return the endpointID
	 */
	public String getEndpointID() {
		return EndpointID;
	}

	/**
	 * @param endpointID
	 *            the endpointID to set
	 */
	public void setEndpointID(String endpointID) {
		EndpointID = endpointID;
	}

	/**
	 * @return the industryClassificationCode
	 */
	public String getIndustryClassificationCode() {
		return IndustryClassificationCode;
	}

	/**
	 * @param industryClassificationCode
	 *            the industryClassificationCode to set
	 */
	public void setIndustryClassificationCode(String industryClassificationCode) {
		IndustryClassificationCode = industryClassificationCode;
	}

	/**
	 * @return the logoReferenceID
	 */
	public String getLogoReferenceID() {
		return LogoReferenceID;
	}

	/**
	 * @param logoReferenceID
	 *            the logoReferenceID to set
	 */
	public void setLogoReferenceID(String logoReferenceID) {
		LogoReferenceID = logoReferenceID;
	}

	/**
	 * @return the markAttentionIndicator
	 */
	public boolean isMarkAttentionIndicator() {
		return MarkAttentionIndicator;
	}

	/**
	 * @param markAttentionIndicator
	 *            the markAttentionIndicator to set
	 */
	public void setMarkAttentionIndicator(boolean markAttentionIndicator) {
		MarkAttentionIndicator = markAttentionIndicator;
	}

	/**
	 * @return the markCareIndicator
	 */
	public boolean isMarkCareIndicator() {
		return MarkCareIndicator;
	}

	/**
	 * @param markCareIndicator
	 *            the markCareIndicator to set
	 */
	public void setMarkCareIndicator(boolean markCareIndicator) {
		MarkCareIndicator = markCareIndicator;
	}

	/**
	 * @return the websiteURIID
	 */
	public String getWebsiteURIID() {
		return WebsiteURIID;
	}

	/**
	 * @param websiteURIID
	 *            the websiteURIID to set
	 */
	public void setWebsiteURIID(String websiteURIID) {
		WebsiteURIID = websiteURIID;
	}

	/**
	 * @return the postalAddress
	 */
	public Address getPostalAddress() {
		return PostalAddress;
	}

	/**
	 * @param postalAddress
	 *            the postalAddress to set
	 */
	public void setPostalAddress(Address postalAddress) {
		PostalAddress = postalAddress;
	}

	/**
	 * @return the m_Contact
	 */
	public Contact getM_Contact() {
		return m_Contact;
	}

	/**
	 * @param m_Contact
	 *            the m_Contact to set
	 */
	public void setM_Contact(Contact m_Contact) {
		this.m_Contact = m_Contact;
	}

	/**
	 * @return the m_FinancialAccount
	 */
	public FinancialAccount getM_FinancialAccount() {
		return m_FinancialAccount;
	}

	/**
	 * @param m_FinancialAccount
	 *            the m_FinancialAccount to set
	 */
	public void setM_FinancialAccount(FinancialAccount m_FinancialAccount) {
		this.m_FinancialAccount = m_FinancialAccount;
	}

	/**
	 * @return the m_Language
	 */
	public Language getM_Language() {
		return m_Language;
	}

	/**
	 * @param m_Language
	 *            the m_Language to set
	 */
	public void setM_Language(Language m_Language) {
		this.m_Language = m_Language;
	}

	/**
	 * @return the physicalLocation
	 */
	public Location getPhysicalLocation() {
		return PhysicalLocation;
	}

	/**
	 * @param physicalLocation
	 *            the physicalLocation to set
	 */
	public void setPhysicalLocation(Location physicalLocation) {
		PhysicalLocation = physicalLocation;
	}

	/**
	 * @return the agentParty
	 */
	public Party getAgentParty() {
		return AgentParty;
	}

	/**
	 * @param agentParty
	 *            the agentParty to set
	 */
	public void setAgentParty(Party agentParty) {
		AgentParty = agentParty;
	}

	/**
	 * @return the m_PartyIdentification
	 */
	public PartyIdentification getM_PartyIdentification() {
		return m_PartyIdentification;
	}

	/**
	 * @param m_PartyIdentification
	 *            the m_PartyIdentification to set
	 */
	public void setM_PartyIdentification(PartyIdentification m_PartyIdentification) {
		this.m_PartyIdentification = m_PartyIdentification;
	}

	/**
	 * @return the m_PartyLegalEntity
	 */
	public PartyLegalEntity getM_PartyLegalEntity() {
		return m_PartyLegalEntity;
	}

	/**
	 * @param m_PartyLegalEntity
	 *            the m_PartyLegalEntity to set
	 */
	public void setM_PartyLegalEntity(PartyLegalEntity m_PartyLegalEntity) {
		this.m_PartyLegalEntity = m_PartyLegalEntity;
	}

	/**
	 * @return the m_PartyName
	 */
	public PartyName getM_PartyName() {
		return m_PartyName;
	}

	/**
	 * @param m_PartyName
	 *            the m_PartyName to set
	 */
	public void setM_PartyName(PartyName m_PartyName) {
		this.m_PartyName = m_PartyName;
	}

	/**
	 * @return the m_PartyTaxScheme
	 */
	public PartyTaxScheme getM_PartyTaxScheme() {
		return m_PartyTaxScheme;
	}

	/**
	 * @param m_PartyTaxScheme
	 *            the m_PartyTaxScheme to set
	 */
	public void setM_PartyTaxScheme(PartyTaxScheme m_PartyTaxScheme) {
		this.m_PartyTaxScheme = m_PartyTaxScheme;
	}

	/**
	 * @return the m_Person
	 */
	public Person getM_Person() {
		return m_Person;
	}

	/**
	 * @param m_Person
	 *            the m_Person to set
	 */
	public void setM_Person(Person m_Person) {
		this.m_Person = m_Person;
	}

	/**
	 * @return the m_PowerOfAttorney
	 */
	public PowerOfAttorney getM_PowerOfAttorney() {
		return m_PowerOfAttorney;
	}

	/**
	 * @param m_PowerOfAttorney
	 *            the m_PowerOfAttorney to set
	 */
	public void setM_PowerOfAttorney(PowerOfAttorney m_PowerOfAttorney) {
		this.m_PowerOfAttorney = m_PowerOfAttorney;
	}

	/**
	 * @return the m_ServiceProviderParty
	 */
	public ServiceProviderParty getM_ServiceProviderParty() {
		return m_ServiceProviderParty;
	}

	/**
	 * @param m_ServiceProviderParty
	 *            the m_ServiceProviderParty to set
	 */
	public void setM_ServiceProviderParty(ServiceProviderParty m_ServiceProviderParty) {
		this.m_ServiceProviderParty = m_ServiceProviderParty;
	}

}// end Party