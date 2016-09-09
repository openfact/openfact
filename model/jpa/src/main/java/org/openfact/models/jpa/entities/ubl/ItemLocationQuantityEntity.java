package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.jpa.entities.ublType.IndicatorType;
import org.openfact.models.jpa.entities.ublType.MeasureType;
import org.openfact.models.jpa.entities.ublType.QuantityType;
import org.openfact.models.jpa.entities.ublType.TextType;

/**
 * A class for information about pricing structure, lead time, and location
 * associated with an item.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:47 a. m.
 */
public class ItemLocationQuantityEntity {

    /**
     * An indication that the transported item, as delivered, in the stated
     * quantity to the stated location, is subject to an international
     * regulation concerning the carriage of dangerous goods (true) or not
     * (false).
     */
    private IndicatorType HazardousRiskIndicator;
    /**
     * The lead time, i.e., the time taken from the time at which an item is
     * ordered to the time of its delivery.
     */
    private MeasureType LeadTimeMeasure;
    /**
     * The maximum quantity that can be ordered to qualify for a specific price.
     */
    private QuantityType MaximumQuantity;
    /**
     * The minimum quantity that can be ordered to qualify for a specific price.
     */
    private QuantityType MinimumQuantity;
    /**
     * Text describing trade restrictions on the quantity of this item or on the
     * item itself.
     */
    private TextType TradingRestrictions;
    private AddressEntity ApplicableTerritoryAddress;
    private List<AllowanceChargeEntity> AllowanceCharges = new ArrayList<>();
    private List<DeliveryUnitEntity> DeliveryUnits = new ArrayList<>();
    private List<DependentPriceReferenceEntity> DependentPriceReferences = new ArrayList<>();
    private List<PackageEntity> Packages = new ArrayList<>();
    private List<PriceEntity> Prices = new ArrayList<>();
    private TaxCategoryEntity ApplicableTaxCategory;

}
