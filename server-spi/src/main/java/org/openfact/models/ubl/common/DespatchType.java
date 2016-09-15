package org.openfact.models.ubl.common;

public interface DespatchType {

    IDType getID();

    void setID(IDType value);

    RequestedDespatchDateType getRequestedDespatchDate();

    void setRequestedDespatchDate(RequestedDespatchDateType value);

    RequestedDespatchTimeType getRequestedDespatchTime();

    void setRequestedDespatchTime(RequestedDespatchTimeType value);

    EstimatedDespatchDateType getEstimatedDespatchDate();

    void setEstimatedDespatchDate(EstimatedDespatchDateType value);

    EstimatedDespatchTimeType getEstimatedDespatchTime();

    void setEstimatedDespatchTime(EstimatedDespatchTimeType value);

    ActualDespatchDateType getActualDespatchDate();

    void setActualDespatchDate(ActualDespatchDateType value);

    ActualDespatchTimeType getActualDespatchTime();

    void setActualDespatchTime(ActualDespatchTimeType value);

    AddressType getDespatchAddress();

    void setDespatchAddress(AddressType value);

    PartyType getDespatchParty();

    void setDespatchParty(PartyType value);

    ContactType getContact();

    void setContact(ContactType value);

    String getId();

    void setId(String value);

}
