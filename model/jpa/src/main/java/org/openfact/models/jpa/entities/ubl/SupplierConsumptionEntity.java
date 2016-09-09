package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * The consumption in case the consumption is for one and only one supplier.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:58 a. m.
 */
public class SupplierConsumptionEntity {

    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextType Description;
    private List<ConsumptionEntity> Consumptions = new ArrayList<>();
    private List<ConsumptionLineEntity> ConsumptionsLine = new ArrayList<>();
    private List<ContractEntity> Contracts = new ArrayList<>();
    private PartyEntity UtilityCustomerParty;
    private PartyEntity UtilitySupplierParty;

}
