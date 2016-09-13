package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to define a line in a DespatchAdvice.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:29 a. m.
 */
public class DespatchLineModel {

    /**
     * The quantity on back order at the supplier.
     */
    private QuantityModel backorderQuantity;
    /**
     * The reason for the back order.
     */
    private TextModel backorderReason;
    /**
     * The quantity despatched (picked up).
     */
    private QuantityModel deliveredQuantity;
    /**
     * An identifier for this despatch line.
     */
    private IdentifierModel ID;
    /**
     * A code signifying the status of this despatch line with respect to its
     * original state.
     */
    private LineStatusCodeModel lineStatusCode;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextModel note;
    /**
     * The quantity outstanding (which will follow in a later despatch).
     */
    private QuantityModel outstandingQuantity;
    /**
     * The reason for the outstanding quantity.
     */
    private TextModel outstandingReason;
    /**
     * The quantity over-supplied, i.e., the quantity over and above that
     * ordered.
     */
    private QuantityModel oversupplyQuantity;
    /**
     * A universally unique identifier for this despatch line.
     */
    private IdentifierModel UUID;
    private List<DocumentReferenceModel> documentReferences = new ArrayList<>();
    private List<ItemModel> items = new ArrayList<>();
    private List<OrderLineReferenceModel> orderLineReferences = new ArrayList<>();
    private List<ShipmentModel> shipments = new ArrayList<>();

}
