package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to define a reference to an order line.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:17 a. m.
 */
public class OrderLineReferenceModel {

    /**
     * An identifier for the referenced order line, assigned by the buyer.
     */
    private IdentifierModel lineID;
    /**
     * A code signifying the status of the referenced order line with respect to
     * its original state.
     */
    private LineStatusCodeModel lineStatusCode;
    /**
     * An identifier for the referenced order line, assigned by the seller.
     */
    private IdentifierModel salesOrderLineID;
    /**
     * A universally unique identifier for this order line reference.
     */
    private IdentifierModel UUID;
    private List<OrderReferenceModel> orderReferences = new ArrayList<>();

}
