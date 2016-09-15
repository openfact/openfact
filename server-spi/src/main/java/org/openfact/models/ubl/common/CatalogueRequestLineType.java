package org.openfact.models.ubl.common;

import java.util.List;

public interface CatalogueRequestLineType {

    IDType getID();

    void setID(IDType value);

    ContractSubdivisionType getContractSubdivision();

    void setContractSubdivision(ContractSubdivisionType value);

    List<NoteType> getNote();

    void setNote(List<NoteType> note);

    PeriodType getLineValidityPeriod();

    void setLineValidityPeriod(PeriodType value);

    List<ItemLocationQuantityType> getRequiredItemLocationQuantity();

    void setRequiredItemLocationQuantity(List<ItemLocationQuantityType> requiredItemLocationQuantity);

    ItemType getItem();

    void setItem(ItemType value);

    String getId();

    void setId(String value);

}
