package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierType;

/**
 * A class to describe a customer party.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:14:16 a. m.
 */
public class CustomerPartyRepresentation {

    /**
     * An identifier for the customer's account, assigned by a third party.
     */
    private IdentifierType additionalAccountID;
    /**
     * An identifier for the customer's account, assigned by the customer
     * itself.
     */
    private IdentifierType customerAssignedAccountID;
    /**
     * An identifier for the customer's account, assigned by the supplier.
     */
    private IdentifierType supplierAssignedAccountID;
    private ContactRepresentation deliveryContact;
    private ContactRepresentation accountingContact;
    private ContactRepresentation buyerContact;
    private List<PartyRepresentation> parties = new ArrayList<>();

}
