package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.IdentifierType;
import org.openfact.representations.idm.ubl.type.QuantityType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * The consumption for a specific party for given consumption point provided by
 * a numbers of suppliers. An enterprise can have one utility statement for
 * several parties (e.g. a ministry of defence receiving a telephone bill). In
 * this way each subscriber cons
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:57 a. m.
 */
public class SubscriberConsumptionRepresentation {

    /**
     * The identifier tor this specification.
     */
    private IdentifierType consumptionID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType note;
    /**
     * The code which specifies the type of this specification, e.g. an on
     * account specification or the yearly specification.
     */
    private CodeType specificationTypeCode;
    /**
     * The total quantity consumed, as calculated from meter readings.
     */
    private QuantityType totalMeteredQuantity;
    private List<ConsumptionRepresentation> consumptions = new ArrayList<>();
    private ConsumptionPointRepresentation utilityConsumptionPoint;
    private List<OnAccountPaymentRepresentation> onAccountPayments = new ArrayList<>();
    private PartyRepresentation subscriberParty;
    private List<SupplierConsumptionRepresentation> supplierconsumptions = new ArrayList<>();

}
