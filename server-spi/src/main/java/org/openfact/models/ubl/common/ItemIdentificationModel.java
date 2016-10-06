package org.openfact.models.ubl.common;

import java.util.List;

public interface ItemIdentificationModel {

    String getID();

    void setID(String value);

    String getExtendedID();

    void setExtendedID(String value);

    List<PhysicalAttributeModel> getPhysicalAttribute();

    void setPhysicalAttribute(List<PhysicalAttributeModel> physicalAttribute);

    List<DimensionModel> getMeasurementDimension();

    void setMeasurementDimension(List<DimensionModel> measurementDimension);

    PartyModel getIssuerParty();

    void setIssuerParty(PartyModel value);

    String getId();

    

}
