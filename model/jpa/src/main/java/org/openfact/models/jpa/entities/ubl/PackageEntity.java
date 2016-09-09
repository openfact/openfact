package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.packagingTypeCodeType;
import org.openfact.models.jpa.entities.ublType.quantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class to describe a package.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:21 a. m.
 */
public class PackageEntity {

    /**
     * An identifier for this package.
     */
    private IdentifierType ID;
    /**
     * A code signifying a level of packaging.
     */
    private CodeType packageLevelCode;
    /**
     * A code signifying a type of packaging.
     */
    private packagingTypeCodeType packagingTypeCode;
    /**
     * Text describing the packaging material.
     */
    private TextType packingMaterial;
    /**
     * The quantity of items contained in this package.
     */
    private quantityType quantity;
    /**
     * An indicator that the packaging material is returnable (true) or not
     * (false).
     */
    private IndicatorType returnableMaterialIndicator;
    /**
     * An identifier for use in tracing this package, such as the EPC number
     * used in RFID.
     */
    private IdentifierType traceID;
    private List<DeliveryEntity> deliveries = new ArrayList<>();
    private List<DeliveryUnitEntity> deliveriesUnit = new ArrayList<>();
    private List<DespatchEntity> despatches = new ArrayList<>();
    private DimensionEntity measurementDimension;
    private List<GoodsItemEntity> goodsItems = new ArrayList<>();
    private PackageEntity containedPackage;
    private List<PickupEntity> pickups = new ArrayList<>();
    private TransportEquipmentEntity containingTransportEquipment;

}
