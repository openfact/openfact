package org.openfact.models.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface TransportEventModel {

    String getIdentificationID();

    void setIdentificationID(String value);

    LocalDate getOccurrenceDate();

    void setOccurrenceDate(LocalDate value);

    LocalTime getOccurrenceTime();

    void setOccurrenceTime(LocalTime value);

    String getTransportEventModelCode();

    void setTransportEventModelCode(String value);

    String getDescription();

    void setDescription(String value);

    boolean getCompletionIndicator();

    void setCompletionIndicator(boolean value);

    ShipmentModel getReportedShipment();

    void setReportedShipment(ShipmentModel value);

    List<StatusModel> getCurrentStatus();

    void setCurrentStatus(List<StatusModel> currentStatus);

    List<ContactModel> getContact();

    void setContact(List<ContactModel> contact);

    String getId();

    

}
