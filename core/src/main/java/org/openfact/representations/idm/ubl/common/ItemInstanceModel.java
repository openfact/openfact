package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ItemInstanceModel {
    protected String ProductTraceID;
    protected LocalDate ManufactureDate;
    protected LocalTime ManufactureTime;
    protected String RegistrationID;
    protected String SerialID;
    protected List<ItemPropertyModel> AdditionalItemProperty;
    protected LotIdentificationModel LotIdentification;
    protected String Id;
}