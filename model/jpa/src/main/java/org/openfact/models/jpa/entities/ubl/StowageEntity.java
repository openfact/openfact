package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to describe a location on board a means of transport where specified
 * goods or transport equipment have been stowed or are to be stowed.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:54 a. m.
 */
public class StowageEntity {

    /**
     * Text describing the location.
     */
    private TextType location;
    /**
     * An identifier for the location.
     */
    private IdentifierType locationID;
    private DimensionEntity measurementDimension;

}
