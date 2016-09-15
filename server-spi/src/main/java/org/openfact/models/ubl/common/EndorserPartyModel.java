package org.openfact.models.ubl.common;

public interface EndorserPartyModel {

    String getRoleCode();

    void setRoleCode(String value);

    SequenceNumericModel getSequenceNumeric();

    void setSequenceNumeric(SequenceNumericModel value);

    PartyModel getParty();

    void setParty(PartyModel value);

    ContactModel getSignatoryContact();

    void setSignatoryContact(ContactModel value);

    String getId();

    void setId(String value);

}
