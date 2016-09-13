package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * The StatementRepresentation of correction, for examples heating correction.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:48 a. m.
 */
public class ConsumptionCorrectionRepresentation {

    /**
     * StatementRepresentation for the actuel heating correction temperature.
     */
    private QuantityRepresentation actualTemperatureReductionQuantity;
    /**
     * Your consumpt for district heating energy.
     */
    private QuantityRepresentation consumptionEnergyQuantity;
    /**
     * Your consumpt for district heating water.
     */
    private QuantityRepresentation consumptionWaterQuantity;
    /**
     * Your correction for heating correction.
     */
    private BigDecimal correctionAmount;
    /**
     * StatementRepresentation for the correction type.
     */
    private TextRepresentation correctionType;
    /**
     * StatementRepresentation at the code for the correction type.
     */
    private CodeRepresentation correctionTypeCode;
    /**
     * Correction per MWH per degree C.
     */
    private BigDecimal correctionUnitAmount;
    /**
     * description related to the corrections.
     */
    private TextRepresentation description;
    /**
     * Deviation from standard heating correction.
     */
    private QuantityRepresentation differenceTemperatureReductionQuantity;
    /**
     * Correction of the gas pressure.
     */
    private QuantityRepresentation gasPressureQuantity;
    /**
     * StatementRepresentation for meter number.
     */
    private TextRepresentation meterNumber;
    /**
     * StatementRepresentation for the standard for heating correction
     * temperature.
     */
    private QuantityRepresentation normalTemperatureReductionQuantity;

}
