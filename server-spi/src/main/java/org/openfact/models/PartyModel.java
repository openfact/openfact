package org.openfact.models;

import java.util.List;

public interface PartyModel {

    String getId();

    ContactModel getContact();

    ContactModel getContactAsNotNull();

    List<PartyLegalEntityModel> getPartyLegalEntity();

    PartyLegalEntityModel addPartyLegalEntity();

}
