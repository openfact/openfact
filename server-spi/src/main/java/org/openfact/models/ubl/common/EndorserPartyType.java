package org.openfact.models.ubl.common;

public interface EndorserPartyType {

    RoleCodeType getRoleCode();

    void setRoleCode(RoleCodeType value);

    SequenceNumericType getSequenceNumeric();

    void setSequenceNumeric(SequenceNumericType value);

    PartyType getParty();

    void setParty(PartyType value);

    ContactType getSignatoryContact();

    void setSignatoryContact(ContactType value);

    String getId();

    void setId(String value);

}
