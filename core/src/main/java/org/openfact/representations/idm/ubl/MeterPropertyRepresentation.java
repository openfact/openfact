package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.NameRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

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
    private NameRepresentation name;
    /**
     * The value of this meter property, expressed as text.
     */
    private CodeRepresentation nameCode;
    /**
     * The value of this meter property, expressed as a quantity.
     */
    private TextRepresentation value;
    /**
     * An additional value to qualify the value of the meter
     */
    private TextRepresentation valueQualifier;
    /**
     * The value of this meter property, expressed as a quantity.
     */
    private QuantityRepresentation valueQuantity;

}
