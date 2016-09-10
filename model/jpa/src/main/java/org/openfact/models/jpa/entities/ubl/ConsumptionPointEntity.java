package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.QuantityType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to define the point of consumption for a utility, such as a meter.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:53 a. m.
 */
public class ConsumptionPointEntity {

    /**
     * Text describing this consumption point.
     */
    private TextType description;
    /**
     * An identifier for this point of consumption.
     */
    private IdentifierType ID;
    /**
     * An identifier for the subscriber responsible for the consumption at this
     * consumption point.
     */
    private IdentifierType subscriberID;
    /**
     * The type of subscriber, expressed as text.
     */
    private TextType subscriberType;
    /**
     * The type of subscriber, expressed as a code.
     */
    private CodeType subscriberTypeCode;
    /**
     * The total quantity delivered, calculated at this consumption point.
     */
    private QuantityType totalDeliveredQuantity;
    private List<AddressEntity> addresses = new ArrayList<>();
    private MeterEntity utilityMeter;
    private List<WebSiteAccessEntity> webSiteAccesses = new ArrayList<>();

}
