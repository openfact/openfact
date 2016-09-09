package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;

/**
 * A class to describe the consumption of a utility.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:45 a. m.
 */
public class ConsumptionEntity {

    /**
     * A code identifying the type of the UtilityStatementEntity required for
     * this consumption. Explains the kind of utility the statement is about,
     * e.g.. "gas", "electricity", "telephone"
     */
    private CodeType UtilityStatementTypeCode;
    private List<AllowanceChargeEntity> AllowanceCharges = new ArrayList<>();
    private List<EnergyWaterSupplyEntity> EnergyWaterSupplies = new ArrayList<>();
    private MonetaryTotalEntity LegalMonetaryTotal;
    private PeriodEntity MainPeriod;
    private List<TaxTotalEntity> TaxTotals = new ArrayList<>();
    private List<TelecommunicationsSupplyEntity> TelecommunicationsSupplies = new ArrayList<>();

}
