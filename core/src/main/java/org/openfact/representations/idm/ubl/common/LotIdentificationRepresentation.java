package org.openfact.representations.idm.ubl.common;

import java.time.LocalDate;
import java.util.List;

public class LotIdentificationRepresentation {
    private String lotNumberID;
    private LocalDate expiryDate;
    private List<ItemPropertyRepresentation> additionalItemProperty;
    private String id;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLotNumberID() {
        return this.lotNumberID;
    }

    public void setLotNumberID(String lotNumberID) {
        this.lotNumberID = lotNumberID;
    }

    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public List<ItemPropertyRepresentation> getAdditionalItemProperty() {
        return this.additionalItemProperty;
    }

    public void setAdditionalItemProperty(List<ItemPropertyRepresentation> additionalItemProperty) {
        this.additionalItemProperty = additionalItemProperty;
    }
}