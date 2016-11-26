package org.openfact.models.jpa;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.ContactModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.PartyLegalEntityModel;
import org.openfact.models.PartyModel;
import org.openfact.models.jpa.entities.ContactEntity;
import org.openfact.models.jpa.entities.PartyEntity;
import org.openfact.models.jpa.entities.PartyLegalEntity;

public class PartyAdapter implements PartyModel, JpaModel<PartyEntity> {

    protected static final Logger logger = Logger.getLogger(PartyAdapter.class);
    protected PartyEntity party;
    protected EntityManager em;
    protected OpenfactSession session;

    public PartyAdapter(OpenfactSession session, EntityManager em, PartyEntity supplierParty) {
        this.session = session;
        this.em = em;
        this.party = supplierParty;
    }

    @Override
    public PartyEntity getEntity() {
        return party;
    }

    @Override
    public String getId() {
        return party.getId();
    }

    @Override
    public List<PartyLegalEntityModel> getPartyLegalEntity() {
        return party.getPartyLegalEntity().stream().map(f -> new PartyLegalEntityAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public PartyLegalEntityModel addPartyLegalEntity() {
        List<PartyLegalEntity> entities = party.getPartyLegalEntity();

        PartyLegalEntity entity = new PartyLegalEntity();
        entities.add(entity);
        return new PartyLegalEntityAdapter(session, em, entity);
    }

    @Override
    public ContactModel getContact() {
        if (party.getContact() == null) {
            return null;
        }
        return new ContactAdapter(session, em, party.getContact());
    }

    @Override
    public ContactModel getContactAsNotNull() {
        if (party.getContact() == null) {
            ContactEntity contact = new ContactEntity();
            party.setContact(contact);            
        }
        return new ContactAdapter(session, em, party.getContact());
    }

}
