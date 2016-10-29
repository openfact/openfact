package org.openfact.models.jpa.ubl.common;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.DeliveryUnitEntity;
import org.openfact.models.jpa.entities.ubl.common.DimensionEntity;
import org.openfact.models.jpa.entities.ubl.common.GoodsItemEntity;
import org.openfact.models.jpa.entities.ubl.common.PackageEntity;
import org.openfact.models.jpa.entities.ubl.common.PeriodEntity;
import org.openfact.models.jpa.entities.ubl.common.QuantityEntity;
import org.openfact.models.jpa.entities.ubl.common.ShipmentEntity;
import org.openfact.models.ubl.common.DeliveryUnitModel;
import org.openfact.models.ubl.common.DimensionModel;
import org.openfact.models.ubl.common.GoodsItemModel;
import org.openfact.models.ubl.common.PackageModel;
import org.openfact.models.ubl.common.QuantityModel;

public class PackageAdapter implements PackageModel, JpaModel<PackageEntity> {

	protected static final Logger logger = Logger.getLogger(PackageAdapter.class);

	protected PackageEntity packageEntity;
	protected EntityManager em;
	protected OpenfactSession session;

	public PackageAdapter(OpenfactSession session, EntityManager em, PackageEntity packageEntity) {
		this.session = session;
		this.em = em;
		this.packageEntity = packageEntity;
	}

	@Override
	public PackageEntity getEntity() {
		return packageEntity;
	}

	@Override
	public String getID() {
		return packageEntity.getID();
	}

	@Override
	public void setID(String value) {
		packageEntity.setID(value);
	}

	@Override
	public QuantityModel getQuantity() {
		return new QuantityAdapter(session, em, packageEntity.getQuantity());
	}

	@Override
	public void setQuantity(QuantityModel value) {
		packageEntity.setQuantity(QuantityAdapter.toEntity(value, em));
		;

	}

	@Override
	public boolean getReturnableMaterialIndicator() {
		return packageEntity.isReturnableMaterialIndicator();
	}

	@Override
	public void setReturnableMaterialIndicator(boolean value) {
		packageEntity.setReturnableMaterialIndicator(value);
	}

	@Override
	public String getPackageLevelCode() {
		return packageEntity.getPackageLevelCode();
	}

	@Override
	public void setPackageLevelCode(String value) {
		packageEntity.setPackageLevelCode(value);
	}

	@Override
	public String getPackagingTypeCode() {
		return packageEntity.getPackagingTypeCode();
	}

	@Override
	public void setPackagingTypeCode(String value) {
		packageEntity.setPackagingTypeCode(value);
	}

	@Override
	public List<String> getPackingMaterial() {
		return packageEntity.getPackingMaterial();
	}

	@Override
	public void setPackingMaterial(List<String> packingMaterial) {
		packageEntity.setPackingMaterial(packingMaterial);
	}

	@Override
	public List<PackageModel> getContainedPackage() {
		return packageEntity.getContainedPackage().stream().map(f -> new PackageAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setContainedPackage(List<PackageModel> containedPackage) {
		List<PackageEntity> entities = containedPackage.stream().map(f -> PackageAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		packageEntity.setContainedPackage(entities);
	}

	@Override
	public List<GoodsItemModel> getGoodsItem() {
		return packageEntity.getGoodsItem().stream().map(f -> new GoodsItemAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setGoodsItem(List<GoodsItemModel> goodsItem) {
		List<GoodsItemEntity> entities = goodsItem.stream().map(f -> GoodsItemAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		packageEntity.setGoodsItem(entities);

	}

	@Override
	public List<DimensionModel> getMeasurementDimension() {
		return packageEntity.getMeasurementDimension().stream().map(f -> new DimensionAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setMeasurementDimension(List<DimensionModel> measurementDimension) {
		List<DimensionEntity> entities = measurementDimension.stream().map(f -> DimensionAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		packageEntity.setMeasurementDimension(entities);
	}

	@Override
	public List<DeliveryUnitModel> getDeliveryUnit() {
		return packageEntity.getDeliveryUnit().stream().map(f -> new DeliveryUnitAdapter(session, em, f))
				.collect(Collectors.toList());
	}

	@Override
	public void setDeliveryUnit(List<DeliveryUnitModel> deliveryUnit) {
		List<DeliveryUnitEntity> entities = deliveryUnit.stream().map(f -> DeliveryUnitAdapter.toEntity(f, em))
				.collect(Collectors.toList());
		packageEntity.setDeliveryUnit(entities);
	}

	@Override
	public String getId() {
		return packageEntity.getId();
	}

	private static PackageEntity toEntity(PackageModel model, EntityManager em) {
		if (model instanceof PackageAdapter) {
			return ((PackageAdapter) model).getEntity();
		}
		return em.getReference(PackageEntity.class, model.getId());
	}

}
