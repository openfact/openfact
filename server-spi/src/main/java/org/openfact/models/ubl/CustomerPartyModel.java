package org.openfact.models.ubl;

import java.util.List;

import org.openfact.models.ubl.type.IdentifierModel;

public interface CustomerPartyModel {

    IdentifierModel getAdditionalAccountID();

    void setAdditionalAccountID(IdentifierModel additionalAccountID);

    IdentifierModel getCustomerAssignedAccountID();

    void setCustomerAssignedAccountID(String valueParam);
    
    void setCustomerAssignedAccountID(IdentifierModel customerAssignedAccountID);

    IdentifierModel getSupplierAssignedAccountID();

    void setSupplierAssignedAccountID(IdentifierModel supplierAssignedAccountID);

    ContactModel getDeliveryContact();

    void setDeliveryContact(ContactModel deliveryContact);

    ContactModel getAccountingContact();

    void setAccountingContact(ContactModel accountingContact);

    ContactModel getBuyerContact();

    void setBuyerContact(ContactModel buyerContact);

    PartyModel getParty();

    void setParties(List<PartyModel> parties);

}
