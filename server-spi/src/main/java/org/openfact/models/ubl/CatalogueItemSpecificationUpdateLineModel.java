package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to define a line describing the transaction that updates the
 * specification of an item in a catalogue.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:18 a. m.
 */
public class CatalogueItemSpecificationUpdateLineModel {

    /**
     * An identifier for the line to be updated in a catalogue.
     */
    private IdentifierModel ID;
    private CustomerPartyModel contractorCustomerParty;
    private List<ItemModel> items = new ArrayList<>();
    private SupplierPartyModel sellerSupplierParty;

}
