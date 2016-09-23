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

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LotIdentificationRepresentation getLotIdentification() {
        return this.lotIdentification;
    }

    public void setLotIdentification(LotIdentificationRepresentation lotIdentification) {
        this.lotIdentification = lotIdentification;
    }

    public LocalDate getManufactureDate() {
        return this.manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public List<ItemPropertyRepresentation> getAdditionalItemProperty() {
        return this.additionalItemProperty;
    }

    public void setAdditionalItemProperty(List<ItemPropertyRepresentation> additionalItemProperty) {
        this.additionalItemProperty = additionalItemProperty;
    }

    public String getProductTraceID() {
        return this.productTraceID;
    }

    public void setProductTraceID(String productTraceID) {
        this.productTraceID = productTraceID;
    }

    public String getSerialID() {
        return this.serialID;
    }

    public void setSerialID(String serialID) {
        this.serialID = serialID;
    }

    public LocalTime getManufactureTime() {
        return this.manufactureTime;
    }

    public void setManufactureTime(LocalTime manufactureTime) {
        this.manufactureTime = manufactureTime;
    }

    public String getRegistrationID() {
        return this.registrationID;
    }

    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
    }
}