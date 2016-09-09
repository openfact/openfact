package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.QuantityType;

/**
 * A class to describe a line item for utility consumption. To specify more than
 * one utility item, use separate consumption lines.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:52 a. m.
 */
public class ConsumptionLineEntity {

    /**
     * An identifier for this consumption line.
     */
    private IdentifierType ID;
    /**
     * The quantity invoiced.
     */
    private QuantityType InvoicedQuantity;
    /**
     * The monetary amount, including discount, to be charged for this
     * consumption line.
     */
    private AmountType LineExtensionAmount;
    /**
     * An identifier for the transaction line on a related document (such as an
     * invoice) that covers this consumption line.
     */
    private IdentifierType ParentDocumentLineReferenceID;
    private List<AllowanceChargeEntity> AllowanceCharges = new ArrayList<>();
    private List<DeliveryEntity> Deliveries = new ArrayList<>();
    private List<PeriodEntity> Periods = new ArrayList<>();
    private List<PriceEntity> Prices = new ArrayList<>();
    private List<TaxTotalEntity> TaxTotals = new ArrayList<>();
    private List<UnstructuredPriceEntity> UnstructuredPrices = new ArrayList<>();
    private List<UtilityItemEntity> UtilityItems = new ArrayList<>();

}
