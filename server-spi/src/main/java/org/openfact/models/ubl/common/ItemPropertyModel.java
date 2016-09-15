package org.openfact.models.ubl.common;

import java.util.List;

public interface ItemPropertyModel {

    NameModelCommBas getName();

    void setName(NameModelCommBas value);

    ValueModel getValue();

    void setValue(ValueModel value);

    PeriodModel getUsabilityPeriod();

    void setUsabilityPeriod(PeriodModel value);

    List<ItemPropertyGroupModel> getItemPropertyGroup();

    void setItemPropertyGroup(List<ItemPropertyGroupModel> itemPropertyGroup);

    String getId();

    void setId(String value);

}
