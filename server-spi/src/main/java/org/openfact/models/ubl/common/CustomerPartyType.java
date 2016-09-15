package org.openfact.models.ubl.common;

import java.util.List;

public interface CustomerPartyType {

    CustomerAssignedAccountIDType getCustomerAssignedAccountID();

    void setCustomerAssignedAccountID(CustomerAssignedAccountIDType value);

    SupplierAssignedAccountIDType getSupplierAssignedAccountID();

    void setSupplierAssignedAccountID(SupplierAssignedAccountIDType value);

    List<AdditionalAccountIDType> getAdditionalAccountID();

    void setAdditionalAccountID(List<AdditionalAccountIDType> additionalAccountID);

    PartyType getParty();

    void setParty(PartyType value);

    ContactType getDeliveryContact();

    void setDeliveryContact(ContactType value);

    ContactType getAccountingContact();

    void setAccountingContact(ContactType value);

    ContactType getBuyerContact();

    void setBuyerContact(ContactType value);

    String getId();

    void setId(String value);

}
