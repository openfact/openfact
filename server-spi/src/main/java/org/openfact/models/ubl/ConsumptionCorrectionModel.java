package org.openfact.models.ubl;

import java.math.BigDecimal;

import org.openfact.models.ubl.type.*;

/**
 * The StatementModel of correction, for examples heating correction.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:48 a. m.
 */
public class ConsumptionCorrectionModel {

    /**
     * StatementModel for the actuel heating correction temperature.
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
    private BigDecimal correctionAmount;
    /**
     * StatementModel for the correction type.
     */
    private TextType correctionType;
    /**
     * StatementModel at the code for the correction type.
     */
    private CodeType correctionTypeCode;
    /**
     * Correction per MWH per degree C.
     */
    private BigDecimal correctionUnitAmount;
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
     * StatementModel for meter number.
     */
    private TextType meterNumber;
    /**
     * StatementModel for the standard for heating correction temperature.
     */
    private QuantityType normalTemperatureReductionQuantity;

}
