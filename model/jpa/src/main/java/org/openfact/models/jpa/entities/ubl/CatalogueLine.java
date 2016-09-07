package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

/**
 * A class to define a line in a Catalogue describing a purchasable item.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:19 a. m.
 */
public class CatalogueLine {

	/**
	 * A code signifying the action required to synchronize this catalogue line.
	 * Recommend codes (delete, update, add)
	 */
	private String ActionCode;
	/**
	 * The numeric quantity of the ordering unit (and units of measure) of the
	 * catalogue line.
	 */
	private BigDecimal ContentUnitQuantity;
	/**
	 * A subdivision of a contract or tender covering this catalogue line.
	 */
	private String ContractSubdivision;
	/**
	 * An identifier for the line in the catalogue.
	 */
	private String ID;
	/**
	 * A code signifying the life cycle status of this catalogue line. Examples are
	 * pre-order, end of production
	 */
	private String LifeCycleStatusCode;
	/**
	 * The maximum amount of the item described in this catalogue line that can be
	 * ordered.
	 */
	private BigDecimal MaximumOrderQuantity;
	/**
	 * The minimum amount of the item described in this catalogue line that can be
	 * ordered.
	 */
	private BigDecimal MinimumOrderQuantity;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private String Note;
	/**
	 * An indicator that this catalogue line describes an orderable item (true) or is
	 * included for reference purposes only (false).
	 */
	private boolean OrderableIndicator;
	/**
	 * A textual description of the units in which the item described in this
	 * catalogue line can be ordered.
	 */
	private String OrderableUnit;
	/**
	 * The number of items that can set the order quantity increments.
	 */
	private BigDecimal OrderQuantityIncrementNumeric;
	/**
	 * A mutually agreed code signifying the level of packaging associated with the
	 * item described in this catalogue line.
	 */
	private String PackLevelCode;
	/**
	 * Text about a warranty (provided by WarrantyParty) for the good or service
	 * described in this catalogue line.
	 */
	private String WarrantyInformation;
	private CustomerParty ContractorCustomerParty;
	private DocumentReference CallForTendersDocumentReference;
	private DocumentReference m_DocumentReference;
	private Item m_Item;
	private ItemComparison m_ItemComparison;
	private ItemLocationQuantity RequiredItemLocationQuantity;
	private ItemProperty KeywordItemProperty;
	private LineReference CallForTendersLineReference;
	private Party WarrantyParty;
	private Period WarrantyValidityPeriod;
	private Period LineValidityPeriod;
	private RelatedItem ComponentRelatedItem;
	private RelatedItem ReplacedRelatedItem;
	private RelatedItem ComplementaryRelatedItem;
	private RelatedItem ReplacementRelatedItem;
	private RelatedItem AccessoryRelatedItem;
	private RelatedItem RequiredRelatedItem;
	private SupplierParty SellerSupplierParty;

	public CatalogueLine(){

	}

	public void finalize() throws Throwable {

	}

	public String getActionCode() {
		return ActionCode;
	}

	public void setActionCode(String actionCode) {
		ActionCode = actionCode;
	}

	public BigDecimal getContentUnitQuantity() {
		return ContentUnitQuantity;
	}

	public void setContentUnitQuantity(BigDecimal contentUnitQuantity) {
		ContentUnitQuantity = contentUnitQuantity;
	}

	public String getContractSubdivision() {
		return ContractSubdivision;
	}

