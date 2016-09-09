package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.CodeType;
import org.openfact.models.jpa.entities.ublType.IdentifierType;
import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.PackagingTypeCodeType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
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
    private CodeType PackageLevelCode;
    /**
     * A code signifying a type of packaging.
     */
    private PackagingTypeCodeType PackagingTypeCode;
    /**
     * Text describing the packaging material.
     */
    private TextType PackingMaterial;
    /**
     * The quantity of items contained in this package.
     */
    private QuantityType Quantity;
    /**
     * An indicator that the packaging material is returnable (true) or not
     * (false).
     */
    private IndicatorType ReturnableMaterialIndicator;
    /**
     * An identifier for use in tracing this package, such as the EPC number
     * used in RFID.
     */
    private IdentifierType TraceID;
    private List<DeliveryEntity> Deliveries = new ArrayList<>();
    private List<DeliveryUnitEntity> DeliveriesUnit = new ArrayList<>();
    private List<DespatchEntity> Despatches = new ArrayList<>();
    private DimensionEntity MeasurementDimension;
    private List<GoodsItemEntity> GoodsItems = new ArrayList<>();
    private PackageEntity ContainedPackage;
    private List<PickupEntity> Pickups = new ArrayList<>();
    private TransportEquipmentEntity ContainingTransportEquipment;

}
