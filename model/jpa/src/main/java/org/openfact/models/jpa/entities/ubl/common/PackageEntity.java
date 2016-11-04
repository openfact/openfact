/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.models.jpa.entities.ubl.common;

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
@Table(name = "PACKAGE")
public class PackageEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	protected String id;

	@Column(name = "ID_UBL")
	protected String ID;

	@ManyToOne(targetEntity = QuantityEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "QUANTITY_PACKAGE")
	protected QuantityEntity quantity;

	@Column(name = "RETURNABLE_MATERIAL_INDICATOR")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean returnableMaterialIndicator;

	@Column(name = "PACKAGE_LEVEL_CODE")
	protected String packageLevelCode;

	@Column(name = "PACKAGING_TYPE_CODE")
	protected String packagingTypeCode;

	@ElementCollection
	@Column(name = "VALUE")
	@CollectionTable(name = "PACKINGMATERIAL_PACKAGE", joinColumns = { @JoinColumn(name = "PACKAGE_ID") })
	protected List<String> packingMaterial = new ArrayList<>();

	@OneToMany(targetEntity = PackageEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CONTAINEDPACKAGE_PACKAGE")
	protected List<PackageEntity> containedPackage;

	@OneToMany(targetEntity = GoodsItemEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "GOODSITEM_PACKAGE")
	protected List<GoodsItemEntity> goodsItem = new ArrayList<>();

	@OneToMany(targetEntity = DimensionEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "MEASUREMENTDIMENSION_PACKAGE")
	protected List<DimensionEntity> measurementDimension = new ArrayList<>();

	@OneToMany(targetEntity = DeliveryUnitEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "DELIVERYUNIT_PACKAGE")
	protected List<DeliveryUnitEntity> deliveryUnit = new ArrayList<>();

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

	public QuantityEntity getQuantity() {
		return quantity;
	}

	public void setQuantity(QuantityEntity quantity) {
		this.quantity = quantity;
	}

	public boolean isReturnableMaterialIndicator() {
		return returnableMaterialIndicator;
	}

	public void setReturnableMaterialIndicator(boolean returnableMaterialIndicator) {
		this.returnableMaterialIndicator = returnableMaterialIndicator;
	}

	public String getPackageLevelCode() {
		return packageLevelCode;
	}

	public void setPackageLevelCode(String packageLevelCode) {
		this.packageLevelCode = packageLevelCode;
	}

	public String getPackagingTypeCode() {
		return packagingTypeCode;
	}

	public void setPackagingTypeCode(String packagingTypeCode) {
		this.packagingTypeCode = packagingTypeCode;
	}

	public List<String> getPackingMaterial() {
		return packingMaterial;
	}

	public void setPackingMaterial(List<String> packingMaterial) {
		this.packingMaterial = packingMaterial;
	}

	public List<PackageEntity> getContainedPackage() {
		return containedPackage;
	}

	public void setContainedPackage(List<PackageEntity> containedPackage) {
		this.containedPackage = containedPackage;
	}

	public List<GoodsItemEntity> getGoodsItem() {
		return goodsItem;
	}

	public void setGoodsItem(List<GoodsItemEntity> goodsItem) {
		this.goodsItem = goodsItem;
	}

	public List<DimensionEntity> getMeasurementDimension() {
		return measurementDimension;
	}

	public void setMeasurementDimension(List<DimensionEntity> measurementDimension) {
		this.measurementDimension = measurementDimension;
	}

	public List<DeliveryUnitEntity> getDeliveryUnit() {
		return deliveryUnit;
	}

	public void setDeliveryUnit(List<DeliveryUnitEntity> deliveryUnit) {
		this.deliveryUnit = deliveryUnit;
	}

}
