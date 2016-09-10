package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a meter and its readings.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:06 a. m.
 */
public class MeterModel {

    /**
     * The factor by which readings of this meter must be multiplied to
     * calculate consumption, expressed as text.
     */
    private TextType meterConstant;
    /**
     * A code signifying the formula to be used in applying the meter constant.
     */
    private CodeType meterConstantCode;
    /**
     * The name of this meter, which serves as an identifier to distinguish a
     * main meter from a submeter.
     */
    private TextType meterName;
    /**
     * The meter number, expressed as text.
     */
    private TextType meterNumber;
    /**
     * The quantity delivered; the total quantity consumed as calculated from
     * the meter readings.
     */
    private QuantityType totalDeliveredQuantity;
    private List<MeterPropertyModel> meterProperties = new ArrayList<>();
    private List<MeterReadingModel> meterReadings = new ArrayList<>();

}
