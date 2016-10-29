package org.openfact.models.jpa.entities.ubl.common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "GOODS_ITEM")
public class GoodsItemEntity {
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	protected String id;

	@Column(name = "ID_UBL")
	protected String ID;

	@Column(name = "SEQUENCE_NUMBER_ID")
	protected String sequenceNumberID;

	@ElementCollection
	@Column(name = "VALUE")
	@CollectionTable(name = "DESCRIPTION_GOODSITEM", joinColumns = { @JoinColumn(name = "GOODS_ITEM_ID") })
	protected List<String> description = new ArrayList<>();

	@Column(name = "HAZARDOUS_RISK_INDICATOR")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean hazardousRiskIndicator;

	@Column(name = "DECLARED_CUSTOMS_VALUE_AMOUNT")
	protected BigDecimal declaredCustomsValueAmount;

	@Column(name = "DECLARED_FOR_CARRIAGE_VALUE_AMOUNT")
	protected BigDecimal declaredForCarriageValueAmount;

	@Column(name = "DECLARED_STATISTICS_VALUE_AMOUNT")
	protected BigDecimal declaredStatisticsValueAmount;

	@Column(name = "FREE_ON_BOARD_VALUE_AMOUNT")
	protected BigDecimal freeOnBoardValueAmount;

	@Column(name = "INSURANCE_VALUE_AMOUNT")
	protected BigDecimal insuranceValueAmount;

	@Column(name = "VALUE_AMOUNT")
	protected BigDecimal valueAmount;

	@ManyToOne(targetEntity = MeasureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "GROSSWEIGHTMEASURE_GOODSITEM")
	protected MeasureEntity grossWeightMeasure = new MeasureEntity();

	@ManyToOne(targetEntity = MeasureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "NETWEIGHTMEASURE_GOODSITEMTY")
	protected MeasureEntity netWeightMeasure = new MeasureEntity();

	@ManyToOne(targetEntity = MeasureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "NETNETWEIGHTMEASURE_GOODSITE")
	protected MeasureEntity netNetWeightMeasure = new MeasureEntity();

