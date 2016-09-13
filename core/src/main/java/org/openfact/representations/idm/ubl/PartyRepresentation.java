package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.IdentifierType;

/**
 * A class to describe an organization, sub-organization, or individual
 * fulfilling a role in a business process.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:25 a. m.
 */
public class PartyRepresentation {

    /**
     * An identifier for the end point of the routing service (e.g., EAN
     * Location Number, GLN).
     */
    private IdentifierType endpointID;
    /**
     * This party's Industry Classification Code.
     */
    private CodeType industryClassificationCode;
    /**
     * An identifier for this party's logo.
     */
    private IdentifierType logoReferenceID;
    /**
     * An indicator that this party is "for the attention of" (FAO) (true) or
     * not (false).
     */
    private Boolean markAttentionIndicator;
    /**
     * An indicator that this party is "care of" (c/o) (true) or not (false).
     */
    private Boolean markCareIndicator;
    /**
     * The Uniform Resource Identifier (URI) that identifies this party's web
     * site; i. e., the web site's Uniform Resource Locator (URL).
     */
    private IdentifierType websiteURIID;
    private AddressRepresentation postalAddress;
    private List<ContactRepresentation> contacts = new ArrayList<>();
    private List<FinancialAccountRepresentation> financialAccounts = new ArrayList<>();
    private List<LanguageRepresentation> languages = new ArrayList<>();
    private LocationRepresentation physicalLocation;
    private List<PartyRepresentation> agentParty = new ArrayList<>();
    private List<PartyIdentificationRepresentation> partyIdentifications = new ArrayList<>();
    private List<PartyLegalEntityRepresentation> partyLegalEntities = new ArrayList<>();
    private List<PartyNameRepresentation> partyNames = new ArrayList<>();
    private List<PartyRepresentation> taxSchemePartyTaxSchemes = new ArrayList<>();
    private List<PersonRepresentation> persons = new ArrayList<>();
    private List<PowerOfAttorneyRepresentation> powerOfAttorneys = new ArrayList<>();
    private List<ServiceProviderPartyRepresentation> serviceProviderParties = new ArrayList<>();

    /**
     * @return the endpointID
     */
    public IdentifierType getEndpointID() {
        return endpointID;
    }

    /**
     * @param endpointID
     *            the endpointID to set
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
     * @param industryClassificationCode
     *            the industryClassificationCode to set
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
     * @param logoReferenceID
     *            the logoReferenceID to set
     */
    public void setLogoReferenceID(IdentifierType logoReferenceID) {
        this.logoReferenceID = logoReferenceID;
    }

    /**
     * @return the markAttentionIndicator
     */
    public Boolean getMarkAttentionIndicator() {
        return markAttentionIndicator;
    }

    /**
     * @param markAttentionIndicator
     *            the markAttentionIndicator to set
     */
    public void setMarkAttentionIndicator(Boolean markAttentionIndicator) {
        this.markAttentionIndicator = markAttentionIndicator;
    }

    /**
     * @return the markCareIndicator
     */
    public Boolean getMarkCareIndicator() {
        return markCareIndicator;
    }

    /**
     * @param markCareIndicator
     *            the markCareIndicator to set
     */
    public void setMarkCareIndicator(Boolean markCareIndicator) {
        this.markCareIndicator = markCareIndicator;
    }

    /**
     * @return the websiteURIID
     */
    public IdentifierType getWebsiteURIID() {
        return websiteURIID;
    }

    /**
     * @param websiteURIID
     *            the websiteURIID to set
     */
    public void setWebsiteURIID(IdentifierType websiteURIID) {
        this.websiteURIID = websiteURIID;
    }

    /**
     * @return the postalAddress
     */
    public AddressRepresentation getPostalAddress() {
        return postalAddress;
    }

    /**
     * @param postalAddress
     *            the postalAddress to set
     */
    public void setPostalAddress(AddressRepresentation postalAddress) {
        this.postalAddress = postalAddress;
    }

    /**
     * @return the contacts
     */
    public List<ContactRepresentation> getContacts() {
        return contacts;
    }

    /**
     * @param contacts
     *            the contacts to set
     */
    public void setContacts(List<ContactRepresentation> contacts) {
        this.contacts = contacts;
    }

