package org.openfact.models.ubl.common;

import java.util.List;

public interface TransportEventType {

    IdentificationIDType getIdentificationID();

    void setIdentificationID(IdentificationIDType value);

    OccurrenceDateType getOccurrenceDate();

    void setOccurrenceDate(OccurrenceDateType value);

    OccurrenceTimeType getOccurrenceTime();

    void setOccurrenceTime(OccurrenceTimeType value);

    TransportEventTypeCodeType getTransportEventTypeCode();

    void setTransportEventTypeCode(TransportEventTypeCodeType value);

    DescriptionType getDescription();

    void setDescription(DescriptionType value);

    CompletionIndicatorType getCompletionIndicator();

    void setCompletionIndicator(CompletionIndicatorType value);

    ShipmentType getReportedShipment();

    void setReportedShipment(ShipmentType value);

    List<StatusType> getCurrentStatus();

    void setCurrentStatus(List<StatusType> currentStatus);

    List<ContactType> getContact();

    void setContact(List<ContactType> contact);

    String getId();

    void setId(String value);

}
