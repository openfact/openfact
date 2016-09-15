package org.openfact.models.ubl.common;

import java.util.List;

public interface PartyModel {

    MarkCareIndicatorModel getMarkCareIndicator();

    void setMarkCareIndicator(MarkCareIndicatorModel value);

    MarkAttentionIndicatorModel getMarkAttentionIndicator();

    void setMarkAttentionIndicator(MarkAttentionIndicatorModel value);

    String getWebsiteURI();

    void setWebsiteURI(String value);

    String getLogoReferenceID();

    void setLogoReferenceID(String value);

    String getEndpointID();

    void setEndpointID(String value);

    List<PartyIdentificationModel> getPartyIdentification();

    void setPartyIdentification(List<PartyIdentificationModel> partyIdentification);

    List<PartyNameModel> getPartyName();

    void setPartyName(List<PartyNameModel> partyName);

    LanguageModel getLanguage();

    void setLanguage(LanguageModel value);

    AddressModel getPostalAddress();

    void setPostalAddress(AddressModel value);

    LocationModelCommAgg getPhysicalLocation();

    void setPhysicalLocation(LocationModelCommAgg value);

    List<PartyTaxSchemeModel> getPartyTaxScheme();

    void setPartyTaxScheme(List<PartyTaxSchemeModel> partyTaxScheme);

    List<PartyLegalEntityModel> getPartyLegalEntity();

    void setPartyLegalEntity(List<PartyLegalEntityModel> partyLegalEntity);

    ContactModel getContact();

    void setContact(ContactModel value);

    PersonModel getPerson();

    void setPerson(PersonModel value);

    PartyModel getAgentParty();

    void setAgentParty(PartyModel value);

    String getId();

    void setId(String value);

}
