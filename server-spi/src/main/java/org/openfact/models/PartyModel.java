package org.openfact.models;

import java.util.List;

public interface PartyModel {

    String getId();

    List<PartyLegalEntityModel> getPartyLegalEntity();

    PartyLegalEntityModel addPartyLegalEntity();

}
