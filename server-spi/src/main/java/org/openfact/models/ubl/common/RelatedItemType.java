package org.openfact.models.ubl.common;

import java.util.List;

public interface RelatedItemType {

    IDType getID();

    void setID(IDType value);

    QuantityTypeCommBas getQuantity();

    void setQuantity(QuantityTypeCommBas value);

    List<DescriptionType> getDescription();

    void setDescription(List<DescriptionType> description);

    String getId();

    void setId(String value);

}
