package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.QuantityType;

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
    private QuantityType invoicedQuantity;
    /**
     * The monetary amount, including discount, to be charged for this
     * consumption line.
     */
    private BigDecimal lineExtensionAmount;
    /**
     * An identifier for the transaction line on a related document (such as an
     * invoice) that covers this consumption line.
     */
    private IdentifierType parentDocumentLineReferenceID;
    private List<AllowanceChargeEntity> allowanceCharges = new ArrayList<>();
    private List<DeliveryEntity> deliveries = new ArrayList<>();
    private List<PeriodEntity> periods = new ArrayList<>();
    private List<PriceEntity> prices = new ArrayList<>();
    private List<TaxTotalEntity> taxTotals = new ArrayList<>();
    private List<UnstructuredPriceEntity> unstructuredprices = new ArrayList<>();
    private List<UtilityItemEntity> utilityItems = new ArrayList<>();

}
