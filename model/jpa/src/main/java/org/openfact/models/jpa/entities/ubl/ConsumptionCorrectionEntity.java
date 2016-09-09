package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.jpa.entities.ublType.AmountType;
import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * The StatementEntity of correction, for examples heating correction.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:48 a. m.
 */
public class ConsumptionCorrectionEntity {

    /**
     * StatementEntity for the actuel heating correction temperature.
     */
    private QuantityType ActualTemperatureReductionQuantity;
    /**
     * Your consumpt for district heating energy.
     */
    private QuantityType ConsumptionEnergyQuantity;
    /**
     * Your consumpt for district heating water.
     */
    private QuantityType ConsumptionWaterQuantity;
    /**
     * Your correction for heating correction.
     */
    private AmountType CorrectionAmount;
    /**
     * StatementEntity for the correction type.
     */
    private TextType CorrectionType;
    /**
     * StatementEntity at the code for the correction type.
     */
    private CodeType CorrectionTypeCode;
    /**
     * Correction per MWH per degree C.
     */
    private AmountType CorrectionUnitAmount;
    /**
     * Description related to the corrections.
     */
    private TextType Description;
    /**
     * Deviation from standard heating correction.
     */
    private QuantityType DifferenceTemperatureReductionQuantity;
    /**
     * Correction of the gas pressure.
     */
    private QuantityType GasPressureQuantity;
    /**
     * StatementEntity for meter number.
     */
    private TextType MeterNumber;
    /**
     * StatementEntity for the standard for heating correction temperature.
     */
    private QuantityType NormalTemperatureReductionQuantity;

}
