package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.LineStatusCodeRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to define a line in a DespatchAdvice.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:29 a. m.
 */
public class DespatchLineRepresentation {

    /**
     * The quantity on back order at the supplier.
     */
    private QuantityRepresentation backorderQuantity;
    /**
     * The reason for the back order.
     */
    private TextRepresentation backorderReason;
    /**
     * The quantity despatched (picked up).
     */
    private QuantityRepresentation deliveredQuantity;
    /**
     * An identifier for this despatch line.
     */
    private IdentifierRepresentation ID;
    /**
     * A code signifying the status of this despatch line with respect to its
     * original state.
     */
    private LineStatusCodeRepresentation lineStatusCode;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextRepresentation note;
    /**
     * The quantity outstanding (which will follow in a later despatch).
     */
    private QuantityRepresentation outstandingQuantity;
    /**
     * The reason for the outstanding quantity.
     */
    private TextRepresentation outstandingReason;
    /**
     * The quantity over-supplied, i.e., the quantity over and above that
     * ordered.
     */
    private QuantityRepresentation oversupplyQuantity;
    /**
     * A universally unique identifier for this despatch line.
     */
    private IdentifierRepresentation UUID;
    private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>();
    private List<ItemRepresentation> items = new ArrayList<>();
    private List<OrderLineReferenceRepresentation> orderLineReferences = new ArrayList<>();
    private List<ShipmentRepresentation> shipments = new ArrayList<>();

}
