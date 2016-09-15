package org.openfact.models.ubl.common;

import java.util.List;

public interface CustomerPartyModel {

    CustomerAssignedAccountIDModel getCustomerAssignedAccountID();

    void setCustomerAssignedAccountID(CustomerAssignedAccountIDModel value);

    SupplierAssignedAccountIDModel getSupplierAssignedAccountID();

    void setSupplierAssignedAccountID(SupplierAssignedAccountIDModel value);

    List<AdditionalAccountIDModel> getAdditionalAccountID();

    void setAdditionalAccountID(List<AdditionalAccountIDModel> additionalAccountID);

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
