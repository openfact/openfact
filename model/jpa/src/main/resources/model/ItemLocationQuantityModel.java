package org.openfact.models.jpa.entities.ubl;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class for information about pricing structure, lead time, and location
 * associated with an item.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:47 a. m.
 */
public class ItemLocationQuantityModel{

	/**
	 * An indication that the transported item, as delivered, in the stated quantity
	 * to the stated location, is subject to an international regulation concerning
	 * the carriage of dangerous goods (true) or not (false).
	 */
	private IndicatorType hazardousRiskIndicator; 
	/**
	 * The lead time, i.e., the time taken from the time at which an item is ordered
	 * to the time of its delivery.
	 */
	private MeasureType leadTimeMeasure; 
	/**
	 * The maximum quantity that can be ordered to qualify for a specific price.
	 */
	private QuantityType maximumQuantity; 
	/**
	 * The minimum quantity that can be ordered to qualify for a specific price.
	 */
	private QuantityType minimumQuantity; 
	/**
	 * Text describing trade restrictions on the quantity of this item or on the item
	 * itself.
	 */
	private TextType tradingRestrictions; 
	private AddressModel applicableTerritoryAddress; 
	private List<AllowanceChargeModel> allowanceCharges = new ArrayList<>(); 
	private List<DeliveryUnitModel> deliveryUnits = new ArrayList<>(); 
	private List<DependentPriceReferenceModel> dependentPriceReferences = new ArrayList<>(); 
	private List<PackageModel> packages = new ArrayList<>(); 
	private List<PriceModel> prices = new ArrayList<>(); 
	private TaxCategoryModel applicableTaxCategory; 

}