package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierType;
import org.openfact.representations.idm.ubl.type.LineStatusCodeType;

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
    private IdentifierType lineID;
    /**
     * A code signifying the status of the referenced order line with respect to
     * its original state.
     */
    private LineStatusCodeType lineStatusCode;
    /**
     * An identifier for the referenced order line, assigned by the seller.
     */
    private IdentifierType salesOrderLineID;
    /**
     * A universally unique identifier for this order line reference.
     */
    private IdentifierType UUID;
    private List<OrderReferenceRepresentation> orderReferences = new ArrayList<>();

}