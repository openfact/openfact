package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to describe the supply (and therefore consumption) of an amount of
 * energy or water.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:49 a. m.
 */
public class EnergyWaterSupplyModel {

    private List<ConsumptionAverageModel> consumptionAverages = new ArrayList<>();
    private ConsumptionCorrectionModel energyWaterConsumptionCorrection;
    private List<ConsumptionReportModel> consumptionReports = new ArrayList<>();
    private List<EnergyTaxReportModel> energyTaxReports = new ArrayList<>();

}
