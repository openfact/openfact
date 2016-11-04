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
import org.openfact.models.jpa.entities.ubl.common.PriceEntity;
import org.openfact.models.jpa.entities.ubl.common.PricingReferenceEntity;
import org.openfact.models.ubl.common.ItemLocationQuantityModel;
import org.openfact.models.ubl.common.PriceModel;
import org.openfact.models.ubl.common.PricingReferenceModel;

public class PricingReferenceAdapter implements PricingReferenceModel, JpaModel<PricingReferenceEntity> {

    protected static final Logger logger = Logger.getLogger(PricingReferenceAdapter.class);
    protected PricingReferenceEntity pricingReference;
    protected EntityManager em;
    protected OpenfactSession session;

    public PricingReferenceAdapter(OpenfactSession session, EntityManager em,
            PricingReferenceEntity pricingReference) {
        this.session = session;
        this.em = em;
        this.pricingReference = pricingReference;
    }

    @Override
    public ItemLocationQuantityModel getOriginalItemLocationQuantity() {
        return new ItemLocationQuantityAdapter(session, em,
                this.pricingReference.getOriginalItemLocationQuantity());
    }

    @Override
    public void setOriginalItemLocationQuantity(ItemLocationQuantityModel value) {
        this.pricingReference
                .setOriginalItemLocationQuantity(ItemLocationQuantityAdapter.toEntity(value, em));
    }

    @Override
    public List<PriceModel> getAlternativeConditionPrice() {
        return pricingReference.getAlternativeConditionPrice().stream()
                .map(f -> new PriceAdapter(session, em, f)).collect(Collectors.toList());
    }

    @Override
    public void setAlternativeConditionPrice(List<PriceModel> alternativeConditionPrice) {
        List<PriceEntity> entities = alternativeConditionPrice.stream().map(f -> PriceAdapter.toEntity(f, em))
                .collect(Collectors.toList());
        this.pricingReference.setAlternativeConditionPrice(entities);
    }

    @Override
    public String getId() {
        return this.pricingReference.getId();
    }

    @Override
    public PricingReferenceEntity getEntity() {
        return pricingReference;
    }

    @Override
    public PriceModel addAlternativeConditionPrice() {
        List<PriceEntity> priceEntities = pricingReference.getAlternativeConditionPrice();
        PriceEntity priceEntity = new PriceEntity();
        priceEntities.add(priceEntity);
        return new PriceAdapter(session, em, priceEntity);
    }

    public static PricingReferenceEntity toEntity(PricingReferenceModel model, EntityManager em) {
        if (model instanceof PricingReferenceAdapter) {
            return ((PricingReferenceAdapter) model).getEntity();
        }
        return em.getReference(PricingReferenceEntity.class, model.getId());
    }

}
