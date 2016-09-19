package org.openfact.models.jpa.ubl.common;

import java.util.List;

public class PartyAdapter implements PartyModel, JpaModel<PartyEntity> {

    protected static final Logger logger = Logger.getLogger(PartyAdapter.class);
    protected PartyEntity party;
    protected EntityManager em;
    protected OpenfactSession session;

    public PartyAdapter(OpenfactSession session, EntityManager em, PartyEntity party) {
        this.session = session;
        this.em = em;
        this.party = party;
    }

    boolean getMarkCareIndicator() {
        return this.party.getMarkCareIndicator();
    }

    void setMarkCareIndicator(boolean value) {
        this.party.setMarkCareIndicator(value);
    }

    boolean getMarkAttentionIndicator() {
        return this.party.getMarkAttentionIndicator();
    }

    void setMarkAttentionIndicator(boolean value) {
        this.party.setMarkAttentionIndicator(value);
    }

    String getWebsiteURI() {
        return this.party.getWebsiteURI();
    }

    void setWebsiteURI(String value) {
        this.party.setWebsiteURI(value);
    }

    String getLogoReferenceID() {
        return this.party.getLogoReferenceID();
    }

    void setLogoReferenceID(String value) {
        this.party.setLogoReferenceID(value);
    }

    String getEndpointID() {
        return this.party.getEndpointID();
    }

    void setEndpointID(String value) {
        this.party.setEndpointID(value);
    }

    List<String> getPartyIdentification() {
        return this.party.getPartyIdentification();
    }

    void setPartyIdentification(List<String> partyIdentification) {
        this.party.setPartyIdentification(partyIdentification);
    }

    List<String> getPartyName() {
        return this.party.getPartyName();
    }

    void setPartyName(List<String> partyName) {
        this.party.setPartyName(partyName);
    }

    LanguageAdapter getLanguage() {
        return this.party.getLanguage();
    }

    void setLanguage(LanguageAdapter value) {
        this.party.setLanguage(value);
    }

    AddressAdapter getPostalAddress() {
        return this.party.getPostalAddress();
    }

    void setPostalAddress(AddressAdapter value) {
        this.party.setPostalAddress(value);
    }

    LocationAdapterCommAgg getPhysicalLocation() {
        return this.party.getPhysicalLocation();
    }

    void setPhysicalLocation(LocationAdapterCommAgg value) {
        this.party.setPhysicalLocation(value);
    }

    List<PartyTaxSchemeAdapter> getPartyTaxScheme() {
        return this.party.getPartyTaxScheme();
    }

    void setPartyTaxScheme(List<PartyTaxSchemeAdapter> partyTaxScheme) {
        this.party.setPartyTaxScheme(partyTaxScheme);
    }

    List<PartyLegalEntityAdapter> getPartyLegalEntity() {
        return this.party.getPartyLegalEntity();
    }

    void setPartyLegalEntity(List<PartyLegalEntityAdapter> partyLegalEntity) {
        this.party.setPartyLegalEntity(partyLegalEntity);
    }

    ContactAdapter getContact() {
        return this.party.getContact();
    }

    void setContact(ContactAdapter value) {
        this.party.setContact(value);
    }

    PersonAdapter getPerson() {
        return this.party.getPerson();
    }

    void setPerson(PersonAdapter value) {
        this.party.setPerson(value);
    }

    PartyAdapter getAgentParty() {
        return this.party.getAgentParty();
    }

    void setAgentParty(PartyAdapter value) {
        this.party.setAgentParty(value);
    }

    String getId() {
        return this.party.getId();
    }

    void setId(String value) {
        this.party.setId(value);
    }

    /**
     * */
    PartyLegalEntityAdapter addPartyLegalEntity();

}
