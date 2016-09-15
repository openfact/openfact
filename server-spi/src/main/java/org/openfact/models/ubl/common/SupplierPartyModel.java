package org.openfact.models.ubl.common;

import java.util.List;

public interface SupplierPartyModel {

    CustomerAssignedAccountIDModel getCustomerAssignedAccountID();

    void setCustomerAssignedAccountID(CustomerAssignedAccountIDModel value);

    List<AdditionalAccountIDModel> getAdditionalAccountID();

    void setAdditionalAccountID(List<AdditionalAccountIDModel> additionalAccountID);

    DataSendingCapabilityModel getDataSendingCapability();

    void setDataSendingCapability(DataSendingCapabilityModel value);

    PartyModel getParty();

    void setParty(PartyModel value);

    ContactModel getDespatchContact();

    void setDespatchContact(ContactModel value);

    ContactModel getAccountingContact();

    void setAccountingContact(ContactModel value);

    ContactModel getSellerContact();

    void setSellerContact(ContactModel value);

    String getId();

    void setId(String value);

}
