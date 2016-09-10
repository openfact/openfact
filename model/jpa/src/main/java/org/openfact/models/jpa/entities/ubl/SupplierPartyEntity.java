package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to describe a supplier party.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:00 a. m.
 */
public class SupplierPartyEntity {

    /**
     * An additional identifier for this supplier party.
     */
    private IdentifierType additionalAccountID;
    /**
     * An identifier for this supplier party, assigned by the customer.
     */
    private IdentifierType customerAssignedAccountID;
    /**
     * Text describing the supplier's ability to send invoice data via a
     * purchase card provider (e.g., VISA, MasterCard, American Express).
     */
    private TextType dataSendingCapability;
    private ContactEntity sellerContact;
    private ContactEntity accountingContact;
    private ContactEntity despatchContact;
    private List<PartyEntity> parties = new ArrayList<>();

}
