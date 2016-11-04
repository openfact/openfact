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
package org.openfact.models.jpa.ubl.common;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.AddressEntity;
import org.openfact.models.jpa.entities.ubl.common.DeliveryUnitEntity;
import org.openfact.models.jpa.entities.ubl.common.ItemLocationQuantityEntity;
import org.openfact.models.jpa.entities.ubl.common.TaxCategoryEntity;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.DeliveryUnitModel;
import org.openfact.models.ubl.common.ItemLocationQuantityModel;
import org.openfact.models.ubl.common.MeasureModel;
import org.openfact.models.ubl.common.PriceModel;
import org.openfact.models.ubl.common.QuantityModel;
import org.openfact.models.ubl.common.TaxCategoryModel;

public class ItemLocationQuantityAdapter
        implements ItemLocationQuantityModel, JpaModel<ItemLocationQuantityEntity> {

    protected static final Logger logger = Logger.getLogger(ItemLocationQuantityAdapter.class);
    protected ItemLocationQuantityEntity itemLocationQuantity;
    protected EntityManager em;
    protected OpenfactSession session;

    public ItemLocationQuantityAdapter(OpenfactSession session, EntityManager em,
            ItemLocationQuantityEntity itemLocationQuantity) {
        this.session = session;
        this.em = em;
        this.itemLocationQuantity = itemLocationQuantity;
    }

    @Override
    public MeasureModel getLeadTimeMeasure() {
        return new MeasureAdapter(session, em, this.itemLocationQuantity.getLeadTimeMeasure());
    }

    @Override
    public void setLeadTimeMeasure(MeasureModel value) {
        this.itemLocationQuantity.setLeadTimeMeasure(MeasureAdapter.toEntity(value, em));
    }

    @Override
    public QuantityModel getMinimumQuantity() {
        return new QuantityAdapter(session, em, itemLocationQuantity.getMinimumQuantity());
    }

    @Override
    public void setMinimumQuantity(QuantityModel value) {
        this.itemLocationQuantity.setMinimumQuantity(QuantityAdapter.toEntity(value, em));
    }

    @Override
    public QuantityModel getMaximumQuantity() {
        return new QuantityAdapter(session, em, itemLocationQuantity.getMaximumQuantity());
    }

    @Override
    public void setMaximumQuantity(QuantityModel value) {
        this.itemLocationQuantity.setMaximumQuantity(QuantityAdapter.toEntity(value, em));
    }

    @Override
    public boolean getHazardousRiskIndicator() {
        return this.itemLocationQuantity.isHazardousRiskIndicator();
    }

    @Override
    public void setHazardousRiskIndicator(boolean value) {
        this.itemLocationQuantity.setHazardousRiskIndicator(value);
    }

    @Override
    public List<String> getTradingRestrictions() {
        return this.itemLocationQuantity.getTradingRestrictions();
    }

    @Override
    public void setTradingRestrictions(List<String> tradingRestrictions) {
        this.itemLocationQuantity.setTradingRestrictions(tradingRestrictions);
    }

    @Override
    public List<AddressModel> getApplicableTerritoryAddress() {
        return itemLocationQuantity.getApplicableTerritoryAddress().stream()
                .map(f -> new AddressAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setApplicableTerritoryAddress(List<AddressModel> applicableTerritoryAddress) {
        List<AddressEntity> entities = applicableTerritoryAddress.stream()
                .map(f -> AddressAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.itemLocationQuantity.setApplicableTerritoryAddress(entities);
    }

    @Override
    public PriceModel getPrice() {
        return new PriceAdapter(session, em, itemLocationQuantity.getPrice());
    }

    @Override
    public void setPrice(PriceModel value) {
        this.itemLocationQuantity.setPrice(PriceAdapter.toEntity(value, em));
    }

    @Override
    public List<DeliveryUnitModel> getDeliveryUnit() {
        return itemLocationQuantity.getDeliveryUnit().stream()
                .map(f -> new DeliveryUnitAdapter(session, em, f)).collect(Collectors.toList());

    }

    @Override
    public void setDeliveryUnit(List<DeliveryUnitModel> deliveryUnit) {
        List<DeliveryUnitEntity> entities = deliveryUnit.stream()
                .map(f -> DeliveryUnitAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.itemLocationQuantity.setDeliveryUnit(entities);
    }

    @Override
    public List<TaxCategoryModel> getApplicableTaxCategory() {
        return itemLocationQuantity.getApplicableTaxCategory().stream()
                .map(f -> new TaxCategoryAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setApplicableTaxCategory(List<TaxCategoryModel> applicableTaxCategory) {
        List<TaxCategoryEntity> entities = applicableTaxCategory.stream()
                .map(f -> TaxCategoryAdapter.toEntity(f, em)).collect(Collectors.toList());
        this.itemLocationQuantity.setApplicableTaxCategory(entities);
    }

    @Override
    public String getId() {
        return this.itemLocationQuantity.getId();
    }

    public static ItemLocationQuantityEntity toEntity(ItemLocationQuantityModel model, EntityManager em) {
        if (model instanceof ItemLocationQuantityAdapter) {
            return ((ItemLocationQuantityAdapter) model).getEntity();
        }
        return em.getReference(ItemLocationQuantityEntity.class, model.getId());
    }

    @Override
    public ItemLocationQuantityEntity getEntity() {

        return itemLocationQuantity;
    }

}
