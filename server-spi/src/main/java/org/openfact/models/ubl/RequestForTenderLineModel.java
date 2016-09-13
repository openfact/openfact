package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to define a line in a Request for TenderModel describing an item of
 * goods or a service solicited in the Request for Tender.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:29 a. m.
 */
public class RequestForTenderLineModel {

    /**
     * The estimated total amount of the deliverable.
     */
    private BigDecimal estimatedAmount;
    /**
     * An identifier for this request for tender line.
     */
    private IdentifierModel ID;
    /**
     * The maximum amount allowed for this deliverable.
     */
    private BigDecimal maximumAmount;
    /**
     * The maximum quantity of the item associated with this request for tender
     * line.
     */
    private QuantityModel maximumQuantity;
    /**
     * The minimum amount allowed for this deliverable.
     */
    private BigDecimal minimumAmount;
    /**
     * The minimum quantity of the item associated with this request for tender
     * line.
     */
    private QuantityModel minimumQuantity;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextModel note;
    /**
     * The quantity of the item for which a tender is requested in this line.
     */
    private QuantityModel quantity;
    /**
     * Indicates whether the amounts are taxes included (true) or not (false).
     */
    private boolean taxIncludedIndicator;
    /**
     * A universally unique identifier for this request for tender line.
     */
    private IdentifierModel UUID;
    private List<DocumentReferenceModel> documentReferences = new ArrayList<>();
    private List<ItemModel> items = new ArrayList<>();
    private ItemLocationQuantityModel requiredItemLocationQuantity;
    private PeriodModel deliveryPeriod;
    private PeriodModel warrantyValidityPeriod;
    //private Request forTenderLineSubRequestForTenderLine;

}
