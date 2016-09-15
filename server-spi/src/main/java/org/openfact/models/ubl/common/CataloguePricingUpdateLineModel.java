package org.openfact.models.ubl.common;

import java.util.List;

public interface CataloguePricingUpdateLineModel {

    String getID();

    void setID(String value);

    CustomerPartyModel getContractorCustomerParty();

    void setContractorCustomerParty(CustomerPartyModel value);

    SupplierPartyModel getSellerSupplierParty();

    void setSellerSupplierParty(SupplierPartyModel value);

    List<ItemLocationQuantityModel> getRequiredItemLocationQuantity();

    void setRequiredItemLocationQuantity(List<ItemLocationQuantityModel> requiredItemLocationQuantity);

    String getId();

    void setId(String value);

}
