package org.openfact.models.ubl.common;

public interface DespatchModel {

    String getID();

    void setID(String value);

    RequestedDespatchDateModel getRequestedDespatchDate();

    void setRequestedDespatchDate(RequestedDespatchDateModel value);

    RequestedDespatchTimeModel getRequestedDespatchTime();

    void setRequestedDespatchTime(RequestedDespatchTimeModel value);

    EstimatedDespatchDateModel getEstimatedDespatchDate();

    void setEstimatedDespatchDate(EstimatedDespatchDateModel value);

    EstimatedDespatchTimeModel getEstimatedDespatchTime();

    void setEstimatedDespatchTime(EstimatedDespatchTimeModel value);

    ActualDespatchDateModel getActualDespatchDate();

    void setActualDespatchDate(ActualDespatchDateModel value);

    ActualDespatchTimeModel getActualDespatchTime();

    void setActualDespatchTime(ActualDespatchTimeModel value);

    AddressModel getDespatchAddress();

    void setDespatchAddress(AddressModel value);

    PartyModel getDespatchParty();

    void setDespatchParty(PartyModel value);

    ContactModel getContact();

    void setContact(ContactModel value);

    String getId();

    void setId(String value);

}
