package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.RateType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe a price, expressed in a data structure containing
 * multiple properties (compare with UnstructuredPrice).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:52 a. m.
 */
public class PriceEntity {

    /**
     * The quantity at which this price applies.
     */
    private QuantityType BaseQuantity;
    /**
     * The factor by which the base price unit can be converted to the orderable
     * unit.
     */
    private RateType OrderableUnitFactorRate;
    /**
     * The amount of the price.
     */
    private AmountType PriceAmount;
    /**
     * A reason for a price change.
     */
    private TextType PriceChangeReason;
    /**
     * The type of price, expressed as text.
     */
    private TextType PriceType;
    /**
     * The type of price, expressed as a code.
     */
    private CodeType PriceTypeCode;
    private List<AllowanceChargeEntity> AllowanceCharges = new ArrayList<>();
    private ExchangeRateEntity PricingExchangeRate;
    private PeriodEntity ValidityPeriod;
    private List<PriceListEntity> PriceLists = new ArrayList<>();

}
