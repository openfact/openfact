package org.openfact.models.ubl.common;

import java.math.BigDecimal;

public interface EndorserPartyModel {

    String getRoleCode();

    void setRoleCode(String value);

    BigDecimal getSequenceNumeric();

    void setSequenceNumeric(BigDecimal value);

    PartyModel getParty();

    void setParty(PartyModel value);

    ContactModel getSignatoryContact();

    void setSignatoryContact(ContactModel value);

    String getId();

    void setId(String value);

}
