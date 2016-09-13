package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.PackagingTypeCodeRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe a package.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:21 a. m.
 */
public class PackageRepresentation {

    /**
     * An identifier for this package.
     */
    private IdentifierRepresentation ID;
    /**
     * A code signifying a level of packaging.
     */
    private CodeRepresentation packageLevelCode;
    /**
     * A code signifying a type of packaging.
     */
    private PackagingTypeCodeRepresentation packagingTypeCode;
    /**
     * Text describing the packaging material.
     */
    private TextRepresentation packingMaterial;
    /**
     * The quantity of items contained in this package.
     */
    private QuantityRepresentation quantity;
    /**
     * An indicator that the packaging material is returnable (true) or not
     * (false).
     */
    private boolean returnableMaterialIndicator;
    /**
     * An identifier for use in tracing this package, such as the EPC number
     * used in RFID.
     */
    private IdentifierRepresentation traceID;
    private List<DeliveryRepresentation> deliveries = new ArrayList<>();
    private List<DeliveryUnitRepresentation> deliveriesUnit = new ArrayList<>();
    private List<DespatchRepresentation> despatches = new ArrayList<>();
    private DimensionRepresentation measurementDimension;
    private List<GoodsItemRepresentation> goodsItems = new ArrayList<>();
    private PackageRepresentation containedPackage;
    private List<PickupRepresentation> pickups = new ArrayList<>();
    private TransportEquipmentRepresentation containingTransportEquipment;

}
