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

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.TransportationServiceEntity;
import org.openfact.models.ubl.common.TransportationServiceModel;

public class TransportationServiceAdapter implements TransportationServiceModel, JpaModel<TransportationServiceEntity> {
	protected static final Logger logger = Logger.getLogger(TransportationServiceAdapter.class);

	protected TransportationServiceEntity transportationService;
	protected EntityManager em;
	protected OpenfactSession session;

	public TransportationServiceAdapter(OpenfactSession session, EntityManager em,
			TransportationServiceEntity transportationService) {
		this.session = session;
		this.em = em;
		this.transportationService = transportationService;
	}

	@Override
	public TransportationServiceEntity getEntity() {
		return transportationService;
	}

	@Override
	public String getTransportServiceCode() {
		return transportationService.getTransportServiceCode();
	}

	@Override
	public void setTransportServiceCode(String value) {
		transportationService.setTransportServiceCode(value);
	}

	@Override
	public String getTariffClassCode() {
		return transportationService.getTariffClassCode();
	}

	@Override
	public void setTariffClassCode(String value) {
		transportationService.setTariffClassCode(value);
	}

	@Override
	public String getPriority() {
		return transportationService.getPriority();
	}

	@Override
	public void setPriority(String value) {
		transportationService.setPriority(value);
	}

	@Override
	public String getFreightRateClassCode() {
		return transportationService.getFreightRateClassCode();
	}

	@Override
	public void setFreightRateClassCode(String value) {
		transportationService.setFreightRateClassCode(value);

	}

	@Override
	public String getId() {
		return transportationService.getId();
	}

	public static TransportationServiceEntity toEntity(TransportationServiceModel model, EntityManager em) {
		if (model instanceof TransportationServiceAdapter) {
			return ((TransportationServiceAdapter) model).getEntity();
		}
		return em.getReference(TransportationServiceEntity.class, model.getId());
	}

}
