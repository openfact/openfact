package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;
import org.openfact.models.jpa.entities.ublType.*;

/**
 * A class to describe the supply (and therefore consumption) of an amount of
 * energy or water.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:49 a. m.
 */
public class EnergyWaterSupplyEntity {

	private List<ConsumptionAverageEntity> consumptionAverages = new ArrayList<>();
	private ConsumptionCorrectionEntity energyWaterConsumptionCorrection;
	private List<ConsumptionReportEntity> consumptionReports = new ArrayList<>();
	private List<EnergyTaxReportEntity> energyTaxReports = new ArrayList<>();

}
