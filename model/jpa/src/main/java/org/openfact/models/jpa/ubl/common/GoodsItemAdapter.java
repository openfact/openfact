package org.openfact.models.jpa.ubl.common;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.AllowanceChargeEntity;
import org.openfact.models.jpa.entities.ubl.common.GoodsItemContainerEntity;
import org.openfact.models.jpa.entities.ubl.common.GoodsItemEntity;
import org.openfact.models.jpa.entities.ubl.common.InvoiceLineEntity;
import org.openfact.models.jpa.entities.ubl.common.ItemEntity;
import org.openfact.models.jpa.entities.ubl.common.TemperatureEntity;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.GoodsItemContainerModel;
import org.openfact.models.ubl.common.GoodsItemModel;
import org.openfact.models.ubl.common.InvoiceLineModel;
import org.openfact.models.ubl.common.ItemModel;
import org.openfact.models.ubl.common.MeasureModel;
import org.openfact.models.ubl.common.QuantityModel;
import org.openfact.models.ubl.common.TemperatureModel;

public class GoodsItemAdapter implements GoodsItemModel, JpaModel<GoodsItemEntity> {

	protected static final Logger logger = Logger.getLogger(GoodsItemAdapter.class);

	protected GoodsItemEntity goodsItem;
	protected EntityManager em;
	protected OpenfactSession session;

	public GoodsItemAdapter(OpenfactSession session, EntityManager em, GoodsItemEntity goodsItem) {
		this.session = session;
		this.em = em;
		this.goodsItem = goodsItem;
	}

	@Override
	public GoodsItemEntity getEntity() {
		return goodsItem;
	}

	@Override
	public String getID() {
		return goodsItem.getID();
	}

	@Override
	public void setID(String value) {
		goodsItem.setID(value);
	}

	@Override
	public String getSequenceNumberID() {
		return goodsItem.getSequenceNumberID();
	}

	@Override
	public void setSequenceNumberID(String value) {
		goodsItem.setSequenceNumberID(value);
	}

	@Override
	public List<String> getDescription() {
		return goodsItem.getDescription();
	}

	@Override
	public void setDescription(List<String> description) {
		goodsItem.setDescription(description);
	}

	@Override
	public boolean getHazardousRiskIndicator() {
		return goodsItem.isHazardousRiskIndicator();
	}

	@Override
	public void setHazardousRiskIndicator(boolean value) {
		goodsItem.setHazardousRiskIndicator(value);
	}

	@Override
	public BigDecimal getDeclaredCustomsValueAmount() {
		return goodsItem.getDeclaredCustomsValueAmount();
	}

	@Override
	public void setDeclaredCustomsValueAmount(BigDecimal value) {
		goodsItem.setDeclaredCustomsValueAmount(value);
	}

	@Override
	public BigDecimal getDeclaredForCarriageValueAmount() {
		return goodsItem.getDeclaredForCarriageValueAmount();
	}

	@Override
	public void setDeclaredForCarriageValueAmount(BigDecimal value) {
		goodsItem.setDeclaredForCarriageValueAmount(value);
	}

	@Override
	public BigDecimal getDeclaredStatisticsValueAmount() {
		return goodsItem.getDeclaredStatisticsValueAmount();
	}

	@Override
	public void setDeclaredStatisticsValueAmount(BigDecimal value) {
		goodsItem.setDeclaredStatisticsValueAmount(value);
	}

	@Override
	public BigDecimal getFreeOnBoardValueAmount() {
		return goodsItem.getFreeOnBoardValueAmount();
	}

	@Override
	public void setFreeOnBoardValueAmount(BigDecimal value) {
		goodsItem.setFreeOnBoardValueAmount(value);
	}

	@Override
	public BigDecimal getInsuranceValueAmount() {
		return goodsItem.getInsuranceValueAmount();
	}

	@Override
	public void setInsuranceValueAmount(BigDecimal value) {
		goodsItem.setInsuranceValueAmount(value);
	}

	@Override
	public BigDecimal getValueAmount() {
		return goodsItem.getValueAmount();
	}

	@Override
	public void setValueAmount(BigDecimal value) {
		goodsItem.setValueAmount(value);
	}

	@Override
	public MeasureModel getGrossWeightMeasure() {
		return new MeasureAdapter(session, em, goodsItem.getGrossWeightMeasure());
	}

	@Override
	public void setGrossWeightMeasure(MeasureModel value) {
		goodsItem.setGrossWeightMeasure(MeasureAdapter.toEntity(value, em));
	}

	@Override
	public MeasureModel getNetWeightMeasure() {
		return new MeasureAdapter(session, em, goodsItem.getNetWeightMeasure());
	}

	@Override
	public void setNetWeightMeasure(MeasureModel value) {
		goodsItem.setNetWeightMeasure(MeasureAdapter.toEntity(value, em));

	}

	@Override
	public MeasureModel getNetNetWeightMeasure() {
		return new MeasureAdapter(session, em, goodsItem.getNetNetWeightMeasure());
	}

	@Override
	public void setNetNetWeightMeasure(MeasureModel value) {
		goodsItem.setNetNetWeightMeasure(MeasureAdapter.toEntity(value, em));

	}

	@Override
	public MeasureModel getChargeableWeightMeasure() {
		return new MeasureAdapter(session, em, goodsItem.getChargeableWeightMeasure());
	}

	@Override
	public void setChargeableWeightMeasure(MeasureModel value) {
		goodsItem.setChargeableWeightMeasure(MeasureAdapter.toEntity(value, em));

	}

