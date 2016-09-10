package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * The consumption in case the consumption is for one and only one supplier.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:58 a. m.
 */
public class SupplierConsumptionModel {

    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType description;
    private List<ConsumptionModel> consumptions = new ArrayList<>();
    private List<ConsumptionLineModel> consumptionsLine = new ArrayList<>();
    private List<ContractModel> contracts = new ArrayList<>();
    private PartyModel utilityCustomerParty;
    private PartyModel utilitySupplierParty;

}
