package org.openfact.models.ubl.common;

public interface CatalogueItemSpecificationUpdateLineModel {

    IDModel getID();

    void setID(IDModel value);

    CustomerPartyModel getContractorCustomerParty();

    void setContractorCustomerParty(CustomerPartyModel value);

    SupplierPartyModel getSellerSupplierParty();

    void setSellerSupplierParty(SupplierPartyModel value);

    ItemModel getItem();

    void setItem(ItemModel value);

    String getId();

    void setId(String value);

}
