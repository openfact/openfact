package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.quantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to define a line in a Request for TenderEntity describing an item of
 * goods or a service solicited in the Request for Tender.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:29 a. m.
 */
public class RequestForTenderLineEntity {

    /**
     * The estimated total amount of the deliverable.
     */
    private AmountType estimatedAmount;
    /**
     * An identifier for this request for tender line.
     */
    private IdentifierType ID;
    /**
     * The maximum amount allowed for this deliverable.
     */
    private AmountType maximumAmount;
    /**
     * The maximum quantity of the item associated with this request for tender
     * line.
     */
    private quantityType maximumquantity;
    /**
     * The minimum amount allowed for this deliverable.
     */
    private AmountType minimumAmount;
    /**
     * The minimum quantity of the item associated with this request for tender
     * line.
     */
    private quantityType minimumquantity;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType note;
    /**
     * The quantity of the item for which a tender is requested in this line.
     */
    private quantityType quantity;
    /**
     * Indicates whether the amounts are taxes included (true) or not (false).
     */
    private IndicatorType taxIncludedIndicator;
    /**
     * A universally unique identifier for this request for tender line.
     */
    private IdentifierType UUID;
    private List<DocumentReferenceEntity> documentReferences = new ArrayList<>();
    private List<ItemEntity> items = new ArrayList<>();
    private ItemLocationquantityEntity RequiredItemLocationquantity;
    private PeriodEntity deliveryPeriod;
    private PeriodEntity warrantyValidityPeriod;
    private Request forTenderLineSubRequestForTenderLine;

}
