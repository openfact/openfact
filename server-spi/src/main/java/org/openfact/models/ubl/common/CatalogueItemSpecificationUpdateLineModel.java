package org.openfact.models.ubl.common;

public interface CatalogueItemSpecificationUpdateLineModel {

    String getID();

    void setID(String value);

    CustomerPartyModel getContractorCustomerParty();

    void setContractorCustomerParty(CustomerPartyModel value);

    SupplierPartyModel getSellerSupplierParty();

    void setSellerSupplierParty(SupplierPartyModel value);

    ItemModel getItem();

    void setItem(ItemModel value);

    String getId();

    void setId(String value);

}
