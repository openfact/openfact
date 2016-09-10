package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.ubl.type.IdentifierType;

/**
 * A class to define a line describing a pricing update to a catalogue line.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:21 a. m.
 */
public class CataloguePricingUpdateLineEntity {

    /**
     * An identifier for the catalogue line to be updated.
     */
    private IdentifierType ID;
    private CustomerPartyEntity contractorCustomerParty;
    private ItemLocationQuantityEntity requiredItemLocationQuantity;
    private SupplierPartyEntity sellerSupplierParty;

}
