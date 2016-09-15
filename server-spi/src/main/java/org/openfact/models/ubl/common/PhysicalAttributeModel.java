package org.openfact.models.ubl.common;

import java.util.List;

public interface PhysicalAttributeModel {

    AttributeIDModel getAttributeID();

    void setAttributeID(AttributeIDModel value);

    String getPositionCode();

    void setPositionCode(String value);

    String getDescriptionCode();

    void setDescriptionCode(String value);

    List<DescriptionModel> getDescription();

    void setDescription(List<DescriptionModel> description);

    String getId();

    void setId(String value);

}
