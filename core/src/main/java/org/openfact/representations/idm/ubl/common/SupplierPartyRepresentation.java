package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class SupplierPartyRepresentation {
    private String customerAssignedAccountID;
    private List<String> additionalAccountID;
    private String dataSendingCapability;
    private PartyRepresentation party;
    private ContactRepresentation despatchContact;
    private ContactRepresentation accountingContact;
    private ContactRepresentation sellerContact;
    private String id;
}
