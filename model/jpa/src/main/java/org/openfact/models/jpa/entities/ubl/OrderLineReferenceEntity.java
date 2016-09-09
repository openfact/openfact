package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.LineStatusCodeType;

/**
 * A class to define a reference to an order line.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:17 a. m.
 */
public class OrderLineReferenceEntity {

    /**
     * An identifier for the referenced order line, assigned by the buyer.
     */
    private IdentifierType LineID;
    /**
     * A code signifying the status of the referenced order line with respect to
     * its original state.
     */
    private LineStatusCodeType LineStatusCode;
    /**
     * An identifier for the referenced order line, assigned by the seller.
     */
    private IdentifierType SalesOrderLineID;
    /**
     * A universally unique identifier for this order line reference.
     */
    private IdentifierType UUID;
    private List<OrderReferenceEntity> OrderReferences = new ArrayList<>();

}
