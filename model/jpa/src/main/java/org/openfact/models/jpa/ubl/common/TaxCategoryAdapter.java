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

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.TaxCategoryEntity;
import org.openfact.models.ubl.common.MeasureModel;
import org.openfact.models.ubl.common.TaxCategoryModel;
import org.openfact.models.ubl.common.TaxSchemeModel;

public class TaxCategoryAdapter implements TaxCategoryModel, JpaModel<TaxCategoryEntity> {

    protected static final Logger logger = Logger.getLogger(TaxCategoryAdapter.class);
    protected TaxCategoryEntity taxCategory;
    protected EntityManager em;
    protected OpenfactSession session;

    public TaxCategoryAdapter(OpenfactSession session, EntityManager em, TaxCategoryEntity taxCategory) {
        this.session = session;
        this.em = em;
        this.taxCategory = taxCategory;
    }

    @Override
    public String getID() {
        return this.taxCategory.getID();
    }

    @Override
    public void setID(String value) {
        this.taxCategory.setID(value);
    }

    @Override
    public String getName() {
        return this.taxCategory.getName();
    }

    @Override
    public void setName(String value) {
        this.taxCategory.setName(value);
    }

    @Override
    public BigDecimal getPercent() {
        return this.taxCategory.getPercent();
    }

    @Override
    public void setPercent(BigDecimal value) {
        this.taxCategory.setPercent(value);
    }

    @Override
    public MeasureModel getBaseUnitMeasure() {
        return new MeasureAdapter(session, em, taxCategory.getBaseUnitMeasure());
    }

    @Override
    public void setBaseUnitMeasure(MeasureModel value) {
        this.taxCategory.setBaseUnitMeasure(MeasureAdapter.toEntity(value, em));
    }

    @Override
    public BigDecimal getPerUnitAmount() {
        return this.taxCategory.getPerUnitAmount();
    }

    @Override
    public void setPerUnitAmount(BigDecimal value) {
        this.taxCategory.setPerUnitAmount(value);
    }

    @Override
    public String getTaxExemptionReasonCode() {
        return this.taxCategory.getTaxExemptionReasonCode();
    }

    @Override
    public void setTaxExemptionReasonCode(String value) {
        this.taxCategory.setTaxExemptionReasonCode(value);
    }

    @Override
    public String getTaxExemptionReason() {
        return this.taxCategory.getTaxExemptionReason();
    }

    @Override
    public void setTaxExemptionReason(String value) {
        this.taxCategory.setTaxExemptionReason(value);
    }

    @Override
    public String getTierRange() {
        return this.taxCategory.getTierRange();
    }

    @Override
    public void setTierRange(String value) {
        this.taxCategory.setTierRange(value);
    }

    @Override
    public BigDecimal getTierRatePercent() {
        return this.taxCategory.getTierRatePercent();
    }

    @Override
    public void setTierRatePercent(BigDecimal value) {
        this.taxCategory.setTierRatePercent(value);
    }

    @Override
    public TaxSchemeModel getTaxScheme() {
        return new TaxSchemeAdapter(session, em, taxCategory.getTaxScheme());

    }

    @Override
    public void setTaxScheme(TaxSchemeModel value) {
        this.taxCategory.setTaxScheme(TaxSchemeAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return this.taxCategory.getId();
    }

    public static TaxCategoryEntity toEntity(TaxCategoryModel model, EntityManager em) {
        if (model instanceof TaxCategoryAdapter) {
            return ((TaxCategoryAdapter) model).getEntity();
        }
        return em.getReference(TaxCategoryEntity.class, model.getId());
    }

    @Override
    public TaxCategoryEntity getEntity() {

        return taxCategory;
    }

}
