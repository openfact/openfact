package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a physical attribute.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:48 a. m.
 */
public class PhysicalAttributeModel {

    /**
     * An identifier for this physical attribute.
     */
    private IdentifierType attributeID;
    /**
     * A description of the physical attribute, expressed as text.
     */
    private TextType description;
    /**
     * A description of the physical attribute, expressed as a code.
     */
    private CodeType descriptionCode;
    /**
     * A code signifying the position of this physical attribute.
     */
    private CodeType positionCode;

}
