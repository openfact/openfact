package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to define a line in a Request for TenderRepresentation describing an
 * item of goods or a service solicited in the Request for Tender.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:29 a. m.
 */
public class RequestForTenderLineRepresentation {

    /**
     * The estimated total amount of the deliverable.
     */
    private BigDecimal estimatedAmount;
    /**
     * An identifier for this request for tender line.
     */
    private IdentifierRepresentation ID;
    /**
     * The maximum amount allowed for this deliverable.
     */
    private BigDecimal maximumAmount;
    /**
     * The maximum quantity of the item associated with this request for tender
     * line.
     */
    private QuantityRepresentation maximumQuantity;
    /**
     * The minimum amount allowed for this deliverable.
     */
    private BigDecimal minimumAmount;
    /**
     * The minimum quantity of the item associated with this request for tender
     * line.
     */
    private QuantityRepresentation minimumQuantity;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextRepresentation note;
    /**
     * The quantity of the item for which a tender is requested in this line.
     */
    private QuantityRepresentation quantity;
    /**
     * Indicates whether the amounts are taxes included (true) or not (false).
     */
    private boolean taxIncludedIndicator;
    /**
     * A universally unique identifier for this request for tender line.
     */
    private IdentifierRepresentation UUID;
    private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>();
    private List<ItemRepresentation> items = new ArrayList<>();
    private ItemLocationQuantityRepresentation requiredItemLocationQuantity;
    private PeriodRepresentation deliveryPeriod;
    private PeriodRepresentation warrantyValidityPeriod;
    //private Request forTenderLineSubRequestForTenderLine;

}
