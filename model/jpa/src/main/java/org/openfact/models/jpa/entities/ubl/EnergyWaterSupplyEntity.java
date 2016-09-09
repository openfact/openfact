package org.openfact.models.jpa.entities.ubl;

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
public class EnergyWaterSupplyEntity {

    private List<ConsumptionAverageEntity> ConsumptionAverages = new ArrayList<>();
    private ConsumptionCorrectionEntity EnergyWaterConsumptionCorrection;
    private List<ConsumptionReportEntity> ConsumptionReports = new ArrayList<>();
    private List<EnergyTaxReportEntity> EnergyTaxReports = new ArrayList<>();

}
