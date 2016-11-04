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
import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.ExchangeRateEntity;
import org.openfact.models.ubl.common.ContractModel;
import org.openfact.models.ubl.common.ExchangeRateModel;

public class ExchangeRateAdapter implements ExchangeRateModel, JpaModel<ExchangeRateEntity> {

    protected static final Logger logger = Logger.getLogger(ExchangeRateAdapter.class);
    protected ExchangeRateEntity exchangeRate;
    protected EntityManager em;
    protected OpenfactSession session;

    public ExchangeRateAdapter(OpenfactSession session, EntityManager em, ExchangeRateEntity exchangeRate) {
        this.session = session;
        this.em = em;
        this.exchangeRate = exchangeRate;
    }

    @Override
    public String getSourceCurrencyCode() {
        return this.exchangeRate.getSourceCurrencyCode();
    }

    @Override
    public void setSourceCurrencyCode(String value) {
        this.exchangeRate.setSourceCurrencyCode(value);
    }

    @Override
    public BigDecimal getSourceCurrencyBaseRate() {
        return this.exchangeRate.getSourceCurrencyBaseRate();
    }

    @Override
    public void setSourceCurrencyBaseRate(BigDecimal value) {
        this.exchangeRate.setSourceCurrencyBaseRate(value);
    }

    @Override
    public String getTargetCurrencyCode() {
        return this.exchangeRate.getTargetCurrencyCode();
    }

    @Override
    public void setTargetCurrencyCode(String value) {
        this.exchangeRate.setTargetCurrencyCode(value);
    }

    @Override
    public BigDecimal getTargetCurrencyBaseRate() {
        return this.exchangeRate.getTargetCurrencyBaseRate();
    }

    @Override
    public void setTargetCurrencyBaseRate(BigDecimal value) {
        this.exchangeRate.setTargetCurrencyBaseRate(value);
    }

    @Override
    public String getExchangeMarketID() {
        return this.exchangeRate.getExchangeMarketID();
    }

    @Override
    public void setExchangeMarketID(String value) {
        this.exchangeRate.setExchangeMarketID(value);
    }

    @Override
    public BigDecimal getCalculationRate() {
        return this.exchangeRate.getCalculationRate();
    }

    @Override
    public void setCalculationRate(BigDecimal value) {
        this.exchangeRate.setCalculationRate(value);
    }

    @Override
    public String getMathematicOperatorCode() {
        return this.exchangeRate.getMathematicOperatorCode();
    }

    @Override
    public void setMathematicOperatorCode(String value) {
        this.exchangeRate.setMathematicOperatorCode(value);
    }

    @Override
    public LocalDate getDate() {
        return this.exchangeRate.getDate();
    }

    @Override
    public void setDate(LocalDate value) {
        this.exchangeRate.setDate(value);
    }

    @Override
    public ContractModel getForeignExchangeContract() {
        return new ContractAdapter(session, em, exchangeRate.getForeignExchangeContract());
    }

    @Override
    public void setForeignExchangeContract(ContractModel value) {
        this.exchangeRate.setForeignExchangeContract(ContractAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return this.exchangeRate.getId();
    }

    @Override
    public ExchangeRateEntity getEntity() {
        return exchangeRate;
    }

    public static ExchangeRateEntity toEntity(ExchangeRateModel model, EntityManager em) {
        if (model instanceof ExchangeRateAdapter) {
            return ((ExchangeRateAdapter) model).getEntity();
        }
        return em.getReference(ExchangeRateEntity.class, model.getId());
    }

}
