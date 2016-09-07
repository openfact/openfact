package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe a line item.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:55 a. m.
 */
public class LineItem {

	/**
	 * The buyer's accounting cost centre for this line item, expressed as text.
	 */
	private String accountingCost;
	/**
	 * The buyer's accounting cost centre for this line item, expressed as a
	 * code.
	 */
	private String accountingCostCode;
	/**
	 * An indicator that back order is allowed (true) or not (false).
	 */
	private boolean backOrderAllowedIndicator;
	/**
	 * An identifier for this line item, assigned by the buyer.
	 */
	private String id;
	/**
	 * A code signifying the inspection requirements for the item associated
	 * with this line item.
	 */
	private String inspectionMethodCode;
	/**
	 * The total amount for this line item, including allowance charges but net
	 * of taxes.
	 */
	private BigDecimal lineExtensionAmount;
	/**
	 * A code signifying the status of this line item with respect to its
	 * original state.
	 */
	private String lineStatusCode;
	/**
	 * The maximum back order quantity of the item associated with this line
	 * (where back order is allowed).
	 */
	private BigDecimal maximumBackorderQuantity;
	/**
	 * The maximum quantity of the item associated with this line.
	 */
	private BigDecimal maximumQuantity;
	/**
	 * The minimum back order quantity of the item associated with this line
	 * (where back order is allowed).
	 */
	private BigDecimal minimumBackorderQuantity;
	/**
	 * The minimum quantity of the item associated with this line.
	 */
	private BigDecimal minimumQuantity;
	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	private String note;
	/**
	 * An indicator that a partial delivery is allowed (true) or not (false).
	 */
	private boolean partialDeliveryIndicator;
	/**
	 * The quantity of items associated with this line item.
	 */
	private BigDecimal quantity;
	/**
	 * An identifier for this line item, assigned by the seller.
	 */
	private String salesOrderID;
	/**
	 * The total tax amount for this line item.
	 */
	private BigDecimal totalTaxAmount;
	/**
	 * A universally unique identifier for this line item.
	 */
	private String UUID;
	/**
	 * Text describing a warranty (provided by WarrantyParty) for the good or
	 * service described in this line item.
	 */
	private String warrantyInformation;
	private List<AllowanceCharge> allowanceCharges = new ArrayList<>();
	private List<Delivery> deliveries = new ArrayList<>();
	private List<DeliveryTerms> deliveryTerms = new ArrayList<>(); 
	private List<Item> items = new ArrayList<>();
	private LineItem subLineItem;
	private List<LineReference> lineReferences=new ArrayList<>();
	private Party originatorParty;
	private Party warrantyParty;
	private Period warrantyValidityPeriod;
	private List<OrderedShipment> orderedShipments=new ArrayList<>();
	private List<Price> prices = new ArrayList<>();
	private PriceExtension iItemPriceExtension;
	private List<PricingReference> pricingeferences=new ArrayList<>();
	private List<TaxTotal> taxTotals = new ArrayList<>();

	public LineItem() {

	}

	public void finalize() throws Throwable {

	}

	public String getAccountingCost() {
		return accountingCost;
	}

	public void setAccountingCost(String accountingCost) {
		this.accountingCost = accountingCost;
	}

	public String getAccountingCostCode() {
		return accountingCostCode;
	}

	public void setAccountingCostCode(String accountingCostCode) {
		this.accountingCostCode = accountingCostCode;
	}

	public boolean isBackOrderAllowedIndicator() {
		return backOrderAllowedIndicator;
	}

