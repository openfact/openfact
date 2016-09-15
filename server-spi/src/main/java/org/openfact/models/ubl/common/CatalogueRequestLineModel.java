package org.openfact.models.ubl.common;

import java.util.List;

public interface CatalogueRequestLineModel {

    IDModel getID();

    void setID(IDModel value);

    ContractSubdivisionModel getContractSubdivision();

    void setContractSubdivision(ContractSubdivisionModel value);

    List<NoteModel> getNote();

    void setNote(List<NoteModel> note);

    PeriodModel getLineValidityPeriod();

    void setLineValidityPeriod(PeriodModel value);

    List<ItemLocationQuantityModel> getRequiredItemLocationQuantity();

    void setRequiredItemLocationQuantity(List<ItemLocationQuantityModel> requiredItemLocationQuantity);

    ItemModel getItem();

    void setItem(ItemModel value);

    String getId();

    void setId(String value);

}
