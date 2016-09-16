package org.openfact.models.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

public interface DespatchModel {

    String getID();

    void setID(String value);

    LocalDate getRequestedDespatchDate();

    void setRequestedDespatchDate(LocalDate value);

    LocalTime getRequestedDespatchTime();

    void setRequestedDespatchTime(LocalTime value);

    LocalDate getEstimatedDespatchDate();

    void setEstimatedDespatchDate(LocalDate value);

    LocalTime getEstimatedDespatchTime();

    void setEstimatedDespatchTime(LocalTime value);

    LocalDate getActualDespatchDate();

    void setActualDespatchDate(LocalDate value);

    LocalTime getActualDespatchTime();

    void setActualDespatchTime(LocalTime value);

    AddressModel getDespatchAddress();

    void setDespatchAddress(AddressModel value);

    PartyModel getDespatchParty();

    void setDespatchParty(PartyModel value);

    ContactModel getContact();

    void setContact(ContactModel value);

    String getId();

    void setId(String value);

}