	public void setContractSubdivision(String contractSubdivision) {
		ContractSubdivision = contractSubdivision;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getLifeCycleStatusCode() {
		return LifeCycleStatusCode;
	}

	public void setLifeCycleStatusCode(String lifeCycleStatusCode) {
		LifeCycleStatusCode = lifeCycleStatusCode;
	}

	public BigDecimal getMaximumOrderQuantity() {
		return MaximumOrderQuantity;
	}

	public void setMaximumOrderQuantity(BigDecimal maximumOrderQuantity) {
		MaximumOrderQuantity = maximumOrderQuantity;
	}

	public BigDecimal getMinimumOrderQuantity() {
		return MinimumOrderQuantity;
	}

	public void setMinimumOrderQuantity(BigDecimal minimumOrderQuantity) {
		MinimumOrderQuantity = minimumOrderQuantity;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public boolean isOrderableIndicator() {
		return OrderableIndicator;
	}

	public void setOrderableIndicator(boolean orderableIndicator) {
		OrderableIndicator = orderableIndicator;
	}

	public String getOrderableUnit() {
		return OrderableUnit;
	}

	public void setOrderableUnit(String orderableUnit) {
		OrderableUnit = orderableUnit;
	}

	public BigDecimal getOrderQuantityIncrementNumeric() {
		return OrderQuantityIncrementNumeric;
	}

	public void setOrderQuantityIncrementNumeric(BigDecimal orderQuantityIncrementNumeric) {
		OrderQuantityIncrementNumeric = orderQuantityIncrementNumeric;
	}

	public String getPackLevelCode() {
		return PackLevelCode;
	}

	public void setPackLevelCode(String packLevelCode) {
		PackLevelCode = packLevelCode;
	}

	public String getWarrantyInformation() {
		return WarrantyInformation;
	}

	public void setWarrantyInformation(String warrantyInformation) {
		WarrantyInformation = warrantyInformation;
	}

	public CustomerParty getContractorCustomerParty() {
		return ContractorCustomerParty;
	}

	public void setContractorCustomerParty(CustomerParty contractorCustomerParty) {
		ContractorCustomerParty = contractorCustomerParty;
	}

	public DocumentReference getCallForTendersDocumentReference() {
		return CallForTendersDocumentReference;
	}

	public void setCallForTendersDocumentReference(DocumentReference callForTendersDocumentReference) {
		CallForTendersDocumentReference = callForTendersDocumentReference;
	}

	public DocumentReference getM_DocumentReference() {
		return m_DocumentReference;
	}

	public void setM_DocumentReference(DocumentReference m_DocumentReference) {
		this.m_DocumentReference = m_DocumentReference;
	}

	public Item getM_Item() {
		return m_Item;
	}

	public void setM_Item(Item m_Item) {
		this.m_Item = m_Item;
	}

	public ItemComparison getM_ItemComparison() {
		return m_ItemComparison;
	}

	public void setM_ItemComparison(ItemComparison m_ItemComparison) {
		this.m_ItemComparison = m_ItemComparison;
	}

	public ItemLocationQuantity getRequiredItemLocationQuantity() {
		return RequiredItemLocationQuantity;
	}

	public void setRequiredItemLocationQuantity(ItemLocationQuantity requiredItemLocationQuantity) {
		RequiredItemLocationQuantity = requiredItemLocationQuantity;
	}

	public ItemProperty getKeywordItemProperty() {
		return KeywordItemProperty;
	}

	public void setKeywordItemProperty(ItemProperty keywordItemProperty) {
		KeywordItemProperty = keywordItemProperty;
	}

	public LineReference getCallForTendersLineReference() {
		return CallForTendersLineReference;
	}

	public void setCallForTendersLineReference(LineReference callForTendersLineReference) {
		CallForTendersLineReference = callForTendersLineReference;
	}

	public Party getWarrantyParty() {
		return WarrantyParty;
	}

	public void setWarrantyParty(Party warrantyParty) {
		WarrantyParty = warrantyParty;
	}

	public Period getWarrantyValidityPeriod() {
		return WarrantyValidityPeriod;
	}

	public void setWarrantyValidityPeriod(Period warrantyValidityPeriod) {
		WarrantyValidityPeriod = warrantyValidityPeriod;
	}

	public Period getLineValidityPeriod() {
		return LineValidityPeriod;
	}

	public void setLineValidityPeriod(Period lineValidityPeriod) {
		LineValidityPeriod = lineValidityPeriod;
	}

	public RelatedItem getComponentRelatedItem() {
		return ComponentRelatedItem;
	}

	public void setComponentRelatedItem(RelatedItem componentRelatedItem) {
		ComponentRelatedItem = componentRelatedItem;
	}

	public RelatedItem getReplacedRelatedItem() {
		return ReplacedRelatedItem;
	}

	public void setReplacedRelatedItem(RelatedItem replacedRelatedItem) {
		ReplacedRelatedItem = replacedRelatedItem;
	}

	public RelatedItem getComplementaryRelatedItem() {
		return ComplementaryRelatedItem;
	}

	public void setComplementaryRelatedItem(RelatedItem complementaryRelatedItem) {
		ComplementaryRelatedItem = complementaryRelatedItem;
	}

	public RelatedItem getReplacementRelatedItem() {
		return ReplacementRelatedItem;
	}

	public void setReplacementRelatedItem(RelatedItem replacementRelatedItem) {
		ReplacementRelatedItem = replacementRelatedItem;
	}

	public RelatedItem getAccessoryRelatedItem() {
		return AccessoryRelatedItem;
	}

	public void setAccessoryRelatedItem(RelatedItem accessoryRelatedItem) {
		AccessoryRelatedItem = accessoryRelatedItem;
	}

	public RelatedItem getRequiredRelatedItem() {
		return RequiredRelatedItem;
	}

	public void setRequiredRelatedItem(RelatedItem requiredRelatedItem) {
		RequiredRelatedItem = requiredRelatedItem;
	}

	public SupplierParty getSellerSupplierParty() {
		return SellerSupplierParty;
	}

	public void setSellerSupplierParty(SupplierParty sellerSupplierParty) {
		SellerSupplierParty = sellerSupplierParty;
	}
	
	
}//end Catalogue Line