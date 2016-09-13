package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.LineStatusCodeRepresentation;

/**
 * A class to define a reference to an order line.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:17 a. m.
 */
public class OrderLineReferenceRepresentation {

    /**
     * An identifier for the referenced order line, assigned by the buyer.
     */
    private IdentifierRepresentation lineID;
    /**
     * A code signifying the status of the referenced order line with respect to
     * its original state.
     */
    private LineStatusCodeRepresentation lineStatusCode;
    /**
     * An identifier for the referenced order line, assigned by the seller.
     */
    private IdentifierRepresentation salesOrderLineID;
    /**
     * A universally unique identifier for this order line reference.
     */
    private IdentifierRepresentation UUID;
    private List<OrderReferenceRepresentation> orderReferences = new ArrayList<>();

}
