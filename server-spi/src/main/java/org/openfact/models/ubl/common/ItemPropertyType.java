package org.openfact.models.ubl.common;

import java.util.List;

public interface ItemPropertyType {

    NameTypeCommBas getName();

    void setName(NameTypeCommBas value);

    ValueType getValue();

    void setValue(ValueType value);

    PeriodType getUsabilityPeriod();

    void setUsabilityPeriod(PeriodType value);

    List<ItemPropertyGroupType> getItemPropertyGroup();

    void setItemPropertyGroup(List<ItemPropertyGroupType> itemPropertyGroup);

    String getId();

    void setId(String value);

}
