package org.openfact.models.ubl.common;

import java.util.List;

public interface PhysicalAttributeModel {

    AttributeIDModel getAttributeID();

    void setAttributeID(AttributeIDModel value);

    PositionCodeModel getPositionCode();

    void setPositionCode(PositionCodeModel value);

    DescriptionCodeModel getDescriptionCode();

    void setDescriptionCode(DescriptionCodeModel value);

    List<DescriptionModel> getDescription();

    void setDescription(List<DescriptionModel> description);

    String getId();

    void setId(String value);

}
