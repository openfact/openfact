package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class CustomerPartyRepresentation {
    private String customerAssignedAccountID;
    private String supplierAssignedAccountID;
    private List<String> additionalAccountID;
    private PartyRepresentation party;
    private ContactRepresentation deliveryContact;
    private ContactRepresentation accountingContact;
    private ContactRepresentation buyerContact;
    private String id;
}
