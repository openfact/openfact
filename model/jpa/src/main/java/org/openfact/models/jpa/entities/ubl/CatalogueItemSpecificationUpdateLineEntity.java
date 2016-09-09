package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.IdentifierType;

/**
 * A class to define a line describing the transaction that updates the
 * specification of an item in a catalogue.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:18 a. m.
 */
public class CatalogueItemSpecificationUpdateLineEntity {

    /**
     * An identifier for the line to be updated in a catalogue.
     */
    private IdentifierType ID;
    private CustomerPartyEntity ContractorCustomerParty;
    private List<ItemEntity> Items = new ArrayList<>();
    private SupplierPartyEntity SellerSupplierParty;

}
