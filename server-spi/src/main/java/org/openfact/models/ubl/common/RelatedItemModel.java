package org.openfact.models.ubl.common;

import java.util.List;

public interface RelatedItemModel {

    IDModel getID();

    void setID(IDModel value);

    QuantityModelCommBas getQuantity();

    void setQuantity(QuantityModelCommBas value);

    List<DescriptionModel> getDescription();

    void setDescription(List<DescriptionModel> description);

    String getId();

    void setId(String value);

}
