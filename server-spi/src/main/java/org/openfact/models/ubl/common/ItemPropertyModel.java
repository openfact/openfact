package org.openfact.models.ubl.common;

import java.util.List;

public interface ItemPropertyModel {

    String getName();

    void setName(String value);

    String getValue();

    void setValue(String value);

    PeriodModel getUsabilityPeriod();

    void setUsabilityPeriod(PeriodModel value);

    List<ItemPropertyGroupModel> getItemPropertyGroup();

    void setItemPropertyGroup(List<ItemPropertyGroupModel> itemPropertyGroup);

    String getId();

    

}
