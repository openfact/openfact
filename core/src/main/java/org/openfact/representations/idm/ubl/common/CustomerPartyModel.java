package org.openfact.representations.idm.ubl.common;

import java.util.List;

public interface CustomerPartyModel {

    String getCustomerAssignedAccountID();

    void setCustomerAssignedAccountID(String value);

    String getSupplierAssignedAccountID();

    void setSupplierAssignedAccountID(String value);

    List<String> getAdditionalAccountID();

    void setAdditionalAccountID(List<String> additionalAccountID);

    PartyModel getParty();

    void setParty(PartyModel value);

    ContactModel getDeliveryContact();

    void setDeliveryContact(ContactModel value);

    ContactModel getAccountingContact();

    void setAccountingContact(ContactModel value);

    ContactModel getBuyerContact();

    void setBuyerContact(ContactModel value);

    String getId();

    void setId(String value);

}
