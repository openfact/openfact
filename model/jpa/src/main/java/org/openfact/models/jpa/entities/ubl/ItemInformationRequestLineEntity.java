package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;

/**
 * A class to define a line in an ItemInformationRequestEntity asking a trading
 * partner for item information.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:44 a. m.
 */
public class ItemInformationRequestLineEntity {

    /**
     * The information request can be either about supply chain activity or
     * about forecasts or about performance metrics, so it should be optional
     */
    private CodeType forecastTypeCode;
    /**
     * A code signifying a measure of performance.
     */
    private CodeType performanceMetricTypeCode;
    /**
     * A code used to identify the type of supply chain activity about which
     * information request is issued. Examples: CANCELED_ORDERS EMERGENCY_ORDERS
     * ON_HAND ORDERS
     */
    private CodeType supplyChainActivityTypeCode;
    /**
     * A code signifying the frequency with which item information should be
     * sent to the requester.
     */
    private CodeType timeFrequencyCode;
    private List<PeriodEntity> periods = new ArrayList<>();
    private List<SalesItemEntity> salesItems = new ArrayList<>();

}
