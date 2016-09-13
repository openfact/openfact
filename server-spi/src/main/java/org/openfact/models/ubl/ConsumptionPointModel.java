package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to define the point of consumption for a utility, such as a meter.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:53 a. m.
 */
public class ConsumptionPointModel {

    /**
     * Text describing this consumption point.
     */
    private TextModel description;
    /**
     * An identifier for this point of consumption.
     */
    private IdentifierModel ID;
    /**
     * An identifier for the subscriber responsible for the consumption at this
     * consumption point.
     */
    private IdentifierModel subscriberID;
    /**
     * The type of subscriber, expressed as text.
     */
    private TextModel subscriberType;
    /**
     * The type of subscriber, expressed as a code.
     */
    private CodeModel subscriberTypeCode;
    /**
     * The total quantity delivered, calculated at this consumption point.
     */
    private QuantityModel totalDeliveredQuantity;
    private List<AddressModel> addresses = new ArrayList<>();
    private MeterModel utilityMeter;
    private List<WebSiteAccessModel> webSiteAccesses = new ArrayList<>();

}
