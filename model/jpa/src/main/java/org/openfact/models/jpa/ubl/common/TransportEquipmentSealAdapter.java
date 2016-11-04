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
import org.openfact.models.jpa.entities.ubl.common.TransportEquipmentSealEntity;
import org.openfact.models.ubl.common.TransportEquipmentSealModel;

public class TransportEquipmentSealAdapter
		implements TransportEquipmentSealModel, JpaModel<TransportEquipmentSealEntity> {
	protected static final Logger logger = Logger.getLogger(TransportEquipmentSealAdapter.class);

	protected TransportEquipmentSealEntity transportEquipmentSeal;
	protected EntityManager em;
	protected OpenfactSession session;

	public TransportEquipmentSealAdapter(OpenfactSession session, EntityManager em,
			TransportEquipmentSealEntity transportEquipmentSeal) {
		this.session = session;
		this.em = em;
		this.transportEquipmentSeal = transportEquipmentSeal;
	}

	@Override
	public TransportEquipmentSealEntity getEntity() {
		return transportEquipmentSeal;
	}

	@Override
	public String getID() {
		return transportEquipmentSeal.getID();
	}

	@Override
	public void setID(String value) {
		transportEquipmentSeal.setID(value);
	}

	@Override
	public String getSealIssuerTypeCode() {
		return transportEquipmentSeal.getSealIssuerTypeCode();
	}

	@Override
	public void setSealIssuerTypeCode(String value) {
		transportEquipmentSeal.setSealIssuerTypeCode(value);
	}

	@Override
	public String getCondition() {
		return transportEquipmentSeal.getCondition();
	}

	@Override
	public void setCondition(String value) {
		transportEquipmentSeal.setCondition(value);
	}

	@Override
	public String getSealStatusCode() {
		return transportEquipmentSeal.getSealStatusCode();
	}

	@Override
	public void setSealStatusCode(String value) {
		transportEquipmentSeal.setSealStatusCode(value);
	}

	@Override
	public String getSealingPartyType() {
		return transportEquipmentSeal.getSealingPartyType();
	}

	@Override
	public void setSealingPartyType(String value) {
		transportEquipmentSeal.setSealingPartyType(value);
	}

	@Override
	public String getId() {
		return getId();
	}

	public static TransportEquipmentSealEntity toEntity(TransportEquipmentSealModel model, EntityManager em) {
		if (model instanceof TransportEquipmentSealAdapter) {
			return ((TransportEquipmentSealAdapter) model).getEntity();
		}
		return em.getReference(TransportEquipmentSealEntity.class, model.getId());
	}

}
