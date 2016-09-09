package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

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
public class SubscriberConsumptionEntity {

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
    private List<ConsumptionEntity> consumptions = new ArrayList<>();
    private ConsumptionPointEntity utilityConsumptionPoint;
    private List<OnAccountPaymentEntity> onAccountPayments = new ArrayList<>();
    private PartyEntity subscriberParty;
    private List<SupplierConsumptionEntity> Supplierconsumptions = new ArrayList<>();

}
