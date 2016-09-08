package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to define a line in a Catalogue describing a purchasable item.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:19 a. m.
 */
public class CatalogueLine {

	/**
	 * A code signifying the action required to synchronize this catalogue line.
	 * Recommend codes (delete, update, add)
	 */
	private String actionCode;
	/**
	 * The numeric quantity of the ordering unit (and units of measure) of the
	 * catalogue line.
	 */
	private BigDecimal contentUnitQuantity;
	/**
	 * A subdivision of a contract or tender covering this catalogue line.
	 */
	private String contractSubdivision;
	/**
	 * An identifier for the line in the catalogue.
	 */
	private String id;
	/**
	 * A code signifying the life cycle status of this catalogue line. Examples
	 * are pre-order, end of production
	 */
	private String lifeCycleStatusCode;
	/**
	 * The maximum amount of the item described in this catalogue line that can
	 * be ordered.
	 */
	private BigDecimal maximumOrderQuantity;
	/**
	 * The minimum amount of the item described in this catalogue line that can
	 * be ordered.
	 */
	private BigDecimal minimumOrderQuantity;
	/**
	 * Free-form text conveying information that is not contained explicitly in
	 * other structures.
	 */
	private String note;
	/**
	 * An indicator that this catalogue line describes an orderable item (true)
	 * or is included for reference purposes only (false).
	 */
	private boolean orderableIndicator;
	/**
	 * A textual description of the units in which the item described in this
	 * catalogue line can be ordered.
	 */
	private String orderableUnit;
	/**
	 * The number of items that can set the order quantity increments.
	 */
	private BigDecimal orderQuantityIncrementNumeric;
	/**
	 * A mutually agreed code signifying the level of packaging associated with
	 * the item described in this catalogue line.
	 */
	private String packLevelCode;
	/**
	 * Text about a warranty (provided by WarrantyParty) for the good or service
	 * described in this catalogue line.
	 */
	private String warrantyInformation;
	private CustomerParty contractorCustomerParty;
	private DocumentReference callForTendersDocumentReference;
	private List<DocumentReference> documentReferences= new ArrayList<>();
	private List<Item> items= new ArrayList<>();
	private List<ItemComparison> itemComparisons= new ArrayList<>();
	private ItemLocationQuantity requiredItemLocationQuantity;
	private ItemProperty keywordItemProperty;
	private LineReference callForTendersLineReference;
	private Party warrantyParty;
	private Period warrantyValidityPeriod;
	private Period lineValidityPeriod;
	private RelatedItem componentRelatedItem;
	private RelatedItem replacedRelatedItem;
	private RelatedItem complementaryRelatedItem;
	private RelatedItem replacementRelatedItem;
	private RelatedItem accessoryRelatedItem;
	private RelatedItem requiredRelatedItem;
	private SupplierParty sellerSupplierParty;

	public CatalogueLine() {

	}

	public void finalize() throws Throwable {

	}

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	public BigDecimal getContentUnitQuantity() {
		return contentUnitQuantity;
	}

	public void setContentUnitQuantity(BigDecimal contentUnitQuantity) {
		this.contentUnitQuantity = contentUnitQuantity;
	}

	public String getContractSubdivision() {
		return contractSubdivision;
	}

