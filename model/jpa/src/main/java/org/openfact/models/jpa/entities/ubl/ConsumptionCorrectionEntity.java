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
    private QuantityType actualTemperatureReductionQuantity;
    /**
     * Your consumpt for district heating energy.
     */
    private QuantityType consumptionEnergyQuantity;
    /**
     * Your consumpt for district heating water.
     */
    private QuantityType consumptionWaterQuantity;
    /**
     * Your correction for heating correction.
     */
    private AmountType correctionAmount;
    /**
     * StatementEntity for the correction type.
     */
    private TextType correctionType;
    /**
     * StatementEntity at the code for the correction type.
     */
    private CodeType correctionTypeCode;
    /**
     * Correction per MWH per degree C.
     */
    private AmountType correctionUnitAmount;
    /**
     * description related to the corrections.
     */
    private TextType description;
    /**
     * Deviation from standard heating correction.
     */
    private QuantityType differenceTemperatureReductionQuantity;
    /**
     * Correction of the gas pressure.
     */
    private QuantityType gasPressureQuantity;
    /**
     * StatementEntity for meter number.
     */
    private TextType meterNumber;
    /**
     * StatementEntity for the standard for heating correction temperature.
     */
    private QuantityType normalTemperatureReductionQuantity;

}
