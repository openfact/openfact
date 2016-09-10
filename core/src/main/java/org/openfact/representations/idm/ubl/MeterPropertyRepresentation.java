package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.CodeType;
import org.openfact.representations.idm.ubl.type.NameType;
import org.openfact.representations.idm.ubl.type.QuantityType;
import org.openfact.representations.idm.ubl.type.TextType;

/**
 * The name of this meter property.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:08 a. m.
 */
public class MeterPropertyRepresentation {

    /**
     * The name of this meter property, expressed as a code.
     */
    private NameType name;
    /**
     * The value of this meter property, expressed as text.
     */
    private CodeType nameCode;
    /**
     * The value of this meter property, expressed as a quantity.
     */
    private TextType value;
    /**
     * An additional value to qualify the value of the meter
     */
    private TextType valueQualifier;
    /**
     * The value of this meter property, expressed as a quantity.
     */
    private QuantityType valueQuantity;

}
