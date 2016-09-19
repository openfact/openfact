package org.openfact.models.jpa.ubl.common;

import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.PartyEntity;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.ContactModel;
import org.openfact.models.ubl.common.LanguageModel;
import org.openfact.models.ubl.common.LocationModelCommAgg;
import org.openfact.models.ubl.common.PartyLegalEntityModel;
import org.openfact.models.ubl.common.PartyModel;
import org.openfact.models.ubl.common.PartyTaxSchemeModel;
import org.openfact.models.ubl.common.PersonModel;

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

    @Override
    public boolean getMarkCareIndicator() {
        return this.party.getMarkCareIndicator();
    }

    @Override
    public void setMarkCareIndicator(boolean value) {
        this.party.setMarkCareIndicator(value);
    }

    @Override
    public boolean getMarkAttentionIndicator() {
        return this.party.getMarkAttentionIndicator();
    }

    @Override
    public void setMarkAttentionIndicator(boolean value) {
        this.party.setMarkAttentionIndicator(value);
    }

    @Override
    public String getWebsiteURI() {
        return this.party.getWebsiteURI();
    }

    @Override
    public void setWebsiteURI(String value) {
        this.party.setWebsiteURI(value);
    }

    @Override
    public String getLogoReferenceID() {
        return this.party.getLogoReferenceID();
    }

    @Override
    public void setLogoReferenceID(String value) {
        this.party.setLogoReferenceID(value);
    }

    @Override
    public String getEndpointID() {
        return this.party.getEndpointID();
    }

    @Override
    public void setEndpointID(String value) {
        this.party.setEndpointID(value);
    }

    @Override
    public List<String> getPartyIdentification() {
        return this.party.getPartyIdentification();
    }

    @Override
    public void setPartyIdentification(List<String> partyIdentification) {
        this.party.setPartyIdentification(partyIdentification);
    }

    @Override
    public List<String> getPartyName() {
        return this.party.getPartyName();
    }

    @Override
    public void setPartyName(List<String> partyName) {
        this.party.setPartyName(partyName);
    }

    @Override
    public LanguageModel getLanguage() {
        return this.party.getLanguage();
    }

    @Override
    public void setLanguage(LanguageAdapter value) {
        this.party.setLanguage(value);
    }

    @Override
    public AddressModel getPostalAddress() {
        return this.party.getPostalAddress();
    }

    @Override
    public void setPostalAddress(AddressAdapter value) {
        this.party.setPostalAddress(value);
    }

    @Override
    public LocationModelCommAgg getPhysicalLocation() {
        return this.party.getPhysicalLocation();
    }

    @Override
    public void setPhysicalLocation(LocationAdapterCommAgg value) {
        this.party.setPhysicalLocation(value);
    }

    @Override
    public List<PartyTaxSchemeModel> getPartyTaxScheme() {
        return this.party.getPartyTaxScheme();
    }

    @Override
    public void setPartyTaxScheme(List<PartyTaxSchemeAdapter> partyTaxScheme) {
        this.party.setPartyTaxScheme(partyTaxScheme);
    }

    @Override
    public List<PartyLegalEntityModel> getPartyLegalEntity() {
        return this.party.getPartyLegalEntity();
    }

    @Override
    public void setPartyLegalEntity(List<PartyLegalEntityAdapter> partyLegalEntity) {
        this.party.setPartyLegalEntity(partyLegalEntity);
    }

    @Override
    public ContactModel getContact() {
        return this.party.getContact();
    }

    @Override
    public void setContact(ContactAdapter value) {
        this.party.setContact(value);
    }

    @Override
    public PersonModel getPerson() {
        return this.party.getPerson();
    }

    @Override
    public void setPerson(PersonAdapter value) {
        this.party.setPerson(value);
    }

    @Override
    public PartyModel getAgentParty() {
        return this.party.getAgentParty();
    }

    @Override
    public void setAgentParty(PartyAdapter value) {
        this.party.setAgentParty(value);
    }

    @Override
    public String getId() {
        return this.party.getId();
    }

    @Override
    public void setId(String value) {
        this.party.setId(value);
    }

    /**
     * */    
    PartyLegalEntityAdapter addPartyLegalEntity();

	public static PartyEntity toEntity(PartyModel model, EntityManager em) {
		// TODO Auto-generated method stub
		return null;
	}

}
