package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ItemInstanceRepresentation {
    private String productTraceID;
    private LocalDate manufactureDate;
    private LocalTime manufactureTime;
    private String registrationID;
    private String serialID;
    private List<ItemPropertyRepresentation> additionalItemProperty;
    private LotIdentificationRepresentation lotIdentification;
    private String id;
}
