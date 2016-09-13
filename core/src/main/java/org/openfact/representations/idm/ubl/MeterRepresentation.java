package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe a meter and its readings.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:06 a. m.
 */
public class MeterRepresentation {

    /**
     * The factor by which readings of this meter must be multiplied to
     * calculate consumption, expressed as text.
     */
    private TextRepresentation meterConstant;
    /**
     * A code signifying the formula to be used in applying the meter constant.
     */
    private CodeRepresentation meterConstantCode;
    /**
     * The name of this meter, which serves as an identifier to distinguish a
     * main meter from a submeter.
     */
    private TextRepresentation meterName;
    /**
     * The meter number, expressed as text.
     */
    private TextRepresentation meterNumber;
    /**
     * The quantity delivered; the total quantity consumed as calculated from
     * the meter readings.
     */
    private QuantityRepresentation totalDeliveredQuantity;
    private List<MeterPropertyRepresentation> meterProperties = new ArrayList<>();
    private List<MeterReadingRepresentation> meterReadings = new ArrayList<>();

}
