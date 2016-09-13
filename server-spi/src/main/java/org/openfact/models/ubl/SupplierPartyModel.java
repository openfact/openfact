package org.openfact.models.ubl;

import org.openfact.models.ubl.type.IdentifierModel;
import org.openfact.models.ubl.type.TextModel;

public interface SupplierPartyModel {

    String getId();

    IdentifierModel getAdditionalAccountID();

    void setAdditionalAccountID(IdentifierModel additionalAccountID);

    IdentifierModel getCustomerAssignedAccountID();

    void setCustomerAssignedAccountID(String valueParam);

    void setCustomerAssignedAccountID(IdentifierModel customerAssignedAccountID);

    TextModel getDataSendingCapability();

    void setDataSendingCapability(TextModel dataSendingCapability);

    ContactModel getSellerContact();

    void setSellerContact(ContactModel sellerContact);

    ContactModel getAccountingContact();

    void setAccountingContact(ContactModel accountingContact);

    ContactModel getDespatchContact();

    void setDespatchContact(ContactModel despatchContact);

    PartyModel getParty();

    void setParty(PartyModel party);

}
