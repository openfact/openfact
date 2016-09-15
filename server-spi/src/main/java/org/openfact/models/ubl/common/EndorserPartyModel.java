package org.openfact.models.ubl.common;

public interface EndorserPartyModel {

    RoleCodeModel getRoleCode();

    void setRoleCode(RoleCodeModel value);

    SequenceNumericModel getSequenceNumeric();

    void setSequenceNumeric(SequenceNumericModel value);

    PartyModel getParty();

    void setParty(PartyModel value);

    ContactModel getSignatoryContact();

    void setSignatoryContact(ContactModel value);

    String getId();

    void setId(String value);

}
