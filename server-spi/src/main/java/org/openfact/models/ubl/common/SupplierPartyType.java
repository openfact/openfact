package org.openfact.models.ubl.common;

import java.util.List;

public interface SupplierPartyType {

    CustomerAssignedAccountIDType getCustomerAssignedAccountID();

    void setCustomerAssignedAccountID(CustomerAssignedAccountIDType value);

    List<AdditionalAccountIDType> getAdditionalAccountID();

    void setAdditionalAccountID(List<AdditionalAccountIDType> additionalAccountID);

    DataSendingCapabilityType getDataSendingCapability();

    void setDataSendingCapability(DataSendingCapabilityType value);

    PartyType getParty();

    void setParty(PartyType value);

    ContactType getDespatchContact();

    void setDespatchContact(ContactType value);

    ContactType getAccountingContact();

    void setAccountingContact(ContactType value);

    ContactType getSellerContact();

    void setSellerContact(ContactType value);

    String getId();

    void setId(String value);

}
