package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.lineStatusCodeType;
import org.openfact.models.jpa.entities.ublType.quantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe a line item.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:55 a. m.
 */
public class LineItemEntity {

    /**
     * The buyer's accounting cost centre for this line item, expressed as text.
     */
    private TextType accountingCost;
    /**
     * The buyer's accounting cost centre for this line item, expressed as a
     * code.
     */
    private CodeType accountingCostCode;
    /**
     * An indicator that back order is allowed (true) or not (false).
     */
    private IndicatorType backOrderAllowedIndicator;
    /**
     * An identifier for this line item, assigned by the buyer.
     */
    private IdentifierType ID;
    /**
     * A code signifying the inspection requirements for the item associated
     * with this line item.
     */
    private CodeType inspectionMethodCode;
    /**
     * The total amount for this line item, including allowance charges but net
     * of taxes.
     */
    private AmountType lineExtensionAmount;
    /**
     * A code signifying the status of this line item with respect to its
     * original state.
     */
    private lineStatusCodeType lineStatusCode;
    /**
     * The maximum back order quantity of the item associated with this line
     * (where back order is allowed).
     */
    private quantityType maximumBackorderquantity;
    /**
     * The maximum quantity of the item associated with this line.
     */
    private quantityType maximumquantity;
    /**
     * The minimum back order quantity of the item associated with this line
     * (where back order is allowed).
     */
    private quantityType minimumBackorderquantity;
    /**
     * The minimum quantity of the item associated with this line.
     */
    private quantityType minimumquantity;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType note;
    /**
     * An indicator that a partial delivery is allowed (true) or not (false).
     */
    private IndicatorType partialDeliveryIndicator;
    /**
     * The quantity of items associated with this line item.
     */
    private quantityType quantity;
    /**
     * An identifier for this line item, assigned by the seller.
     */
    private IdentifierType salesOrderID;
    /**
     * The total tax amount for this line item.
     */
    private AmountType totalTaxAmount;
    /**
     * A universally unique identifier for this line item.
     */
    private IdentifierType UUID;
    /**
     * Text describing a warranty (provided by warrantyParty) for the good or
     * service described in this line item.
     */
    private TextType warrantyInformation;
    private List<AllowanceChargeEntity> allowanceCharges = new ArrayList<>();
    private List<DeliveryEntity> deliveries = new ArrayList<>();
    private List<DeliveryTermsEntity> deliveriesTerms = new ArrayList<>();
    private List<ItemEntity> items = new ArrayList<>();
    private LineItemEntity subLineItem;
    private List<LineReferenceEntity> lineReferences = new ArrayList<>();
    private PartyEntity originatorParty;
    private PartyEntity warrantyParty;
    private PeriodEntity warrantyValidityPeriod;
    private List<OrderedShipmentEntity> orderedShipments = new ArrayList<>();
    private List<PriceEntity> prices = new ArrayList<>();
    private PriceExtensionEntity itemPriceExtension;
    private List<PricingReferenceEntity> pricingReferences = new ArrayList<>();
    private List<TaxTotalEntity> taxTotals = new ArrayList<>();

}
