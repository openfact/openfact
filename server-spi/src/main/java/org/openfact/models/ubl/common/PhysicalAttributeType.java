package org.openfact.models.ubl.common;

import java.util.List;

public interface PhysicalAttributeType {

    AttributeIDType getAttributeID();

    void setAttributeID(AttributeIDType value);

    PositionCodeType getPositionCode();

    void setPositionCode(PositionCodeType value);

    DescriptionCodeType getDescriptionCode();

    void setDescriptionCode(DescriptionCodeType value);

    List<DescriptionType> getDescription();

    void setDescription(List<DescriptionType> description);

    String getId();

    void setId(String value);

}
