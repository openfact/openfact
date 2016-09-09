package adapter;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe the supply (and therefore consumption) of an amount of
 * energy or water.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:49 a. m.
 */
public class EnergyWaterSupplyAdapter{

	private List<ConsumptionAverageAdapter> ConsumptionAverages = new ArrayList<>();
	private ConsumptionCorrectionAdapter EnergyWaterConsumptionCorrection;
	private List<ConsumptionReportAdapter> ConsumptionReports = new ArrayList<>();
	private List<EnergyTaxReportAdapter> EnergyTaxReports = new ArrayList<>();

}
