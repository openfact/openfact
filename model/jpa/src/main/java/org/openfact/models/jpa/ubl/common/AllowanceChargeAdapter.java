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
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.AllowanceChargeEntity;
import org.openfact.models.jpa.entities.ubl.common.PaymentMeansEntity;
import org.openfact.models.jpa.entities.ubl.common.TaxCategoryEntity;
import org.openfact.models.ubl.common.AllowanceChargeModel;
import org.openfact.models.ubl.common.PaymentMeansModel;
import org.openfact.models.ubl.common.TaxCategoryModel;
import org.openfact.models.ubl.common.TaxTotalModel;

public class AllowanceChargeAdapter implements AllowanceChargeModel, JpaModel<AllowanceChargeEntity> {

    protected static final Logger logger = Logger.getLogger(AllowanceChargeAdapter.class);
    protected AllowanceChargeEntity allowanceCharge;
    protected EntityManager em;
    protected OpenfactSession session;

    public AllowanceChargeAdapter(OpenfactSession session, EntityManager em,
            AllowanceChargeEntity allowanceCharge) {
        this.session = session;
        this.em = em;
        this.allowanceCharge = allowanceCharge;
    }

    @Override
    public String getID() {
        return allowanceCharge.getID();
    }

    @Override
    public void setID(String value) {
        allowanceCharge.setID(value);
    }

    @Override
    public boolean getChargeIndicator() {
        return allowanceCharge.isChargeIndicator();
    }

    @Override
    public void setChargeIndicator(boolean value) {
        allowanceCharge.setChargeIndicator(value);
    }

    @Override
    public String getAllowanceChargeReasonCode() {
        return allowanceCharge.getAllowanceChargeReasonCode();
    }

    @Override
    public void setAllowanceChargeReasonCode(String value) {
        allowanceCharge.setAllowanceChargeReasonCode(value);
    }

    @Override
    public String getAllowanceChargeReason() {
        return allowanceCharge.getAllowanceChargeReason();
    }

    @Override
    public void setAllowanceChargeReason(String value) {
        allowanceCharge.setAllowanceChargeReason(value);
    }

    @Override
    public BigDecimal getMultiplierFactorNumeric() {
        return allowanceCharge.getMultiplierFactorNumeric();
    }

    @Override
    public void setMultiplierFactorNumeric(BigDecimal value) {
        allowanceCharge.setMultiplierFactorNumeric(value);
    }

    @Override
    public boolean getPrepaidIndicator() {
        return allowanceCharge.isPrepaidIndicator();
    }

    @Override
    public void setPrepaidIndicator(boolean value) {
        allowanceCharge.setPrepaidIndicator(value);
    }

    @Override
    public BigDecimal getSequenceNumeric() {
        return allowanceCharge.getSequenceNumeric();
    }

    @Override
    public void setSequenceNumeric(BigDecimal value) {
        allowanceCharge.setSequenceNumeric(value);
    }

    @Override
    public BigDecimal getAmount() {
        return allowanceCharge.getAmount();
    }

    @Override
    public void setAmount(BigDecimal value) {
        allowanceCharge.setAmount(value);
    }

    @Override
    public BigDecimal getBaseAmount() {
        return allowanceCharge.getBaseAmount();
    }

    @Override
    public void setBaseAmount(BigDecimal value) {
        allowanceCharge.setBaseAmount(value);
    }

    @Override
    public String getAccountingCostCode() {
        return allowanceCharge.getAccountingCostCode();
    }

    @Override
    public void setAccountingCostCode(String value) {
        allowanceCharge.setAccountingCostCode(value);
    }

    @Override
    public String getAccountingCost() {
        return allowanceCharge.getAccountingCost();
    }

    @Override
    public void setAccountingCost(String value) {
        allowanceCharge.setAccountingCost(value);
    }

    @Override
    public List<TaxCategoryModel> getTaxCategory() {
        return allowanceCharge.getTaxCategory().stream().map(f -> new TaxCategoryAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public void setTaxCategory(List<TaxCategoryModel> taxCategory) {
        List<TaxCategoryEntity> entities = taxCategory.stream().map(f -> TaxCategoryAdapter.toEntity(f, em))
                .collect(Collectors.toList());
        allowanceCharge.setTaxCategory(entities);
    }

    @Override
    public TaxTotalModel getTaxTotal() {
        return new TaxTotalAdapter(session, em, allowanceCharge.getTaxTotal());
    }

    @Override
    public void setTaxTotal(TaxTotalModel value) {
        allowanceCharge.setTaxTotal(TaxTotalAdapter.toEntity(value, em));
    }

    @Override
    public List<PaymentMeansModel> getPaymentMeans() {
        return allowanceCharge.getPaymentMeans().stream().map(f -> new PaymentMeansAdapter(session, em, f))
                .collect(Collectors.toList());
    }

    @Override
    public void setPaymentMeans(List<PaymentMeansModel> paymentMeans) {
        List<PaymentMeansEntity> entities = paymentMeans.stream()
                .map(f -> PaymentMeansAdapter.toEntity(f, em)).collect(Collectors.toList());
        allowanceCharge.setPaymentMeans(entities);
    }

    @Override
    public String getId() {
        return allowanceCharge.getId();
    }

    @Override
    public AllowanceChargeEntity getEntity() {
        return allowanceCharge;
    }

    public static AllowanceChargeEntity toEntity(AllowanceChargeModel model, EntityManager em) {
        if (model instanceof AllowanceChargeAdapter) {
            return ((AllowanceChargeAdapter) model).getEntity();
        }
        return em.getReference(AllowanceChargeEntity.class, model.getId());
    }
}
