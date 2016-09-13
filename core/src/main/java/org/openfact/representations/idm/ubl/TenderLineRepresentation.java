package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to define a line in a Tender.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:15 a. m.
 */
public class TenderLineRepresentation {

    /**
     * The unit of measure and quantity of the orderable unit.
     */
    private QuantityRepresentation contentUnitQuantity;
    /**
     * An identifier for this tender line.
     */
    private IdentifierRepresentation ID;
    /**
     * The total amount for this tender line, including allowance charges but
     * net of taxes.
     */
    private BigDecimal lineExtensionAmount;
    /**
     * The maximum number of items described in this tender line that can be
     * ordered.
     */
    private QuantityRepresentation maximumOrderQuantity;
    /**
     * The minimum number of items described in this tender line that can be
     * ordered.
     */
    private QuantityRepresentation minimumOrderQuantity;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextRepresentation note;
    /**
     * Text describing a unit in which the item described in this tender line
     * can be ordered.
     */
    private TextRepresentation orderableUnit;
    /**
     * The number of items that can set the order quantity increments.
     */
    private BigDecimal orderQuantityIncrementNumeric;
    /**
     * A mutually agreed code signifying the level of packaging associated with
     * the item described in this tender line.
     */
    private CodeRepresentation packLevelCode;
    /**
     * The quantity of the item quoted in this tender line.
     */
    private QuantityRepresentation quantity;
    /**
     * The total tax amount for this tender line.
     */
    private BigDecimal totalTaxAmount;
    /**
     * Text about a warranty (provided by WarrantyParty) for the good or service
     * described in this tender line.
     */
    private TextRepresentation warrantyInformation;
    private List<DocumentReferenceRepresentation> callForTendersDocumentReference = new ArrayList<>();
    private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>();
    private List<ItemRepresentation> items = new ArrayList<>();
    private ItemLocationQuantityRepresentation offeredItemLocationQuantity;
    private LineReferenceRepresentation callForTendersLineReference;
    private PartyRepresentation warrantyParty;
    private PeriodRepresentation warrantyValidityPeriod;
    private RelatedItemRepresentation replacementRelatedItem;
    private TenderLineRepresentation subTenderLine;

}
