package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class CustomerPartyModel {
    protected String CustomerAssignedAccountID;
    protected String SupplierAssignedAccountID;
    protected List<String> AdditionalAccountID;
    protected PartyModel Party;
    protected ContactModel DeliveryContact;
    protected ContactModel AccountingContact;
    protected ContactModel BuyerContact;
    protected String Id;
}