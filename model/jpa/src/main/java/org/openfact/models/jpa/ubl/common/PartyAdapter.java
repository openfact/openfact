/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.models.jpa.ubl.common;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.PartyEntity;
import org.openfact.models.jpa.entities.ubl.common.PartyLegalEntity;
import org.openfact.models.jpa.entities.ubl.common.PartyTaxSchemeEntity;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.ContactModel;
import org.openfact.models.ubl.common.LanguageModel;
import org.openfact.models.ubl.common.LocationCommAggModel;
import org.openfact.models.ubl.common.PartyLegalModel;
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
        return this.party.isMarkCareIndicator();
    }

    @Override
    public void setMarkCareIndicator(boolean value) {
        this.party.setMarkCareIndicator(value);
    }

    @Override
    public boolean getMarkAttentionIndicator() {
        return this.party.isMarkAttentionIndicator();
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
        return new LanguageAdapter(session, em, party.getLanguage());
    }

    @Override
    public void setLanguage(LanguageModel value) {
        this.party.setLanguage(LanguageAdapter.toEntity(value, em));
    }

    @Override
    public AddressModel getPostalAddress() {
        return new AddressAdapter(session, em, party.getPostalAddress());
    }

    @Override
    public void setPostalAddress(AddressModel value) {
        this.party.setPostalAddress(AddressAdapter.toEntity(value, em));
    }

    @Override
    public LocationCommAggModel getPhysicalLocation() {
        return new LocationCommAggAdapter(session, em, party.getPhysicalLocation());
    }

    @Override
    public void setPhysicalLocation(LocationCommAggModel value) {
        this.party.setPhysicalLocation(LocationCommAggAdapter.toEntity(value, em));
    }

    @Override
    public List<PartyTaxSchemeModel> getPartyTaxScheme() {
        return party.getPartyTaxScheme().stream().map(f -> new PartyTaxSchemeAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public void setPartyTaxScheme(List<PartyTaxSchemeModel> partyTaxScheme) {
        List<PartyTaxSchemeEntity> entities = partyTaxScheme.stream()
                .map(f -> PartyTaxSchemeAdapter.toEntity(f, em)).collect(Collectors.toList());
        party.setPartyTaxScheme(entities);
    }

    @Override
    public List<PartyLegalModel> getPartyLegalEntity() {
        return party.getPartyLegalEntity().stream().map(f -> new PartyLegalAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public void setPartyLegalEntity(List<PartyLegalModel> partyLegalmodel) {
        List<PartyLegalEntity> entities = partyLegalmodel.stream().map(f -> PartyLegalAdapter.toEntity(f, em))
                .collect(Collectors.toList());
        this.party.setPartyLegalEntity(entities);
    }

    @Override
    public ContactModel getContact() {
        return new ContactAdapter(session, em, party.getContact());
    }

    @Override
    public void setContact(ContactModel value) {
        this.party.setContact(ContactAdapter.toEntity(value, em));
    }

    @Override
    public PersonModel getPerson() {
        return new PersonAdapter(session, em, party.getPerson());
    }

    @Override
    public void setPerson(PersonModel value) {
        this.party.setPerson(PersonAdapter.toEntity(value, em));
    }

    @Override
    public PartyModel getAgentParty() {
        return new PartyAdapter(session, em, party.getAgentParty());
    }

    @Override
    public void setAgentParty(PartyModel value) {
        this.party.setAgentParty(PartyAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return this.party.getId();
    }

    public static PartyEntity toEntity(PartyModel model, EntityManager em) {
        if (model instanceof PartyAdapter) {
            return ((PartyAdapter) model).getEntity();
        }
        return em.getReference(PartyEntity.class, model.getId());
    }

    @Override
    public PartyEntity getEntity() {
        return party;
    }

    @Override
    public PartyLegalModel addPartyLegalEntity() {
        List<PartyLegalEntity> partyLegalEntities = party.getPartyLegalEntity();
        PartyLegalEntity partyLegalEntity = new PartyLegalEntity();
        partyLegalEntities.add(partyLegalEntity);
        return new PartyLegalAdapter(session, em, partyLegalEntity);
    }

}
