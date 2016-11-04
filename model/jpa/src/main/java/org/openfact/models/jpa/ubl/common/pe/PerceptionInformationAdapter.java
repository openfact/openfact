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
import org.openfact.models.jpa.entities.ubl.common.pe.PerceptionInformationEntity;
import org.openfact.models.jpa.ubl.common.ExchangeRateAdapter;
import org.openfact.models.ubl.common.ExchangeRateModel;
import org.openfact.models.ubl.common.pe.PerceptionInformationModel;

public class PerceptionInformationAdapter implements PerceptionInformationModel, JpaModel<PerceptionInformationEntity> {

	protected static final Logger logger = Logger.getLogger(PerceptionInformationAdapter.class);

	protected PerceptionInformationEntity perceptionInformation;
	protected EntityManager em;
	protected OpenfactSession session;

	public PerceptionInformationAdapter(OpenfactSession session, EntityManager em,
			PerceptionInformationEntity perceptionInformation) {
		this.session = session;
		this.em = em;
		this.perceptionInformation = perceptionInformation;
	}

	@Override
	public PerceptionInformationEntity getEntity() {
		return perceptionInformation;
	}

	@Override
	public String getId() {
		return perceptionInformation.getId();
	}

	@Override
	public BigDecimal getSunatPerceptionAmount() {
		return perceptionInformation.getSunatPerceptionAmount();
	}

	@Override
	public void setSunatPerceptionAmount(BigDecimal sunatPerceptionAmount) {
		perceptionInformation.setSunatPerceptionAmount(sunatPerceptionAmount);
	}

	@Override
	public LocalDateTime getSunatPerceptionDate() {
		return perceptionInformation.getSunatPerceptionDate();
	}

	@Override
	public void setSunatPerceptionDate(LocalDateTime sunatPerceptionDate) {
		perceptionInformation.setSunatPerceptionDate(sunatPerceptionDate);
	}

	@Override
	public BigDecimal getSunatNetTotalPaid() {
		return perceptionInformation.getSunatNetTotalPaid();
	}

	@Override
	public void setSunatNetTotalPaid(BigDecimal sunatNetTotalPaid) {
		perceptionInformation.setSunatNetTotalPaid(sunatNetTotalPaid);
	}

	@Override
	public ExchangeRateModel getExchangeRate() {
		return new ExchangeRateAdapter(session, em, perceptionInformation.getExchangeRate());
	}

	@Override
	public void setExchangeRate(ExchangeRateModel exchangeRate) {
		perceptionInformation.setExchangeRate(ExchangeRateAdapter.toEntity(exchangeRate, em));
	}

	public static PerceptionInformationEntity toEntity(PerceptionInformationModel model, EntityManager em) {
		if (model instanceof PerceptionInformationAdapter) {
			return ((PerceptionInformationAdapter) model).getEntity();
		}
		return em.getReference(PerceptionInformationEntity.class, model.getId());
	}

}
