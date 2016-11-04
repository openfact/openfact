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
package org.openfact.models.jpa.ubl.common.pe;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.pe.RetentionInformationEntity;
import org.openfact.models.jpa.ubl.common.ExchangeRateAdapter;
import org.openfact.models.ubl.common.ExchangeRateModel;
import org.openfact.models.ubl.common.pe.RetentionInformationModel;

public class RetentionInformationAdapter implements RetentionInformationModel, JpaModel<RetentionInformationEntity> {

	protected static final Logger logger = Logger.getLogger(RetentionInformationAdapter.class);

	protected RetentionInformationEntity retentionInformation;
	protected EntityManager em;
	protected OpenfactSession session;

	public RetentionInformationAdapter(OpenfactSession session, EntityManager em,
			RetentionInformationEntity retentionInformation) {
		this.session = session;
		this.em = em;
		this.retentionInformation = retentionInformation;
	}

	@Override
	public RetentionInformationEntity getEntity() {
		return retentionInformation;
	}

	@Override
	public String getId() {
		return retentionInformation.getId();
	}

	@Override
	public BigDecimal getSunatRetentionAmount() {
		return retentionInformation.getSunatRetentionAmount();
	}

	@Override
	public void setSunatRetentionAmount(BigDecimal sunatRetentionAmount) {
		retentionInformation.setSunatRetentionAmount(sunatRetentionAmount);
	}

	@Override
	public LocalDateTime getSunatRetentionDate() {
		return retentionInformation.getSunatRetentionDate();
	}

	@Override
	public void setSunatRetentionDate(LocalDateTime sunatRetentionDate) {
		retentionInformation.setSunatRetentionDate(sunatRetentionDate);
	}

	@Override
	public BigDecimal getSunatNetTotalPaid() {
		return retentionInformation.getSunatNetTotalPaid();
	}

	@Override
	public void setSunatNetTotalPaid(BigDecimal sunatNetTotalPaid) {
		retentionInformation.setSunatNetTotalPaid(sunatNetTotalPaid);
	}

	@Override
	public ExchangeRateModel getExchangeRate() {
		return new ExchangeRateAdapter(session, em, retentionInformation.getExchangeRate());
	}

	@Override
	public void setExchangeRate(ExchangeRateModel exchangeRate) {
		retentionInformation.setExchangeRate(ExchangeRateAdapter.toEntity(exchangeRate, em));
	}

	public static RetentionInformationEntity toEntity(RetentionInformationModel model, EntityManager em) {
		if (model instanceof RetentionInformationAdapter) {
			return ((RetentionInformationAdapter) model).getEntity();
		}
		return em.getReference(RetentionInformationEntity.class, model.getId());
	}
}
