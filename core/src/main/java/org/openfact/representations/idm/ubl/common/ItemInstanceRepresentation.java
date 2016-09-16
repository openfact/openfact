package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ItemInstanceRepresentation {
    private String ProductTraceID;
    private LocalDate ManufactureDate;
    private LocalTime ManufactureTime;
    private String RegistrationID;
    private String SerialID;
    private List<ItemPropertyRepresentation> AdditionalItemProperty;
    private LotIdentificationRepresentation LotIdentification;
    private String Id;
}