package org.openfact.models.ubl.common;

public interface CatalogueItemSpecificationUpdateLineType {

    IDType getID();

    void setID(IDType value);

    CustomerPartyType getContractorCustomerParty();

    void setContractorCustomerParty(CustomerPartyType value);

    SupplierPartyType getSellerSupplierParty();

    void setSellerSupplierParty(SupplierPartyType value);

    ItemType getItem();

    void setItem(ItemType value);

    String getId();

    void setId(String value);

}
