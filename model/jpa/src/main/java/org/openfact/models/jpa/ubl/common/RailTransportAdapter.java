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
import org.openfact.models.jpa.entities.ubl.common.RailTransportEntity;
import org.openfact.models.ubl.common.RailTransportModel;

public class RailTransportAdapter implements RailTransportModel, JpaModel<RailTransportEntity> {

	protected static final Logger logger = Logger.getLogger(RailTransportAdapter.class);
	protected RailTransportEntity railTransport;
	protected EntityManager em;
	protected OpenfactSession session;

	public RailTransportAdapter(OpenfactSession session, EntityManager em, RailTransportEntity railTransport) {
		this.session = session;
		this.em = em;
		this.railTransport = railTransport;
	}

	@Override
	public RailTransportEntity getEntity() {
		return railTransport;
	}

	@Override
	public String getTrainID() {
		return railTransport.getTrainID();
	}

	@Override
	public void setTrainID(String value) {
		railTransport.setTrainID(value);
	}

	@Override
	public String getRailCarID() {
		return railTransport.getRailCarID();
	}

	@Override
	public void setRailCarID(String value) {
		railTransport.setRailCarID(value);
	}

	@Override
	public String getId() {
		return railTransport.getId();
	}

	public static RailTransportEntity toEntity(RailTransportModel model, EntityManager em) {
		if (model instanceof RailTransportAdapter) {
			return ((RailTransportAdapter) model).getEntity();
		}
		return em.getReference(RailTransportEntity.class, model.getId());
	}
}
