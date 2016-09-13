package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

public interface PartyModel {

    String getId();

    IdentifierType getEndpointID();

    void setEndpointID(IdentifierType endpointID);

    CodeType getIndustryClassificationCode();

    void setIndustryClassificationCode(CodeType industryClassificationCode);

    IdentifierType getLogoReferenceID();

    void setLogoReferenceID(IdentifierType logoReferenceID);

    boolean isMarkAttentionIndicator();

    void setMarkAttentionIndicator(boolean markAttentionIndicator);

    boolean isMarkCareIndicator();

    void setMarkCareIndicator(boolean markCareIndicator);

    IdentifierType getWebsiteURIID();

    void setWebsiteURIID(IdentifierType websiteURIID);

    AddressModel getPostalAddress();

    void setPostalAddress(AddressModel postalAddress);

    List<ContactModel> getContacts();

    void setContacts(List<ContactModel> contacts);

    List<FinancialAccountModel> getFinancialAccounts();

    void setFinancialAccounts(List<FinancialAccountModel> financialAccounts);

    List<LanguageModel> getLanguages();

    void setLanguages(List<LanguageModel> languages);

    LocationModel getPhysicalLocation();

    void setPhysicalLocation(LocationModel physicalLocation);

    List<PartyModel> getAgentParty();

    void setAgentParty(List<PartyModel> agentParty);

    List<PartyIdentificationModel> getPartyIdentifications();

    void setPartyIdentifications(List<PartyIdentificationModel> partyIdentifications);

    List<PartyLegalEntityModel> getPartyLegalEntities();

    void setPartyLegalEntities(List<PartyLegalEntityModel> partyLegalEntities);

    PartyLegalEntityModel addPartyLegalEntity();

    List<PartyNameModel> getPartyNames();

    void setPartyNames(List<PartyNameModel> partyNames);

    void addPartyName(String valueParam);

    List<PartyModel> getTaxSchemePartyTaxSchemes();

    void setTaxSchemePartyTaxSchemes(List<PartyModel> taxSchemePartyTaxSchemes);

    List<PersonModel> getPersons();

    void setPersons(List<PersonModel> persons);

    List<PowerOfAttorneyModel> getPowerOfAttorneys();

    void setPowerOfAttorneys(List<PowerOfAttorneyModel> powerOfAttorneys);

    List<ServiceProviderPartyModel> getServiceProviderParties();

    void setServiceProviderParties(List<ServiceProviderPartyModel> serviceProviderParties);

}
