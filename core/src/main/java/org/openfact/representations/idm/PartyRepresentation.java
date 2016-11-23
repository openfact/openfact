package org.openfact.representations.idm;

import java.util.ArrayList;
import java.util.List;

public class PartyRepresentation {

    protected List<PartyLegalEntityRepresentation> partyLegalEntity;

    public List<PartyLegalEntityRepresentation> getPartyLegalEntity() {
        return partyLegalEntity;
    }

    public void setPartyLegalEntity(List<PartyLegalEntityRepresentation> partyLegalEntity) {
        this.partyLegalEntity = partyLegalEntity;
    }


}
