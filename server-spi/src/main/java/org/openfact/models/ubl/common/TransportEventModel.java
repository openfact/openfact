package org.openfact.models.ubl.common;

import java.util.List;

public interface TransportEventModel {

    String getIdentificationID();

    void setIdentificationID(String value);

    OccurrenceDateModel getOccurrenceDate();

    void setOccurrenceDate(OccurrenceDateModel value);

    OccurrenceTimeModel getOccurrenceTime();

    void setOccurrenceTime(OccurrenceTimeModel value);

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

    void setId(String value);

}
