package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * The consumption in case the consumption is for one and only one supplier.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:58 a. m.
 */
public class SupplierConsumption {

    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private String Description;
    private List<Consumption> consumptions = new ArrayList<>();
    private List<ConsumptionLine> consumptionLines = new ArrayList<>();
    private List<Contract> contracts = new ArrayList<>();
    private Party UtilityCustomerParty;
    private Party UtilitySupplierParty;

    /**
     * @return the description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        Description = description;
    }

    /**
     * @return the consumptions
     */
    public List<Consumption> getConsumptions() {
        return consumptions;
    }

    /**
     * @param consumptions
     *            the consumptions to set
     */
    public void setConsumptions(List<Consumption> consumptions) {
        this.consumptions = consumptions;
    }

    /**
     * @return the consumptionLines
     */
    public List<ConsumptionLine> getConsumptionLines() {
        return consumptionLines;
    }

    /**
     * @param consumptionLines
     *            the consumptionLines to set
     */
    public void setConsumptionLines(List<ConsumptionLine> consumptionLines) {
        this.consumptionLines = consumptionLines;
    }

    /**
     * @return the contracts
     */
    public List<Contract> getContracts() {
        return contracts;
    }

    /**
     * @param contracts
     *            the contracts to set
     */
    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    /**
     * @return the utilityCustomerParty
     */
    public Party getUtilityCustomerParty() {
        return UtilityCustomerParty;
    }

    /**
     * @param utilityCustomerParty
     *            the utilityCustomerParty to set
     */
    public void setUtilityCustomerParty(Party utilityCustomerParty) {
        UtilityCustomerParty = utilityCustomerParty;
    }

    /**
     * @return the utilitySupplierParty
     */
    public Party getUtilitySupplierParty() {
        return UtilitySupplierParty;
    }

    /**
     * @param utilitySupplierParty
     *            the utilitySupplierParty to set
     */
    public void setUtilitySupplierParty(Party utilitySupplierParty) {
        UtilitySupplierParty = utilitySupplierParty;
    }

}// end Supplier Consumption