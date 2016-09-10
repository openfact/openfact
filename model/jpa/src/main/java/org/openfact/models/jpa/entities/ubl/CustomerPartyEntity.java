package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.IdentifierType;

/**
 * A class to describe a customer party.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:14:16 a. m.
 */
public class CustomerPartyEntity {

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
    private ContactEntity deliveryContact;
    private ContactEntity accountingContact;
    private ContactEntity buyerContact;
    private List<PartyEntity> parties = new ArrayList<>();

}
