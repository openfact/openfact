package org.openfact.models.ubl.common;

import java.util.List;

public interface PartyModel {

    boolean getMarkCareIndicator();

    void setMarkCareIndicator(boolean value);

    boolean getMarkAttentionIndicator();

    void setMarkAttentionIndicator(boolean value);

    String getWebsiteURI();

    void setWebsiteURI(String value);

    String getLogoReferenceID();

    void setLogoReferenceID(String value);

    String getEndpointID();

    void setEndpointID(String value);

    List<String> getPartyIdentification();

    void setPartyIdentification(List<String> partyIdentification);

    List<String> getPartyName();

    void setPartyName(List<String> partyName);

    LanguageModel getLanguage();

    void setLanguage(LanguageModel value);

    AddressModel getPostalAddress();

    void setPostalAddress(AddressModel value);

    LocationCommAggModel getPhysicalLocation();

    void setPhysicalLocation(LocationCommAggModel value);

    List<PartyTaxSchemeModel> getPartyTaxScheme();

    void setPartyTaxScheme(List<PartyTaxSchemeModel> partyTaxScheme);

    List<PartyLegalModel> getPartyLegalEntity();

    void setPartyLegalEntity(List<PartyLegalModel> partyLegalEntity);

    ContactModel getContact();

    void setContact(ContactModel value);

    PersonModel getPerson();

    void setPerson(PersonModel value);

    PartyModel getAgentParty();

    void setAgentParty(PartyModel value);

    String getId();

    

    /**
     * */
    PartyLegalModel addPartyLegalEntity();

}
