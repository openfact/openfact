package org.openfact.representations.idm.ubl;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe a physical attribute.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:16:48 a. m.
 */
public class PhysicalAttributeRepresentation {

    /**
     * An identifier for this physical attribute.
     */
    private IdentifierRepresentation attributeID;
    /**
     * A description of the physical attribute, expressed as text.
     */
    private TextRepresentation description;
    /**
     * A description of the physical attribute, expressed as a code.
     */
    private CodeRepresentation descriptionCode;
    /**
     * A code signifying the position of this physical attribute.
     */
    private CodeRepresentation positionCode;

}
