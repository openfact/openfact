package org.openfact.models.ubl.common;

import java.util.List;

public interface CatalogueRequestLineModel {

    String getID();

    void setID(String value);

    String getContractSubdivision();

    void setContractSubdivision(String value);

    List<String> getNote();

    void setNote(List<String> note);

    PeriodModel getLineValidityPeriod();

    void setLineValidityPeriod(PeriodModel value);

    List<ItemLocationQuantityModel> getRequiredItemLocationQuantity();

    void setRequiredItemLocationQuantity(List<ItemLocationQuantityModel> requiredItemLocationQuantity);

    ItemModel getItem();

    void setItem(ItemModel value);

    String getId();

    void setId(String value);

}