	@Override
	public MeasureModel getGrossVolumeMeasure() {
		return new MeasureAdapter(session, em, goodsItem.getGrossVolumeMeasure());
	}

	@Override
	public void setGrossVolumeMeasure(MeasureModel value) {
		goodsItem.setGrossVolumeMeasure(MeasureAdapter.toEntity(value, em));

	}

	@Override
	public MeasureModel getNetVolumeMeasure() {
		return new MeasureAdapter(session, em, goodsItem.getNetVolumeMeasure());
	}

	@Override
	public void setNetVolumeMeasure(MeasureModel value) {
		goodsItem.setNetVolumeMeasure(MeasureAdapter.toEntity(value, em));

	}

	@Override
	public QuantityModel getQuantity() {
		return new QuantityAdapter(session, em, goodsItem.getQuantity());
	}

	@Override
	public void setQuantity(QuantityModel value) {
		goodsItem.setQuantity(QuantityAdapter.toEntity(value, em));
	}

	@Override
	public String getPreferenceCriterionCode() {
		return goodsItem.getPreferenceCriterionCode();
	}

	@Override
	public void setPreferenceCriterionCode(String value) {
		goodsItem.setPreferenceCriterionCode(value);
	}

	@Override
	public String getRequiredCustomsID() {
		return goodsItem.getRequiredCustomsID();
	}

	@Override
	public void setRequiredCustomsID(String value) {
		goodsItem.setRequiredCustomsID(value);
	}

	@Override
	public String getCustomsStatusCode() {
		return goodsItem.getCustomsStatusCode();
	}

	@Override
	public void setCustomsStatusCode(String value) {
		goodsItem.setCustomsStatusCode(value);
	}

	@Override
	public QuantityModel getCustomsTariffQuantity() {
		return new QuantityAdapter(session, em, goodsItem.getCustomsTariffQuantity());
	}

	@Override
	public void setCustomsTariffQuantity(QuantityModel value) {
		goodsItem.setCustomsTariffQuantity(QuantityAdapter.toEntity(value, em));
	}

	@Override
	public boolean getCustomsImportClassifiedIndicator() {
		return goodsItem.isCustomsImportClassifiedIndicator();
	}

	@Override
	public void setCustomsImportClassifiedIndicator(boolean value) {
		goodsItem.setCustomsImportClassifiedIndicator(value);
	}

	@Override
	public List<ItemModel> getItem() {
		return goodsItem.getItem().stream().map(f -> new ItemAdapter(session, em, f)).collect(Collectors.toList());
	}

	@Override
	public void setItem(List<ItemModel> item) {
		List<ItemEntity> entities = item.stream().map(f -> ItemAdapter.toEntity(f, em)).collect(Collectors.toList());
		goodsItem.setItem(entities);
	}

	@Override
	public List<GoodsItemContainerModel> getGoodsItemContainer() {
		return goodsItem.getGoodsItemContainer().stream().map(f -> new GoodsItemContainerAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setGoodsItemContainer(List<GoodsItemContainerModel> goodsItemContainer) {
		List<GoodsItemContainerEntity> entities = goodsItemContainer.stream()
				.map(f -> GoodsItemContainerAdapter.toEntity(f, em)).collect(Collectors.toList());
		goodsItem.setGoodsItemContainer(entities);
	}

	@Override
	public List<AllowanceChargeModel> getFreightAllowanceCharge() {
		return goodsItem.getFreightAllowanceCharge().stream().map(f -> new AllowanceChargeAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setFreightAllowanceCharge(List<AllowanceChargeModel> freightAllowanceCharge) {
		List<AllowanceChargeEntity> entities = freightAllowanceCharge.stream()
				.map(f -> AllowanceChargeAdapter.toEntity(f, em)).collect(Collectors.toList());
		goodsItem.setFreightAllowanceCharge(entities);

	}

	@Override
	public List<InvoiceLineModel> getInvoiceLine() {
		return goodsItem.getInvoiceLine().stream().map(f -> new InvoiceLineAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setInvoiceLine(List<InvoiceLineModel> invoiceLine) {
		List<InvoiceLineEntity> entities = invoiceLine.stream().map(f -> InvoiceLineAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		goodsItem.setInvoiceLine(entities);

	}

	@Override
	public List<TemperatureModel> getTemperature() {
		return goodsItem.getTemperature().stream().map(f -> new TemperatureAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setTemperature(List<TemperatureModel> temperature) {
		List<TemperatureEntity> entities = temperature.stream().map(f -> TemperatureAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		goodsItem.setTemperature(entities);
	}

	@Override
	public List<GoodsItemModel> getContainedGoodsItem() {
		return goodsItem.getContainedGoodsItem().stream().map(f -> new GoodsItemAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setContainedGoodsItem(List<GoodsItemModel> containedGoodsItem) {
		List<GoodsItemEntity> entities = containedGoodsItem.stream().map(f -> GoodsItemAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		goodsItem.setContainedGoodsItem(entities);

	}

	@Override
	public AddressModel getOriginAddress() {
		return new AddressAdapter(session, em, goodsItem.getOriginAddress());
	}

	@Override
	public void setOriginAddress(AddressModel value) {
		goodsItem.setOriginAddress(AddressAdapter.toEntity(value, em));
	}

	@Override
	public String getId() {
		return goodsItem.getId();
	}

	public static GoodsItemEntity toEntity(GoodsItemModel model, EntityManager em) {
		if (model instanceof GoodsItemAdapter) {
			return ((GoodsItemAdapter) model).getEntity();
		}
		return em.getReference(GoodsItemEntity.class, model.getId());
	}

}