	@ManyToOne(targetEntity = MeasureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CHARGEABLEWEIGHTMEASURE_GOOD")
	protected MeasureEntity chargeableWeightMeasure = new MeasureEntity();;

	@ManyToOne(targetEntity = MeasureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "GROSSVOLUMEMEASURE_GOODSITEM")
	protected MeasureEntity grossVolumeMeasure = new MeasureEntity();;

	@ManyToOne(targetEntity = MeasureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "NETVOLUMEMEASURE_GOODSITEMTY")
	protected MeasureEntity netVolumeMeasure = new MeasureEntity();;

	@ManyToOne(targetEntity = QuantityEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "QUANTITY_GOODSITEM")
	protected QuantityEntity quantity = new QuantityEntity();

	@Column(name = "PREFERENCE_CRITERION_CODE")
	protected String preferenceCriterionCode;

	@Column(name = "REQUIRED_CUSTOMS_ID")
	protected String requiredCustomsID;

	@Column(name = "CUSTOMS_STATUS_CODE")
	protected String customsStatusCode;

	@ManyToOne(targetEntity = QuantityEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CUSTOMSTARIFFQUANTITY_GOODS")
	protected QuantityEntity customsTariffQuantity = new QuantityEntity();

	@Column(name = "CUSTOMS_IMPORT_CLASSIFIED_INDICATOR")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean customsImportClassifiedIndicator;

	@OneToMany(targetEntity = ItemEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ITEM_GOODSITEM")
	protected List<ItemEntity> item = new ArrayList<>();

	@OneToMany(targetEntity = GoodsItemContainerEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "GOODSITEMCONTAINER_GOODSITEM")
	protected List<GoodsItemContainerEntity> goodsItemContainer = new ArrayList<>();;

	@OneToMany(targetEntity = AllowanceChargeEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "FREIGHTALLOWANCECHARGE_GOODS")
	protected List<AllowanceChargeEntity> freightAllowanceCharge = new ArrayList<>();;

	@OneToMany(targetEntity = InvoiceLineEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "INVOICELINE_GOODSITEM")
	protected List<InvoiceLineEntity> invoiceLine = new ArrayList<>();;

	@OneToMany(targetEntity = TemperatureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "TEMPERATURE_GOODSITEM")
	protected List<TemperatureEntity> temperature = new ArrayList<>();;

	@OneToMany(targetEntity = GoodsItemEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CONTAINEDGOODSITEM_GOODSITEM")
	protected List<GoodsItemEntity> containedGoodsItem;

	@ManyToOne(targetEntity = AddressEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ORIGINADDRESS_GOODSITEM")
	protected AddressEntity originAddress = new AddressEntity();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getSequenceNumberID() {
		return sequenceNumberID;
	}

	public void setSequenceNumberID(String sequenceNumberID) {
		this.sequenceNumberID = sequenceNumberID;
	}

	public List<String> getDescription() {
		return description;
	}

	public void setDescription(List<String> description) {
		this.description = description;
	}

	public boolean isHazardousRiskIndicator() {
		return hazardousRiskIndicator;
	}

	public void setHazardousRiskIndicator(boolean hazardousRiskIndicator) {
		this.hazardousRiskIndicator = hazardousRiskIndicator;
	}

	public BigDecimal getDeclaredCustomsValueAmount() {
		return declaredCustomsValueAmount;
	}

	public void setDeclaredCustomsValueAmount(BigDecimal declaredCustomsValueAmount) {
		this.declaredCustomsValueAmount = declaredCustomsValueAmount;
	}

	public BigDecimal getDeclaredForCarriageValueAmount() {
		return declaredForCarriageValueAmount;
	}

	public void setDeclaredForCarriageValueAmount(BigDecimal declaredForCarriageValueAmount) {
		this.declaredForCarriageValueAmount = declaredForCarriageValueAmount;
	}

	public BigDecimal getDeclaredStatisticsValueAmount() {
		return declaredStatisticsValueAmount;
	}

	public void setDeclaredStatisticsValueAmount(BigDecimal declaredStatisticsValueAmount) {
		this.declaredStatisticsValueAmount = declaredStatisticsValueAmount;
	}

	public BigDecimal getFreeOnBoardValueAmount() {
		return freeOnBoardValueAmount;
	}

	public void setFreeOnBoardValueAmount(BigDecimal freeOnBoardValueAmount) {
		this.freeOnBoardValueAmount = freeOnBoardValueAmount;
	}

	public BigDecimal getInsuranceValueAmount() {
		return insuranceValueAmount;
	}

	public void setInsuranceValueAmount(BigDecimal insuranceValueAmount) {
		this.insuranceValueAmount = insuranceValueAmount;
	}

	public BigDecimal getValueAmount() {
		return valueAmount;
	}

	public void setValueAmount(BigDecimal valueAmount) {
		this.valueAmount = valueAmount;
	}

	public MeasureEntity getGrossWeightMeasure() {
		return grossWeightMeasure;
	}

	public void setGrossWeightMeasure(MeasureEntity grossWeightMeasure) {
		this.grossWeightMeasure = grossWeightMeasure;
	}

	public MeasureEntity getNetWeightMeasure() {
		return netWeightMeasure;
	}

	public void setNetWeightMeasure(MeasureEntity netWeightMeasure) {
		this.netWeightMeasure = netWeightMeasure;
	}

	public MeasureEntity getNetNetWeightMeasure() {
		return netNetWeightMeasure;
	}

	public void setNetNetWeightMeasure(MeasureEntity netNetWeightMeasure) {
		this.netNetWeightMeasure = netNetWeightMeasure;
	}

	public MeasureEntity getChargeableWeightMeasure() {
		return chargeableWeightMeasure;
	}

	public void setChargeableWeightMeasure(MeasureEntity chargeableWeightMeasure) {
		this.chargeableWeightMeasure = chargeableWeightMeasure;
	}

	public MeasureEntity getGrossVolumeMeasure() {
		return grossVolumeMeasure;
	}

	public void setGrossVolumeMeasure(MeasureEntity grossVolumeMeasure) {
		this.grossVolumeMeasure = grossVolumeMeasure;
	}

	public MeasureEntity getNetVolumeMeasure() {
		return netVolumeMeasure;
	}

	public void setNetVolumeMeasure(MeasureEntity netVolumeMeasure) {
		this.netVolumeMeasure = netVolumeMeasure;
	}

	public QuantityEntity getQuantity() {
		return quantity;
	}

	public void setQuantity(QuantityEntity quantity) {
		this.quantity = quantity;
	}

	public String getPreferenceCriterionCode() {
		return preferenceCriterionCode;
	}

	public void setPreferenceCriterionCode(String preferenceCriterionCode) {
		this.preferenceCriterionCode = preferenceCriterionCode;
	}

	public String getRequiredCustomsID() {
		return requiredCustomsID;
	}

	public void setRequiredCustomsID(String requiredCustomsID) {
		this.requiredCustomsID = requiredCustomsID;
	}

	public String getCustomsStatusCode() {
		return customsStatusCode;
	}

	public void setCustomsStatusCode(String customsStatusCode) {
		this.customsStatusCode = customsStatusCode;
	}

	public QuantityEntity getCustomsTariffQuantity() {
		return customsTariffQuantity;
	}

	public void setCustomsTariffQuantity(QuantityEntity customsTariffQuantity) {
		this.customsTariffQuantity = customsTariffQuantity;
	}

	public boolean isCustomsImportClassifiedIndicator() {
		return customsImportClassifiedIndicator;
	}

	public void setCustomsImportClassifiedIndicator(boolean customsImportClassifiedIndicator) {
		this.customsImportClassifiedIndicator = customsImportClassifiedIndicator;
	}

	public List<ItemEntity> getItem() {
		return item;
	}

	public void setItem(List<ItemEntity> item) {
		this.item = item;
	}

	public List<GoodsItemContainerEntity> getGoodsItemContainer() {
		return goodsItemContainer;
	}

	public void setGoodsItemContainer(List<GoodsItemContainerEntity> goodsItemContainer) {
		this.goodsItemContainer = goodsItemContainer;
	}

	public List<AllowanceChargeEntity> getFreightAllowanceCharge() {
		return freightAllowanceCharge;
	}

	public void setFreightAllowanceCharge(List<AllowanceChargeEntity> freightAllowanceCharge) {
		this.freightAllowanceCharge = freightAllowanceCharge;
	}

	public List<InvoiceLineEntity> getInvoiceLine() {
		return invoiceLine;
	}

	public void setInvoiceLine(List<InvoiceLineEntity> invoiceLine) {
		this.invoiceLine = invoiceLine;
	}

	public List<TemperatureEntity> getTemperature() {
		return temperature;
	}

	public void setTemperature(List<TemperatureEntity> temperature) {
		this.temperature = temperature;
	}

	public List<GoodsItemEntity> getContainedGoodsItem() {
		return containedGoodsItem;
	}

	public void setContainedGoodsItem(List<GoodsItemEntity> containedGoodsItem) {
		this.containedGoodsItem = containedGoodsItem;
	}

	public AddressEntity getOriginAddress() {
		return originAddress;
	}

	public void setOriginAddress(AddressEntity originAddress) {
		this.originAddress = originAddress;
	}
	
}
