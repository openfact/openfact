package org.openfact.models.ubl.common;

import java.util.List;

public interface SupplierPartyModel {

    String getCustomerAssignedAccountID();

    void setCustomerAssignedAccountID(String value);

    List<String> getAdditionalAccountID();

    void setAdditionalAccountID(List<String> additionalAccountID);

    String getDataSendingCapability();

    void setDataSendingCapability(String value);

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
