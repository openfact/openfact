package org.openfact.models.ubl.common;

import java.util.List;

public interface PhysicalAttributeModel {

    String getAttributeID();

    void setAttributeID(String value);

    String getPositionCode();

    void setPositionCode(String value);

    String getDescriptionCode();

    void setDescriptionCode(String value);

    List<String> getDescription();

    void setDescription(List<String> description);

    String getId();

    void setId(String value);

}
