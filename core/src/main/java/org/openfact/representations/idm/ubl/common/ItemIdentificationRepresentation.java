package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class ItemIdentificationRepresentation {
    private String idUbl;
    private String extendedID;
    private List<PhysicalAttributeRepresentation> physicalAttribute;
    private List<DimensionRepresentation> measurementDimension;
    private PartyRepresentation issuerParty;
    private String id;

    public String getIdUbl() {
        return this.idUbl;
    }

    public void setIdUbl(String idUbl) {
        this.idUbl = idUbl;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<PhysicalAttributeRepresentation> getPhysicalAttribute() {
        return this.physicalAttribute;
    }

    public void setPhysicalAttribute(List<PhysicalAttributeRepresentation> physicalAttribute) {
        this.physicalAttribute = physicalAttribute;
    }

    public PartyRepresentation getIssuerParty() {
        return this.issuerParty;
    }

    public void setIssuerParty(PartyRepresentation issuerParty) {
        this.issuerParty = issuerParty;
    }

    public List<DimensionRepresentation> getMeasurementDimension() {
        return this.measurementDimension;
    }

    public void setMeasurementDimension(List<DimensionRepresentation> measurementDimension) {
        this.measurementDimension = measurementDimension;
    }

    public String getExtendedID() {
        return this.extendedID;
    }

    public void setExtendedID(String extendedID) {
        this.extendedID = extendedID;
    }
}