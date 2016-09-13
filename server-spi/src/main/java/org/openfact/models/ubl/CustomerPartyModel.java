package org.openfact.models.ubl;

import java.util.List;

import org.openfact.models.ubl.type.IdentifierType;

public interface CustomerPartyModel {

    IdentifierType getAdditionalAccountID();

    void setAdditionalAccountID(IdentifierType additionalAccountID);

    IdentifierType getCustomerAssignedAccountID();

    void setCustomerAssignedAccountID(String valueParam);
    
    void setCustomerAssignedAccountID(IdentifierType customerAssignedAccountID);

    IdentifierType getSupplierAssignedAccountID();

    void setSupplierAssignedAccountID(IdentifierType supplierAssignedAccountID);

    ContactModel getDeliveryContact();

    void setDeliveryContact(ContactModel deliveryContact);

    ContactModel getAccountingContact();

    void setAccountingContact(ContactModel accountingContact);

    ContactModel getBuyerContact();

    void setBuyerContact(ContactModel buyerContact);

    PartyModel getParty();

    void setParties(List<PartyModel> parties);

}