	public void setContractSubdivision(String contractSubdivision) {
		this.contractSubdivision = contractSubdivision;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLifeCycleStatusCode() {
		return lifeCycleStatusCode;
	}

	public void setLifeCycleStatusCode(String lifeCycleStatusCode) {
		this.lifeCycleStatusCode = lifeCycleStatusCode;
	}

	public BigDecimal getMaximumOrderQuantity() {
		return maximumOrderQuantity;
	}

	public void setMaximumOrderQuantity(BigDecimal maximumOrderQuantity) {
		this.maximumOrderQuantity = maximumOrderQuantity;
	}

	public BigDecimal getMinimumOrderQuantity() {
		return minimumOrderQuantity;
	}

	public void setMinimumOrderQuantity(BigDecimal minimumOrderQuantity) {
		this.minimumOrderQuantity = minimumOrderQuantity;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public boolean isOrderableIndicator() {
		return orderableIndicator;
	}

	public void setOrderableIndicator(boolean orderableIndicator) {
		this.orderableIndicator = orderableIndicator;
	}

	public String getOrderableUnit() {
		return orderableUnit;
	}

	public void setOrderableUnit(String orderableUnit) {
		this.orderableUnit = orderableUnit;
	}

	public BigDecimal getOrderQuantityIncrementNumeric() {
		return orderQuantityIncrementNumeric;
	}

	public void setOrderQuantityIncrementNumeric(BigDecimal orderQuantityIncrementNumeric) {
		this.orderQuantityIncrementNumeric = orderQuantityIncrementNumeric;
	}

	public String getPackLevelCode() {
		return packLevelCode;
	}

	public void setPackLevelCode(String packLevelCode) {
		this.packLevelCode = packLevelCode;
	}

	public String getWarrantyInformation() {
		return warrantyInformation;
	}

	public void setWarrantyInformation(String warrantyInformation) {
		this.warrantyInformation = warrantyInformation;
	}

	public CustomerParty getContractorCustomerParty() {
		return contractorCustomerParty;
	}

	public void setContractorCustomerParty(CustomerParty contractorCustomerParty) {
		this.contractorCustomerParty = contractorCustomerParty;
	}

	public DocumentReference getCallForTendersDocumentReference() {
		return callForTendersDocumentReference;
	}

	public void setCallForTendersDocumentReference(DocumentReference callForTendersDocumentReference) {
		this.callForTendersDocumentReference = callForTendersDocumentReference;
	}

	public List<DocumentReference> getDocumentReferences() {
		return documentReferences;
	}

	public void setDocumentReferences(List<DocumentReference> documentReferences) {
		this.documentReferences = documentReferences;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<ItemComparison> getItemComparisons() {
		return itemComparisons;
	}

	public void setItemComparisons(List<ItemComparison> itemComparisons) {
		this.itemComparisons = itemComparisons;
	}

	public ItemLocationQuantity getRequiredItemLocationQuantity() {
		return requiredItemLocationQuantity;
	}

	public void setRequiredItemLocationQuantity(ItemLocationQuantity requiredItemLocationQuantity) {
		this.requiredItemLocationQuantity = requiredItemLocationQuantity;
	}

	public ItemProperty getKeywordItemProperty() {
		return keywordItemProperty;
	}

	public void setKeywordItemProperty(ItemProperty keywordItemProperty) {
		this.keywordItemProperty = keywordItemProperty;
	}

	public LineReference getCallForTendersLineReference() {
		return callForTendersLineReference;
	}

	public void setCallForTendersLineReference(LineReference callForTendersLineReference) {
		this.callForTendersLineReference = callForTendersLineReference;
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

	public Period getLineValidityPeriod() {
		return lineValidityPeriod;
	}

	public void setLineValidityPeriod(Period lineValidityPeriod) {
		this.lineValidityPeriod = lineValidityPeriod;
	}

	public RelatedItem getComponentRelatedItem() {
		return componentRelatedItem;
	}

	public void setComponentRelatedItem(RelatedItem componentRelatedItem) {
		this.componentRelatedItem = componentRelatedItem;
	}

	public RelatedItem getReplacedRelatedItem() {
		return replacedRelatedItem;
	}

	public void setReplacedRelatedItem(RelatedItem replacedRelatedItem) {
		this.replacedRelatedItem = replacedRelatedItem;
	}

	public RelatedItem getComplementaryRelatedItem() {
		return complementaryRelatedItem;
	}

	public void setComplementaryRelatedItem(RelatedItem complementaryRelatedItem) {
		this.complementaryRelatedItem = complementaryRelatedItem;
	}

	public RelatedItem getReplacementRelatedItem() {
		return replacementRelatedItem;
	}

	public void setReplacementRelatedItem(RelatedItem replacementRelatedItem) {
		this.replacementRelatedItem = replacementRelatedItem;
	}

	public RelatedItem getAccessoryRelatedItem() {
		return accessoryRelatedItem;
	}

	public void setAccessoryRelatedItem(RelatedItem accessoryRelatedItem) {
		this.accessoryRelatedItem = accessoryRelatedItem;
	}

	public RelatedItem getRequiredRelatedItem() {
		return requiredRelatedItem;
	}

	public void setRequiredRelatedItem(RelatedItem requiredRelatedItem) {
		this.requiredRelatedItem = requiredRelatedItem;
	}

	public SupplierParty getSellerSupplierParty() {
		return sellerSupplierParty;
	}

	public void setSellerSupplierParty(SupplierParty sellerSupplierParty) {
		this.sellerSupplierParty = sellerSupplierParty;
	}
}// end Catalogue Line