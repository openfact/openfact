package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.IdentifierType;

/**
 * A class for assigning identifying information to an item.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:42 a. m.
 */
public class ItemIdentificationEntity {

    /**
     * An identifier for a system of barcodes.
     */
    private IdentifierType barcodeSymbologyID;
    /**
     * An extended identifier for the item that identifies the item with
     * specific properties, e.g., ItemEntity 123 = Chair / ItemEntity 123 Ext 45
     * = brown chair. Two chairs can have the same item number, but one is
     * brown. The other is white.
     */
    private IdentifierType extendedID;
    /**
     * An identifier for the item.
     */
    private IdentifierType ID;
    private DimensionEntity measurementDimension;
    private PartyEntity issuerParty;
    private List<PhysicalAttributeEntity> physicalAttributes = new ArrayList<>();

}
