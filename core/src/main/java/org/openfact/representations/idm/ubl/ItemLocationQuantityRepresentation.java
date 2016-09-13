package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.MeasureRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class for information about pricing structure, lead time, and location
 * associated with an item.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:47 a. m.
 */
public class ItemLocationQuantityRepresentation {

    /**
     * An indication that the transported item, as delivered, in the stated
     * quantity to the stated location, is subject to an international
     * regulation concerning the carriage of dangerous goods (true) or not
     * (false).
     */
    private boolean hazardousRiskIndicator;
    /**
     * The lead time, i.e., the time taken from the time at which an item is
     * ordered to the time of its delivery.
     */
    private MeasureRepresentation leadTimeMeasure;
    /**
     * The maximum quantity that can be ordered to qualify for a specific price.
     */
    private QuantityRepresentation maximumQuantity;
    /**
     * The minimum quantity that can be ordered to qualify for a specific price.
     */
    private QuantityRepresentation minimumQuantity;
    /**
     * Text describing trade restrictions on the quantity of this item or on the
     * item itself.
     */
    private TextRepresentation tradingRestrictions;
    private AddressRepresentation applicableTerritoryAddress;
    private List<AllowanceChargeRepresentation> allowanceCharges = new ArrayList<>();
    private List<DeliveryUnitRepresentation> deliveryUnits = new ArrayList<>();
    private List<DependentPriceReferenceRepresentation> dependentPriceReferences = new ArrayList<>();
    private List<PackageRepresentation> packages = new ArrayList<>();
    private List<PriceRepresentation> prices = new ArrayList<>();
    private TaxCategoryRepresentation applicableTaxCategory;

}
