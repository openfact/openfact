package org.openfact.models.ubl.common;

import java.util.List;

public interface CataloguePricingUpdateLineType {

    IDType getID();

    void setID(IDType value);

    CustomerPartyType getContractorCustomerParty();

    void setContractorCustomerParty(CustomerPartyType value);

    SupplierPartyType getSellerSupplierParty();

    void setSellerSupplierParty(SupplierPartyType value);

    List<ItemLocationQuantityType> getRequiredItemLocationQuantity();

    void setRequiredItemLocationQuantity(List<ItemLocationQuantityType> requiredItemLocationQuantity);

    String getId();

    void setId(String value);

}
