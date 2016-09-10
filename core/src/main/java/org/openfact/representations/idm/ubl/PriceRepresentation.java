package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.QuantityType;
import org.openfact.representations.idm.ubl.type.RateType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * A class to describe a price, expressed in a data structure containing
 * multiple properties (compare with UnstructuredPrice).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:52 a. m.
 */
public class PriceRepresentation {

    /**
     * The quantity at which this price applies.
     */
    private QuantityType baseQuantity;
    /**
     * The factor by which the base price unit can be converted to the orderable
     * unit.
     */
    private RateType orderableUnitFactorRate;
    /**
     * The amount of the price.
     */
    private BigDecimal priceAmount;
    /**
     * A reason for a price change.
     */
    private TextType priceChangeReason;
    /**
     * The type of price, expressed as text.
     */
    private TextType priceType;
    /**
     * The type of price, expressed as a code.
     */
    private CodeType priceTypeCode;
    private List<AllowanceChargeRepresentation> allowanceCharges = new ArrayList<>();
    private ExchangeRateRepresentation pricingExchangeRate;
    private PeriodRepresentation validityPeriod;
    private List<PriceListRepresentation> priceLists = new ArrayList<>();

}