	public void setBackOrderAllowedIndicator(boolean backOrderAllowedIndicator) {
		this.backOrderAllowedIndicator = backOrderAllowedIndicator;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInspectionMethodCode() {
		return inspectionMethodCode;
	}

	public void setInspectionMethodCode(String inspectionMethodCode) {
		this.inspectionMethodCode = inspectionMethodCode;
	}

	public BigDecimal getLineExtensionAmount() {
		return lineExtensionAmount;
	}

	public void setLineExtensionAmount(BigDecimal lineExtensionAmount) {
		this.lineExtensionAmount = lineExtensionAmount;
	}

	public String getLineStatusCode() {
		return lineStatusCode;
	}

	public void setLineStatusCode(String lineStatusCode) {
		this.lineStatusCode = lineStatusCode;
	}

	public BigDecimal getMaximumBackorderQuantity() {
		return maximumBackorderQuantity;
	}

	public void setMaximumBackorderQuantity(BigDecimal maximumBackorderQuantity) {
		this.maximumBackorderQuantity = maximumBackorderQuantity;
	}

	public BigDecimal getMaximumQuantity() {
		return maximumQuantity;
	}

	public void setMaximumQuantity(BigDecimal maximumQuantity) {
		this.maximumQuantity = maximumQuantity;
	}

	public BigDecimal getMinimumBackorderQuantity() {
		return minimumBackorderQuantity;
	}

	public void setMinimumBackorderQuantity(BigDecimal minimumBackorderQuantity) {
		this.minimumBackorderQuantity = minimumBackorderQuantity;
	}

	public BigDecimal getMinimumQuantity() {
		return minimumQuantity;
	}

	public void setMinimumQuantity(BigDecimal minimumQuantity) {
		this.minimumQuantity = minimumQuantity;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public boolean isPartialDeliveryIndicator() {
		return partialDeliveryIndicator;
	}

	public void setPartialDeliveryIndicator(boolean partialDeliveryIndicator) {
		this.partialDeliveryIndicator = partialDeliveryIndicator;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public String getSalesOrderID() {
		return salesOrderID;
	}

	public void setSalesOrderID(String salesOrderID) {
		this.salesOrderID = salesOrderID;
	}

	public BigDecimal getTotalTaxAmount() {
		return totalTaxAmount;
	}

	public void setTotalTaxAmount(BigDecimal totalTaxAmount) {
		this.totalTaxAmount = totalTaxAmount;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String UUID) {
		this.UUID = UUID;
	}

	public String getWarrantyInformation() {
		return warrantyInformation;
	}

	public void setWarrantyInformation(String warrantyInformation) {
		this.warrantyInformation = warrantyInformation;
	}

	public List<AllowanceCharge> getAllowanceCharges() {
		return allowanceCharges;
	}

	public void setAllowanceCharges(List<AllowanceCharge> allowanceCharges) {
		this.allowanceCharges = allowanceCharges;
	}

	public List<Delivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	public List<DeliveryTerms> getDeliveryTerms() {
		return deliveryTerms;
	}

	public void setDeliveryTerms(List<DeliveryTerms> deliveryTerms) {
		this.deliveryTerms = deliveryTerms;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public LineItem getSubLineItem() {
		return subLineItem;
	}

	public void setSubLineItem(LineItem subLineItem) {
		this.subLineItem = subLineItem;
	}

	public List<LineReference> getLineReferences() {
		return lineReferences;
	}

	public void setLineReferences(List<LineReference> lineReferences) {
		this.lineReferences = lineReferences;
	}

	public Party getOriginatorParty() {
		return originatorParty;
	}

	public void setOriginatorParty(Party originatorParty) {
		this.originatorParty = originatorParty;
	}

	public Party getWarrantyParty() {
		return warrantyParty;
	}

	public void setWarrantyParty(Party warrantyParty) {
		this.warrantyParty = warrantyParty;
	}

	public Period getWarrantyValidityPeriod() {
		return warrantyValidityPeriod;
	}

	public void setWarrantyValidityPeriod(Period warrantyValidityPeriod) {
		this.warrantyValidityPeriod = warrantyValidityPeriod;
	}

	public List<OrderedShipment> getOrderedShipments() {
		return orderedShipments;
	}

	public void setOrderedShipments(List<OrderedShipment> orderedShipments) {
		this.orderedShipments = orderedShipments;
	}

	public List<Price> getPrices() {
		return prices;
	}

	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}

	public PriceExtension getiItemPriceExtension() {
		return iItemPriceExtension;
	}

	public void setiItemPriceExtension(PriceExtension iItemPriceExtension) {
		this.iItemPriceExtension = iItemPriceExtension;
	}

	public List<PricingReference> getPricingeferences() {
		return pricingeferences;
	}

	public void setPricingeferences(List<PricingReference> pricingeferences) {
		this.pricingeferences = pricingeferences;
	}

	public List<TaxTotal> getTaxTotals() {
		return taxTotals;
	}

	public void setTaxTotals(List<TaxTotal> taxTotals) {
		this.taxTotals = taxTotals;
	}
}// end Line Item