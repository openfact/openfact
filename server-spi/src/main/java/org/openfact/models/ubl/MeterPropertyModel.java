package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;

/**
 * The name of this meter property.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:08 a. m.
 */
public class MeterPropertyModel {

    /**
     * The name of this meter property, expressed as a code.
     */
    private NameModel name;
    /**
     * The value of this meter property, expressed as text.
     */
    private CodeModel nameCode;
    /**
     * The value of this meter property, expressed as a quantity.
     */
    private TextModel value;
    /**
     * An additional value to qualify the value of the meter
     */
    private TextModel valueQualifier;
    /**
     * The value of this meter property, expressed as a quantity.
     */
    private QuantityModel valueQuantity;

}
