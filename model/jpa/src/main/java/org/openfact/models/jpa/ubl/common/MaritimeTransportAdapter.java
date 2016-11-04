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
import org.openfact.models.jpa.entities.ubl.common.MaritimeTransportEntity;
import org.openfact.models.ubl.common.MaritimeTransportModel;

public class MaritimeTransportAdapter implements MaritimeTransportModel, JpaModel<MaritimeTransportEntity> {

	protected static final Logger logger = Logger.getLogger(MaritimeTransportAdapter.class);
	protected MaritimeTransportEntity maritimeTransport;
	protected EntityManager em;
	protected OpenfactSession session;

	public MaritimeTransportAdapter(OpenfactSession session, EntityManager em,
			MaritimeTransportEntity maritimeTransport) {
		this.session = session;
		this.em = em;
		this.maritimeTransport = maritimeTransport;
	}

	@Override
	public MaritimeTransportEntity getEntity() {
		return maritimeTransport;
	}

	@Override
	public String getId() {
		return maritimeTransport.getId();
	}

	@Override
	public String getVesselID() {
		return maritimeTransport.getVesselID();
	}

	@Override
	public void setVesselID(String vesselID) {
		maritimeTransport.setVesselID(vesselID);
	}

	@Override
	public String getVesselName() {
		return maritimeTransport.getVesselName();
	}

	@Override
	public void setVesselName(String vesselName) {
		maritimeTransport.setVesselName(vesselName);
	}

	public static MaritimeTransportEntity toEntity(MaritimeTransportModel model, EntityManager em) {
		if (model instanceof MaritimeTransportAdapter) {
			return ((MaritimeTransportAdapter) model).getEntity();
		}
		return em.getReference(MaritimeTransportEntity.class, model.getId());
	}

}
