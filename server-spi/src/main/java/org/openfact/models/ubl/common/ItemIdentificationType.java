package org.openfact.models.ubl.common;

import java.util.List;

public interface ItemIdentificationType {

    IDType getID();

    void setID(IDType value);

    ExtendedIDType getExtendedID();

    void setExtendedID(ExtendedIDType value);

    List<PhysicalAttributeType> getPhysicalAttribute();

    void setPhysicalAttribute(List<PhysicalAttributeType> physicalAttribute);

    List<DimensionType> getMeasurementDimension();

    void setMeasurementDimension(List<DimensionType> measurementDimension);

    PartyType getIssuerParty();

    void setIssuerParty(PartyType value);

    String getId();

    void setId(String value);

}
