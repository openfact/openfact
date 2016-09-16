package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class CustomerPartyRepresentation {
    private String CustomerAssignedAccountID;
    private String SupplierAssignedAccountID;
    private List<String> AdditionalAccountID;
    private PartyRepresentation Party;
    private ContactRepresentation DeliveryContact;
    private ContactRepresentation AccountingContact;
    private ContactRepresentation BuyerContact;
    private String Id;
}