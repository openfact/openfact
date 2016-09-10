package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.TextType;

/**
 * The consumption in case the consumption is for one and only one supplier.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:58 a. m.
 */
public class SupplierConsumptionRepresentation {

    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType description;
    private List<ConsumptionRepresentation> consumptions = new ArrayList<>();
    private List<ConsumptionLineRepresentation> consumptionsLine = new ArrayList<>();
    private List<ContractRepresentation> contracts = new ArrayList<>();
    private PartyRepresentation utilityCustomerParty;
    private PartyRepresentation utilitySupplierParty;

}
