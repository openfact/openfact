package org.openfact.models.ubl.common;

import java.util.List;

public interface TransportEventModel {

    IdentificationIDModel getIdentificationID();

    void setIdentificationID(IdentificationIDModel value);

    OccurrenceDateModel getOccurrenceDate();

    void setOccurrenceDate(OccurrenceDateModel value);

    OccurrenceTimeModel getOccurrenceTime();

    void setOccurrenceTime(OccurrenceTimeModel value);

    TransportEventModelCodeModel getTransportEventModelCode();

    void setTransportEventModelCode(TransportEventModelCodeModel value);

    DescriptionModel getDescription();

    void setDescription(DescriptionModel value);

    CompletionIndicatorModel getCompletionIndicator();

    void setCompletionIndicator(CompletionIndicatorModel value);

    ShipmentModel getReportedShipment();

    void setReportedShipment(ShipmentModel value);

    List<StatusModel> getCurrentStatus();

    void setCurrentStatus(List<StatusModel> currentStatus);

    List<ContactModel> getContact();

    void setContact(List<ContactModel> contact);

    String getId();

    void setId(String value);

}