    /**
     * @return the financialAccounts
     */
    public List<FinancialAccountRepresentation> getFinancialAccounts() {
        return financialAccounts;
    }

    /**
     * @param financialAccounts
     *            the financialAccounts to set
     */
    public void setFinancialAccounts(List<FinancialAccountRepresentation> financialAccounts) {
        this.financialAccounts = financialAccounts;
    }

    /**
     * @return the languages
     */
    public List<LanguageRepresentation> getLanguages() {
        return languages;
    }

    /**
     * @param languages
     *            the languages to set
     */
    public void setLanguages(List<LanguageRepresentation> languages) {
        this.languages = languages;
    }

    /**
     * @return the physicalLocation
     */
    public LocationRepresentation getPhysicalLocation() {
        return physicalLocation;
    }

    /**
     * @param physicalLocation
     *            the physicalLocation to set
     */
    public void setPhysicalLocation(LocationRepresentation physicalLocation) {
        this.physicalLocation = physicalLocation;
    }

    /**
     * @return the agentParty
     */
    public List<PartyRepresentation> getAgentParty() {
        return agentParty;
    }

    /**
     * @param agentParty
     *            the agentParty to set
     */
    public void setAgentParty(List<PartyRepresentation> agentParty) {
        this.agentParty = agentParty;
    }

    /**
     * @return the partyIdentifications
     */
    public List<PartyIdentificationRepresentation> getPartyIdentifications() {
        return partyIdentifications;
    }

    /**
     * @param partyIdentifications
     *            the partyIdentifications to set
     */
    public void setPartyIdentifications(List<PartyIdentificationRepresentation> partyIdentifications) {
        this.partyIdentifications = partyIdentifications;
    }

    /**
     * @return the partyLegalEntities
     */
    public List<PartyLegalEntityRepresentation> getPartyLegalEntities() {
        return partyLegalEntities;
    }

    /**
     * @param partyLegalEntities
     *            the partyLegalEntities to set
     */
    public void setPartyLegalEntities(List<PartyLegalEntityRepresentation> partyLegalEntities) {
        this.partyLegalEntities = partyLegalEntities;
    }

    /**
     * @return the partyNames
     */
    public List<PartyNameRepresentation> getPartyNames() {
        return partyNames;
    }

    /**
     * @param partyNames
     *            the partyNames to set
     */
    public void setPartyNames(List<PartyNameRepresentation> partyNames) {
        this.partyNames = partyNames;
    }

    /**
     * @return the taxSchemePartyTaxSchemes
     */
    public List<PartyRepresentation> getTaxSchemePartyTaxSchemes() {
        return taxSchemePartyTaxSchemes;
    }

    /**
     * @param taxSchemePartyTaxSchemes
     *            the taxSchemePartyTaxSchemes to set
     */
    public void setTaxSchemePartyTaxSchemes(List<PartyRepresentation> taxSchemePartyTaxSchemes) {
        this.taxSchemePartyTaxSchemes = taxSchemePartyTaxSchemes;
    }

    /**
     * @return the persons
     */
    public List<PersonRepresentation> getPersons() {
        return persons;
    }

    /**
     * @param persons
     *            the persons to set
     */
    public void setPersons(List<PersonRepresentation> persons) {
        this.persons = persons;
    }

    /**
     * @return the powerOfAttorneys
     */
    public List<PowerOfAttorneyRepresentation> getPowerOfAttorneys() {
        return powerOfAttorneys;
    }

    /**
     * @param powerOfAttorneys
     *            the powerOfAttorneys to set
     */
    public void setPowerOfAttorneys(List<PowerOfAttorneyRepresentation> powerOfAttorneys) {
        this.powerOfAttorneys = powerOfAttorneys;
    }

    /**
     * @return the serviceProviderParties
     */
    public List<ServiceProviderPartyRepresentation> getServiceProviderParties() {
        return serviceProviderParties;
    }

    /**
     * @param serviceProviderParties
     *            the serviceProviderParties to set
     */
    public void setServiceProviderParties(List<ServiceProviderPartyRepresentation> serviceProviderParties) {
        this.serviceProviderParties = serviceProviderParties;
    }

}
