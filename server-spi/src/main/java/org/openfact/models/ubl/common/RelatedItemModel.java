package org.openfact.models.ubl.common;

import java.util.List;

public interface RelatedItemModel {

    String getID();

    void setID(String value);

    QuantityModel getQuantity();

    void setQuantity(QuantityModel value);

    List<String> getDescription();

    void setDescription(List<String> description);

    String getId();

    void setId(String value);

}
