package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a supplier party.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:00 a. m.
 */
public class SupplierPartyModel {

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
    private ContactModel sellerContact;
    private ContactModel accountingContact;
    private ContactModel despatchContact;
    private List<PartyModel> parties = new ArrayList<>();

}
