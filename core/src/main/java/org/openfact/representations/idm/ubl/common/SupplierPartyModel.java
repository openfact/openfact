package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class SupplierPartyModel {
    protected String CustomerAssignedAccountID;
    protected List<String> AdditionalAccountID;
    protected String DataSendingCapability;
    protected PartyModel Party;
    protected ContactModel DespatchContact;
    protected ContactModel AccountingContact;
    protected ContactModel SellerContact;
    protected String Id;
}