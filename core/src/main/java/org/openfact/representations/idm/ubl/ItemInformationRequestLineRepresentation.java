package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;

/**
 * A class to define a line in an ItemInformationRequestRepresentation asking a
 * trading partner for item information.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:44 a. m.
 */
public class ItemInformationRequestLineRepresentation {

    /**
     * The information request can be either about supply chain activity or
     * about forecasts or about performance metrics, so it should be optional
     */
    private CodeRepresentation forecastTypeCode;
    /**
     * A code signifying a measure of performance.
     */
    private CodeRepresentation performanceMetricTypeCode;
    /**
     * A code used to identify the type of supply chain activity about which
     * information request is issued. Examples: CANCELED_ORDERS EMERGENCY_ORDERS
     * ON_HAND ORDERS
     */
    private CodeRepresentation supplyChainActivityTypeCode;
    /**
     * A code signifying the frequency with which item information should be
     * sent to the requester.
     */
    private CodeRepresentation timeFrequencyCode;
    private List<PeriodRepresentation> periods = new ArrayList<>();
    private List<SalesItemRepresentation> salesItems = new ArrayList<>();

}
