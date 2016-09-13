package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;

/**
 * A class to define a line describing the transaction that updates the
 * specification of an item in a catalogue.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:18 a. m.
 */
public class CatalogueItemSpecificationUpdateLineRepresentation {

    /**
     * An identifier for the line to be updated in a catalogue.
     */
    private IdentifierRepresentation ID;
    private CustomerPartyRepresentation contractorCustomerParty;
    private List<ItemRepresentation> items = new ArrayList<>();
    private SupplierPartyRepresentation sellerSupplierParty;

}
