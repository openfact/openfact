package org.openfact.models.ubl.common;

import java.util.List;

public interface PartyType {

    MarkCareIndicatorType getMarkCareIndicator();

    void setMarkCareIndicator(MarkCareIndicatorType value);

    MarkAttentionIndicatorType getMarkAttentionIndicator();

    void setMarkAttentionIndicator(MarkAttentionIndicatorType value);

    WebsiteURIType getWebsiteURI();

    void setWebsiteURI(WebsiteURIType value);

    LogoReferenceIDType getLogoReferenceID();

    void setLogoReferenceID(LogoReferenceIDType value);

    EndpointIDType getEndpointID();

    void setEndpointID(EndpointIDType value);

    List<PartyIdentificationType> getPartyIdentification();

    void setPartyIdentification(List<PartyIdentificationType> partyIdentification);

    List<PartyNameType> getPartyName();

    void setPartyName(List<PartyNameType> partyName);

    LanguageType getLanguage();

    void setLanguage(LanguageType value);

    AddressType getPostalAddress();

    void setPostalAddress(AddressType value);

    LocationTypeCommAgg getPhysicalLocation();

    void setPhysicalLocation(LocationTypeCommAgg value);

    List<PartyTaxSchemeType> getPartyTaxScheme();

    void setPartyTaxScheme(List<PartyTaxSchemeType> partyTaxScheme);

    List<PartyLegalEntityType> getPartyLegalEntity();

    void setPartyLegalEntity(List<PartyLegalEntityType> partyLegalEntity);

    ContactType getContact();

    void setContact(ContactType value);

    PersonType getPerson();

    void setPerson(PersonType value);

    PartyType getAgentParty();

    void setAgentParty(PartyType value);

    String getId();

    void setId(String value);

}
