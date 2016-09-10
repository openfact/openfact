package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.IdentifierType;

/**
 * A class to associate a time period and locations (activity data) with an item
 * for inventory planning purposes.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:32 a. m.
 */
public class ActivityDataLineRepresentation {

    /**
     * An identifier for this activity data line.
     */
    private IdentifierType ID;
    /**
     * A code signifying the type of supply chain activity.
     */
    private CodeType supplyChainActivityTypeCode;
    private CustomerPartyRepresentation buyerCustomerParty;
    private LocationRepresentation activityOriginLocation;
    private PeriodRepresentation activityPeriod;
    private LocationRepresentation activityFinalLocation;
    private List<SalesItemRepresentation> salesItems = new ArrayList<>();
    private SupplierPartyRepresentation sellerSupplierParty;

}
