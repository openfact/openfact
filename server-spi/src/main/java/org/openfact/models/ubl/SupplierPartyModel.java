package org.openfact.models.ubl;

import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.TextType;

public interface SupplierPartyModel {

    String getId();

    IdentifierType getAdditionalAccountID();

    void setAdditionalAccountID(IdentifierType additionalAccountID);

    IdentifierType getCustomerAssignedAccountID();

    void setCustomerAssignedAccountID(String valueParam);

    void setCustomerAssignedAccountID(IdentifierType customerAssignedAccountID);

    TextType getDataSendingCapability();

    void setDataSendingCapability(TextType dataSendingCapability);

    ContactModel getSellerContact();

    void setSellerContact(ContactModel sellerContact);

    ContactModel getAccountingContact();

    void setAccountingContact(ContactModel accountingContact);

    ContactModel getDespatchContact();

    void setDespatchContact(ContactModel despatchContact);

    PartyModel getParty();

    void setParty(PartyModel party);

}
