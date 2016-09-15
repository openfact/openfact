package org.openfact.models.ubl.common;

import java.util.List;

public interface ItemIdentificationModel {

    IDModel getID();

    void setID(IDModel value);

    ExtendedIDModel getExtendedID();

    void setExtendedID(ExtendedIDModel value);

    List<PhysicalAttributeModel> getPhysicalAttribute();

    void setPhysicalAttribute(List<PhysicalAttributeModel> physicalAttribute);

    List<DimensionModel> getMeasurementDimension();

    void setMeasurementDimension(List<DimensionModel> measurementDimension);

    PartyModel getIssuerParty();

    void setIssuerParty(PartyModel value);

    String getId();

    void setId(String value);

}
